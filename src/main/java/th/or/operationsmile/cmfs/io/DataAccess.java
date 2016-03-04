package th.or.operationsmile.cmfs.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import th.or.operationsmile.cmfs.exception.ErrorFieldException;
import th.or.operationsmile.cmfs.exception.InvalidDataException;
import th.or.operationsmile.cmfs.model.InputValidation;
import th.or.operationsmile.cmfs.model.RegistedPerson;

public class DataAccess {

	private Connection databaseConnection = null;
	private static final String insertSQL = "INSERT INTO registedPerson ("
			+ "title,firstName,lastName,firstNameEn,lastNameEn,birthDate,mobile,email,tShirtSize,tShirtPickUpPoint,payInSlipPath,paid) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

	private static final String updateSQLForConfirmedPayment = "UPDATE registedPerson " 
			+ "SET paid = TRUE, runnerId = ? "
			+ "WHERE runningId = ?;";
	private static final String selectMaxRunnerID = "SELECT max(runnerId) FROM registedPerson;";

	private static final String selectSQLwithFirstName = "SELECT * FROM registedPerson WHERE firstName = ? ;";
	private static final String selectSQLwithRunningId = "SELECT * FROM registedPerson WHERE runningId = ? ;";
	private static final String selectSQL = "SELECT * FROM registedPerson;";

