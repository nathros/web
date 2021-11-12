package web.database;

import java.util.ArrayList;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Database {
	public static DynamoDB dynamoDB = init();
	public final static String DB_USER = "usr";
	public final static String DB_COMMENT = "cmt";
	public final static String DB_TABLE_COMMENTS = "comments";
	public final static String DB_TABLE_COMMENTS_KEY_NAME = "page";

	private final static ObjectMapper mapper = new ObjectMapper();
	private final static ObjectWriter ow = mapper.writer();

	private static DynamoDB init() {
		ProfileCredentialsProvider profile = new ProfileCredentialsProvider();
		boolean error = false;
		try {
			AWSCredentials cred = profile.getCredentials();
			error = cred == null;
		} catch (Exception e) {
			error = true;
		}

		if (!error) { // Use local profile if
			AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_WEST_1).withCredentials(profile).build();
			return new DynamoDB(client);
		} else { // If not try default
			AmazonDynamoDBAsync client = AmazonDynamoDBAsyncClientBuilder.defaultClient();
			return new DynamoDB(client);
		}
	}

	public static <T> T itemToObject(Item item, Class<T> toValueType) throws JsonMappingException, JsonProcessingException {
        String itemStr = item.toJSON();
        JsonNode jsonNode = mapper.readTree(itemStr);
        return (T) mapper.convertValue(jsonNode, toValueType);
	}

	public static Item objectToItem(Object object) throws JsonProcessingException {
		String json = ow.writeValueAsString(object);
		Item item = new Item();
		item.withJSON("root", json);
		item = Item.fromJSON(json);
		return item;
	}

	public static boolean addNewComment(String page, String tree, String name, String comment, String date) {
		Table table = Database.dynamoDB.getTable(Database.DB_TABLE_COMMENTS);
		GetItemSpec spec = new GetItemSpec().withPrimaryKey(Database.DB_TABLE_COMMENTS_KEY_NAME, page);
		Item outcome = table.getItem(spec);
		CommentRoot base = null;
		try {
			if (outcome == null) {
				base = Database.getEmptyCommentRoot(page);
			} else {
				base = itemToObject(outcome, CommentRoot.class);
			}
		} catch (Exception e) {
			return false;
		} 
		if (base != null) {
			String[] split = tree.split(",");
			try {
				CommentNode node = base.root;

				for (int i = 1; i < split.length; i++) {
					node = node.children.get(Integer.valueOf(split[i]));
				}
				if (node != null) {
					CommentNode newNode = new CommentNode();
					newNode.user = name;
					newNode.comment = comment;
					newNode.date = date;
					if (node.children == null) node.children = new ArrayList<CommentNode>();
					node.children.add(newNode);
					try {
						Item item = objectToItem(base);
						table.putItem(item);
					} catch (JsonProcessingException e) {
						return false;
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean delComment(String page, String tree) {
		Table table = Database.dynamoDB.getTable(Database.DB_TABLE_COMMENTS);
		GetItemSpec spec = new GetItemSpec().withPrimaryKey(Database.DB_TABLE_COMMENTS_KEY_NAME, page);
		Item outcome = table.getItem(spec);
		CommentRoot base = null;
		try {
			base = itemToObject(outcome, CommentRoot.class);
		} catch (Exception e) {
			return false;
		} 
		if (outcome != null) {
			String[] split = tree.split(",");
			try {
				CommentNode node = base.root;

				for (int i = 1; i < split.length - 1; i++) {
					node = node.children.get(Integer.valueOf(split[i]));
				}
				if (node != null) {
					int index = Integer.valueOf(split[split.length - 1]);
					node.children.remove(index);
					try {
						Item item = objectToItem(base);
						table.putItem(item);
					} catch (JsonProcessingException e) {
						return false;
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	public static void createTestComment(String page) {
		Table table = Database.dynamoDB.getTable(Database.DB_TABLE_COMMENTS);
		CommentRoot base = new CommentRoot();
		CommentNode rootNode = new CommentNode();
		rootNode.user = null;
		rootNode.comment = null;
		rootNode.children = new ArrayList<CommentNode>();
		for (int i = 0; i < 3; i++) {
			CommentNode node =  new CommentNode();
			node.user = "User " + i;
			node.comment = "Comment " + i;
			rootNode.children.add(node);
		}
		rootNode.children.get(1).children = new ArrayList<CommentNode>();
		CommentNode node =  new CommentNode();
		node.user = "Reply 1";
		node.comment = "Comment reply 1";
		rootNode.children.get(1).children.add(node);

		base.page = page;
		base.root = rootNode;

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

		String json = "";
		try {
			json = ow.writeValueAsString(base);
			System.out.print(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		Item itm = new Item();
		itm.withJSON("root", json);
		itm = Item.fromJSON(json);
		table.putItem(itm);
	}

	public static CommentRoot getEmptyCommentRoot(String page) {
		CommentRoot root = new CommentRoot();
		root.root = new CommentNode();
		root.page = page;
		return root;
	}
}
