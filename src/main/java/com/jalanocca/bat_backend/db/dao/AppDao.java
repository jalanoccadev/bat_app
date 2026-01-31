package com.jalanocca.bat_backend.db.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jalanocca.bat_backend.db.entity.AppConfigEntity;
import com.jalanocca.bat_backend.db.repository.AppConfigRepository;

@Service
public class AppDao {

    private final AppConfigRepository appConfigRepository;

    public AppDao(AppConfigRepository appConfigRepository) {
        this.appConfigRepository = appConfigRepository;
    }

    public List<AppConfigEntity> getAllAppConfigByAppId(Long appId) {
        return appConfigRepository.findByAppId(appId);
    }

}
