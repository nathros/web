package web.pages.root.projects.rohloff;

import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class RohloffPage4 extends BasePage {

	public RohloffPage4(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_TOOLTIP, Resource.CSS_MODAL_IMAGE };
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_MODAL_IMAGE };

		m.addHead(css, js, "Flat-Mount Adapter");

		m.ln("<body>");
		m.addNavbar(NavbarItem.Projects);

		m.addBanner("Flat-Mount Adapter",
				"https://www.campagnolo.com/media/immagini/9593_z_campagnolo-super-record-chain-MY2019-banner.jpg");

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");
		RohloffUtils.addRohloffPageSelector(m, 4);

		m.ln("<p>");
		m.ln("	The Rohloff hub was originally designed for a 9mm quick release skewer.");
		m.ln("	12mm thru-axle support was only made available late 2016, which is achieved via M7 bolts and adapters.");
		// TODO find first thru-axle release
		// https://forums.mtbr.com/downhill-freeride/trek-diesel-riders-2180.html
		// https://forums.mtbr.com/downhill-freeride/quick-release-skewer-problem-154419.html
		// https://www.mtbr.com/product/older-categories-bikes/front-shock/rst/alfalfa-xl-00.html
		// https://www.google.com/search?q=thru+axle+12mm+site%3A+forums.mtbr.com&rlz=1C1GCEU_enGB821GB821&biw=2560&bih=1329&source=lnt&tbs=cdr%3A1%2Ccd_min%3A10%2F29%2F1995%2Ccd_max%3A10%2F1%2F2004&tbm=
		m.ln("	Early thru-axles bicycles were released around 2000, Rohloff are slow to adopt new standards waiting over 15 years.");
		m.ln("	Although 12mm rear axles didn't stabilise until 2004.");
		m.ln("	I have contacted Rohloff and they have no plans to support flat-mount in the future.");
		m.ln("	The next step was Cycle Monkey, a company renowned in selling internal hub bikes.");

		m.ln("	They even produce dedicated A12 dropouts replacing the thru-axle adapters [link] I didn’t find the adapters too much of an issue.");
		// https://bikerumor.com/2018/06/15/cycle-monkey-x-paragon-machine-works-team-up-for-rohloff-a12-thru-axle-dropouts/
		m.ln("</p>");

		m.ln("</p>");
		m.ln("	I queried them and they replied saying that they are working on a flat mount adapter but >6 months later and still no progress.");
		m.ln("	If you didn’t know internal hubs need to be directly mounted to the frame to counter input torque.");
		m.ln("	~The Rohloff hub can make use of an axle plate (OEM2) which connects to a custom post mount brake adapter (monkey bone).");
		m.ln(String.format(
				"	This only works post mount brake mounting, Rohloff can provide a %s which attaches to the chainstay for non-compatible frames, but it is big and unsightly.",
				"“torque arm link”"));
		m.ln("	This lead me to design my own.");
		m.ln("</p>");

		m.ln("</p>");
		m.ln("	The flat mount brake system is designed for 140mm rotors, an adapter must be installed for use on 160mm rotors.");
		m.ln("	Rohloff supports a minimum rotor size of 160mm.");
		m.ln("	I decided to replace the original SRAM calipers to the SRAM compatible Hope RX4.");
		m.ln("	Rohloff supports a minimum rotor size of 160mm.");
		m.addToolTip("<b>Torque arm</b>",
				"<img src=\"http://twentynineinches.com/wp-content/uploads/2010/02/fig_rohl_3.jpg\">\r\n"
						+ "	<p>The torque arm is the horizontal bar with holes, quite big and unsightly</p>");
		m.ln("	One issue with this decision the RX4 is that is does not require an adapter and only supports 160mm rotors, essentially having a built in one.");
		m.ln("	This means there is no room to fit a flat-mount monkeybone on top of the brake mount.");
		m.ln("	Also I would assume if Cycle Monkey would ever release an adapter it would only be compatible with standard calipers flat-mount 140mm calipers.");

		m.addModalImage(Resource.IMG_ROHLOFF_FLATMOUNT_FINAL_TN, Resource.IMG_ROHLOFF_FLATMOUNT_FINAL,
				"width:250px;height:188px");

		m.ln("</p>");
		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("</body>");
		m.ln("</html>");
		return m.p.toString();
	}

}
