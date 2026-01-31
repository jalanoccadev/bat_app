package com.jalanocca.bat_backend.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalanocca.bat_backend.db.entity.OcdEntity;

public interface OcdRepository extends JpaRepository<OcdEntity, Long> {
    
}
