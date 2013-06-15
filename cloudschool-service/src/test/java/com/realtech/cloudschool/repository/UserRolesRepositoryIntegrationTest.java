package com.realtech.cloudschool.repository;

import com.realtech.cloudschool.model.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@ContextConfiguration("classpath:repository-context.xml")
public class UserRolesRepositoryIntegrationTest extends AbstractCloudSchoolRepositoryTest {

    @Autowired
    private UserRolesRepository repository;

    @Test
    public void shouldSaveUserRoles() {
        UserRoles userRoles = repository.save(new UserRoles());
        assertThat(userRoles.getUserRoleId(), is(notNullValue()));
    }
}
