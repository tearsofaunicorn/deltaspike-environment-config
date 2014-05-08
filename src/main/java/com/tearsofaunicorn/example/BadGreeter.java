package com.tearsofaunicorn.example;

import org.apache.deltaspike.core.api.exclude.Exclude;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;

/**
 * Implementation of a Greeter which is not very friendly
 */
@Exclude(ifProjectStage = ProjectStage.UnitTest.class)
public class BadGreeter implements Greeter {

    @Override
    public String greet() {
        return "Go away!";
    }

}
