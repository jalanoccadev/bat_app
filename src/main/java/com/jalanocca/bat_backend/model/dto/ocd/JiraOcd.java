package com.jalanocca.bat_backend.model.dto.ocd;

public class JiraOcd {
    private String ticketOCD;
    private String ticketScrum;

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

    @Override
    public String toString() {
        return "JiraOcd{" +
                "ticketOCD='" + ticketOCD + '\'' +
                ", ticketScrum='" + ticketScrum + '\'' +
                '}';
    }
}
