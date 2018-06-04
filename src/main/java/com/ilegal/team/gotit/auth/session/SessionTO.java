package com.ilegal.team.gotit.auth.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mm on 6/4/18.
 */
@Entity
@Table(name = "SESSION")
public class SessionTO {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "token")
    private String token;

    @Column(name = "created")
    private Long created;

    @Column(name = "modified")
    private Long modified;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "modifiedBy")
    private String modifiedBy;

    @Column(name = "version")
    private Integer version;

    @Column(name = "deleted")
    private Long deleted;

    public SessionTO() {
    }

    public SessionTO(String id, String userId, String token, Long created, Long modified, String createdBy, String modifiedBy, Integer version, Long deleted) {
        this.id = id;
        this.userId = userId;
        this.token = token;
        this.created = created;
        this.modified = modified;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.version = version;
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getModified() {
        return modified;
    }

    public void setModified(Long modified) {
        this.modified = modified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getDeleted() {
        return deleted;
    }

    public void setDeleted(Long deleted) {
        this.deleted = deleted;
    }
}
