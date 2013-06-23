package com.realtech.cloudschool.identityaccess.domain.repository;


import com.realtech.cloudschool.identityaccess.domain.model.UserId;

public interface UserIdRepository {
    UserId nextIdentity();
}
