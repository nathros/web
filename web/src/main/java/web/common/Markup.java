package web.common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import web.pages.PageMapping;
import web.pages.resources.Resource;

public class Markup {
	public StringBuilder p = new StringBuilder(1024 * 32);

	public Markup() {
		ln("<!DOCTYPE html>");
	}

	public void addNavbar(NavbarItem item) {
		addFormFullscreenMessage();
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
		ln("			<a href=\"".concat(PageMapping.ROHLOFF_PG1).concat("\">Rohloff Bike</a>"));
		ln("			<a href=\"".concat(PageMapping.ROHLOFF2_PG1).concat("\">Rohloff Bike Upgrade</a>"));
		ln("			<a href=\"".concat(PageMapping.FILESERVER1_PG0).concat("\">45TB File Server</a>"));
		ln("			<a href=\"".concat(PageMapping.CONNECT4).concat("\">Connect 4</a>"));
		ln("			<a href=\"https://github.com/nathros\" target=\"_blank\" rel=\"noreferrer\">Github");
		ln("				<svg style=\"float:right;margin-top:-0.5rem\" height=\"32\" viewBox=\"0 0 16 16\" width=\"32\">");
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

		if (NavbarItem.Admin == item) {
			ln("	<a class=\"navbar-selected\" >Admin</a>");
		} else if (NavbarItem.BadPage == item) {
			ln("	<a class=\"navbar-selected\" >Missing Page</a>");
		}

		ln("	<div class=\"navbar-search\">");
		ln("		<form action=\"/stage/search\" name=\"search-form\" class=\"" + (NavbarItem.Search == item ? "btn-search-form-selected" : "") + "\" onsubmit=\"btnSearchClick(this)\">");
		ln("			<button type=\"button\" class=\"btn-search" + (NavbarItem.Search == item ? " navbar-line btn-search-selected" : "") + "\" onclick=\"btnSearchClick(this)\"></button>");
		ln("			<input id=\"query\" type=\"text\" class=\"input-search\" name=\"" + Forms.INPUT_QUERY + "\" placeholder=\"Type to search...\">");
		ln("		</form>");
		ln("	</div>");

		ln("</div>"); // navbar
	}

	public void addPageSelector(LinkedHashMap<String, String> items, int selectedIndex) {
		ln("<form method=\"get\" action=javascript:action>");
		ln("	<div style=\"display:flex;align-items:center;\">");
		ln("		<label for=\"page-select\"><strong>Page:</strong></label>");
		ln("		<select style=\"flex:1;margin-left:1rem;\" id=\"page-select\" onChange=\"self.location=this.options[this.selectedIndex].value;\">");
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
		ln("		</select>"); // select
		ln("	</div>"); // container
		ln("</form>"); // form
	}

	int toggleCount = 0;

