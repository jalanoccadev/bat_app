package com.jalanocca.bat_backend.model.dto.ocd;

import java.util.List;

public class OcdJob {
    private String name;
    private List<String> env;
    private boolean wait;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEnv() {
        return env;
    }

    public void setEnv(List<String> env) {
        this.env = env;
    }

    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    @Override
    public String toString() {
        return "OcdJob{" +
                "name='" + name + '\'' +
                ", env=" + env +
                ", wait=" + wait +
                '}';
    }
    
}
