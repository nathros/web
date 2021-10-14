package web.pages.root;

import java.io.IOException;

import web.Tools;
import web.common.Debug;
import web.common.LocalStringBuffer;
import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageAdmin extends BasePage {

	public PageAdmin(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_TOGGLE_DIV, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_HEADER, Resource.JS_TOGGLE_DIV };

		m.addHead(css, js, "Admin");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Admin, requestInfo);

		m.addBanner("Admin", Resource.IMG_BANNER_ADMIN);

		final String email = requestInfo.getQueryParam("email");
		
		
		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		LocalStringBuffer ErrorMsg = new LocalStringBuffer(1024);
		ErrorMsg.ln("<p>");
		ErrorMsg.ln("<p><b>Request</b></p>");
		ErrorMsg.ln(requestInfo.getPrettyHTML());
		ErrorMsg.ln("</p><br>");

		try {
			ErrorMsg.ln("<p><b>Request Base64</b></p>");
			ErrorMsg.ln("<div style=\"width: 32rem; word-wrap: break-word\">");
			ErrorMsg.ln(Debug.serialise(requestInfo.requestMap));
			ErrorMsg.ln("</div>");
			ErrorMsg.ln("<br>");
		} catch (IOException e) {

			e.printStackTrace();
		}
		m.ln(m.getContentToggle("<b>Current Request</b>", ErrorMsg.toString()));
		
		
		m.ln("<form>");
		m.ln("	<input type=\"hidden\" name=\"email\" value=\"test\">");
		if (email != "") {
			m.ln("	<textarea style=\"width:100%\" rows=\"32\">");
			m.ln(Tools.sendEmail("Test Subject", "Test Body", true));
			m.ln("	</textarea>");
			m.ln("	<br>");
		}
		m.ln("	<input type=\"submit\" value=\"Send Test Email\">");
		m.ln("</form>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter(requestInfo);

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
