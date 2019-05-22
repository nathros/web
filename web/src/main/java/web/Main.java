package web;

import static j2html.TagCreator.form;

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
		  
		
		
		  form();

		  /*
		  TagCreator.iff(boolean condition, T ifValue) // If-expression for use in method calls
		  div().withClasses("menu-element", iff(isActive, "active"))


		  TagCreator.iffElse(boolean condition, T ifValue, T elseValue) // If/else-expression for use in method calls
		  div().withClasses("menu-element", iffElse(isActive, "active", "not-active"))


		  Tag.class // Is extended by ContainerTag (ex <div></div> and EmptyTag (ex <br>)
		  Tag.attr(String attribute, Object value) // Set an attribute on the tag
		  Tag.withXyz(String value) // Calls attr with predefined attribute (ex .withId, .withClass, etc.)*/
		  
		  response.end("dd");
		});

		server.listen(8081);

	}

}
