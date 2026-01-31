package com.jalanocca.bat_backend.service;

import java.util.List;

import com.jalanocca.bat_backend.model.dto.jira.JiraIssueDto;

public interface JiraService {
    List<JiraIssueDto> fetchJiraIssues();
}
