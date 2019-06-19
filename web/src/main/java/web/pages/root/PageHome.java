package web.pages.root;

import web.common.RequestInfo;
import web.pages.BasePage;

public class PageHome extends BasePage {

	public PageHome(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		m.ln("<html>");
		m.addHeader();
		m.addCSS();

		m.ln("<body>");
		m.ln("<h2>root page</h2>");
		m.ln("</body>");

		m.ln("</html>");

		return m.p.toString();
	}

}
