package th.or.operationsmile.cmfs.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputValidation {
	private static final String correctTitles[] = { "mr", "mrs", "ms" };

	private static final int firstNameMustNotLongThanThis = 50;

	private static final int lastNameMustNotLongThanThis = 50;

	private static final String correctDateFormat = "yyyy-MM-dd";
	private static final int birthDateMustLongEqualToThis = 10;

	private static final String correctMobileFormat = "[0-9]+";
	private static final int mobileMustLongEqualToThis = 10;

	private static final String correctEmailFormat = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String correctTShirtSizes[] = { "s", "m", "l","xl"};

	public static boolean validateTitle(String title) {
		boolean result = false;

		for (String correctTitle : correctTitles) {
			if (title.equals(correctTitle)) {
				result = true;
			}
		}

		return result;
	}

	public static boolean validateFirstName(String firstName) {
		boolean result = false;

		if (firstName.length() < firstNameMustNotLongThanThis) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validateLastName(String firstName) {
		boolean result = false;

		if (firstName.length() < lastNameMustNotLongThanThis) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validateBirthDate(String birthDate) {
		boolean result = false;
		if (correctBirthDateLength(birthDate)) {
			result = correctBirthDateFormat(birthDate);
		}
		return result;
	}

	private static boolean correctBirthDateFormat(String birthDate) {
		boolean result = false;
		SimpleDateFormat dateFormat = new SimpleDateFormat(correctDateFormat);

		try {
			dateFormat.parse(birthDate);
			result = true;
		} catch (ParseException exception) {
			result = false;
		}
		return result;
	}

	private static boolean correctBirthDateLength(String birthDate) {
		if (birthDate.length() == birthDateMustLongEqualToThis) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validateMobile(String mobile) {
		boolean result = false;

		if (correctMobileLength(mobile)) {
			result = correctMobileFormat(mobile);
		}

		return result;
	}

	private static boolean correctMobileLength(String mobile) {

		if (mobile.length() == mobileMustLongEqualToThis) {
			return true;
		} else {
			return false;
		}

	}

	private static boolean correctMobileFormat(String mobile) {
		return mobile.matches(correctMobileFormat);
	}

	public static boolean validateEmail(String email) {
		return email.matches(correctEmailFormat);
	}
	
	public static boolean validateTShirtSize(String tShirtSize) {
		boolean result = false;

		for (String correctTitle : correctTShirtSizes) {
			if (tShirtSize.equals(correctTitle)) {
				result = true;
			}
		}

		return result;
	}
}
