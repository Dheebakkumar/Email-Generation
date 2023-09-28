package com.EmailGenerator.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public String sendEmail(String toEmail, String subject, String body) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("dheebakkumar.v@dikshatech.com");
		message.setTo(toEmail);
		//message.setCc(addMail);
		message.setSubject(subject);
		message.setText(body);
		
		mailSender.send(message);
		
		System.out.println("Email Sent Successfully... ");
		return "Email Sent Successfully...";
	}
	
	
	public String sendMailWithAttachment(String toEmail, String subject, String body, String attachment) throws MessagingException {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
		
		mimeMessageHelper.setFrom("dheebakkumar.v@dikshatech.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(body);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		mailSender.send(mimeMessage);
		
		System.out.println("EMail sent with Attachment");
		
		return "EMail sent with Attachment";
		
	}
}
