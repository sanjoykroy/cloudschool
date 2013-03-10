package com.realtech.cloudschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    private static final String VIEW_NAME = "home";

    @RequestMapping("/home")
    public String showHomePage(){
        return VIEW_NAME;
    }
}
