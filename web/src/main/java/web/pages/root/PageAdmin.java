package web.pages.root;

import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageAdmin extends BasePage {

	public PageAdmin(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		m.ln("<html>");
		m.addHead(Resource.CSS_COMMON, Resource.CSS_HEADER);

		m.ln("<body>");
		m.addNavbar();
		m.ln("</body>");

		m.ln("</html>");
		return m.p.toString();
	}

}
