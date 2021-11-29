package web.pages.root.sandpit.toast;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;
import web.pages.root.Page404;

public class PageToast extends BasePage {

	public PageToast(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		if (!requestInfo.isDebugCookieTrue()) return new Page404(requestInfo).getResponse();

		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FORMS, Resource.CSS_TOGGLE_DIV};
		String[] js = { Resource.JS_HEADER, Resource.JS_FORMS, Resource.JS_TOGGLE_DIV };

		m.addHead(css, js, "Toast");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Sandpit, requestInfo);

		m.ln("<div class=\"common-content\">");
		m.ln("<div class=\"card\">");

		m.ln("	<div style=\"text-align: left; margin-top: 3rem;\">");
		m.ln("<br><br><br><br>");
		m.ln("<button onclick=\"document.getElementById('toast').className='show'\">show</button>");
		m.ln("<button onclick=\"document.getElementById('toast').className='show error'\">show error</button>");
		m.ln("<button onclick=\"document.getElementById('toast').className='show warning'\">show warning</button>");
		m.ln("<button onclick=\"document.getElementById('toast').className='show good'\">show good</button>");
		m.ln("<button onclick=\"document.getElementById('toast').className='hide'\">hide</button>");
		m.ln("<button onclick=\"document.getElementById('toast').className='';document.getElementById('toast').offsetWidth;document.getElementById('toast').className='show'\">reshow</button>");
		m.ln("	</div>");

		m.ln("</div>"); // card
		m.ln("</div>"); //common-content

		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
