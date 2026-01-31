package com.jalanocca.bat_backend.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ocd_jira")
public class OcdJiraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ocd_id")
    private OcdEntity ocd;

    // datos ocd
    private String ticketOCD;
    private String ticketScrum;

    // datos
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

    // responsables
    private String clDev;
    private String clQe;
    private String grupoAgileOps;
    private String lt;
    private String opsGobierno;
    private String po;
    private String qe;
    private String reporter;
    private String seguridad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OcdEntity getOcd() {
        return ocd;
    }

    public void setOcd(OcdEntity ocd) {
        this.ocd = ocd;
    }

    public String getTicketOCD() {
        return ticketOCD;
    }

    public void setTicketOCD(String ticketOCD) {
        this.ticketOCD = ticketOCD;
    }

    public String getTicketScrum() {
        return ticketScrum;
    }

    public void setTicketScrum(String ticketScrum) {
        this.ticketScrum = ticketScrum;
    }

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
}
