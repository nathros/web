package web.pages.root;

import java.util.UUID;

import web.Tools;
import web.common.Forms;
import web.common.HttpMethod;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class Page3DQuote extends BasePage {

	final static String INPUT_FILAMENT_COLOUR = "filament-colour";
	final static String INPUT_FILAMENT_MATERIAL = "filament-material";
	final static String INPUT_LAYER_HEIGHT = "layer-height";
	final static String INPUT_SERVICE = "service";

	public Page3DQuote(RequestInfo request) {
		super(request);
	}

	public void addNavbar3D() {
		m.ln("<div class=\"navbar\">");
		m.ln("	<a class=\"navbar-selected\">3D Print / Design Quote</a>");
		m.ln("	<a class=\"ebay-logo\" href=\"https://www.ebay.co.uk\" target=\"_blank\">&nbsp;</a>");
		m.ln("</div>"); // navbar
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_3D_QUOTE, Resource.CSS_FORMS, Resource.CSS_FOOTER };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_3D_QUOTE, Resource.JS_FORMS, Resource.JS_HEADER };

		m.addHead(css, js, "Quote");

		m.ln("<body>");

		addNavbar3D();
		m.addBannerHomeAnimated(Resource.IMG_BANNER_1);

		final boolean isPost = requestInfo.getMethod() == HttpMethod.POST;
		final String user = requestInfo.getBodyParam(Forms.INPUT_USER);
		final String comment = requestInfo.getBodyParam(Forms.INPUT_COMMENT);
		final String filamentColour = requestInfo.getBodyParam(INPUT_FILAMENT_COLOUR);
		final String filamentMaterial = requestInfo.getBodyParam(INPUT_FILAMENT_MATERIAL);
		final String layerHeight = requestInfo.getBodyParam(INPUT_LAYER_HEIGHT);
		final String captcha = requestInfo.getBodyParam(Forms.INPUT_CAPTCHA).replaceAll(" ", "");
		final String service = requestInfo.getBodyParam(INPUT_SERVICE);
		final boolean isDesignService = "designService".equals(service);
		String userId = requestInfo.getBodyParam("userId");

		////
		m.ln("<div class=\"common-content\" style=\"margin-top:-20.5rem\">");
		m.ln("	<div class=\"card\">");

		m.ln("<form id=\"email-form\" action=\"3d-quote\" method=\"post\">");

		HttpMethod method = requestInfo.getMethod();
		boolean anyFailure = false;
		boolean inputError = !Forms.isContentValid(user, method);
		if (inputError) anyFailure = true;
		m.addFormInput(Forms.INPUT_USER, user, "eBay Username or E-mail", Forms.ERROR_MESSAGE_REQUIRED, inputError, false, Forms.SCRIPT_INPUT, Forms.SCRIPT_INPUT, "Quote will be sent to this address or user", Forms.INPUT_ICON_USER, true, null);

		m.ln("	<div>Service:</div>");
		m.ln("	<div class=\"forms-input\" style=\"padding:0\">");
		m.ln("		<div style=\"display:flex;gap:0rem;\">");
		m.ln("			<label id=\"radio-print-label\" class=\"btn btn-blue ripple\" style=\"width:100%;margin-right:0.5rem\" onclick=\"selectPrintService()\">");
		m.ln(" 				<input id=\"radio-print\" style=\"display:none;\" type=\"radio\" name=\"service\" value=\"printService\">"); // TODO make resize to 370px dynamic not fixed, animation overlap on expand also needs correcting
		m.ln("				3D Print Service");
		m.ln("			</label>");
		m.ln("			<label id=\"radio-design-label\" class=\"btn btn-light-blue ripple\" style=\"width:100%\" onclick=\"selectDesignService()\">");
		m.ln("				<input id=\"radio-design\" style=\"display:none;\" type=\"radio\" name=\"service\" value=\"designService\">");
		m.ln("				Design Service");
		m.ln("			</label>");
		m.ln("		</div>");
		m.ln("	</div>"); // forms-input
		m.ln("	<i class=\"forms-small-text\">What kind of service you require</i>");
		m.ln("	<br><br>");

		m.ln("<div id=\"print-extras\" class=\"print-extras\">");

		inputError = !Forms.isContentValid(filamentColour, method);
		if (inputError && !isDesignService) anyFailure = true;
		m.addFormInput(INPUT_FILAMENT_COLOUR, filamentColour, "Filament Colour", Forms.ERROR_MESSAGE_REQUIRED, inputError, false, Forms.SCRIPT_INPUT, Forms.SCRIPT_INPUT, "Examples: Black, Green, Red", Forms.INPUT_ICON_PALETTE, true, null);

		inputError = !Forms.isContentValid(filamentMaterial, method);
		if (inputError && !isDesignService) anyFailure = true;
		m.addFormInput(INPUT_FILAMENT_MATERIAL, filamentMaterial, "Filament Material", Forms.ERROR_MESSAGE_REQUIRED, inputError, false, Forms.SCRIPT_INPUT, Forms.SCRIPT_INPUT, "Examples: PLA <b>(typical)</b>, ABS", Forms.INPUT_ICON_BRICKS, true, null);

		inputError = !Forms.isContentValid(layerHeight, method);
		if (inputError && !isDesignService) anyFailure = true;
		m.addFormInput(INPUT_LAYER_HEIGHT, layerHeight, "Layer Height", Forms.ERROR_MESSAGE_REQUIRED, inputError, false, Forms.SCRIPT_INPUT, Forms.SCRIPT_INPUT, "Examples: 0.1mm, 0.2mm <b>(typical)</b>", Forms.INPUT_ICON_WIDTH, true, null);

		m.ln("</div>"); // print-extras
		m.l("<script>");
		if (isDesignService) {
			m.l("selectDesignService();");
		} else {
			m.l("selectPrintService();");
		}
		m.ln("</script>");

		if (!isPost) {
			userId = UUID.randomUUID().toString().replace("-", "");
		} else {
			if ("".equals(userId)) { // This should not blank
				userId = UUID.randomUUID().toString().replace("-", "");
			}
		}
		m.ln("	<div>File Upload</div>");
		m.ln("	<input type=\"hidden\" id=\"userId\" name=\"userId\" value=\"" + userId + "\">");  // TODO resize iframe to correct height
		m.ln(" <iframe id=\"upload-iframe\" class=\"forms-input\" src=\"https://script.google.com/macros/s/AKfycbwSmT5Np3Kaph121292wB1EwLNYWdprGfM4ap2gVforAtmItUw/exec?par="
				+ userId + "\"></iframe>");
		m.ln("	<br><br>");

		inputError = !Forms.isContentValid(comment, method);
		if (inputError) anyFailure = true;
		m.addFormTextArea(Forms.INPUT_COMMENT, comment, "Comment", Forms.ERROR_MESSAGE_REQUIRED, inputError, Forms.SCRIPT_TEXTAREA, Forms.SCRIPT_TEXTAREA, "Any other additions about your project goal or requirements, this can include quantity or any other special considerations", -1, null);

		m.addCAPTCHAInput(null, null);

		final String encoded = requestInfo.getBodyParam("encoded");
		inputError = !Forms.encodedCAPTCHACompareValid(encoded, captcha, method);
		if (inputError) anyFailure = true;
		m.addFormInput(Forms.INPUT_CAPTCHA, "", "Security Check", Forms.ERROR_MESSAGE_INCORRECT, inputError, true, Forms.SCRIPT_INPUT_CAPTCHA, Forms.SCRIPT_INPUT_CAPTCHA, "Copy both numbers", Forms.INPUT_ICON_SECURITY, true, null);

		m.ln("	<button class=\"btn btn-blue ripple\" style=\"width:12rem\" onclick=\"sendEmail()\" value=\"Submit\" aria-label=\"Submit\">Submit</button>");
		if (requestInfo.getMethod() == HttpMethod.POST) {
			if (anyFailure) {
				m.ln("	<p style=\"color:red\">ERROR: missing or invalid fields</p>");
			} else {
				String body = "username: " + user + "\n";
				body += "userId: " + userId + "\n";
				body += "service: " + service + "\n";
				body += "filamentColour: " + filamentColour + "\n";
				body += "filamentMaterial: " + filamentMaterial + "\n";
				body += "layerHeight: " + layerHeight + "\n";
				body += "message:" + comment;

				String result = Tools.sendEmailAWSSMTP("New Quote", body);

				if (!result.equals(Tools.EmailOkayResponse)) {
					m.ln("	<p class=\"forms-param-error\">ERROR: in sending email</p>");
					m.ln("<p>".concat(result).concat("</p>"));
				} else {
					m.ln("	<p class=\"forms-param-good\">SUCCESS: E-mail successfully sent</p>");
				}
			}
		}

		m.ln("<p>Note: Maximum print size of 235mm(X), 235mm(Y), 250mm(Z).");
		m.ln("<br>Depending on your model it maybe possible to print in separate parts");
		m.ln("then friction or chemical weld them into a single piece seamlessly.");
		m.ln("</p>");

		m.ln("</form>"); // 3d-quote

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter(requestInfo);

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
