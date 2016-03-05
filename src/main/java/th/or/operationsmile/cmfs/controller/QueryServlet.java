package th.or.operationsmile.cmfs.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import th.or.operationsmile.cmfs.exception.ErrorFieldException;
import th.or.operationsmile.cmfs.exception.InvalidDataException;
import th.or.operationsmile.cmfs.io.DataAccess;
import th.or.operationsmile.cmfs.model.RegistedPerson;

public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public QueryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RegistedPerson> registedPeople = null;
		try {
			registedPeople = retrieveFromDatabase();
			request.setAttribute("registedPeople", registedPeople);
			
			System.out.println("debug: "+registedPeople);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ErrorFieldException e) {
			e.printStackTrace();
		} catch (InvalidDataException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher; 
		requestDispatcher = request.getRequestDispatcher("/WEB-INF/query.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private List<RegistedPerson> retrieveFromDatabase() throws NamingException, SQLException, ErrorFieldException, InvalidDataException {
		Context initialContext = new InitialContext();
		Context environmentContext = (Context) initialContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) environmentContext.lookup("jdbc/cmfsDB");
		List<RegistedPerson> results;

		Connection databaseConnection = dataSource.getConnection();
		DataAccess dataAccess = new DataAccess(databaseConnection);
		results = dataAccess.queryRegistedPersonThatNotConfirm();

		databaseConnection.close();
		
		return results;
	}

}
