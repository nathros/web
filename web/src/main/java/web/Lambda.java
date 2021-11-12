package web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.root.Page404;

public class Lambda {

	public String handleRequest(Object input) {
		RequestInfo request = null;
		try {
			request = new RequestInfo(input);

			// Reflect to get page from URL "path" parameter
			Class<?> c = Class.forName(request.getPageClass());
			Constructor<?> cons = c.getConstructor(RequestInfo.class);
			Object object = cons.newInstance(request);

			BasePage response = (BasePage) object;
			String result = response.getResponse();

			Scheduled.run(request);

			return result;

		} catch (Exception e) { // return exception as response
			try {
				Page404 page = new Page404(request);
				return page.getResponse(e, input);
			} catch (Exception e2) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				return sw.toString();
			}
		}
	}

}