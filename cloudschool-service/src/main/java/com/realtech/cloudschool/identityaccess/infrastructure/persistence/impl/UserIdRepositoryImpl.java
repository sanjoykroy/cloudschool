package com.realtech.cloudschool.identityaccess.infrastructure.persistence.impl;


import com.realtech.cloudschool.identityaccess.domain.model.UserId;
import com.realtech.cloudschool.identityaccess.infrastructure.persistence.UserIdRepository;

import java.util.UUID;


public class UserIdRepositoryImpl implements UserIdRepository {
    @Override
    public UserId nextIdentity() {
        return new UserId(UUID.randomUUID().toString().toUpperCase());
    }
}
