package web.common;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import web.Version;
import web.database.CommentNode;
import web.database.CommentRoot;
import web.database.Database;
import web.pages.PageMapping;
import web.pages.resources.Resource;

public class Markup {
	public LocalStringBuffer p = new LocalStringBuffer(1024 * 32);

	public Markup() {
		ln("<!DOCTYPE html>");
	}

	public void addNavbar(NavbarItem item, RequestInfo request) {
		boolean debug = request.isDebugCookieTrue();
		addFormFullscreenMessage();
		ln("<div class=\"navbar\" " + (debug ? "style=\"filter:invert(1)\"" : "") + ">");

		if (NavbarItem.Home == item) {
			ln("	<a class=\"navbar-selected\" href=\"".concat(PageMapping.HOME_PG).concat("\">Home</a>"));
		} else {
			ln("	<a href=\"".concat(PageMapping.HOME_PG).concat("\">Home</a>"));
		}

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
		ln("			<a href=\"".concat(PageMapping.FILESERVER1_PG).concat("\">45TB File Server</a>"));
		ln("			<a href=\"".concat(PageMapping.CONNECT4).concat("\">Connect 4</a>"));
		ln("			<a href=\"https://github.com/nathros\" target=\"_blank\" rel=\"noreferrer\">Github");
		ln("				<img class=\"navbar-git\" src=\"" + Resource.IMG_GITICO + "\" alt=\"Gitgub Logo\">");
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

		if (debug) {
			if (NavbarItem.Sandpit == item) {
				ln("	<a class=\"navbar-selected\" href=\"".concat(PageMapping.SANDPIT_PG).concat("\">Sandpit</a>"));
			} else {
				ln("	<a href=\"".concat(PageMapping.SANDPIT_PG).concat("\">Sandpit</a>"));
			}
		}

		if (NavbarItem.Admin == item) {
			ln("	<a class=\"navbar-selected\" href=\"".concat(PageMapping.ADMIN_PG).concat("\">Admin</a>"));
		} else if (debug) {
			ln("	<a href=\"".concat(PageMapping.ADMIN_PG).concat("\">Admin</a>"));
		}

		if (NavbarItem.BadPage == item) {
			ln("	<a class=\"navbar-selected\" >Missing Page</a>");
		}

		ln("	<div class=\"navbar-search\">");
		ln("		<form action=\"/stage/search\" name=\"search-form\" class=\"" + (NavbarItem.Search == item ? "btn-search-form-selected" : "") + "\" onsubmit=\"btnSearchClick(this)\">");
		ln("			<button type=\"button\" class=\"btn-search" + (NavbarItem.Search == item ? " navbar-line btn-search-selected" : "") + "\" onclick=\"btnSearchClick()\" onmouseup=\"btnSearchDebug(event)\"></button>");
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

	public String getContentToggle(String title, String content) {
		String id = UUID.randomUUID().toString(); // When deployed on AWS addCommentsSectionAsync() can clash if not random, 2 toggles with same ID
		LocalStringBuffer buffer = new LocalStringBuffer(512);
		buffer.ln("<div class=\"toggle-container\">");
		buffer.ln("	<label class=\"toggle-label\" for=\"toggle-item-" + id + "\">".concat(title).concat("</label>"));
		buffer.ln("	<input class=\"toggle-input\" checked type=\"checkbox\" id=\"toggle-item-" + id + "\" onclick=\"toggleContentHeight(this)\">");
		buffer.ln("	<div class=\"toggle-content\">");
		buffer.ln(content);
		buffer.ln("	</div>"); // toggle-content
		buffer.ln("	<i class=\"toggle-arrow\"></i>");
		buffer.ln("</div>"); // toggle-container
		return buffer.toString();
	}

	public String getContentTogglePlus(String title, String content) {
		String id = UUID.randomUUID().toString(); // When deployed on AWS addCommentsSectionAsync() can clash if not random, 2 toggles with same ID
		LocalStringBuffer buffer = new LocalStringBuffer(512);
		buffer.ln("<div class=\"toggle-container\">");
		buffer.ln("	<label class=\"toggle-label\" for=\"toggle-item-" + id + "\">".concat(title).concat("</label>"));
		buffer.ln("	<input class=\"toggle-input\" checked type=\"checkbox\" id=\"toggle-item-" + id + "\" onclick=\"toggleContentHeight(this)\">");
		buffer.ln("	<div class=\"toggle-content\">");
		buffer.ln(content);
		buffer.ln("	</div>"); // toggle-content
		buffer.ln("	<i class=\"toggle-cross\"></i>");
		buffer.ln("</div>"); // toggle-container
		return buffer.toString();
	}

	public String getContentTogglePulse(String title, String content) {
		String id = UUID.randomUUID().toString(); // When deployed on AWS addCommentsSectionAsync() can clash if not random, 2 toggles with same ID
		LocalStringBuffer buffer = new LocalStringBuffer(512);
		buffer.ln("<div class=\"toggle-container\">");
		buffer.ln("	<label class=\"toggle-label\" for=\"toggle-item-" + id + "\">".concat(title).concat("</label>"));
		buffer.ln("	<input class=\"toggle-input\" checked type=\"checkbox\" id=\"toggle-item-" + id + "\" onclick=\"toggleContentHeight(this)\">");
		buffer.ln("	<div class=\"toggle-content\">");
		buffer.ln(content);
		buffer.ln("	</div>"); // toggle-content
		buffer.ln("	<div class=\"toggle-arrow\" style=\"z-index:10\"></div>");
		buffer.ln("	<div class=\"toggle-arrow\" style=\"z-index:5\">");
		buffer.ln("		<div class=\"toggle-circle\"></div>");
		buffer.ln("	</div>");
		buffer.ln("</div>"); // toggle-container
		return buffer.toString();
	}

	public void addToolTip(String visibleContent, String tooltipContent, boolean addIcon) {
		ln("<div class=\"tooltip\" onmouseover=\"tooltipHover(this)\" onmouseleave=\"tooltipHoverLeave(this)\">");
		ln("<span>" + visibleContent + (addIcon ? " <img src=\"" + Resource.IMG_EXPANDICO + "\" alt=\"none\">" : "") + "</span>");
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

	public void addModalImage(String thumbnailURL, String imageURL, String thumbnailStyle, String caption, LocalStringBuffer buff) {
		if (buff == null) buff = p;
		buff.ln("<div class=\"modal-container\" style=\"".concat(thumbnailStyle).concat("\">"));
		buff.ln("	<a href=\"#img" + modalCount + "\" onclick=\"disableBodyScroll();\" aria-label=\"Scroll\">");
		buff.ln("		<img class=\"modal-thumbnail\" src=\"".concat(thumbnailURL).concat("\" style=\"").concat("max-width:100%;").concat("\" alt=\"\">"));
		buff.ln("	</a>"); // #img
		buff.ln("</div>"); // modal-container

		buff.ln("<a href=\"javascript:enableBodyScroll();\" class=\"modal-image\" id=\"img" + modalCount + "\" aria-label=\"Scroll\">");
		buff.ln("	<div>");
		buff.ln("		<img src=\"".concat(imageURL).concat("\" alt=\"\">"));
		if (null != caption) buff.ln("		<p>".concat(caption).concat("</p>"));
		buff.ln("	</div>"); // flex container
		buff.ln("</a>"); // modal-image
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
		p.ln(line);
	}

	public void l(String line) {
		p.l(line);
	}

	public void addLinkButton(String text, String href, boolean newTab) {
		l("<a class=\"btn btn-blue ripple\" href=\"".concat(href).concat("\"").concat(newTab ? " target=\"_blank\">" : ">").concat(text).concat("</a>"));
	}

	public void addLinkButtonStyle(String text, String href, String extraStyle, boolean newTab) {
		l("<a class=\"btn btn-blue ripple\" style=\"".concat(extraStyle).concat("\" href=\"".concat(href).concat("\"").concat(newTab ? " target=\"_blank\">" : ">").concat(text).concat("</a>")));
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
		ln("	<meta name=\"theme-color\" content=\"#16202b\">"); // Mobile tab colour

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

		if ((request != null) && request.isDebugCookieTrue()) {
			try {
				ln("<div class=\"common-content\">");
				ln("<div class=\"card\">");

				ln("<b>Request JSON</b><br>");
				ln("<div style=\"font-family:monospace\">");
				ln(request.getPrettyHTML());
				ln("</div><br>");

				ln("<b>Request Base64</b>");
				ln("<div style=\"width:32rem;word-wrap:break-word;font-family:monospace\">");
				ln(Debug.serialise(request.requestMap));
				ln("</div>");

				ln("<br><b>Version</b>: " + Version.version);

				long creationTime = System.currentTimeMillis() - request.getCreatedTime();
				ln("<br><b>Server Page Time</b>: " + creationTime + "ms");

				ln("</div>"); // card
				ln("</div>"); // common-content
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
		ln("</div>"); // fullscreen-message

		ln("<div id=\"toast\" style=\"display:none\">"); // Display none if forms.css not included
		ln("	<button type=\"button\" onclick=\"hideToast()\">&times;</button>");
		ln("	<p id=\"toast-message\"></p>");
		ln("</div>"); //toast
	}

	public void addCheckbox(String inputName, boolean checked, LocalStringBuffer buff) {
		if (buff == null) buff = p;
		buff.ln("<div class=\"checkbox-group\">");
		buff.ln("<input type=\"checkbox\" id=\"" + inputName + "\" name=\"" + inputName + "\" " + (checked ? "checked" : "") + ">");
		buff.ln("<label for=\"" + inputName + "\">Keep details for future use</label>");
		buff.ln("</div><br>");
	}

	public void addFormInput(String inputName, String inputValue, String inputLabel, String errorMessage, boolean showError, boolean stopAutoComplete, String focusScript, String inputScript, String subText, String icon, boolean addBreaks, LocalStringBuffer buff) {
		if (buff == null) buff = p;
		buff.ln("	<div " + (showError ? "class=\"forms-param-error\"" : "" ) + ">" + inputLabel + ": * <b style=\"display:" + (showError ? "initial" : "none") + "\">"+ errorMessage + "</b></div>");
		buff.ln("	<div class=\"input-group forms-input\">");
		buff.ln("		<input class=\"" + (showError ? "input-error" : "") + "\" type=\"text\" name=\"" + inputName + "\" value=\"" + inputValue + "\" aria-label=\"" + inputName + "\" onfocusout=\"" + focusScript + "(this)\" oninput=\"" + inputScript + "(this)\"" + (stopAutoComplete ? " autocomplete=\"new-password\"" : "") + ">");
		buff.ln("		<div class=\"input-icon" + (showError ? " input-icon-error": "") + "\"><i class=\"" + icon + "\"></i></div>");
		buff.ln("		</div>");
		if (subText != null) {
			buff.ln("	<i class=\"forms-small-text\">" + subText + "</i>");
		}
		if (addBreaks) buff.ln("	<br><br>");
	}

	public void addFormTextArea(String inputName, String inputValue, String inputLabel, String errorMessage, boolean showError, String focusScript, String inputScript, String subText, int maxLength, LocalStringBuffer buff) {
		if (buff == null) buff = p;
		String maxLengthStr = "";
		if (maxLength > 0) maxLengthStr = " maxlength=\"" + maxLength + "\" ";
		buff.ln("	<div " + (showError ? "class=\"forms-param-error\"" : "" ) + ">" + inputLabel + ": * <b style=\"display:" + (showError ? "initial" : "none") + "\">"+ errorMessage + "</b></div>");
		buff.ln("	<textarea rows=\"12\" cols=\"100\"" + maxLengthStr + " name=\"" + inputName + "\" "+ (showError ? " class=\"input-error\"" : "") + " aria-label=\"" + inputName + "\"  onfocusout=\"" + focusScript + "(this)\" oninput=\"" + inputScript + "(this)\">");
		buff.l(inputValue);
		buff.ln("</textarea>");
		if (subText != null) {
			buff.ln("	<i class=\"forms-small-text\">" + subText + "</i>");
		}
		buff.ln("	<br><br>");
	}

	public List<Integer> addCAPTCHAInput(LocalStringBuffer buffer, String nameAppend) {
		List<Integer> numbers = Forms.getNewCAPTCHANumbers();
		String cap = Helper.generateCAPTCHAImageAsBase64(numbers.get(0), numbers.get(1), false);
		String encodedCaptcha = "";
		try {
			encodedCaptcha = Debug.serialise(String.valueOf(numbers.get(0)) + String.valueOf(numbers.get(1)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		addCAPTCHAInputExternalConfig(buffer, nameAppend, cap, encodedCaptcha);
		return numbers;
	}

	public void addCAPTCHAInputExternalConfig(LocalStringBuffer buffer, String nameAppend, String base64Image, String encodedCaptcha) {
		if (buffer == null) buffer = p;
		buffer.ln("<img class=\"captcha-image\" src=\"" + base64Image + "\" aria-label=\"Security\" alt=\"Security\">");
		buffer.ln("<img class=\"captcha-refresh\" src=\"data:,x\" aria-label=\"Refresh CAPTCHA\" alt=\"Refresh CAPTCHA\" onclick=\"loadNewCAPTCHA('" + PageMapping.AJAX_NEW_CAPTCHA + "',this)\">");
		buffer.ln("<i class=\"forms-small-text forms-param-error\" style=\"display:none\">Error in refresh</i>");
		if (nameAppend == null) nameAppend = "";
		buffer.ln("	<input type=\"hidden\" id=\"encoded\" name=\"encoded" + nameAppend + "\" value=\"" + encodedCaptcha + "\">");
	}

	// TODO remove <br> and replace with styling
	public int addCommentsTreeLoop(CommentNode node, final String nest, final int calls, LocalStringBuffer buf, CommentLoopMetaData meta) throws Exception {
		int count = 0;
		if ((node.user != null) && (node.comment != null)) {
			if (calls == 1) buf.ln("<div style=\"padding-top: 1rem; padding-bottom: 1rem\">");
			else buf.ln("<div style=\"padding: 1rem; padding-left: 3rem; padding-right:0\">");

			buf.ln("<b>" + node.user + "</b> - ");
			if (node.date != null) buf.ln("<i style=\"font-size:0.8rem\"> " + node.date + "</i>");
			buf.ln("<br><p>" + node.comment + "</p>");
		} else if (calls == 0) {
			buf.ln("<div>");
		}

		LocalStringBuffer tmp = new LocalStringBuffer(1024);
		tmp.ln("<div style=\"height:10px\"></div>"); // Change to CSS style
		addFormInput(Forms.INPUT_NAME + nest, meta.name, "Name", Forms.ERROR_MESSAGE_REQUIRED, false, false, Forms.SCRIPT_INPUT, Forms.SCRIPT_INPUT, null, Forms.INPUT_ICON_USER, true, tmp);
		addFormInput(Forms.INPUT_EMAIL + nest, meta.email, "Email (not made public)", Forms.ERROR_MESSAGE_REQUIRED, false, false, Forms.SCRIPT_INPUT_EMAIL_LEAVE, Forms.SCRIPT_INPUT_EMAIL, null, Forms.INPUT_ICON_EMAIL, true, tmp);
		addCheckbox("keep-comment" + nest, meta.keepInputChecked, tmp);
		addFormTextArea(Forms.INPUT_COMMENT + nest, "", "Comment", Forms.ERROR_MESSAGE_REQUIRED, false, Forms.SCRIPT_TEXTAREA, Forms.SCRIPT_TEXTAREA, null, 1024, tmp);
		addCAPTCHAInputExternalConfig(tmp, nest, meta.base64ImageCaptcha, meta.encodedCaptcha);
		addFormInput(Forms.INPUT_CAPTCHA + nest, "", "Security Check", Forms.ERROR_MESSAGE_INCORRECT, false, false, Forms.SCRIPT_INPUT_CAPTCHA, Forms.SCRIPT_INPUT_CAPTCHA, "Copy both numbers", Forms.INPUT_ICON_SECURITY, true, tmp);

		tmp.ln("<button class=\"btn btn-blue ripple\" onclick=\"commentAction(this,'" + nest + "','reply')\">Send</button>");
		if (meta.isDebugCookieTrue) tmp.ln("<a class=\"btn btn-blue ripple\" onclick=\"commentAction(this,'" + nest + "','delete')\">Delete</a>");
		tmp.ln("<br><br>");

		tmp.ln("<div id=\"comments-placeholder" + nest + "\" style=\"display:none;height:0.5rem\">&nbsp</div>");
		if (node.user == null) {
			buf.ln(getContentTogglePlus("<b>Leave a Comment</b>", tmp.toString()));
			buf.ln("<hr class=\"hr-strong\">");
		} else {
			buf.ln(getContentTogglePlus("<i>Reply</i><span class=\"inline-icon-reply\"></span>", tmp.toString()));
			buf.ln("<hr>");
		}

		if (node.children != null) {
			for (int i = 0; i < node.children.size(); i++) {
				count++;
				count += addCommentsTreeLoop(node.children.get(i), nest + "," + String.valueOf(i), calls + 1, buf, meta);
			}
		}

		if ((node.user != null) || (calls == 0)) buf.ln("</div>");
		return count;
	}

	public void addCommentsTree(RequestInfo request, String externalPath) {
		try {
			Table table = Database.dynamoDB.getTable(Database.DB_TABLE_COMMENTS);
			String path = externalPath == null ? request.getPath() : externalPath;
			GetItemSpec spec = new GetItemSpec().withPrimaryKey("page", path);
			Item outcome = table.getItem(spec);
			CommentRoot rootNode;
			if (outcome == null) {
				rootNode = CommentRoot.getNewEmptyCommentRoot(path);
			} else {
				rootNode = Database.itemToObject(outcome, CommentRoot.class);
			}
			LocalStringBuffer buffer = new LocalStringBuffer(4096);
			CommentLoopMetaData meta = new CommentLoopMetaData(request);
			int count = addCommentsTreeLoop(rootNode.root, "r", 0, buffer, meta);
			ln("<h2 style=\"margin-top:0\"><span class=\"inline-icon-comment\"></span>Comments (" + count + ")</h2>");
			ln(buffer.toString());
		} catch (Exception e) {
			ln("<div style=\"color:red\">ERROR in comments</div>");
		}
	}

	public void addCommentsSectionAsync() {
		ln("<div class=\"common-content\">");
		ln("<div class=\"card\">");

		ln("<div id=\"comment\">");

		ln("	<div style=\"text-align:center;padding-bottom:0.2rem;\">Loading Comments</div>");
		ln("	<div class=\"comments-placeholder-container\">");
		ln("		<div class=\"comments-placeholder\">&nbsp;</div>");
		ln("	</div>"); // comments-placeholder-container

		ln("</div>"); // comment

		ln("</div>"); // card
		ln("</div>"); // common-content

		ln("<script>");
		ln(Resource.readResource(Resource.JS_LOAD_DYNAMIC));
		ln("</script>");
	}

	private class CommentLoopMetaData {
		public final boolean isDebugCookieTrue;
		final String name;
		final String email;
		final boolean keepInputChecked;

		public final String base64ImageCaptcha;
		public String encodedCaptcha;

		public CommentLoopMetaData(RequestInfo request) {
			List<Integer> numbers = Forms.getNewCAPTCHANumbers();
			base64ImageCaptcha = Helper.generateCAPTCHAImageAsBase64(numbers.get(0), numbers.get(1), false);
			encodedCaptcha = "ERROR";
			try {
				encodedCaptcha = Debug.serialise(String.valueOf(numbers.get(0)) + String.valueOf(numbers.get(1)));
			} catch (IOException e) {
				e.printStackTrace();
			}

			isDebugCookieTrue = request.isDebugCookieTrue();
			String keepCookie = request.getCookie(Forms.COOKIE_COMMENT_KEEP);
			keepInputChecked = !(keepCookie.equals(Forms.VALUE_FALSE) && !keepCookie.equals(Forms.COOKIE_EMPTY));
			if (keepInputChecked) {
				name = request.getCookie(Forms.COOKIE_COMMENT_NAME);
				email = request.getCookie(Forms.COOKIE_COMMENT_EMAIL);
			} else {
				name = email = "";
			}
		}
	}
}
