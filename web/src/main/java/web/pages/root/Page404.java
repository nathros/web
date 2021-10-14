package web.pages.root;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import web.common.Debug;
import web.common.LocalStringBuffer;
import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class Page404 extends BasePage {

	public Page404(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		return getResponse(null, null);
	}

	public String getResponse(Exception e, Object request) {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_TOGGLE_DIV, Resource.CSS_BUTTON, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_TOGGLE_DIV, Resource.JS_HEADER };

		m.addHead(css, js, "404");

		m.ln("<body>");
		m.addNavbar(NavbarItem.BadPage, requestInfo);

		m.addBannerAnimated("404 Page Not Found", Resource.IMG_BANNER_1);

		m.ln("<div class=\"common-content\">");
		m.ln("<div class=\"card\">");
		m.ln("<button class=\"btn btn-blue ripple\" onclick=\"window.history.back()\">Go Back</button>");

		LocalStringBuffer ErrorMsg = new LocalStringBuffer(1024);

		if (e != null) {
			ErrorMsg.ln("<p><b>Stack Trace</b></p>");
			ErrorMsg.ln("<div style=\"font-family:monospace\">");
			ErrorMsg.ln(e.getMessage() + "<br>");
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			ErrorMsg.ln(sw.toString().replaceAll("\n", "<br>"));
			ErrorMsg.ln("</div><br>");
		}

		if (request != null) {
			try {
				ErrorMsg.ln("<b>Request JSON</b><br>");
				ErrorMsg.ln("<div style=\"font-family:monospace\">");
				ErrorMsg.ln(new RequestInfo(request).getPrettyHTML());
				ErrorMsg.ln("</div><br>");

				ErrorMsg.ln("<b>Request Base64</b>");
				ErrorMsg.ln("<div style=\"width:32rem;word-wrap:break-word;font-family:monospace\">");
				ErrorMsg.ln(Debug.serialise(request));
				ErrorMsg.ln("</div>");
			} catch (IOException e1) {
				ErrorMsg.ln("Exception: " + e1.getClass().getCanonicalName() + ": " + e1.getMessage());
			}
		}

		m.ln("<br><br>");
		m.ln(m.getContentToggle("<b>Show Detailed Info</b>", ErrorMsg.toString()));
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content
		m.addFooter(requestInfo);
		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}
}
