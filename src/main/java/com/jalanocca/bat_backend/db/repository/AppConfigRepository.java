package com.jalanocca.bat_backend.db.repository;

import com.jalanocca.bat_backend.db.entity.AppConfigEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppConfigRepository extends JpaRepository<AppConfigEntity, Long> {
    List<AppConfigEntity> findByAppId(Long appId);
}
