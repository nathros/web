package web.pages;

import java.util.HashMap;
import java.util.Map;

import web.pages.root.*;
import web.pages.root.projects.PageProjects;

public class PageMapping {
	private static Map<String, String> map = createMap();

	private static Map<String, String> createMap() {
		Map<String, String> m = new HashMap<String, String>();
		m.put("/404", Page404.class.getName());
		m.put("/root", PageHome.class.getName());
		m.put("/root/projects", PageProjects.class.getName());
		m.put("/admin", PageAdmin.class.getName());
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