package com.banking.auth.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;


@Service
public class MailService {
	
	static final String FROM="12345600iiii@gmail.com";
	static final String FROMNAME="ishwari";
	static final String SMTP_USERNAME="12345600iiii@gmail.com";
	static final String SMTP_PASSWORD="@iiii00654321";
	static final String HOST="smtp.gmail.com";
	static final String PORT="587";
	static final String SUBJECT="Banking OTP";
	
	
	
	public boolean senMail(String emailId,int otpValue) {
	try {
		Properties props =System.getProperties();
		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.host",HOST);
		props.put("mail.smtp.port",PORT);
		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.auth","true");
		
		Session session =Session.getDefaultInstance(props);
		
		MimeMessage msg = new MimeMessage(session);
		
		msg.setFrom(new InternetAddress(FROM,FROMNAME));
		msg.setRecipient(Message.RecipientType.TO,new InternetAddress(emailId));
		msg.setSubject(SUBJECT);
		msg.setContent("Please enter otp to verify email:" +otpValue,"text/html");
		
		
		Transport transport = session.getTransport();
		transport.connect(HOST,SMTP_USERNAME,SMTP_PASSWORD);
		transport.sendMessage(msg,msg.getAllRecipients());
		
		
		return true;
	}catch(Exception ex) {
		return false;
	}
		
	}	
		
	}
	
	
	


