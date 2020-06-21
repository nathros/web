package web.pages.root;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageHome extends BasePage {

	public PageHome(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "Home Page");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Home);
		m.addBannerHomeAnimated(Resource.IMG_BANNER_1);

		////
		m.ln("<div class=\"common-content\" style=\"margin-top:-20rem\">");
		m.ln("	<div class=\"card\">");

		for (int i = 0; i < 12; i++) {
			m.ln("<h2>Title</h2>");
			if (i == 1) {
				m.ln("	<a style=\"text-decoration: none;\" href=\"/stage/spelling\">404 example</a>");
			}
			m.ln("<p>What is Lorem Ipsum?\r\n"
					+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n"
					+ "\r\n" + "Why do we use it?\r\n"
					+ "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\r\n"
					+ "\r\n" + "\r\n" + "Where does it come from?\r\n"
					+ "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\r\n"
					+ "\r\n"
					+ "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.</p>");
		}
		m.ln("<a class=\"btn btn-blue ripple\" style=\"text-align: center;display:block;\" onclick=\"scrollToTop();\">Top</a>");

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content
		////

		m.ln("<script>");
		m.ln(Resource.readResource(Resource.JS_BANNER));
		m.ln(Resource.readResource(Resource.JS_SCROLL_TOP));
		m.ln("</script>");

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
