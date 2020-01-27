package web.pages.root;

import web.common.LocalStringBuffer;
import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageCV extends BasePage {

	public PageCV(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_TOGGLE_DIV, Resource.CSS_TIMELINE };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "CV");

		m.ln("<body>");
		m.addNavbar(NavbarItem.CV);

		m.addBanner("CV", Resource.IMG_BANNER_1);
		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		m.ln("<h2>Experience</h2>");

		LocalStringBuffer job1 = new LocalStringBuffer(1024);
		job1.ln("<p>Detailed description</p>");

		m.ln("	<div class=\"timeline-container\">");

		m.ln("		<div class=\"timeline-item\" date-is=\"2018-2020\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h2>Title</h2>");
		m.ln(m.getContentToggle("<b>Expand Details</b>", job1.toString()));
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item

		m.ln("		<div class=\"timeline-item\" date-is=\"2020-Present\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h2>Title</h2>");
		m.ln(m.getContentToggle("<b>Expand Details</b>", job1.toString()));
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item

		m.ln("	</div>"); // timeline-container

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content
		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
