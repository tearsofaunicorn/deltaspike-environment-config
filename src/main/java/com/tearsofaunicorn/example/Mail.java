package com.tearsofaunicorn.example;

/**
 * Represents a piece of Mail to be sent
 */
public class Mail {

    private final String to;
    private final String subject;
    private final String body;

    public Mail(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

}
