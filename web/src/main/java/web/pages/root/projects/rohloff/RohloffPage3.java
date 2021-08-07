package web.pages.root.projects.rohloff;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class RohloffPage3 extends BasePage {

	public RohloffPage3(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "Rohloff 3");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("Belt Transmission", Resource.IMG_BANNER_ROHLOFF);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloffPageSelector(m, 3);

		m.ln("<h2>Belt Drive</h2>");
		m.ln("<h3>Belt Choice</h3>");
		m.ln("<p>");
		m.ln("Gates Carbon Drive uses an 11mm pitch 12mm width belt. This is not an industry standard pitch for synchronous belts were the closest readily available options are 8mm and 14mm. ");
		m.ln("A bicycle belt would operate at low RPM (< 110), with high peak torques and dynamic stressing (variable load). ");
		m.ln("Not all belts are designed for dynamic stresses and will prematurely fatigue is subject to such use. ");
		m.ln("There are also several tooth profiles and material compositions to consider which serve different applications. ");
		m.ln("After researching I believe the best match is the modified curvilinear GT2 profile with 8mm pitch and ~12mm width. ");
		m.ln("Two readily available commercial options exist: Gates PolyChain GT2 or Continental Synchrochain CTD. ");
		m.ln("The CTD and GT2 profiles are equivalent and compatible but given different names as they from different companies.");
		m.ln("</p>");

		m.ln("<h3>Determining Belt Length</h3>");
		m.ln("<p>");
		m.ln("My frame has a 410mm chain stay which is the centre distance between the bottom bracket and rear wheel. ");
		m.ln("The belt in question has an 8mm tooth pitch. ");
		m.ln("Front sprocket with 80 teeth, rear has 30. ");
		m.ln("This will result in a belt length of 1269.9mm. To get number of teeth needed divide by teeth pitch and round up. 1269.9 / 8 = 159 teeth. https://www.bbman.com/belt-length-calculator/ ");
		m.ln("</p>");

		m.ln("<h3>Splice Design</h3>");
		m.ln("<p>");
		m.ln("Veer uses a V shaped split most likely done via CNC. My design is much simpler to cut as it is an L shape which has perpendicular edges. ");
		m.ln("I don't think the V shape is mechanically stronger than L, both require cutting of the internal cords. ");
		m.ln("The L design has half of them cut at the same tooth while V is gradual over several. ");
		m.ln("However, some teeth at the tips of the V cut will only have a single cord of support while L will always have half of available. ");
		m.ln("The split is set to span over 40 teeth, Veer has a similar amount.");
		m.ln("My design is similar to ERO Joint http://www.ero-joint.com/en/poly-chainr-gt-carbontm-fastening-ero-jointr-ultimate-0 ");
		m.ln("I tried several methods of cutting the belt. ");
		m.ln("Trying with a rotary tool had issues, it is very easy to cause the rubber to melt resulting in a poor cut. ");
		m.ln("At low RPM a much better cut can be made but the motor would stall often resulting in a rough jagged edge. ");
		m.ln("It also takes a lot of time to complete the operation, the rouge edges could be sanded down but this is already a long procedure. ");
		m.ln("I found the best method is the simplest, using a sharp knife (surgical blade) and carefully cut the belt to shape.");
		m.ln("</p>");

		m.ln("<h3>Sprocket Design</h3>");
		m.ln("<p>");
		m.ln("This was by far the most difficult problem to solve. ");
		m.ln("If I wasn't set on the requirement to replace the traditional chain with something with better durability then this project could have been completed in less than half the time. ");
		m.ln("Getting an off the shelf 3/32\" chainring, 8 speed chain and chain tensioner is inexpensive and a quick way to get working power transfer but I was determined for something different. ");
		m.ln("The reasoning behind ditching the chain is because I was disappointed with the lifespan of the 11 speed drivetrain on my Whyte road bike and dislike cleaning and maintenance. ");
		m.ln("I understand that an 8 speed with thicker 3/32\" (2.38mm) inner plates and pins should last longer than 11 speed 11/128\" (2.18mm) if constructed from the same material and tolerances. ");
		m.ln("This is this due to more contact surface to distribute load, which does make 8 speed a little bit heavier. ");
		m.ln("With the recent release of 12 speed systems I expect the durability to decrease once again over 11 speed. ");
		m.ln("Chains are cheap but have a few problems: the lubricant attracts debris which acts as mild abrasive accelerating wear of bushing. ");
		m.ln("From what I've read chains in enclosures can last much longer than their exposed counterparts as they are kept clean. ");
		m.ln("You can get similar results with an open chain but you will need to clean your drivetrain every ride. ");
		m.ln("Enclosures are not compatible derailleur systems unless you have a massive enclosure covering the whole cassette. ");
		m.ln("There are products available for single speed/hub such as the Hebie Chainguard Chainglider but this is noisy. ");
		m.ln("If you don't keep on top of maintenance when wear will accumulate exponentially leading to costly replacement parts. ");
		m.ln("Also I find performing these tasks laborious and time not spent riding. ");
		m.ln("I was originally going to get the Veer Split Belt Pro but delay after delay and when released they didn't support Rohloff lead me to design my own. ");
		m.ln("I investigated existing belt drive systems such as Gates Carbon Drive, Continental used to have a competing system called CBD but was recalled and discontinued due to safety concerns. ");
		m.ln("Next I researched different tooth profiles, belt construction with their applications. ");
		m.ln("The best for my application is a GT2 profile belt, 8mm pitch, 12mm width with fibreglass or carbon fibre cords. ");
		m.ln("No commercially available industry standard bicycle sprockets exist, excluding proprietary systems such as Gates Carbon Drive. ");
		m.ln("I asked Gates for drawings of tooth profiles, they are not fixed and change with the number of teeth on a sprocket because the belt deforms as it bends. ");
		m.ln("The drawings the sent back were useful but were in inches. ");
		m.ln("I know Gates is an American company but I didn't expect mechanical engineers from over there to use such units. ");
		m.ln("For belt tensioning I used the Veer belt tensioner from their original single speed conversion. ");
		m.ln("The pulley axle had to be shortened because it is designed to fit for a cassette hub body, with my Rohloff wheel the axle clashed with the spokes. ");
		m.ln("The front sprocket looks very similar to the one Veer provides as part of their Split Belt Pro, with alternating tooth belt guides and the rear is guided by the tensioner. ");
		m.ln("Veer offers 64 or 72 teeth while mine has 80. The Rohloff has a wide 58mm chainline, when measuring the chainline of my the crank I determined both sprockets need to be slammed. ");
		m.ln("100% negative offset for the rear and 100% positive for the front with a 2mm spacer for the front. ");
		m.ln("This means with my design the sprockets are not reversible while with the Veer system they look to be only partially offset and can be reversed but still require the use of spacers. ");
		m.ln("They were manufactured via CNC by the same company that made the flat-mount axle plate, front using black anodised aluminum and rear is 304 stainless steel.");
		m.ln("</p>");

		m.ln("<h3>Manufacturing</h3>");
		m.ln("<p>");
		m.ln("Drilling needs to be done at a low RPM, I used the slowest mode of my rotary tool. ");
		m.ln("You have to press slowly and gently as not not cause too much heat or the rubber will melt. ");
		m.ln("I used a m2 drill bit and joined the belt with m2.2 stainless steel self tapping screws. Any excess screw is later trimmed. I used a Contitech CTD belt.");
		m.ln("</p>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter();

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
