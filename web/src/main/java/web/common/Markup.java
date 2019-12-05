package web.common;

import java.util.LinkedHashMap;
import java.util.Map;

import web.pages.PageMapping;
import web.pages.resources.Resource;

public class Markup {
	public StringBuffer p = new StringBuffer(1024 * 4);

	public Markup() {
		ln("<!DOCTYPE html>");
	}

	public void addNavbar(NavbarItem item) {
		ln("<div class=\"navbar\">");

		if (NavbarItem.Home == item) {
			ln("	<a class=\"navbar-selected\" href=\"".concat(PageMapping.HOME_PG).concat("\">Home</a>"));
		} else {
			ln("	<a href=\"".concat(PageMapping.HOME_PG).concat("\">Home</a>"));
		}

		// ln(" <a href=\"sandpit\">Sandpit</a>");

		if (NavbarItem.Projects == item) {
			ln("	<div class=\"navbar-dropdown navbar-selected\">");
			ln("		<button class=\"dropbtn navbar-selected\">Projects</button>");
		} else {
			ln("	<div class=\"navbar-dropdown\">");
			ln("		<button class=\"dropbtn\">Projects</button>");
		}
		ln("		<div class=\"navbar-dropdown-content\">");
		ln("			<a href=\"".concat(PageMapping.ROHLOFF_PG0).concat("\">Rohloff Bike</a>"));
		ln("			<a href=\"".concat(PageMapping.FILESERVER1_PG0).concat("\">45TB File Server</a>"));
		ln("			<a href=\"".concat(PageMapping.CONNECT4).concat("\">Connect 4</a>"));
		ln("		</div>"); // navbar-dropdown-content
		ln("	</div>"); // navbar-dropdown
		ln("</div>"); // navbar
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

	int toggleCount = 0;

	public String getContentToggle(String title, String content) {
		LocalStringBuffer buffer = new LocalStringBuffer(512);
		buffer.ln("<div class=\"toggle-container\">");
		buffer.ln("	<label class=\"toggle-label\" for=\"toggle-item-" + toggleCount
				+ "\">".concat(title).concat("</label>"));
		buffer.ln("	<input class=\"toggle-input\" checked type=\"checkbox\" id=\"toggle-item-" + toggleCount + "\">");
		buffer.ln("	<div class=\"toggle-content\">");
		buffer.ln(content);
		buffer.ln("	</div>"); // toggle-content
		buffer.ln("	<i class=\"toggle-arrow\"></i>");
		buffer.ln("</div>"); // toggle-container
		toggleCount++;
		return buffer.toString();
	}

	public void addToolTip(String visibleContent, String tooltipContent) {
		ln("<div class=\"tooltip\">");
		ln(visibleContent);
		ln("	<div class=\"tooltip-inner\">");
		ln(tooltipContent);
		ln("	</div>"); // tooltip-inner
		ln("</div>"); // tooltip
	}

	public void addBanner(String title, String background) {
		ln("<div class=\"title-banner\" style=\"background-image: url(".concat(background).concat(")\">"));
		ln("	<div>".concat(title).concat("</div>"));
		ln("</div>"); // title-banner
	}

	int modalCount = 0;

	public void addModalImage(String thumbnailURL, String imageURL, String thumbnailStyle) { // TODO @media for mobile
		ln("<div class=\"modal-container\" style=\"" + thumbnailStyle + "\">");
		ln("	<a href=\"#img" + modalCount + "\">");
		ln("		<img class=\"modal-thumbnail\" src=\"" + thumbnailURL + "\" style=\"" + thumbnailStyle
				+ "\" alt=\"\">");
		ln("	</a>"); // #img1
		ln("</div>"); // modal-container

		ln("<a href=\"#\" class=\"modal-image\" id=\"img" + modalCount + "\">");
		ln("	<img src=\"" + imageURL + "\" alt=\"\">");
		ln("</a>"); // modal-image
		modalCount++;
	}

	public void addCard(String content) {
		ln("<div class=\"card\">");
		ln(content);
		ln("</div>");
	}

	public void ln(String line) {
		p.append(line);
		p.append("\n");
	}

	public void l(String line) {
		p.append(line);
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
