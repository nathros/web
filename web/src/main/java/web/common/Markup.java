package web.common;

import static j2html.TagCreator.*;

import java.util.List;

public class Markup {
	public StringBuffer page = new StringBuffer();

	public void addHeader(List<String> styles) {

		//
		page.append("<!DOCTYPE html>\n");
		page.append(head(style()));

		/*
		 * page.append( body( h1("Hello, World!"), img().withSrc("/img/hello.png")
		 * ).renderFormatted());
		 */
	}
}
