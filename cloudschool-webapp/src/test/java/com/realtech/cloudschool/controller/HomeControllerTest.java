package com.realtech.cloudschool.controller;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.server.MockMvc;
import org.springframework.web.servlet.View;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;

public class HomeControllerTest {

    private static final String EXPECTED_HOME_VIEW = "home";

    private HomeController controller;
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
        this.mockMvc.perform(get("/home"))
                .andExpect(view().name(containsString(EXPECTED_HOME_VIEW)))
                .andExpect(status().isOk());
    }
}
