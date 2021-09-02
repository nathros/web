package web.pages;

import java.util.HashMap;
import java.util.Map;

import web.pages.ajax.AJAXNewCAPTCHA;
import web.pages.resources.JSSnakeRes;
import web.pages.root.*;
import web.pages.root.projects.PageProjects;
import web.pages.root.projects.connect4.Connect4Page;
import web.pages.root.projects.fileserver1.FileServerPage1;
import web.pages.root.projects.rohloff.RohloffPage1;
import web.pages.root.projects.rohloff.RohloffPage2;
import web.pages.root.projects.rohloff.RohloffPage3;
import web.pages.root.projects.rohloff.RohloffPage4;
import web.pages.root.projects.rohloff.RohloffPage5;
import web.pages.root.projects.rohloff.RohloffPage6;
import web.pages.root.projects.rohloff.RohloffPage7;
import web.pages.root.projects.rohloff2.PageRohloffR21;
import web.pages.root.projects.rohloff2.PageRohloffR22;
import web.pages.root.projects.rohloff2.PageRohloffR23;
import web.pages.root.projects.rohloff2.PageRohloffR24;
import web.pages.root.sandpit.PageSandpit;
import web.pages.root.sandpit.carousel.PageCarousel;
import web.pages.root.sandpit.xhttp.PageXHTTPInner;
import web.pages.root.sandpit.xhttp.PageXHTTPOuter;

public class PageMapping {
	public static final String STAGE = "/stage"; // Name of AWS API stage name, don't forget to update JavaScript links
	public static final String HOME_PG = STAGE + "/";
	public static final String _404_PG = STAGE + "/404";
	public static final String ADMIN_PG = STAGE + "/admin";
	public static final String CV_PG = STAGE + "/cv";
	public static final String CONTACT_PG = STAGE + "/contact";
	public static final String QUOTE_3D_PG = STAGE + "/3d-quote";
	public static final String SEARCH_PG = STAGE + "/search";

	public static final String AJAX_NEW_CAPTCHA = STAGE + "/ajax/new-captcha";

	public static final String ROHLOFF_PG0 = STAGE + "/projects/rohloff";
	public static final String ROHLOFF_PG1 = STAGE + "/projects/rohloff-1";
	public static final String ROHLOFF_PG2 = STAGE + "/projects/rohloff-2";
	public static final String ROHLOFF_PG3 = STAGE + "/projects/rohloff-3";
	public static final String ROHLOFF_PG4 = STAGE + "/projects/rohloff-4";
	public static final String ROHLOFF_PG5 = STAGE + "/projects/rohloff-5";
	public static final String ROHLOFF_PG6 = STAGE + "/projects/rohloff-6";
	public static final String ROHLOFF_PG7 = STAGE + "/projects/rohloff-7";

	public static final String ROHLOFF2_PG1 = STAGE + "/projects/rohloff2-1";
	public static final String ROHLOFF2_PG2 = STAGE + "/projects/rohloff2-2";
	public static final String ROHLOFF2_PG3 = STAGE + "/projects/rohloff2-3";
	public static final String ROHLOFF2_PG4 = STAGE + "/projects/rohloff2-4";

	public static final String FILESERVER1_PG0 = STAGE + "/projects/fileserver";
	public static final String FILESERVER1_PG1 = STAGE + "/projects/fileserver-1";
	public static final String FILESERVER1_PG2 = STAGE + "/projects/fileserver-2";
	public static final String CONNECT4 = STAGE + "/projects/connect4";

	public static Map<String, String> map = createMap();
	public static Map<String, String> searchMap = createSearchMap();

	private static Map<String, String> createMap() {
		Map<String, String> m = new HashMap<String, String>();
		m.put(HOME_PG, PageHome.class.getName());
		m.put(_404_PG, Page404.class.getName());
		m.put(ADMIN_PG, PageAdmin.class.getName());
		m.put("/root", PageHome.class.getName());
		m.put("/root/projects", PageProjects.class.getName());
		m.put(CV_PG, PageCV.class.getName());
		m.put(CONTACT_PG, PageContact.class.getName());
		m.put(QUOTE_3D_PG, Page3DQuote.class.getName());
		m.put(SEARCH_PG, PageSearch.class.getName());

		// AJAX
		m.put(AJAX_NEW_CAPTCHA, AJAXNewCAPTCHA.class.getName());

		m.put(ROHLOFF_PG0, RohloffPage1.class.getName());
		m.put(ROHLOFF_PG1, RohloffPage1.class.getName());
		m.put(ROHLOFF_PG2, RohloffPage2.class.getName());
		m.put(ROHLOFF_PG3, RohloffPage3.class.getName());
		m.put(ROHLOFF_PG4, RohloffPage4.class.getName());
		m.put(ROHLOFF_PG5, RohloffPage5.class.getName());
		m.put(ROHLOFF_PG6, RohloffPage6.class.getName());
		m.put(ROHLOFF_PG7, RohloffPage7.class.getName());

		m.put(ROHLOFF2_PG1, PageRohloffR21.class.getName());
		m.put(ROHLOFF2_PG2, PageRohloffR22.class.getName());
		m.put(ROHLOFF2_PG3, PageRohloffR23.class.getName());
		m.put(ROHLOFF2_PG4, PageRohloffR24.class.getName());

		m.put(FILESERVER1_PG0, FileServerPage1.class.getName());
		//m.put(FILESERVER1_PG1, FileServerPage1.class.getName());
		//m.put(FILESERVER1_PG2, FileServerPage1.class.getName());

		m.put(CONNECT4, Connect4Page.class.getName());

		// Resources
		m.put(STAGE + "/res/snake.js", JSSnakeRes.class.getName());

		// Testing pages
		m.put("/debug", PageDebug.class.getName());
		m.put("/sandpit", PageSandpit.class.getName());
		m.put("/sandpit/xhttpinner", PageXHTTPInner.class.getName());
		m.put("/sandpit/xhttpouter", PageXHTTPOuter.class.getName());
		m.put("/sandpit/carousel", PageCarousel.class.getName());
		return m;
	}

	private static Map<String, String> createSearchMap() {
		Map<String, String> m = new HashMap<String, String>();
		m.put(HOME_PG, PageHome.class.getName());
		m.put("/root/projects", PageProjects.class.getName());
		m.put(CV_PG, PageCV.class.getName());
		m.put(CONTACT_PG, PageContact.class.getName());
		m.put(QUOTE_3D_PG, Page3DQuote.class.getName());

		m.put(ROHLOFF_PG1, RohloffPage1.class.getName());
		m.put(ROHLOFF_PG2, RohloffPage2.class.getName());
		m.put(ROHLOFF_PG3, RohloffPage3.class.getName());
		m.put(ROHLOFF_PG4, RohloffPage4.class.getName());
		m.put(ROHLOFF_PG5, RohloffPage5.class.getName());
		m.put(ROHLOFF_PG6, RohloffPage6.class.getName());
		m.put(ROHLOFF_PG7, RohloffPage7.class.getName());

		m.put(ROHLOFF2_PG1, PageRohloffR21.class.getName());
		m.put(ROHLOFF2_PG2, PageRohloffR22.class.getName());
		m.put(ROHLOFF2_PG3, PageRohloffR23.class.getName());
		m.put(ROHLOFF2_PG4, PageRohloffR24.class.getName());

		m.put(FILESERVER1_PG1, FileServerPage1.class.getName());

		m.put(CONNECT4, Connect4Page.class.getName());
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