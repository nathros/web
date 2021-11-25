package web.pages.root.sandpit.viewwindow;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageViewWindow extends BasePage {

	public PageViewWindow(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		//if (!requestInfo.isDebugCookieTrue()) return new Page404(requestInfo).getResponse();

		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FORMS};
		String[] js = { Resource.JS_HEADER, Resource.JS_FORMS };

		m.addHead(css, js, "View Window");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Sandpit, requestInfo);

		m.ln("<script>");
		m.ln("function updateClientWidth() {");
		m.ln("	var element = document.getElementById('client-width');");
		m.ln("	element.innerHTML = document.documentElement.clientWidth;");
		m.ln("}");

		m.ln("function updateInnerWidth() {");
		m.ln("	var element = document.getElementById('inner-width');");
		m.ln("	element.innerHTML = window.innerWidth;");
		m.ln("}");

		m.ln("function updateClientHeight() {");
		m.ln("	var element = document.getElementById('client-height');");
		m.ln("	element.innerHTML = document.documentElement.clientHeight;");
		m.ln("}");

		m.ln("function updateInnerHeight() {");
		m.ln("	var element = document.getElementById('inner-height');");
		m.ln("	element.innerHTML = window.innerHeight;");
		m.ln("}");

		m.ln("function updateAll() {");
		m.ln("updateClientWidth();");
		m.ln("updateInnerWidth();");
		m.ln("updateClientHeight();");
		m.ln("updateInnerHeight();");
		m.ln("}");
		m.ln("</script>");


		m.ln("<style>");
		m.ln("#hold {");
		m.ln("position: fixed;");
		m.ln("background-color: powderblue;");
		m.ln("left: 0;");
		m.ln("}");

		m.ln(".green { background-color: lightgreen; }");
		m.ln("</style>");

		m.ln("<div class=\"common-content\">");
		m.ln("<div class=\"card\">");

		m.ln("<br><br><br>");
		m.ln("<p><i>On Chrome for Android: you cannot interact with the bottom of the page when page is displayed through iframe</i></p><br>");

		m.ln("<div id='hold'>");
		m.ln("<p>document.documentElement.clientWidth = <b id='client-width'></b>");
		m.ln("<button onclick='updateClientWidth()'>update</button></p>");

		m.ln("<p>window.innerWidth = <b id='inner-width'></b>");
		m.ln("<button onclick='updateInnerWidth()'>update</button></p>");

		m.ln("<p>document.documentElement.clientHeight = <b id='client-height'></b>");
		m.ln("<button onclick='updateClientHeight()'>update</button></p>");

		m.ln("<p>window.innerWidth = <b id='inner-height'></b>");
		m.ln("<button onclick='updateInnerHeight()'>update</button></p>");

		m.ln("<p>Update all: ");
		m.ln("<button onclick='updateAll()'>update all</button></p>");
		m.ln("</div>"); // hold

		for (int i = 0; i < 64; i ++) {
			m.ln("<br>line " + i);
		}

		m.ln("</div>"); // card
		m.ln("</div>"); //common-content

		m.ln("<button onclick='this.classList.toggle(\"green\");'>----| Can press? |----</button>");
		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
