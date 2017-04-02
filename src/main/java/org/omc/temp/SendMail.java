package org.omc.temp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class SendMail {

	public static void main(String[] args) {	
		
		final String USER_GOOGLE = "ocoortez@gmail.com";
		final String USER_YAHOO = "ocean.cortez@yahoo.com.br";
		final String PASS = "xxx";
		
		
		SimpleEmail email = new SimpleEmail();
		email.setDebug(true); 
		email.setHostName( "smtp.mail.yahoo.com" );
		email.setCharset("UTF-8");
		email.setSSL(true);
		email.setSslSmtpPort("465");
		email.setAuthenticator( new DefaultAuthenticator( USER_YAHOO ,  PASS ) );
		try {
		    email.setFrom(USER_YAHOO);
		    email.addTo("theoceaan@gmail.com");
		    email.setSubject("Assunto do E-mail");
		    long hora = System.currentTimeMillis();
		    Date data = new Date(hora);
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		    email.setMsg( "Texto sem formatação" + "Hora do envio: " + sdf.format(data));		    		     
		    email.send();
		     
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
		
		
//		
//		Properties props = new Properties();
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.socketFactory.port", "465");
//		props.put("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.port", "465");		
//		
//		Session session = Session.getInstance(props,
//				  new javax.mail.Authenticator() {
//					protected PasswordAuthentication getPasswordAuthentication() {
//						return new PasswordAuthentication(username, password);
//					}
//				  });
//		
//		
//		try {
//
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("oxi@gmail.com"));
//			message.setRecipients(Message.RecipientType.TO,
//				InternetAddress.parse("theoceaan@gmail.com"));
//			message.setSubject("Testing Subject");
//			message.setText("Dear Mail Crawler,"
//				+ "\n\n No spam to my email, please!");
//
//			Transport.send(message);
//
//			System.out.println("Done");
//
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
		
		
		
		
	}
		

	}


