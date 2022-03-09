package web;

import java.util.LinkedHashMap;
import java.util.List;

import web.common.Debug;

public class RequestFactory {

	public static Object getPremadeRequestObject() {
		try {
			// taken from AWS serialised object
			/*
			 * { method=POST,
			 * body=firstname=111&email=getafisidi%40daymailonline.com&subject=Jockey+wheel+
			 * change&comment=sdf%2Csdndsfnj%2Cdsfndjfsndkj, headers= {
			 * accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image
			 * /apng,**;q=0.8,application/signed-exchange;v=b3;q=0.9, accept-encoding=br,
			 * gzip, deflate, accept-language=en,en-GB;q=0.9,en-US;q=0.8,
			 * cache-control=max-age=0, content-type=application/x-www-form-urlencoded,
			 * Host=q6hkaaeqd1.execute-api.eu-west-1.amazonaws.com,
			 * origin=https://q6hkaaeqd1.execute-api.eu-west-1.amazonaws.com,
			 * referer=https://q6hkaaeqd1.execute-api.eu-west-1.amazonaws.com/stage?aa=ff&bb
			 * =ff, sec-fetch-mode=navigate, sec-fetch-site=same-origin, sec-fetch-user=?1,
			 * upgrade-insecure-requests=1, User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64)
			 * AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36
			 * OPR/66.0.3515.44, X-Amzn-Trace-Id=Root=1-5e361f2a-e08a3c339df00ef53fbfb2a9,
			 * X-Forwarded-For=82.4.155.132, X-Forwarded-Port=443, X-Forwarded-Proto=https }
			 * queryParams= { aa=ff, bb=ff } pathParams= {} bodyParams= { firstname=111,
			 * email=getafisidi@daymailonline.com, subject=Jockey wheel change,
			 * comment=sdf,sdndsfnj,dsfndjfsndkj } }
			 */
			return Debug.deserialise(
					"rO0ABXNyABdqYXZhLnV0aWwuTGlua2VkSGFzaE1hcDTATlwQbMD7AgABWgALYWNjZXNzT3JkZXJ4cgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAMdwgAAAAQAAAACHQABGJvZHlzcQB+AAA/QAAAAAAAAncIAAAAAgAAAAB4AHQABHBhdGh0AA4vc3RhZ2UvY29udGFjdHQABm1ldGhvZHQAA0dFVHQACHNvdXJjZUlQdAANODAuMTk0LjExNi41MXQAB2hlYWRlcnNzcQB+AAA/QAAAAAAAGHcIAAAAIAAAABN0AAZhY2NlcHR0AHx0ZXh0L2h0bWwsYXBwbGljYXRpb24veGh0bWwreG1sLGFwcGxpY2F0aW9uL3htbDtxPTAuOSxpbWFnZS93ZWJwLGltYWdlL2FwbmcsKi8qO3E9MC44LGFwcGxpY2F0aW9uL3NpZ25lZC1leGNoYW5nZTt2PWIzO3E9MC45dAAPYWNjZXB0LWVuY29kaW5ndAARZ3ppcCwgZGVmbGF0ZSwgYnJ0AA9hY2NlcHQtbGFuZ3VhZ2V0ABplbi1HQixlbjtxPTAuOSxlbi1VUztxPTAuOHQABmNvb2tpZXQAHnVzZXJuYW1lPUpvaG4gRG9lMTsgZGVidWc9dHJ1ZXQABEhvc3R0AC5xNmhrYWFlcWQxLmV4ZWN1dGUtYXBpLmV1LXdlc3QtMS5hbWF6b25hd3MuY29tdAAHcmVmZXJlcnQARGh0dHBzOi8vcTZoa2FhZXFkMS5leGVjdXRlLWFwaS5ldS13ZXN0LTEuYW1hem9uYXdzLmNvbS9zdGFnZS9jb250YWN0dAAJc2VjLWNoLXVhdABBIkNocm9taXVtIjt2PSI5NCIsICJNaWNyb3NvZnQgRWRnZSI7dj0iOTQiLCAiO05vdCBBIEJyYW5kIjt2PSI5OSJ0ABBzZWMtY2gtdWEtbW9iaWxldAACPzB0ABJzZWMtY2gtdWEtcGxhdGZvcm10AAkiV2luZG93cyJ0AA5zZWMtZmV0Y2gtZGVzdHQACGRvY3VtZW50dAAOc2VjLWZldGNoLW1vZGV0AAhuYXZpZ2F0ZXQADnNlYy1mZXRjaC1zaXRldAALc2FtZS1vcmlnaW50AA5zZWMtZmV0Y2gtdXNlcnQAAj8xdAAZdXBncmFkZS1pbnNlY3VyZS1yZXF1ZXN0c3QAATF0AApVc2VyLUFnZW50dACCTW96aWxsYS81LjAgKFdpbmRvd3MgTlQgMTAuMDsgV2luNjQ7IHg2NCkgQXBwbGVXZWJLaXQvNTM3LjM2IChLSFRNTCwgbGlrZSBHZWNrbykgQ2hyb21lLzk0LjAuNDYwNi43MSBTYWZhcmkvNTM3LjM2IEVkZy85NC4wLjk5Mi4zOHQAD1gtQW16bi1UcmFjZS1JZHQAKFJvb3Q9MS02MTY3MDBiYi0xNTk1ZGEyNjFjODhjYThiNTk0ZjVmMjZ0AA9YLUZvcndhcmRlZC1Gb3J0AA04MC4xOTQuMTE2LjUxdAAQWC1Gb3J3YXJkZWQtUG9ydHQAAzQ0M3QAEVgtRm9yd2FyZGVkLVByb3RvdAAFaHR0cHN4AHQAC3F1ZXJ5UGFyYW1zc3EAfgAAP0AAAAAAAAJ3CAAAAAIAAAAAeAB0AApwYXRoUGFyYW1zc3EAfgAAP0AAAAAAAAF3CAAAAAIAAAABcQB+AAV0AAdjb250YWN0eAB0AApib2R5UGFyYW1zc3EAfgAAP0AAAAAAAAJ3CAAAAAIAAAAAeAB4AA==");
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

	public static Object generateRequestObject(List<String> list) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();

		if (null == list) {
			return map;
		}

		boolean isPost = false;

		String request = list.get(0);
		if (request != null) {
			isPost = request.indexOf("POST") == 0;
			map.put("method", isPost ? "POST" : "GET");

			String paramsStr = "";
			String queryStr = "";
			int index = request.indexOf("?");
			if (index != -1) {
				paramsStr = request.substring(request.indexOf("/"), index);
				queryStr = request.substring(index + 1, request.lastIndexOf(" HTT"));
			} else {
				try {
					paramsStr = request.substring(request.indexOf(" /") + 1, request.lastIndexOf(" HTT"));
				} catch (Exception e) {
					// Do nothing. Firefox can send request which only contains "Body:" method is
					// missing
				}
			}

			LinkedHashMap<String, String> queryParams = new LinkedHashMap<String, String>();
			String[] keyPair = queryStr.split("&");
			for (String i : keyPair) {
				String[] split = i.split("=");
				if (split.length == 2)
					queryParams.put(split[0], split[1]);
			}
			map.put("queryParams", queryParams);
			map.put("path", paramsStr);

			LinkedHashMap<String, Object> cookies = new LinkedHashMap<String, Object>();
			for (String i : list) {
				index = i.indexOf("Cookie: ");
				if (index != -1) {
					cookies.put("cookie", i.substring(index + 8));
					map.put("headers", cookies);
					continue;
				}

				index = i.indexOf("Host: ");
				if (index != -1) {
					String ip = i.substring(index + 6, i.length());
					map.put("sourceIP", ip);
					continue;
				}
			}
		}

		if (isPost) {
			LinkedHashMap<String, String> bodyParams = new LinkedHashMap<String, String>();
			String body = list.get(list.size() - 1);
			String[] split = body.split("&");
			for (int i = 0; i < split.length; i++) {
				String[] keyPair = split[i].split("=");
				if (keyPair.length > 1) {
					bodyParams.put(keyPair[0], keyPair[1]);
				} else if (keyPair.length == 1) {
					bodyParams.put(keyPair[0], "");
				}
			}
			map.put("bodyParams", bodyParams);
		}
		return map;
	}

}
