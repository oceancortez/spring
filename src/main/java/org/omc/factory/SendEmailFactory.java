package org.omc.factory;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.omc.model.Email;
import org.springframework.stereotype.Component;

@Component
public class SendEmailFactory {

	final String USER_YAHOO = "ocean.cortez@yahoo.com.br";
	final String USER_GMAIL = "theoceaan@gmail.com";
	final String PASS = "xxx";
	
	public SimpleEmail sendEmail(Email email){
		if(email != null){
			SimpleEmail se = new SimpleEmail();			
			se.setDebug(true); 
			se.setHostName( "smtp.mail.yahoo.com" );
			se.setCharset("UTF-8");
			se.setSSL(true);
			se.setSslSmtpPort("465");			
			se.setAuthenticator( new DefaultAuthenticator( USER_YAHOO ,  PASS ) );
			try {
				se.setFrom(USER_YAHOO);
				se.addTo(USER_GMAIL);
				se.setSubject(email.getSubject());
			    long hora = System.currentTimeMillis();
			    Date data = new Date(hora);
			    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			    se.setMsg(email.getMsg() + "Hora do envio: " + sdf.format(data));		    		     
			    se.send();
			     
			} catch (EmailException e) {
			    e.printStackTrace();
			} 
		}
		return null;
	}
	
	
}
