package web.pages.ajax;

import java.io.IOException;
import java.util.List;

import web.common.Debug;
import web.common.Forms;
import web.common.Helper;
import web.common.RequestInfo;
import web.pages.BasePage;

public class AJAXNewCAPTCHA extends BasePage {

	public AJAXNewCAPTCHA(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() { // Only returns inner content
		List<Integer> numbers = Forms.getNewCAPTCHANumbers();
		String cap = Helper.generateCAPTCHAImageAsBase64(numbers.get(0), numbers.get(1), false);

		String encodedCaptcha = "";
		try {
			encodedCaptcha = Debug.serialise(String.valueOf(numbers.get(0)) + String.valueOf(numbers.get(1)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		cap += "@" + encodedCaptcha;
		return cap;
	}
}
