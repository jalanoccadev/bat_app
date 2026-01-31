package com.jalanocca.bat_backend.db.mapper;

import com.jalanocca.bat_backend.db.entity.OcdDeliveryEntity;
import com.jalanocca.bat_backend.db.entity.OcdJiraEntity;
import com.jalanocca.bat_backend.model.dto.ocd.OcdJiraConfig;
import com.jalanocca.bat_backend.model.dto.ocd.OcdJobsConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OcdMapper {
    
    /**
     * Mapea OcdJiraConfig a OcdJiraEntity
     * @param ocdJiraConfig
     * @return OcdJiraEntity
     */
    public static OcdJiraEntity toOcdJiraEntity(OcdJiraConfig ocdJiraConfig) {
        OcdJiraEntity entity = new OcdJiraEntity();
        entity.setTicketOCD(ocdJiraConfig.getDatosOCD().getTicketOCD());
        entity.setTicketScrum(ocdJiraConfig.getDatosOCD().getTicketScrum());
        
        entity.setDescription(ocdJiraConfig.getDatos().getDescription());
        entity.setDiagramaArquitectura(ocdJiraConfig.getDatos().getDiagramaArquitectura());
        entity.setDiagramaInfraestructura(ocdJiraConfig.getDatos().getDiagramaInfraestructura());
        entity.setIndisponibilidadCanal(ocdJiraConfig.getDatos().getIndisponibilidadCanal());
        entity.setInstruccionesCert(ocdJiraConfig.getDatos().getInstruccionesCert());
        entity.setInstruccionesProd(ocdJiraConfig.getDatos().getInstruccionesProd());
        entity.setInstruccionesReversion(ocdJiraConfig.getDatos().getInstruccionesReversion());
        entity.setNroTicket(ocdJiraConfig.getDatos().getNroTicket());
        entity.setOrigenTicket(ocdJiraConfig.getDatos().getOrigenTicket());
        entity.setSummary(ocdJiraConfig.getDatos().getSummary());
        entity.setSustento(ocdJiraConfig.getDatos().getSustento());
        entity.setTipoRatificacion(ocdJiraConfig.getDatos().getTipoRatificacion());
        entity.setTipoRequerimiento(ocdJiraConfig.getDatos().getTipoRequerimiento());

        entity.setClDev(ocdJiraConfig.getResponsables().getClDev());
        entity.setClQe(ocdJiraConfig.getResponsables().getClQe());
        entity.setGrupoAgileOps(ocdJiraConfig.getResponsables().getGrupoAgileOps());
        entity.setLt(ocdJiraConfig.getResponsables().getLt());
        entity.setOpsGobierno(ocdJiraConfig.getResponsables().getOpsGobierno());
        entity.setPo(ocdJiraConfig.getResponsables().getPo());
        entity.setQe(ocdJiraConfig.getResponsables().getQe());
        entity.setReporter(ocdJiraConfig.getResponsables().getReporter());
        entity.setSeguridad(ocdJiraConfig.getResponsables().getSeguridad());

        return entity;
    }

    public static OcdDeliveryEntity toOcdDeliveryEntity(OcdJobsConfig ocdJobsConfig) {
        OcdDeliveryEntity entity = new OcdDeliveryEntity();
        entity.setNameOcdRc(ocdJobsConfig.getNameOcdRc());
        entity.setMoveJobs(ocdJobsConfig.getMoveJobs());
        try {
            ObjectMapper mapper = new ObjectMapper();
            String reposJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ocdJobsConfig.getRepos());
            entity.setRepos(reposJson);
        } catch (Exception e) {
            entity.setRepos(null);
        }
        return entity;
    }

}
