package web.common;

import web.pages.resources.Resource;

public class Markup {
	public StringBuffer p = new StringBuffer(1024 * 4);

	public Markup() {
		ln("<!DOCTYPE html>");
	}

	public void ln(String line) {
		p.append(line + "\n");
	}

	public void addHeader() {
		ln("<head>");
		ln("<link rel=\"icon\" type=\"image/png\" href=\"https://img.icons8.com/cute-clipart/64/000000/sun.png\">");

		ln("<div class=\"navbar\">");

		ln("</head>");
	}

	public void addCSS() {
		ln("<style>");
		ln(Resource.readResource(Resource.CSS));
		ln("</style>");
	}
}
