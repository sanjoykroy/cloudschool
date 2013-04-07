package com.realtech.cloudschool.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginForm(){
        LOGGER.info("Showing login page");
        return "login";
    }

    @RequestMapping(value = "/login-again", method = RequestMethod.GET)
    public String loginFormAgain(ModelMap map){
        LOGGER.info("Showing login page with error message");
        map.addAttribute("loginError", "error.login.failed");
        return "login";
    }
}
