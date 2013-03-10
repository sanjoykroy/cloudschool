package com.realtech.cloudschool.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginForm(){
        return "login";
    }

    @RequestMapping(value = "/login-again", method = RequestMethod.GET)
    public String loginFormAgain(ModelMap map){
        map.addAttribute("loginError", "error.login.failed");
        return "login";
    }
}
