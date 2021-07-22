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
		String[] js = { Resource.JS_SNAKE_HOOK, Resource.JS_TOGGLE_DIV};

		m.addHead(css, js, "CV");
		m.ln("<body>");
		m.addNavbar(NavbarItem.CV);
		m.addBannerAnimated("CV", Resource.IMG_BANNER_1);

		m.ln("<div class=\"common-content\">");
		m.ln("	<div class=\"card\">");

		m.ln("<h2>Experience</h2>");

		LocalStringBuffer job = new LocalStringBuffer(1024);

		m.ln("	<div class=\"timeline-container\">");
		
		m.ln("		<div class=\"timeline-item\" data-date-is=\"August 2020 - Present\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h2>August 2020 - Present</h2>");
		m.ln("				<img src=\"https://i.imgur.com/drsWZYP.jpeg\" style=\"height:2rem\" alt=\"Slipstream Engineering Design Ltd\">");
		m.ln("				<i class=\"superscript\">Slipstream Engineering Design Ltd: <a href=\"https://www.slipstream-design.co.uk/\" target=\"_blank\">https://www.slipstream-design.co.uk/</a></i>");
		m.ln("				<h4>Embedded C/C++ software developer for RF systems in commercial and military applications</h4>");

		job.ln("<p>Zynq UltraScale+ RFSoC ZCU111/ZCU102<br>");
		job.ln("Custom PetaLinux software platform using Yocto, custom bootloader for dual parallel QSPI.");
		job.ln("Linux application code to manage system and communicate to FPGA via custom AXI peripheral.");
		job.ln("Read RF IQ data from PS-PL DMA DDR4 over Ethernet for data processsing.");
		job.ln("High speed fibre optic SFP communication.");

		job.ln("<p>100W High Power RF Amplifier<br>");
		job.ln("FreeRTOS 10 to manage high speed high speed 3.75Mbps DMA UART customer command interface and background functions.");
		job.ln("STM32 HAL library used for configuring and using perfierals.");
		job.ln("C# GUI developed for use by RF/electrical engineers to test and control board over USB interface");
		job.ln("System level tests done using NI TestStand.</p>");

		job.ln("<p>CERN White Rabbit - &lt;100 picosecond synchronisation over SFP fibre optics<br>");
		job.ln("Custom implemtation based on Simple PCIe FMC carrier (SPEC).");
		job.ln("The system allows synchronisation between many end nodes by using an extended IEEE1588 Precision Time Protocol over fibre optics.");
		job.ln("A Xilinx Spartan 6 FPGA with open source White Rabbit PTP Core is the core of this design.");
		job.ln("Software using LM32 softcore adpted from SPEC design");
		job.ln("User configurable clock synthesiser phase synchronised with 1pps.</p>");

		job.ln("<div class=\"logo-group\">");
		job.ln(m.getLittleLogoWithTooltip("xilinx", "Xilinx Zynq UltraScale+ RFSoC & Spartan-6"));
		job.ln(m.getLittleLogoWithTooltip("st", "STMicroelectronics Cortex-M3 STM32F207ZG"));
		job.ln(m.getLittleLogoWithTooltip("nxp", "NXP LPC4370"));
		job.ln(m.getLittleLogoWithTooltip("linux", "PetaLinux"));
		job.ln(m.getLittleLogoWithTooltip("vivado", "Vivado 2020.1"));
		job.ln(m.getLittleLogoWithTooltip("ise", "Xilinx ISE 14.7"));
		job.ln(m.getLittleLogoWithTooltip("vitis", "Vitis 2020.1"));
		job.ln(m.getLittleLogoWithTooltip("yocto", "Yocto"));
		job.ln(m.getLittleLogoWithTooltip("white-rabbit", "CERN White Rabbit"));
		job.ln(m.getLittleLogoWithTooltip("freertos", "FreeRTOS 10"));
		job.ln(m.getLittleLogoWithTooltip("c", "C 11"));
		job.ln(m.getLittleLogoWithTooltip("cpp", "C++ 17"));
		job.ln(m.getLittleLogoWithTooltip("visual-studio", "Visual Studio 2019"));
		job.ln(m.getLittleLogoWithTooltip("csharp", "C#"));
		job.ln(m.getLittleLogoWithTooltip("vhdl", "VHDL"));
		job.ln(m.getLittleLogoWithTooltip("verilog", "Verilog"));
		job.ln(m.getLittleLogoWithTooltip("device-tree", "Linux Device Tree"));
		job.ln(m.getLittleLogoWithTooltip("u-boot", "U-Boot"));
		job.ln(m.getLittleLogoWithTooltip("test-stand", "National Instruments Test Stand"));
		job.ln(m.getLittleLogoWithTooltip("git", "git"));
		job.ln(m.getLittleLogoWithTooltip("svn", "SVN"));
		job.ln(m.getLittleLogoWithTooltip("altium", "Altium Designer"));
		job.ln(m.getLittleLogoWithTooltip("solid-works", "Solid Works"));
		job.ln("<i class=\"superscript\">Technologies used</i>");
		job.ln("</div>");
		
		m.ln(m.getContentToggle("<b>Expand Details</b>", job.toString()));
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item
		job.buffer.setLength(0);
		
		// ================================================================================================================= //
		m.ln("		<div class=\"timeline-item\" data-date-is=\"December 2017 - August 2020\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h2>December 2017 - August 2020</h2>");
		m.ln("				<img src=\"http://svgur.com/i/Y9g.svg\" alt=\"QuantuMDx Group Ltd\">");
		m.ln("				<i class=\"superscript\">QuantuMDx Group Ltd: <a href=\"https://quantumdx.com\" target=\"_blank\">https://quantumdx.com/</a></i>");
		m.ln("				<h4>Embedded C/C++ software developer for portable PCR and QPCR medical diagnostics device</h4>");
		
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
		
		job.ln("<p>Adept writing firmware for assay sequencing, controlling heaters, fluid movement and");
		job.ln("cassette clamping among others. Final marketable device, work is still in progress. Software");
		job.ln("written to comply in accordance with IEC 62304.</p>");

		job.ln("<div class=\"logo-group\">");
		job.ln(m.getLittleLogoWithTooltip("cypress", "Cypress PSoC 6"));
		job.ln(m.getLittleLogoWithTooltip("microchip", "Microchip SAMA5D27"));
		job.ln(m.getLittleLogoWithTooltip("nxp", "NXP i.MX8 SoC"));
		job.ln(m.getLittleLogoWithTooltip("atmel", "Atmel SAM V71 Xplained Ultra"));
		job.ln(m.getLittleLogoWithTooltip("yocto", "Yocto"));
		job.ln(m.getLittleLogoWithTooltip("buildroot", "Build Root"));
		job.ln(m.getLittleLogoWithTooltip("freertos", "FreeRTOS 10"));
		job.ln(m.getLittleLogoWithTooltip("cpp", "C++ 14"));
		job.ln(m.getLittleLogoWithTooltip("c", "C 99"));
		job.ln(m.getLittleLogoWithTooltip("csharp", "C#"));
		job.ln(m.getLittleLogoWithTooltip("cmake", "CMake"));
		job.ln(m.getLittleLogoWithTooltip("git", "git"));
		job.ln(m.getLittleLogoWithTooltip("clion", "CLion IDE"));
		job.ln(m.getLittleLogoWithTooltip("atmel-studio", "Atmel Studio 7"));
		job.ln(m.getLittleLogoWithTooltip("visual-studio", "Visual Studio 2019"));
		job.ln(m.getLittleLogoWithTooltip("mqtt", "Mosquitto MQTT"));
		job.ln(m.getLittleLogoWithTooltip("jenkins", "Jenkins"));
		job.ln(m.getLittleLogoWithTooltip("iec", "IEC 62304"));
		job.ln(m.getLittleLogoWithTooltip("q-pulse", "Q-Pulse QMS"));
		job.ln("<i class=\"superscript\">Technologies used</i>");
		job.ln("</div>");
		
		m.ln(m.getContentToggle("<b>Expand Details</b>", job.toString()));
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item

		
		// ================================================================================================================= //
		m.ln("		<div class=\"timeline-item\" data-date-is=\"August 2015 - December 2017\">");
		m.ln("			<div class=\"timeline-item-content\">");
		m.ln("				<h2>August 2015 - December 2017</h2>");
		
		m.ln("				<img src=\"https://i.imgur.com/zJHyO4f.png\" alt=\"EnAppSys\">");
		m.ln("				<i class=\"superscript\">EnAppSys Ltd: <a href=\"https://www.enappsys.com/\" target=\"_blank\">https://www.enappsys.com/</a></i>");
		m.ln("				<h4>Java software developer providing analytics for energy market trading</h4>");

		job.buffer.setLength(0);
		job.ln("<p>Port of self hosted monolithic system into more extensible microservice architecture for AWS.</p>");
		job.ln("<p>Full stack web develpment, GWT client and server size development.</p>");
		job.ln("<p>Realtime processing Tibco messages from Elexon, stored in Postgres database for historical data and sending to realtime traders.</p>");

		job.ln("<div class=\"logo-group\">");
		job.ln(m.getLittleLogoWithTooltip("aws", "Amazon Web Services"));
		job.ln(m.getLittleLogoWithTooltip("aws-ec2", "AWS EC2"));
		job.ln(m.getLittleLogoWithTooltip("aws-lambda", "AWS Lambda"));
		job.ln(m.getLittleLogoWithTooltip("aws-load-balancer", "AWS Elastic Load Balancing"));
		job.ln(m.getLittleLogoWithTooltip("linux", "Amazon Linux AMI"));
		job.ln(m.getLittleLogoWithTooltip("open-suse", "OpenSUSE"));
		job.ln(m.getLittleLogoWithTooltip("eclipse", "Eclipse IDE"));
		job.ln(m.getLittleLogoWithTooltip("aws-dyndb", "AWS DynamoDB"));
		job.ln(m.getLittleLogoWithTooltip("postgres-sql", "PostgreSQL"));
		job.ln(m.getLittleLogoWithTooltip("gwt", "Google Web Toolkit 2.7"));
		job.ln(m.getLittleLogoWithTooltip("gradle", "Gradle"));
		job.ln(m.getLittleLogoWithTooltip("java", "Java 8"));
		job.ln(m.getLittleLogoWithTooltip("svn", "SVN"));
		job.ln(m.getLittleLogoWithTooltip("tibco", "TIBCO Enterprise Message Service"));
		job.ln("<i class=\"superscript\">Technologies used</i>");
		job.ln("</div>");

		m.ln(m.getContentToggle("<b>Expand Details</b>", job.toString()));
		m.ln("			</div>"); // timeline-item-content
		m.ln("		</div>"); // timeline-item
		m.ln("	</div>"); // timeline-container

		
		// ================================================================================================================= //
		m.ln("<h2><br>Skills</h2>");
		m.ln("<div class=\"skills-wrapper\">");
		m.ln("	<div class=\"skills-subject\">Languages</div>");
		m.ln("	<div class=\"skills-detail\">Embedded C(11), C++(14), C#, Java, VHDL, JavaScript, Pascal</div>");

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
		m.ln("	<div class=\"skills-detail\">Yocto, Buildroot, Jenkins</div>");

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
				+ "Linux AMI), FreeBSD.</div>");

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
