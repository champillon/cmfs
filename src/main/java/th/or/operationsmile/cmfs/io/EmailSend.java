package th.or.operationsmile.cmfs.io;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import th.or.operationsmile.cmfs.model.RegistedPerson;

public class EmailSend {
	private static Properties mailServerProperties;
	private static Session getMailSession;
	private static MimeMessage generateMailMessage;
	
	public static void main(String args[]) throws AddressException, MessagingException {
		generateAndSendEmail("passapong.t@gmail.com",null);
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
	
	
	public static void generateAndSendEmail(String mailTo,RegistedPerson registedPerson) throws AddressException, MessagingException {
		 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
//		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		getMailSession = Session.getInstance(mailServerProperties, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("operationsmile.th@gmail.com", "mysterior");
		    }
		});
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
//		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("passapong.opsmile@gmail.com"));
		generateMailMessage.setFrom(new InternetAddress("operationsmile.th@gmail.com"));
		generateMailMessage.setSubject("Colour Miles of Smiles: แจ้งสถานะการลงทะเบียน -> รอตรวจสอบข้อมูลการโอน");
		String emailBody  = "ขอบคุณที่สมัครเข้าร่วมในงานวิ่งการกุศล Colour Miles for Smiles 2016, Neon Edition ครั้งนี้ ทางมูลนิธิสร้างรอยยิ้มจะดำเนินการตรวจสอบเอกสาร และตอบรับกลับไปทางอีเมลพร้อมหมายเลขผู้วิ่งภายใน 2 วันทำการ";
		generateMailMessage.setContent(emailBody, "text/plain; charset=utf-8");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "<----- Your GMAIL ID ----->", "<----- Your GMAIL PASSWORD ----->");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}

