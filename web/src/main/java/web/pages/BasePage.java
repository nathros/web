package web.pages;

import web.common.Markup;
import web.common.RequestInfo;

public abstract class BasePage {

	protected RequestInfo requestInfo;
	protected Markup m = new Markup();
	protected boolean searchable;

	protected BasePage(RequestInfo request, boolean isSearchable) {
		requestInfo = request;
		searchable = isSearchable;
	}

	public abstract String getResponse();

	public boolean getIsSearchable() {
		return searchable;
	}
}
