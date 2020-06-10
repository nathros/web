package web.pages.root;

import web.common.NavbarItem;
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
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_CAROUSEL };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "Home Page");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Home);
		m.addBannerHome("Home", Resource.IMG_BANNER_1);

		////
		m.ln("<div class=\"common-content\" style=\"margin-top:-20rem\">");
		m.ln("	<div class=\"card\">");

		m.ln("<h2>Experience</h2>");
		m.ln("<h2>Experience</h2>");
		m.ln("<h2>Experience</h2>");
		m.ln("<h2>Experience</h2>");
		m.ln("<h2>Experience</h2>");
		m.ln("<h2>Experience</h2>");
		m.ln("<h2>Experience</h2>");
		m.ln("<h2>Experience</h2>");
		m.ln("<h2>Experience</h2>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content
		////

		m.ln("<script>");
		m.ln(Resource.readResource(Resource.JS_BANNER));
		m.ln("</script>");

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
