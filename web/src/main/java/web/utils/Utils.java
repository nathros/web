package web.utils;

import org.json.JSONObject;

public class Utils {
	private static JSONObject json;
	
	public static boolean setJSON(String str) {
		if (str == null) return false;
		json = new JSONObject(str.toString());
		return true;
	}

	public static String getRefererURL() {
		return json.getString("referer");
	}
	
	
}
