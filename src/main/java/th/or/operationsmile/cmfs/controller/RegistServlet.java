package th.or.operationsmile.cmfs.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

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
		handleUploadedFile(request, response);
		handleDatabase();

		response.getWriter().append("Served at: ")
				.append(request.getContextPath() + " " + request.getParameter("address"));
	}
	
	private void handleDatabase(){
		try{
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)
			  envCtx.lookup("jdbc/cmfsDB");

			Connection conn = ds.getConnection();
			System.out.println("champ db: "+conn);
			Statement statement = conn.createStatement();
			statement.executeUpdate("INSERT INTO registedPerson (firstName,lastName) VALUES('Passapong','Thaithatgoon');");
			
			statement.close();
			conn.close();
		}
		catch(NamingException e){
			System.out.println(e);
		}
		catch(SQLException e){
			System.out.println(e);
		}
			
	
	}

	private void handleUploadedFile(HttpServletRequest request, HttpServletResponse response) {
		String filePath = "/root/";
		DiskFileItemFactory diskFileItemFactory = null;
		int maxFileSize = 50 * 1024;
		int maxMemSize = 4 * 1024;
		File file;
		ServletFileUpload uploadedFile =null;

		diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setSizeThreshold(maxMemSize);
		diskFileItemFactory.setRepository(new File("/tmp"));
	      
		uploadedFile = new ServletFileUpload(diskFileItemFactory);
		uploadedFile.setSizeMax( maxFileSize );

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
					System.out.println("champ: filePath: "+file.getAbsolutePath());
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
