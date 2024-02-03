package com.usermanagement.usermanagement.mail;

import org.springframework.beans.factory.annotation.Value;

public class GoogleMailService implements MailService {

    @Value("${mail-provider.googlemail.url}")
    private String url;
    @Value("${mail-provider.googlemail.port}")
    private String port;

    public GoogleMailService() {
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void sendMail(String to, String body) {
        System.out.println("Sent by google");
    // TODO: Send email implementation
    }
}
