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

	public static final String JS_SNAKE_HOOK = "web/js/snake_hook.js";
	public static final String JS_SNAKE = "web/js/snake.js";
	public static final String JS_LOAD_DOC = "web/js/load_doc.js";
	public static final String JS_MODAL_IMAGE = "web/js/modal-image.js";

	// Thumbnails w:640
	public static final String IMG_ROHLOFF_FLATMOUNT_FINAL_TN = "https://i.imgur.com/1jUoTVG.jpg";
	public static final String IMG_ROHLOFF_FLATMOUNT_FINAL = "https://i.imgur.com/agFrpUp.jpg";

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
	public static final String IMG_ROHLOFF_MRD524_TN = "https://i.imgur.com/9ov3VLi.jpg";
	public static final String IMG_ROHLOFF_MRD524 = "https://i.imgur.com/dwXPA5E.jpg";
	public static final String IMG_ROHLOFF_MRD524_SIZE_TN = "https://i.imgur.com/FTWYSWA.png";
	public static final String IMG_ROHLOFF_MRD524_SIZE = "https://i.imgur.com/4guxLvk.png";
	public static final String IMG_ROHLOFF_HANDLEBAR = "https://i.imgur.com/w1lxLfq.jpg";
	public static final String IMG_ROHLOFF_SPOKE = "https://i.imgur.com/Mjb6mp3.png";
	public static final String IMG_ROHLOFF_SPOKE_STAT_1 = "https://i.imgur.com/Bqg9dbd.png";
	public static final String IMG_ROHLOFF_SPOKE_STAT_2 = "https://i.imgur.com/kRzGXTN.png";
	public static final String IMG_ROHLOFF_SPOKE_NIPPLE = "https://i.imgur.com/9zPMer1.png";
	public static final String IMG_ROHLOFF_ERD = "https://i.imgur.com/oDZU9cM.png";
	public static final String IMG_ROHLOFF_ERD_CALC = "https://i.imgur.com/MHdfM0S.png";
	public static final String IMG_ROHLOFF_RIM_PROFILE = "https://i.imgur.com/Rp0mRvx.png";

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