	public DataAccess(Connection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void addRegistedPerson(RegistedPerson registedPerson)
			throws ErrorFieldException, InvalidDataException, SQLException {
		InputValidation.reValidateRegistedPerson(registedPerson);
		this.insertToDatabase(registedPerson);
	}

	private void insertToDatabase(RegistedPerson registedPerson) throws SQLException {
		PreparedStatement preparedStatement = databaseConnection.prepareStatement(insertSQL);

		preparedStatement.setString(1, registedPerson.getTitle());
		preparedStatement.setString(2, registedPerson.getFirstName());
		preparedStatement.setString(3, registedPerson.getLastName());
                preparedStatement.setString(4, registedPerson.getFirstNameEn());
		preparedStatement.setString(5, registedPerson.getLastNameEn());
		preparedStatement.setString(6, registedPerson.getBirthDate());
		preparedStatement.setString(7, registedPerson.getMobile());
		preparedStatement.setString(8, registedPerson.getEmail());
		preparedStatement.setString(9, registedPerson.gettShirtSize());
		preparedStatement.setString(10, registedPerson.gettShirtPickUpPoint());
		preparedStatement.setString(11, registedPerson.getPayInSlipPath());
		preparedStatement.setBoolean(12, registedPerson.isPaid());
		

		preparedStatement.executeUpdate();
		preparedStatement.close();

	}

	public List<RegistedPerson> queryRegistedPersonByFirstName(String queryName) throws SQLException {
		PreparedStatement queryResultStatement = databaseConnection.prepareStatement(selectSQLwithFirstName);
		queryResultStatement.setString(1, queryName);
		ResultSet queryResult = queryResultStatement.executeQuery();

		List<RegistedPerson> results = new ArrayList<RegistedPerson>();
		RegistedPerson registedPerson = null;

		while (queryResult.next()) {
			registedPerson = new RegistedPerson();

			try {
				registedPerson.setRunningId(queryResult.getInt("runningId"));
				registedPerson.setTitle(queryResult.getString("title"));
				registedPerson.setFirstName(queryResult.getString("firstName"));
				registedPerson.setLastName(queryResult.getString("lastName"));
				registedPerson.setFirstNameEn(queryResult.getString("firstNameEn"));
				registedPerson.setLastNameEn(queryResult.getString("lastNameEn"));
				registedPerson.setBirthDate(queryResult.getString("birthDate"));
				registedPerson.setMobile(queryResult.getString("mobile"));
				registedPerson.setEmail(queryResult.getString("email"));
				registedPerson.settShirtSize(queryResult.getString("tShirtSize"));
				registedPerson.settShirtPickUpPoint(queryResult.getString("tShirtPickUpPoint"));
				registedPerson.setPayInSlipPath(queryResult.getString("payInSlipPath"));
				registedPerson.setPaid(queryResult.getBoolean("paid"));
				registedPerson.setRunnerId(queryResult.getString("runnerId"));

				results.add(registedPerson);

			} catch (InvalidDataException e) {
				e.printStackTrace();
			}

		}

		queryResult.close();
		queryResultStatement.close();

		return results;
	}

	public RegistedPerson queryRegistedPersonByRunningId(int queryRunningId) throws SQLException {
		PreparedStatement queryResultStatement = databaseConnection.prepareStatement(selectSQLwithRunningId);
		queryResultStatement.setInt(1, queryRunningId);
		ResultSet queryResult = queryResultStatement.executeQuery();

		RegistedPerson result = null;

		queryResult.next();
		result = new RegistedPerson();

		try {
			result.setRunningId(queryResult.getInt("runningId"));
			result.setTitle(queryResult.getString("title"));
			result.setFirstName(queryResult.getString("firstName"));
			result.setLastName(queryResult.getString("lastName"));
			result.setFirstNameEn(queryResult.getString("firstNameEn"));
			result.setLastNameEn(queryResult.getString("lastNameEn"));
			result.setBirthDate(queryResult.getString("birthDate"));
			result.setMobile(queryResult.getString("mobile"));
			result.setEmail(queryResult.getString("email"));
			result.settShirtSize(queryResult.getString("tShirtSize"));
			result.settShirtPickUpPoint(queryResult.getString("tShirtPickUpPoint"));
			result.setPayInSlipPath(queryResult.getString("payInSlipPath"));
			result.setPaid(queryResult.getBoolean("paid"));
			result.setRunnerId(queryResult.getString("runnerId"));

		} catch (InvalidDataException e) {
			e.printStackTrace();
		}

		queryResult.close();
		queryResultStatement.close();

		return result;
	}

	public List<RegistedPerson> queryRegistedPerson() throws SQLException {
		PreparedStatement queryResultStatement = databaseConnection.prepareStatement(selectSQL);
		ResultSet queryResult = queryResultStatement.executeQuery();

		List<RegistedPerson> results = new ArrayList<RegistedPerson>();
		RegistedPerson registedPerson = null;

		while (queryResult.next()) {
			registedPerson = new RegistedPerson();

			try {
				registedPerson.setRunningId(queryResult.getInt("runningId"));
				registedPerson.setTitle(queryResult.getString("title"));
				registedPerson.setFirstName(queryResult.getString("firstName"));
				registedPerson.setLastName(queryResult.getString("lastName"));
				registedPerson.setFirstNameEn(queryResult.getString("firstNameEn"));
				registedPerson.setLastNameEn(queryResult.getString("lastNameEn"));
				registedPerson.setBirthDate(queryResult.getString("birthDate"));
				registedPerson.setMobile(queryResult.getString("mobile"));
				registedPerson.setEmail(queryResult.getString("email"));
				registedPerson.settShirtSize(queryResult.getString("tShirtSize"));
				registedPerson.settShirtPickUpPoint(queryResult.getString("tShirtPickUpPoint"));
				registedPerson.setPayInSlipPath(queryResult.getString("payInSlipPath"));
				registedPerson.setPaid(queryResult.getBoolean("paid"));
				registedPerson.setRunnerId(queryResult.getString("runnerId"));
				
				results.add(registedPerson);

			} catch (InvalidDataException e) {
				e.printStackTrace();
			}

		}

		queryResult.close();
		queryResultStatement.close();

		return results;
	}

	public void confirmedPaySlipAndGenerateRunningKey(RegistedPerson registedPerson) throws SQLException {
		int maxRunnerId;
		PreparedStatement queryResultStatement = databaseConnection.prepareStatement(selectMaxRunnerID);
		ResultSet queryResult = queryResultStatement.executeQuery();

		queryResult.next();
		maxRunnerId = queryResult.getInt("max(runnerId)");

		maxRunnerId++;
		registedPerson.setRunnerId(maxRunnerId + "");

		queryResult.close();
		queryResultStatement.close();

		PreparedStatement updateResultStatement = databaseConnection.prepareStatement(updateSQLForConfirmedPayment);
		updateResultStatement.setString(1, registedPerson.getRunnerId());
		updateResultStatement.setInt(2, registedPerson.getRunningId());

		updateResultStatement.executeUpdate();
		updateResultStatement.close();

	}

}
