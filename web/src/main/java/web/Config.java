package web;

public class Config {
	public static final boolean logToDynamoDB = false;

	// Recipient of e-mails from contact page
	public static final String emailPassword = "password";
	public static final String emailAddress = "sender@hotmail.co.uk";

	// Prints the full raw HTTP request, localhost testing only
	public static final boolean printVerboseRequest = false;
}
