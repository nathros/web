package web.pages.root;

import web.common.RequestInfo;
import web.pages.BasePage;

public class PageDebug extends BasePage {

	public PageDebug(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		m.p.buffer.delete(0, m.p.buffer.length());
		m.ln("<h2>" + System.currentTimeMillis() + "</h2>");

		return m.p.toString();
	}

}
