package com.realtech.cloudschool.identityaccess.domain.repository;


import com.realtech.cloudschool.identityaccess.domain.model.UserRoles;
import org.springframework.data.repository.CrudRepository;

public interface UserRolesRepository  extends CrudRepository<UserRoles, Long> {
}
