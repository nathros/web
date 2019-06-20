package web.pages.resources;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Resource {
	public static final String CSS_COMMON = "web/css/common.css";
	public static final String CSS_HEADER = "web/css/header.css";

	public static final String JS_SNAKE_HOOK = "web/js/snake_hook.js";

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
