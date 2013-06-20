package com.realtech.cloudschool.controller;

import com.realtech.cloudschool.model.User;
import com.realtech.cloudschool.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
public class HomeController {

    private final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserRepository repository;

    private static final String HOME_VIEW = "home";

    @RequestMapping("/home")
    public String showHomePage(Principal principal, ModelMap map){
        String userName = principal.getName();
        LOGGER.info("Showing home page for [{}]", userName);
        Page<User> users = repository.findByUsername(userName, new PageRequest(0, 1));
        map.addAttribute("user", users.iterator().next());
        return HOME_VIEW;
    }
}
