package com.tearsofaunicorn.example;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.api.provider.BeanProvider;

public class PerformMailing {

    public static void main(String[] args) throws Exception {

        System.out.println("System environment variable 'environment' == " + System.getenv("environment"));

        System.out.println("Starting CDI container");
        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();
        cdiContainer.getContextControl().startContexts();

        ProjectStage projectStage = BeanProvider.getContextualReference(ProjectStage.class, false);
        System.out.println("Configured ProjectStage == " + projectStage);

        Mailer mailer = BeanProvider.getContextualReference(Mailer.class, false);
        System.out.println("Injected Mailer class == " + mailer.getClass().getSimpleName());

        Mail message = new Mail("foo@example.com", "Test email sending", "Hello, World!");
        mailer.sendMail(message);

        cdiContainer.shutdown();
    }

}
