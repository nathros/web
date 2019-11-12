package web.pages.root.projects.connect4;

import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class Connect4Page extends BasePage {

	public Connect4Page(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.ln("<html lang=\"en\">");
		m.addHead(css, js, "Connect 4");

		m.ln("<body>");
		m.addNavbar();

		m.addBanner("Connect 4",
				"https://d1e4pidl3fu268.cloudfront.net/484a5987-b3df-4b5e-a715-1805c1c8c3ee/connectfour.png");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		////

		m.ln("<a class=\"btn btn-blue ripple\">Link</a>");
		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
