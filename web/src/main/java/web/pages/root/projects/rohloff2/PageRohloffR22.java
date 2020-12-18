package web.pages.root.projects.rohloff2;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;
import web.pages.root.projects.rohloff.RohloffUtils;

public class PageRohloffR22 extends BasePage {

	public PageRohloffR22(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "Test new page 2");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("new title 2",
				"https://www.campagnolo.com/media/immagini/9593_z_campagnolo-super-record-chain-MY2019-banner.jpg");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloff2PageSelector(m, 2);

		m.ln("<h2>title</h2>");
		

		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
