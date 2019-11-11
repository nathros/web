package web.pages.root.projects.rohloff;

import java.util.LinkedHashMap;

import web.common.Markup;
import web.pages.PageMapping;

public class RohloffUtils {

	public static void addRohloffPageSelector(Markup m, int selectedIndex) {
		LinkedHashMap<String, String> items = new LinkedHashMap<String, String>();
		items.put("1", "/stage" + PageMapping.ROHLOFF_PG1);
		items.put("2", "/stage" + PageMapping.ROHLOFF_PG2);
		items.put("3", "/stage" + PageMapping.ROHLOFF_PG3);
		items.put("4", "/stage" + PageMapping.ROHLOFF_PG4);
		m.addPageSelector(items, selectedIndex);
	}

}
