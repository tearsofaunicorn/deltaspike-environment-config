package com.tearsofaunicorn.example;

import org.apache.deltaspike.core.api.exclude.Exclude;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;

/**
 * Implementation of a Mailer which just swallows the mail
 */
@Exclude(exceptIfProjectStage = ProjectStage.UnitTest.class)
public class NullMailer implements Mailer {

    @Override
    public void sendMail(Mail mail) {
        System.out.println("Discarding mail to /dev/null");
    }

}
