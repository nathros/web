package web.pages.home;

import web.common.RequestInfo;
import web.pages.BasePage;

public class PageHome extends BasePage {

	public PageHome(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		return "sss";
	}

}
