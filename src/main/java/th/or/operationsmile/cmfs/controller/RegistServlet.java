package th.or.operationsmile.cmfs.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import th.or.operationsmile.cmfs.exception.ErrorFieldException;
import th.or.operationsmile.cmfs.exception.InvalidDataException;
import th.or.operationsmile.cmfs.io.DataAccess;
import th.or.operationsmile.cmfs.io.EmailSend;
import th.or.operationsmile.cmfs.model.RegistedPerson;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean processCompleted = false;
		// handleUploadedFile(request, response);
		try {
			RegistedPerson registedPerson = mapRequestParameter(request);
			EmailSend.generateAndSendEmail(registedPerson.getEmail(), registedPerson);
			saveToDatabase(registedPerson);
			processCompleted = true;

		} catch (InvalidDataException e) {
			e.printStackTrace();
			
		} catch (AddressException e) {
			e.printStackTrace();

		} catch (MessagingException e) {
			e.printStackTrace();

		} catch (NamingException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ErrorFieldException e) {
			e.printStackTrace();
		}

		if(processCompleted){
			response.setContentType("text/plain; charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append("ขอบคุณที่สมัครเข้าร่วมในงานวิ่งการกุศล Colour Miles for Smiles 2016, Neon Edition ครั้งนี้ ทางมูลนิธิสร้างรอยยิ้มจะดำเนินการตรวจสอบเอกสาร และตอบรับกลับไปทางอีเมลพร้อมหมายเลขผู้วิ่งภายใน 2 วันทำการ");
		}
		else{
			response.setContentType("text/plain; charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append("เกิดข้อผิดพลาด กรูณาลองทำรายการใหม่อีกครั้ง");
		}
		
	}

	private RegistedPerson mapRequestParameter(HttpServletRequest request) throws InvalidDataException, UnsupportedEncodingException {
		RegistedPerson result = new RegistedPerson();
		
		request.setCharacterEncoding("UTF-8");

		result.setTitle(request.getParameter("title"));
		result.setFirstName(request.getParameter("firstName"));
		result.setLastName(request.getParameter("lastName"));
		result.setBirthDate(request.getParameter("birthDate")+"-"+request.getParameter("birthMonth"));
		result.setMobile(request.getParameter("mobile"));
		result.setEmail(request.getParameter("email"));
		result.settShirtSize(request.getParameter("tShirtSize"));
		result.settShirtPickUpPoint(request.getParameter("tShirtPickUpPoint"));
		result.setPayInSlipPath("/test/path/for/payInSlip");
		
		

		return result;
	}

	private void saveToDatabase(RegistedPerson registedPerson) throws NamingException, SQLException, ErrorFieldException, InvalidDataException {
		Context initialContext = new InitialContext();
		Context environmentContext = (Context) initialContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) environmentContext.lookup("jdbc/cmfsDB");

		Connection databaseConnection = dataSource.getConnection();
		DataAccess dataAccess = new DataAccess(databaseConnection);
		dataAccess.addRegistedPerson(registedPerson);

		databaseConnection.close();
		

	}

	private void handleUploadedFile(HttpServletRequest request, HttpServletResponse response) {
		String filePath = "/root/";
		DiskFileItemFactory diskFileItemFactory = null;
		int maxFileSize = 50 * 1024;
		int maxMemSize = 4 * 1024;
		File file;
		ServletFileUpload uploadedFile = null;

		diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setSizeThreshold(maxMemSize);
		diskFileItemFactory.setRepository(new File("/tmp"));

		uploadedFile = new ServletFileUpload(diskFileItemFactory);
		uploadedFile.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.
			List fileItems = uploadedFile.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
					} else {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
					}
					fi.write(file);
					System.out.println("champ: filePath: " + file.getAbsolutePath());
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
