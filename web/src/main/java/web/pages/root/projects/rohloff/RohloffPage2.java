package web.pages.root.projects.rohloff;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class RohloffPage2 extends BasePage {

	public RohloffPage2(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.ln("<html lang=\"en\">");
		m.addHead(css, js, "Rohloff 2");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.ln("<div class=\"title-banner\">"); // common-content
		m.ln("	<div>Rohloff 2</div>");
		m.ln("</div>"); // title-banner

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloffPageSelector(m, 2);
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
