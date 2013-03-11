package com.realtech.cloudschool.controller;


import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.server.MockMvc;
import org.springframework.web.servlet.View;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class LoginControllerTest {
    private LoginController controller;
    @Mock
    private View mockView;
    private MockMvc mockMvc;

    @BeforeMethod
    public void setup() throws Exception {
        controller = new LoginController();
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(controller).setSingleView(mockView).build();
    }

    @Test
    public void shouldShowLoginPage() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andExpect(view().name(containsString("login")))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldShowLoginPageWithErrorMessage() throws Exception{
        this.mockMvc.perform(get("/login-again"))
                .andExpect(model().attribute("loginError", "error.login.failed"))
                .andExpect(model().size(1))
                .andExpect(view().name(containsString("login")))
                .andExpect(status().isOk());
    }
}
