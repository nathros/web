package web.common;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import web.pages.PageMapping;
import web.pages.home.PageHome;

public class RequestInfo {
	private JSONObject requestJSON;
	private Map<String, String> queryMap;

	public RequestInfo(Object requestJSON) {
		if (requestJSON == null)
			this.requestJSON = new JSONObject("{}");
		else
			this.requestJSON = new JSONObject(requestJSON.toString());
		queryMap = populateQueries(getQuery());
	}

	private Map<String, String> populateQueries(String query) {
		Map<String, String> map = new HashMap<String, String>();
		String[] split = query.split("&");
		for (String i : split) {
			String[] keyValue = i.split("=");
			map.put(keyValue[0], keyValue[1]);
		}
		return map;
	}

	public String getQuery() {
		return requestJSON.getString("query");
	}

	public String getRefererURL() {
		return requestJSON.getString("referer");
	}

	public String getPageClass() {
		try {
			String ret = queryMap.get("path");
			if ((ret == null) || (ret == ""))
				return PageHome.class.getName();
			else {
				String classRef = PageMapping.map.get(ret);
				return classRef;
			}
		} catch (JSONException e) {
			return PageHome.class.getName();
		}

	}
}
