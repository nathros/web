package web.pages.root;

import java.io.IOException;

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
				Resource.CSS_TOGGLE_DIV };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "Admin");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Admin);

		m.addBanner("Admin", "https://wallpaperplay.com/walls/full/0/b/2/96811.jpg");

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

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
