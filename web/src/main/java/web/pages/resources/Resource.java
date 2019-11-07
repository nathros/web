package web.pages.resources;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Resource {
	public static final String CSS_COMMON = "web/css/common.css"; // includes global css variables
	public static final String CSS_HEADER = "web/css/header.css";
	public static final String CSS_CARD = "web/css/card.css";
	public static final String CSS_TIMELINE = "web/css/timeline.css";
	public static final String CSS_SIDENAV = "web/css/sidenav.css";
	public static final String CSS_TITLE_BANNER = "web/css/title-banner.css";

	public static final String JS_SNAKE_HOOK = "web/js/snake_hook.js";
	public static final String JS_SNAKE = "web/js/snake.js";
	public static final String JS_LOAD_DOC = "web/js/load_doc.js";

	public static final String IMG_FAVICO = "https://i.imgur.com/1BUcNs0.png";

	public static String readResource(String path) {
		try {
			File file = new File(Resource.class.getClassLoader().getResource(path).getFile());
			String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
			return content;
		} catch (Exception e) {
			return "Missing resource " + path;
		}
	}

}
