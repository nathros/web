package web.pages.root.sandpit;

import web.common.RequestInfo;
import web.pages.BasePage;

public class PageSandpit extends BasePage {

	public PageSandpit(RequestInfo request) {
		super(request, false);
	}

	@Override
	public String getResponse() {
		m.ln("<html lang=\"en\">");
		m.ln("<head>");
		m.ln("<title>Sandpit</title>");
		m.ln("<style>a { color: black; }</style>");
		m.ln("</head>");

		m.ln("<body>");
		m.ln("	<div style=\"text-align: center;\">");
		m.ln("		<a href=\"sandpit/xhttpouter\">xhttpouter</a><br>");
		m.ln("		<a href=\"sandpit/carousel\">carousel</a><br>");
		m.ln("	</div>");
		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
