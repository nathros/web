package web.pages.home;

import web.common.RequestInfo;
import web.pages.BasePage;

public class Page404 extends BasePage {

	public Page404(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		return "404";
	}

}
