package com.jalanocca.bat_backend.model.dto.ocd;

public class OcdJiraConfig {
    private JiraOcd datosOCD;
    private JiraDatos datos;
    private JiraResponsables responsables;

    public JiraOcd getDatosOCD() {
        return datosOCD;
    }

    public void setDatosOCD(JiraOcd datosOCD) {
        this.datosOCD = datosOCD;
    }

    public JiraDatos getDatos() {
        return datos;
    }

    public void setDatos(JiraDatos datos) {
        this.datos = datos;
    }

    public JiraResponsables getResponsables() {
        return responsables;
    }

    public void setResponsables(JiraResponsables responsables) {
        this.responsables = responsables;
    }

    @Override
    public String toString() {
        return "OcdJiraConfig{" +
                "datosOCD=" + datosOCD +
                ", datos=" + datos +
                ", responsables=" + responsables +
                '}';
    }
}