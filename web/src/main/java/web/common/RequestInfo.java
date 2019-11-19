package web.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import web.pages.PageMapping;
import web.pages.root.PageHome;

public class RequestInfo {
	public LinkedHashMap<String, Objects> requestMap;

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

	public String getPrettyHTML() { // TODO make simpler
		StringBuffer str = new StringBuffer(256);
		List<Object> rootKeys = new ArrayList<Object>(requestMap.keySet());

		str.append("{<br>");
		for (int i = 0; i < rootKeys.size(); i++) {
			Object rootKey = rootKeys.get(i);
			Object rootValue = requestMap.get(rootKey);

			if (rootValue instanceof String) {
				str.append("&nbsp;&nbsp;&nbsp;&nbsp;").append(rootKey).append("=").append(rootValue).append(",<br>");
			} else if (rootValue instanceof LinkedHashMap<?, ?>) {
				str.append("&nbsp;&nbsp;&nbsp;&nbsp;").append(rootKey).append("= {");

				List<Object> childKeys = new ArrayList<Object>(((LinkedHashMap<String, Objects>) rootValue).keySet());
				for (int j = 0; j < childKeys.size(); j++) {
					Object childKey = childKeys.get(j);
					if (((LinkedHashMap<String, Objects>) rootValue).containsKey(childKey)) {
						Object childValue = ((LinkedHashMap<String, Objects>) rootValue).get(childKey);
						str.append("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;").append(childKey).append("=")
								.append(childValue);
						if (j != childKeys.size() - 1)
							str.append(",");
					} else {
						str.append(",&nbsp;&nbsp;<br>;");
					}

				}
				if (childKeys.size() == 0) {
					str.append("}<br>");
				} else {
					str.append("<br>&nbsp;&nbsp&nbsp;&nbsp;}<br>");
				}
			}
		}
		str.append("}");
		return str.toString();

	}

	public String getString() {
		return requestMap.toString();
	}

}
