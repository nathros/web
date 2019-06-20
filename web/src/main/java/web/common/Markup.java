package web.common;

import web.pages.resources.Resource;

public class Markup {
	public StringBuffer p = new StringBuffer(1024 * 4);

	public Markup() {
		ln("<!DOCTYPE html>");
	}

	public void addNavbar() {
		ln("<div class=\"navbar\">");
		ln("	<a href=\"#home\">Home</a>");
		ln("	<a href=\"#news\">News</a>");
		ln("	<div class=\"navbar-dropdown\">");
		ln("		<button class=\"dropbtn\">Dropdown</button>");
		ln("		<div class=\"navbar-dropdown-content\">");
		ln("			<a href=\"#\">Link 1</a>");
		ln("			<a href=\"#\">Link 2</a>");
		ln("			<a href=\"#\">Link 3</a>");
		ln("		</div>");
		ln("	</div>");
		ln("</div>");
	}

	public void ln(String line) {
		p.append(line + "\n");
	}

	public void startDiv(String className) {
		if (null == className)
			ln("<div>");
		else
			ln("<div class=\"".concat(className).concat("\">"));
	}

	public void endDiv() {
		ln("</div>");
	}

	public void addHead(String... css) {
		ln("<head>");
		ln("<link rel=\"icon\" type=\"image/png\" href=\"https://i.imgur.com/1BUcNs0.png\">");

		for (String i : css) {
			ln("<style> /* ".concat(i).concat(" */"));
			ln(Resource.readResource(i));
			ln("</style>");
		}

		ln("<script type=\"text/javascript\">");
		ln(Resource.readResource(Resource.JS_SNAKE_HOOK));
		ln("</script>");

		ln("</head>");
	}

	public void addCSS() {
		ln("<style>");
		ln(Resource.readResource(Resource.CSS_COMMON));
		ln("</style>");
	}
}
