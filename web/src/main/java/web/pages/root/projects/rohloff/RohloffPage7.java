package web.pages.root.projects.rohloff;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class RohloffPage7 extends BasePage {

	public RohloffPage7(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "STI Shifting");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("STI Shifting",
				"https://www.campagnolo.com/media/immagini/9593_z_campagnolo-super-record-chain-MY2019-banner.jpg");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloffPageSelector(m, 7);

		m.ln("<h2>Rohloff STI/Brifter Shifting</h2>");
		m.ln("<p>");
		m.ln("The Gebla Rohbox replaces the standard external gear mech. The Rohloff handles it’s own indexing meaning the indexing from the shifter needs to be removed. This is easiest with SRAM/Campagnolo but no obvious method with Shimano. The Rohloff grip shifter is not designed to work with road handlebars. There are hacks and 3rd party alternatives but none are elegant. https://www.cyclingabout.com/rohloff-hubs-with-drop-handlebars/");
		m.ln("</p>");

		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
