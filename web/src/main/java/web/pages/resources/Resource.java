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

	public static final String BASE_EXT = "https://raw.githubusercontent.com/nathros/nathros.github.io/master/";

	public static final String IMG_BANNER_1 = "https://raw.githubusercontent.com/nathros/nathros.github.io/master/images/common/banner.jpg";
	public static final String IMG_BANNER_2 = "https://i.imgur.com/9p0HPN7.jpg";
	public static final String IMG_BANNER_FILESERVER1 = BASE_EXT + "images/projects/fileserver/banner.jpg";
	public static final String IMG_BANNER_ADMIN = BASE_EXT + "images/projects/fileserver/banner-admin.jpg";
	public static final String IMG_BANNER_CONNECT4 = BASE_EXT + "images/projects/connect4/banner.jpg";
	public static final String IMG_BANNER_ROHLOFF = BASE_EXT + "images/projects/rohloff/banner.jpg";
	public static final String IMG_BANNER_ROHLOFF_2 = BASE_EXT + "images/projects/rohloff2/banner.avif";

	// pg 1
	public static final String IMG_ROHLOFF_FINAL_COMPLETE_TN = BASE_EXT + "images/projects/rohloff/finished-tn.avif";
	public static final String IMG_ROHLOFF_FINAL_COMPLETE = BASE_EXT + "images/projects/rohloff/finished.avif";

	// pg 2
	public static final String IMG_ROHLOFF_GEAR_BELT = BASE_EXT + "images/projects/rohloff/gear-belt.png";
	public static final String IMG_ROHLOFF_GEAR_COMPACT = BASE_EXT + "images/projects/rohloff/gear-compact.png";
	public static final String IMG_ROHLOFF_GEAR_MTB = BASE_EXT + "images/projects/rohloff/gear-mtb.png";
	public static final String IMG_ROHLOFF_FSA_CRANK_TN = BASE_EXT + "images/projects/rohloff/fsa-crank-tn.jpg";
	public static final String IMG_ROHLOFF_FSA_CRANK = BASE_EXT + "images/projects/rohloff/fsa-crank.jpg";
	public static final String IMG_ROHLOFF_BITEX_HUB = BASE_EXT + "images/projects/rohloff/bitex-hub.jpg";
	public static final String IMG_ROHLOFF_RFORCE_TI_TN = BASE_EXT + "images/projects/rohloff/rforce-ti-tn.jpg";
	public static final String IMG_ROHLOFF_RFORCE_TI = BASE_EXT + "images/projects/rohloff/rforce-ti.jpg";
	public static final String IMG_ROHLOFF_OKO_TN = BASE_EXT + "images/projects/rohloff/oko-tn.jpg";
	public static final String IMG_ROHLOFF_OKO = BASE_EXT + "images/projects/rohloff/oko.jpg";
	public static final String IMG_ROHLOFF_HANDLEBAR = BASE_EXT + "images/projects/rohloff/handlebar.jpg";
	public static final String IMG_ROHLOFF_SPOKE = BASE_EXT + "images/projects/rohloff/spoke.png";
	public static final String IMG_ROHLOFF_SPOKE_STAT_1 = BASE_EXT + "images/projects/rohloff/spoke-1.png";
	public static final String IMG_ROHLOFF_SPOKE_STAT_2 = BASE_EXT + "images/projects/rohloff/spoke-2.png";
	public static final String IMG_ROHLOFF_SPOKE_NIPPLE = BASE_EXT + "images/projects/rohloff/spoke-n.png";
	public static final String IMG_ROHLOFF_ERD = BASE_EXT + "images/projects/rohloff/erd.png";
	public static final String IMG_ROHLOFF_ERD_CALC = BASE_EXT + "images/projects/rohloff/calc.png";
	public static final String IMG_ROHLOFF_RIM_PROFILE = BASE_EXT + "images/projects/rohloff/profile.png";

	public static final String IMG_ROHLOFF_2_B_SIDE_TN = BASE_EXT + "images/projects/rohloff2/build-side-tn.avif";
	public static final String IMG_ROHLOFF_2_B_SIDE = BASE_EXT + "images/projects/rohloff2/build-side.avif";
	public static final String IMG_ROHLOFF_2_B_CRANK_TN = BASE_EXT + "images/projects/rohloff2/build-crank-tn.avif";
	public static final String IMG_ROHLOFF_2_B_CRANK = BASE_EXT + "images/projects/rohloff2/build-crank.avif";
	public static final String IMG_ROHLOFF_2_B_F_HUB_TN = BASE_EXT + "images/projects/rohloff2/build-front-hub-tn.avif";
	public static final String IMG_ROHLOFF_2_B_F_HUB = BASE_EXT + "images/projects/rohloff2/build-front-hub.avif";
	public static final String IMG_ROHLOFF_2_B_SEAT_TN = BASE_EXT + "images/projects/rohloff2/build-seat-tn.avif";
	public static final String IMG_ROHLOFF_2_B_SEAT = BASE_EXT + "images/projects/rohloff2/build-seat.avif";
	public static final String IMG_ROHLOFF_2_B_FRONT_TN = BASE_EXT + "images/projects/rohloff2/build-front-tn.avif";
	public static final String IMG_ROHLOFF_2_B_FRONT = BASE_EXT + "images/projects/rohloff2/build-front.avif";
	public static final String IMG_ROHLOFF_2_B_REAR_W_TN = BASE_EXT + "images/projects/rohloff2/build-rear-wheel-tn.avif";
	public static final String IMG_ROHLOFF_2_B_REAR_W = BASE_EXT + "images/projects/rohloff2/build-rear-wheel.avif";
	public static final String IMG_ROHLOFF_2_B_HANDLE_TN = BASE_EXT + "images/projects/rohloff2/build-handle-tn.avif";
	public static final String IMG_ROHLOFF_2_B_HANDLE = BASE_EXT + "images/projects/rohloff2/build-handle.avif";
	public static final String IMG_ROHLOFF_2_B_CRANK2_TN = BASE_EXT + "images/projects/rohloff2/build-crank2-tn.avif";
	public static final String IMG_ROHLOFF_2_B_CRANK2 = BASE_EXT + "images/projects/rohloff2/build-crank2.avif";
	public static final String IMG_ROHLOFF_2_B_WHEEL_D_TN = BASE_EXT + "images/projects/rohloff2/build-wheel-decal-tn.avif";
	public static final String IMG_ROHLOFF_2_B_WHEEL_D = BASE_EXT + "images/projects/rohloff2/build-wheel-decal.avif";
	public static final String IMG_ROHLOFF_2_B_REAR_DOWN_TN = BASE_EXT + "images/projects/rohloff2/build-rear-down-tn.avif";
	public static final String IMG_ROHLOFF_2_B_REAR_DOWN = BASE_EXT + "images/projects/rohloff2/build-rear-down.avif";
	public static final String IMG_ROHLOFF_2_B_PARTS_TN = BASE_EXT + "images/projects/rohloff2/build-parts-tn.avif";
	public static final String IMG_ROHLOFF_2_B_PARTS = BASE_EXT + "images/projects/rohloff2/build-parts.avif";
	public static final String IMG_ROHLOFF_2_B_WHEEL_F_TN = BASE_EXT + "images/projects/rohloff2/build-wheel-f-tn.avif";
	public static final String IMG_ROHLOFF_2_B_WHEEL_F = BASE_EXT + "images/projects/rohloff2/build-wheel-f.avif";
	public static final String IMG_ROHLOFF_2_B_WHEEL_R_TN = BASE_EXT + "images/projects/rohloff2/build-wheel-r-tn.avif";
	public static final String IMG_ROHLOFF_2_B_WHEEL_R = BASE_EXT + "images/projects/rohloff2/build-wheel-r.avif";
	public static final String IMG_ROHLOFF_2_B_BELT_DRILL_TN = BASE_EXT + "images/projects/rohloff2/build-belt-drill-tn.avif";
	public static final String IMG_ROHLOFF_2_B_BELT_DRILL = BASE_EXT + "images/projects/rohloff2/build-belt-drill.avif";
	public static final String IMG_ROHLOFF_2_B_BELT_SCREW_TN = BASE_EXT + "images/projects/rohloff2/build-belt-screw-tn.avif";
	public static final String IMG_ROHLOFF_2_B_BELT_SCREW = BASE_EXT + "images/projects/rohloff2/build-belt-screw.avif";
	public static final String IMG_ROHLOFF_2_B_BELT_FIN_TN = BASE_EXT + "images/projects/rohloff2/build-belt-finish-tn.avif";
	public static final String IMG_ROHLOFF_2_B_BELT_FIN = BASE_EXT + "images/projects/rohloff2/build-belt-finish.avif";
	public static final String IMG_ROHLOFF_2_B_BB_TN = BASE_EXT + "images/projects/rohloff2/build-bb-tn.avif";
	public static final String IMG_ROHLOFF_2_B_BB = BASE_EXT + "images/projects/rohloff2/build-bb.avif";
	public static final String IMG_ROHLOFF_2_B_R_TRI_TN = BASE_EXT + "images/projects/rohloff2/build-r-triangle-tn.avif";
	public static final String IMG_ROHLOFF_2_B_R_TRI = BASE_EXT + "images/projects/rohloff2/build-r-triangle.avif";
	public static final String IMG_ROHLOFF_2_B_CHAINSTAY_TN = BASE_EXT + "images/projects/rohloff2/build-chainstay-tn.avif";
	public static final String IMG_ROHLOFF_2_B_CHAINSTAY = BASE_EXT + "images/projects/rohloff2/build-chainstay.avif";
	public static final String IMG_ROHLOFF_2_B_TAPE_TN = BASE_EXT + "images/projects/rohloff2/build-tape-tn.avif";
	public static final String IMG_ROHLOFF_2_B_TAPE = BASE_EXT + "images/projects/rohloff2/build-tape.avif";
	public static final String IMG_ROHLOFF_2_B_BUILD_WEIGHT_TN = BASE_EXT + "images/projects/rohloff2/build-weight-tn.avif";
	public static final String IMG_ROHLOFF_2_B_BUILD_WEIGHT = BASE_EXT + "images/projects/rohloff2/build-weight.avif";
	public static final String IMG_ROHLOFF_2_BARE_FRAME_TN = BASE_EXT + "images/projects/rohloff2/bare-frame-tn.avif";
	public static final String IMG_ROHLOFF_2_BARE_FRAME = BASE_EXT + "images/projects/rohloff2/bare-frame.avif";
	public static final String IMG_ROHLOFF_2_INSIDE_TN = BASE_EXT + "images/projects/rohloff2/inside-tn.avif";
	public static final String IMG_ROHLOFF_2_INSIDE = BASE_EXT + "images/projects/rohloff2/inside.avif";
	public static final String IMG_ROHLOFF_2_ROHBOX_TN = BASE_EXT + "images/projects/rohloff2/rohbox-placement-tn.avif";
	public static final String IMG_ROHLOFF_2_ROHBOX = BASE_EXT + "images/projects/rohloff2/rohbox-placement.avif";
	public static final String IMG_ROHLOFF_2_SPACER_TN = BASE_EXT + "images/projects/rohloff2/spacer-tn.avif";
	public static final String IMG_ROHLOFF_2_SPACER = BASE_EXT + "images/projects/rohloff2/spacer.avif";
	public static final String IMG_ROHLOFF_2_SPACER_R_TN = BASE_EXT + "images/projects/rohloff2/spacer-render.png";
	public static final String IMG_ROHLOFF_2_SPACER_PRINT_TN = BASE_EXT + "images/projects/rohloff2/spacer-print-tn.avif";
	public static final String IMG_ROHLOFF_2_SPACER_PRINT = BASE_EXT + "images/projects/rohloff2/spacer-print.avif";
	public static final String IMG_ROHLOFF_2_REAR_LIGHT_TN = BASE_EXT + "images/projects/rohloff2/rear-light-mount-tn.avif";
	public static final String IMG_ROHLOFF_2_REAR_LIGHT = BASE_EXT + "images/projects/rohloff2/rear-light-mount.avif";
	public static final String IMG_ROHLOFF_2_REAR_LIGHT_RENDER = BASE_EXT + "images/projects/rohloff2/rear-light-mount-render.png";
	public static final String IMG_ROHLOFF_2_REAR_LIGHT_S_TN = BASE_EXT + "images/projects/rohloff2/rear-light-tn.avif";
	public static final String IMG_ROHLOFF_2_REAR_LIGHT_S = BASE_EXT + "images/projects/rohloff2/rear-light.avif";
	public static final String IMG_ROHLOFF_2_FRONT_MOUNT_TN = BASE_EXT + "images/projects/rohloff2/front-mount-tn.avif";
	public static final String IMG_ROHLOFF_2_FRONT_MOUNT = BASE_EXT + "images/projects/rohloff2/front-mount.avif";
	public static final String IMG_ROHLOFF_2_FRONT_MOUNT_RENDER = BASE_EXT + "images/projects/rohloff2/front-mount-render.png";
	public static final String IMG_ROHLOFF_2_FRONT_LIGHT_TN = BASE_EXT + "images/projects/rohloff2/front-light-tn.avif";
	public static final String IMG_ROHLOFF_2_FRONT_LIGHT = BASE_EXT + "images/projects/rohloff2/front-light.avif";
	public static final String IMG_ROHLOFF_2_SRAM_H = BASE_EXT + "images/projects/rohloff2/sram-h.avif";
	public static final String IMG_ROHLOFF_2_SRAM_F = BASE_EXT + "images/projects/rohloff2/sram-f.avif";
	public static final String IMG_ROHLOFF_2_SRAM_CAL_RED = BASE_EXT + "images/projects/rohloff2/sram-caliper-red.avif";
	public static final String IMG_ROHLOFF_2_SRAM_CAL_RED_AXS = BASE_EXT + "images/projects/rohloff2/sram-caliper-red-axs.avif";
	public static final String IMG_ROHLOFF_2_HOPE_RX4 = BASE_EXT + "images/projects/rohloff2/hope-rx4+.avif";
	public static final String IMG_ROHLOFF_2_HOPE_RX4_PLUS = BASE_EXT + "images/projects/rohloff2/hope-rx4-plus.avif";
	public static final String IMG_ROHLOFF_2_HOPE_X2 = BASE_EXT + "images/projects/rohloff2/hope-x2.avif";
	public static final String IMG_ROHLOFF_2_PADS_TN = BASE_EXT + "images/projects/rohloff2/pads-tn.avif";
	public static final String IMG_ROHLOFF_2_PADS = BASE_EXT + "images/projects/rohloff2/pads.avif";
	public static final String IMG_ROHLOFF_2_PADS_DIM = BASE_EXT + "images/projects/rohloff2/pads-dimensions.png";
	public static final String IMG_ROHLOFF_2_PADS_ALIGN_TN = BASE_EXT + "images/projects/rohloff2/pads-align-tn.avif";
	public static final String IMG_ROHLOFF_2_PADS_ALIGN = BASE_EXT + "images/projects/rohloff2/pads-align.avif";
	public static final String IMG_ROHLOFF_2_SHIFTER_MOD = BASE_EXT + "images/projects/rohloff2/shifter-mod.avif";
	public static final String IMG_ROHLOFF_2_SHIFTER_TOOL = BASE_EXT + "images/projects/rohloff2/shifter-tool-render.png";
	public static final String IMG_ROHLOFF_2_SHIFTER_INSIDE = BASE_EXT + "images/projects/rohloff2/shifter-inside.avif";
	public static final String IMG_ROHLOFF_2_HYDRO = BASE_EXT + "images/projects/rohloff2/hydraulic.png";
	public static final String IMG_ROHLOFF_2_COMPARE_CRANK = BASE_EXT + "images/projects/rohloff2/compare-crank.avif";

	public static final String IMG_FAVICO = BASE_EXT + "images/common/favico.png";
	public static final String IMG_SNAKEICO = BASE_EXT + "images/common/snake.svg";
	public static final String IMG_GITICO = BASE_EXT + "images/common/github.svg";
	public static final String IMG_EXPANDICO = BASE_EXT + "images/common/box-arrow-up-right.svg";
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
