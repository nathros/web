package web.pages.root;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageCV extends BasePage {

	public PageCV(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_CAROUSEL };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.ln("<html lang=\"en\">");
		m.addHead(css, js, "CV");

		m.ln("<body>");
		m.addNavbar(NavbarItem.CV);

		m.ln("<div class=\"title-banner\">");
		m.ln("	<div>CV</div>");
		m.ln("</div>"); // title-banner

		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
