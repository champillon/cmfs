package th.or.operationsmile.cmfs.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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
        String errorMessage = "";
        Map<String, List<String>> requestValueMap = null;

        try {
            requestValueMap = handleRequestWithUploadedFile(request, response);
            List<RegistedPerson> registedPersons = mapRequestParameter(requestValueMap);
            for (RegistedPerson registedPerson : registedPersons) {
                saveToDatabase(registedPerson);
                EmailSend.sendRegistrationEmail(registedPerson.getEmail(), registedPerson);
            }
            processCompleted = true;

        } catch (InvalidDataException e) {
            e.printStackTrace();
            errorMessage = e.getMessage();

        } catch (AddressException e) {
            e.printStackTrace();
            errorMessage = e.getMessage();

        } catch (MessagingException e) {
            e.printStackTrace();
            errorMessage = e.getMessage();

        } catch (NamingException e) {
            e.printStackTrace();
            errorMessage = e.getMessage();

        } catch (SQLException e) {
            e.printStackTrace();
            errorMessage = e.getMessage();

        } catch (ErrorFieldException e) {
            e.printStackTrace();
            errorMessage = e.getMessage();
        }

        if (processCompleted) {
            response.setContentType("text/plain; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().append(
                    "ขอบคุณที่สมัครเข้าร่วมในงานวิ่งการกุศล Colour Miles for Smiles 2016, Neon Edition ครั้งนี้ ทางมูลนิธิสร้างรอยยิ้มจะดำเนินการตรวจสอบเอกสาร และตอบรับกลับไปทางอีเมลพร้อมหมายเลขผู้วิ่งภายใน 2 วันทำการ"
                    + "\n"
                    + "Thank you for applying to enter Colour Miles for Smiles 2016: Neon Edition. Please allow us two working days to review your application and email your confirmation and running number.");
        } else {
            response.setContentType("text/plain; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().append("[ERROR] เกิดข้อผิดพลาด กรุณาลองทำรายการใหม่อีกครั้ง รายละเอียด Error:" + errorMessage);
        }

    }

    private List<RegistedPerson> mapRequestParameter(Map<String, List<String>> requestValueMap)
            throws InvalidDataException, UnsupportedEncodingException {
        List<RegistedPerson> registedPersons = new ArrayList<RegistedPerson>();
        
        
        
        System.out.println(requestValueMap+"xxxxx");
        
        
        
        for (int i = 0; i < requestValueMap.get("title").size(); i++) {
            RegistedPerson result = new RegistedPerson();
            String eMail = requestValueMap.get("email").get(i);
            String confirmedEmail = requestValueMap.get("confirmEmail").get(i);

            result.setTitle(requestValueMap.get("title").get(i));
            result.setFirstName(requestValueMap.get("firstName").get(i));
            result.setLastName(requestValueMap.get("lastName").get(i));
            result.setFirstNameEn(requestValueMap.get("firstNameEn").get(i));
            result.setLastNameEn(requestValueMap.get("lastNameEn").get(i));
            result.setBirthDate(requestValueMap.get("birthDate").get(i) + "-" + requestValueMap.get("birthMonth").get(i));
            result.setMobile(requestValueMap.get("mobile").get(i));
            result.settShirtSize(requestValueMap.get("tShirtSize").get(i));
            result.settShirtPickUpPoint(requestValueMap.get("tShirtPickUpPoint").get(i));
            result.setPayInSlipPath(requestValueMap.get("payInSlipPath").get(0));

            if (eMail.equals(confirmedEmail)) {
                result.setEmail(eMail);
            } else {
                throw new InvalidDataException("email and confirmed email are not the same.");
            }
            registedPersons.add(result);
        }

        return registedPersons;
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

    private Map<String, List<String>> handleRequestWithUploadedFile(HttpServletRequest request,
            HttpServletResponse response) {
        String filePath = "/var/www/html/uploaded/";
        DiskFileItemFactory diskFileItemFactory = null;
        int maxFileSize = 50 * 1024 * 1024;
        int maxMemSize = 4 * 1024;
        File file;
        ServletFileUpload uploadedFile = null;
        Map<String, List<String>> result = new HashMap<String, List<String>>();

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
                    String fileName = new Date().getTime() + "." + contentType.substring(6, contentType.length());

                    System.out.println("fileName: " + fileName);
                    file = new File(filePath + fileName);
                    fileItem.write(file);

                    if (result.get("payInSlipPath") == null) {
                        result.put("payInSlipPath", Arrays.asList(fileName));
                    }
                } else {
                    String fieldName = fieldNameRadioType(fileItem.getFieldName());
                    String fieldValue = fileItem.getString("UTF-8");
                    System.out.println("fieldName: " + fieldName);
                    System.out.println("fieldValue: " + fieldValue);
                    if (result.get(fieldName) == null) {
                        List<String> values = new ArrayList<String>();
                        values.add(fieldValue);
                        result.put(fieldName, values);
                    } else {
                        result.get(fieldName).add(fieldValue);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;

    }

    private String fieldNameRadioType(String field) {
        if (field != null && field.contains("title")) {
            return "title";
        }
        if (field != null && field.contains("tShirtSize")) {
            return "tShirtSize";
        }
        if (field != null && field.contains("tShirtPickUpPoint")) {
            return "tShirtPickUpPoint";
        }
        return field;
    }

}
