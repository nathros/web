package web.pages.root.projects.rohloff2;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;
import web.pages.root.projects.rohloff.RohloffUtils;

public class PageRohloffR23 extends BasePage {

	public PageRohloffR23(RequestInfo request) {
		super(request, true);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FOOTER};
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE, Resource.JS_HEADER };

		m.addHead(css, js, "Test new page 2");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("A12 Thru Axle Mount",
				"https://www.campagnolo.com/media/immagini/9593_z_campagnolo-super-record-chain-MY2019-banner.jpg");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloff2PageSelector(m, 2);

		m.ln("<h2>title</h2>");
		
		m.ln("<br><h2>A12 Issue</h2>");
		m.ln("<p>");
		m.ln("The Rohloff hub was designed well before the thru axle standard.");
		m.ln("If you look at a cutout of the hub there is not enough free space for a 12mm diameter axle but does allow a Quick Release Skewer.");
		m.ln("Rather than redesign the hub Rohloff opted to have adapters that match the frame drop outs to allow a M7 bolt to secure the hub.");
		
		m.ln("One issue with this is that unlike Quick Release, there are many thru axle standards. These include wdith, diamter, thread pitch and even the interface.");
		m.ln("Show all standards/ 100mm.....");
		
		m.ln("My hub has adapters for the Micicle RD25 which uses a Shimano type 142mm x 12mm thru axle");
		m.ln("My new frame is still 142 x 12mm but has a Syntace V2 interface so new adapters would be needed.");
		m.ln("I took my bike to LBS that was registered with Rohloff as a dealer and asked them if it was possible get the new frame measured and order new adapters.");
		m.ln("They didn't understand my request at first and later turned out they had never dealt with A12 Rohloff hubs before.");
		m.ln("My contact at the shop got training from Rohloff, the measuring kit was sent to shop and the procedure was done.");
		m.ln("Dissapointly Rohloff have minium dropout thickness rules which the which new frame failed."); 
		m.ln("I requested to order the adapter anyway without warrenty and that I would take all responsibuilty.");
		m.ln("...");
		m.ln("I descided to retrive my frame but was meet for a high service charge for them send a few e-mails to Rohloff and a 15 minute measurement operation.");
		m.ln("Not phased I looked to design my own.");
		
		m.ln("The threads inserted into the frame is important, too few and it may not be satbley secured, too many and it can interfere with the hub operation and grind the axle. ");
		m.ln("Measuring the length of purtruding threads to be xyzmm, I designed my own adapters");
		
		
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
