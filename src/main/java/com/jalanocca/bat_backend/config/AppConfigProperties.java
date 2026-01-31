package com.jalanocca.bat_backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.config")
public class AppConfigProperties {
    private String pathForRepos;

    public String getPathForRepos() {
        return pathForRepos;
    }

    public void setPathForRepos(String pathForRepos) {
        this.pathForRepos = pathForRepos;
    }
}
