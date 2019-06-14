package web.pages.root;

import web.common.Markup;
import web.common.RequestInfo;
import web.pages.BasePage;

public class PageHome extends BasePage {

	public PageHome(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		Markup m = new Markup();
		m.page.append("<!DOCTYPE html>\n");
		m.page.append("<html>");
		m.page.append("<head>");
		// m.page.append("<img
		// src=\"https://img.icons8.com/cute-clipart/64/000000/sun.png\">");
		m.page.append(
				"<link rel=\"icon\" type=\"image/png\" href=\"https://img.icons8.com/cute-clipart/64/000000/sun.png\">");

		m.page.append("<body>");
		m.page.append("<h2>root page</h2>");
		m.page.append("</body>");

		m.page.append("</head>");
		m.page.append("</html>");

		return m.page.toString();
	}

}
