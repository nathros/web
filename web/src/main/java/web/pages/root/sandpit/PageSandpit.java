package web.pages.root.sandpit;

import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageSandpit extends BasePage {

	public PageSandpit(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		m.ln("<html>");

		m.ln("<body>");
		m.ln("	<a href=\"xhttpouter\">xhttpouter</a><br>");
		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
