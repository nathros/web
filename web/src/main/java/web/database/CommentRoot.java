package web.database;

public class CommentRoot {
	public String page;
	public CommentNode root;

	public static CommentRoot getNewEmptyCommentRoot(String page) {
		CommentRoot root = new CommentRoot();
		root.root = new CommentNode();
		root.page = page;
		return root;
	}
}
