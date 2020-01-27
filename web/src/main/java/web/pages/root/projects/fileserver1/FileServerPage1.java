package web.pages.root.projects.fileserver1;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class FileServerPage1 extends BasePage {

	public FileServerPage1(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "File Server 1");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("File Server 1", Resource.IMG_BANNER_FILESERVER1);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		////

		m.ln("<a class=\"btn btn-blue ripple\">Work in Progress</a>");
		////
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
