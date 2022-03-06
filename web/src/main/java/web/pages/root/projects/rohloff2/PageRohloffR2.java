package web.pages.root.projects.rohloff2;

import web.common.LocalStringBuffer;
import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.PageMapping;
import web.pages.resources.Resource;

public class PageRohloffR2 extends BasePage {

	public PageRohloffR2(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FOOTER, Resource.CSS_TOGGLE_DIV, Resource.CSS_FORMS, Resource.CSS_FLEX_LIST, Resource.CSS_TOOLTIP };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE, Resource.JS_HEADER, Resource.JS_FORMS, Resource.JS_TOGGLE_DIV, Resource.JS_TOOLTIP };

		m.addHead(css, js, "Rohloff Frame Upgrade");
//https://imgur.com/a/fbZOMGF
		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects, requestInfo);

		m.addBanner("Rohloff Bike Upgrade", "https://i.imgur.com/eHJZWCG.jpg");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/LbMY3Uh.jpg", "https://i.imgur.com/dZamJAm.jpg", "max-width:100%", null, null);
		m.addModalImage("https://i.imgur.com/evSsONK.jpg", "https://i.imgur.com/m7JgAWQ.jpg", "max-width:100%", null, null);
		m.ln("</div>");

		LocalStringBuffer gallery = new LocalStringBuffer(1024);
		gallery.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/s2iDvez.jpg", "https://i.imgur.com/eKDeQKl.jpg", "max-width:100%", null, gallery);
		m.addModalImage("https://i.imgur.com/Opx5SAL.jpg", "https://i.imgur.com/5wz8xRR.jpg", "max-width:100%", null, gallery);
		m.addModalImage("https://i.imgur.com/3kZGHHk.jpg", "https://i.imgur.com/SpIyRLF.jpg", "max-width:100%", null, gallery);
		gallery.ln("</div>");
		gallery.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/ORzM2iQ.jpg", "https://i.imgur.com/rVuhTRL.jpg", "max-width:100%", null, gallery);
		m.addModalImage("https://i.imgur.com/J4WpPiJ.jpg", "https://i.imgur.com/UptS9l2.jpg", "max-width:100%", null, gallery);
		gallery.ln("</div>");
		gallery.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/jgbBi6f.jpg", "https://i.imgur.com/q2mmb7C.jpg", "max-width:100%", null, gallery);
		m.addModalImage("https://i.imgur.com/SJAq8XY.jpg", "https://i.imgur.com/OovGYZd.jpg", "max-width:100%", null, gallery);
		m.addModalImage("https://i.imgur.com/SZPU5cK.jpg", "https://i.imgur.com/OvHqyv2.jpg", "max-width:100%", null, gallery);
		gallery.ln("</div>");
		gallery.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/7FHIE3a.jpg", "https://i.imgur.com/JUp5Xri.jpg", "max-width:100%", "Most major components except the rear wheel as it had not been built", gallery);
		m.addModalImage("https://i.imgur.com/pk268Zx.jpg", "https://i.imgur.com/B04t4xk.jpg", "max-width:100%", "Novatech D411CB Hub with Pillar Wing 20 spokes ready to be built", gallery);
		m.addModalImage("https://i.imgur.com/F6QZfyr.jpg", "https://i.imgur.com/IJrPins.jpg", "max-width:100%", "Rohloff ready to be assembled with Pillar 20 spokes", gallery);
		gallery.ln("</div>");
		gallery.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/hB4SKzL.jpg", "https://i.imgur.com/dOXfFbf.jpg", "max-width:100%", "New belt being drilled, RPM must be low or the rubber will melt", gallery);
		m.addModalImage("https://i.imgur.com/Txu58RT.jpg", "https://i.imgur.com/XyaOTAF.jpg", "max-width:100%", "Belt cut to length using scalpel and rejoined using M2.2 stainless steel screws", gallery);
		m.addModalImage("https://i.imgur.com/vTEa1Zs.jpg", "https://i.imgur.com/kKty5x2.jpg", "max-width:100%", "Finished belt, screws cut using rotary tool", gallery);
		gallery.ln("</div>");
		gallery.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/rtigsgh.jpg", "https://i.imgur.com/44O0fSd.jpg", "max-width:100%", "BB30 to BB86 converter with spacers for long spindle 92mm crankset", gallery);
		m.addModalImage("https://i.imgur.com/WXRyg31.jpg", "https://i.imgur.com/i1Zkx4K.jpg", "max-width:100%", "3D printed derailleur cable plug as it will not be used", gallery);
		gallery.ln("</div>");
		gallery.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/BFmzydn.jpg", "https://i.imgur.com/v7w4C7D.jpg", "max-width:100%", null, gallery);
		m.addModalImage("https://i.imgur.com/mqM8oUe.jpg", "https://i.imgur.com/4RlqAos.jpg", "max-width:100%", "Handlebar tape has a reflective rainbow effect under the right light conditions", gallery);
		m.addModalImage("https://i.imgur.com/qv0Bx5B.jpg", "https://i.imgur.com/6DtSfHm.jpg", "max-width:100%", "Just over 9kg, similar to the R6 build", gallery);
		gallery.ln("</div>");
		m.ln(m.getContentToggle("<b>Expand Extended Gallery</b>", gallery.toString()));

		m.ln("<h2>Frame</h2>");
		m.ln("<div class=\"paragraph\">");
		m.ln("After working with the frame it is clear that it is intended for use with electronic shifting only. ");
		m.ln("It officially supports mechanical shifting but the implementation is more of an afterthought and not well suited. ");
		m.ln("The two main cable entry points of the frame, the headset and rear triangle exposed issues with tight cable bends in these areas preventing shifting. ");
		m.ln("The second can be excused as the rear hydraulic line routing was not intended to fit an additional two extra gear cables. ");
		m.ln("For the Venge the Axle plate cannot be placed under the stay, this is because routing the cable from the hydraulic brake hole it too much of an aggressive angle. ");
		m.ln("Conversely the Yoeleo frame allows the axle plate to be in this position and have shifting work well as the cable hole is placed much closer to the centre of the stay. ");
		m.ln("In the Venge the hydraulic cable exit port is situated very close to the caliper. ");
		m.ln("</div><br>");

		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/hUt9mPR.jpeg", "https://i.imgur.com/lwTW9ff.jpg", "max-width:100%", "This is an SL7 frame but observe the join along both chain stays", null);
		m.addModalImage("https://i.imgur.com/h2k9sto.jpg", "https://i.imgur.com/T60sXRN.jpg", "max-width:100%", null, null);
		m.addModalImage("https://i.imgur.com/jJMWKW6.jpg", "https://i.imgur.com/WjGKAXJ.jpg", "max-width:100%", "I would liked to have had the Gebla under the chain stay", null);
		m.ln("</div>");
		m.ln("<div class=\"paragraph\">");
		m.ln("I also had some issues routing cables through the chainstay because they would get caught on a lip. ");
		m.ln("After many failed attempts to pass this I got a cheap USB endoscope to see what is the cause which will make it easier to be overcome rather than blindly guiding cables. ");
		m.ln("Using the hook attachment I could move the cable past the obstacle. ");
		m.ln("The frame is clearly manufactured in separate sections which are bonded together later, one such is part of the rear triangle the cause of my issue. ");
		m.ln("I discovered an image of a pre-finished SL7 frame were you can see this bond and I assume the Venge is made in a very similar way. ");
		m.ln("Cables had to be routed into the rear hydraulic brake exit port first then towards the bottom bracket and onward to the headset. ");
		m.ln("The reason is because doing it the other way round made it impossible to fish three cables through the hydraulic exit hole. ");
		m.ln("When I tried routing cables this way it did not catch the lip. ");
		m.ln("The Gebla was originally placed under the chain stay in a similar fashion to the way it was on the previous build using the Yoeleo R6 ");
		m.addLink("see here", PageMapping.ROHLOFF_PG4 + "#img2", true);
		m.ln(". Disappointedly this bend was too tight for shifting to work properly in a similar way to the headset issue. ");
		m.ln("The exit hole is simply too close and angled ");
		m.addToolTip("<b style=\"cursor: default\">inwards</b>", "<img src=\"https://i.imgur.com/lxnP8Qm.jpg\" alt=\"Gear Exit\"><p>Cables exit inward and when the Gebla is mounted under the chain stay a very tight s-bend prevents shifting from working, also notice the cable tie to prevent the shift cables from clashing with the spokes</p>", true);
		m.ln(" towards the wheel away from the Gebla. ");
		m.ln("The next option was to route cables over the chain stay and move the Gebla shift box, this required new gear outers as they were now cut too short. ");
		m.ln("</div><br>");


		m.ln("<h2>Moving A12 Rohloff to New Frame</h2>");
		m.ln("<div class=\"paragraph\">");
		m.ln("The Rohloff hub was designed well before the thru axle standard.");
		m.ln("If you look at a cut out or exploded diagram of the hub there is not enough free space for a 12mm diameter axle but does allow a Quick Release Skewer. ");
		m.addToolTip("<b style=\"cursor: default\">Rohloff Exploded View</b>", "<img src=\"https://cdn-0.sheldonbrown.com/harris/images/speedbild2.jpeg\" alt=\"Rohloff Exploded View\"><p>The axle only has enough room for a 9mm quick release skewer</p>", true);
		m.ln("The only hub with native thru axle support is from Kindernay. ");
		m.ln("Rather than redesign the hub Rohloff opted to have adapters that match the frame dropouts to allow M7 bolts to secure the hub. ");
		m.ln("One issue with this is that unlike Quick Release, there are many thru axle standards. ");
		m.addToolTip("<b style=\"cursor: default\">Thru Axle Variations</b>", "<img src=\"https://wheelbuilder.com/product_images/uploaded_images/thruaxle-detail-update.jpg\" alt=\"Thru Axle Variations\"><p>There are different thread pitches, head taper types and even lengths depending on dropout thicknesses</p>", true);
		m.ln("Total length of the thru axle can vary dramatically between manufacturers. A \"Standard\" 142x12mm Thru Axle can vary in length between 162mm and 171mm depending on the frame manufacturer. ");
		m.ln("There are also different thread pitches generally M1 or M1.5.");
		m.ln("There are two different types of attachment seat used at the interface where the skewer mates to the frame or fork which are traditional (flat) and conical");
		m.ln("These include different width, diameter, thread pitch and even the interface. ");
		m.ln("My hub has adapters for the Yoeleo R6 which uses the Shimano e-thru axle while the Venge uses a Syntace V2 interface (according to Rolhoff dropout measurement process) so new adapters would be needed.");
		m.ln("I took my bike to the nearest shop that was registered with Rohloff as a dealer and asked them if it was possible to get the new frame measured and order new adapters. ");
		m.ln("They didn't understand my request at first and later turned out they had never dealt with A12 Rohloff hubs before. ");
		m.ln("My contact at the shop got training from Rohloff on how to perform the task, later the measuring kit was sent to the shop and the procedure was done. ");
		m.ln("Disappointingly Rohloff have a minimum dropout thickness rule which the new frame ");
		m.addToolTip("<b style=\"cursor: default\">Failed</b>", "<img style=\"max-height:70vh;width:unset\" src=\"https://i.imgur.com/KllcNBP.jpg\" alt=\"Thru Axle Failure\"><p>In the Syntace V2 dropout thickness test the Venge gets a result of 49mm</p>", true);
		m.ln(". The bike shop stated to me that the minimum thickness test is 51mm while the Venge got 49mm. ");
		m.ln("Regardless I requested to order the adapter anyway without warranty and that I would take all responsibility. ");
		m.ln("When writing this article a few months later I checked the ");
		m.addLink("<b>Rohloff A12 Dropout Measurement Process</b>", "https://www.rohloff.de/fileadmin/user_upload/Rohloff-A12-_Dropout_Measurement_Process_en.pdf", true);
		m.ln(" document and there is no mention of 51mm, the Syntace V2 test on page 45 states the minimum thickness is 47mm, so the frame should have passed.");
		m.ln("</div><br>");


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
		m.addToolTip("<b style=\"cursor: default\">Praxis M30 THRU</b>", "<img src=\"https://praxiscycles.com/wp-content/uploads/DSCF3688-1024x576.jpg\" alt=\"68-4101R\"><p>The Praxis 68-4101R bottom bracket allows the use of long 30mm spindle cranks such as BB386EVO into a BB30 or PF30 frames</p>", true);
		m.ln("so I could use my existing FSA BB386 crank but the spindle is showing signs of wear which is in need of replacement. ");
		m.ln("My own fault for not taking better care. ");
		m.ln("Alloy 30mm spindles need to be cleaned regularly, the hard steel bearing makes direct contact to the softer aluminium spindle which can cause galling if not properly maintained. ");
		m.ln("So I decided to move to a similar crank using MegaExo 24 which uses a steel 24mm spindle, which as far as I can tell is directly compatible with Shimano HollowTech II. ");
		m.ln("One advantage of HollowTech II is that the spindle is steel and the bearings have a plastic cover so the spindle does not make direct contact. ");
		m.ln("A disadvantage is that the crank will be a little ");
		m.addToolTip("<b style=\"cursor: default\">heavier</b>", "<img src=\"https://i.imgur.com/Es4npYZ.jpg\" alt=\"Heavy\"><p>Left is the BB386Evo crank with 30mm alloy spindle used on the Yoeleo R6 build and right is the replacement crank with 24mm steal spindle which as just over a 100g penalty<p>", true);
		m.ln("a tradeoff for a more durable item. Cranks with alloy spindles almost become a consumable item like a chain or cassette which is not ideal. ");
		m.ln("With this in mind I got a BB30 to BB86 converter, the one I have allows the bearings to be replaced and I ordered some spare 6805 bearings and plastic top hats.");
		m.ln("The replacement FSA crankset is made for MTB so it has an effective spindle length of 92mm (86 + 5). ");
		m.ln("An issue is that the Venge frame has a 68mm, so when the BB30 to BB86 converter is installed the final width will be 86mm, 5mm of extra spindle length will need to be taken up somehow. ");
		m.ln("I fabricated 2 spacers measuring 3.5mm for the drive side and 1.5mm non-drive to take up the slack.");
		m.addToolTip("<b style=\"cursor: default\">BBB BBO-85</b>", "<img src=\"https://m.media-amazon.com/images/I/71DwILbI3OL._AC_SL1500_.jpg\" alt=\"BBB BBO-85\"><p>Later discovered the BBB BBO-85 bottom bracket which has a wider outbound bearing cups to support MTB cranks in road frames</p>", true);
		m.addToolTip("<b style=\"cursor: default\">Outbound Comparison</b>", "<img src=\"https://i.imgur.com/s0XZpoi.jpg\" alt=\"Outbound Comparison\"><p>BBB BBO-85 bottom bracket has wider cups than the ZTTO bottom bracket to accommodate for longer MTB spindle</p>", true);
		m.ln("</div><br>");


		m.ln("<h2>Headset Spacer</h2>");
		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/6fuyCVS.jpg", "https://i.imgur.com/QtGppm7.jpg", "max-width:100%", "Original spacers", null);
		m.addModalImage("https://i.imgur.com/543AWrh.png", "https://i.imgur.com/543AWrh.png", "max-width:100%", "Screenshot from FreeCAD", null);
		m.addModalImage("https://i.imgur.com/BeGrHIV.jpg", "https://i.imgur.com/T7BTLxX.jpg", "max-width:100%", "3D printed spacer after sanding", null);
		m.ln("</div>");
		m.ln("<div class=\"paragraph\">");
		m.ln("When the cables were routed I noticed very high friction in the cable. ");
		m.ln("I could change a single gear once then the return spring in the Gebla could not reset the ratchet. ");
		m.ln("Fully removing the inner cable and slowly feeding it back in I noticed a sharp increase in friction when entering the headset. ");
		m.ln("I determined this by removing the inner cable when the friction increased and measuring the length of cable that had been fed in. ");
		m.ln("Then roughly gaging where this is in the cable route. ");
		m.ln("I did a lot of investigating to the cause of the problem and discovered that cables entering the headset are at a very tight angle. ");
		m.ln("Adding slack and adjusting the outer cables did not help with the issue. ");
		m.ln("The Venge is clearly tailored to electronic shifting and not too well suited to mechanical shifting. ");
		m.ln("Looking online there is a headset for which supports mechanical shifting but my frame did not come with it. ");
		m.ln("To work around this I designed a replacement spacer to allow a smoother cable transition into the headset. ");
		m.addToolTip("<b style=\"cursor: default\">Early Prototype</b>", "<img src=\"https://i.imgur.com/7mzdUML.jpg\" alt=\"Early Headset spacer\"><p>Early revision of the headset spacer which relied on one of the original spacers</p>", true);
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
		m.addModalImage("https://i.imgur.com/xsZy6sy.jpg", "https://i.imgur.com/88V59iq.jpg", "max-width:100%", "Two part mount installed into seatpost", null);
		m.addModalImage("https://i.imgur.com/Iy77F1b.png", "https://i.imgur.com/Iy77F1b.png", "max-width:100%", "Screenshot from FreeCAD of both parts", null);
		m.addModalImage("https://i.imgur.com/aireSEc.jpg", "https://i.imgur.com/FJK1vV7.jpg", "max-width:100%", null, null);
		m.ln("</div>");
		m.ln("<div class=\"paragraph\">");
		m.ln("One interesting feature of the Venge is that it can house a Di2 junction box in the back of the seatpost such as the EW-RS910. ");
		m.addToolTip("<b style=\"cursor: default\">Di2 Junction Box</b>", "<img src=\"https://i.imgur.com/6OfI9ZR.jpg\" alt=\"Di2 Junction Box\"><p>Here is a Shmanio Di2 handlebar style junction box installed into a Venge seatpost</p>", true);
		m.ln("These are originally designed to replace a road handlebar end cap but Specialized has retrofitted the design to fit inside the seatpost, this is a neat integrated design choice. ");
		m.ln("I have looked at lights that fit into ");
		m.addToolTip("<b style=\"cursor: default\">End Caps</b>", "<img src=\"https://cdn.road.cc/sites/default/files/styles/main_width/public/images/Products/GUBLEDendcaps.jpg\" alt=\"End Cap Light\"><p>Most of these types of lights do not have an integrated rechargeable battery but need two or more AG10 or 2032 batteries</p>", true);
		m.ln(" but these do not produce much light and should be considered a complementary safety light. ");
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
		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/RVlIrQZ.jpg", "https://i.imgur.com/a6vj8T4.jpg", "max-width:100%", null, null);
		m.addModalImage("https://i.imgur.com/SnuhtDt.pngg", "https://i.imgur.com/SnuhtDt.png", "max-width:100%", "Screenshot from FreeCAD", null);
		m.addModalImage("https://i.imgur.com/4lH8Ymp.jpg", "https://i.imgur.com/kXR5v0J.jpg", "max-width:100%", "Neatly placed under the stem", null);
		m.ln("</div>");
		m.ln("<div class=\"paragraph\">");
		m.ln("The Venge has a cable clamp for tidying the cables under the stem. ");
		m.ln("There already exists an official mounting mechanism which attached to the front faceplate. ");
		m.addToolTip("<b style=\"cursor: default\">Clamp and Faceplate Mount</b>", "<img src=\"http://bikerumor.com/wp-content/uploads/2020/09/2021-specialized-tarmac-s-works-sl7-aero-handlebar-cable-routing-04.jpg\" alt=\"Di2 Junction Box\"><p>This is not from a Venge frame but the newer SL7, they are very similar in regards to the stem/headset. This shows both the faceplate Garmim mount and cable tidy clamp under the stem.</p>", true);
		m.ln("Looking at this it is possible to use this to mount a front light. ");
		m.ln("This is good if have a cycle computer but I do not currently use one. ");
		m.ln("Placing the light directly underneath the stem puts it in a more discrete position. ");
		m.ln("</div><br>");
		// front mount wip
				// For the front the biggest hurdle was the living hinge for the light mount.
				// "I tried many many different designs of hinge but they failed pretty quickly.
				// My first reaction was to reinforce the area that broke but this just moved the failure point to another area until the hinge would not flex without a large amount of force.
				// Inspecting the failures closely I noticed failure was caused by layer separation.
				// The fix was to rotate the part 90 degrees towards the build plate so that the layers were not in the same direction as the hinge.

		m.ln("<h2>Brake Caliper Change</h2>");
		m.ln("<p>");
		m.ln("Gone are the Hope RX-4, they looked excellent but I had a lot of issues with sticking pistons and they were a challenge to bleed, so I started looking into alternatives. ");
		m.ln("This led into an investigation of how hydraulics work and if it is possible to fit different calipers to the HydroR levers. ");
		m.ln("The levers use DOT fluid so I need to make sure I select DOT compatible calipers not ones designed for mineral oil. ");
		m.ln("Do not mix and match these as the seals are only designed for one type of fluid and might corrode and fail catastrophically. ");
		m.ln("</p>");

		m.ln("<h3>Hydraulic Theory</h3>");
		m.ln("<img class=\"common-static-image\" src=\"https://i.imgur.com/RzT8DP3.png\" alt=\"Hydraulic System\">");
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
		m.ln("</p>");
		
		m.ln("<h3>Brake Pads</h3>");
		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/LSdKX4s.jpg", "https://i.imgur.com/6k1MRVD.jpg", "max-width:100%", "(Top) Original SRAM brake pads, semi-metal and sintered BR-M555", null);
		m.addModalImage("https://i.imgur.com/fUaohqb.png", "https://i.imgur.com/fUaohqb.png", "max-width:100%", null, null);
		m.addModalImage("https://i.imgur.com/0El6Cls.jpg", "https://i.imgur.com/ex5DQX6.jpg", "max-width:100%", "Pads when the axle hole are aligned at the top", null);
		m.ln("</div>");

		m.ln("<p>");
		m.ln("When looking to purchase some extra brake pads I noticed that Shimano BR-M555 pads had a very similar shape to the pads for the HydroR. ");
		m.ln("The shape is unique as most other brake pads have the pad axle hole in the centre rather than off to an edge. ");
		m.ln("The BR-M555 is a few mm taller than the HydroR, the springs are very similar and from my testing are interchangeable making then compatible with either type of pad. ");
		m.ln("If you have a wide rotor then you can take advantage of the taller BR-M555 brake pads. ");
		m.ln("One thing to note is that with the same pad material there will not be an increase in braking power with a larger pad. ");
		m.ln("This is because the force from pistons will not change and will simply be spread over a larger area. ");
		m.ln("The advantage over using the larger BR-M555 is longer pad life and better heat management. ");
		m.ln("The HydroR braking surface has an approximate area of 351mm<sup>2</sup> while the BR-M555 is 18.5% bigger at 416mm<sup>2</sup>. ");
		m.ln("The costs of either type brake pad are similar but there are fewer choices available for the BR-M555 as the Shimano Deore C900 caliper they are made for has long been defunct. ");
		m.ln("</p>");

		m.ln("<h3>SRAM Hood Tear</h3>");
		m.ln("<div class=\"paragraph\">");
		m.ln("After a few months of use the inner section of the hoods began to tear with the previous Yoeleo build. ");
		m.ln("This is caused by the shift lever making repeated contact with the rubber during each gear change. ");
		m.ln("On ");
		m.addLink("<b>Weightweenies</b>", "https://weightweenies.starbike.com/forum/viewtopic.php?t=163553", true);
		m.ln(" other people have had a similar problem ");
		m.ln(" typically only on the right shifter. ");
		m.ln("This is because this lever controls the rear derailleur which has much more frequent use than the left shifter controlling the front derailleur. ");
		m.ln("Explaining why this happened to these people right hand side first. ");
		m.ln("For me both levers were affected because they are in constant use with the Gebla, right shifter to move to a harder gear and left to an easier. ");
		m.addLink("<b>Bikerumor</b>", "https://bikerumor.com/hack-how-to-prevent-sram-doubletap-shifter-levers-from-sticking/", true);
		m.ln(" published an article stating that some people were having issues of sticking shifters and even suggested cutting the hood to alleviate the problem. ");
		m.ln("I adapted a similar approach with new hoods and carefully cut a hole so that the lever can move freely. ");
		m.ln("This is poor design from SRAM, designed to fail. ");
		m.ln("</div>");

		m.ln("<h3>Shimano Shifter With Gebla Investigation</h3>");
		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://i.imgur.com/xVgxZyd.jpg", "https://i.imgur.com/xVgxZyd.jpg", "max-width:100%", "Proprietary bolt from Shimano, the safety pin can be easily pushed out", null);
		m.addModalImage("https://i.imgur.com/004ETtI.png", "https://i.imgur.com/004ETtI.png", "max-width:100%", null, null);
		m.addModalImage("https://i.imgur.com/cfva9uu.jpg", "https://i.imgur.com/cfva9uu.jpgg", "max-width:100%", "Right shifter with assembly removed", null);
		m.ln("</div>");
		m.ln("<div class=\"paragraph\">");
		m.ln("Ordering a pair Shimano Dura Ace R9120 shifters I wanted to determine if it is possible to use them with the Gebla. ");
		m.ln("I could not find any materials from Shimano or other places online on how disassemble/repair these shifters. ");
		m.ln("I created a custom tool to interface with the four tooth profile of the bolt and adapted it to a 5mm hex. ");
		m.ln("The bolt is soft and I probably make from an Aluminium alloy, one thing to note is the left shifter bolt is left hand threaded, right is right handed thread, the safety pin can be easily removed. ");
		m.ln("The older ");
		m.addLink("<b>ST-6700</b>", "https://youtu.be/wJj6dASBMN0?t=80", true);
		m.ln(" shifter uses a common ");
		m.addToolTip("<b style=\"cursor: default\">Hex Bolt</b>", "<img src=\"https://i.imgur.com/K5mGamy.jpg\" alt=\"68-4101R\"><p>Here the ST-6700 shifter uses a hex bolt for securing the shifting assembly</p>", true);
		m.ln(" not sure why a proprietary bolt is needed other than to limit user repairability or maybe for a marginal weight saving. ");
		m.ln("The left shifter only needs a single pawl to be disabled and can be done easily with removal of the pawl spring. ");
		m.ln("It is a similar story the right shifter, but two pawls need to be disabled. ");
		m.ln("The first can be done in a similar fashion to the left shifter but the other pawl and spring is fixed in place by what looks like a dowel pin. ");
		m.ln("No amount of force I used could budge it, I placed an obstruction to stop the pawl engaging but it would only work a few times before it would slip. ");
		m.ln("There is destructive method, using a rotary tool with a cutting wheel the pawl could be removed permanently. ");
		m.ln("Shimano shifters use the larger lever for down shifting and braking while the smaller one up shifts. ");
		m.ln("If the two pawls were disabled then the smaller shifter would not work, this is as intended. ");
		m.ln("I could leave it free flowing, remove it or bond it to the larger lever. ");
		m.ln("One bigger issue is that the cable pull of the Shimano is approximately 2-3mm less than the SRAM, as a result it is likely that a single lever throw would only change a maximum of one gear. ");
		m.ln("The lever was never tested with the Gebla to verify this is the case as I could not find a non-destructive way to get the desired result. ");
		m.ln("When using the SRAM shifter a short throw can change one gear, continue the stroke to move a second gear. ");
		m.ln("I reassembled the shifters and returned them. ");
		m.ln("I would have preferred to use a Shimano shifter as mineral oil is non-corrosive and lasts a lot longer. ");
		m.ln("</div>");
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
