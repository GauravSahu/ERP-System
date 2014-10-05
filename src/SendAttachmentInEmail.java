import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendAttachmentInEmail {
   public static void main(String[] args) {
	   String result;
	// Recipient's email ID needs to be mentioned.
	//String to1 =(String) request.getAttribute("email");
	//System.out.println("STRIN email->"+to1);
	// Sender's email ID needs to be mentioned
	String from1 = "gauravsahu27@gmail.com";

	// Assuming you are sending email from localhost
	String host = "smtp.gmail.com";

	String password = "gauravsahu77";
	try{
	// Get system properties object
			Properties props = new Properties();
			  props.put("mail.smtp.user",from1); 
			   props.put("mail.smtp.password", password);
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", "smtp.gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.quitwait", "false");

			java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	// Get the default Session object.
		Session mailSession = Session.getInstance(props,new Authenticator() {
	     protected PasswordAuthentication  getPasswordAuthentication() {
	     return new PasswordAuthentication(
	                 "gauravsahu27@gmail.com", "gauravsahu77");
	             }
	 });


	   // Create a default MimeMessage object.
	   MimeMessage message = new MimeMessage(mailSession);
	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from1));
	   // Set To: header field of the header.
	   message.setRecipient(Message.RecipientType.TO,
	                            new InternetAddress("gauravsahu19@gmail.com"));
	   // Set Subject: header field
	   message.setSubject("Automated email from client information sheet");
	   
	   // Create the message part 
	   BodyPart messageBodyPart = new MimeBodyPart();

	   // Fill the message
	   messageBodyPart.setText("This is auto generated mail from MMvisa client information!");
	   
	   // Create a multipar message
	   Multipart multipart = new MimeMultipart();

	   // Set text message part
	   multipart.addBodyPart(messageBodyPart);

	
	   
	   messageBodyPart = new MimeBodyPart();
	   String flpath = "D:\\PDF_Java4s.pdf";
	   DataSource source1 = new FileDataSource(flpath);
	   messageBodyPart.setDataHandler(new DataHandler(source1));
	   messageBodyPart.setFileName("PDF_Java4s.pdf");
	   multipart.addBodyPart(messageBodyPart);
	  
	   // Send the complete message parts
	   message.setContent(multipart );
	   // Send the actual HTML message, as big as you like
	  // message.setContent("<h1>This is actual message</h1>",
	    //                     "text/html" );
	   // Send message
	   Transport.send(message);
	        result = "Sent message successfully....";
	}catch (MessagingException mex) {
	   mex.printStackTrace();
	   result = "Error: unable to send message....";
	}
	System.out.println(result);
	try{
		 
		File file = new File("D:\\PDF_Java4s.pdf");

		if(file.delete()){
			System.out.println(file.getName() + " is deleted!");
		}else{
			System.out.println("Delete operation is failed.");
		}

	}catch(Exception e){

		e.printStackTrace();

	}
   }
}