	public String getContentToggle(String title, String content) {
		LocalStringBuffer buffer = new LocalStringBuffer(512);
		buffer.ln("<div class=\"toggle-container\">");
		buffer.ln("	<label class=\"toggle-label\" for=\"toggle-item-" + toggleCount
				+ "\">".concat(title).concat("</label>"));
		buffer.ln("	<input class=\"toggle-input\" checked type=\"checkbox\" id=\"toggle-item-" + toggleCount + "\" onclick=\"toggleContentHeight(this)\">");
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

	public void addBannerHomeAnimated(String background) {
		ln("<div class=\"title-banner-home scanlines\" style=\"background-image: url(".concat(background).concat(")\">"));
		ln("</div>"); // title-banner-home
	}

	public void addBannerAnimated(String title, String background) {
		ln("<div class=\"title-banner scanlines\" style=\"background-image: url(".concat(background).concat(")\">"));
		ln("	<div><p>".concat(title).concat("</p></div>"));
		ln("</div>"); // title-banner-home
	}

	int modalCount = 0;
	
	public String getLittleLogoWithTooltip(String logoClass, String tooltipText) {
		LocalStringBuffer buffer = new LocalStringBuffer(512);
		buffer.ln("<div class=\"" + logoClass + "-logo logo-little logo-tooltip\">");
		buffer.ln("	<div class=\"logo-tooltip-bottom\">");
		buffer.ln("		<p>" + tooltipText + "</p>");
		buffer.ln("		<i></i>");
		buffer.ln("	</div>");
		buffer.ln("</div>");
		return buffer.toString();
	}

	public void addModalImage(String thumbnailURL, String imageURL, String thumbnailStyle, String caption) {
		//if (true )return;
		ln("<div class=\"modal-container\" style=\"".concat(thumbnailStyle).concat("\">"));
		ln("	<a href=\"#img" + modalCount + "\" onclick=\"disableBodyScroll();\" aria-label=\"Scroll\">");
		ln("		<img class=\"modal-thumbnail\" src=\"".concat(thumbnailURL).concat("\" style=\"").concat("max-width:100%;").concat("\" alt=\"\">"));
		ln("	</a>"); // #img
		ln("</div>"); // modal-container

		ln("<a href=\"javascript:enableBodyScroll();\" class=\"modal-image\" id=\"img" + modalCount + "\" aria-label=\"Scroll\">");
		ln("	<div>");
		ln("		<img src=\"".concat(imageURL).concat("\" alt=\"\">"));
		if (null != caption) ln("		<p>".concat(caption).concat("</p>"));
		ln("	</div>"); // flex container
		ln("</a>"); // modal-image
		modalCount++;
	}

	public void addStaticImage(String thumbnailURL) {
		ln("<img class=\"common-static-image\" src=\"" + thumbnailURL + "\" alt=\"\">");
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

	public void addLinkButton(String text, String href, boolean newTab) {
		l("<a class=\"btn btn-blue ripple\" href=\"".concat(href).concat("\"").concat(newTab ? " target=\"_blank\">" : ">").concat(text).concat("</a>"));
	}

	public void addLink(String text, String href, boolean newTab) {
		l("<a  href=\"".concat(href).concat("\"").concat(newTab ? " target=\"_blank\">" : ">").concat(text).concat("</a>"));
	}

	public void addHead(String[] cssImport, String[] jsImport, String title) {
		ln("<html lang=\"en\">");
		ln("<head>");
		if (null == title)
			title = "";
		ln("	<meta charset=\"UTF-8\">"); // Firefox complains about missing encoding
		ln("	<title>".concat(title).concat("</title>"));
		ln("	<link rel=\"shortcut icon\" type=\"image/png\" href=\"".concat(Resource.IMG_FAVICO).concat("\">"));
		ln("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		ln("	<meta name=\"theme-color\" content=\"#be8dee\">"); // Mobile tab colour

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

	public void addFooter(RequestInfo request) {
		ln("<footer>");
		ln("<img src=\"" + Resource.IMG_SNAKEICO + "\" onclick=\"startSnake()\" alt=\"Snake..\">");
		ln("<p>Snake...</p>");

		if ((request != null) && request.getQueryParam(Forms.INPUT_DEBUG_REQUEST).equals("y")) {
			try {
				ln("<div>");
				ln("<b>Request</b><br>");
				ln(request.getPrettyHTML());
				ln("</div><br>");
				ln("<b>Request Base64</b>");
				ln("<div style=\"width: 32rem; word-wrap: break-word\">");
				ln(Debug.serialise(request));
				ln("</div><br>");
			} catch (Exception e1) {
				ln("Exception: " + e1.getClass().getCanonicalName() + ": " + e1.getMessage());
			}
		}
		ln("</footer>");
	}

	public void addFormFullscreenMessage() {
		ln("<div id=\"fullscreen-message\">");
		ln("	<h1>Please Wait...</h1>");
		ln("	<div class=\"loading\">");
		ln("		<div class=\"bounce1\"></div>");
		ln("		<div class=\"bounce2\"></div>");
		ln("		<div class=\"bounce3\"></div>");
		ln("	</div>");
		ln("</div>");
	}

	public void addFormInput(String inputName, String inputValue, String inputLabel, String errorMessage, boolean showError, boolean stopAutoComplete, String focusScript, String inputScript, String subText, String icon, boolean addBreaks) {
		ln("	<div " + (showError ? "class=\"forms-param-error\"" : "" ) + ">" + inputLabel + ": * <b style=\"display:" + (showError ? "initial" : "none") + "\">"+ errorMessage + "</b></div>");
		ln("	<div class=\"input-group forms-input\">");
		ln("		<input class=\"" + (showError ? "input-error" : "") + "\" type=\"text\" name=\"" + inputName + "\" value=\"" + inputValue + "\" aria-label=\"" + inputName + "\" onfocusout=\"" + focusScript + "(this)\" oninput=\"" + inputScript + "(this)\"" + (stopAutoComplete ? " autocomplete=\"new-password\"" : "") + ">");
		ln("		<div class=\"input-icon" + (showError ? " input-icon-error": "") + "\"><i class=\"" + icon + "\"></i></div>");
		ln("		</div>");
		if (subText != null) {
			ln("	<i class=\"forms-small-text\">" + subText + "</i>");
		}
		if (addBreaks) ln("	<br><br>");
	}

	public void addFormTextArea(String inputName, String inputValue, String inputLabel, String errorMessage, boolean showError, String focusScript, String inputScript, String subText) {
		ln("	<div " + (showError ? "class=\"forms-param-error\"" : "" ) + ">" + inputLabel + ": * <b style=\"display:" + (showError ? "initial" : "none") + "\">"+ errorMessage + "</b></div>");
		ln("	<textarea rows=\"12\" cols=\"100\" name=\"" + inputName + "\" "+ (showError ? " class=\"input-error\"" : "") + " aria-label=\"" + inputName + "\"  onfocusout=\"" + focusScript + "(this)\" oninput=\"" + inputScript + "(this)\">");
		l(inputValue);
		ln("</textarea>");
		if (subText != null) {
			ln("	<i class=\"forms-small-text\">" + subText + "</i>");
		}
		ln("	<br><br>");
	}

	public List<Integer> addCAPTCHAInput() {
		List<Integer> numbers = Forms.getNewCAPTCHANumbers();
		String cap = Helper.generateCAPTCHAImageAsBase64(numbers.get(0), numbers.get(1));
		ln("<img class=\"captcha-image\" src=\"" + cap + "\" aria-label=\"Security\" alt=\"Security\">");
		ln("<img class=\"captcha-refresh\" src=\"data:,x\" aria-label=\"Refresh\" alt=\"Refresh\" onclick=\"loadNewCAPTCHA('" + PageMapping.AJAX_NEW_CAPTCHA + "',this)\">");
		ln("<i class=\"forms-small-text forms-param-error\" style=\"display:none\">Error in refresh</i>");
		return numbers;
	}
}
