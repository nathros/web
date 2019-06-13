package web.pages;

import java.util.HashMap;
import java.util.Map;

import web.pages.home.*;

public class PageMapping {
	public static Map<String, String> map = createMap();

	private static Map<String, String> createMap() {
		Map<String, String> m = new HashMap<String, String>();
		m.put("404", Page404.class.getName());
		m.put("home", PageHome.class.getName());
		return m;
	}

}