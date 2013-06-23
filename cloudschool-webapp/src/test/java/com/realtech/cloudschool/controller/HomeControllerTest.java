package com.realtech.cloudschool.controller;

import com.realtech.cloudschool.identityaccess.domain.model.User;
import com.realtech.cloudschool.identityaccess.domain.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.server.MockMvc;
import org.springframework.web.servlet.View;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Principal;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;

public class HomeControllerTest {

    private static final String EXPECTED_HOME_VIEW = "home";
    @InjectMocks
    private HomeController controller;
    @Mock
    private UserRepository repository;
    @Mock
    private View mockView;
    private MockMvc mockMvc;

    @BeforeMethod
    public void setup() throws Exception {
        controller = new HomeController();
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(controller).setSingleView(mockView).build();
    }

    @Test
    public void shouldShowHomePage() throws Exception {
        User user =  getFakeUser();
        Page<User> users = new PageImpl<User>(Arrays.asList(user));
        Pageable pageable = new PageRequest(0, 1);
        when(repository.findByUsername("testUser", pageable)).thenReturn(users);
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return "testUser";
            }
        };

        this.mockMvc.perform(get("/home").principal(principal))
                .andExpect(model().attribute("user", user))
                .andExpect(view().name(containsString(EXPECTED_HOME_VIEW)))
                .andExpect(status().isOk());

        verify(repository).findByUsername("testUser", pageable);
    }

    private User getFakeUser(){
        User user = new User();
        user.setUsername("testUser");
        return user;
    }
}
