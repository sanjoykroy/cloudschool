package com.realtech.cloudschool.controller;



import com.realtech.cloudschool.command.UserCommand;
import com.realtech.cloudschool.model.User;
import com.realtech.cloudschool.model.UserRoles;
import com.realtech.cloudschool.repository.UserRepository;
import com.realtech.cloudschool.repository.UserRolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    private static final String HOME_VIEW = "home";
    private static final String LOGIN_VIEW = "login";

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserRolesRepository rolesRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(UserCommand command, BindingResult result, ModelMap map){
        LOGGER.info("Registering a user {}", command);

        if(result.hasErrors()){
            LOGGER.error("Registering a user has errors - {}", result.getAllErrors());
        } else {
            User user = command.convertToUser();
            User savedUser = repository.save(user);
            UserRoles roles = createUserRoles(savedUser.getId());
            map.addAttribute("user", savedUser);
            map.addAttribute("roles", roles);
            return HOME_VIEW;
        }
        return LOGIN_VIEW;
    }

    private UserRoles createUserRoles(Long userId){
        UserRoles roles = new UserRoles();
        roles.setUserId(userId);
        roles.setAuthority("ROLE_USER");
        return rolesRepository.save(roles);
    }
}
