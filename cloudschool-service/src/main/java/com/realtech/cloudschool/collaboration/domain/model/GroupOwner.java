package com.realtech.cloudschool.collaboration.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GroupOwner {

    @Column(name = "OWNER")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
