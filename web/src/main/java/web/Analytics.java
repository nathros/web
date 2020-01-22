package web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
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

	DynamoDB dynamoDB;
	// https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/GettingStarted.Java.04.html

	public Analytics() {
		nowStr = dtf.format(LocalDateTime.now());

		ProfileCredentialsProvider profile = new ProfileCredentialsProvider();
		boolean error = false;
		try {
			error = !(profile.getCredentials() == null);
		} catch (Exception e) {
			error = true;
		}

		if (!error) { // Use local profile if
			AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_WEST_1)
					.withCredentials(new ProfileCredentialsProvider()).build();
			dynamoDB = new DynamoDB(client);
		} else { // If not try default
			AmazonDynamoDBAsync client = AmazonDynamoDBAsyncClientBuilder.defaultClient();
			dynamoDB = new DynamoDB(client);
		}

	}

	public void logRequestRequest(RequestInfo request) {

		Table table = dynamoDB.getTable("web");
		try {
			table.putItem(new Item().withPrimaryKey("access", nowStr).withMap("info", request.requestMap));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public RequestInfo getRequestFromDB() {
		Table table = dynamoDB.getTable("web");

		GetItemSpec spec = new GetItemSpec().withPrimaryKey("access", "access");

		try {
			Item outcome = table.getItem(spec);
			return new RequestInfo(outcome.asMap());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return null;
	}
}
