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
		sb.append("Request:<br>");
		sb.append(request.toString());
		sb.append("=======================<br>");
		sb.append("=======================<br>");

		if (e != null) {
			sb.append(e.getMessage() + "<br>");

			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			sb.append(sw.toString());
		}
		sb.append("....");
		try {
			sb.append(Debug.serialise(request));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		sb.append("....");
		return sb.toString();
	}
}
