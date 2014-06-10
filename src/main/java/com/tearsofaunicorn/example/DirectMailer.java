package com.tearsofaunicorn.example;

import org.apache.deltaspike.core.api.exclude.Exclude;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;

/**
 * Implementation of a Mailer which directly send the mail out
 */
@Exclude(ifProjectStage = {ProjectStage.UnitTest.class, ProjectStage.Production.class})
public class DirectMailer implements Mailer {

    @Override
    public void sendMail(Mail mail) {
        System.out.println("Sending mail directly out to recipient");
    }
}
