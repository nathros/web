package web;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

public class Main {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		HttpServer server = vertx.createHttpServer();

		server.requestHandler(request -> {
		  HttpServerResponse response = request.response();
		  response.putHeader("content-type", "text/plain");
		  response.end("Hello World!");
		});

		server.listen(8081);

	}

}
