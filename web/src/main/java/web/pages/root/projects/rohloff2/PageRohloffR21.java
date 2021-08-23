package web.pages.root.projects.rohloff2;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;
import web.pages.root.projects.rohloff.RohloffUtils;

public class PageRohloffR21 extends BasePage {

	public PageRohloffR21(RequestInfo request) {
		super(request, true);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_HEADER };

		m.addHead(css, js, "Test new page");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("new title",
				"https://www.campagnolo.com/media/immagini/9593_z_campagnolo-super-record-chain-MY2019-banner.jpg");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		
		RohloffUtils.addRohloff2PageSelector(m, 1);

		
		m.ln("<h2>title</h2>");
		m.ln("<p>");
		m.ln("Decmeber 2020 work in progress<br>");
		m.ln("Frame upgrade<br>");
		m.ln("3d print rear light mount<br>");
		m.ln("needed new a12 mount - difficulty<br>");
		m.ln("shimano gebla conversion?<br><br>");
		
		m.ln("wheel upgrade - new rims and spokes and front hub<br>");
		m.ln("</p>");

		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter();

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
