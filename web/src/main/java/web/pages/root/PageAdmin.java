package web.pages.root;

import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageAdmin extends BasePage {

	public PageAdmin(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TIMELINE,
				Resource.CSS_SIDENAV };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.ln("<html>");
		m.addHead(css, js);

		m.ln("<body>");
		m.addNavbar();

		////
		m.ln("<div class=\"sidenav\">");
		m.ln("	<a href=\"#a\">test</a>");
		m.ln("	<a href=\"#a\">test</a>");
		m.ln("	<a href=\"#a\">test</a>");
		m.ln("	<a href=\"#a\">test</a>");
		m.ln("	<a href=\"#a\">test</a>");

		m.ln("</div>"); // sidenav

		////

		m.ln("<div class=\"common-content\">");
		m.addCard("	<h2><a href=\"/test/admin\"> link</a></h2>");

		////

		m.ln("	<div class=\"timeline-container\">");
		m.ln("		<div class=\"timeline-item\" date-is=\"test date\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h1>sample heading</h1>");
		m.ln("				<p>qas we grd dd gg dgjf fn fl</p>");
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item
		m.ln("		<div class=\"timeline-item\" date-is=\"test date\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h1>sample heading</h1>");
		m.ln("				<p>qas we grd dd gg dgjf fn fl</p>");
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item
		m.ln("		<div class=\"timeline-item\" date-is=\"test date\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h1>sample heading</h1>");
		m.ln("				<p>qas we grd dd gg dgjf fn fl</p>");
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item
		m.ln("		<div class=\"timeline-item\" date-is=\"test date\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h1>sample heading</h1>");
		m.ln("				<p>qas we grd dd gg dgjf fn fl</p>");
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item
		m.ln("		<div class=\"timeline-item\" date-is=\"test date\">");
		m.ln("			<h1>sample heading</h1>");
		m.ln("			<p>qas we grd dd gg dgjf fn fl</p>");
		m.ln("		</div>");
		m.ln("	</div>"); // timeline-container
		////

		m.ln("</div>"); // common-content
		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
