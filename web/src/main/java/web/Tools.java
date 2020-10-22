package web;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

public class Tools {

	// Using Gmail or Outlook on local machine is fine, when deployed in AWS is fraught with problems
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

		String status = "Success";
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
}
