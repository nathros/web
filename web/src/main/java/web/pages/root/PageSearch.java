package web.pages.root;

import java.lang.reflect.Constructor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import web.common.Forms;
import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.PageMapping;
import web.pages.resources.Resource;

public class PageSearch extends BasePage {

	public PageSearch(RequestInfo request) {
		super(request, false);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_TOGGLE_DIV, Resource.CSS_FOOTER, Resource.CSS_FORMS, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_HEADER, Resource.JS_FORMS };

		m.addHead(css, js, "Search WIP");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Search);
		m.addBanner("Search WIP", Resource.IMG_BANNER_ADMIN);

		final String query = requestInfo.getQueryParam("query");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		m.ln("<form action=\"/stage/search\" name=\"search-form\">");
		m.addFormInput(Forms.INPUT_QUERY, query, "Search", Forms.ERROR_MESSAGE_EMPTY, false, false, Forms.SCRIPT_INPUT, Forms.SCRIPT_INPUT, null, Forms.INPUT_ICON_SEARCH);
		m.ln("	<button class=\"btn btn-blue ripple\" style=\"width:12rem\" onclick=\"sendEmail()\" value=\"Submit\" aria-label=\"Submit\">Search</button>");
		m.ln("</form>");
	
		int results = 0;
		for (String key : PageMapping.map.keySet()) {
			try {
				Class<?> c = Class.forName(PageMapping.map.get(key));
				Constructor<?> cons = c.getConstructor(RequestInfo.class);
				Object object = cons.newInstance(requestInfo);

				BasePage page = (BasePage) object;
				if (page.getIsSearchable()) {
					Document doc = Jsoup.parse(page.getResponse());
					String inner = doc.selectFirst("div:containsOwn(" + query + ")").text();
					
					final int range = 150;
					int index = inner.indexOf(query);
					int start = index - (range / 2);
					if (start < 0) start = 0;
					int end = start + range;
					if (end >= inner.length()) end = inner.length() - 1;
					
					String firstSection = inner.substring(start, index);
					String secondSection = inner.substring(index + query.length(), end);
					
					results++;
					m.ln("<p><b><a href=\"" + key + "\">" + key + "</a></b></p>");
					m.ln("<p>");
					m.l("..." + firstSection);
					m.l("<b>" + query + "</b>");
					m.l(secondSection + "...");
					m.ln("</p><hr>");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(key);
			}
		}

		if (0 == results) {
			m.ln("<p>Not results found<p>");
		}
		
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter();

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
