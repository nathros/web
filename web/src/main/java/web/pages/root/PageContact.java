package web.pages.root;

import java.io.IOException;
import java.util.List;

import web.Tools;
import web.common.Debug;
import web.common.Forms;
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
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FORMS, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_FORMS, Resource.JS_HEADER };

		m.addHead(css, js, "Contact");
		m.ln("<body>");

		m.addNavbar(NavbarItem.Contact);
		m.addBannerAnimated("Contact", Resource.IMG_BANNER_1);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		final String firstname = requestInfo.getBodyParam(Forms.INPUT_NAME);
		final String email = requestInfo.getBodyParam(Forms.INPUT_EMAIL);
		final String subject = requestInfo.getBodyParam(Forms.INPUT_SUBJECT);
		final String comment = requestInfo.getBodyParam(Forms.INPUT_COMMENT);
		final String captcha = requestInfo.getBodyParam(Forms.INPUT_CAPTCHA).replaceAll(" ", "");

		HttpMethod method = requestInfo.getMethod();

		boolean anyFailure = false;
		m.ln("<form id=\"email-form\" action=\"contact\" method=\"post\">");

		boolean inputError = !Forms.isContentValid(firstname, method);
		if (inputError) anyFailure = true;
		m.addFormInput(Forms.INPUT_NAME, firstname, "Name", Forms.ERROR_MESSAGE_REQUIRED, inputError, false, Forms.SCRIPT_INPUT, Forms.SCRIPT_INPUT, null, Forms.INPUT_ICON_USER, true);

		inputError = !Forms.isContentValid(email, method);
		if ((!inputError) && (method == HttpMethod.POST)) {
			inputError = !Helper.isValidEmail(email);
		}
		if (inputError) anyFailure = true;
		m.addFormInput(Forms.INPUT_EMAIL, email, "Email", Forms.ERROR_MESSAGE_EMAIL, inputError, false, Forms.SCRIPT_INPUT_EMAIL_LEAVE, Forms.SCRIPT_INPUT_EMAIL, null, Forms.INPUT_ICON_EMAIL, true);

		inputError = !Forms.isContentValid(subject, method);
		if (inputError) anyFailure = true;
		m.addFormInput(Forms.INPUT_SUBJECT, subject, "Subject", Forms.ERROR_MESSAGE_REQUIRED, inputError, false, Forms.SCRIPT_INPUT, Forms.SCRIPT_INPUT, null, Forms.INPUT_ICON_SUBJECT, true);

		inputError = !Forms.isContentValid(comment, method);
		if (inputError) anyFailure = true;
		m.addFormTextArea(Forms.INPUT_COMMENT, comment, "Comment", Forms.ERROR_MESSAGE_REQUIRED, inputError, Forms.SCRIPT_TEXTAREA, Forms.SCRIPT_TEXTAREA, null);

		List<Integer> numbers = m.addCAPTCHAInput();

		final String encoded = requestInfo.getBodyParam("encoded");
		inputError = !Forms.encodedCAPTCHACompareValid(encoded, captcha, method);
		if (inputError) anyFailure = true;
		m.addFormInput(Forms.INPUT_CAPTCHA, "", "Security Check", Forms.ERROR_MESSAGE_INCORRECT, inputError, true, Forms.SCRIPT_INPUT_CAPTCHA, Forms.SCRIPT_INPUT_CAPTCHA, "Copy both numbers", Forms.INPUT_ICON_SECURITY, true);

		String encodedCaptcha = "";
		try {
			encodedCaptcha = Debug.serialise(String.valueOf(numbers.get(0)) + String.valueOf(numbers.get(1)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		m.ln("	<input type=\"hidden\" id=\"encoded\" name=\"encoded\" value=\"" + encodedCaptcha + "\">");

		m.ln("	<button class=\"btn btn-blue ripple\" style=\"width:12rem\" onclick=\"sendEmail()\" value=\"Submit\" aria-label=\"Submit\">Submit</button>");

		if (requestInfo.getMethod() == HttpMethod.POST) {
			if (anyFailure) {
				m.ln("	<p class=\"forms-param-error\">ERROR: missing or invalid fields</p>");
			} else {
				String body = "firstname: " + firstname + "\n";
				body += "email: " + email + "\n";
				body += "comment: " + comment + "\n";
				String result = Tools.sendEmailAWSSMTP(subject, body);

				if (!result.equals(Tools.EmailOkayResponse)) {
					m.ln("	<p class=\"forms-param-error\">ERROR: in sending email</p>");
					m.ln("<p>".concat(result).concat("</p>"));
				} else {
					m.ln("	<p class=\"forms-param-good\">SUCCESS: E-mail successfully sent</p>");
				}
			}
		}

		m.ln("</form>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter(requestInfo);

		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
