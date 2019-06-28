package web.pages.root;

import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageAdmin extends BasePage {

	public PageAdmin(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.ln("<html>");
		m.addHead(css, js);

		m.ln("<body>");
		m.addNavbar();
		m.addCard("<h2>card</h2>");
		m.ln("</body>");

		m.ln("</html>");
		return m.p.toString();
	}

}
