package web.pages.root;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import web.common.Debug;
import web.common.LocalStringBuffer;
import web.common.NavbarItem;
import web.common.RequestInfo;
import web.database.Database;
import web.database.LogNode;
import web.database.LogRoot;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageAdmin extends BasePage {

	public PageAdmin(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		if (!requestInfo.isDebugCookieTrue()) return new Page404(requestInfo).getResponse();

		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_TOGGLE_DIV, Resource.CSS_FOOTER, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_HEADER, Resource.JS_TOGGLE_DIV };

		m.addHead(css, js, "Admin");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Admin, requestInfo);

		m.addBanner("Admin", Resource.IMG_BANNER_ADMIN);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		LocalStringBuffer ErrorMsg = new LocalStringBuffer(1024);
		ErrorMsg.ln("<p>");
		ErrorMsg.ln("<p><b>Request</b></p>");
		ErrorMsg.ln(requestInfo.getPrettyHTML());
		ErrorMsg.ln("</p><br>");

		try {
			ErrorMsg.ln("<p><b>Request Base64</b></p>");
			ErrorMsg.ln("<div style=\"width: 32rem; word-wrap: break-word\">");
			ErrorMsg.ln(Debug.serialise(requestInfo.requestMap));
			ErrorMsg.ln("</div>");
			ErrorMsg.ln("<br>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		m.ln(m.getContentToggle("<b>Current Request</b>", ErrorMsg.toString()));
		m.ln("<br><hr>");

		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		String startQuery = requestInfo.getQueryParam("start");
		String endQuery = requestInfo.getQueryParam("end");
		LocalDate startDate = null, endDate = null;

		if (startQuery.equals("")) {
			startQuery = formatter.format(LocalDate.now().minusMonths(1));
		}
		try {
			startDate = LocalDate.parse(startQuery, formatter);
		} catch (Exception e) {
			m.ln("<p>Failed to parse start date:" + startQuery + "</p>");
			startQuery = formatter.format(LocalDate.now().minusMonths(1));
			startDate = LocalDate.parse(startQuery, formatter);
		}

		if (endQuery.equals("")) {
			endQuery = formatter.format(LocalDate.now().plusDays(1));
		}
		try {
			endDate = LocalDate.parse(endQuery, formatter);
		} catch (Exception e) {
			m.ln("<p>Failed to parse end date:" + endQuery + "</p>");
			endQuery = formatter.format(LocalDate.now().plusDays(1));
			endDate = LocalDate.parse(endQuery, formatter);
		}
		m.ln("<form>");
		m.ln("	<label style=\"display:inline-block;width:5rem\" for=\"start\">Start date:</label>");
		m.ln("	<input type=\"date\" id=\"start\" name=\"start\" value=\"" + startQuery + "\"><br>");
		m.ln("	<label style=\"display:inline-block;width:5rem\" for=\"end\">End date:</label>");
		m.ln("	<input type=\"date\" id=\"end\" name=\"end\" value=\"" + endQuery + "\">");
		m.ln("	<button class=\"btn btn-blue ripple\" style=\"width:6rem;padding:0\" value=\"Submit\" aria-label=\"Update\">Update</button>");
		m.ln("</form>");
		List<LogRoot> list = Database.getLog(startDate, endDate);
		if (list != null) {
			for (LogRoot i : list) {
				LocalStringBuffer lb = new LocalStringBuffer(1024);
				lb.ln("<div style=\"font-family:monospace\">");
				for (LogNode log: i.entries) {
					lb.ln(log.date);
					lb.ln(log.path);
					lb.ln("<br>");
				}
				lb.ln("</div>");
				String padding = "";
				for (int len = i.address.length(); len < 15; len++) padding += "&nbsp;";
				m.ln(m.getContentToggle("<b style=\"font-family:monospace;font-size:1rem\">" + i.address + padding + " (" + i.entries.size() + ") " + i.lastRequest + "</b>", lb.toString()));
			}
		}
		m.ln("<hr>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter(requestInfo);

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
