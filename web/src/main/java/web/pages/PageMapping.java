package web.pages;

import java.util.HashMap;
import java.util.Map;

import web.pages.resources.JSSnakeRes;
import web.pages.root.*;
import web.pages.root.projects.PageProjects;
import web.pages.root.projects.rohloff.RohloffPage1;
import web.pages.root.projects.rohloff.RohloffPage2;
import web.pages.root.projects.rohloff.RohloffPage3;
import web.pages.root.projects.rohloff.RohloffPage4;
import web.pages.root.sandpit.PageSandpit;
import web.pages.root.sandpit.xhttp.PageXHTTPInner;
import web.pages.root.sandpit.xhttp.PageXHTTPOuter;

public class PageMapping {
	public static final String ROHLOFF_PG0 = "/projects/rohloff";
	public static final String ROHLOFF_PG1 = "/projects/rohloff-1";
	public static final String ROHLOFF_PG2 = "/projects/rohloff-2";
	public static final String ROHLOFF_PG3 = "/projects/rohloff-3";
	public static final String ROHLOFF_PG4 = "/projects/rohloff-4";

	private static Map<String, String> map = createMap();

	private static Map<String, String> createMap() {
		Map<String, String> m = new HashMap<String, String>();
		m.put("/404", Page404.class.getName());
		m.put("/root", PageHome.class.getName());
		m.put("/root/projects", PageProjects.class.getName());

		m.put(ROHLOFF_PG0, RohloffPage1.class.getName());
		m.put(ROHLOFF_PG1, RohloffPage1.class.getName());
		m.put(ROHLOFF_PG2, RohloffPage2.class.getName());
		m.put(ROHLOFF_PG3, RohloffPage3.class.getName());
		m.put(ROHLOFF_PG4, RohloffPage4.class.getName());

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