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
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FOOTER, Resource.CSS_TOGGLE_DIV, Resource.CSS_FORMS, Resource.CSS_FLEX_LIST, Resource.CSS_TOOLTIP };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE, Resource.JS_HEADER, Resource.JS_FORMS, Resource.JS_TOGGLE_DIV, Resource.JS_TOOLTIP };

		m.addHead(css, js, "Test new page 2");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects, requestInfo);

		m.addBanner("Light Mounts",
				"https://www.campagnolo.com/media/immagini/9593_z_campagnolo-super-record-chain-MY2019-banner.jpg");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloff2PageSelector(m, 2);

		
		m.ln("<h2>Frame</h2>");
		m.ln("<p>");
		m.ln("");
		m.ln("");
		m.ln("");
		m.ln("");
		m.ln("");
		m.ln("");
		m.ln("");
		m.ln("</p><br>");


		m.ln("<h2>Bottom Bracket</h2>");
		m.ln("<p>");
		m.ln("The Venge comes with a BB30 bottom bracket, there is an aluminium insert that houses the bearings. ");
		m.ln("One issue with this standard is that the bearings are close together in the 68mm width shell. ");
		m.ln("This exposes them to additional strain which can lead to a lower lifespan, other standards such as BB86 place the bearings further apart. ");
		m.ln("BB30 has had numerous complaints throughout its history with issues such as creaking and the aforementioned short bearing life. ");
		m.ln("This is typically caused by poor manufacturing tolerances from frame manufacturers resulting in bad fit or even misalignment causing premature bearing failure. ");
		m.ln("</p>");

		m.ln("<div class=\"paragraph\">");
		m.ln("To avoid these issues I looked into a bottom bracket conversion kit. ");
		m.ln("There exists BB30 to BB386 converters such as the ");
		m.addToolTip("<b style=\"cursor: default\">Praxis M30 THRU</b>", "<img src=\"https://praxiscycles.com/wp-content/uploads/DSCF3688-1024x576.jpg\" alt=\"68-4101R\"><p>Prxis 68-4101R converts BB30/PF30 bottom brackets to allow use of wide 30mm spindle cranks such as BB386</p>", true);
		m.ln("so I could use my existing FSA BB386 crank but the spindle is showing signs of wear which is in need of replacement. ");
		m.ln("My own fault for not taking better care. ");
		m.ln("Alloy 30mm spindles need to be cleaned regularly, the hard steel bearing makes direct contact to the softer aluminium spindle which can cause galling if not properly maintained. ");
		m.ln("So I decided to move to a similar crank using MegaExo 24 which uses a steel 24mm spindle, which as far as I can tell is directly compatible with Shimano HollowTech II. ");
		m.ln("One advantage of HollowTech II is that the spindle is steel and the bearings have a plastic cover so the spindle does not make direct contact. ");
		m.ln("A disadvantage is that the crank will be a little heavier, a tradeoff for a more durable item. ");
		m.ln("Cranks with alloy spindles almost become a consumable item like a chain or cassette which is not ideal. ");
		m.ln("With this in mind I got a BB30 to BB86 converter, the one I have allows the bearings to be replaced and I ordered some spare 6805 bearings and plastic top hats.");
		m.ln("The replacement FSA crankset is made for MTB so it has an effective spindle length of 91mm (86 + 5). ");
		m.ln("An issue is that the Venge frame has a 68mm, so when the BB30 to BB86 converter is installed the final width will be 86mm, 5mm of extra spindle length will need to be taken up somehow. ");
		m.ln("I fabricated 2 spacers measuring 3.5mm for the drive side and 1.5mm non-drive to take up the slack.");
		m.addToolTip("<b style=\"cursor: default\">BBB BBO-85</b>", "<img src=\"https://m.media-amazon.com/images/I/71DwILbI3OL._AC_SL1500_.jpg\" alt=\"BBB BBO-85\"><p>Later discovered the BBB BBO-85 bottom bracket which has a wider outbound bearing cups to support MTB cranks in road frames</p>", true);
		m.addToolTip("<b style=\"cursor: default\">Outbound Comparison</b>", "<img src=\"https://i.imgur.com/s0XZpoi.jpg\" alt=\"Outbound Comparison\"><p>BBB BBO-85 bottom bracket has wider cups than the ZTTO bottom bracket to accommodate for longer MTB spindle</p>", true);
		m.ln("</div><br>");

		m.ln("<h2>A12</h2>");
		//m.addModalImage("https://dbyvw4eroffpi.cloudfront.net/product-media/KNP/1000/1000/Praxis-Works-M30-Bottom-Bracket-BB86-BB92.jpg", "https://dbyvw4eroffpi.cloudfront.net/product-media/KNP/1000/1000/Praxis-Works-M30-Bottom-Bracket-BB86-BB92.jpg", "max-width:30%", "The bearing ID is 28mm");

		m.ln("<div class=\"paragraph\">");
		m.ln("The Rohloff hub was designed well before the thru axle standard.");
		m.ln("If you look at a cutout or exploded diagram of the hub there is not enough free space for a 12mm diameter axle but does allow a Quick Release Skewer. ");
		m.addToolTip("<b style=\"cursor: default\">Rohloff Exploded View</b>", "<img src=\"https://cdn-0.sheldonbrown.com/harris/images/speedbild2.jpeg\" alt=\"Rohloff Exploded View\"><p>The axle only has enough room for a 9mm quick release skewer</p>", true);
		m.ln("Rather than redesign the hub Rohloff opted to have adapters that match the frame dropouts to allow M7 bolts to secure the hub. ");
		m.ln("One issue with this is that unlike Quick Release, there are many thru axle standards. ");

		m.ln("<br><img class=\"common-static-image\" src=\"https://wheelbuilder.com/product_images/uploaded_images/thruaxle-detail-update.jpg\" alt=\"Thru Axle Standards\"><br>");
		m.ln("Total length of the Thru Axle can vary dramatically between manufacturers. A \"Standard\" 142x12mm Thru Axle can vary in length between 162mm and 171mm depending on the frame manufacturer. ");
		m.ln("Modern Thru Axles thread directly into frames/forks but early rear thru axles needed a nut. There are also different thread pitches generally m1 or m1.5.");

		m.ln("There are two different types of attachment seat used at the interface where the skewer mates to the frame or fork which are traditional (flat) and conical");

		m.ln("These include different width, diameter, thread pitch and even the interface. ");
		m.ln("My hub has adapters for the Yoeolo? RD25 which uses a Shimano type 142mm x 12mm thru axle.");
		m.ln("The Venge frame is still 142 x 12mm but has a Syntace V2 interface so new adapters would be needed. ");
		m.ln("I took my bike to the nearest shop that was registered with Rohloff as a dealer and asked them if it was possible to get the new frame measured and order new adapters. ");
		m.ln("They didn't understand my request at first and later turned out they had never dealt with A12 Rohloff hubs before. ");
		m.ln("My contact at the shop got training from Rohloff on how to perform the task, later the measuring kit was sent to the shop and the procedure was done. ");
		m.ln("Disappointingly Rohloff have a minimum dropout thickness rule which the new frame failed. ");
		m.ln("I requested to order the adapter anyway without warranty and that I would take all responsibility.");
		m.ln("</div><br>");


		m.ln("<h2>Headset</h2>");
		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/6fuyCVS.jpg", "https://i.imgur.com/QtGppm7.jpg", "max-width:100%", "Original spacers");
		m.addModalImage("https://i.imgur.com/BeGrHIV.jpg", "https://i.imgur.com/T7BTLxX.jpg", "max-width:100%", "3D printed spacer after sanding");
		m.addModalImage("https://i.imgur.com/543AWrh.png", "https://i.imgur.com/543AWrh.png", "max-width:100%", "Screenshot from FreeCAD");
		m.ln("</div>");
		m.ln("<div class=\"paragraph\">");
		m.ln("When the cables were routed I noticed very high friction in the cable. ");
		m.ln("I did a lot of investigating to the cause of the problem and discovered that cables entering the headset are at a very tight angle. ");
		m.ln("The Venge is clearly tailored to electronic shifting and not too well suited to mechanical shifting. ");
		m.ln("Looking online there is a headset for which supports mechanical shifting but my frame did not come with it and the kit is expensive for a piece of plastic. ");
		m.ln("To work around this I designed a replacement spacer to allow a smoother cable transition into the headset. ");
		m.addToolTip("<b style=\"cursor: default\">Early Prototype</b>", "<img src=\"https://cdn-0.sheldonbrown.com/harris/images/speedbild2.jpeg\" alt=\"Early Headset spacer\"><p>Early resvision of the headset spacer</p>", true);
		m.ln(" This needed a few revisions to match the unique shape. ");
		
		// headset
		// 
		// When the cabled were routed I noticed very high friction in the cable.
		// I could change a single gear one on the Rohloff then the return spring was not strong enough to reset the ratchet mechanism of the Rohbox Gebla allow a second change.
		//So it was unusable/
		// i did a lot of investigation to the cause f the problem and discovered that cables entering the headset are at a very tight angle.
		// The Venge is tailored to electronic shifting. To alleviate this I designed a replacement spacer to allow a smother cable transition into the headset.
		// This needed a few revisions to match the unique shape.
		// In the non-drive chain stay there is a lip which makes routing cables through there difficult.
		// It looks like the bottom bracket area and rear triangle are built separately then joined together.
		// I used a cheap endoscope which has a hook on the end which I used to move cables
		m.ln("</div><br>");

		m.ln("<h2>Rear Light Mount</h2>");
		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/xsZy6sy.jpg", "https://i.imgur.com/88V59iq.jpg", "max-width:100%", "Two part mount installed into seatpost");
		m.addModalImage("https://i.imgur.com/cp2ENTk.png", "https://i.imgur.com/cp2ENTk.png", "max-width:100%", "Screenshot from FreeCAD of both parts");
		m.addModalImage("https://complianz.io/wp-content/uploads/2019/03/placeholder-300x202.jpg", "https://complianz.io/wp-content/uploads/2019/03/placeholder-300x202.jpg", "max-width:100%", "Pads when the axle hole are aligned at the top");
		m.ln("</div>");
		m.ln("<div class=\"paragraph\">");
		m.ln("One interesting feature of the Venge is that it can house a Di2 junction box in the back of the seatpost such as the EW-RS910. ");
		m.addToolTip("<b style=\"cursor: default\">Di2 Junction Box</b>", "<img src=\"https://i.imgur.com/6OfI9ZR.jpg\" alt=\"Di2 Junction Box\"><p>Here is a Shmanio Di2 handlebar style junction box installed into a Venge seatpost</p>", true);
		m.ln("These are originally designed to replace a road handlebar end cap but Specialized has retrofitted the design to fit inside the seatpost, this is a neat integrated design choice. ");
		m.ln("I have looked at lights that fit into end caps (image?) but these do not produce much light and should be considered a complementary safety light. ");
		m.ln("Another option is a saddle mounted light, this is what I used in the original bike build, they are discrete and not very protruding. ");
		m.ln("One issue is that the position of the light is so high that it can easily be covered by a coat or bag. ");
		m.ln("This is not a big issue but I wanted to create a much neater and integrated design. ");
		m.ln("As I am not using Di2 rather than fit the included blank I thought it would be a good idea to repurpose this into a rear light mount. ");
		m.ln("My design is in two parts, this is because I decided to reuse the existing cover. ");
		m.ln("The first is a direct replacement for the junction box, it allows the second part which is the light mount to be secured to the seatpost via 3 screw holes. ");
		m.ln("PETG was used for both parts as it is more suitable for outdoor use as it does not degrade in UV, unlike PLA. ");
		m.ln("The print direction of the mount is critical and needs to parallel to the living hinge or it will fail quickly. ");
		m.addToolTip("<b style=\"cursor: default\">Print Direction</b>", "<img src=\"https://i.imgur.com/O1ZIb0c.png\" alt=\"Print Direction\"><p>For a small part a brim was needed for good bed adhesion. Tree supports were used as they were much easier to remove</p>", true);
		m.ln(" This is not to best orientation for the rest of the part as it results in a lot of support material.");
		m.ln("</div><br>");

		m.ln("<h2>Front Light Mount</h2>");
		m.ln("<p>");
		// front mount wip
				// For the front the biggest hurdle was the living hinge for the light mount.
				// "I tried many many different designs of hinge but they failed pretty quickly.
				// My first reaction was to reinforce the area that broke but this just moved the failure point to another area until the hinge would not flex without a large amount of force.
				// Inspecting the failures closely I noticed failure was caused by layer separation.
				// The fix was to rotate the part 90 degrees towards the build plate so that the layers were not in the same direction as the hinge.
		m.ln("</p><br>");

		m.ln("<h2>Shimano Shifter with Rohbox Gebla</h2>");

		m.ln("<h2>Brake Caliper Change</h2>");
		m.ln("<p>");
		m.ln("Gone are the Hope RX-4, they looked excellent but I had a lot of issues with sticking pistons and they were a challenge to bleed, so I started looking into alternatives. ");
		m.ln("This led into an investigation of how hydraulics work and if it is possible to fit different calipers to the HydroR levers. ");
		m.ln("The levers use DOT fluid so I need to make sure I select DOT compatible calipers not ones designed for mineral oil. ");
		m.ln("Do not mix and match these as the seals are only designed for one type of fluid and might corrode and fail catastrophically. ");
		m.ln("</p>");
		m.ln("<h3>!Tried with Shimano!</h3>");

		m.ln("<h3>Hydraulic Theory</h3>");
		m.ln("<img class=\"common-static-image\" src=\"https://i.imgur.com/RzT8DP3.png\" alt=\"Hydraulic System	\">");
		m.ln("<p>");
		m.ln("This is some background information on how basic hydraulics work in order to apply this knowledge to determine if it is possible to mix and match levers and calipers. ");
		m.ln("In this example the surface area of B is 5 times greater than A. So an input force of 30 Newtons f<sub>1</sub> results in an output force 150 Newtons f<sub>2</sub> which is calculated: <span style=\"white-space:nowrap;\">30 &times; 5 = 150.</span>");
		m.ln("This comes at a cost, if A moves down 25cm then B only moves 5cm. So you have traded a force amplification for a reduction in travel. ");
		
		m.ln("</p>");

		m.ln("<h3>Lever and Caliper Compatibility</h3>");

		m.ln("<div class=\"list-container\">");
		m.ln("<div class=\"list-group\">");
		m.ln("		<img src=\"https://i.imgur.com/HZNhVso.jpeg\" alt=\"SRAM HydroR\">");
		m.ln("		<b>SRAM Red HydroR</b>");
		m.ln("		<span>Release date: 2014</span>");
		m.ln("		<span>Mechanical only <i>(Rohbox compatible)</i></span>");
		m.ln("		<span>Reservoir and master cylinder size unknown</span>");
		m.ln("</div>");
		m.ln("<div class=\"list-group\">");
		m.ln("		<img src=\"https://i.imgur.com/Z2MGmvF.jpeg\" alt=\"SRAM AXS\">");
		m.ln("		<b>SRAM Red AXS</b>");
		m.ln("		<span>Release date: April 2019</span>");
		m.ln("		<span>Electronic only <i>(Rohbox incompatible)</i></span>");
		m.ln("		<span>Bigger reservoir and master cylinder for larger pistons?</span>");
		m.ln("</div>");
		m.ln("</div>"); // list-container

		m.ln("<p>");
		m.ln("The size of the SRAM HydroR master cylinder area is unknown (A), but we can calculate (B) the surface area at the caliper end. ");
		m.ln("I can make a best guess with a constant (A) and see the effects of different calipers assuming the reservoir is of sufficient size. ");
		m.ln("The HydroR caliper has 2 18mm pistons, so we can calculate the surface area on one and multiply it by 2 to get the formula: 2&#960;r<sup>2</sup>.");
		m.ln("Manufacturers such as Shimano and SRAM do not provide a compatibility list and explicitly state no compatibility between models even in their own product lines. ");
		m.ln("If manufacturers published master cylinder sizes and resviour sizes you could make reasonable decisions to mix and match levers and calipers of the same type of hydrailic fluid.");
		m.ln("</p>");

		m.ln("<div class=\"list-container\">");

		m.ln("	<div class=\"list-group\">");
		m.ln("		<img src=\"https://i.imgur.com/yGx0clq.jpeg\" alt=\"RAM HydroR\">");
		m.ln("		<b>SRAM HydroR</b>");
		m.ln("		<span>2 x 18mm diameter pistons</span>");
		m.ln("		<span style=\"border-bottom: 5px solid rgba(0,128,255,0.5);white-space: nowrap;\">2&#960;9<sup>2</sup> = <b>508.9mm<sup>2</sup></b></span>");
		m.ln("	</div>");
		
		m.ln("	<div class=\"list-group\">");
		m.ln("		<img src=\"https://i.imgur.com/r4Uk49Z.jpeg\" alt=\"SRAM AXS HRD\">");
		m.ln("		<b>SRAM AXS HRD</b>");
		m.ln("		<span>2 x 21mm pistons</span>");
		m.ln("		<span style=\"border-bottom: 5px solid rgba(255,128,0,0.5);white-space: nowrap;\">2&#960;10.5<sup>2</sup> = <b>692.7mm<sup>2</sup></b></span>");
		m.ln("	</div>");

		m.ln("	<div class=\"list-group\">");
		m.ln("		<img src=\"https://i.imgur.com/QPpAPN9.jpeg\" alt=\"Hope SRAM RX-4\">");
		m.ln("		<b>Hope SRAM RX-4</b>");
		m.ln("		<span>2 x 11mm pistons</span>");
		m.ln("		<span>2 x 14mm pistons</span>");
		m.ln("		<span style=\"border-bottom: 5px solid rgba(0,128,255,0.5);white-space: nowrap;\">(2&#960;5.5<sup>2</sup>) + (2&#960;7<sup>2</sup>) = <b>497.9mm<sup>2</sup></b></span>");
		m.ln("	</div>");

		m.ln("	<div class=\"list-group\">");
		m.ln("		<img src=\"https://i.imgur.com/1EvlDGn.jpeg\" alt=\"Hope SRAM RX-4+\">");
		m.ln("		<b>Hope SRAM RX-4+</b>");
		m.ln("		<span>2 x 14mm pistons</span>");
		m.ln("		<span>2 x 16mm pistons</span>");
		m.ln("		<span style=\"border-bottom: 5px solid rgba(255,128,0,0.5);white-space: nowrap;\">(2&#960;7<sup>2</sup>) + (2&#960;8<sup>2</sup>) = <b>710.0mm<sup>2</sup></b></span>");
		m.ln("	</div>");

		m.ln("	<div class=\"list-group\">");
		m.ln("		<img src=\"https://i.imgur.com/t12nsPc.jpeg\" alt=\"Hope X2 Flat Mount\">");
		m.ln("		<b>Hope X2 Flat Mount</b>");
		m.ln("		<span>2 x 22mm pistons</span>");
		m.ln("		<span style=\"border-bottom: 5px solid rgba(255,255,255,0);white-space: nowrap;\">2&#960;11<sup>2</sup> = <b>760.3mm<sup>2</sup></b></span>");
		m.ln("	</div>");

		m.ln("</div>"); // list-container

		m.ln("<p>");
		m.ln("The original Hope RX-4 SRAM has a similar surface area to the original calipers highlighted in blue above which makes sense as Hope advertised the RX-4 SR as a direct replacement. ");
		m.ln("There is a revised model known as the RX-4+ which uses bigger pistons for a total increased area of ~40%.");
		m.ln("I contacted Hope and they said that the RX-4+ will work fine with both the newer AXS and older HydroR levers. ");
		m.ln("This is interesting as the new AXS caliper has 21mm pistons and a similar area to the RX-4+ and likely intentional highlighted in orange above. ");
		m.ln("I contacted Hope and they said that the RX-4+ will work fine with both the newer and older SRAM levers. ");
		m.ln("The size piston surface difference is quite big and I'm not convinced the older levers which are designed for 18mm pistons would work well with the RX-4+. ");
		m.ln("Taking Hope at their word I looked at if it is possible to use the Hope X2 flat mount caliper. ");
		m.ln("It is even larger but not too dissimilar to the RX-4+ being 7% bigger. ");
		m.ln("Contacting Hope they recommended against the X2 as the reservoir may be too small. ");
		m.ln("Rather than risk getting the X2 and not being able to return a used caliper I got a new pair of the original flat mount calipers.");
		m.ln("</p><br>");
		
		m.ln("<h3>Brake Pads</h3>");
		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/LSdKX4s.jpg", "https://i.imgur.com/6k1MRVD.jpg", "max-width:100%", "(Top) Original SRAM brake pads, semi-metal and sintered BR-M555");
		m.addModalImage("https://i.imgur.com/fUaohqb.png", "https://i.imgur.com/fUaohqb.png", "max-width:100%", null);
		m.addModalImage("https://i.imgur.com/0El6Cls.jpg", "https://i.imgur.com/ex5DQX6.jpg", "max-width:100%", "Pads when the axle hole are aligned at the top");
		m.ln("</div>");

		m.ln("<p>");
		m.ln("When looking to purchase some extra brake pads I noticed that Shimano BR-M555 pads had a very similar shape to the pads for the HydroR. ");
		m.ln("The shape is unique as most other brake pads have the pad axle hole in the centre rather than off to an edge. ");
		m.ln("The BR-M555 is a few mm taller than the HydroR, the springs are very similar and from my testing are interchangeable making then compatible with either type of pad. ");
		m.ln("If you have a wide rotor then you can take advantage of the taller BR-M555 brake pads. ");
		m.ln("One thing to note is that with the same pad material there will not be an increase in braking power with a larger pad. ");
		m.ln("This is because the force from pistons will not change and will simply be spread over a larger area. ");
		m.ln("The advantage over using the larger BR-M555 is longer pad life and better heat management. ");
		m.ln("The costs of either type ares similar but there are fewer choices available for the BR-M555 as the Shimano Deore C900 caliper they are made for is long defunct. ");
		m.ln("</p>");
		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addCommentsSectionAsync();
		m.addFooter(requestInfo);

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
