package web.pages.root;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import web.common.Debug;
import web.common.RequestInfo;
import web.pages.BasePage;

public class Page404 extends BasePage {

	public Page404(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		return "404";
	}

	public String getResponse(Exception e, Object request) {
		StringBuilder sb = new StringBuilder();
		sb.append("<h2>404</h2>");

		if (e != null) {
			sb.append("<p>Stack Trace</p>");
			sb.append(e.getMessage() + "<br>");
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			sb.append(sw.toString().replaceAll("\n", "<br>"));
		}

		try {
			sb.append("<p>Request Base64</p>");
			sb.append("<div style=\"width: 16em; word-wrap: break-word\">");
			sb.append(Debug.serialise(request));
			sb.append("</div>");
			sb.append("<br>");
			sb.append("<p>Request</p>");
			sb.append(request.toString().replaceAll(", ", "<br>"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return sb.toString();
	}
}
