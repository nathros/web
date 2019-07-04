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
		ln("	<a href=\"sandpit\">Sandpit</a>");
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

	public void addCard(String content) {
		ln("<div class=\"card\">");
		ln(content);
		ln("</div>");
	}

	public void ln(String line) {
		p.append(line + "\n");
	}

	public void addHead(String[] cssImport, String[] jsImport, String title) {
		ln("<head>");
		if (null == title)
			title = "";
		ln("<title>".concat(title).concat("</title>"));
		ln("<link rel=\"icon\" type=\"image/png\" href=\"".concat(Resource.IMG_FAVICO).concat("\">"));

		if (cssImport != null) {
			ln("<style>");
			for (String i : cssImport) {
				ln("/* ".concat(i).concat(" */"));
				ln(Resource.readResource(i));
			}
			ln("</style>");
		}

		if (jsImport != null) {
			ln("<script>");
			for (String i : jsImport) {
				ln("/* ".concat(i).concat(" */"));
				ln(Resource.readResource(i));
			}
			ln("</script>");
		}
		ln("</head>");
	}

	public void addCSS() {
		ln("<style>");
		ln(Resource.readResource(Resource.CSS_COMMON));
		ln("</style>");
	}
}
