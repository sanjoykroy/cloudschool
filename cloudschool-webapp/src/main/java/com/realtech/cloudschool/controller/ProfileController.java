package com.realtech.cloudschool.controller;

import com.realtech.cloudschool.identityaccess.domain.model.User;
import com.realtech.cloudschool.identityaccess.domain.model.UserId;
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

    @RequestMapping(value="/profile/{userId}", method = RequestMethod.GET)
    public String showProfile(@PathVariable String userId, ModelMap map){
        LOGGER.info("Showing profile for User Id [{}]", userId);
        UserId userIdToLookFor = new UserId(userId);
        Page<User> users = repository.findByUserId(userIdToLookFor, new PageRequest(0, 1));
        map.addAttribute("user", users.iterator().next());
        map.addAttribute("menuactive", "profile");
        return PROFILE_VIEW;
    }

}
