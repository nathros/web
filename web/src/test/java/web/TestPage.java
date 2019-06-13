package web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetSocketAddress;

import org.json.JSONObject;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

public class TestPage {

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
		HttpContext context = server.createContext("/");
		context.setHandler(TestPage::handleRequest);
		server.start();
		System.out.println("Test server live");
	}

	private static void handleRequest(HttpExchange exchange) throws IOException {
		Lambda ret = new Lambda();
		String response = ret.handleRequest(TestPage.requestToJSON(exchange));

		exchange.sendResponseHeaders(200, response.getBytes().length);
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

	private static String requestToJSON(HttpExchange exchange) {
		JSONObject json = new JSONObject();
		json.put("method", exchange.getRequestMethod());
		json.put("headers", exchange.getRequestHeaders().toString());

		// handle query to JSON format
		String[] split = exchange.getRequestURI().getQuery().split("&");
		StringBuilder query = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			if ((i + 1) == split.length)
				query.append(split[i]);
			else
				query.append(split[i] + ", ");
		}
		json.put("query", query.toString());

		return json.toString();
	}

}
