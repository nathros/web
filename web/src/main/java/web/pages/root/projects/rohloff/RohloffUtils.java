package web.pages.root.projects.rohloff;

import java.util.LinkedHashMap;

import web.common.Markup;
import web.pages.PageMapping;

public class RohloffUtils {

	public static void addRohloffPageSelector(Markup m, int selectedIndex) {
		LinkedHashMap<String, String> items = new LinkedHashMap<String, String>();
		items.put("Background", PageMapping.ROHLOFF_PG1);
		items.put("Specifications", PageMapping.ROHLOFF_PG2);
		items.put("Belt Transmittion", PageMapping.ROHLOFF_PG3);
		items.put("Flat-mount Adapter", PageMapping.ROHLOFF_PG4);
		items.put("Wheel Build", PageMapping.ROHLOFF_PG5);
		items.put("Headset Spacers", PageMapping.ROHLOFF_PG6);
		items.put("Drop Bar Shifting", PageMapping.ROHLOFF_PG7);
		m.addPageSelector(items, selectedIndex);
	}

	public static void addRohloff2PageSelector(Markup m, int selectedIndex) {
		LinkedHashMap<String, String> items = new LinkedHashMap<String, String>();
		items.put("Background", PageMapping.ROHLOFF2_PG1);
		items.put("Frame", PageMapping.ROHLOFF2_PG2);
		items.put("A12", PageMapping.ROHLOFF2_PG3);
		items.put("Lights", PageMapping.ROHLOFF2_PG4);
		m.addPageSelector(items, selectedIndex);
	}

}
