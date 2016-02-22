package th.or.operationsmile.cmfs.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import th.or.operationsmile.cmfs.exception.ErrorFieldException;
import th.or.operationsmile.cmfs.exception.InvalidDataException;
import th.or.operationsmile.cmfs.model.InputValidation;
import th.or.operationsmile.cmfs.model.RegistedPerson;

public class DataAccessObject {
	
	private Connection databaseConnection = null;
	private static final String insertSQL = "INSERT INTO registedPerson ("
			+ "title,firstName,lastName,birthDate,mobile,email,address,tShirtSize,tShirtPickUpPoint,payInSlipPath,paid) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?);";
	
	public DataAccessObject(Connection databaseConnection){
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
		preparedStatement.setString(7, registedPerson.getAddress());
		preparedStatement.setString(8, registedPerson.gettShirtSize());
		preparedStatement.setString(9, registedPerson.gettShirtPickUpPoint());
		preparedStatement.setString(10, registedPerson.getPayInSlipPath());
		preparedStatement.setBoolean(11, registedPerson.isPaid());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	
	}

}
