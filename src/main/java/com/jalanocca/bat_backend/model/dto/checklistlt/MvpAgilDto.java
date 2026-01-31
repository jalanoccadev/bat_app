package com.jalanocca.bat_backend.model.dto.checklistlt;

public class MvpAgilDto {

    private int correlativo;
    private String tool;
    private String category;
    private String revision;
    private String cumpleDev;
    private String cumpleLt;
    
    public MvpAgilDto(int correlativo, String tool, String category, String revision, String cumpleDev, String cumpleLt) {
        this.correlativo = correlativo;
        this.tool = tool;
        this.category = category;
        this.revision = revision;
        this.cumpleDev = cumpleDev;
        this.cumpleLt = cumpleLt;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getCumpleDev() {
        return cumpleDev;
    }

    public void setCumpleDev(String cumpleDev) {
        this.cumpleDev = cumpleDev;
    }

    public String getCumpleLt() {
        return cumpleLt;
    }

    public void setCumpleLt(String cumpleLt) {
        this.cumpleLt = cumpleLt;
    }
}
