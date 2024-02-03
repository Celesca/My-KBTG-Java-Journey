package com.usermanagement.usermanagement.order;

import com.usermanagement.usermanagement.mail.GoogleMailService;
import com.usermanagement.usermanagement.mail.MailService;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private MailService mailService;

    public OrderService(MailService mailService) {
        this.mailService = mailService;
    }

    public void createOrder() {
        mailService.sendMail("user@gmail.com", "Order created");
    }
}