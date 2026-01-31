package com.jalanocca.bat_backend.model.dto.ocd;

public class OcdBodyConfig {
    private OcdJiraConfig ocdJiraConfig;
    private OcdJobsConfig ocdJobsConfig;

    public OcdJiraConfig getOcdJiraConfig() {
        return ocdJiraConfig;
    }

    public void setOcdJiraConfig(OcdJiraConfig ocdJiraConfig) {
        this.ocdJiraConfig = ocdJiraConfig;
    }

    public OcdJobsConfig getOcdJobsConfig() {
        return ocdJobsConfig;
    }

    public void setOcdJobsConfig(OcdJobsConfig ocdJobsConfig) {
        this.ocdJobsConfig = ocdJobsConfig;
    }

    @Override
    public String toString() {
        return "OcdBodyConfig{" +
                "ocdJiraConfig=" + ocdJiraConfig +
                ", ocdJobsConfig=" + ocdJobsConfig +
                '}';
    }
}
