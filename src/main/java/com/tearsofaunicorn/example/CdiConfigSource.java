package com.tearsofaunicorn.example;

import java.util.HashMap;
import java.util.Map;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.spi.config.ConfigSource;

/**
 * Implementation of Deltaspike ConfigSource to set the ProjectStage based off an "env" environment variable
 */
public class CdiConfigSource implements ConfigSource {

    private final Map<String, ProjectStage> mapping;
    private final Map<String, String> properties;

    public CdiConfigSource() {
        this.mapping = new HashMap<>();
        this.mapping.put("dev", ProjectStage.Development);
        this.mapping.put("test", ProjectStage.UnitTest);
        this.mapping.put("int", ProjectStage.IntegrationTest);
        this.mapping.put("stage", ProjectStage.Staging);
        this.mapping.put("prod", ProjectStage.Production);

        this.properties = new HashMap<>();
        String env = System.getenv("environment");
        if (env == null || env.trim().length() == 0) {
            env = "test";
        }
        env = this.mapping.get(env).getClass().getSimpleName();
        properties.put("org.apache.deltaspike.ProjectStage", env);
    }

    @Override
    public int getOrdinal() {
        return 500;
    }

    @Override
    public Map<String, String> getProperties() {
        return this.properties;
    }

    @Override
    public String getPropertyValue(String string) {
        return this.properties.get(string);
    }

    @Override
    public String getConfigName() {
        return "cdiConfigSource";
    }

    @Override
    public boolean isScannable() {
        return false;
    }

}
