package web.pages.root.projects.rohloff;

import web.common.NavbarItem;
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
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FOOTER, Resource.CSS_TOGGLE_DIV, Resource.CSS_FORMS };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE, Resource.JS_HEADER, Resource.JS_FORMS, Resource.JS_TOGGLE_DIV };

		m.addHead(css, js, "Rohloff - Background");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects, requestInfo);

		m.addBanner("Background", Resource.IMG_BANNER_ROHLOFF);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloffPageSelector(m, 1);

		m.ln("<br>");
		m.addModalImage(Resource.IMG_ROHLOFF_FINAL_COMPLETE_TN, Resource.IMG_ROHLOFF_FINAL_COMPLETE, "max-width:60%", null, null);
		m.ln("Finished build");
		m.ln("<h2>Design Goal</h2>");
		m.ln("<p>");
		m.ln("To produce a low maintenance high performance road bike.I currently have a Shimano 105 5800 equipped road bike and do a lot of riding. One issue I am having is the high level of maintenance a derailleur system requires. If this neglected then degradation can occur quickly leading to costly repairs. For example, if you let a chain become worn then it will destroy the cassettes and chainrings leading to poor shifting and skipping under load and in worst case failure. A new chain will skip and the whole drivetrain will need to be replaced. The chain needs to be kept reasonably clean and lubed to slow down wear. Dry chains will corrode easily while the dirt in lubed chains will act like grit or mild sandpaper, neither is good for longevity.");
		m.ln("</p>");

		m.ln("<h2>Types of Transmission</h2>");
		m.ln("<p>");
		m.ln("A direct chain drive is possibly the most efficient system at transferring rider power to the rear wheel and is also the most popular system. ");
		m.ln("When looking for alternatives I categorised them into hub gears, shaft drive or exotic. ");
		m.ln("Hubs are the second most popular system, with offerings from big manufactures such Shimano. ");
		m.ln("Shaft drive equipped frames are hard to come by ");
		m.addLink("link", "https://bicycles.stackexchange.com/questions/20591/any-experience-with-shaft-driven-bikes", true);
		
		m.ln(" Exotic systems are even rarer than shaft bikes. String bicycles are interesting www.stringbike.com and CeramicSpeed have an interesting concept in development named Driven: https://www.ceramicspeed.com/en/driven/ ");
		m.ln("I have settled on a Rohloff hub as it is the best and well regarded internal hub available renowned for its durability. The efficiency is not that far behind a derailleur, see");
		m.ln("internal hubs and derailleur efficiency: ");
		m.addLink("PDF", "http://www.ihpva.org/HParchive/PDF/hp52-2001.pdf", true);
		m.ln(" internal hub efficiency comparison from ");
		m.addLink("CyclingAbout", "https://www.cyclingabout.com/speed-difference-testing-gearbox-systems/", true);
		m.ln(". Single speed is not suitable for my use case and the exotic systems have their own unique issues which is why I rejected these options.");
		m.ln("Also, a derailleur system will quickly become less efficient as the lubricant deteriorates and drivetrain becomes dirty. Depending on the user and conditions a belt driven hub could be more efficient on average in terms of less time spent maintaining the system.");
		m.ln("</p>");

		m.ln("<h2>Belt Transmission</h2>");
		m.ln("<p>");
		m.ln("BikeRadar: ");
		m.addLink("link", "https://www.bikeradar.com/road/news/article/chain-or-belt-drive-which-is-faster-36074/", true);
		
		m.ln(" This article says that belts have very poor efficiency: 34.6% more power loss than a chain and the wording in the article makes belts appear unusable. While this is true 2.92W loss for chain, 3.93W for belt, for a 250W input this is less than 0.5% difference in total power and negligible. That is for a clean chain with a straight chainline, in practice this will not be the case in most situations, closing the gap. If performance is very important, you ride professionally or you only ride a few hours a week then a derailleur system is fine for you.");
		m.ln("</p>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addCommentsSectionAsync();
		m.addFooter(requestInfo);

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
