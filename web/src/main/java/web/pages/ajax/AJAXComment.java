package web.pages.ajax;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import web.common.Forms;
import web.common.HttpMethod;
import web.common.RequestInfo;
import web.database.Database;
import web.pages.BasePage;

public class AJAXComment extends BasePage {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z");

	public AJAXComment(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() { // Only returns inner content
		if (HttpMethod.POST == requestInfo.getMethod()) {
			final String level = requestInfo.getBodyParam("level");
			final String action = requestInfo.getBodyParam("action");
			String page = requestInfo.getBodyParam("page");

			if (action.equals("") || page.equals("")) {
				return "ERROR 1";
			}

			int index = page.indexOf("//");
			if (index > 0) {
				page = page.substring(index + 2);
				index = page.indexOf("/");
				if (index > 0) {
					page = page.substring(index);
				}
			}
			if (index == -1) return "ERROR 2";

			if (action.equals("reply")) {
				final String user = requestInfo.getBodyParam("user");
				final String comment = requestInfo.getBodyParam("comment");
				final String date = ZonedDateTime.now().format(formatter);
				final String captcha = requestInfo.getBodyParam("captcha");
				final String encoded = requestInfo.getBodyParam("encoded");
				if (Forms.encodedCAPTCHACompareValid(encoded, captcha, HttpMethod.POST)) {
					if (!Database.addNewComment(page, level, user, comment, date)) {
						return "ERROR 6";
					}
				} else {
					return "ERROR7";
				}

			} else if (action.equals("delete")) {
				if (requestInfo.isDebugCookieTrue()) {
					if (!Database.delComment(page, level)) {
						return "ERROR 7";
					}
				}
				else return "ERROR 5";

			} else if (action.equals("refresh")) {
				m.addCommentsTree(requestInfo, page);
				return m.p.toString();

			}
			else {
				return "ERROR 3";
			}

			m.addCommentsTree(requestInfo, page);
			return m.p.toString();
		}
		return "ERROR 4";
	}
}
