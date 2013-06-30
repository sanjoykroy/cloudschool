package com.realtech.cloudschool.controller;

import com.realtech.cloudschool.identityaccess.domain.model.User;
import com.realtech.cloudschool.identityaccess.infrastructure.persistence.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private UserRepository repository;

    private static final String PROFILE_VIEW = "profile";

    @RequestMapping(value="/profile/{userName}", method = RequestMethod.GET)
    public String showProfile(@PathVariable String userName, ModelMap map){
        LOGGER.info("Showing profile for [{}]", userName);
        Page<User> users = repository.findByUsername(userName, new PageRequest(0, 1));
        map.addAttribute("user", users.iterator().next());
        return PROFILE_VIEW;
    }

}
