package com.onestopcare.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */

@MappedSuperclass
public class PersistenceObject implements Serializable {

    @Version
    private Long version;

    private String createdBy;
    private String lastUpdatedBy;

    private LocalDateTime dateCreated;
    private LocalDateTime dateLastModified;

    public Long getVersion() {
        return version;
    }

    public PersistenceObject setVersion(Long version) {
        this.version = version;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public PersistenceObject setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public PersistenceObject setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
        return this;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public PersistenceObject setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public LocalDateTime getDateLastModified() {
        return dateLastModified;
    }

    public PersistenceObject setDateLastModified(LocalDateTime dateLastModified) {
        this.dateLastModified = dateLastModified;
        return this;
    }
}
