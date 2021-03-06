package th.or.operationsmile.cmfs.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import th.or.operationsmile.cmfs.exception.ErrorFieldException;
import th.or.operationsmile.cmfs.exception.InvalidDataException;
import th.or.operationsmile.cmfs.model.RegistedPerson;

public class Test_InputData {

	@Test
	public void can_input_right_title() throws InvalidDataException {
		String rightInput[] = { "mr", "mrs", "ms" };
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setTitle(rightInput[0]);
		assertEquals(rightInput[0], registedPerson.getTitle());

		registedPerson = new RegistedPerson();
		registedPerson.setTitle(rightInput[1]);
		assertEquals(rightInput[1], registedPerson.getTitle());

		registedPerson = new RegistedPerson();
		registedPerson.setTitle(rightInput[2]);
		assertEquals(rightInput[2], registedPerson.getTitle());

	}

	@Test(expected = InvalidDataException.class)
	public void cannot_input_wrong_title() throws InvalidDataException {
		String wrongInput = "xr";
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setTitle(wrongInput);
		assertEquals(null, registedPerson.getTitle());

	}
	
	@Test(expected = InvalidDataException.class)
	public void cannot_input_wrong_long_title() throws InvalidDataException {
		String wrongInput = "xrfdsafdsafsa";
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setTitle(wrongInput);
		assertEquals(null, registedPerson.getTitle());

	}

	@Test
	public void can_input_right_firstName() throws InvalidDataException {
		String rightInput = "testLongFirstName";
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setFirstName(rightInput);
		assertEquals(rightInput, registedPerson.getFirstName());
		
	}
	
	
	@Test(expected = InvalidDataException.class)
	public void cannot_input_wrong_firstName() throws InvalidDataException {
		String wrongInput = "testLongFirstNameVeryLongVeryLongLongMoreThan50Charactor";
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setFirstName(wrongInput);
		assertEquals(null, registedPerson.getFirstName());
		
	}
	
	@Test
	public void can_input_right_lastName() throws InvalidDataException {
		String rightInput = "testLongLastName";
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setLastName(rightInput);
		assertEquals(rightInput, registedPerson.getLastName());
		
	}
	
	@Test(expected = InvalidDataException.class)
	public void cannot_input_wrong_lastName() throws InvalidDataException {
		String wrongInput = "testLongFirstNameVeryLongVeryLongLongMoreThan50Charactor";
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setLastName(wrongInput);
		assertEquals(null, registedPerson.getLastName());
		
	}
	
	@Test
	public void can_input_right_birthDate() throws InvalidDataException {
		String rightInput = "31-12";
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setBirthDate(rightInput);
		assertEquals(rightInput, registedPerson.getBirthDate());
		
	}
	
	@Test(expected = InvalidDataException.class)
	public void can_input_wrong_birthDate() throws InvalidDataException {
		String wrongInput[] = {"99-13","22202x01-03","99-aa"};
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setBirthDate(wrongInput[0]);
		assertEquals(null, registedPerson.getBirthDate());
		
		registedPerson = new RegistedPerson();
		registedPerson.setBirthDate(wrongInput[1]);
		assertEquals(null, registedPerson.getBirthDate());
		
		registedPerson = new RegistedPerson();
		registedPerson.setBirthDate(wrongInput[2]);
		assertEquals(null, registedPerson.getBirthDate());
		
	}
	
	@Test
	public void can_input_right_mobile() throws InvalidDataException {
		String rightInput = "0922514661";
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setMobile(rightInput);
		assertEquals(rightInput, registedPerson.getMobile());
		
	}
	
	@Test(expected = InvalidDataException.class)
	public void can_input_wrong_mobile() throws InvalidDataException {
		String wrongInput[] = {"x922514661","01234567890"};
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setMobile(wrongInput[0]);
		assertEquals(null, registedPerson.getMobile());
		
		registedPerson = new RegistedPerson();
		registedPerson.setMobile(wrongInput[1]);
		assertEquals(null, registedPerson.getMobile());
		
	}
	
	@Test
	public void can_input_right_email() throws InvalidDataException {
		String rightInput = "test@test.com";
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setEmail(rightInput);
		assertEquals(rightInput, registedPerson.getEmail());
		
	}
	
	@Test(expected = InvalidDataException.class)
	public void can_input_wrong_email() throws InvalidDataException {
		String wrongInput[] = {"tost@tost","testtest.com"};
		RegistedPerson registedPerson = null;

		registedPerson = new RegistedPerson();
		registedPerson.setEmail(wrongInput[0]);
		assertEquals(null, registedPerson.getEmail());
		
		registedPerson = new RegistedPerson();
		registedPerson.setMobile(wrongInput[1]);
		assertEquals(null, registedPerson.getEmail());
		
	}
	
	@Test
	public void can_input_right_registedPerson()throws ErrorFieldException,InvalidDataException{
		RegistedPerson rightInput = new RegistedPerson();
		rightInput.setTitle("mr");
		rightInput.setFirstName("TestFirstName");
		rightInput.setLastName("TestLastName");
                rightInput.setFirstNameEn("TestFirstNameEn");
		rightInput.setLastNameEn("TestLastNameEn");
		rightInput.setBirthDate("31-12");
		rightInput.setMobile("0123456789");
		rightInput.setEmail("test@test.com");
		rightInput.setPayInSlipPath("/path/for/test/");
		
		rightInput.validateAllField();
		assertEquals("mr", rightInput.getTitle());
		
	}
	
	@Test(expected = ErrorFieldException.class)
	public void cannot_input_null_fields_in_registedPerson()throws ErrorFieldException,InvalidDataException{
		RegistedPerson rightInput = new RegistedPerson();
		rightInput.setTitle("mr");
		rightInput.setFirstName("TestFirstName");
		rightInput.setLastName("TestLastName");
		rightInput.setBirthDate("31-11");
		rightInput.setMobile("0123456789");
		rightInput.setEmail("test@test.com");
		rightInput.setPayInSlipPath("/path/for/test/");
		
		rightInput.validateAllField();
		assertEquals(null, rightInput.getTitle());
		
	}
	
	@Test
	public void can_print_toString()throws InvalidDataException{
		RegistedPerson registedPerson= new RegistedPerson();
		registedPerson.setTitle("mr");
		registedPerson.setFirstName("TestFirstName");
		registedPerson.setLastName("TestLastName");
                registedPerson.setFirstNameEn("TestFirstNameEn");
		registedPerson.setLastNameEn("TestLastNameEn");
		registedPerson.setBirthDate("31-12");
		registedPerson.setMobile("0123456789");
		registedPerson.setEmail("test@test.com");
		registedPerson.setPayInSlipPath("/path/for/test/");
		
		assertEquals(registedPerson.toString(),
				"{mr,TestFirstName,TestLastName,TestFirstNameEn,TestLastNameEn,31-12,0123456789,test@test.com,/path/for/test/}");
	}
}
