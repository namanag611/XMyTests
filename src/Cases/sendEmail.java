package Cases;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.testng.annotations.Test;

public class sendEmail {

	/*
	 * JAF Jar:
	 * http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-
	 * archive-downloads-java-plat-419418.html#jaf-1.1.1-fcs-oth-JPR
	 * 
	 * JavaMail Jar:
	 * http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-
	 * archive-downloads-eeplat-419426.html#javamail-1.4.5-oth-JPR
	 */

	@Test
	public void send2() {
		final String username = "test_email@gmail.com";// Email address
		final String password = "test_password";// Password
		String htmlmessage = "<p>Hello Sir,</p><p>Greetings!</p><p>Please find below details of my work</p><ul><li>34488 : Test 1</li><li>34344 : Test 2</li></ul><p>Thanks</p>";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("test_email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("test_email_to@gmail.com"));
			message.setSubject("Testing Subject2");
			/*
			 * Simple message as Text format
			 */
			// message.setText("Dear Mail Crawler," + "\n\n No spam to my email,
			// please!");
			/*
			 * HTML format message
			 */
			message.setContent(htmlmessage, "text/html");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
