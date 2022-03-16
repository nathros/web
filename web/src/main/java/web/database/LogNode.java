package web.database;

import java.time.LocalDateTime;

public class LogNode {
	public String path;
	public String date;

	public LogNode(String path) {
		this.path = path;
		LocalDateTime now = LocalDateTime.now();
		this.date = Database.dtf.format(now);
	}

	public LogNode() {}
}
