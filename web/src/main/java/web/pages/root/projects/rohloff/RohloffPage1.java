package web.pages.root.projects.rohloff;

import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class RohloffPage1 extends BasePage {

	public RohloffPage1(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.ln("<html lang=\"en\">");
		m.addHead(css, js, "Rohloff 1");

		m.ln("<body>");
		m.addNavbar();

		m.ln("<div class=\"title-banner\">"); // common-content
		m.ln("	<div>Rohloff 1</div>");
		m.ln("</div>"); // title-banner

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloffPageSelector(m, 1);

		////
		m.ln("<a href=\"#img1\">");
		m.ln("	<img src=\"http://insomnia.rest/images/screens/main.png\" class=\"image\" style=\"width: 100px;\">");
		m.ln("</a>"); // #img1

		m.ln("<a href=\"#_\" class=\"modal-image\" id=\"img1\">");
		m.ln("	<img src=\"http://insomnia.rest/images/screens/main.png\">");
		m.ln("</a>"); // modal-image

		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
