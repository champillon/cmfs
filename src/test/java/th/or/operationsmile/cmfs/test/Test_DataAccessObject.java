package th.or.operationsmile.cmfs.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import th.or.operationsmile.cmfs.exception.ErrorFieldException;
import th.or.operationsmile.cmfs.exception.InvalidDataException;
import th.or.operationsmile.cmfs.io.DataAccessObject;
import th.or.operationsmile.cmfs.model.RegistedPerson;

public class Test_DataAccessObject {
	private static final String databaseUsername = "root";
	private static final String databasePassword = "welcome1";
	private static final String databaseConnectionUrl = "jdbc:mysql://localhost:3306/cmfs";

	private static final String selectSQL = "SELECT * FROM registedPerson WHERE email = ? ;";
	private static final String clearUpSQL = "DELETE FROM registedPerson;";

	private Connection databaseConnection = null;

	@Before
	public void startDatabaseConnection() {
		try {
			databaseConnection = DriverManager.getConnection(databaseConnectionUrl, databaseUsername, databasePassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@After
	public void stopDatabaseConnection() {
		try {
			Statement statement = databaseConnection.createStatement();
			statement.executeUpdate(clearUpSQL);
			statement.close();
			databaseConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void can_insert_correct_registedPerson() throws InvalidDataException, ErrorFieldException, SQLException {
		RegistedPerson rightInput = new RegistedPerson();
		rightInput.setTitle("mr");
		rightInput.setFirstName("TestFirstName");
		rightInput.setLastName("TestLastName");
		rightInput.setBirthDate("2000-11-11");
		rightInput.setMobile("0123456789");
		rightInput.setEmail("test@test.com");
		rightInput.setAddress("address...");
		rightInput.settShirtSize("m");
		rightInput.settShirtPickUpPoint("aa");
		rightInput.setPayInSlipPath("/path/for/test/");

		DataAccessObject dataAccessObject = new DataAccessObject(this.databaseConnection);
		dataAccessObject.addRegistedPerson(rightInput);

		PreparedStatement queryResultStatement = databaseConnection.prepareStatement(selectSQL);
		queryResultStatement.setString(1, "test@test.com");
		ResultSet queryResult = queryResultStatement.executeQuery();

		queryResult.next();
		assertEquals(queryResult.getString("title"), "mr");
		assertEquals(queryResult.getString("firstName"), "TestFirstName");
		assertEquals(queryResult.getString("lastName"), "TestLastName");
		assertEquals(queryResult.getString("birthDate"), "2000-11-11");
		assertEquals(queryResult.getString("mobile"), "0123456789");
		assertEquals(queryResult.getString("email"), "test@test.com");
		assertEquals(queryResult.getString("address"), "address...");
		assertEquals(queryResult.getString("tShirtSize"), "m");
		assertEquals(queryResult.getString("tShirtPickUpPoint"), "aa");
		assertEquals(queryResult.getString("payInSlipPath"), "/path/for/test/");
		assertEquals(queryResult.getBoolean("paid"), false);

	}

}
