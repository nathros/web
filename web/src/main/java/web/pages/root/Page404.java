package web.pages.root;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import web.common.Debug;
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
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.ln("<html lang=\"en\">");
		m.addHead(css, js, "404");

		m.ln("<body>");
		m.addNavbar();

		m.ln("<div class=\"title-banner\">");
		m.ln("	<div>404</div>");
		m.ln("</div>"); // title-banner

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		if (e != null) {
			m.ln("<p><b>Stack Trace</b></p>");
			m.ln(e.getMessage() + "<br>");
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			m.ln(sw.toString().replaceAll("\n", "<br>"));
		}

		if (request != null) {
			try {
				m.ln("<br><p><b>Request Base64</b></p>");
				m.ln("<div style=\"width: 16em; word-wrap: break-word\">");
				m.ln(Debug.serialise(request));
				m.ln("</div>");
				m.ln("<br>");
				m.ln("<p><b>Request JSON</b></p>");
				m.ln(request.toString().replaceAll(", ", "<br>"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content
		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}
}
