package web;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import web.common.RequestInfo;

public class Scheduled {
	static boolean sendEmail = false;
	static String subjectEmail;
	static String bodyEmail;

	public static void run(RequestInfo request) {
		log(request);
		if (sendEmail) {
			sendEmail(subjectEmail, bodyEmail);
		}
	}

	public static void scheduleEmail(String subject, String body) {
		sendEmail = true;
		subjectEmail = subject;
		bodyEmail = body;
	}

	public static void log(RequestInfo request) {
		if (Config.logToDynamoDB) {
			Analytics analytics = new Analytics();

			ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

			executorService.schedule(new Runnable() {
				@Override
				public void run() {
					long startLog = System.currentTimeMillis();
					System.out.print("Started log request...");
					analytics.logRequestRequest(request);
					System.out.println("...finished in " + (System.currentTimeMillis() - startLog) + "ms");
				}
			}, 10, TimeUnit.MILLISECONDS);
		}
	}

	public static void sendEmail(String subject, String body) {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

		executorService.schedule(new Runnable() {
			@Override
			public void run() {
				sendEmail = false;
				long startLog = System.currentTimeMillis();
				System.out.print("Started email request...");
				Properties props = new Properties();
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.host", "smtp.office365.com");
				props.put("mail.smtp.port", "587");
				// props.put("mail.debug", "true");

				Session session = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(Config.emailAddress, Config.emailPassword);
					}
				});

				try {
					final Message message = new MimeMessage(session);
					message.setRecipient(Message.RecipientType.TO, new InternetAddress(Config.emailAddress));
					message.setFrom(new InternetAddress(Config.emailAddress));
					message.setSubject(subject);
					message.setText(body);
					message.setSentDate(new Date());
					Transport.send(message);
				} catch (final MessagingException ex) {
					System.out.println(ex.getMessage());
				}
				System.out.println("...finished in " + (System.currentTimeMillis() - startLog) + "ms");
			}
		}, 10, TimeUnit.MILLISECONDS);
	}
}
