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
		ln("			<a href=\"https://github.com/nathros\" target=\"_blank\">Github");
		ln("				<svg style=\"float:right;margin-top:-0.5rem\" height=\"32\" viewBox=\"0 0 16 16\" width=\"32\">");
		ln("  					<sodipodi:namedview />");
		ln("  						<path style=\"fill:var(--navbar-font-idle-colour);fill-rule:evenodd\" d=\"M 8.0132232,15.927273 C 6.6542001,15.9351 5.4723743,15.809286 5.47,15.59 5.87,15.66 6.02,15.42 6.02,15.21 6.02,15.02 6.01,14.39 6.01,13.72 4,14.09 3.48,13.23 3.32,12.78 3.23,12.55 2.84,11.84 2.5,11.65 2.22,11.5 1.82,11.13 2.49,11.12 3.12,11.11 3.57,11.7 3.72,11.94 4.44,13.15 5.59,12.81 6.05,12.6 6.12,12.08 6.33,11.73 6.56,11.53 4.78,11.33 2.92,10.64 2.92,7.58 2.92,6.71 3.23,5.99 3.74,5.43 3.66,5.23 3.38,4.41 3.82,3.31 c 0,0 0.67,-0.21 2.2,0.82 0.64,-0.18 1.32,-0.27 2,-0.27 0.68,0 1.36,0.09 2,0.27 1.53,-1.04 2.2,-0.82 2.2,-0.82 0.44,1.1 0.16,1.92 0.08,2.12 0.51,0.56 0.82,1.27 0.82,2.15 0,3.07 -1.87,3.75 -3.65,3.95 0.29,0.25 0.54,0.73 0.54,1.48 0,1.07 -0.01,1.93 -0.01,2.2 0,0.21 0.15,0.46 0.55,0.38 -0.0033,0.262984 -0.913269,0.32712 -2.5367768,0.337273 z\" />");
		ln("				</svg>");
		ln("			</a>");
		ln("		</div>"); // navbar-dropdown-content
		ln("	</div>"); // navbar-dropdown

		if (NavbarItem.CV == item) {
			ln("	<a class=\"navbar-selected\" href=\"".concat(PageMapping.CV_PG).concat("\">CV</a>"));
		} else {
			ln("	<a href=\"".concat(PageMapping.CV_PG).concat("\">CV</a>"));
		}

		if (NavbarItem.Contact == item) {
			ln("	<a class=\"navbar-selected\" href=\"".concat(PageMapping.CONTACT_PG).concat("\">Contact</a>"));
		} else {
			ln("	<a href=\"".concat(PageMapping.CONTACT_PG).concat("\">Contact</a>"));
		}

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
		ln("	<div><p>".concat(title).concat("</p></div>"));
		ln("</div>"); // title-banner
	}

	int modalCount = 0;

	public void addModalImage(String thumbnailURL, String imageURL, String thumbnailStyle) { // TODO @media for mobile,
																								// alt text
		ln("<div class=\"modal-container\" style=\"" + thumbnailStyle + "\">");
		ln("	<a href=\"#img" + modalCount + "\">");
		ln("		<img class=\"modal-thumbnail\" src=\"" + thumbnailURL + "\" style=\"" + thumbnailStyle
				+ "\" alt=\"\">");
		ln("	</a>"); // #img1
		ln("</div>"); // modal-container

		ln("<a href=\"javascript: history.go(-1)\" class=\"modal-image\" id=\"img" + modalCount + "\">");
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
