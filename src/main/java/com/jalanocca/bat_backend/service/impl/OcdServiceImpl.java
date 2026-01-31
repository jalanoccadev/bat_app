package com.jalanocca.bat_backend.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jalanocca.bat_backend.config.AppConfigProperties;
import com.jalanocca.bat_backend.db.dao.AppDao;
import com.jalanocca.bat_backend.db.entity.AppConfigEntity;
import com.jalanocca.bat_backend.db.entity.IssueEntity;
import com.jalanocca.bat_backend.db.entity.OcdDeliveryEntity;
import com.jalanocca.bat_backend.db.entity.OcdEntity;
import com.jalanocca.bat_backend.db.entity.OcdJiraEntity;
import com.jalanocca.bat_backend.db.mapper.OcdMapper;
import com.jalanocca.bat_backend.db.repository.IssueRepository;
import com.jalanocca.bat_backend.db.repository.OcdRepository;
import com.jalanocca.bat_backend.model.dto.GenericResponseDto;
import com.jalanocca.bat_backend.model.dto.ocd.OcdBodyConfig;
import com.jalanocca.bat_backend.service.GitService;
import com.jalanocca.bat_backend.service.OcdService;

@Service
public class OcdServiceImpl implements OcdService {

    private final AppConfigProperties appConfigProperties;

    private final AppDao appDao;

    private final GitService gitService;

    private final IssueRepository issueRepository;
    private final OcdRepository ocdRepository;

    public OcdServiceImpl(AppConfigProperties appConfigProperties, AppDao appDao, GitService gitService, IssueRepository issueRepository, OcdRepository ocdRepository) {
        this.appConfigProperties = appConfigProperties;
        this.appDao = appDao;
        this.gitService = gitService;
        this.issueRepository = issueRepository;
        this.ocdRepository = ocdRepository;
    }

    @Override
    public GenericResponseDto createOcdDelivery(Long appId, OcdBodyConfig ocdBodyConfig) throws Exception {

        String repoUrl = null, repoName = null, branchTemplate = null, pathDelivery = null, pathJira = null;

        // CARGAR CONFIGS DE LA APP DESDE BD - START
        List<AppConfigEntity> appConfigs = appDao.getAllAppConfigByAppId(appId);
        for (AppConfigEntity appConfig : appConfigs) {
            switch (appConfig.getConfig().getConfigType()) {
                case "REPO_DELIVERY_URL":
                    repoUrl = appConfig.getConfigValue();
                    break;
                case "REPO_DELIVERY_NAME":
                    repoName = appConfig.getConfigValue();
                    break;
                case "BRANCH_DELIVERY_TEMPLATE":
                    branchTemplate = appConfig.getConfigValue();
                    break;
                case "RUTA_JSON_DELIVERY":
                    pathDelivery = appConfig.getConfigValue();
                    break;
                case "RUTA_JSON_JIRA":
                    pathJira = appConfig.getConfigValue();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown config type: " + appConfig.getConfig().getConfigType());
            }
        }
        // CARGAR CONFIGS DE LA APP DESDE BD - END
        
        // PREPARAR REPOSITORIO - START
        String folderForReposPath = appConfigProperties.getPathForRepos();
        String repoPath = folderForReposPath + File.separator + repoName;
        String newBrachName = "feature/" + ocdBodyConfig.getOcdJiraConfig().getDatosOCD().getTicketScrum();

        if (this.checkIfFolderExists(repoPath)) {
            // El repositorio ya existe, hacer fetch, checkout y pull
            this.gitService.executeFetch(repoPath);
            this.gitService.executeCheckout(repoPath, branchTemplate);
            this.gitService.executePull(repoPath);
            this.gitService.executeCheckoutNewBranch(repoPath, newBrachName);
            
        } else {
            // El repositorio no existe, clonar y crear nueva rama
            this.gitService.executeClone(repoUrl, folderForReposPath);
            this.gitService.executeCheckout(repoPath, branchTemplate);
            this.gitService.executeCheckoutNewBranch(repoPath, newBrachName);
        }
        // PREPARAR REPOSITORIO - END

        // ESCRIBIR Y PUSH ARCHIVOS - START
        // Serializar a JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonDelivery = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ocdBodyConfig.getOcdJobsConfig());
        String jsonJira = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ocdBodyConfig.getOcdJiraConfig());

        // Construir rutas completas
        String fullPathDelivery = Paths.get(repoPath, pathDelivery).toString();
        String fullPathJira = Paths.get(repoPath, pathJira).toString();

        // Escribir archivos
        Files.write(Paths.get(fullPathDelivery), jsonDelivery.getBytes());
        Files.write(Paths.get(fullPathJira), jsonJira.getBytes());

        this.gitService.executeAddAll(repoPath);
        this.gitService.executeDefaultBatCommit(repoPath, newBrachName);
        this.gitService.executePushWithNewBranch(repoPath, newBrachName);
        
        // ESCRIBIR Y PUSH ARCHIVOS - END

        // GUARDAR EN BD EL REGISTRO DE OCD - START

        IssueEntity existingIssue = issueRepository.findByCodeAndAppId(
            ocdBodyConfig.getOcdJiraConfig().getDatosOCD().getTicketScrum(),
            appId
        ).get();
        
        OcdEntity ocdEntity = new OcdEntity();
        ocdEntity.setCode(ocdBodyConfig.getOcdJiraConfig().getDatosOCD().getTicketOCD());;
        ocdEntity.setJsonJira(jsonJira);
        ocdEntity.setJsonDelivery(jsonDelivery);

        OcdJiraEntity ocdJiraEntity = OcdMapper.toOcdJiraEntity(ocdBodyConfig.getOcdJiraConfig());
        ocdJiraEntity.setOcd(ocdEntity);
        ocdEntity.setOcdJira(ocdJiraEntity);

        OcdDeliveryEntity ocdDeliveryEntity = OcdMapper.toOcdDeliveryEntity(ocdBodyConfig.getOcdJobsConfig());
        ocdDeliveryEntity.setOcd(ocdEntity);
        ocdEntity.setOcdDelivery(ocdDeliveryEntity);

        ocdEntity.setIssue(existingIssue);
        existingIssue.setOcd(ocdEntity);

        ocdRepository.save(ocdEntity);
        // GUARDAR EN BD EL REGISTRO DE OCD - END

        return GenericResponseDto.success("OCD delivery created successfully");
    }

    /**
     * Valida si en la ruta base existe una carpeta con el nombre dado.
     * @param basePath Ruta base donde buscar
     * @param folderName Nombre de la carpeta a buscar
     * @return true si existe la carpeta, false si no
     */
    private boolean checkIfFolderExists(String folderPath) {
        File carpeta = new File(folderPath);
        return carpeta.exists() && carpeta.isDirectory();
    }
    
}
