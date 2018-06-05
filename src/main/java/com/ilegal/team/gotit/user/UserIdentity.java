package com.ilegal.team.gotit.user;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by mm on 6/4/18.
 */
public class UserIdentity {

    private String id;

    private String username;

    private String interestedCategories;

    private String roles;

    private Long created;

    private Long modified;

    private String createdBy;

    private String modifiedBy;

    private Integer version;

    private Long deleted;

    public UserIdentity() {
    }

    public UserIdentity(String id, String username, String interestedCategories, String roles, Long created, Long modified, String createdBy, String modifiedBy, Integer version, Long deleted) {
        this.id = id;
        this.username = username;
        this.interestedCategories = interestedCategories;
        this.roles = roles;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInterestedCategories() {
        return interestedCategories;
    }

    public void setInterestedCategories(String interestedCategories) {
        this.interestedCategories = interestedCategories;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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
