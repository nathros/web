package web.pages.root.projects.rohloff2;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;
import web.pages.root.projects.rohloff.RohloffUtils;

public class PageRohloffR24 extends BasePage {

	public PageRohloffR24(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE };

		m.addHead(css, js, "Test new page 2");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("Light Mounts",
				"https://www.campagnolo.com/media/immagini/9593_z_campagnolo-super-record-chain-MY2019-banner.jpg");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloff2PageSelector(m, 2);

		m.ln("<h2>title</h2>");
		
		m.ln("<br><h2>Light mounts</h2>");
		m.ln("<p>");
		
		m.ln("A saddle mount would work fine but one issue I have with them is that they are easily covered by a coat."); 
		m.ln("The Venge seatpost has a handlebar Di2 junction box mount.");
		m.ln("I thought it would be a good idea to repurpose this as a rear light mount.");
		m.ln("This is in two parts, the first is a direction replacement for the junction box.");
		m.ln("The second is the light mount itself which screws into the junction box."); 
		
		
		m.ln("For the front the biggest hurdle was the living hinge for the light mount.");
		m.ln("I tried many many different designs of hinge but they failed pretty quickly.");
		
		m.ln("My first reaction was to reinforce the area that broke but this just moved the failure point to another area until the hinge would not flex without a large amount of force.");
		m.ln("Inspecting the failures closely I noticed failure was caused by layer separation.");
		m.ln("The fix was to rotate the part 90 degrees towards the build plate so that the layers were not in the same direction as the hinge.");
		m.ln("I used PETG, ABS or Nylon would likely be a better material as they are more have more elasticity but I did not have these at hand.");
		
		m.ln("</p>");
		
		
		
		
		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
