package web.pages.root;

import java.lang.reflect.Constructor;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import web.common.Forms;
import web.common.LocalStringBuffer;
import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.PageMapping;
import web.pages.resources.Resource;

public class PageSearch extends BasePage {

	public PageSearch(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_TOGGLE_DIV, Resource.CSS_FOOTER, Resource.CSS_FORMS, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_HEADER, Resource.JS_FORMS };

		m.addHead(css, js, "Search");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Search);
		m.addBannerAnimated("Search", Resource.IMG_BANNER_1);

		final String query = requestInfo.getQueryParam("query");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		m.ln("<form action=\"/stage/search\" name=\"search-form\">");
		m.addFormInput(Forms.INPUT_QUERY, query, "Search", Forms.ERROR_MESSAGE_EMPTY, false, false, Forms.SCRIPT_INPUT, Forms.SCRIPT_INPUT, null, Forms.INPUT_ICON_SEARCH, false);
		m.ln("	<button class=\"btn btn-blue ripple\" style=\"width:12rem;margin-top:0.35rem\" onclick=\"sendEmail()\" value=\"Submit\" aria-label=\"Submit\">Search</button>");
		m.ln("</form>");
	
		LocalStringBuffer sb = new LocalStringBuffer(4096);
		int results = 0;
		if ((query != null) && (!query.equals(""))) {
			Set<String> set = PageMapping.searchMap.keySet();
			for (String key : set) {
				try {
					Class<?> c = Class.forName(PageMapping.searchMap.get(key));
					Constructor<?> cons = c.getConstructor(RequestInfo.class);
					Object object = cons.newInstance(requestInfo);

					BasePage page = (BasePage) object;
					Document doc = Jsoup.parse(page.getResponse());
					Elements body = doc.getElementsByClass("common-content"); // ignore title

					Elements result = body.get(0).getElementsContainingOwnText(query);
					if (result.size() == 0) continue;

					String inner = result.get(0).text();
					String lowercase = inner.toLowerCase();

					String title = doc.getElementsByTag("title").get(0).text();

					final int range = 150;
					int index = lowercase.indexOf(query.toLowerCase());
					int start = index - (range / 2);
					if (start < 0) start = 0;
					int end = start + range;
					if (end >= inner.length()) end = inner.length();

					String firstSection = inner.substring(start, index);
					String secondSection;
					if ((index + query.length()) >= end) secondSection = "";
					else secondSection = inner.substring(index + query.length(), end);

					String search = inner.substring(index, index + query.length());

					results++;

					sb.ln("<h3><a href=\"" + key + "\" target=\"_blank\">" + title + "</a></h3>");
					sb.ln("<p>");
					sb.l("..." + firstSection);
					sb.l("<b>" + search + "</b>");
					sb.l(secondSection + "...");
					sb.ln("</p><hr>");
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println(key);
				}
			}
		}

		if (0 == results) {
			m.ln("<p class=\"forms-param-error\">Not results found<p>");
		} else {
			m.ln("<p class=\"forms-param-good\">" + results + " result" + (results > 1 ? "s" : "" ) + " found<p>");
		}
		
		m.ln(sb.toString());

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.addFooter();

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
