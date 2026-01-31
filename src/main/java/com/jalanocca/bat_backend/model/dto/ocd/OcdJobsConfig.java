package com.jalanocca.bat_backend.model.dto.ocd;

import java.util.List;

public class OcdJobsConfig {
    private String nameOcdRc;
    private String moveJobs;
    private List<OcdJob> repos;

    public String getNameOcdRc() {
        return nameOcdRc;
    }

    public void setNameOcdRc(String nameOcdRc) {
        this.nameOcdRc = nameOcdRc;
    }

    public String getMoveJobs() {
        return moveJobs;
    }

    public void setMoveJobs(String moveJobs) {
        this.moveJobs = moveJobs;
    }

    public List<OcdJob> getRepos() {
        return repos;
    }

    public void setRepos(List<OcdJob> repos) {
        this.repos = repos;
    }

    @Override
    public String toString() {
        return "OcdJobsConfig{" +
                "nameOcdRc='" + nameOcdRc + '\'' +
                ", moveJobs='" + moveJobs + '\'' +
                ", repos=" + repos +
                '}';
    }


}
