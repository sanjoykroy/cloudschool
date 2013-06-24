package com.realtech.cloudschool.identityaccess.infrastructure.persistence;


import com.realtech.cloudschool.AbstractCloudSchoolRepositoryTest;
import com.realtech.cloudschool.identityaccess.domain.model.UserId;
import com.realtech.cloudschool.identityaccess.infrastructure.persistence.UserIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class UserIdRepositoryTest extends AbstractCloudSchoolRepositoryTest {

    @Autowired
    private UserIdRepository userIdRepository;

    @Test
    public void shouldGenerateNextIdentity() throws Exception {
        UserId id = userIdRepository.nextIdentity();
        assertThat(id, is(notNullValue()));
    }
}
