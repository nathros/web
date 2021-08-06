package web.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Forms {
	public final static String INPUT_NAME = "firstname";
	public final static String INPUT_USER = "user";
	public final static String INPUT_EMAIL = "email";
	public final static String INPUT_SUBJECT = "subject";
	public final static String INPUT_COMMENT = "comment";
	public final static String INPUT_CAPTCHA = "captcha";

	public final static String SCRIPT_INPUT = "checkInputEmpty";
	public final static String SCRIPT_INPUT_EMAIL = "checkInputEmail";
	public final static String SCRIPT_INPUT_EMAIL_LEAVE = "checkInputEmailLeave";
	public final static String SCRIPT_INPUT_CAPTCHA = "checkInputCAPTCHA";
	public final static String ERROR_MESSAGE_REQUIRED = "REQUIRED";
	public final static String ERROR_MESSAGE_EMAIL = "INVALID EMAIL";
	public final static String ERROR_MESSAGE_INCORRECT = "INCORRECT";

	public static boolean isContentValid(String value, HttpMethod method) {
		if (HttpMethod.POST == method) {
			if ((value == null) || (value.trim().equals(""))) {
				return false;
			}
		}
		return true;
	}

	public static boolean encodedCAPTCHACompareValid(String encoded, String userInput, HttpMethod method) {
		if (method == HttpMethod.POST) {
			if (isContentValid(userInput, method)) {
				try {
					String compare = Debug.serialise(userInput);
					return compare.equals(encoded);
				} catch (IOException e) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public static List<Integer> getNewCAPTCHANumbers() {
		List<Integer> list = new ArrayList<Integer>();

		Random random = new Random();
		int number1;
		do {
			number1 = Math.abs(random.nextInt() % 10);
		} while ((number1 == 6) || (number1 == 9));
		int number2;
		do {
			number2 = Math.abs(random.nextInt() % 10);
		} while ((number2 == 6) || (number2 == 9));

		list.add(number1);
		list.add(number2);
		return list;
	}
}