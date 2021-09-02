package web.pages.root.projects.rohloff;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class RohloffPage5 extends BasePage {

	public RohloffPage5(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_TOOLTIP, Resource.CSS_MODAL_IMAGE, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_HEADER };

		m.addHead(css, js, "Wheel Build");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("Flat-mount Adapter", Resource.IMG_BANNER_ROHLOFF);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloffPageSelector(m, 5);

		m.ln("<p>");
		m.ln("	I used the book https://www.wheelpro.co.uk/wheelbuilding/book.php by Roger Musson. ");
		m.ln("He is not an advocates of straight pull hubs (questionable advantage over J-bend) and advises against internal nipples, which I understand his rational but ignored his advice for cosmetic reasons. ");
		m.ln("Only the front is straight pull as Rohloff only offers a flanged hub. ");
		m.ln("This is my first wheel build and decided to get a rim which accepts internal nipples. ");
		m.ln("This is purely for aesthetics and the aero gains are practically zero and accept the drawback that truing requires removal of the tyre. ");
		m.ln("If done correctly then this should not need to be done for a long time.");
		m.ln("Building with 65mm deep section rims and internal nipples was a tedious process. ");
		m.ln("I used my bike light to illuminate the inner rim via free spoke holes (2) which enabled me to see inside via another hole (1). ");
		m.ln("Getting the initial nipple to thread on the spoke was tricky and led to a few nipples fall inside the rim which were also annoying to get back out. ");
		m.ln("Without seeing inside the rim the whole wheel build process would almost be impossible. ");
		m.ln("Also Rohloff recommend to use their own spokes, I have seen other people online use non-Rohloff spokes with no issues. ");
		m.ln("I don't think the required tolerances are so tight that the wheel with these spokes will not be reliable.");
		m.ln("</p>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter();

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
