package com.jalanocca.bat_backend.model.dto.ocd;

public class JiraDatos {
    private String description;
    private String diagramaArquitectura;
    private String diagramaInfraestructura;
    private String indisponibilidadCanal;
    private String instruccionesCert;
    private String instruccionesProd;
    private String instruccionesReversion;
    private String nroTicket;
    private String origenTicket;
    private String summary;
    private String sustento;
    private String tipoRatificacion;
    private String tipoRequerimiento;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiagramaArquitectura() {
        return diagramaArquitectura;
    }

    public void setDiagramaArquitectura(String diagramaArquitectura) {
        this.diagramaArquitectura = diagramaArquitectura;
    }

    public String getDiagramaInfraestructura() {
        return diagramaInfraestructura;
    }

    public void setDiagramaInfraestructura(String diagramaInfraestructura) {
        this.diagramaInfraestructura = diagramaInfraestructura;
    }

    public String getIndisponibilidadCanal() {
        return indisponibilidadCanal;
    }

    public void setIndisponibilidadCanal(String indisponibilidadCanal) {
        this.indisponibilidadCanal = indisponibilidadCanal;
    }

    public String getInstruccionesCert() {
        return instruccionesCert;
    }

    public void setInstruccionesCert(String instruccionesCert) {
        this.instruccionesCert = instruccionesCert;
    }

    public String getInstruccionesProd() {
        return instruccionesProd;
    }

    public void setInstruccionesProd(String instruccionesProd) {
        this.instruccionesProd = instruccionesProd;
    }

    public String getInstruccionesReversion() {
        return instruccionesReversion;
    }

    public void setInstruccionesReversion(String instruccionesReversion) {
        this.instruccionesReversion = instruccionesReversion;
    }

    public String getNroTicket() {
        return nroTicket;
    }

    public void setNroTicket(String nroTicket) {
        this.nroTicket = nroTicket;
    }

    public String getOrigenTicket() {
        return origenTicket;
    }

    public void setOrigenTicket(String origenTicket) {
        this.origenTicket = origenTicket;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSustento() {
        return sustento;
    }

    public void setSustento(String sustento) {
        this.sustento = sustento;
    }

    public String getTipoRatificacion() {
        return tipoRatificacion;
    }

    public void setTipoRatificacion(String tipoRatificacion) {
        this.tipoRatificacion = tipoRatificacion;
    }

    public String getTipoRequerimiento() {
        return tipoRequerimiento;
    }

    public void setTipoRequerimiento(String tipoRequerimiento) {
        this.tipoRequerimiento = tipoRequerimiento;
    }

    @Override
    public String toString() {
        return "JiraDatos{" +
                "description='" + description + '\'' +
                ", diagramaArquitectura='" + diagramaArquitectura + '\'' +
                ", diagramaInfraestructura='" + diagramaInfraestructura + '\'' +
                ", indisponibilidadCanal='" + indisponibilidadCanal + '\'' +
                ", instruccionesCert='" + instruccionesCert + '\'' +
                ", instruccionesProd='" + instruccionesProd + '\'' +
                ", instruccionesReversion='" + instruccionesReversion + '\'' +
                ", nroTicket='" + nroTicket + '\'' +
                ", origenTicket='" + origenTicket + '\'' +
                ", summary='" + summary + '\'' +
                ", sustento='" + sustento + '\'' +
                ", tipoRatificacion='" + tipoRatificacion + '\'' +
                ", tipoRequerimiento='" + tipoRequerimiento + '\'' +
                '}';
    }
}
