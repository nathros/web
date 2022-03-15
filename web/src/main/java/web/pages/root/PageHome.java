package web.pages.root;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.PageMapping;
import web.pages.resources.Resource;

public class PageHome extends BasePage {

	public PageHome(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_H_SECTION, Resource.CSS_TABS, Resource.CSS_MODAL_IMAGE, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE, Resource.JS_HEADER };

		m.addHead(css, js, "Home Page");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Home, requestInfo);
		m.addBannerHomeAnimated(Resource.IMG_BANNER_1);
		//m.addBannerHomeAnimated("");

		//// https://i.imgur.com/pwDNLvY.jpg
		// https://ma-hub.imgix.net/wp-images/2019/11/17203220/final-cut-pro-missing-file.jpg
		// https://www.mtbr.com/threads/bontrager-race-lite-serial-number.316277/
		m.ln("<div class=\"common-content\" style=\"margin-top:-20.5625rem\">");
		m.ln("	<div class=\"card card-home\">");
		m.ln("		<div style=\"display: flex;flex-direction: column;justify-content: center;height:16.5625rem\">");
		m.ln("			<h1 style=\"text-align:center\">Technology With A Difference</h1>");
		m.ln("			<h4 style=\"text-align:center\">Enabling tight software and hardware integration</h4>");
		//m.ln("		<p style=\"text-align:justify\">Welcome to a journey of an engineer</p>");
		m.ln("		</div>");
		m.ln("	</div>"); // card
		
		m.ln("<br><br>");
		
		m.ln("		<div class=\"tab-container\">");
		m.ln("			<input type=\"radio\" id=\"tab-1\" name=\"tab-group1\" checked>");
		m.ln("			<input type=\"radio\" id=\"tab-2\" name=\"tab-group1\">");
		m.ln("			<div class=\"tab\">");
		m.ln("				<ul>");
		m.ln("					<li class=\"tab-wrapper\">");
		m.ln("						<ul>");
		m.ln("							<li id=\"tab-id-1\"><label for=\"tab-1\"><div>Embedded Software Contracting</div></label><div class=\"shadow-cover\"></div></li>");
		m.ln("							<li id=\"tab-id-2\"><label for=\"tab-2\"><div>3D Printing Service</div></label><div class=\"shadow-cover\"></div></li>");
		m.ln("						</ul>");
		m.ln("					</li>"); // tab-wrapper
		m.ln("				</ul>");
		m.ln("			</div>"); // tab
		m.ln("			<div class=\"tab-content-container\">"); // replace container


		m.ln("		<div id=\"container-tab-1\" class=\"tab-animated\">");
		m.ln("		<div class=\"horizontal-section-container-left\" style=\"\">");
		m.ln("		<img class=\"horizontal-section-image\" src=\"https://i.ibb.co/r27vLqT/FOHDVjQ.webp\" alt=\"\">");
		m.ln("		<p class=\"horizontal-section-text-left horizontal-section-clear\">");
		m.ln("			<b>Atmel SAM D10 Xplained Mini</b><br><br>");
		m.ln("			Embedded software can be very simple, such as that used for controlling lighting in homes, and can run on an 8-bit microcontroller with just a few kilobytes of memory, or it can be quite complex such as the software running all of the electronic components of a modern smart car, complete with climate controls, automatic cruising and collision sensing, as well as control navigations. Complex embedded software can also be found in aircraft avionics systems, in very complex fly-by-wire systems used in fighter planes and even in missile guidance systems.");
	
		m.ln("		</p>");
		m.ln("	</div>");
		m.ln("		</div>"); // container-tab-1

		
		
		m.ln("		<div id=\"container-tab-2\" class=\"tab-animated\">");
		m.ln("		<div class=\"horizontal-section-container-right\" style=\"\">");
		m.ln("		<div class=\"horizontal-section-text-right horizontal-section-clear\">");
		m.ln("			<p>");
		m.ln("Our 3D printing service is used to fabricate high quality prototypes. Products modelled in 3D CAD can be produced in a variety of materials to replicate the products aesthetics, form and functionality. 3D People's prototyping service helps customers reduce costs, speed up product development time and create valuable presentation tools.");
		m.ln("			</p>");

		m.ln("			<div class=\"common-container-centre\">");
		m.addLinkButton("Request Quote", PageMapping.QUOTE_3D_PG, true);
		m.ln("			</div>");
		
		m.ln("		</div>");
		m.ln("		<img class=\"horizontal-section-image\" src=\"https://cdn-3d.niceshops.com/upload/image/product/large/default/creality-cr-6-se-1-pc-333178-en.jpg\" alt=\"\">");
		m.ln("	</div>");
		m.ln("		</div>"); // container-tab-2


		m.ln("			</div>"); // tab-content-container
		m.ln("		</div>"); // tab-container


		m.ln("		<div class=\"tab-container\">");
		m.ln("			<input type=\"radio\" id=\"tab-3\" name=\"tab-group2\" checked >");
		m.ln("			<input type=\"radio\" id=\"tab-4\" name=\"tab-group2\">");
		m.ln("			<input type=\"radio\" id=\"tab-5\" name=\"tab-group2\">");
		m.ln("			<div class=\"tab\">");
		m.ln("				<ul>");
		m.ln("					<li class=\"tab-wrapper\">");
		m.ln("						<ul>");
		m.ln("							<li id=\"tab-id-3\"><label for=\"tab-3\"><div>Rohloff Build</div></label><div class=\"shadow-cover\"></div></li>");
		m.ln("							<li id=\"tab-id-4\"><label for=\"tab-4\"><div>File Server</div></label><div class=\"shadow-cover\"></div></li>");
		m.ln("							<li id=\"tab-id-5\"><label for=\"tab-5\"><div>Contact</div></label><div class=\"shadow-cover\"></div></li>");
		m.ln("						</ul>");
		m.ln("					</li>"); // tab-wrapper
		m.ln("				</ul>");
		m.ln("			</div>"); // tab
		m.ln("			<div class=\"tab-content-container\">"); // replace container
		
		m.ln("				<div id=\"container-tab-3\" class=\"tab-animated\">");
		
		m.ln("		<img class=\"\" src=\"".concat("https://i.pinimg.com/originals/74/88/0b/74880bc293ef939e31366692f104a925.jpg").concat("\" style=\"").concat("max-width:100%;").concat("\" alt=\"\"><br>"));
		m.addLinkButton("See build", PageMapping.ROHLOFF_PG1, false);
		m.ln("				</div>"); // container-tab-1
		
		m.ln("				<div id=\"container-tab-4\" class=\"tab-animated\">");
		m.ln("		<img class=\"\" src=\"".concat("https://i.imgur.com/bq6Nm5v.jpg").concat("\" style=\"").concat("max-width:100%;").concat("\" alt=\"\"><br>"));
		m.addLinkButton("See machine", PageMapping.FILESERVER1_PG, false);
		m.ln("				</div>"); // container-tab-2
		
		m.ln("				<div id=\"container-tab-5\" class=\"tab-animated\">");
		m.addLinkButton("Open contact form", PageMapping.CONTACT_PG, false);
		m.ln("				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>"); // container-tab-2

		m.ln("			</div>"); // tab-content-container
		m.ln("		</div>"); // tab-container

		m.ln("<a class=\"btn btn-blue ripple\" style=\"text-align: center;display:block;\" onclick=\"scrollToTop();\">Top</a>");

		
		m.ln("</div>"); // common-content

		m.addFooter(requestInfo);

		m.ln("<script>");
		m.ln(Resource.readResource(Resource.JS_SCROLL_TOP));
		m.ln("</script>");

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
