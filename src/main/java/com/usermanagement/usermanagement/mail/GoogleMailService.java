package com.usermanagement.usermanagement.mail;

import org.springframework.beans.factory.annotation.Value;

public class GoogleMailService implements MailService {

    @Value("${mail-provider.google.url}")
    private String url;
    @Value("${mail-provider.google.url-port}")
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
        System.out.println("Sent by google: " + url + ":" + port + " to " + to + " with body " + body);
    // TODO: Send email implementation
    }
}
