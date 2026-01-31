package com.jalanocca.bat_backend.db.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "ocd")
public class OcdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "ocd")
    private IssueEntity issue;

    private String code;
    @Lob
    private String jsonJira;
    @Lob
    private String jsonDelivery;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ocd_jira_id")
    private OcdJiraEntity ocdJira;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ocd_delivery_id")
    private OcdDeliveryEntity ocdDelivery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IssueEntity getIssue() {
        return issue;
    }

    public void setIssue(IssueEntity issue) {
        this.issue = issue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getJsonJira() {
        return jsonJira;
    }

    public void setJsonJira(String jsonJira) {
        this.jsonJira = jsonJira;
    }

    public String getJsonDelivery() {
        return jsonDelivery;
    }

    public void setJsonDelivery(String jsonDelivery) {
        this.jsonDelivery = jsonDelivery;
    }

    public OcdJiraEntity getOcdJira() {
        return ocdJira;
    }

    public void setOcdJira(OcdJiraEntity ocdJira) {
        this.ocdJira = ocdJira;
    }

    public OcdDeliveryEntity getOcdDelivery() {
        return ocdDelivery;
    }

    public void setOcdDelivery(OcdDeliveryEntity ocdDelivery) {
        this.ocdDelivery = ocdDelivery;
    }
}