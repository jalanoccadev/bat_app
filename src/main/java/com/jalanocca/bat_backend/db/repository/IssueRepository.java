package com.jalanocca.bat_backend.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalanocca.bat_backend.db.entity.IssueEntity;

public interface IssueRepository extends JpaRepository<IssueEntity, Long> {
    Optional<IssueEntity> findByCodeAndAppId(String code, Long appId);
}
