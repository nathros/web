package web.pages;

import java.util.HashMap;
import java.util.Map;

import web.pages.resources.JSSnakeRes;
import web.pages.root.*;
import web.pages.root.projects.PageProjects;
import web.pages.root.sandpit.PageSandpit;
import web.pages.root.sandpit.xhttp.PageXHTTPInner;
import web.pages.root.sandpit.xhttp.PageXHTTPOuter;

public class PageMapping {
	private static Map<String, String> map = createMap();

	private static Map<String, String> createMap() {
		Map<String, String> m = new HashMap<String, String>();
		m.put("/404", Page404.class.getName());
		m.put("/root", PageHome.class.getName());
		m.put("/root/projects", PageProjects.class.getName());
		m.put("/admin", PageAdmin.class.getName());
		m.put("/debug", PageDebug.class.getName());

		// Testing pages
		m.put("/sandpit", PageSandpit.class.getName());
		m.put("/sandpit/xhttpinner", PageXHTTPInner.class.getName());
		m.put("/sandpit/xhttpouter", PageXHTTPOuter.class.getName());

		//
		m.put("/res/snake.js", JSSnakeRes.class.getName());
		return m;
	}

	public static String getPageClassMap(String path, boolean removefirst) {
		if (removefirst) {
			int index = path.indexOf("/", 1);
			int last = path.length();
			if (index != -1) {
				if (path.charAt(path.length() - 1) == '/')
					last--;
				path = path.substring(index, last);
			} else
				return PageHome.class.getName();
		}
		if (path.equals(""))
			return PageHome.class.getName();
		else
			return map.get(path);
	}

}