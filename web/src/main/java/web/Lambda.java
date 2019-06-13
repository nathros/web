package web;

import java.lang.reflect.Constructor;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.home.Page404;

public class Lambda {

	public String handleRequest(Object input) {
		try {
			RequestInfo request = new RequestInfo(input);

			// Reflect to get page from "path" query parameter
			Class<?> c = Class.forName(request.getPageClass());
			Constructor<?> cons = c.getConstructor(RequestInfo.class);
			Object object = cons.newInstance(request);

			BasePage response = (BasePage) object;
			return response.getResponse();

		} catch (Exception e) { // return exception as response
			Page404 page = new Page404(new RequestInfo(input)); // TODO null
			return page.getResponse(e, input);
		}
	}

}