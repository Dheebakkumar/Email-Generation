package com.EmailGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmailGenerator.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService service;
	
	@GetMapping("/send")
	public String sendMail() {
		
		return service.sendEmail("deepak.cbe04@gmail.com", "Diksha Event Invitation", "Welcome to Diksha Tech and We greatful to invite that Event on that Date..  .");
	}
	
	@GetMapping("/send/attachment")
	public String sendMailWithAttachment() throws MessagingException {
		
		return service.sendMailWithAttachment("deepak.cbe04@gmail.com", "Diksha Event Invitation", "Welcome to Diksha Tech and We greatful to invite that Event on that Date..." ,"C:\\Users\\Diksha\\Downloads\\pay.aw.pdf" );
	}
	
}
