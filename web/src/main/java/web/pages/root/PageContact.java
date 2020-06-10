package web.pages.root;

import web.Scheduled;
import web.common.Helper;
import web.common.HttpMethod;
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

		final String styleMissing = " style=\"color:red\"";
		final String requiredParam = " REQUIRED";
		String style = "";
		String required = "";
		boolean isPost = requestInfo.getMethod() == HttpMethod.POST;

		boolean parseFailure = false;
		m.ln("<form action=\"contact\" method=\"post\">");

		style = "";
		required = "";
		if (isPost) {
			if (firstname.equals("")) {
				style = styleMissing;
				required = requiredParam;
				parseFailure = true;
			}
		}
		m.ln("	<div" + style + ">Name: * " + required + "</div>");
		m.ln("	<input type=\"text\" name=\"firstname\" value=\"" + firstname + "\">");
		m.ln("	<br><br>");

		style = "";
		required = "";
		if (isPost) {
			if (email.equals("")) {
				style = styleMissing;
				required = requiredParam;
				parseFailure = true;
			} else {
				if (!Helper.isValidEmail(email)) {
					required = " INVALID EMAIL";
					style = styleMissing;
					parseFailure = true;
				}
			}
		}
		m.ln("	<div" + style + ">Email-address: * " + required + "</div>");
		m.ln("	<input type=\"text\" name=\"email\" value=\"" + email + "\">");
		m.ln("	<br><br>");

		style = "";
		required = "";
		if (isPost) {
			if (subject.equals("")) {
				style = styleMissing;
				required = requiredParam;
				parseFailure = true;
			}
		}
		m.ln("	<div" + style + ">Subject: * " + required + "</div>");
		m.ln("	<input type=\"text\" name=\"subject\" value=\"" + subject + "\"><br><br>");

		style = "";
		required = "";
		if (isPost) {
			if (comment.equals("")) {
				style = styleMissing;
				required = requiredParam;
				parseFailure = true;
			}
		}
		m.ln("	<div" + style + ">Message: * " + required + "</div>");

		m.ln("	<textarea style=\"width:100%;\" rows=\"12\" cols=\"100\" name=\"comment\">");
		if (isPost) {
			if (!comment.equals("")) {
				m.l(comment);
			}
		}
		m.ln("</textarea>");

		m.ln("	<br><br>");
		m.ln("	<input class=\"btn btn-blue ripple\" type=\"submit\" value=\"Submit\">");

		if (isPost) {
			if (parseFailure) {
				m.ln("	<p style=\"color:red\">ERROR: missing or invalid fields</p>");
			} else {
				m.ln("	<p style=\"color:green\">SUCCESS: E-mail successfully sent</p>");
				Scheduled.scheduleEmail(subject, firstname + "\n" + email + "\n" + comment);
			}
		}

		m.ln("</form>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
