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
		generateMailMessage.setSubject("Colour Miles of Smiles: แจ้งสถานะการลงทะเบียน -> รอตรวจสอบข้อมูลการโอน  Colour Miles for Smiles: Application Status -> Application Status Verification");
		String emailBody = "เรียนคุณ "+registedPerson.getFirstNameEn()+" "+registedPerson.getLastNameEn()+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"ขอบคุณที่สมัครเข้าร่วมในงานวิ่งการกุศล Colour Miles for Smiles 2016, Neon Edition ครั้งนี้ "
				+ "ทางมูลนิธิสร้างรอยยิ้มจะดำเนินการตรวจสอบเอกสาร และตอบรับกลับไปทางอีเมลพร้อมหมายเลขผู้วิ่งภายใน 2 วันทำการ"
				+ "\n\n"
				+ "Thank you for applying to enter Colour Miles for Smiles 2016: Neon Edition. "
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
		generateMailMessage.setSubject("Colour Miles of Smiles: แจ้งสถานะการลงทะเบียน -> แจ้งหมายเลขผู้วิ่งของท่าน Colour Miles for Smiles: Application Status -> Runner Number Notification");
		
		String emailBody = "เรียนคุณ "+registedPerson.getFirstNameEn()+" "+registedPerson.getLastNameEn()+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"ทางมูลนิธิสร้างรอยยิ้มได้ดำเนินการตรวจสอบเอกสารเรียบร้อยแล้ว หมายเลขผู้วิ่งของท่านคือ "+registedPerson.getRunnerId();
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"ท่านสามารถมารับเสื้อวิ่ง และสายรัดข้อมือได้หน้างานที่อาคารบันเทิง สวนลุมพินี เวลา 15.30 น. เป็นต้นไป พบกันที่สวนลุมพินี วันเสาร์ที่ 9 เมษายน 2559 นี้ ";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"กำหนดการ";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"15.30 น.\t\tลงทะเบียน";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"17.00 น.\t\tเปิดงาน พิธีมอบเงินบริจาค";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"17.15 น.\t\tการนำวอร์มอัพ";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"17.30 น.\t\tเริ่มวิ่ง";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"19.00 น.\t\tมอบรางวัล และโปรยสี";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"เคล็ดลับเพื่อความสนุก";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"1.ผงสีที่ใช้โปรยในงานเป็นสูตรปราศจากสารพิษ และย่อยสลายได้ แต่ก็ต้องระวังไม่ให้เข้าตา";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"2.การทำความสะอาดสีที่เปื้อนผิวหนัง แนะนำให้เช็ดทำความสะอาดด้วยเบบี้ออยก่อนค่อยล้างด้วยน้ำ";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"3.กรุณาอย่านำสิ่งของมีค่าติดตัวมา มีที่รับฝากของไว้ให้บริการ แต่ทางมูลนิธิฯ จะไม่รับผิดชอบในกรณีสูญหาย";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"4.เนื่องจากที่จอดรถมีจำนวนจำกัด แนะนำให้นั่งรถไฟฟ้าใต้ดิน รถประจำทาง หรือรถสาธารณะมาเพื่อความสะดวก";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"5.กรุณาช่วยกันรักษาความสะอาดของสวนลุมพินี";
		emailBody  = emailBody+"\n";
		
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"Congratulations: Your Colour Miles for Smiles 2016: Neon Edition entry is confirmed! Your running number is "+registedPerson.getRunnerId()+".";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"Please come to collect your running pack at the event visit the event registration at the Entertainment Building, Lumpini Park from 15.30 hrs. See you at Lumpini Park on April 9, 2016.";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"Agenda";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"15.30 hrs.\t\tRegistration";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"17.00 hrs.\t\tOpening & Donation Photo Op";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"17.15 hrs.\t\tWarm up";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"17.30 hrs.\t\tRun Starts";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"19.00 hrs.\t\tPrize & Colour Blow";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"Our tips for a fun event";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"1.The multi-coloured powder used at the finish line is non-toxic and biodegradable however do avoid getting it in your eyes.";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"2.After the event the fastest way to remove the coloured powder from your skin is to apply baby oil before taking your normal bath or shower.";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"3.Please do not bring valuables to the event. A bag minding service will be available as a courtesy but we will not be responsible should your belongings get damaged or go missing.";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"4.Due to limited parking we suggest you take public transport or taxis to and from the event.";
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"5.Please help us keep Lumpini Park as clean as we can for our fellow citizens. Use the bins!";
		emailBody  = emailBody+"\n";
		
		emailBody  = emailBody+"\n";
		emailBody  = emailBody+"แผนที่ (Map) --> http://newsletter.operationsmile.or.th/map.jpg";
		emailBody  = emailBody+"\n";
		
		generateMailMessage.setContent(emailBody, "text/plain; charset=utf-8");

		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "<----- Your GMAIL ID ----->", "<----- Your GMAIL PASSWORD ----->");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}

