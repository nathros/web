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
	public static final String CSS_MODAL_IMAGE = "web/css/modal-image.css";
	public static final String CSS_BUTTON = "web/css/button.css";
	public static final String CSS_TOOLTIP = "web/css/tooltip.css";
	public static final String CSS_TOGGLE_DIV = "web/css/toggle-div.css";
	public static final String CSS_CAROUSEL = "web/css/carousel.css";
	public static final String CSS_FORMS = "web/css/forms.css";
	public static final String CSS_3D_QUOTE = "web/css/3d-quote.css";
	public static final String CSS_H_SECTION = "web/css/horizontal-section.css";
	public static final String CSS_TABS = "web/css/tabs.css";
	public static final String CSS_LOGOS = "web/css/logos.css";
	public static final String CSS_FOOTER = "web/css/footer.css";
	public static final String CSS_FLEX_LIST = "web/css/flex-list.css";

	public static final String JS_SNAKE_HOOK = "web/js/snake_hook.js";
	public static final String JS_SNAKE = "web/js/snake.js";
	public static final String JS_SCROLL_TOP = "web/js/scroll-top.js";
	public static final String JS_MODAL_IMAGE = "web/js/modal-image.js";
	public static final String JS_LOAD_DOC = "web/js/load_doc.js";
	public static final String JS_3D_QUOTE = "web/js/3d-quote.js";
	public static final String JS_FORMS = "web/js/forms.js";
	public static final String JS_TOGGLE_DIV = "web/js/toggle-div.js";
	public static final String JS_HEADER = "web/js/header.js";
	public static final String JS_LOAD_DYNAMIC = "web/js/load-dynamic.js";
	public static final String JS_TOOLTIP = "web/js/tooltip.js";

	public static final String IMG_BANNER_1 = "https://i.imgur.com/dtgWhuG.jpg";
	public static final String IMG_BANNER_2 = "https://i.imgur.com/9p0HPN7.jpg";
	public static final String IMG_BANNER_FILESERVER1 = "https://i.imgur.com/yWHI2Wi.jpg";
	public static final String IMG_BANNER_ADMIN = "https://i.imgur.com/acO3yV1.jpg";
	public static final String IMG_BANNER_CONNECT4 = "https://i.imgur.com/DVdR2SS.jpg";
	public static final String IMG_BANNER_ROHLOFF = "https://i.imgur.com/VKIHXq8.jpg";

	// pg 1
	public static final String IMG_ROHLOFF_FINAL_COMPLETE_TN = "https://i.imgur.com/8R4I2rP.jpg";
	public static final String IMG_ROHLOFF_FINAL_COMPLETE = "https://i.imgur.com/VcIacQh.jpg";

	// pg 2
	public static final String IMG_ROHLOFF_GEAR_BELT = "https://i.imgur.com/yrghhYU.png";
	public static final String IMG_ROHLOFF_GEAR_COMPACT = "https://i.imgur.com/MdtxT0o.png";
	public static final String IMG_ROHLOFF_GEAR_MTB = "https://i.imgur.com/ZJ2e4YP.png";
	public static final String IMG_ROHLOFF_FSA_CRANK_TN = "https://i.imgur.com/tyFeOR7.jpg";
	public static final String IMG_ROHLOFF_FSA_CRANK = "https://i.imgur.com/0qYstqY.jpg";
	public static final String IMG_ROHLOFF_BITEX_HUB = "https://i.imgur.com/06MWHaQ.jpg";
	public static final String IMG_ROHLOFF_RFORCE_TI_TN = "https://i.imgur.com/tSihQl3.jpg";
	public static final String IMG_ROHLOFF_RFORCE_TI = "https://i.imgur.com/bOVrxJQ.jpg";
	public static final String IMG_ROHLOFF_OKO_TN = "https://i.imgur.com/ScrdfYf.jpg";
	public static final String IMG_ROHLOFF_OKO = "https://i.imgur.com/8MHWJB5.jpg";
	public static final String IMG_ROHLOFF_HANDLEBAR = "https://i.imgur.com/w1lxLfq.jpg";
	public static final String IMG_ROHLOFF_SPOKE = "https://i.imgur.com/Mjb6mp3.png";
	public static final String IMG_ROHLOFF_SPOKE_STAT_1 = "https://i.imgur.com/Bqg9dbd.png";
	public static final String IMG_ROHLOFF_SPOKE_STAT_2 = "https://i.imgur.com/kRzGXTN.png";
	public static final String IMG_ROHLOFF_SPOKE_NIPPLE = "https://i.imgur.com/9zPMer1.png";
	public static final String IMG_ROHLOFF_ERD = "https://i.imgur.com/oDZU9cM.png";
	public static final String IMG_ROHLOFF_ERD_CALC = "https://i.imgur.com/MHdfM0S.png";
	public static final String IMG_ROHLOFF_RIM_PROFILE = "https://i.imgur.com/Rp0mRvx.png";

	public static final String IMG_FAVICO = "https://raw.githubusercontent.com/nathros/nathros.github.io/master/images/common/favico.png";
	public static final String IMG_SNAKEICO = "https://raw.githubusercontent.com/nathros/nathros.github.io/master/images/common/snake.svg";
	public static final String IMG_GITICO = "https://raw.githubusercontent.com/nathros/nathros.github.io/master/images/common/github.svg";
	public static final String IMG_EXPANDICO = "https://raw.githubusercontent.com/nathros/nathros.github.io/master/images/common/box-arrow-up-right.svg";
	/* https://www.svgrepo.com/vectors/search/ */

	public static boolean readResource = true; // When searching pages for content strings do not load resources

	public static String readResource(String path) {
		if (readResource) {
			try {
				File file = new File(Resource.class.getClassLoader().getResource(path).getFile());
				String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
				return content;
			} catch (Exception e) {
				return "Missing resource " + path;
			}
		} else {
			return "";
		}
	}

}
