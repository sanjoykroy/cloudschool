package com.realtech.cloudschool.identityaccess.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class UserId {

    @Column(name = "USERID")
    private String id;

    protected UserId() {
    }

    public UserId(String anId) {
        super();
        this.setId(anId);
    }

    public String getId() {
        return this.id;
    }

    private void setId(String anId) {
        if(anId == null){
            throw new IllegalArgumentException("Id can not be set to null.");
        }
        if(anId.length() == 0){
            throw new IllegalArgumentException("Id is required.");
        }
        if(anId.length() > 100){
            throw new IllegalArgumentException("Id must be 100 characters or less.");
        }
        this.id = anId;
    }
}
