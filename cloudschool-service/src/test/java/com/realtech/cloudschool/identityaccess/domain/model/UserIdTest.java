package com.realtech.cloudschool.identityaccess.domain.model;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class UserIdTest {

    @DataProvider(name = "invalidUserIds")
    public Object[][] invalidUserIds() {
        return new Object[][] {
                { null },
                { "" },
                { "AAAAA11111-BBBBB22222-CCCCC33333-DDDDD44444-EEEEE55555-FFFFF66666-GGGGG77777-HHHHH88888-IIIII99999-JJJJJ-22222" }
        };
    }

    @Test(dataProvider = "invalidUserIds", expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenInvalidDataIsPassed(String id) throws Exception {
        new UserId(id);
    }

    @Test
    public void shouldCreateUserIdWhenValidDataIsPassed() throws Exception {
        String id = UUID.randomUUID().toString().toUpperCase();
        UserId userId = new UserId(id);

        assertThat(userId, is(notNullValue()));
        assertThat(userId.getId(), is(equalTo(id)));
    }
}
