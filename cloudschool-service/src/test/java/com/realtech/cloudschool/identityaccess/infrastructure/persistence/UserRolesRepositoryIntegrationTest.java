package com.realtech.cloudschool.identityaccess.infrastructure.persistence;

import com.realtech.cloudschool.AbstractCloudSchoolRepositoryTest;
import com.realtech.cloudschool.identityaccess.domain.model.UserRoles;
import com.realtech.cloudschool.identityaccess.infrastructure.persistence.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class UserRolesRepositoryIntegrationTest extends AbstractCloudSchoolRepositoryTest {

    @Autowired
    private UserRolesRepository repository;

    @Test
    public void shouldSaveUserRoles() {
        UserRoles userRoles = repository.save(new UserRoles());
        assertThat(userRoles.getUserRoleId(), is(notNullValue()));
    }
}
