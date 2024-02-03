package com.usermanagement.usermanagement;

import com.usermanagement.usermanagement.mail.GoogleMailService;
import com.usermanagement.usermanagement.mail.MailService;
import com.usermanagement.usermanagement.mail.OutlookMailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class UserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

	@Bean
	public MailService outlookMail() {
		return new OutlookMailService();
	}
	@Bean
	@Primary
	public MailService googleMail() {
		return new GoogleMailService();
	}
}
