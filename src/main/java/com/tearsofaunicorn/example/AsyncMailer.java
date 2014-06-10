package com.tearsofaunicorn.example;

import org.apache.deltaspike.core.api.exclude.Exclude;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;

/**
 * Implementation of a Mailer which sends the mail out via an asynchronous queue
 */
@Exclude(exceptIfProjectStage = ProjectStage.Production.class)
public class AsyncMailer implements Mailer {

    @Override
    public void sendMail(Mail mail) {
        System.out.println("Placing mail on queue to be sent out later");
    }
}
