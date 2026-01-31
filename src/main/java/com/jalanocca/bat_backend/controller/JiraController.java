package com.jalanocca.bat_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jalanocca.bat_backend.model.dto.jira.JiraIssueDto;
import com.jalanocca.bat_backend.service.JiraService;

@RestController
@RequestMapping("/jira")
public class JiraController {

    private final JiraService jiraService;

    public JiraController(JiraService jiraService) {
        this.jiraService = jiraService;
    }

    // obtener issues de jira
    @GetMapping("/loadIssues")
    @ResponseBody
    public List<JiraIssueDto> loadIssues() {
        return this.jiraService.fetchJiraIssues();
    } 
    // obtener detalles de un issue

    
}
