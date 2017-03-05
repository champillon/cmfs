package th.or.operationsmile.cmfs.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import th.or.operationsmile.cmfs.exception.ErrorFieldException;
import th.or.operationsmile.cmfs.exception.InvalidDataException;

public class InputValidation {
	private static final String correctTitles[] = { "mr", "mrs", "ms" };

	private static final int firstNameMustNotLongThanThis = 50;

	private static final int lastNameMustNotLongThanThis = 50;

	private static final String correctDateFormat = "dd-MM";
	private static final int birthDateMustLongEqualToThis = 5;

	private static final String correctMobileFormat = "[0-9]+";
	private static final int mobileMustLongEqualToThis = 10;

	private static final String correctEmailFormat = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String correctTShirtSizes[] = { "s", "m", "l", "xl" };
        
        private static final String nameEnlishFormat = "[a-zA-Z]+";

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
        
        public static boolean validateFirstNameEn(String firstNameEn){
            return firstNameEn.length() < firstNameMustNotLongThanThis && firstNameEn.length() >0;
        }
        
        public static boolean validateLastNameEn(String lastNameEn){
            return lastNameEn.length() < lastNameMustNotLongThanThis && lastNameEn.length() > 0;
        }
        
        public static boolean validateFirstNameEnFormat(String firstNameEn){
            return firstNameEn.matches(nameEnlishFormat);
        }
        
        public static boolean validateLastNameEnFormat(String lastNameEn){
            return lastNameEn.matches(nameEnlishFormat);
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
		
		int date = Integer.parseInt(""+birthDate.subSequence(0,2));
		int month = Integer.parseInt(""+birthDate.subSequence(3,5));
		
		if(date>31){
			result = false;
		}
		if(month>12){
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

	public static void reValidateRegistedPerson(RegistedPerson registedPerson)throws ErrorFieldException,InvalidDataException {

		
		if(registedPersonHaveNoNullField(registedPerson)){
			reValidateRegistedPersonField(registedPerson);
		}
		else{
			throw new Error("critical invalid condition: "+registedPerson);
		}

	}
	
	private static void reValidateRegistedPersonField(RegistedPerson registedPerson)throws InvalidDataException{
		validateTitle(registedPerson.getTitle());
		validateFirstName(registedPerson.getFirstName());
		validateLastName(registedPerson.getLastName());
                validateFirstNameEn(registedPerson.getFirstNameEn());
                validateLastNameEn(registedPerson.getLastNameEn());
		validateBirthDate(registedPerson.getBirthDate());
		validateMobile(registedPerson.getMobile());
		validateEmail(registedPerson.getEmail());
	}

	private static boolean registedPersonHaveNoNullField(RegistedPerson registedPerson)throws ErrorFieldException {
		boolean result = false;
		
			if(registedPerson.getTitle() == null){
				throw new ErrorFieldException("found null filed","title");
			}
			else if(registedPerson.getFirstName() == null){
				throw new ErrorFieldException("found null filed","firstName");
			}
			else if(registedPerson.getLastName() == null){
				throw new ErrorFieldException("found null filed","lastName");
			}
                        else if(registedPerson.getFirstNameEn() == null){
                            throw new ErrorFieldException("found null filed","firstNameEn");
                        }
                        else if(registedPerson.getLastNameEn() == null){
                            throw new ErrorFieldException("found null filed","lastNameEn");
                        }
			else if(registedPerson.getBirthDate() == null){
				throw new ErrorFieldException("found null filed","birthDate");
			}
			else if(registedPerson.getMobile() == null){
				throw new ErrorFieldException("found null filed","mobile");
			}
			else if(registedPerson.getEmail() == null){
				throw new ErrorFieldException("found null filed","email");
			}
			else if(registedPerson.getPayInSlipPath() == null){
				throw new ErrorFieldException("found null filed","payInSlipPath");
			}
			else{
				result = true;
			}

		return result;
	}
}
