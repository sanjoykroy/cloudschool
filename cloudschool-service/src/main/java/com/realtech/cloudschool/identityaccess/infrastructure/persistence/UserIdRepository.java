package com.realtech.cloudschool.identityaccess.infrastructure.persistence;


import com.realtech.cloudschool.identityaccess.domain.model.UserId;

public interface UserIdRepository {
    UserId nextIdentity();
}
