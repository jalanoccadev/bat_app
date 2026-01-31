package com.jalanocca.bat_backend.model.external.jira;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalListIssueResponse {
    private List<ExternalIssue> issues;
    private boolean isLast;

    public List<ExternalIssue> getIssues() {
        return issues;
    }

    public void setIssues(List<ExternalIssue> issues) {
        this.issues = issues;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }
}