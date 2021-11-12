package web.pages.root.sandpit.xhttp;

import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;
import web.pages.root.Page404;

public class PageXHTTPOuter extends BasePage {

	public PageXHTTPOuter(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		if (!requestInfo.isDebugCookieTrue()) return new Page404(requestInfo).getResponse();

		String[] css = {};
		String[] js = { Resource.JS_LOAD_DOC };

		m.ln("<html lang=\"en\">");
		m.addHead(css, js, "XHTTP Test");

		m.ln("<body>");
		m.ln("	<button type=\"button\" onclick=\"loadDoc('../sandpit/xhttpinner')\">Request server time</button>");
		m.ln("	<p id=\"demo\"></p>");
		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
