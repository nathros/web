package web.pages.root.projects.rohloff;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class RohloffPage6 extends BasePage {

	public RohloffPage6(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "Headset Spacers");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("Headset Spacers", Resource.IMG_BANNER_ROHLOFF);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloffPageSelector(m, 6);

		m.ln("<h2>Headset Spacers Poor Fit</h2>");
		m.ln("<p>");
		m.ln("The included headset spacers for the Wilier Triestina Alabarda integrated handlebar are designed for use with a Wilier frame and are a poor fit for my frame. ");
		m.ln("I got a good deal on the handlebar and was fond of its appearance so instead of selling it and searching for a replacement I decided to remedy the situation. ");
		m.ln("The main culprit is the base spacer and it does not match the profile of the top of the head tube on Miracle frame. ");
		m.ln("I took measurements of the existing spacers and frame and designed a set of replacement spacers in FreeCAD. ");
		m.ln("These were manufactured by 3DHubs https://www.3dhubs.com/ via SLS 3D printing and carbon filled nylon material in black. ");
		m.ln("In the same production run I also added cable hole covers (only 1 was included with the frame) and derailleur hole cover as I would not be using it and don't want water entering the frame. ");
		m.ln("Also the first revision of my Rohloff belt sprocket. ");
		m.ln("The colour came out as grey rather than the desired black and as a result did not match the rest of the build. ");
		m.ln("Nylon can be dyed so I used fabric dye with good success and I didn't like the idea of painting due to durability concerns such as flaking.");
		m.ln("</p>");

		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
