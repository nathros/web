package web.pages.root;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import web.Scheduled;
import web.common.Debug;
import web.common.Helper;
import web.common.HttpMethod;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class Page3DQuote extends BasePage {

	public Page3DQuote(RequestInfo request) {
		super(request);
	}

	public void addNavbar3D() {
		m.ln("<div class=\"navbar\">");
		m.ln("	<a class=\"navbar-selected\"\">3D Print / Design Quote</a>");
		m.ln("	<a class=\"ebay-logo\" style=\"float:right\" href=\"https://www.ebay.co.uk\" target=\"_blank\">&nbsp;</a>");
		m.ln("</div>"); // navbar
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_3D_QUOTE, Resource.CSS_FORMS };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_3D_QUOTE };

		m.addHead(css, js, "Quote");

		m.ln("<body>");
		addNavbar3D();
		m.addBannerHomeAnimated(Resource.IMG_BANNER_1);

		final boolean isPost = requestInfo.getMethod() == HttpMethod.POST;
		final String user = requestInfo.getBodyParam("user");
		final String comment = requestInfo.getBodyParam("comment");
		final String filamentColour = requestInfo.getBodyParam("filament-colour");
		final String filamentMaterial = requestInfo.getBodyParam("filament-material");
		final String layerHeight = requestInfo.getBodyParam("layer-height");
		final String captcha = requestInfo.getBodyParam("captcha");
		final String service = requestInfo.getBodyParam("service");
		final boolean isDesignService = "designService".equals(service);
		String userId = requestInfo.getBodyParam("userId");

		final String errorParam = " class=\"forms-param-error\"";
		final String requiredParamText = " REQUIRED";
		boolean parseFailure = false;

		////
		m.ln("<div class=\"common-content\" style=\"margin-top:-20rem\">");
		m.ln("	<div class=\"card\">");

		m.ln("<form action=\"3d-quote\" method=\"post\">");

		String style = "";
		String required = "";
		if (isPost) {
			if ("".equals(user)) {
				style = errorParam;
				required = requiredParamText;
				parseFailure = true;
			}
		}
		m.ln("	<div" + style + ">eBay Username or E-mail: * " + required + "</div>");
		m.ln("	<input class=\"forms-input\" type=\"text\" name=\"user\" value=\"" + user + "\">");
		m.ln("	<i class=\"forms-small-text\">Quote will be sent to this address or user</i>");
		m.ln("	<br><br>");

		m.ln("	<div>Service:</div>");
		m.ln("	<div class=\"forms-input\">");
		m.ln("	<div style=\"display:flex;gap:1rem;\">");
		m.ln("		<label id=\"radio-print-label\" class=\"btn btn-blue ripple\" style=\"width:100%;margin-right:1rem\" onclick=\"selectPrintService()\">");
		m.ln(" 			<input id=\"radio-print\" style=\"display:none;\" type=\"radio\" name=\"service\" value=\"printService\">");
		m.ln("			3D Print Service");
		m.ln("		</label>");
		m.ln("		<label id=\"radio-design-label\" class=\"btn btn-light-blue ripple\" style=\"width:100%\" onclick=\"selectDesignService()\">");
		m.ln("			<input id=\"radio-design\" style=\"display:none;\" type=\"radio\" name=\"service\" value=\"designService\">");
		m.ln("			Design Service");
		m.ln("		</label>");
		m.ln("	</div>"); // forms-input
		m.ln("	</div>"); // forms-input
		m.ln("	<i class=\"forms-small-text\">What kind of service you require</i>");
		m.ln("	<br><br>");

		style = "";
		required = "";
		if (isPost) {
			if ("".equals(filamentColour)) {
				style = errorParam;
				required = requiredParamText;
				if (!isDesignService) {
					parseFailure = true;
				}
			}
		}
		m.ln("<div id=\"print-extras\" class=\"print-extras\">");

		m.ln("	<div" + style + ">Filament Colour: * " + required + "</div>");
		m.ln("	<input class=\"forms-input\" type=\"text\" name=\"filament-colour\" value=\"" + filamentColour + "\">");
		m.ln("	<i class=\"forms-small-text\">Examples: Black, Green, Red</i>");
		m.ln("	<br><br>");

		style = "";
		required = "";
		if (isPost) {
			if ("".equals(filamentMaterial)) {
				style = errorParam;
				required = requiredParamText;
				if (!isDesignService) {
					parseFailure = true;
				}
			}
		}
		m.ln("	<div" + style + ">Filament Material: * " + required + "</div>");
		m.ln("	<input class=\"forms-input\" type=\"text\" name=\"filament-material\" value=\"" + filamentMaterial
				+ "\">");
		m.ln("	<i class=\"forms-small-text\">Examples: PLA <b>(typical)</b>, ABS</i>");
		m.ln("	<br><br>");

		style = "";
		required = "";
		if (isPost) {
			if ("".equals(layerHeight)) {
				style = errorParam;
				required = requiredParamText;
				if (!isDesignService) {
					parseFailure = true;
				}
			}
		}
		m.ln("	<div" + style + ">Layer Height: * " + required + "</div>");
		m.ln("	<input class=\"forms-input\" type=\"text\" name=\"layer-height\" value=\"" + layerHeight + "\">");
		m.ln("	<i class=\"forms-small-text\">Examples: 0.1mm, 0.2mm <b>(typical)</b></i>");
		m.ln("	<br><br>");

		m.ln("</div>"); // print-extras
		m.l("<script>");
		if (isDesignService) {
			m.l("selectDesignService();");
		} else {
			m.l("selectPrintService();");
		}
		m.ln("</script>");

		if (!isPost) { // TODO resize iframe to correct height
			userId = UUID.randomUUID().toString().replace("-", "");
		} else {
			if ("".equals(userId)) { // This should not blank
				userId = UUID.randomUUID().toString().replace("-", "");
			}
		}
		m.ln("	<div>File Upload</div>");
		m.ln("	<input type=\"hidden\" id=\"userId\" name=\"userId\" value=\"" + userId + "\">");
		m.ln(" <iframe id=\"upload-iframe\" class=\"forms-input\" src=\"https://script.google.com/macros/s/AKfycbwSmT5Np3Kaph121292wB1EwLNYWdprGfM4ap2gVforAtmItUw/exec?par="
				+ userId + "\" frameBorder=\"0\"\"></iframe>");
		m.ln("	<br><br>");

		style = "";
		required = "";
		if (isPost) {
			if (comment.equals("")) {
				style = errorParam;
				required = requiredParamText;
				parseFailure = true;
			}
		}
		m.ln("	<div" + style + ">Details: * " + required + "</div>");
		m.ln("	<textarea rows=\"12\" cols=\"100\" name=\"comment\">");
		if (isPost) {
			if (!comment.equals("")) {
				m.l(comment);
			}
		}
		m.ln("</textarea>");
		m.ln("	<i class=\"forms-small-text\">Any other additions about your project goal or requirements.");
		m.ln("This can include quantity or any other special considerations.</i><br><br>");

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
		m.ln("<img style=\"border: 1px solid gray;\" src=\"" + cap + "\">");

		final String encoded = requestInfo.getBodyParam("encoded");
		style = "";
		required = "";
		if (isPost) {
			if ("".equals(captcha)) {
				style = errorParam;
				required = "INCORRECT";
				parseFailure = true;
			} else {
				try {
					String compare = Debug.serialise(captcha);
					if (!compare.equals(encoded)) {
						style = errorParam;
						required = "INCORRECT";
						parseFailure = true;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		m.ln("	<div" + style + ">Security Check: * " + required + "</div>");
		m.ln("	<input class=\"forms-input\" type=\"text\" name=\"captcha\" value=\"\" autocomplete=\"off\">");
		m.ln("	<i class=\"forms-small-text\">Add both numbers together</i>");
		String encodedCaptcha = "";
		try {
			encodedCaptcha = Debug.serialise(String.valueOf(number1 + number2));
		} catch (IOException e) {
			e.printStackTrace();
		}
		m.ln("	<input type=\"hidden\" id=\"encoded\" name=\"encoded\" value=\"" + encodedCaptcha + "\">");
		m.ln("	<br><br>");

		m.ln("	<input class=\"btn btn-blue ripple\" type=\"submit\" value=\"Submit\">");
		if (isPost) {
			if (parseFailure) {
				m.ln("	<p style=\"color:red\">ERROR: missing or invalid fields</p>");
			} else {
				m.ln("	<p style=\"color:green\">SUCCESS: E-mail successfully sent</p>");
				String body = "username: " + user + "\n";
				body += "userId: " + userId + "\n";
				body += "service: " + service + "\n";
				body += "filamentColour: " + filamentColour + "\n";
				body += "filamentMaterial: " + filamentMaterial + "\n";
				body += "layerHeight: " + layerHeight + "\n";
				body += "message:" + comment;
				Scheduled.scheduleEmail("New Quote", body);
			}
		}

		m.ln("<p>Note: Maximum print size of 235mm(X), 235mm(Y), 250mm(Z).");
		m.ln("<br>Depending on your model it maybe possible to print in separate parts");
		m.ln("then friction or chemical weld them into a single piece seamlessly.");
		m.ln("</p>");

		m.ln("</form>"); // 3d-quote

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content
		////

		m.ln("<script>");
		m.ln(Resource.readResource(Resource.JS_BANNER));
		m.ln("</script>");

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
