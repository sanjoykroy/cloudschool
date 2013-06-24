package com.realtech.cloudschool.command;


import com.realtech.cloudschool.identityaccess.domain.model.User;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCommandTest {

    @Test
    public void shouldConvertToUser(){
        UserCommand command = new UserCommand();
        command.setUsername("username");
        command.setPassword("password");
        command.setFirstname("firstname");
        command.setLastname("lastname");
        command.setEmail("email@abc.com");
        command.setInterests("interests");
        command.setEnabled(true);

        User user = command.convertToUser();

        assertThat(user.getUsername(), is("username"));
        assertThat(user.getFirstname(), is("firstname"));
        assertThat(user.getLastname(), is("lastname"));
        assertThat(user.getEmail().getAddress(), is("email@abc.com"));
        assertThat(user.getInterests(), is("interests"));
        assertThat(user.isEnabled(), is(Boolean.TRUE));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfEmailIsNotValid() throws Exception{
        UserCommand command = new UserCommand();
        command.setUsername("username");
        command.setPassword("password");
        command.setEmail("email");
        command.convertToUser();
    }
}
