package com.jalanocca.bat_backend.model.dto.ocd;

public class JiraResponsables {
    private String clDev;
    private String clQe;
    private String grupoAgileOps;
    private String lt;
    private String opsGobierno;
    private String po;
    private String qe;
    private String reporter;
    private String seguridad;

    public String getClDev() {
        return clDev;
    }

    public void setClDev(String clDev) {
        this.clDev = clDev;
    }

    public String getClQe() {
        return clQe;
    }

    public void setClQe(String clQe) {
        this.clQe = clQe;
    }

    public String getGrupoAgileOps() {
        return grupoAgileOps;
    }

    public void setGrupoAgileOps(String grupoAgileOps) {
        this.grupoAgileOps = grupoAgileOps;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public String getOpsGobierno() {
        return opsGobierno;
    }

    public void setOpsGobierno(String opsGobierno) {
        this.opsGobierno = opsGobierno;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getQe() {
        return qe;
    }

    public void setQe(String qe) {
        this.qe = qe;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }

    @Override
    public String toString() {
        return "JiraResponsables{" +
                "clDev='" + clDev + '\'' +
                ", clQe='" + clQe + '\'' +
                ", grupoAgileOps='" + grupoAgileOps + '\'' +
                ", lt='" + lt + '\'' +
                ", opsGobierno='" + opsGobierno + '\'' +
                ", po='" + po + '\'' +
                ", qe='" + qe + '\'' +
                ", reporter='" + reporter + '\'' +
                ", seguridad='" + seguridad + '\'' +
                '}';
    }
}
