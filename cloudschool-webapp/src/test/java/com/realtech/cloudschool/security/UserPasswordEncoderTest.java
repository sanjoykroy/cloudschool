package com.realtech.cloudschool.security;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserPasswordEncoderTest {

    private UserPasswordEncoder passwordEncoder;

    @BeforeMethod
    public void setUp(){
        passwordEncoder = new UserPasswordEncoder();
    }

    @Test
    public void shouldEncodePassword() throws Exception {
        String actual = passwordEncoder.encodePassword("sen", passwordEncoder.SALT);
        assertThat(actual, is("$1$54%as56w$MmFHlGeQPVfpV.AwtX.oZ/"));
    }

    @Test
    public void shouldValidatePassword() throws Exception {
        boolean isValid = passwordEncoder.isPasswordValid("$1$54%as56w$MmFHlGeQPVfpV.AwtX.oZ/", "sen", null);
        assertThat(isValid, is(Boolean.TRUE));
    }
}
