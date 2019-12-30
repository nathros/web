package web.pages.root.projects.rohloff;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageRohloff0 extends BasePage {

	public PageRohloff0(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TIMELINE,
				Resource.CSS_SIDENAV };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_LOAD_DOC };

		m.addHead(css, js, "Admin");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.ln("<div class=\"common-content\">");
		m.addCard("	<h2><a href=\"/test/admin\"> link</a></h2>");
		////

		m.ln("</div>"); // common-content
		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
