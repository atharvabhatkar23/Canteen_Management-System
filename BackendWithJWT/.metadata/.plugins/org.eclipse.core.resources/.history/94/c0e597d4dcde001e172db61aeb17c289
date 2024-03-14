package com.app.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Student;


@Service
@Transactional
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	
	@Override
	public void sendMail(Student student, String password) {
		
		try
		{
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper helper = new MimeMessageHelper(message);
//			helper.setFrom("abhichopade1045@gmail.com");
//			helper.setTo(student.getEmail());
//			String text = "Hello "+student.getName()+" Welcome To Campus Canteen";
//			helper.setText(text);
//			mailSender.send(message);
			
			
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom("abhichopade1045@gmail.com");
			simpleMailMessage.setSubject("Campus Canteen Management System");
			simpleMailMessage.setTo(student.getEmail());
			String text = "Hello "+student.getName()+" Welcome To Campus Canteen\n Your Password is "+"'"+password+"'";
			simpleMailMessage.setText(text);
			mailSender.send(simpleMailMessage);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
