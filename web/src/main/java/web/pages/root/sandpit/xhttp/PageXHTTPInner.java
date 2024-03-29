package web.pages.root.sandpit.xhttp;

import java.text.SimpleDateFormat;
import java.util.Date;

import web.common.RequestInfo;
import web.pages.BasePage;

public class PageXHTTPInner extends BasePage {

	public PageXHTTPInner(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() { // Only returns inner content
		m.p.buffer.delete(0, m.p.buffer.length());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date = new Date(System.currentTimeMillis());
		m.ln(formatter.format(date));
		return m.p.toString();
	}
}
