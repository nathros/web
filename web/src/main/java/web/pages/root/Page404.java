package web.pages.root;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import web.common.Debug;
import web.common.LocalStringBuffer;
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
				Resource.CSS_TOGGLE_DIV };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.ln("<html lang=\"en\">");
		m.addHead(css, js, "404");

		m.ln("<body>");
		m.addNavbar();

		// m.ln("<div class=\"title-banner\">");
		// m.ln(" <div>404</div>");
		// m.ln("</div>"); // title-banner

		m.ln("<div class=\"common-content\">");
		m.ln("<div class=\"card-single\">");
		m.ln("<h1>404</h1>");
		m.ln("<button onclick=\"window.history.back()\">Go Back</button>");

		LocalStringBuffer stackTrace = new LocalStringBuffer(1024);
		LocalStringBuffer requestJSON = new LocalStringBuffer(1024);
		LocalStringBuffer requestB64 = new LocalStringBuffer(1024);

		if (e != null) {
			// stackTrace.ln("<p><b>Stack Trace</b></p>");
			stackTrace.ln(e.getMessage() + "<br>");
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			stackTrace.ln(sw.toString().replaceAll("\n", "<br>"));
		}

		if (request != null) {
			try {
				// requestB64.ln("<br><p><b>Request Base64</b></p>");
				requestB64.ln("<div style=\"width: 32rem; word-wrap: break-word\">");
				requestB64.ln(Debug.serialise(request));
				requestB64.ln("</div>");
				requestB64.ln("<br>");
				// requestB64.ln("<p><b>Request JSON</b></p>");
				requestB64.ln(request.toString().replaceAll(", ", "<br>"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		requestJSON.ln("<p>");
		requestJSON.ln(requestInfo.getPrettyHTML());
		requestJSON.ln("</p>");

		String stackTraceString = m.getContentToggle("<b>Strack Trace</b>", stackTrace.toString());
		String requestJSONString = m.getContentToggle("<b>Request</b>", requestJSON.toString());
		String requestB64String = m.getContentToggle("<b>Request Base64</b>", requestB64.toString());
		m.ln(m.getContentToggle("<b>Show More Info</b>", stackTraceString + requestJSONString + requestB64String));
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content
		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}
}
