package com.sveticov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

@SpringBootApplication
public class GmailSpringBootApplication implements CommandLineRunner{
	@Autowired
	private JavaMailSender sender;

	public static void main(String[] args) {
		SpringApplication.run(GmailSpringBootApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//		MimeMessage message =sender.createMimeMessage();
//		MimeMessageHelper helper=new MimeMessageHelper(message,true);
//
//		helper.setTo("vgvanrt@mail.ru");//sveticovdanil@gmail.com
//		helper.setText("Test message");
//		helper.setSubject("Hi");
//
//		ClassPathResource file=new ClassPathResource("716742_original.jpg");
//		helper.addAttachment("716742_original.jpg",file);
//		sender.send(message);

		sendMail("maxzubr@i.ua");
		sendMail("sveticovdanil@gmail.com");
	}


	public  void sendMail(String mailName) throws Exception{
		MimeMessage message =sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message,true);

		helper.setTo(mailName);//
		helper.setText("<html><body>Here is a cat picture! <img src='cid:id101'/><body></html>",true);
		helper.setSubject("Hi");

		ClassPathResource file=new ClassPathResource("716742_original.jpg");
		helper.addAttachment("id101",file);
		sender.send(message);
	}
}































