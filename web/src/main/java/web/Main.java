package web;


public class Main {

	public static void main(String[] args) {
		/*Vertx vertx = Vertx.vertx();
		HttpServer server = vertx.createHttpServer();
		Router router = Router.router(vertx);
		/*router.route().handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			  response.putHeader("content-type", "text/plain");

			  // Write to the response and end it
			  response.end("Hello World from Vert.x-Web!");
		});
		
		
		Route route = router.route("/some/path/");		
		route.handler(routingContext -> {

		  HttpServerResponse response = routingContext.response();
		  // enable chunked responses because we will be adding data as
		  // we execute over other handlers. This is only required once and
		  // only if several handlers do output.
		  response.setChunked(true);

		  response.write("route1\n");

		  // Call the next matching route after a 5 second delay
		  routingContext.vertx().setTimer(0, tid -> routingContext.next());
		});

		route.handler(routingContext -> {

		  HttpServerResponse response = routingContext.response();
		  response.write("route2\n");

		  // Call the next matching route after a 5 second delay
		  routingContext.vertx().setTimer(0, tid -> routingContext.next());
		});

		route.handler(routingContext -> {

		  HttpServerResponse response = routingContext.response();
		  response.write("route3");

		  // Now end the response
		  routingContext.response().end();
		});
		
		server.requestHandler(router).listen(8081);
		System.out.println("svs");*/
	}

}
