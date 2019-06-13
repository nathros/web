package web.pages;

import web.common.RequestInfo;

public abstract class BasePage {

	protected RequestInfo requestInfo;

	protected BasePage(RequestInfo request) {
		requestInfo = request;
	}

	public abstract String getResponse();

}
