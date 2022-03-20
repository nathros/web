package web.database;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemUtils;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Database {
	public static DynamoDB dynamoDB = init();
	public static AmazonDynamoDB client;
	public final static String DB_USER = "usr";
	public final static String DB_COMMENT = "cmt";
	public final static String DB_TABLE_COMMENTS = "comments";
	public final static String DB_TABLE_COMMENTS_KEY_NAME = "page";

	public final static String DB_TABLE_LOG = "log";
	public final static String DB_TABLE_LOG_KEY_NAME = "address";

	public final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
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
			client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_WEST_1).withCredentials(profile).build();
			return new DynamoDB(client);
		} else { // If not try default
			client = AmazonDynamoDBAsyncClientBuilder.defaultClient();
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
				base = CommentRoot.getNewEmptyCommentRoot(page);
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
					newNode.comment = comment.length() > 1024 ? comment.substring(0, 1023) : comment;
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

	public static boolean addNewLog(String address, String path) {
		if ((null == address) || (null == path)) return false;
		Table table = Database.dynamoDB.getTable(Database.DB_TABLE_LOG);
		GetItemSpec spec = new GetItemSpec().withPrimaryKey(Database.DB_TABLE_LOG_KEY_NAME, address);
		Item outcome = table.getItem(spec);
		LogRoot root = null;
		try {
			if (outcome == null) {
				root = LogRoot.getNewEmptyLogRoot(address);
			} else {
				root = itemToObject(outcome, LogRoot.class);
			}
		} catch (Exception e) {
			return false;
		}

		try {
			root.AddEntry(path);
			Item item = objectToItem(root);
			table.putItem(item);
		} catch (JsonProcessingException e) {
			return false;
		}

		return true;
	}

	public static List<LogRoot> getLog(LocalDate start, LocalDate end) {
		LocalDateTime startDateTime = start.atTime(0, 0);
		LocalDateTime endDateTime = end.atTime(0, 0);
		String filterStart = Database.dtf.format(startDateTime);
		String filterEnd = Database.dtf.format(endDateTime);

		Map<String, String> names = new HashMap<String, String>();
		Map<String, AttributeValue> values = new HashMap<String, AttributeValue>();
		names.put("#DYNOBASE_range", "lastRequest");
		values.put(":start", new AttributeValue().withS(filterStart));
		values.put(":end", new AttributeValue().withS(filterEnd));

		ScanRequest scanRequest = new ScanRequest().withTableName(Database.DB_TABLE_LOG)
				.withExpressionAttributeNames(names)
				.withExpressionAttributeValues(values)
				.withFilterExpression("#DYNOBASE_range BETWEEN :start AND :end");
		ScanResult result = client.scan(scanRequest);

		List<Item> itemList = ItemUtils.toItemList(result.getItems());
		List<LogRoot> returnRoots = new ArrayList<LogRoot>();
		for (Item i: itemList) {
			try {
				returnRoots.add(itemToObject(i, LogRoot.class));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Collections.sort(returnRoots, new Comparator<LogRoot>() { // Sort by last request in list
			@Override
			public int compare(LogRoot lhs, LogRoot rhs) {
				int compare = lhs.lastRequest.compareTo(rhs.lastRequest);
				return compare;
		    }
		});
		return returnRoots;
	}
}
