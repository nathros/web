package web.database;

import java.util.Date;

public class LogNode {
	public String path;
	public String date;

	public LogNode(String path) {
		this.path = path;
		Date now = new Date(System.currentTimeMillis());
		this.date = Database.sdf.format(now);
	}

	public LogNode() {}
}
