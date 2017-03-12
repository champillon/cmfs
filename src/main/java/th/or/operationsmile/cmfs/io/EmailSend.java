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
		generateMailMessage.setSubject("Smile Carnival: Application Status -> Application Status Verification");
		String emailBody = "เรียนคุณ "+registedPerson.getFirstNameEn()+" "+registedPerson.getLastNameEn()+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"ขอบคุณที่สมัครเข้าร่วมสนุกในงานการกุศล Smile Carnival ในครั้งนี้"
				+ "ทางมูลนิธิสร้างรอยยิ้มจะดำเนินการตรวจสอบเอกสาร และตอบรับกลับไปทางอีเมลพร้อมหมายเลขผู้วิ่งภายใน 2 วันทำการ"
				+ "\n\n"
				+ "Thank you for applying to enter Smile Carnival. "
				+ "Please allow us two working days to review your application and email your confirmation and running number.";
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
		generateMailMessage.setSubject("Smile Carnival: Application Status -> Runner Number Notification");
		
		String emailBody = "เรียนคุณ "+registedPerson.getFirstNameEn()+" "+registedPerson.getLastNameEn()+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"ทางมูลนิธิสร้างรอยยิ้มได้ดำเนินการตรวจสอบเอกสารเรียบร้อยแล้ว หมายเลขการสมัครของท่านคือ "+registedPerson.getRunnerId();
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"ท่านสามารถมารับบัตรเข้างานได้ที่หน้างาน ณ ลานอเนกประสงค์ สนามกีฬาแห่งชาติ (ศุภชลาศัย) เวลา 17.00 น. เป็นต้นไป";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"แล้วพบกันที่สนามกีฬาแห่งชาติ (ศุภชลาศัย) วันเสาร์ที่ 1 เมษายน 2560 นี้นะคะ";
		emailBody  = emailBody+"กำหนดการ";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"17.00 น.\t\tลงทะเบียน";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"18.00 น.\t\tเปิดงานและเริ่มงาน";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"21.00 น.\t\tงานจบ";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"เคล็ดลับเพื่อความสนุก";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"1. เนื่องจากที่จอดรถมีจำนวนจำกัด แนะนำให้นั่งรถไฟฟ้า (สถานีสนามกีฬาแห่งชาติ ทางออกหมายเลข 2) รถประจำทาง หรือรถสาธารณะมาเพื่อความสะดวก";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"2. กรุณาช่วยกันรักษาความสะอาดของบริเวณงานด้วยนะคะ";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"Congratulations: Your Smile Carnival entry is confirmed! Your ticker number is "+registedPerson.getRunnerId()+".";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"Please show your confirmation email to collect your ticket at the entrance at Outdoor Sport Courtyard, the National Stadium of Thailand from 17.00 hrs on ward.";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"See you at the National Stadium of Thailand on April 1, 2017.";
		emailBody  = emailBody+"Agenda";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"17.00 hrs.\t\tRegistration";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"18.00 hrs.\t\tOpening";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"19:00 hrs.\t\tClosing";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"Our tips for a fun event";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"1. Due to limited parking we suggest you take public transport (BTS, National Stadium station exit no.2) or taxis to and from the event.";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"2. Please help us keep the venue as clean as we can for our fellow citizens.";
		emailBody  = emailBody+"\n";
		
		generateMailMessage.setContent(emailBody, "text/plain; charset=utf-8");

		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "<----- Your GMAIL ID ----->", "<----- Your GMAIL PASSWORD ----->");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}

