package web.pages.root;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.PageMapping;
import web.pages.resources.Resource;

public class PageHome extends BasePage {

	public PageHome(RequestInfo request) {
		super(request, true);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_H_SECTION, Resource.CSS_TABS, Resource.CSS_MODAL_IMAGE, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE, Resource.JS_HEADER };

		m.addHead(css, js, "Home Page");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Home);
		m.addBannerHomeAnimated(Resource.IMG_BANNER_1);
		//m.addBannerHomeAnimated("");

		//// https://i.imgur.com/pwDNLvY.jpg
		// https://ma-hub.imgix.net/wp-images/2019/11/17203220/final-cut-pro-missing-file.jpg
		// https://www.mtbr.com/threads/bontrager-race-lite-serial-number.316277/
		m.ln("<div class=\"common-content\" style=\"margin-top:-20rem\">");
		m.ln("	<div class=\"card card-home\">");
		m.ln("		<h1 style=\"text-align:center\">Building Value Through Design</h1>");
		m.ln("		<h4 style=\"text-align:center\">Enabling tight software and hardware integration</h4>");
		//m.ln("		<p style=\"text-align:justify\">Welcome to a journey of an engineer</p>");
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


		m.ln("				<div id=\"container-tab-1\" class=\"tab-animated\">");
		m.ln("	<div class=\"horizontal-section-container-left\" style=\"\">");
		m.ln("		<img class=\"horizontal-section-image\" src=\"https://i.ibb.co/r27vLqT/FOHDVjQ.webp\" alt=\"\">");
		m.ln("		<p class=\"horizontal-section-text-left horizontal-section-clear\">");
		m.ln("			<b>Atmel SAM D10 Xplained Mini</b><br><br>");
		m.ln("			Embedded software can be very simple, such as that used for controlling lighting in homes, and can run on an 8-bit microcontroller with just a few kilobytes of memory, or it can be quite complex such as the software running all of the electronic components of a modern smart car, complete with climate controls, automatic cruising and collision sensing, as well as control navigations. Complex embedded software can also be found in aircraft avionics systems, in very complex fly-by-wire systems used in fighter planes and even in missile guidance systems.");
	
		m.ln("		</p>");
		m.ln("	</div>");
		m.ln("				</div>"); // container-tab-1

		
		
		m.ln("				<div id=\"container-tab-2\" class=\"tab-animated\">");
		m.ln("	<div class=\"horizontal-section-container-right\" style=\"\">");
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
		m.ln("				</div>"); // container-tab-2


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
		m.addLinkButton("See machine", PageMapping.FILESERVER1_PG1, false);
		m.ln("				</div>"); // container-tab-2
		
		m.ln("				<div id=\"container-tab-5\" class=\"tab-animated\">");
		m.addLinkButton("Open contact form", PageMapping.CONTACT_PG, false);
		m.ln("				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>"); // container-tab-2

		m.ln("			</div>"); // tab-content-container
		m.ln("		</div>"); // tab-container
		
		/*m.ln("<h2>Title</h2>");
		
		
		/*for (int i = 0; i < 12; i++) {
			m.ln("<h2>Title</h2>");
			if (i == 1) {
				// https://sg.element14.com/productimages/large/en_GB/2451533-40.jpg
				// https://www.microchip.com/_ImagedCopy/ATmega328PB-XMINI_front.jpg
				// https://img.pixers.pics/pho(s3:700/FO/48/36/24/84/700_FO48362484_30045f183526a0f45cb05dbfa9cea87a.jpg,700,700,jpg)/wall-murals-circuit-board-seamless-pattern.jpg.jpg
				// 'https://i.pinimg.com/originals/9c/50/86/9c5086f4402e61b7bc348da6278ee49e.jpg
				m.ln("	<a style=\"text-decoration: none;\" href=\"/stage/spelling\">404 example</a>");

				m.ln("	<div class=\"horizontal-section-container-left\" style=\"background-image: url('https://img.pixers.pics/pho(s3:700/FO/48/36/24/84/700_FO48362484_30045f183526a0f45cb05dbfa9cea87a.jpg,700,700,jpg)/wall-murals-circuit-board-seamless-pattern.jpg.jpg');\">");
				m.ln("		<img class=\"horizontal-section-image\" src=\"https://i.ibb.co/r27vLqT/FOHDVjQ.webp\" alt=\"\">");
				m.ln("		<p class=\"horizontal-section-text-left\"><b>Atmel SAM D10 Xplained Mini</b><br><br>Working with a cheap development kit. how thick each layer is. Smaller 0.1mm height can provide fine details but requires more time to complete a print. Thicker layers such as 0.3mm will be cheaper to produce as the print will complete quicker but the </p>");
				m.ln("	</div>");

				m.ln("	<div class=\"horizontal-section-container-right\" style=\"background-image: url(\'https://previews.123rf.com/images/rommmeo79/rommmeo791610/rommmeo79161000214/64977895-chinese-yellow-gold-seamless-pattern-dragon-fish-scales-simple-seamless-pattern-nature-background-wi.jpg');\">");
				m.ln("		<p class=\"horizontal-section-text-right\">s how thick each layer is. Smaller 0.1mm height can provide fine details but requires more time to complete a print. Thicker layers such as 0.3mm will be cheaper to produce as the print will complete quicker but the </p>");
				m.ln("		<img class=\"horizontal-section-image\" src=\"https://i.imgur.com/FOHDVjQ.png\" alt=\"\">");
				m.ln("	</div>");
			}
			m.ln("<p>What is Lorem Ipsum?\r\n"
					+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n"
					+ "\r\n" + "Why do we use it?\r\n"
					+ "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\r\n"
					+ "\r\n" + "\r\n" + "Where does it come from?\r\n"
					+ "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\r\n"
					+ "\r\n"
					+ "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.</p>");
		}*/
		m.ln("<a class=\"btn btn-blue ripple\" style=\"text-align: center;display:block;\" onclick=\"scrollToTop();\">Top</a>");

		
		m.ln("</div>"); // common-content

		m.addFooter();

		m.ln("<script>");
		m.ln(Resource.readResource(Resource.JS_SCROLL_TOP));
		m.ln("</script>");

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
