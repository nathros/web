package web.pages.root.sandpit.carousel;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;
import web.pages.root.Page404;

public class PageCarousel extends BasePage {

	public PageCarousel(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		if (!requestInfo.isDebugCookieTrue()) return new Page404(requestInfo).getResponse();

		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_CAROUSEL };
		String[] js = { Resource.JS_HEADER };

		m.addHead(css, js, "Home Page");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Sandpit, requestInfo);

		////
		m.ln("	<div class=\"carousel\">");
		m.ln("		<input checked type=radio name=\"slider\" id=\"slide1\"/>");
		m.ln("		<input type=radio name=\"slider\" id=\"slide2\"/>");
		m.ln("		<input type=radio name=\"slider\" id=\"slide3\"/>");
		m.ln("		<input type=radio name=\"slider\" id=\"slide4\"/>");
		m.ln("		<input type=radio name=\"slider\" id=\"slide5\"/>");
		m.ln("		<div class=\"slider-wrapper\">");
		m.ln("			<div class=\"inner-wrapper\">");

		m.ln("				<article class=\"slide\">");
		m.ln("					<div class=\"info top-left\"><h3>Malacca</h3></div>");
		m.ln("					<a href=\"https://google.com\">");
		m.ln("						<img src=\"https://image.shutterstock.com/image-illustration/abstract-blue-background-diagonal-lines-600w-2053988348.jpg\"/>");
		m.ln("					</a>");
		m.ln("				</article>");

		m.ln("				<article class=\"slide\">");
		m.ln("					<div class=\"info top-left\"><h3>Malacca</h3></div>");
		m.ln("					<a href=\"https://google.com\">");
		m.ln("						<img src=\"https://image.shutterstock.com/image-illustration/yellow-blue-colored-grunge-backgroundyellow-600w-1998646751.jpg\"/>");
		m.ln("					</a>");
		m.ln("				</article>");

		m.ln("				<article class=\"slide\">");
		m.ln("					<div class=\"info top-left\"><h3>Malacca</h3></div>");
		m.ln("					<a href=\"https://google.com\">");
		m.ln("						<img src=\"https://image.shutterstock.com/image-illustration/abstract-blue-background-diagonal-lines-600w-2053988348.jpg\"/>");
		m.ln("					</a>");
		m.ln("				</article>");

		m.ln("				<article class=\"slide\">");
		m.ln("					<div class=\"info top-left\"><h3>Malacca</h3></div>");
		m.ln("					<a href=\"https://google.com\">");
		m.ln("						<img src=\"https://image.shutterstock.com/image-illustration/yellow-blue-colored-grunge-backgroundyellow-600w-1998646751.jpg\"/>");
		m.ln("					</a>");
		m.ln("				</article>");

		m.ln("				<article class=\"slide\">");
		m.ln("					<div class=\"info top-left\"><h3>Malacca</h3></div>");
		m.ln("					<a href=\"https://google.com\">");
		m.ln("						<img src=\"https://image.shutterstock.com/image-illustration/abstract-blue-background-diagonal-lines-600w-2053988348.jpg\"/>");
		m.ln("					</a>");
		m.ln("				</article>");

		m.ln("			</div>"); // inner
		m.ln("		</div>"); // slider-wrapper

		m.ln("		<div class=\"slider-prev-next-control\">");
		m.ln("			<label for=slide1></label>");
		m.ln("			<label for=slide2></label>");
		m.ln("			<label for=slide3></label>");
		m.ln("			<label for=slide4></label>");
		m.ln("			<label for=slide5></label>");
		m.ln("		</div>"); // slider-prev-next-control

		m.ln("		<div class=\"slider-dot-control\">");
		m.ln("			<label for=slide1></label>");
		m.ln("			<label for=slide2></label>");
		m.ln("			<label for=slide3></label>");
		m.ln("			<label for=slide4></label>");
		m.ln("			<label for=slide5></label>");
		m.ln("		</div>"); // slider-dot-control
		/// ....
		m.ln("	</div>"); // carousel
		////

		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
