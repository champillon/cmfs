package th.or.operationsmile.cmfs.model;

import th.or.operationsmile.cmfs.exception.InvalidDataException;

public class RegistedPerson {

	private String title;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String mobile;
	private String email;
	private String address;
	private String tShirtSize;
	private String tShirtPickUpPoint;
	private String payInSlipPath;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws InvalidDataException {
		if (InputValidation.validateTitle(title)) {
			this.title = title;
		} else {
			throw new InvalidDataException("Invalid title: " + title);
		}

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws InvalidDataException {
		if (InputValidation.validateFirstName(firstName)) {
			this.firstName = firstName;
		} else {
			throw new InvalidDataException("Invalid firstName: " + firstName);
		}

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws InvalidDataException {
		if (InputValidation.validateLastName(lastName)) {
			this.lastName = lastName;
		} else {
			throw new InvalidDataException("Invalid lastName: " + lastName);
		}
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) throws InvalidDataException {
		if (InputValidation.validateBirthDate(birthDate)) {
			this.birthDate = birthDate;
		} else {
			throw new InvalidDataException("Invalid birthDate: " + birthDate);
		}

	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) throws InvalidDataException {
		if (InputValidation.validateMobile(mobile)) {
			this.mobile = mobile;
		} else {
			throw new InvalidDataException("Invalid mobile: " + mobile);
		}

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email)throws InvalidDataException {
		if (InputValidation.validateEmail(email)) {
			this.email = email;
		} else {
			throw new InvalidDataException("Invalid email: " + email);
		}
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String gettShirtSize() {
		return tShirtSize;
	}

	public void settShirtSize(String tShirtSize)throws InvalidDataException {
		
		if (InputValidation.validateTShirtSize(tShirtSize)) {
			this.tShirtSize = tShirtSize;
		} else {
			throw new InvalidDataException("Invalid tShirtSize: " + tShirtSize);
		}
		
	}

	public String gettShirtPickUpPoint() {
		return tShirtPickUpPoint;
	}

	public void settShirtPickUpPoint(String tShirtPickUpPoint) {
		this.tShirtPickUpPoint = tShirtPickUpPoint;
	}

	public String getPayInSlipPath() {
		return payInSlipPath;
	}

	public void setPayInSlipPath(String payInSlipPath) {
		this.payInSlipPath = payInSlipPath;
	}

}
