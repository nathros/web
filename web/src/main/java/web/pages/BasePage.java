package web.pages;

import web.common.Markup;
import web.common.RequestInfo;

public abstract class BasePage {

	protected RequestInfo requestInfo;
	protected Markup m = new Markup();

	protected BasePage(RequestInfo request) {
		requestInfo = request;
	}

	public abstract String getResponse();

}
