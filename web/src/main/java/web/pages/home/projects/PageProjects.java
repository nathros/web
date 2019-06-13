package web.pages.home.projects;

import web.common.RequestInfo;
import web.pages.BasePage;

public class PageProjects extends BasePage {

	public PageProjects(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		return "projects";
	}

}
