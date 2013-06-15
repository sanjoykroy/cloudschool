package com.realtech.cloudschool.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userPasswordEncoder")
public class UserPasswordEncoder implements PasswordEncoder {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserPasswordEncoder.class);
    public final static String SALT = "$1$54%as56wD";
    private final static String ENCRYP_PWD_START = SALT.substring(0, SALT.length()-1);

    @Override
    public String encodePassword(String rawPassword, Object salt) {
        return MD5Crypt.crypt(rawPassword, SALT);
    }

    @Override
    public boolean isPasswordValid(String encrypPassword, String rawPassword, Object salt) {
        LOGGER.info("Retrieving password for encrypPassword {} rawPassword {} salt {} ", new Object[]{encrypPassword, rawPassword, salt});
        boolean isValid = false;
        if(encrypPassword.startsWith(ENCRYP_PWD_START)){
            LOGGER.info("encrypPassword starts with ENCRYP_PWD_START");
            isValid = encodePassword(rawPassword.trim(), SALT).equals(encrypPassword.trim());
        } else {
            LOGGER.info("encrypPassword does not start with ENCRYP_PWD_START");
            isValid = encrypPassword.equals(rawPassword);
        }
        LOGGER.info("isValid {}", isValid);
        return isValid;
    }

}
