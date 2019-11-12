package web.common;

import java.util.LinkedHashMap;
import java.util.Objects;

import web.pages.PageMapping;
import web.pages.root.PageHome;

public class RequestInfo {
	private LinkedHashMap<String, Objects> requestMap;

	@SuppressWarnings("unchecked") // TODO better solution
	public RequestInfo(Object request) {
		if (request instanceof LinkedHashMap<?, ?>) {
			requestMap = (LinkedHashMap<String, Objects>) request;
		}
	}

	public String getPageClass() {
		try {
			Object o = requestMap.get("path");
			String ret = o.toString();
			if ((ret == null) || (ret == ""))
				return PageHome.class.getName();
			else {
				String classRef = PageMapping.getPageClassMap(ret);
				return classRef;
			}
		} catch (Exception e) {
			return PageHome.class.getName();
		}

	}

}
