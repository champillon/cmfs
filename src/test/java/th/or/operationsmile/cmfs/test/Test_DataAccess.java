package th.or.operationsmile.cmfs.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import th.or.operationsmile.cmfs.exception.ErrorFieldException;
import th.or.operationsmile.cmfs.exception.InvalidDataException;
import th.or.operationsmile.cmfs.io.DataAccess;
import th.or.operationsmile.cmfs.model.RegistedPerson;

public class Test_DataAccess {
	private static final String databaseUsername = "root";
	private static final String databasePassword = "welcome1";
	private static final String databaseConnectionUrl = "jdbc:mysql://localhost:3306/cmfs?useUnicode=true&characterEncoding=utf-8";
	
	private static final String insertSQL = "INSERT INTO registedPerson "
			+ "(title,firstName,lastName,birthDate,mobile,email,tShirtSize,tShirtPickUpPoint,payInSlipPath,paid) "
			+ "VALUES('mr',?,'TestLastName','31-12','0123456789','test@test.com','m','aa','/path/for/test/',FALSE);";
	private static final String selectSQL = "SELECT * FROM registedPerson WHERE email = ? ;";
	private static final String clearUpSQL = "DELETE FROM registedPerson;";
	private static final String selectMaxRunnerID = "SELECT max(runnerId) FROM registedPerson;";

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
	public void can_add_correct_registedPerson() throws InvalidDataException, ErrorFieldException, SQLException {
		RegistedPerson rightInput = new RegistedPerson();
		rightInput.setTitle("mr");
		rightInput.setFirstName("TestFirstName");
		rightInput.setLastName("TestLastName");
		rightInput.setBirthDate("31-12");
		rightInput.setMobile("0123456789");
		rightInput.setEmail("test@test.com");
		rightInput.settShirtSize("m");
		rightInput.settShirtPickUpPoint("aa");
		rightInput.setPayInSlipPath("/path/for/test/");

		DataAccess dataAccess = new DataAccess(this.databaseConnection);
		dataAccess.addRegistedPerson(rightInput);

		PreparedStatement queryResultStatement = databaseConnection.prepareStatement(selectSQL);
		queryResultStatement.setString(1, "test@test.com");
		ResultSet queryResult = queryResultStatement.executeQuery();

		queryResult.next();
		assertEquals(queryResult.getString("title"), "mr");
		assertEquals(queryResult.getString("firstName"), "TestFirstName");
		assertEquals(queryResult.getString("lastName"), "TestLastName");
		assertEquals(queryResult.getString("birthDate"), "31-12");
		assertEquals(queryResult.getString("mobile"), "0123456789");
		assertEquals(queryResult.getString("email"), "test@test.com");
		assertEquals(queryResult.getString("tShirtSize"), "m");
		assertEquals(queryResult.getString("tShirtPickUpPoint"), "aa");
		assertEquals(queryResult.getString("payInSlipPath"), "/path/for/test/");
		assertEquals(queryResult.getBoolean("paid"), false);
		
		queryResult.close();
		queryResultStatement.close();

	}
	
	@Test
	public void can_query_correct_registedPerson() throws SQLException{
		String queryFirstName1 = "TestFirstName1";
		String queryFirstName2 = "TestFirstName2";
		String queryFirstName3 = "ภาษาไทย";
		List<RegistedPerson> registedPeople = null;
		
		PreparedStatement insertStatement = databaseConnection.prepareStatement(insertSQL);
		insertStatement.setString(1, queryFirstName1);
		insertStatement.executeUpdate();
		insertStatement.close();
		
		PreparedStatement insertStatement2  = databaseConnection.prepareStatement(insertSQL);
		insertStatement2.setString(1, queryFirstName2);
		insertStatement2.executeUpdate();
		insertStatement2.close();
		
		PreparedStatement insertStatement3 = databaseConnection.prepareStatement(insertSQL);
		insertStatement3.setString(1, queryFirstName3);
		insertStatement3.executeUpdate();
		insertStatement3.close();
		
		DataAccess dataAccess = new DataAccess(this.databaseConnection);
		registedPeople = dataAccess.queryRegistedPersonByName(queryFirstName3);
		
		for(RegistedPerson registedPerson: registedPeople){

			assertEquals(registedPerson.getTitle(), "mr");
			assertEquals(registedPerson.getFirstName(),queryFirstName3 );
			assertEquals(registedPerson.getLastName(), "TestLastName");
			assertEquals(registedPerson.getBirthDate(), "31-12");
			assertEquals(registedPerson.getMobile(), "0123456789");
			assertEquals(registedPerson.gettShirtSize(), "m");
			assertEquals(registedPerson.gettShirtPickUpPoint(), "aa");
			assertEquals(registedPerson.getPayInSlipPath(), "/path/for/test/");
			assertEquals(registedPerson.isPaid(), false);
		}		
		
		
	}
	
	@Test
	public void can_confirmed_paySlip() throws SQLException{
		String queryFirstName1 = "TestFirstName1";
		String queryFirstName2 = "TestFirstName2";
		String queryFirstName3 = "ภาษาไทย";
		List<RegistedPerson> registedPeople = null;
		RegistedPerson registedPerson = null;
		
		PreparedStatement insertStatement = databaseConnection.prepareStatement(insertSQL);
		insertStatement.setString(1, queryFirstName1);
		insertStatement.executeUpdate();
		insertStatement.close();
		
		PreparedStatement insertStatement2  = databaseConnection.prepareStatement(insertSQL);
		insertStatement2.setString(1, queryFirstName2);
		insertStatement2.executeUpdate();
		insertStatement2.close();
		
		PreparedStatement insertStatement3 = databaseConnection.prepareStatement(insertSQL);
		insertStatement3.setString(1, queryFirstName3);
		insertStatement3.executeUpdate();
		insertStatement3.close();
		
		DataAccess dataAccess = new DataAccess(this.databaseConnection);
		registedPeople = dataAccess.queryRegistedPersonByName(queryFirstName1);
		registedPerson = registedPeople.get(0);
		
		dataAccess.confirmedPaySlipAndGenerateRunningKey(registedPerson);
		
		PreparedStatement queryResultStatement = databaseConnection.prepareStatement(selectMaxRunnerID);
		ResultSet queryResult = queryResultStatement.executeQuery();

		queryResult.next();
		assertEquals(queryResult.getString("max(runnerId)"),registedPerson.getRunnerId());
		
		
	}

}
