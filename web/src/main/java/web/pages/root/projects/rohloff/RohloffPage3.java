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
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FOOTER, Resource.CSS_TOGGLE_DIV, Resource.CSS_FORMS, Resource.CSS_TOOLTIP };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE, Resource.JS_HEADER, Resource.JS_FORMS, Resource.JS_TOGGLE_DIV, Resource.JS_TOOLTIP };

		m.addHead(css, js, "Rohloff - Belt Transmission");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects, requestInfo);
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


		m.ln("<h3>Sprocket Design</h3>");
		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/S2TJ4Of.png", "https://i.imgur.com/S2TJ4Of.png", "max-width:100%", null, null);
		m.addModalImage("https://i.imgur.com/VMkWGij.jpg", "https://i.imgur.com/X1V5sJ4.jpg", "max-width:100%", null, null);
		m.ln("</div>");
		m.ln("<div class=\"paragraph\">");
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
		m.ln("The best for my application is a GT2 profile belt, 8mm pitch, 12mm width with carbon fibre cords. ");
		m.ln("Fibreglass cords may stretch under heavy loads and cause skipping. ");
		m.ln("No commercially available industry standard bicycle sprockets exist, excluding proprietary systems such as Gates Carbon Drive. ");
		m.ln("I asked Gates for drawings of tooth profiles, they are not fixed and change with the number of teeth on a sprocket because the belt deforms as it bends. ");
		m.addToolTip("<b style=\"cursor: default\">30 Teeth</b>", "<img src=\"https://i.imgur.com/WxOHCF4.png\" alt=\"30\"><p>Tooth profile for 30 teeth sprocket</p>", true);
		m.addToolTip("<b style=\"cursor: default\">80 Teeth</b>", "<img src=\"https://i.imgur.com/y9T7JAQ.png\" alt=\"30\"><p>Tooth profile for 80 teeth sprocket</p>", true);
		m.ln("The drawings the sent back were useful but were in inches. ");
		m.addToolTip("<b style=\"cursor: default\">Profile CAD</b>", "<img src=\"https://i.imgur.com/YjtUxJQ.png\" alt=\"FreeCAD\"><p>30T profile recreated in FreeCAD based on drawing from Gates converted to mm</p>", true);
		m.ln("I know Gates is an American company but I didn't expect mechanical engineers from over there to use such units. ");
		m.ln("For belt tensioning I used the Veer belt tensioner from their original single speed conversion. ");
		m.ln("The pulley axle had to be shortened because it is designed to fit for a cassette hub body, with my Rohloff wheel the axle clashed with the spokes. ");
		m.ln("The front sprocket looks very similar to the one Veer provides as part of their Split Belt Pro, with alternating tooth belt guides and the rear is guided by the tensioner. ");
		m.ln("Veer offers 64 or 72 teeth while mine has 80. The Rohloff has a wide 58mm chainline, when measuring the chainline of my the crank I determined both sprockets need to be slammed. ");
		m.ln("100% negative offset for the rear and 100% positive for the front with a 2mm spacer for the front. ");
		m.ln("This means with my design the sprockets are not reversible while with the Veer system they look to be only partially offset and can be reversed but still require the use of spacers. ");
		m.ln("They were manufactured via CNC by the same company that made the flat-mount axle plate, front using black anodised 6061 aluminium and rear is 304 stainless steel.");
		m.ln("</div><br>");


		m.ln("<h3>Splice Design</h3>");
		m.ln("<h3>Veer Belt</h3>");
		m.addStaticImage("https://i.imgur.com/9jj0zAV.png");
		m.ln("<h3>Custom v1 (L)</h3>");
		m.addStaticImage("https://i.imgur.com/Qds7hw7.png");
		m.ln("<h3>Custom v2 (Z)</h3>");
		m.addStaticImage("https://i.imgur.com/VkUOfBw.png");
		m.ln("<div class=\"paragraph\">");
		m.ln("Veer uses a V shaped split most likely done via CNC. My initial design is much simpler to cut as it is an L shape which comprises of a few perpendicular lines. ");
		m.ln("Both systems make the belt weaker as a result of cutting the internal cords, but to mitigate this the cut is done over many teeth, 40 for my design. ");
		m.ln("The L shape design has a ");
		m.addToolTip("<b style=\"cursor: default\">weak point</b>", "<img src=\"https://i.imgur.com/GiNnB18.png\" alt=\"weak point\"><p>There are two weak points at either side of the join in the L shaped design</p>", true);
		m.ln("at the transition period of the split because only half of the belt is supported. ");
		m.ln("This became apparent as this belt quickly failed in this area after short testing. ");
		m.ln("A revision was made to a Z or slashed design, this alleviates this stress point by easing the transition of the join. ");
		m.ln("There are other commercially available split belt designs such as the ");
		m.addLink("ERO Joint", "http://www.ero-joint.com/en/poly-chainr-gt-carbontm-fastening-ero-jointr-ultimate-0", true);
		m.ln(".");
		m.ln("</div>");

		m.ln("<h3>Veer Belt Cords</h3>");
		m.addStaticImage("https://i.imgur.com/leTy9Ry.png");
		m.ln("<h3>Custom v1 (L) Belt Cords</h3>");
		m.addStaticImage("https://i.imgur.com/PhtuVX5.png");
		m.ln("<h3>Custom v2 (Z) Belt Cords</h3>");
		m.addStaticImage("https://i.imgur.com/ELozwdR.png");
		m.ln("<div class=\"paragraph\">");
		m.ln("The blue lines are the cords within a belt and red line shows where a splice is made, in white indicate how many cords are supporting the belt in a corresponding section. ");
		m.ln("One issue with any split belt design is that the cords must be cut which does weaken the belt. ");
		m.ln("12mm width GT2 belts have 12 cords, in my first design there are 2 weak sections were only 5 or 6 cords are supporting the belt. ");
		m.ln("Any heavy or shock loads on this area have a high risk of failure as seen at the bottom of this page. ");
		m.ln("Depending on the accuracy of the splice directly between two cords giving you 6 cords for each side or may damage one reducing the effective count. ");
		m.ln("The second version fixes this issue and only an effective single is lost across the splice, this section is also supported by the screws rejoining the belt. ");
		m.ln("One thing of note is that the Veer belt has two cuts along the same section resulting in two cords being cut reducing the effective count to ten over the split. ");
		m.ln("Also at the base of the V there is the potential to only have nine cords supporting this section, a reduction of 25% of total cords. ");
		m.ln("The Veer design is symmetric which mine is not, so the Veer design may be able to better handle skewed forces that are not parallel to the cords. ");
		m.ln("</div>");

		m.ln("<h3>Manufacturing</h3>");
		m.ln("<div class=\"paragraph\">");
		m.ln("I tried several methods of cutting the belt. ");
		m.ln("First with a rotary tool had issues, running at a medium or high speed the rubber would melt resulting in a poor cut. ");
		m.ln("At low speed the cut was initially much better, but the motor would stall often resulting in a rough jagged edge. ");
		m.ln("Later I found the best method is the simplest, using a N&deg;11 surgical blade to make long connecting cuts. ");
		m.ln("The cut lines were carefully drawn on paper, cut out and then adhered to the belt using a glue stick.");
		m.ln("Drilling needs to be done at a low RPM, I used the slowest mode of my rotary tool. Even that was still too fast to prevent melting of the rubber. ");
		m.ln("The technique I used is to press quite quickly and only for a few seconds then retract the tool.");
		m.ln("If you see bubbles on the teeth then you know it has went past the melting point. Good I had some surplus sections of belt to test drilling and cutting. ");
		m.ln("I used a m2 drill bit and joined the belt with m2.2 stainless steel self tapping screws. Any excess screw is later trimmed. ");
		m.ln("A Contitech CTD belt is used for the v1 design which failed because of the stress point and non-ideal fibreglass cords, the v2 used a belt from Gates.");
		m.ln("</div>");

		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/n1hDFTR.jpg", "https://i.imgur.com/p64gKrP.jpg", "max-width:100%", null, null);
		m.addModalImage("https://i.imgur.com/mUrGF5R.jpg", "https://i.imgur.com/OmmAvGy.jpg", "max-width:100%", null, null);
		m.addModalImage("https://i.imgur.com/SRaXTHt.jpg", "https://i.imgur.com/vPwfaqw.jpg", "max-width:100%", null, null);
		m.ln("</div>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addCommentsSectionAsync();
		m.addFooter(requestInfo);

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
