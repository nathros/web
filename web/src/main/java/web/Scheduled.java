package web;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
				Tools.sendEmail(subject, body, false);
				System.out.println("...finished in " + (System.currentTimeMillis() - startLog) + "ms");
			}
		}, 10, TimeUnit.MILLISECONDS);
	}
}
