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
		sendRegistrationEmail("passapong.t@gmail.com",null);
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
	
	
	public static void sendRegistrationEmail(String mailTo,RegistedPerson registedPerson) throws AddressException, MessagingException {
		 
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
 
		getMailSession = Session.getInstance(mailServerProperties, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("operationsmile.th@gmail.com", "opsmile123");
		    }
		});
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("narumon.m@operationsmile.org"));
		generateMailMessage.setFrom(new InternetAddress("operationsmile.th@gmail.com"));
		generateMailMessage.setSubject("[ทดสอบ] Colour Miles of Smiles: แจ้งสถานะการลงทะเบียน -> รอตรวจสอบข้อมูลการโอน");
		String emailBody = "เรียนคุณ "+registedPerson.getFirstNameEn()+" "+registedPerson.getLastNameEn()+"\n";
		emailBody  = emailBody+"ขอบคุณที่สมัครเข้าร่วมในงานวิ่งการกุศล Colour Miles for Smiles 2016, Neon Edition ครั้งนี้ "
				+ "ทางมูลนิธิสร้างรอยยิ้มจะดำเนินการตรวจสอบเอกสาร และตอบรับกลับไปทางอีเมลพร้อมหมายเลขผู้วิ่งภายใน 2 วันทำการ";
		generateMailMessage.setContent(emailBody, "text/plain; charset=utf-8");

		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "<----- Your GMAIL ID ----->", "<----- Your GMAIL PASSWORD ----->");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
	
	public static void sendConfirmationEmail(String mailTo,RegistedPerson registedPerson) throws AddressException, MessagingException {
		 
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
 
		getMailSession = Session.getInstance(mailServerProperties, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("operationsmile.th@gmail.com", "opsmile123");
		    }
		});
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("narumon.m@operationsmile.org"));
		generateMailMessage.setFrom(new InternetAddress("operationsmile.th@gmail.com"));
		generateMailMessage.setSubject("[ทดสอบ] Colour Miles of Smiles: แจ้งสถานะการลงทะเบียน -> แจ้งลำดับการเข้าร่วมกิจกรรม");
		String emailBody = "เรียนคุณ "+registedPerson.getFirstNameEn()+" "+registedPerson.getLastNameEn()+"\n";
		emailBody  = emailBody+"ขอบคุณที่สมัครเข้าร่วมในงานวิ่งการกุศล Colour Miles for Smiles 2016, Neon Edition ครั้งนี้ "
				+ "ทางมูลนิธิสร้างรอยยิ้มขอแจ้งลำดับการเข้าร่วมกิจกรรมของท่านคือ "+registedPerson.getRunnerId();
		generateMailMessage.setContent(emailBody, "text/plain; charset=utf-8");

		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "<----- Your GMAIL ID ----->", "<----- Your GMAIL PASSWORD ----->");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}

