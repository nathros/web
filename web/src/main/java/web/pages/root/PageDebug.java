package web.pages.root;

import web.common.RequestInfo;
import web.pages.BasePage;

public class PageDebug extends BasePage {

	public PageDebug(RequestInfo request) {
		super(request, false);
	}

	@Override
	public String getResponse() {
		m.p.delete(0, m.p.length());
		m.ln("<h2>" + System.currentTimeMillis() + "</h2>");

		return m.p.toString();
	}

}
