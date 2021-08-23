package web.pages.root.projects.rohloff;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class RohloffPage7 extends BasePage {

	public RohloffPage7(RequestInfo request) {
		super(request, true);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE, Resource.JS_HEADER };

		m.addHead(css, js, "STI Shifting");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("STI Shifting", Resource.IMG_BANNER_ROHLOFF);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloffPageSelector(m, 7);

		m.ln("<h2>Rohloff STI/Brifter Shifting</h2>");
		m.ln("<p>");
		m.l("The Gebla Rohbox is a 3rd party component which replaces the standard external gear mech. ");
		m.l("One way the Rohloff is different from derailleurs it the it handles indexing. ");
		m.l("The Rohloff has the indexing inside the hub rather than at the shifter in derailleur system. ");
		m.l("This is advantageous because cable stretch becomes an nonissue unless it beomes very slack. ");
		m.l("This means the maintence frequency releated to shifting is greatly reduced. ");
		m.l("One disadvange of the Rohloff shifting mechanism is that 2 cables are needed, one for moving up and other down the range. ");
		m.l("The Rohloff grip shifter is not designed to work with road handlebars. There are hacks and 3rd party alternatives but I have found them to be inelegant and awkward to use. ");
		m.l("The Gebla works by pulling on of the cables rotates wheel in the external mech. You can change upto 1 or 2 gears depending on length of stroke. ");
		m.l("The return spring will pull back the cable to the Gebla. In order to make derailleur shifters work with indexing from the shifter must be removed.");
		m.l("This is easiest with SRAM/Campagnolo shifters nondestructley but there is no obvious method with Shimano. Even a mechanical brake lever could be used. ");
		m.l("Two modified shifters will be needed as the Gebla need two cables, I am using SRAM Red HRD with the right shifter set to move to a harder gear and left to downshift. ");
		m.l("Removing the indexing pawls is a simple process. ");
		m.ln("https://www.cyclingabout.com/rohloff-hubs-with-drop-handlebars/");
		m.ln("</p>");

		m.addModalImage("https://www.allcycling.co.uk/content/products/shiftbox-shiftbox-for-rohloff-that-allows-the-use-of-normal-shifters_117958.jpg", "https://www.allcycling.co.uk/content/products/shiftbox-shiftbox-for-rohloff-that-allows-the-use-of-normal-shifters_117958.jpg", "max-width:60%", "Gebla Rohbox");
		
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter();

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
