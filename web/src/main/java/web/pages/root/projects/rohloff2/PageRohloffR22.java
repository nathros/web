package web.pages.root.projects.rohloff2;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;
import web.pages.root.projects.rohloff.RohloffUtils;

public class PageRohloffR22 extends BasePage {

	public PageRohloffR22(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE, Resource.JS_HEADER };

		m.addHead(css, js, "Test new page 2");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("new title 2",
				"https://www.campagnolo.com/media/immagini/9593_z_campagnolo-super-record-chain-MY2019-banner.jpg");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloff2PageSelector(m, 2);

		m.ln("<h2>title</h2>");
		
		
		
		
		
		
		m.ln("<h2>Venge 2020 Frame</h2>");
		m.ln("<p>");
		m.ln("This frame was selected because of its full internal cable routing which the Miracle R?? does not have. ");
		m.ln("</p>");
		
		
		
		m.ln("<br><h2>Rear Light Mount</h2>");
		m.ln("<p>");
		m.ln("<div class=\"modal-container-root\">");
		m.addModalImage("https://cdn.road.cc/sites/default/files/specialized-s-works-venge-seat-post.jpg", "https://cdn.road.cc/sites/default/files/specialized-s-works-venge-seat-post.jpg", "max-width:100%", null);
		m.addModalImage("https://1.bp.blogspot.com/-RiV6G7qBb00/XmHlo5qRW2I/AAAAAAAAuxQ/x_qLOvR584MLTF7aAw1smP7LQxhotrBcQCLcBGAsYHQ/s1600/3D%2BEXERCISES%2B11-20_9.png", "https://1.bp.blogspot.com/-RiV6G7qBb00/XmHlo5qRW2I/AAAAAAAAuxQ/x_qLOvR584MLTF7aAw1smP7LQxhotrBcQCLcBGAsYHQ/s1600/3D%2BEXERCISES%2B11-20_9.png", "max-width:100%", null);
		m.addModalImage("https://i.all3dp.com/cdn-cgi/image/fit=cover,w=1284,h=722,gravity=0.5x0.5,format=auto/wp-content/uploads/2018/04/26155007/an-example-temperature-tower-robomaniacthingiverse-180409.jpg", "https://i.all3dp.com/cdn-cgi/image/fit=cover,w=1284,h=722,gravity=0.5x0.5,format=auto/wp-content/uploads/2018/04/26155007/an-example-temperature-tower-robomaniacthingiverse-180409.jpg", "max-width:100%", null);
		m.ln("</div>");
		
		m.l("The Specialized Venge seatpost can house a Shimano Di2 junction box such as the EW-RS910. ");
		m.l("These are originally designed to replace a road handlebar end cap but Specialized has retro fitted the design to fit inside the seatpost, this is a neat intergrated design choice. ");
		m.l(" ");
		
		m.l("<br><br>It maybe easier to use a light specificaly designed for endcaps but these lights have a few issues. ");
		m.l("They are very small and not partically bright, as such should only be used as a safety light. ");
		
		m.l("Saddle rail mounted lights are available and this is what I used in the original bike build, they are discrete and not very protusruhg. ");
		m.l("One issue is that the position of the light is so high that it can easily be covered by a coat or bag. ");




		m.ln("<br><h2>Bottom Bracket</h2>");
		m.ln("<p>");
		m.addModalImage("https://dbyvw4eroffpi.cloudfront.net/product-media/KNP/1000/1000/Praxis-Works-M30-Bottom-Bracket-BB86-BB92.jpg", "https://dbyvw4eroffpi.cloudfront.net/product-media/KNP/1000/1000/Praxis-Works-M30-Bottom-Bracket-BB86-BB92.jpg", "max-width:30%", "The bearing ID is 28mm");
		m.l("The Venge comes with a BB30 bottom bracket, with this is standard the bearings are inside the frame and are quite close together in the 68mm shell.");
		m.l("BB30 has had numerious compaints with issues such as creaking and poor bearing life. ");
		m.l("This is attriputed to many reasons such as poor manufacturing tollerances from frame manufactures, poor bearing interference fit or even misalingment causing premature bearing failure. ");
		m.l("The close proximiety of each bearing which exhasabates load doesn't help either. ");
		m.l("In order to use my existing BB386 crank a bottom bracket conversion will need to be made.");
		m.l("I could not find many BB30 to longer axle 30mm spindles, most are BB30 to Shimano BB86.");
		m.l("Praxis do manufacture a BB30 to M30 converter. M30 is similar to GXP in that the non-drive slide spindle is 2mm smaller than drive side. In this case 30mm drive and 28mm non-drive");
		m.l("I ordered a Praxis M30 bottom bracket, the 68-4001R. Doing some reasearch beforehand I determined that M30 uses standard 6806 bearings with a 1mm stepdown shim for the non-drive side");
		m.l("I was able to press out both bearings and press in standard 6806 bearings");
		
		
		m.ln("<p>");
		//When it was desieded to use a crankset with a steel 24mm axle I had to get a new 
		
		// Wheels Manufacturing BB30 to Shimano 24mm,
		// The FSA crankset is made for MTB so had an effective spindle length of 91mm (86 + 5) rather than the usual 86mm.
		// The fix for this was to get 5mm worth of spindle spacers. Using the 3D printer two were made measuring 3.5mm for the drive side and 1.5mm non-drive.
		// Worried about flex with spacer between bottom bracket and 
		m.ln("</p>");
		
		
		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter(requestInfo);

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
