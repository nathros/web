package web;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

import web.common.RequestInfo;

public class Analytics {

	public static void logRequestRequest(RequestInfo request) {
		// ProfilesConfigFile a = new ProfilesConfigFile("");

		BasicAWSCredentials creds = new BasicAWSCredentials("", "");

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_WEST_1)
				.withCredentials(new AWSStaticCredentialsProvider(creds)).build();

		DynamoDB dynamoDB = new DynamoDB(client);
		Table table = dynamoDB.getTable("web");

		// final Map<String, Object> infoMap = new HashMap<String, Object>();
		// final Map<String, Object> innerMap = new HashMap<String, Object>();
		// innerMap.put("inner", "testmap2");
		// infoMap.put("plot", "aaa");
		// infoMap.put("plot2", innerMap);

		try {
			System.out.println("Adding a new item...");
			PutItemOutcome outcome = table
					.putItem(new Item().withPrimaryKey("access", "access").withMap("info", request.requestMap));

			System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// AmazonDynamoDBAsync bb = AmazonDynamoDBAsyncClientBuilder.defaultClient();

		// https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/javav2/example_code/dynamodb/src/main/java/com/example/dynamodb
		// https://stackoverflow.com/questions/47763573/aws-credentials-for-lambda-when-working-with-scala-not-working
	}

	public static RequestInfo getRequestFromDB() {

		BasicAWSCredentials creds = new BasicAWSCredentials("", "");

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_WEST_1)
				.withCredentials(new AWSStaticCredentialsProvider(creds)).build();

		DynamoDB dynamoDB = new DynamoDB(client);
		Table table = dynamoDB.getTable("web");

		GetItemSpec spec = new GetItemSpec().withPrimaryKey("access", "access");

		try {
			System.out.println("Attempting to read the item...");
			Item outcome = table.getItem(spec);

			RequestInfo req = new RequestInfo(outcome.asMap());
			System.out.println("GetItem succeeded:  " + outcome);
			System.out.println(req.getPrettyHTML());

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return null;
	}
}
