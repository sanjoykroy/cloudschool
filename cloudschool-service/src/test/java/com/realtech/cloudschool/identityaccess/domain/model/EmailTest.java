package com.realtech.cloudschool.identityaccess.domain.model;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class EmailTest {

    @DataProvider(name = "invalidEmailAddresses")
    public Object[][] invalidEmailAddresses() {
        return new Object[][] {
                { null },
                { "" },
                { "AAAAA11111-BBBBB22222-CCCCC33333-DDDDD44444-EEEEE55555-FFFFF66666-GGGGG77777-HHHHH88888-IIIII99999-" +
                        "JJJJJ-22222EEEEE55555-FFFFF66666-GGGGG77777-HHHHH88888-IIIII99999-JJJJJ-22222@abc.com" },
                { "abc.com" }
        };
    }

    @Test(dataProvider = "invalidEmailAddresses", expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenInvalidAddressIsPassed(String address) throws Exception{
        new Email(address);
    }

    @Test
    public void shouldSetEmailAddressWhenValidAddressIsPassed() throws Exception{
        String address = "test@abc.com";
        Email email = new Email(address);

        assertThat(email.getAddress(), is(notNullValue()));
        assertThat(email.getAddress(), is(equalTo(address)));
    }
}
