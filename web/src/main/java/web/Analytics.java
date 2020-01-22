package web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss:A");
	String nowStr = null;

	public Analytics() {
		nowStr = dtf.format(LocalDateTime.now());
	}

	public void logRequestRequest(RequestInfo request) {
		// ProfilesConfigFile a = new ProfilesConfigFile("");

		BasicAWSCredentials creds = new BasicAWSCredentials("", "");

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_WEST_1)
				.withCredentials(new AWSStaticCredentialsProvider(creds)).build();

		DynamoDB dynamoDB = new DynamoDB(client);
		Table table = dynamoDB.getTable("web");

		try {
			PutItemOutcome outcome = table
					.putItem(new Item().withPrimaryKey("access", nowStr).withMap("info", request.requestMap));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// AmazonDynamoDBAsync bb = AmazonDynamoDBAsyncClientBuilder.defaultClient();

		// https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/javav2/example_code/dynamodb/src/main/java/com/example/dynamodb
		// https://stackoverflow.com/questions/47763573/aws-credentials-for-lambda-when-working-with-scala-not-working
		// https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/GettingStarted.Java.04.html
	}

	public RequestInfo getRequestFromDB() {

		BasicAWSCredentials creds = new BasicAWSCredentials("", "");

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_WEST_1)
				.withCredentials(new AWSStaticCredentialsProvider(creds)).build();

		DynamoDB dynamoDB = new DynamoDB(client);
		Table table = dynamoDB.getTable("web");

		GetItemSpec spec = new GetItemSpec().withPrimaryKey("access", "access");

		try {
			Item outcome = table.getItem(spec);
			RequestInfo req = new RequestInfo(outcome.asMap());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

	// final Map<String, Object> infoMap = new HashMap<String, Object>();
	// final Map<String, Object> innerMap = new HashMap<String, Object>();
	// innerMap.put("inner", "testmap2");
	// infoMap.put("plot", "aaa");
	// infoMap.put("plot2", innerMap);
}
