package web.pages.root.projects.rohloff;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class RohloffPage2 extends BasePage {

	public RohloffPage2(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE };

		m.addHead(css, js, "Specifications");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("Specifications", Resource.IMG_BANNER_ROHLOFF);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloffPageSelector(m, 2);
		m.ln("<h2>Frame</h2>");
		m.addModalImage(Resource.IMG_ROHLOFF_MRD524_TN, Resource.IMG_ROHLOFF_MRD524, "max-width:50%", null);
		m.addModalImage(Resource.IMG_ROHLOFF_MRD524_SIZE_TN, Resource.IMG_ROHLOFF_MRD524_SIZE, "max-width:50%", null);
		m.ln("<p>");
		m.ln("I have reservations about press-fit bottom brackets, creaking and fit issues which can cause premature bearing failure and also be annoying. ");
		m.ln("I understand that professional athletes who a high turnover of bikes might not report these issues but I intended my build to last a long time. ");
		m.ln("So I am willing to accept a 100g increase around the bottom bracket area to meet this goal. ");
		m.ln("I have little experience with press fit bottom brackets but issues that can occur such as bearing or cup seat wear can cause difficult to fix problems. ");
		m.ln("A fix is to use an epoxy filler but this is at best temporary and the fit of the frame may degrade until it is unusable. ");
		m.ln("https://www.youtube.com/watch?v=RFa5HBfRhnET. There is the issue of cross threading in threaded frames, the drive side is reverse threaded. ");
		m.ln("If it the cup isn't screwing in don't force it, a user error. I have taken the cautious approach to get a frame with a BSA86 threaded bottom bracket.");
		m.ln("</p>");

		m.ln("<p>");
		m.ln("img");
		m.ln("</p>");

		m.ln("<p>");
		m.ln("This Miracle RD525 is odd that the seat tube and head tube are not parallel, seat tube is almost vertical. ");
		m.ln("Still the frame has been reported to be comfortable: ");
		m.addLink("https://www.youtube.com/watch?v=CmT62op0GQw", "https://www.youtube.com/watch?v=CmT62op0GQw", true);
		m.ln("Some people are weary of using Chinese carbon, understandably you can purchase some very cheap low quality and potentially dangerous components if you do not do your research. ");
		m.ln("From mine I have concluded that Hongfu/Dengfu (http://www.hongfu-bikes.com, http://www.dengfubikes.com), Workswell (http://www.workswellbikes.com) and Miracle (http://www.miraclebikes.com) are reputable companies. ");
		m.ln("In fact aerospace engineer Hambini shows that Hongfu/Dengfu has better tolerances than some Cannondale and Specialized frames https://www.youtube.com/watch?v=zryhuHkbb-o. ");
		m.ln("You also need to know that warranty and support from Chinese companies will not match the big name manufactures. ");
		m.ln("Either way, where do you think the renowned companies get their components manufactured? ");
		m.ln("It's not the location of manufacturer which matters but the standards with good quality control.");
		m.ln("</p>");

		m.ln("<h2>Handlebar</h2>");
		m.addModalImage(Resource.IMG_ROHLOFF_HANDLEBAR, Resource.IMG_ROHLOFF_HANDLEBAR, "max-width:50%", null);
		m.ln("<p>");
		m.ln("WILIER TRIESTINA ALABARDA Integrated Handlebar 42-110");
		m.ln("This was a good deal found on eBay, one issue is that it is tailored to Wilier frames. ");
		m.ln("The headset spacers do no fit well with the RD525, so I 3D printed some replacements see: Engineering Challenges – Headset Spacers Poor Fit. I am using Fabric Hex Duo Bar Tape in black.");
		m.ln("</p>");

		m.ln("<h2>Pedals</h2>");
		m.addModalImage(Resource.IMG_ROHLOFF_RFORCE_TI_TN, Resource.IMG_ROHLOFF_RFORCE_TI, "max-width:50%", null);
		m.ln("<p>");
		m.ln("Xpedo R-Force Ti (SPD)<br>");
		m.ln("I chose a SPD based pedal as they have the most walkable shoes of all system. ");
		m.ln("SPD-SL and Speedplay are lighter systems good for road use, but the shoes are not very practical. ");
		m.ln("Finding road specific or light SPD pedals was difficult, the only options available are Crank Brothers Eggbeater 11 Ti or the Xpedo R-Force Ti with the latter being cheaper and better suited to a road bike. ");
		m.ln("There is also the Ritchey WCS Micro Road but these require special proprietary cleat which will work in a SPD pedal but a SPD cleat will not work in the WCS. ");
		m.ln("It uses bushings rather than the bearing around the axle which has questionable lifespan.");
		m.ln("</p>");
		m.ln("<table class=\"common-table\">");
		m.ln("	<tr>");
		m.ln("		<th></th>");
		m.ln("		<th>SPD</th>");
		m.ln("		<th>SPD-SL</th>");
		m.ln("		<th>Speedplay</th>");
		m.ln("	</tr>");
		m.ln("	<tr>");
		m.ln("		<td>Shoe Selection</td>");
		m.ln("		<td style=\"background-color:green\">Wide</td>");
		m.ln("		<td style=\"background-color:green\">Wide</td>");
		m.ln("		<td style=\"background-color:red\">Narrow</td>");
		m.ln("	</tr>");
		m.ln("	<tr>");
		m.ln("		<td>Cleat Cost</td>");
		m.ln("		<td style=\"background-color:green\">Low</td>");
		m.ln("		<td style=\"background-color:orange\">Moderate</td>");
		m.ln("		<td style=\"background-color:red\">High</td>");
		m.ln("	</tr>");
		m.ln("	<tr>");
		m.ln("		<td>Walk-ability</td>");
		m.ln("		<td style=\"background-color:orange\">Medium</td>");
		m.ln("		<td style=\"background-color:red\">Poor</td>");
		m.ln("		<td style=\"background-color:orange\">Short</td>");
		m.ln("	</tr>");
		m.ln("</table>");

		m.ln("<h2>Wheels</h2>");

		m.ln("<h3>Rims</h3>");

		m.ln("<h3>Presta Valve</h3>");

		m.ln("<h3>Tubeless Rim Tape</h3>");
		m.ln("<p>");
		m.ln("25mm width Kapton tape, 3-4 layers. ");
		m.ln("Tubeless bicycle specific rim tape is artificially expensive. ");
		m.ln("In fact Stans rim tape has been shown to be rebranded strapping tape with a ~10 times price increase. ");
		m.ln("Duct tape can be used as an effective substitute, but it leaves residue when removed which is difficult to get off the rim. ");
		m.ln("http://forums.mtbr.com/wheels-tires/tubeless-tape-thread-926021.html Go to first page. Some people have reported ammonia attacking Kapton but I have not had this issue with Orange Sealant which contains ammonia. ");
		m.ln("I guess the composition of Kapton tape can vary from different manufacturers but is fairly unreactive: https://www.masterflex.de/fileadmin/user_upload/SE_Website/Produkte/Masterflex_ChemicalResistance_EN.pdf");
		m.ln("</p>");
		

		m.ln("<h3>Tubeless Sealant</h3>");
		m.addModalImage(Resource.IMG_ROHLOFF_OKO_TN, Resource.IMG_ROHLOFF_OKO, "max-width:25%", null);
		m.ln("<p>");
		m.ln("OKO Magic Milk Hi-Fibre Tyre Sealant");
		m.ln("Previously used Orange Endurance Seal with good success but it is expensive. ");
		m.ln("OKO has slightly worse sealing performance but is less than half of the price. OKO is a latex based sealant which does not contain ammonia. ");
		m.addLink("link", "https://www.planetx.co.uk/i/q/WSOKOMMHF/oko-magic-milk-hi-fibre-tyre-sealant", true);
		m.ln("</p>");

		m.ln("<h3>Tyres</h3>");
		m.ln("<p>");
		m.ln("Michelin Pro 4 Endurance v2 25mm (measure as 28mm)");
		m.ln("These tyres have middle of the road rolling resistance but excellent puncture resistance. ");
		m.ln("Tubeless conversion with clincher tyres can have mixed success rates but the Pro 4 Endurance worked well. ");
		m.ln("Pirelli with their recent return to the market released their Cinturato Velo TLR tyre. ");
		m.ln("It has a thicker tread, better puncture protection and is tubeless ready with minor worse rolling resistance and weight penalty compared to the Pro 4 Endurance. ");
		m.ln("I am not using the Pirelli because I had already purchased the Michelin tyres several months earlier before the launch of the Cinturato Velo. ");
		m.ln("When the Pro 4 Endurance tyres wear out then the Cinturato Velo will likely be their replacement. ");
		m.ln("https://www.bicyclerollingresistance.com/road-bike-reviews?maxweight=401&max=23&min=7&minpr=15");
		m.ln("</p>");

		m.ln("<h3>Front Hub</h3>");
		m.addModalImage(Resource.IMG_ROHLOFF_BITEX_HUB, Resource.IMG_ROHLOFF_BITEX_HUB, "max-width:50%", null);
		m.ln("<a target=\"_blank\" href=\"http://www.bitexhubs.com/htm/pd_detail.php?no=BX306F\">link</a>");
		m.ln("The Quick release endcaps have been swapped for 12mm thru-axle.");

		m.ln("<h3>Spokes and Nipples</h3>");
		m.ln("<p>");
		m.ln("Spoke lengths Front Wheel: Left 263mm, Right 265mm<br>");
		m.ln("Spoke lengths Rear Wheel: Left/Right 233mm");
		m.ln("I went with brass nipples rather than alloy due to electrolysis which can happen between carbon and aluminium. ");
		m.ln("https://www.youtube.com/watch?v=eaDx7RkxIAs Brass is also recommend by Roger Musson in his book Professional Guide to Wheel Building. ");
		m.ln("I know that brass is heavier than alloy but I want the wheel to last a long time and be robust.");
		m.ln("</p>");

		m.ln("<h2>Drivetrain</h2>");

		m.ln("<h3>Rohloff Hub</h3>");
		m.ln("<p>");
		m.ln("I am using the Rohloff A12 hub. The hub was not designed for thru-axles, there only enough internal room for a quick release skewer. ");
		m.ln("You can get your frame dropout measured and provided adapters. ");
		m.ln("https://www.rohloff.de/fileadmin/user_upload/Rohloff-A12-_Dropout_Measurement_Process_en.pdf ");
		m.ln("There are many types of thru-axles such as e-thru (Shimano) or DT/Maxle. Just what the industry needed, more standards. ");
		m.ln("Spoke lengths: Calculated: 232.6mm, Chosen: 233mm");
		m.ln("</p>");

		m.ln("<h3>Crank</h3>");
		m.addModalImage(Resource.IMG_ROHLOFF_FSA_CRANK_TN, Resource.IMG_ROHLOFF_FSA_CRANK, "max-width:50%", null);
		m.ln("<p>");
		m.ln("FSA Team Carbon Crankset BB386 EVO 130BCD<br>");
		m.ln("Originally I was set for 24mm Hollowtech II crank and bottom bracket. ");
		m.ln("However I came across an almost new FSA BB386 Carbon Crankset on eBay, the auction was poorly advertised by the seller and I won it for a very good price.");
		m.ln("I later sold the chainrings and included pressfit bottom bracket which covered about 3/4 of the initial cost. ");
		m.ln("I would be happy with a 24mm spindle crank, they are no gains in performance only a small reduction in mass, 24 to 30 inner race is just the next standard bearing size up. ");
		m.ln("FSA do sell BB386 bottom brackets for threaded frames but they have been reported to wear out quickly, so I am using a 3rd party BSA 30 with spacer on the drive side. ");
		m.ln("See: https://mybikeshop.com/products/fsa-team-carbon-crankset-bb386-evo.html ");
		m.ln("</p>");

		m.ln("<h3>Shifters</h3>");
		m.ln("<p>");
		m.ln("SRAM Red HRD Hydraulic Disc Mechanical + SRAM Hope RX-4");
		m.ln("Rohloff uses a 2 cable grip shifter which doesn't work well with road handlebars so I investigated how to remedy this issue. ");
		m.ln("See Rohloff STI/Brifter Shifting in Engineering Challenges for more details. ");
		m.ln("The shifters came with post-mount calipers which I sold and upgraded to the SRAM Hope RX-4 flat-mount.");
		m.ln("</p>");

		m.ln("<h3>Gear Ratios</h3>");
		m.addStaticImage(Resource.IMG_ROHLOFF_GEAR_BELT);
		m.ln("<br>Rohloff: 40T front 15T rear sprocket, equivalent to 80T/30T @90RPM<br><br>");
		m.addStaticImage(Resource.IMG_ROHLOFF_GEAR_COMPACT);
		m.ln("<br>Compact: 50/34 chainring with 11-32 Shimano cassette @90RPM<br><br>");

		m.addStaticImage(Resource.IMG_ROHLOFF_GEAR_MTB);
		m.ln("<br>MTB: 32T chainring 11-46 cassette @90RPM<br><br>");
		m.ln("The Rohloff is like a an MTB with extra range, max speed is less than the compact. I'm not in the 50/11 gear often.");
		m.ln("<a target=\"_blank\" href=\"http://www.gear-calculator.com/?GR=RLSH&KB=40&RZ=15&UF=2135&TF=90&SL=2.6&UN=KMH&DV=speed&GR2=DERS&KB2=34,50&RZ2=11,12,13,14,16,18,20,22,25,28,32&UF2=2135\">Link to Set-up</a>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
