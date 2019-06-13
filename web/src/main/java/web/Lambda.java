package web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;

import web.common.RequestInfo;
import web.pages.BasePage;

public class Lambda {

	public String handleRequest(Object input) {
		try {
			RequestInfo request = new RequestInfo(input);

			Class<?> c = Class.forName(request.getPageClass());
			Constructor<?> cons = c.getConstructor(RequestInfo.class);
			Object object = cons.newInstance(request);

			BasePage response = (BasePage) object;
			return response.getResponse();

		} catch (Exception e) { // return exception as response
			String response = e.getMessage() + "\n";
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response += sw.toString();
			return response;
		}
	}

}