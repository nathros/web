package web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

public class ServicePage {

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
	    HttpContext context = server.createContext("/");
	    context.setHandler(ServicePage::handleRequest);
	    server.start();
	}
	
	private static void handleRequest(HttpExchange exchange) throws IOException {
		Lambda ret = new Lambda();
		String response;
		try {
			 response = ret.handleRequest("{}");
		} catch (Exception e) {
			response = e.getMessage();
			
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response += "\n" + sw.toString();
		}
	    
		exchange.sendResponseHeaders(200, response.getBytes().length); 
	    OutputStream os = exchange.getResponseBody();
	    os.write(response.getBytes());
	    os.close();
	}

}
