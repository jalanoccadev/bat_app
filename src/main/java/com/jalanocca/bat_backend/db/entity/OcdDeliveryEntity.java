package com.jalanocca.bat_backend.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ocd_delivery")
public class OcdDeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ocd_id")
    private OcdEntity ocd;

    private String nameOcdRc;
    private String moveJobs;
    @Lob
    private String repos;

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

    public String getNameOcdRc() {
        return nameOcdRc;
    }

    public void setNameOcdRc(String nameOcdRc) {
        this.nameOcdRc = nameOcdRc;
    }

    public String getMoveJobs() {
        return moveJobs;
    }

    public void setMoveJobs(String moveJobs) {
        this.moveJobs = moveJobs;
    }

    public String getRepos() {
        return repos;
    }

    public void setRepos(String repos) {
        this.repos = repos;
    }
}
