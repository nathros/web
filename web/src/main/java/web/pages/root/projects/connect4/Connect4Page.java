package web.pages.root.projects.connect4;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class Connect4Page extends BasePage {

	public Connect4Page(RequestInfo request) {
		super(request, true);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "Connect 4");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("Connect 4", Resource.IMG_BANNER_CONNECT4);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		////

		m.ln("<a target=\"_blank\" href=\"https://github.com/nathros/connect4\" class=\"btn btn-blue ripple\">Page Work In Progress, click for Connect 4 code on Github</a>");
		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter();

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
