package com.realtech.cloudschool.validator;


import com.realtech.cloudschool.command.UserCommand;
import com.realtech.cloudschool.identityaccess.domain.model.Email;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.apache.commons.lang.StringUtils.isEmpty;

@Component
public class UserCommandValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserCommand.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserCommand command = (UserCommand)o;

        if(isEmpty(command.getFirstname())){
            errors.reject("cloudschool.firstname.required" , "First name is required.");
        }
        if(isEmpty(command.getLastname())){
            errors.reject("cloudschool.lastname.required" , "Last name is required.");
        }
        if(isEmpty(command.getEmail())){
            errors.reject("cloudschool.email.required" , "Email is required.");
        }
        try{
            Email email = new Email(command.getEmail());
        } catch(IllegalArgumentException ex) {
            errors.reject("cloudschool.email.invalid" , ex.getMessage());
        }
        if(isEmpty(command.getUsername())){
            errors.reject("cloudschool.username.required" , "Username is required.");
        }
        if(isEmpty(command.getPassword())){
            errors.reject("cloudschool.password.required" , "Password is required.");
        }

    }
}
