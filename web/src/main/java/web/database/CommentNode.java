package web.database;

import java.util.List;

public class CommentNode {
	public String user;
	public String comment;
	public String date;
	public String email;
	public List<CommentNode> children;
}
