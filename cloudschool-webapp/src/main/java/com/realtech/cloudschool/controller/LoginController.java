package com.realtech.cloudschool.controller;


import com.realtech.cloudschool.command.UserCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private static final String LOGIN_VIEW = "login";
    private static final String COMMAND = "userCommand";
    private static final String LOGIN_ERROR = "loginError";
    private static final String LOGIN_ERROR_MSG = "error.login.failed";

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginForm(ModelMap map){
        LOGGER.info("Showing login page");
        map.addAttribute(COMMAND, new UserCommand());
        return LOGIN_VIEW;
    }

    @RequestMapping(value = "/login-again", method = RequestMethod.GET)
    public String loginFormAgain(ModelMap map){
        LOGGER.info("Showing login page with error message");
        map.addAttribute(LOGIN_ERROR, LOGIN_ERROR_MSG);
        map.addAttribute(COMMAND, new UserCommand());
        return LOGIN_VIEW;
    }
}
