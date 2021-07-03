package web.pages.root;

import java.io.IOException;
import java.util.Random;

import web.Tools;
import web.common.Debug;
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
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FORMS };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_FORMS };

		m.addHead(css, js, "Contact");
		m.ln("<body>");

		m.ln("<div id=\"fullscreen-message\">");
		m.ln("	<h1>Please Wait...</h1>");
		m.ln("	<div class=\"loading\">");
		m.ln("		<div class=\"bounce1\"></div>");
		m.ln("		<div class=\"bounce2\"></div>");
		m.ln("		<div class=\"bounce3\"></div>");
		m.ln("	</div>");
		m.ln("</div>");

		m.addNavbar(NavbarItem.Contact);
		m.addBannerAnimated("Contact", Resource.IMG_BANNER_1);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		final String firstname = requestInfo.getBodyParam("firstname");
		final String email = requestInfo.getBodyParam("email");
		final String subject = requestInfo.getBodyParam("subject");
		final String comment = requestInfo.getBodyParam("comment");
		final String captcha = requestInfo.getBodyParam("captcha").replaceAll(" ", "");

		final String styleMissing = " style=\"color:red\"";
		final String requiredParam = " REQUIRED";
		boolean localFailure = false;
		String style = "";
		String required = "";
		boolean isPost = requestInfo.getMethod() == HttpMethod.POST;

		boolean parseFailure = false;
		m.ln("<form id=\"email-form\" action=\"contact\" method=\"post\">");

		style = "";
		required = "";
		if (isPost) {
			if (firstname.equals("")) {
				style = styleMissing;
				required = requiredParam;
				parseFailure = true;
				localFailure = true;
			}
		}
		m.ln("	<div" + style + ">Name: * " + required + "</div>");
		m.ln("	<input class=\"forms-input" + (localFailure ? " forms-input-error" : "")
				+ "\" type=\"text\" name=\"firstname\" value=\"" + firstname + "\">");
		m.ln("	<br><br>");

		style = "";
		required = "";
		localFailure = false;
		if (isPost) {
			if (email.equals("")) {
				style = styleMissing;
				required = requiredParam;
				parseFailure = true;
				localFailure = true;
			} else {
				if (!Helper.isValidEmail(email)) {
					required = " INVALID EMAIL";
					style = styleMissing;
					parseFailure = true;
					localFailure = true;
				}
			}
		}
		m.ln("	<div" + style + ">Email-address: * " + required + "</div>");
		m.ln("	<input class=\"forms-input" + (localFailure ? " forms-input-error" : "")
				+ "\" type=\"text\" name=\"email\" value=\"" + email + "\">");
		m.ln("	<br><br>");

		style = "";
		required = "";
		localFailure = false;
		if (isPost) {
			if (subject.equals("")) {
				style = styleMissing;
				required = requiredParam;
				parseFailure = true;
				localFailure = true;
			}
		}
		m.ln("	<div" + style + ">Subject: * " + required + "</div>");
		m.ln("	<input class=\"forms-input" + (localFailure ? " forms-input-error" : "")
				+ "\" type=\"text\" name=\"subject\" value=\"" + subject + "\"><br><br>");

		style = "";
		required = "";
		localFailure = false;
		if (isPost) {
			if (comment.equals("")) {
				style = styleMissing;
				required = requiredParam;
				parseFailure = true;
				localFailure = true;
			}
		}
		m.ln("	<div" + style + ">Message: * " + required + "</div>");

		m.ln("	<textarea rows=\"12\" cols=\"100\" name=\"comment\" "
				+ (localFailure ? " class=\"forms-input-error\"" : "") + ">");
		if (isPost) {
			if (!comment.equals("")) {
				m.l(comment);
			}
		}
		m.ln("</textarea>");
		m.ln("	<br><br>");

		Random random = new Random();
		int number1;
		do {
			number1 = Math.abs(random.nextInt() % 10);
		} while ((number1 == 6) || (number1 == 9));
		int number2;
		do {
			number2 = Math.abs(random.nextInt() % 10);
		} while ((number2 == 6) || (number2 == 9));
		String cap = Helper.generateCAPTCHAImageAsBase64(number1, number2);
		m.ln("<img class=\"captcha-image\" src=\"" + cap + "\">");

		final String encoded = requestInfo.getBodyParam("encoded");
		style = "";
		required = "";
		localFailure = false;
		if (isPost) {
			if ("".equals(captcha)) {
				style = styleMissing;
				required = "INCORRECT";
				parseFailure = true;
				localFailure = true;
			} else {
				try {
					String compare = Debug.serialise(captcha);
					if (!compare.equals(encoded)) {
						style = styleMissing;
						required = "INCORRECT";
						parseFailure = true;
						localFailure = true;
					}
				} catch (IOException e) {
					e.printStackTrace();
					localFailure = true;
				}
			}
		}
		m.ln("	<div" + style + ">Security Check: * " + required + "</div>");
		m.ln("	<input class=\"forms-input " + (localFailure ? " forms-input-error" : "")
				+ "\" type=\"text\" name=\"captcha\" value=\"\" autocomplete=\"new-password\">");
		m.ln("	<i class=\"forms-small-text\">Copy both numbers</i>");
		String encodedCaptcha = "";
		try {
			encodedCaptcha = Debug.serialise(String.valueOf(number1) + String.valueOf(number2));
		} catch (IOException e) {
			e.printStackTrace();
		}
		m.ln("	<input type=\"hidden\" id=\"encoded\" name=\"encoded\" value=\"" + encodedCaptcha + "\">");

		m.ln("	<br><br>");
		m.ln("	<input class=\"btn btn-blue ripple\" onclick=\"sendEmail()\" value=\"Submit\">");

		if (isPost) {
			if (parseFailure) {
				m.ln("	<p style=\"color:red\">ERROR: missing or invalid fields</p>");
			} else {
				String body = "firstname: " + firstname + "\n";
				body += "email: " + email + "\n";
				body += "comment: " + comment + "\n";
				String result = Tools.sendEmailAWSSMTP(subject, body);

				if (!result.equals(Tools.EmailOkayResponse)) {
					m.ln("	<p style=\"color:red\">ERROR: in sending email</p>");
					m.ln("<p>".concat(result).concat("</p>"));
				} else
					m.ln("	<p style=\"color:green\">SUCCESS: E-mail successfully sent</p>");
			}
		}

		m.ln("</form>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("<script>");
		m.ln(Resource.readResource(Resource.JS_BANNER));
		m.ln("</script>");

		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
