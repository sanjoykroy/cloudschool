package com.realtech.cloudschool.security;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userPasswordEncoder")
public class UserPasswordEncoder implements PasswordEncoder {

    public final static String SALT = "$1$54%as56wD";
    private final static String ENCRYP_PWD_START = SALT.substring(0, SALT.length()-1);

    @Override
    public String encodePassword(String rawPassword, Object salt) {
        return MD5Crypt.crypt(rawPassword, SALT);
    }

    @Override
    public boolean isPasswordValid(String encrypPassword, String rawPassword, Object salt) {
        if(encrypPassword.startsWith(ENCRYP_PWD_START)){
            return encodePassword(rawPassword, salt).equals(encrypPassword);
        } else {
            return encrypPassword.equals(rawPassword);
        }
    }

}
