package com.usermanagement.usermanagement.mail;

public class OutlookMailService implements MailService {

    private String url;
    private String port;

    public OutlookMailService(){

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void sendMail(String to, String body) {
        System.out.println("Sent by outlook");

    }

}
