package web.pages.root.sandpit.activeshow;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;
import web.pages.root.Page404;

public class PageActiveShow extends BasePage {

	public PageActiveShow(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		if (!requestInfo.isDebugCookieTrue()) return new Page404(requestInfo).getResponse();

		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_FORMS};
		String[] js = { Resource.JS_HEADER, Resource.JS_FORMS };

		m.addHead(css, js, "Active Show");
		m.ln("<style>.comment-reply1 {"
				+ "	cursor: pointer;"
				+ "}"
				+ ""
				+ ".comment-box1 {"
				+ "	display: none;"
				+ "}"
				+ ""
				+ ".comment-reply1:focus + .comment-box1 {"
				+ "	display: block;"
				+ "}"
				+ ""
				+ ".comment-box1:focus-within, .comment-box1:active {"
				+ "	display: block !important;"
				+ "}</style>");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Sandpit, requestInfo);

		m.ln("<div class=\"common-content\">");
		m.ln("<div class=\"card\">");

		m.ln("	<div style=\"text-align: left; margin-top: 3rem;\">");

		m.ln("<a class=\"comment-reply1\" tabindex=\"1\">Click Here</a>");

		m.ln("<div class=\"comment-box1\">");
		m.ln("<div>Name: * <b style=\"display:none\">REQUIRED</b></div>");
		m.ln("<div class=\"input-group forms-input\">"
				+ "		<input class=\"input-error\" type=\"text\" name=\"email\" value=\"\" aria-label=\"email\" onfocusout=\"checkInputEmailLeave(this)\" oninput=\"checkInputEmail(this)\" error=\"true\">"
				+ "		<div class=\"input-icon input-icon-error\"><i class=\"input-icon-email\"></i></div>"
				+ "		</div>");
		m.ln("<textarea>");
		m.ln("Will remain visible on active or focus");
		m.ln("</textarea>");
		m.ln("<a class=\"btn btn-blue ripple\" >Submit</a>");

		m.ln("	</div>");

		m.ln("</div>"); // card
		m.ln("</div>"); //common-content

		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
