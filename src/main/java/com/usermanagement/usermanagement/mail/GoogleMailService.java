package com.usermanagement.usermanagement.mail;

public class GoogleMailService {

    private String url;
    private String port;

    public GoogleMailService() {

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void sentEmail(String to, String body) {
        // TODO: Send email implementation
    }
}
