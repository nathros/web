package web;

import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
				Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.socketFactory.port", "465");
				prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				prop.put("mail.smtp.auth", "true");
				prop.put("mail.smtp.port", "465");

				Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(Config.contactEmailAddress, Config.contactEmailPassword);
					}
				});

				try {
					MimeMessage message = new MimeMessage(session);
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(Config.destinationEmailAddress));
					message.setSubject(subject);
					message.setText(body);
					Transport.send(message);
				} catch (MessagingException e) {
					// Log error
				}
				System.out.println("...finished in " + (System.currentTimeMillis() - startLog) + "ms");
			}
		}, 10, TimeUnit.MILLISECONDS);
	}
}
