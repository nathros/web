package web;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import web.common.RequestInfo;

public class Scheduled {

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
}
