package th.or.operationsmile.cmfs.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
		Map<String, String> requestValueMap = null;

		try {
			requestValueMap = handleRequestWithUploadedFile(request, response);
			RegistedPerson registedPerson = mapRequestParameter(requestValueMap);
			saveToDatabase(registedPerson);
			EmailSend.sendRegistrationEmail(registedPerson.getEmail(), registedPerson);
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

		if (processCompleted) {
			response.setContentType("text/plain; charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(
					"ขอบคุณที่สมัครเข้าร่วมในงานวิ่งการกุศล Colour Miles for Smiles 2016, Neon Edition ครั้งนี้ ทางมูลนิธิสร้างรอยยิ้มจะดำเนินการตรวจสอบเอกสาร และตอบรับกลับไปทางอีเมลพร้อมหมายเลขผู้วิ่งภายใน 2 วันทำการ");
		} else {
			response.setContentType("text/plain; charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append("เกิดข้อผิดพลาด กรุณาลองทำรายการใหม่อีกครั้ง");
		}

	}

	private RegistedPerson mapRequestParameter(Map<String, String> requestValueMap)
			throws InvalidDataException, UnsupportedEncodingException {
		RegistedPerson result = new RegistedPerson();

		result.setTitle(requestValueMap.get("title"));
		result.setFirstName(requestValueMap.get("firstName"));
		result.setLastName(requestValueMap.get("lastName"));
                result.setFirstNameEn(requestValueMap.get("firstNameEn"));
		result.setLastNameEn(requestValueMap.get("lastNameEn"));
		result.setBirthDate(requestValueMap.get("birthDate") + "-" + requestValueMap.get("birthMonth"));
		result.setMobile(requestValueMap.get("mobile"));
		result.setEmail(requestValueMap.get("email"));
		result.settShirtSize(requestValueMap.get("tShirtSize"));
		result.settShirtPickUpPoint(requestValueMap.get("tShirtPickUpPoint"));
		result.setPayInSlipPath(requestValueMap.get("payInSlipPath"));

		return result;
	}

	private void saveToDatabase(RegistedPerson registedPerson)
			throws NamingException, SQLException, ErrorFieldException, InvalidDataException {
		Context initialContext = new InitialContext();
		Context environmentContext = (Context) initialContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) environmentContext.lookup("jdbc/cmfsDB");

		Connection databaseConnection = dataSource.getConnection();
		DataAccess dataAccess = new DataAccess(databaseConnection);
		dataAccess.addRegistedPerson(registedPerson);

		databaseConnection.close();

	}

	private Map<String, String> handleRequestWithUploadedFile(HttpServletRequest request,
			HttpServletResponse response) {
		String filePath = "/var/www/html/uploaded/";
		DiskFileItemFactory diskFileItemFactory = null;
		int maxFileSize = 50 * 1024 * 1024;
		int maxMemSize = 4 * 1024;
		File file;
		ServletFileUpload uploadedFile = null;
		Map<String, String> result = new HashMap<String, String>();

		diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setSizeThreshold(maxMemSize);
		diskFileItemFactory.setRepository(new File("/tmp"));

		uploadedFile = new ServletFileUpload(diskFileItemFactory);
		uploadedFile.setSizeMax(maxFileSize);

		try {
			List fileItems = uploadedFile.parseRequest(request);

			Iterator iterator = fileItems.iterator();
			while (iterator.hasNext()) {
				FileItem fileItem = (FileItem) iterator.next();
				if (!fileItem.isFormField()) {

					String fieldName = fileItem.getFieldName();
					String contentType = fileItem.getContentType();
					String fileName = new Date().getTime() + "."+contentType.substring(6,contentType.length());
					
					System.out.println("fileName: "+fileName);
					file = new File(filePath + fileName);
					fileItem.write(file);
					
					result.put("payInSlipPath",fileName);
				} else {
					String fieldName = fileItem.getFieldName();
					String fieldValue = fileItem.getString("UTF-8");
					System.out.println("fieldName: " + fieldName);
					System.out.println("fieldValue: " + fieldValue);
					result.put(fieldName, fieldValue);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;

	}

}
