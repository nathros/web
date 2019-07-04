package web.pages.resources;

import web.common.RequestInfo;
import web.pages.BasePage;

public class JSSnakeRes extends BasePage {

	public JSSnakeRes(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String res = Resource.readResource(Resource.JS_SNAKE);
		return res;
	}
}
