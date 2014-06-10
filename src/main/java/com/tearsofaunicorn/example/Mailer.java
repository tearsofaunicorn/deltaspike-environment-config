package com.tearsofaunicorn.example;

/**
 * Send mail out
 */
public interface Mailer {

    /**
     * Return a greeting message
     *
     * @return the status of the sent mail
     */
    void sendMail(Mail mail);

}
