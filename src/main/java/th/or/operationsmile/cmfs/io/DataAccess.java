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
			+ "title,firstName,lastName,birthDate,mobile,email,tShirtSize,tShirtPickUpPoint,payInSlipPath,paid) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?);";
	
	private static final String selectSQL = "SELECT * FROM registedPerson WHERE firstName = ? ;";
	
	public DataAccess(Connection databaseConnection){
		this.databaseConnection = databaseConnection;
	}
	
	public void addRegistedPerson(RegistedPerson registedPerson) throws ErrorFieldException, InvalidDataException, SQLException{
		InputValidation.reValidateRegistedPerson(registedPerson);
		this.insertToDatabase(registedPerson);
	}
	
	private void insertToDatabase(RegistedPerson registedPerson) throws SQLException {
		PreparedStatement preparedStatement = databaseConnection.prepareStatement(insertSQL);
		
		preparedStatement.setString(1, registedPerson.getTitle());
		preparedStatement.setString(2, registedPerson.getFirstName());
		preparedStatement.setString(3, registedPerson.getLastName());
		preparedStatement.setString(4, registedPerson.getBirthDate());
		preparedStatement.setString(5, registedPerson.getMobile());
		preparedStatement.setString(6, registedPerson.getEmail());
		preparedStatement.setString(7, registedPerson.gettShirtSize());
		preparedStatement.setString(8, registedPerson.gettShirtPickUpPoint());
		preparedStatement.setString(9, registedPerson.getPayInSlipPath());
		preparedStatement.setBoolean(10, registedPerson.isPaid());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	
	}

	public List<RegistedPerson> queryRegistedPersonByName(String queryEmail) throws SQLException {
		PreparedStatement queryResultStatement = databaseConnection.prepareStatement(selectSQL);
		queryResultStatement.setString(1,queryEmail);
		ResultSet queryResult = queryResultStatement.executeQuery();
		
		List<RegistedPerson> results = new ArrayList<RegistedPerson>();
		RegistedPerson registedPerson = null;

		while(queryResult.next()){
			registedPerson = new RegistedPerson();
						
			try {
				registedPerson.setTitle(queryResult.getString("title"));
				registedPerson.setFirstName(queryResult.getString("firstName"));
				registedPerson.setLastName(queryResult.getString("lastName"));
				registedPerson.setBirthDate(queryResult.getString("birthDate"));
				registedPerson.setMobile(queryResult.getString("mobile"));
				registedPerson.setEmail(queryResult.getString("email"));
				registedPerson.settShirtSize(queryResult.getString("tShirtSize"));
				registedPerson.settShirtPickUpPoint(queryResult.getString("tShirtPickUpPoint"));
				registedPerson.setPayInSlipPath(queryResult.getString("payInSlipPath"));
				registedPerson.setPaid(queryResult.getBoolean("paid"));
				
				results.add(registedPerson);
				
			} catch (InvalidDataException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		return results;
	}

}
