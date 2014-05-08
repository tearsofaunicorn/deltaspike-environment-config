package com.tearsofaunicorn.example;

import org.apache.deltaspike.core.api.exclude.Exclude;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;

/**
 * Implementation of a Greeter which prints a pleasant message
 */
@Exclude(exceptIfProjectStage = ProjectStage.UnitTest.class)
public class PleasantGreeter implements Greeter {

    @Override
    public String greet() {
        return "Good morning";
    }

}
