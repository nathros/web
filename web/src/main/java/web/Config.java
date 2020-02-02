package web;

public class Config {
	public static final boolean logToDynamoDB = false;

	// Recipient of e-mails from contact page
	public static final String contactEmailAddress = "sender@gmail.com";
	public static final String contactEmailPassword = "password";
	public static final String destinationEmailAddress = "receiver@gmail.com";

	// Prints the full raw HTTP request, localhost testing only
	public static final boolean printVerboseRequest = false;
}
