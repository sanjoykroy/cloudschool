package com.realtech.cloudschool.identityaccess.domain.repository.impl;


import com.realtech.cloudschool.identityaccess.domain.model.UserId;
import com.realtech.cloudschool.identityaccess.domain.repository.UserIdRepository;

import java.util.UUID;


public class UserIdRepositoryImpl implements UserIdRepository {
    @Override
    public UserId nextIdentity() {
        return new UserId(UUID.randomUUID().toString().toUpperCase());
    }
}
