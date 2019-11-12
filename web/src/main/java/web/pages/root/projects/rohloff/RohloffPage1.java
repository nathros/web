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
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.ln("<html lang=\"en\">");
		m.addHead(css, js, "Rohloff 1");

		m.ln("<body>");
		m.addNavbar();

		m.addBanner("Rohloff 1", "https://www.jonkensy.com/wp-content/uploads/IMG_0166-2.jpg");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloffPageSelector(m, 1);

		////
		m.addModalImage("http://insomnia.rest/images/screens/main.png", "http://insomnia.rest/images/screens/main.png",
				"width: 256px");
		m.ln("<br>");

		m.addModalImage("https://mladenplavsic.github.io/css-ripple-effect/images/logo_browserstack.svg",
				"https://mladenplavsic.github.io/css-ripple-effect/images/logo_browserstack.svg", "width: 256px");
		m.ln("<br>");

		m.ln("<a class=\"btn btn-blue ripple\">Link</a>");
		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
