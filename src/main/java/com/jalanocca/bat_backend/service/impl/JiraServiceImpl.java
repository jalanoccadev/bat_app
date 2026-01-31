package com.jalanocca.bat_backend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jalanocca.bat_backend.model.dto.jira.JiraIssueDto;
import com.jalanocca.bat_backend.model.external.jira.ExternalIssue;
import com.jalanocca.bat_backend.model.external.jira.ExternalListIssueResponse;
import com.jalanocca.bat_backend.service.JiraService;
import com.jalanocca.bat_backend.service.RestApiService;
import com.jalanocca.bat_backend.util.Constants;

@Service
public class JiraServiceImpl implements JiraService {

    private final RestApiService restApiService;

    public JiraServiceImpl(RestApiService restApiService) {
        this.restApiService = restApiService;
    }

    @Override
    public List<JiraIssueDto> fetchJiraIssues() {
        // cargar de jira los issues
        ExternalListIssueResponse response = this.getIssues();
        List<ExternalIssue> externalIssues = response.getIssues();
        List<JiraIssueDto> jiraIssues = externalIssues.stream()
            .map(JiraServiceImpl::mapToJiraIssueDto)
            .toList();
        return jiraIssues;
        // convertir a objetos internos

        // guardar en base de datos
        
    }

    private ExternalListIssueResponse getIssues() {
        String requestBody = """
        {
            "jql": "project = SCDPDP AND assignee = currentUser() AND type IN ('Business Story', Request, Task) AND status != Resolved ORDER BY created DESC",
            "maxResults": 50,
            "fields": [
                "summary",
                "status",
                "assignee",
                "issueType",
                "created",
                "updated",
                "priority"
            ]
        }
        """;
        return this.restApiService.post("", "", this.buildJiraHeaders(), requestBody, ExternalListIssueResponse.class);
    }

    private Map<String, String> buildJiraHeaders() {
        return Map.of(
            "Content-Type", "application/json",
            "Cookie", "tenant.session.token="
        );
    }

    private static JiraIssueDto mapToJiraIssueDto(ExternalIssue issue) {
        JiraIssueDto jiraIssueDto = new JiraIssueDto();
        jiraIssueDto.setIssueId(issue.getKey());
        jiraIssueDto.setIssueTitle(issue.getFields().getSummary());
        jiraIssueDto.setIssueState(issue.getFields().getStatus().getName());
        jiraIssueDto.setAllowedActions(determineAllowedActions(jiraIssueDto.getIssueState()));
        // Asignar otros campos según sea necesario
        return jiraIssueDto;
    }

    private static List<String> determineAllowedActions(String status) {
        List<String> allowedActions = new ArrayList<>();
        // Lógica para determinar las acciones permitidas según el estado
        if (Constants.ISSUE_STATE_CONSTRUCCION_DOING.equals(status)) {
            allowedActions.add("GENERAR_OCD");
        }

        if (Constants.ISSUE_STATE_CONSTRUCCION_DONE.equals(status) ||
            Constants.ISSUE_STATE_GESTION_CONGELAMIENTO_DOING.equals(status)) {
            allowedActions.add("CHECKLIST_LT");
            allowedActions.add("VALIDADOR_CONGELAMIENTO");
        }

        if (Constants.ISSUE_STATE_GESTION_PASE_DOING.equals(status)) {
            allowedActions.add("REGISTRAR_CHECKLIST");
            allowedActions.add("REGISTRAR_CALENDARIO");
            allowedActions.add("CONFORMIDAD_QE");
            allowedActions.add("VALIDADOR_CALENDARIO");
        }
        return allowedActions;
    }
}
