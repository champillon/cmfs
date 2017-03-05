package th.or.operationsmile.cmfs.model;

import th.or.operationsmile.cmfs.exception.ErrorFieldException;
import th.or.operationsmile.cmfs.exception.InvalidDataException;

public class RegistedPerson {

	private int runningId;

	private String title;
	private String firstName;
	private String lastName;
	private String firstNameEn;
	private String lastNameEn;
	private String birthDate;
	private String mobile;
	private String email;
	private String payInSlipPath;
	private boolean paid = false;
	private String runnerId;
	private String coRunner;

	public String getCoRunner() {
		return coRunner;
	}

	public void setCoRunner(String coRunner) {
		this.coRunner = coRunner;
	}

	public int getRunningId() {
		return runningId;
	}

	public void setRunningId(int runningId) {
		this.runningId = runningId;
	}

	public void setRunnerId(String runnerId) {
		this.runnerId = runnerId;
	}

	public String getRunnerId() {
		return runnerId;
	}

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

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
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

	public String getFirstNameEn() {
		return firstNameEn;
	}

	public void setFirstNameEn(String firstNameEn) throws InvalidDataException {
		if (InputValidation.validateFirstNameEn(firstNameEn)) {
			this.firstNameEn = firstNameEn;
		} else {
			throw new InvalidDataException("Invalid firstNameEn: " + firstNameEn);
		}
	}

	public String getLastNameEn() {
		return lastNameEn;
	}

	public void setLastNameEn(String lastNameEn) throws InvalidDataException {
		if (InputValidation.validateFirstNameEn(lastNameEn)) {
			this.lastNameEn = lastNameEn;
		} else {
			throw new InvalidDataException("Invalid lastNameEn: " + lastNameEn);
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

	public void setEmail(String email) throws InvalidDataException {
		if (InputValidation.validateEmail(email)) {
			this.email = email;
		} else {
			throw new InvalidDataException("Invalid email: " + email);
		}

	}

	public String getPayInSlipPath() {
		return payInSlipPath;
	}

	public void setPayInSlipPath(String payInSlipPath) {
		this.payInSlipPath = payInSlipPath;
	}

	public void validateAllField() throws ErrorFieldException, InvalidDataException {
		InputValidation.reValidateRegistedPerson(this);
	}

	@Override
	public String toString() {
		return "{" + this.getTitle() + "," + this.getFirstName() + "," + this.getLastName() + ","
				+ this.getFirstNameEn() + "," + this.getLastNameEn() + "," + this.getBirthDate() + ","
				+ this.getMobile() + "," + this.getEmail() + "," + this.getPayInSlipPath() + "}";
	}

}
