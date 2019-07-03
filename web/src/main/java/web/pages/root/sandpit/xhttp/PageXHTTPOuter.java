package web.pages.root.sandpit.xhttp;

import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageXHTTPOuter extends BasePage {

	public PageXHTTPOuter(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = {};
		String[] js = { Resource.JS_LOAD_DOC };

		m.ln("<html>");
		m.addHead(css, js);

		m.ln("<body>");
		m.ln("	<button type=\"button\" onclick=\"loadDoc('../sandpit/xhttpinner')\">Request server time</button>\n");
		m.ln("	<p id=\"demo\"></p>");
		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
