package web;

import java.util.LinkedHashMap;

public class RequestFactory {

	public static Object getStandard2Param() {
		try {
			// taken from AWS serialised object
			/*
			 * "Request:<br>{body={}, path=/hhh/home, method=GET, params={path1=home},
			 * query={},
			 * headers={accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/
			 * webp,image/apng,/*;q=0.8, accept-encoding=gzip, deflate,
			 * accept-language=en,en-GB;q=0.9,en-US;q=0.8, cookie=SLG_GWPT_Show_Hide_tmp=1;
			 * SLG_wptGlobTipTmp=1, Host=nghb5ux1bj.execute-api.eu-west-1.amazonaws.com,
			 * upgrade-insecure-requests=1, User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64)
			 * AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36
			 * OPR/60.0.3255.151, X-Amzn-Trace-Id=Root=1-5d02cf9e-576bd4f0ceedd2605cdf07a0,
			 * X-Forwarded-For=82.4.155.132, X-Forwarded-Port=443, X-Forwarded-Proto=https}}
			 */
			return Debug.deserialise(
					"rO0ABXNyABdqYXZhLnV0aWwuTGlua2VkSGFzaE1hcDTATlwQbMD7AgABWgALYWNjZXNzT3JkZXJ4cgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAMdwgAAAAQAAAABnQABGJvZHlzcQB+AAA/QAAAAAAAAncIAAAAAgAAAAB4AHQABHBhdGh0AAkvaGhoL2hvbWV0AAZtZXRob2R0AANHRVR0AAZwYXJhbXNzcQB+AAA/QAAAAAAAAXcIAAAAAgAAAAF0AAVwYXRoMXQABGhvbWV4AHQABXF1ZXJ5c3EAfgAAP0AAAAAAAAJ3CAAAAAIAAAAAeAB0AAdoZWFkZXJzc3EAfgAAP0AAAAAAAAx3CAAAABAAAAALdAAGYWNjZXB0dABVdGV4dC9odG1sLGFwcGxpY2F0aW9uL3hodG1sK3htbCxhcHBsaWNhdGlvbi94bWw7cT0wLjksaW1hZ2Uvd2VicCxpbWFnZS9hcG5nLCovKjtxPTAuOHQAD2FjY2VwdC1lbmNvZGluZ3QADWd6aXAsIGRlZmxhdGV0AA9hY2NlcHQtbGFuZ3VhZ2V0ABplbixlbi1HQjtxPTAuOSxlbi1VUztxPTAuOHQABmNvb2tpZXQALVNMR19HV1BUX1Nob3dfSGlkZV90bXA9MTsgU0xHX3dwdEdsb2JUaXBUbXA9MXQABEhvc3R0AC5uZ2hiNXV4MWJqLmV4ZWN1dGUtYXBpLmV1LXdlc3QtMS5hbWF6b25hd3MuY29tdAAZdXBncmFkZS1pbnNlY3VyZS1yZXF1ZXN0c3QAATF0AApVc2VyLUFnZW50dACATW96aWxsYS81LjAgKFdpbmRvd3MgTlQgMTAuMDsgV09XNjQpIEFwcGxlV2ViS2l0LzUzNy4zNiAoS0hUTUwsIGxpa2UgR2Vja28pIENocm9tZS83My4wLjM2ODMuMTAzIFNhZmFyaS81MzcuMzYgT1BSLzYwLjAuMzI1NS4xNTF0AA9YLUFtem4tVHJhY2UtSWR0AChSb290PTEtNWQwMmNmOWUtNTc2YmQ0ZjBjZWVkZDI2MDVjZGYwN2EwdAAPWC1Gb3J3YXJkZWQtRm9ydAAMODIuNC4xNTUuMTMydAAQWC1Gb3J3YXJkZWQtUG9ydHQAAzQ0M3QAEVgtRm9yd2FyZGVkLVByb3RvdAAFaHR0cHN4AHgA");
		} catch (Exception e) {
			return null;
		}
	}

	public static Object getStandard() {
		LinkedHashMap<String, LinkedHashMap<String, String>> map = new LinkedHashMap<>();
		LinkedHashMap<String, String> query = new LinkedHashMap<String, String>();
		query.put("path", "404");
		map.put("query", query);
		return map;
	}

	// gets client query from request
	public static Object getRequestParam(String request) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();

		String paramsStr = "";
		String queryStr = "";
		int index = request.indexOf("?");
		if (index != -1) {
			paramsStr = request.substring(request.indexOf("/"), index);
			queryStr = request.substring(index + 1, request.lastIndexOf(" HTT"));
		} else {
			paramsStr = request.substring(request.indexOf(" /") + 2, request.lastIndexOf(" HTT"));
		}

		LinkedHashMap<String, String> query = new LinkedHashMap<String, String>();
		String[] keyPair = queryStr.split("&");
		for (String i : keyPair) {
			String[] split = i.split("=");
			if (split.length == 2)
				query.put(split[0], split[1]);
		}
		map.put("query", query);

		// LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
		// keyPair = paramsStr.split("/");
		// index = 0;
		// for (String i : keyPair) {
		// params.put("path" + index, i);
		// index++;
		// }
		// map.put("params", params);
		map.put("path", paramsStr);

		return map;
	}

}
