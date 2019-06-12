package web.utils;

import static j2html.TagCreator.*;

public class Markup {
	public static StringBuffer page = new StringBuffer();
	
	public static void addHeader() {
		page.append("<!DOCTYPE html>\n");
		page.append(
				body(
	            h1("Hello, World!"),
	            img().withSrc("/img/hello.png")
	        ).renderFormatted());
	}
}
