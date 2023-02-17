package com.email.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class service {
	public boolean sendMail(String message, String to, String subject) {
		Boolean b = false;
		// TODO Auto-generated method stub
		 String from="roysukalyan.97@gmail.com";
		
		String host = "smtp.gmail.com";
        Properties properties = new Properties();
        //setup host port etc
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", 465);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
        Session session=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("roysukalyan.97@gmail.com","hahucghtfasmywiu");
			}
        	
        });
        session.setDebug(true);
        
       MimeMessage message1 =  new MimeMessage(session);
       
       try {
    	   message1.setFrom(from);
    	   message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    	   message1.setSubject(subject);
    	   message1.setText(message);
    	   
    	   Transport.send(message1);
    	   b = true;
       }
       catch(Exception e){
    	   e.printStackTrace();
       }
	return b;
       
	}
}
