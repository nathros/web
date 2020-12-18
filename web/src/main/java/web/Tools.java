package web;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import web.common.Markup;

public class Tools {

	// Using Gmail or Outlook on local machine is fine, when deployed in AWS is fraught with problems as IP address constantly changes
	public static String sendEmail(String subject, String body, boolean debug) {
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");
		
		PrintStream originalSystemOut = null;
		ByteArrayOutputStream baos = null;
		if (debug) { // Capture console output to byte array output stream
			props.put("mail.debug", "true");
			originalSystemOut = System.out;
			baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			System.setOut(ps);
		}

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Config.emailAddress, Config.emailPassword);
			}
		});

		String status = EmailOkayResponse;
		try {
			final Message message = new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(Config.emailAddress));
			message.setFrom(new InternetAddress(Config.emailAddress));
			message.setSubject(subject);
			message.setText(body);
			message.setSentDate(new Date());
			Transport.send(message);
		} catch (final MessagingException ex) {			
			status = ex.getMessage();
		}
		
		if (debug) {
			System.setOut(originalSystemOut); // Return original System.out
			System.out.flush();
			String ret = status + "\n" + baos.toString();
			return ret;
		}
		return status;
	}

	private static final String AWShost = "email-smtp.eu-west-1.amazonaws.com";
	private static final String AWSUsername = "user";
	private static final String AWSPassword = "password";
	private static final String AWSFromEmail = "from@gmail.com";
	private static final String AWSToEmail = "to@gamil.com";

	public static final String EmailOkayResponse = "okay";

	public static String sendEmailAWSSMTP(String subject, String body) {
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);

		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(AWSFromEmail, "name"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(AWSToEmail));
			msg.setSubject(subject);
			msg.setContent(body, "text/plain");

			Transport transport = session.getTransport();

			try {
				System.out.println("Sending...");
				transport.connect(AWShost, AWSUsername, AWSPassword);
				transport.sendMessage(msg, msg.getAllRecipients());  // Send the email
				System.out.println("Email sent!");
			}
			catch (Exception ex) {
				System.out.println("The email was not sent.");
				System.out.println("Error message: " + ex.getMessage());
				return ex.getMessage();
			}
			finally {
				transport.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		return e.getMessage();
	}
		return EmailOkayResponse;
	}

	public String sendEmailGoogleAppsScript(Markup m, String subject, String body) {
		// Using Google Script to send e-mails has proven not to be reliable, fails if user is logged into multiple Google accounts at once
		// Passes data to a hidden iframe which sends it to an Apps Script which sends the data in an email
		String exe = "https://script.google.com/macros/s/AKfycbwowNovB7k4jCl1YyIIJOPVbkl9n1xvz7k74BIuG59taWR8BPM/exec?subject=";
		try {
			exe += URLEncoder.encode(subject, StandardCharsets.UTF_8.name()) + "&body=";
			exe += URLEncoder.encode(body, StandardCharsets.UTF_8.name());
			m.ln("	<iframe src=\"" + exe + "\" style=\"width:0;height:0;border:0;border:none;position:absolute;\"></iframe>");
			return EmailOkayResponse;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "error";
		}
	}

}
