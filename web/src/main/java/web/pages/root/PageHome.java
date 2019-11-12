package web.pages.root;

import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageHome extends BasePage {

	public PageHome(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.ln("<html lang=\"en\">");
		m.addHead(css, js, "Home Page");

		m.ln("<body>");
		m.addNavbar();

		m.ln("<div class=\"title-banner\">"); // common-content
		m.ln("	<div>Home Page</div>");
		m.ln("</div>"); // title-banner

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
