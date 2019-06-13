package web.pages.home;

import java.io.PrintWriter;
import java.io.StringWriter;

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

	public String getResponse(Exception e) {

		String response = e.getMessage() + "\n";
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		response += sw.toString();

		return response;
	}
}
