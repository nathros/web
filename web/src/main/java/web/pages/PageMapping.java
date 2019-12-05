package web.pages;

import java.util.HashMap;
import java.util.Map;

import web.pages.resources.JSSnakeRes;
import web.pages.root.*;
import web.pages.root.projects.PageProjects;
import web.pages.root.projects.connect4.Connect4Page;
import web.pages.root.projects.fileserver1.FileServerPage1;
import web.pages.root.projects.rohloff.RohloffPage1;
import web.pages.root.projects.rohloff.RohloffPage2;
import web.pages.root.projects.rohloff.RohloffPage3;
import web.pages.root.projects.rohloff.RohloffPage4;
import web.pages.root.sandpit.PageSandpit;
import web.pages.root.sandpit.xhttp.PageXHTTPInner;
import web.pages.root.sandpit.xhttp.PageXHTTPOuter;

public class PageMapping {
	public static final String STAGE = "/stage"; // Name of AWS API stage name, don't forget to update JavaScript links
	public static final String HOME_PG = STAGE + "/";
	public static final String _404_PG = STAGE + "/404";
	public static final String ADMIN_PG = STAGE + "/admin";

	public static final String ROHLOFF_PG0 = STAGE + "/projects/rohloff";
	public static final String ROHLOFF_PG1 = STAGE + "/projects/rohloff-1";
	public static final String ROHLOFF_PG2 = STAGE + "/projects/rohloff-2";
	public static final String ROHLOFF_PG3 = STAGE + "/projects/rohloff-3";
	public static final String ROHLOFF_PG4 = STAGE + "/projects/rohloff-4";
	public static final String FILESERVER1_PG0 = STAGE + "/projects/fileserver";
	public static final String FILESERVER1_PG1 = STAGE + "/projects/fileserver-1";
	public static final String FILESERVER1_PG2 = STAGE + "/projects/fileserver-2";
	public static final String CONNECT4 = STAGE + "/projects/connect4";

	private static Map<String, String> map = createMap();

	private static Map<String, String> createMap() {
		Map<String, String> m = new HashMap<String, String>();
		m.put(HOME_PG, PageHome.class.getName());
		m.put(_404_PG, Page404.class.getName());
		m.put(ADMIN_PG, PageAdmin.class.getName());
		m.put("/root", PageHome.class.getName());
		m.put("/root/projects", PageProjects.class.getName());

		m.put(ROHLOFF_PG0, RohloffPage1.class.getName());
		m.put(ROHLOFF_PG1, RohloffPage1.class.getName());
		m.put(ROHLOFF_PG2, RohloffPage2.class.getName());
		m.put(ROHLOFF_PG3, RohloffPage3.class.getName());
		m.put(ROHLOFF_PG4, RohloffPage4.class.getName());

		m.put(FILESERVER1_PG0, FileServerPage1.class.getName());
		m.put(FILESERVER1_PG1, FileServerPage1.class.getName());
		m.put(FILESERVER1_PG2, FileServerPage1.class.getName());

		m.put(CONNECT4, Connect4Page.class.getName());

		// Resources
		m.put(STAGE + "/res/snake.js", JSSnakeRes.class.getName());

		// Testing pages
		m.put("/debug", PageDebug.class.getName());
		m.put("/sandpit", PageSandpit.class.getName());
		m.put("/sandpit/xhttpinner", PageXHTTPInner.class.getName());
		m.put("/sandpit/xhttpouter", PageXHTTPOuter.class.getName());
		return m;
	}

	public static String getPageClassMap(String path) {
		if (map.containsKey(path)) {
			return map.get(path);
		} else {
			int index = path.indexOf("/", 1);
			int last = path.length();
			if (index != -1) {
				if (path.charAt(path.length() - 1) == '/') {
					last--;
				}
				path = path.substring(index, last);
			} else {
				return PageHome.class.getName();
			}
			return map.get(path);
		}
	}

}