package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestPage {
	private static final Executor threadPool = Executors.newFixedThreadPool(3);
	public static boolean stopServer = false;

	private static void handleRequest(Socket socket, String[] args) {
		BufferedReader in;
		PrintWriter out;

		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			List<String> headers = new ArrayList<String>();
			String line;
			while (((line = in.readLine()) != null) && (line.length() != 0)) {
				headers.add(line);
				if (Config.printVerboseRequest) {
					System.out.println(line);
				}
			}

			StringBuilder payload = new StringBuilder();
			while (in.ready()) {
				payload.append((char) in.read());
			}
			headers.add(payload.toString());

			System.out.println("Client request: " + headers.get(0) + " Body:" + payload.toString());
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println("HTTP/1.0 200");
			out.println("Content-type: text/html; charset=UTF-8");
			out.println("Cookie: SameSite=Strict");
			out.println("Server-name: server");

			// ============================================================== //
			long startTime = System.currentTimeMillis();
			Lambda ret = new Lambda();
			String response = "NULL missing startup param";
			if (args.length > 0) {
				if ("fixed".equals(args[0])) {
					response = ret.handleRequest(RequestFactory.getPremadeRequestObject());
				} else if ("dynamic".equals(args[0])) {
					response = ret.handleRequest(RequestFactory.generateRequestObject(headers));
				}
			} else {
				System.out.println("Missing start param, assume dynamic");
				response = ret.handleRequest(RequestFactory.generateRequestObject(headers));
			}
			// ============================================================== //

			out.println("Content-length: " + response.length());
			out.println("");
			out.println(response);
			out.flush();
			out.close();
			socket.close();

			System.out.println("Server response time: " + (System.currentTimeMillis() - startTime) + "ms");
			if (Config.printVerboseRequest) {
				System.out.println("==================================");
			}
		} catch (IOException e) {
			System.out.println("Failed respond to client request: " + e.getMessage());
			try {
				socket.close();
			} catch (IOException f) {
				f.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(8081);
		while (!stopServer) {
			final Socket connection = socket.accept();
			Runnable task = new Runnable() {
				@Override
				public void run() {
					handleRequest(connection, args);
				}
			};
			threadPool.execute(task);
		}
		socket.close();
	}

}
