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
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FOOTER, Resource.CSS_TOGGLE_DIV, Resource.CSS_FORMS };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE, Resource.JS_HEADER, Resource.JS_FORMS, Resource.JS_TOGGLE_DIV };

		m.addHead(css, js, "FreeNAS Backup Server");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects, requestInfo);

		m.addBanner("FreeNAS Backup Server", Resource.IMG_BANNER_FILESERVER1);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		//// https://www.truenas.com/community/threads/freenas-9-3-webgui-datagrids-dont-render-on-chrome-after-v67.69360/
		m.addModalImage("https://i.imgur.com/h7fRzRG.jpg", "https://i.imgur.com/bq6Nm5v.jpg", "max-width:60%", null, null);
		m.ln("<br><a class=\"btn btn-blue ripple\">Page is work in progress</a>");
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
