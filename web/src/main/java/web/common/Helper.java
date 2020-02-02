package web.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

	static Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

	public static boolean isValidEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		boolean b = matcher.matches();
		return b;
	}
}
