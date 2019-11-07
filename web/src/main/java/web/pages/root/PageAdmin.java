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
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.ln("<html lang=\"en\">");
		m.addHead(css, js, "Admin");

		m.ln("<body>");
		m.addNavbar();

		////
		m.ln("<div class=\"title-banner\">");
		m.ln("	<div>Admin Page</div>");
		m.ln("</div>"); // title-banner

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		m.ln("		<form method=\"post\" action=javascript:action>");
		m.ln("			<label for=\"page-select\"><strong>Page:</strong></label>");
		m.ln("				<select name=\"page-select\" id=\"page-select\" onChange=\"this.form.action=this.options[this.selectedIndex].value;this.form.submit()\">");
		m.ln("					<option value=\"page1\">Option 1</option>");
		m.ln("					<option value=\"page2\">Option 3</option>");
		m.ln("					<option value=\"page3\">Option 3</option>");
		m.ln("				</select>"); // select
		m.ln("		</form>"); // form
		m.ln("	</div>"); // card

		// m.addCard(" <h2><a href=\"/test/admin\"> link</a></h2>");
		////

		////

		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
