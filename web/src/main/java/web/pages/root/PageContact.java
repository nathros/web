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

		m.addBanner("Contact", Resource.IMG_BANNER_1);
		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		String firstname = requestInfo.getBodyParam("firstname");
		String email = requestInfo.getBodyParam("email");
		String subject = requestInfo.getBodyParam("subject");
		String comment = requestInfo.getBodyParam("comment");
		boolean gotPostData = false;
		m.ln("<form action=\"contact\" method=\"post\">");
		m.ln("	Name:<br>");
		if (null == firstname) {
			m.ln("	<input type=\"text\" name=\"firstname\" value=\"\">");
		} else {
			gotPostData = true;
			m.ln("	<input type=\"text\" name=\"firstname\" value=\"" + firstname + "\">");
		}
		m.ln("	<br><br>");
		m.ln("	Email-address:<br>");
		if (null == email) {
			m.ln("	<input type=\"text\" name=\"email\" value=\"\">");
		} else {
			gotPostData = true;
			m.ln("	<input type=\"text\" name=\"email\" value=\"" + email + "\">");
		}
		m.ln("	<br><br>");
		m.ln("	Subject:<br>");
		if (null == subject) {
			m.ln("	<input type=\"text\" name=\"subject\" value=\"\"><br><br>");
		} else {
			gotPostData = true;
			m.ln("	<input type=\"text\" name=\"subject\" value=\"" + subject + "\"><br><br>");
		}
		m.ln("	Message:<br>");
		m.ln("	<textarea style=\"width:100%;\" rows=\"12\" cols=\"100\" name=\"comment\">");
		if (null != comment) {
			gotPostData = true;
			m.ln(comment);
		}
		m.ln("</textarea>");

		m.ln("	<br><br>");
		m.ln("	<input class=\"btn btn-blue ripple\" type=\"submit\" value=\"Submit\">");
		if (gotPostData) {
			m.ln("	<p style=\"color:red\">WARNING: form POST success, but email submission not currently implemented</p>");
		}
		m.ln("</form>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
