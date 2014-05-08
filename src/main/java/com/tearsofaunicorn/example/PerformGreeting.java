package com.tearsofaunicorn.example;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.api.provider.BeanProvider;

public class PerformGreeting {

    public static void main(String[] args) throws Exception {
        System.out.println("System environment variable 'environment' == " + System.getenv("environment"));

        System.out.println("Starting CDI container");
        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();
        cdiContainer.getContextControl().startContexts();

        ProjectStage projectStage = BeanProvider.getContextualReference(ProjectStage.class, false);
        System.out.println("Configured ProjectStage == " + projectStage);

        Greeter greeter = BeanProvider.getContextualReference(Greeter.class, false);
        System.out.println("Injected Greeter class == " + greeter.getClass().getSimpleName());
        System.out.println("Greeting => " + greeter.greet());

        cdiContainer.shutdown();
    }

}
