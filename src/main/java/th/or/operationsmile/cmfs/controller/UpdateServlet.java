package th.or.operationsmile.cmfs.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./Query");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int runningId = Integer.parseInt(request.getParameter("runningId"));
		boolean processCompleted = false;
		
		try {
			confirmPaySlip(runningId);
			
			processCompleted = true;
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ErrorFieldException e) {
			e.printStackTrace();
		} catch (InvalidDataException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("./Query");
		
	}
	
	private void confirmPaySlip(int runningId)
			throws NamingException, SQLException, ErrorFieldException, InvalidDataException {
		Context initialContext = new InitialContext();
		Context environmentContext = (Context) initialContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) environmentContext.lookup("jdbc/cmfsDB");

		Connection databaseConnection = dataSource.getConnection();
		DataAccess dataAccess = new DataAccess(databaseConnection);
		RegistedPerson registedPersonThatConfirmPaySlip = dataAccess.queryRegistedPersonByRunningId(runningId);
		dataAccess.confirmedPaySlipAndGenerateRunningKey(registedPersonThatConfirmPaySlip);
				
		databaseConnection.close();

	}

}
