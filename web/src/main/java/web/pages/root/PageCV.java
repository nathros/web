package web.pages.root;

import web.common.LocalStringBuffer;
import web.common.NavbarItem;
import web.common.RequestInfo;
import web.pages.BasePage;
import web.pages.resources.Resource;

public class PageCV extends BasePage {

	public PageCV(RequestInfo request) {
		super(request);
	}

	@Override
	public String getResponse() {
		String[] css = { Resource.CSS_COMMON, Resource.CSS_HEADER, Resource.CSS_CARD, Resource.CSS_TITLE_BANNER,
				Resource.CSS_MODAL_IMAGE, Resource.CSS_BUTTON, Resource.CSS_TOGGLE_DIV, Resource.CSS_TIMELINE, Resource.CSS_LOGOS };
		String[] js = { Resource.JS_SNAKE_HOOK };

		m.addHead(css, js, "CV");
		m.ln("<body>");
		m.addNavbar(NavbarItem.CV);
		m.addBannerAnimated("CV", Resource.IMG_BANNER_1);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		m.ln("<h2>Experience</h2>");

		LocalStringBuffer job = new LocalStringBuffer(1024);

		m.ln("	<div class=\"timeline-container\">");
		
		m.ln("		<div class=\"timeline-item\" data-date-is=\"August 2020? - Present\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h2>August 2020? - Present: Job Title</h2>");
		m.ln("				<img src=\"https://i.imgur.com/drsWZYP.jpeg\" style=\"height:2rem\" alt=\"Slipstream Engineering Design Ltd\"> </img>");
		m.ln("				<i class=\"superscript\">Slipstream Engineering Design Ltd: <a href=\"https://www.slipstream-design.co.uk/\" target=\"_blank\">https://www.slipstream-design.co.uk/</a></i>");
		m.ln("				<h4>Embedded C/C++ software developer for RF systems in commercial and military applications</h4>");

		job.ln("<p>Zynq UltraScale+ RFSoC ZCU111/ZCU102<br>");
		job.ln("VHDL in Vivado, C in Vitis, PetaLinux</p>");

		job.ln(m.getLittleLogoWithTooltip("xilinx", "Zynq UltraScale+ RFSoC"));
		job.ln(m.getLittleLogoWithTooltip("linux", "PetaLinux"));
		job.ln(m.getLittleLogoWithTooltip("vivado", "Vivado 2020.1"));
		job.ln(m.getLittleLogoWithTooltip("vitis", "Vitis 2020.1"));
		job.ln(m.getLittleLogoWithTooltip("c", "C 11")); //TODO this logo has sizeing issue
		job.ln(m.getLittleLogoWithTooltip("visual-studio", "Visual Studio 2019"));
		job.ln(m.getLittleLogoWithTooltip("csharp", "C#"));
		job.ln(m.getLittleLogoWithTooltip("git", "git"));
		job.ln(m.getLittleLogoWithTooltip("svn", "SVN"));
		job.ln("<i class=\"superscript\">Technologies used</i><br>");
		job.ln("<br>");
		job.ln(m.getLittleLogoWithTooltip("altium", "Altium Designer"));
		job.ln(m.getLittleLogoWithTooltip("solid-works", "Solid Works"));
		// logo vitis, vivado, zynq, stm32, c#, visual studio, 
		
		
		// STM32 HAL library
		job.ln("<p>CERN White Rabbit<br>");
		job.ln("Reimplemeation with changes</p>");
		
		job.ln("<p>Matlab, Ni Teststand, STM32, C# GUI<br>");
		job.ln("Reimplemeation with changes</p>");
		

		
		m.ln(m.getContentToggle("<b>Expand Details</b>", job.toString()));
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item
		job.buffer.setLength(0);
		
		// ================================================================================================================= //
		m.ln("		<div class=\"timeline-item\" data-date-is=\"December 2017 - 2020: Software Engineer\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h2>December 2017 - 2020: Software Engineer</h2>");
		m.ln("				<img src=\"http://svgur.com/i/Y9g.svg\" alt=\"QuantuMDx Group Ltd\"> </img>");
		m.ln("				<i class=\"superscript\">QuantuMDx Group Ltd: <a href=\"https://quantumdx.com\" target=\"_blank\">https://quantumdx.com</a></i>");
		m.ln("				<h4>Embedded C/C++ software developer for portable PCR and QPCR diagnostics device</h4>");
		
		job.ln("<p>Low Level Controller - Fluid heating and shuttling, cassette handling plus other controls<br>");
		job.ln("Atmel SAMV71 ATSAMV71Q21 ARM Cortex M-7 Atmel Studio 7 with FreeRTOS V10.0.1, FFF(fake function framework) testing.");
		job.ln("Lots of peripherals, driven by SPI and I2C etc, C# PC control before port to C with FreeRTOS</p>");
		job.ln("<p>Heater Board - QPCR/PCR Temperature Zone Managamen<br>");

		job.ln("Cypress PSoC 61 CY8C6136BZI-F14 Cortex-M4 PsoC Creator, FFF(fake function framework)");
		job.ln("PWM and ADCs for controlling heater zones with &#177;0.5&deg; accuracy");
		job.ln("Developed interactive terminal interface over UART for use by electronic engineers.</p>");

		job.ln("<p>Worked on a variety of embedded platforms writing C/C++ for embedded applications");
		job.ln("ranging from small 8-bit AVR bare metal to 32-bit ARM with FreeRTOS and embedded Linux.");
		job.ln("Frequently liaison with electronic engineers, providing software support, schematic design");
		job.ln("feedback and tight integration between both teams.</p>");
		
		// logo yocto, c#, visual studio, c++, atmel studio

		job.ln("Adept writing firmware for assay sequencing, controlling heaters, fluid movement and");
		job.ln("cassette clamping among others. Final marketable device, work is still in progress. Software");
		job.ln("written to comply in accordance with IEC 62304.<br>");


		job.ln(m.getLittleLogoWithTooltip("cypress", "Cypress PSoC 6"));
		job.ln(m.getLittleLogoWithTooltip("nxp", "i.MX8 SoC"));
		job.ln(m.getLittleLogoWithTooltip("microchip", "FIND SoC")); //TODO find chip
		job.ln(m.getLittleLogoWithTooltip("cmake", "CMake"));
		job.ln(m.getLittleLogoWithTooltip("freertos", "FreeRTOS 10"));
		job.ln(m.getLittleLogoWithTooltip("atmel-studio", "Atmel Studio 7"));
		job.ln(m.getLittleLogoWithTooltip("clion", "CLion IDE"));
		job.ln(m.getLittleLogoWithTooltip("yocto", "Yocto Poky"));
		job.ln(m.getLittleLogoWithTooltip("mqtt", "Mosquitto MQTT"));
		job.ln(m.getLittleLogoWithTooltip("git", "git"));
		job.ln(m.getLittleLogoWithTooltip("cpp", "C++ 14"));
		job.ln(m.getLittleLogoWithTooltip("c", "C 99"));
		job.ln(m.getLittleLogoWithTooltip("csharp", "C#"));
		job.ln(m.getLittleLogoWithTooltip("visual-studio", "Visual Studio 2019"));
		job.ln(m.getLittleLogoWithTooltip("jenkins", "Jenkins"));
		job.ln(m.getLittleLogoWithTooltip("q-pulse", "Q-Pulse QMS"));
		job.ln("<i class=\"superscript\">Technologies used</i><br>");

		m.ln(m.getContentToggle("<b>Expand Details</b>", job.toString()));
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item

		
		// ================================================================================================================= //
		m.ln("		<div class=\"timeline-item\" data-date-is=\"August 2015 - December 2017\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h2>Graduate Job</h2>");
		
		m.ln("				<img src=\"https://i.imgur.com/zJHyO4f.png\" alt=\"EnAppSys\"> </img>");
		m.ln("				<i class=\"superscript\">EnAppSys Ltd: <a href=\"https://www.enappsys.com/\" target=\"_blank\">https://www.enappsys.com/</a></i>");
		m.ln("				<h4>Java software developer providing energy market analytics for trading</h4>");

		job.buffer.setLength(0);
		job.ln("<p>Need to add for older job</p>");
		job.ln(m.getLittleLogoWithTooltip("aws", "Amazon Web Services"));
		job.ln(m.getLittleLogoWithTooltip("aws-ec2", "AWS EC2"));
		job.ln(m.getLittleLogoWithTooltip("aws-lambda", "AWS Lambda"));
		job.ln(m.getLittleLogoWithTooltip("linux", "Amazon Linux AMI"));
		job.ln(m.getLittleLogoWithTooltip("open-suse", "OpenSUSE"));
		job.ln(m.getLittleLogoWithTooltip("eclipse", "Eclipse IDE"));
		job.ln(m.getLittleLogoWithTooltip("aws-dyndb", "AWS DynamoDB"));
		job.ln(m.getLittleLogoWithTooltip("postgres-sql", "PostgreSQL"));
		job.ln(m.getLittleLogoWithTooltip("gradle", "Gradle"));
		job.ln(m.getLittleLogoWithTooltip("java", "Java 8"));
		job.ln(m.getLittleLogoWithTooltip("svn", "SVN"));
		job.ln("<i class=\"superscript\">Technologies used</i><br>");

		m.ln(m.getContentToggle("<b>Expand Details</b>", job.toString()));
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item
		m.ln("	</div>"); // timeline-container

		
		// ================================================================================================================= //
		m.ln("<h2><br>Skills</h2>");
		m.ln("<div class=\"skills-wrapper\">");
		m.ln("	<div class=\"skills-subject\">Languages</div>");
		m.ln("	<div class=\"skills-detail\">Embedded C(11), C++(14), C#, Java, JavaScript, Pascal</div>");

		m.ln("	<div class=\"skills-subject\">Hardware</div>");

		m.ln("	<div class=\"skills-subject-sub\">CPU:</div>");
		m.ln("	<div class=\"skills-detail\">ARM Cortex-M3/M4/M7/A5/A53, Atmel AVR, Intel Galileo x86</div>");

		m.ln("	<div class=\"skills-subject-sub\">Comms:</div>");
		m.ln("	<div class=\"skills-detail\">UART, USART, I2C, SPI, CAN, Atmel SSC</div>");

		m.ln("	<div class=\"skills-subject-sub\">IC:</div>");
		m.ln("	<div class=\"skills-detail\">Trinamic (TMC5041, TMCM-1110) stepper controllers, ");
		m.ln("		Analog Devices (AD7176, AD7768) High Speed High Resolution 24bit ADC plus many more...</div>");

		m.ln("	<div class=\"skills-subject-sub\">Hardware:</div>");
		m.ln("	<div class=\"skills-detail\">Stepper motors (micro-fluidic movement), IR & RPM Sensors, Pololu 3pi</div>");

		m.ln("	<div class=\"skills-subject\">Software</div>");

		m.ln("	<div class=\"skills-subject-sub\">Libraries:</div>");
		m.ln("	<div class=\"skills-detail\">Mosquito MQTT, Google Web Toolkit (GWT)</div>");

		m.ln("	<div class=\"skills-subject-sub\">Platform:</div>");
		m.ln("	<div class=\"skills-detail\">Jenkins, Yocto, Buildroot</div>");

		m.ln("	<div class=\"skills-subject-sub\">VCS:</div>");
		m.ln("	<div class=\"skills-detail\">Git, SVN, Bitbucket, Jira</div>");

		m.ln("	<div class=\"skills-subject-sub\">Build:</div>");
		m.ln("	<div class=\"skills-detail\">CMake, Gradle</div>");

		m.ln("	<div class=\"skills-subject-sub\">AWS:</div>");
		m.ln("	<div class=\"skills-detail\">Amazon Web Services (Lambda, EC2, SQS, DynamoDB, Elastic Load Balancing)</div>");

		m.ln("	<div class=\"skills-subject-sub\">Databases:</div>");
		m.ln("	<div class=\"skills-detail\">MySQL, PostgreSQL, DynamoDB</div>");

		m.ln("	<div class=\"skills-subject\">Concepts</div>");
		m.ln("	<div class=\"skills-detail\">Object-oriented Programming and Design, Real-time Operating Systems, Networking"
				+ "and Sockets, Multi-threaded and Multi-process Applications, Asynchronous Programming,"
				+ " Microservices, High Availability</div>");

		m.ln("	<div class=\"skills-subject\">Systems</div>");
		m.ln("	<div class=\"skills-detail\">Windows, FreeRTOS, GNU/Linux (Embedded, Yocto, Debian, OpenSUSE & Amazon\r\n"
				+ "Linux AMI), FreeBSD, FreeNAS.</div>");

		m.ln("	<div class=\"skills-subject\">QMS</div>");
		m.ln("	<div class=\"skills-detail\">Q-Pulse</div>");

		m.ln("	<div class=\"skills-subject\">Transport</div>");
		m.ln("	<div class=\"skills-detail\">Clean UK driver's licence (category B)</div>");

		m.ln("</div>"); // skills-wrapper

		m.ln("<h2><br>Education</h2>");

		m.ln("	<div class=\"timeline-container\">");
		m.ln("		<div class=\"timeline-item\" data-date-is=\"2011 - 2015\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h2>Computer Science</h2>");
		job.ln("<p>Detailed description</p>");
		m.ln(m.getContentToggle("<b>Expand Details</b>", job.toString()));
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item

		m.ln("		<div class=\"timeline-item\" data-date-is=\"2008 - 2011\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h2>College</h2>");
		m.ln(m.getContentToggle("<b>Expand Details</b>", job.toString()));
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item
		m.ln("	</div>"); // timeline-container

		m.ln("	</div>"); // card
		m.ln("</div>"); // common-content

		m.ln("<script>");
		m.ln(Resource.readResource(Resource.JS_BANNER));
		m.ln("</script>");

		m.ln("</body>");
		m.ln("</html>");

		return m.p.toString();
	}

}
