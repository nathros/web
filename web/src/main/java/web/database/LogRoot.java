package web.database;

import java.util.ArrayList;
import java.util.List;

public class LogRoot {
	public String address;
	public String lastRequest;
	public List<LogNode> entries;

	public void AddEntry(String path) {
		if (entries == null) entries = new ArrayList<LogNode>();
		while (entries.size() > 128) {
			entries.remove(1); // Keep first
		}
		LogNode node = new LogNode(path);
		entries.add(node);
		lastRequest = node.date;
	}

	public static LogRoot getNewEmptyLogRoot(String address) {
		LogRoot root = new LogRoot();
		root.address = address;
		return root;
	}
}
