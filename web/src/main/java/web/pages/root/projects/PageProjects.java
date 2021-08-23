package web.pages.root.projects;

import web.common.RequestInfo;
import web.pages.BasePage;

public class PageProjects extends BasePage {

	public PageProjects(RequestInfo request) {
		super(request, true);
	}

	@Override
	public String getResponse() {
		return "projects";
	}

}
