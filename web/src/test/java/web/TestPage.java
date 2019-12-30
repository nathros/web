package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
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
			String request = in.readLine();
			System.out.println("Client request: " + request);
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println("HTTP/1.0 200");
			out.println("Content-type: text/html");
			out.println("Server-name: server");

			// ==============================================================//
			long startTime = System.currentTimeMillis();
			Lambda ret = new Lambda();
			String response = "NULL missing startup param";
			if (args.length > 1) {
				if ("fixed".equals(args[1]))
					response = ret.handleRequest(RequestFactory.getStandard2Param());
				else if ("dynamic".equals(args[1]))
					response = ret.handleRequest(RequestFactory.getRequestParam(request));
			}
			// ==============================================================//

			out.println("Content-length: " + response.length());
			out.println("");
			out.println(response);
			out.flush();
			out.close();
			socket.close();

			System.out.println("Server response time: " + (System.currentTimeMillis() - startTime) + "ms");
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
