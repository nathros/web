package web.pages.root.sandpit;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;
import web.pages.root.Page404;

public class PageSandpit extends BasePage {

	public PageSandpit(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		if (!requestInfo.isDebugCookieTrue()) return new Page404(requestInfo).getResponse();

		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER};
		String[] js = { Resource.JS_HEADER };

		m.addHead(css, js, "Sandpit");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Sandpit, requestInfo);

		m.ln("<div class=\"common-content\">");
		m.ln("<div class=\"card\">");

		m.ln("	<div style=\"text-align: center; margin-top: 3rem;\">");
		m.ln("		<a href=\"sandpit/xhttpouter\">xhttpouter</a><br>");
		m.ln("		<a href=\"sandpit/carousel\">carousel</a><br>");
		m.ln("		<a href=\"sandpit/comment\">comment</a><br>");
		m.ln("		<a href=\"sandpit/activeshow\">activeshow</a><br>");
		m.ln("		<a href=\"sandpit/viewwindow\">viewwindow</a><br>");
		m.ln("	</div>");

		m.ln("</div>"); // card
		m.ln("</div>"); //common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
