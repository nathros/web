package web.common;

import java.util.LinkedHashMap;
import java.util.Map;

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

	public void addPageSelector(LinkedHashMap<String, String> items, int selectedIndex) {
		ln("<form method=\"get\" action=javascript:action>");
		ln("	<label for=\"page-select\"><strong>Page:</strong></label>");
		ln("	<select id=\"page-select\" onChange=\"self.location=this.options[this.selectedIndex].value;\">");
		if (items != null) {
			for (Map.Entry<String, String> entry : items.entrySet()) {
				selectedIndex--;
				String key = entry.getKey();
				String value = entry.getValue();
				if (0 == selectedIndex) {
					ln("		<option selected value=\"".concat(value).concat("\">").concat(key).concat("</option>"));
				} else {
					ln("		<option value=\"".concat(value).concat("\">").concat(key).concat("</option>"));
				}
			}

		}
		ln("	</select>"); // select
		ln("</form>"); // form
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
