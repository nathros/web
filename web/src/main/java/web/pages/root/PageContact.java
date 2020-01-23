package web.pages.root;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageContact extends BasePage {

	public PageContact(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "Contact");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Contact);

		m.addBanner("Contact", "https://wallpaperplay.com/walls/full/1/b/e/366897.jpg");
		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		m.ln("<form action=\"contact\" onSubmit=\"return alert('WARNING: not currently implemented');\">");
		m.ln("	Name<br>");
		m.ln("	<input type=\"text\" name=\"firstname\" value=\"\">");
		m.ln("	<br><br>");
		m.ln("	Email-address:<br>");
		m.ln("	<input type=\"text\" name=\"email\" value=\"\">");
		m.ln("	<br><br>");
		m.ln("	Subject:<br>");
		m.ln("	<input type=\"text\" name=\"subject\" value=\"\"><br><br>");
		m.ln("	<textarea style=\"width:100%;\" rows=\"12\" cols=\"100\" name=\"comment\"></textarea>");
		m.ln("	<br><br>");
		m.ln("	<input type=\"submit\" value=\"Submit\"><p style=\"color:red\">WARNING: submit not currently implemented</p>");
		m.ln("</form>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
