package com.realtech.cloudschool.controller;


import com.realtech.cloudschool.command.UserCommand;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.server.MockMvc;
import org.springframework.web.servlet.View;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class LoginControllerTest {

    private static final String EXPECTED_LOGIN_VIEW = "login";
    private static final String COMMAND = "userCommand";
    private static final String LOGIN_ERROR = "loginError";
    private static final String LOGIN_ERROR_MSG = "error.login.failed";

    private LoginController controller;
    @Mock
    private View mockView;
    private MockMvc mockMvc;

    @BeforeMethod
    public void setup() {
        controller = new LoginController();
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(controller).setSingleView(mockView).build();
    }

    @Test
    public void shouldShowLoginPage() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andExpect(model().attribute(COMMAND, is(UserCommand.class)))
                .andExpect(model().size(1))
                .andExpect(view().name(containsString(EXPECTED_LOGIN_VIEW)))
                .andExpect(status().isOk());

        verify(mockView).render(any(Map.class), any(HttpServletRequest.class), any(HttpServletResponse.class));
        verifyNoMoreInteractions(mockView);
    }

    @Test
    public void shouldShowLoginPageWithErrorMessage() throws Exception{
        this.mockMvc.perform(get("/login-again"))
                .andExpect(model().attribute(COMMAND, is(UserCommand.class)))
                .andExpect(model().attribute(LOGIN_ERROR, is(LOGIN_ERROR_MSG)))
                .andExpect(model().size(2))
                .andExpect(view().name(containsString(EXPECTED_LOGIN_VIEW)))
                .andExpect(status().isOk());

        verify(mockView).render(any(Map.class), any(HttpServletRequest.class), any(HttpServletResponse.class));
        verifyNoMoreInteractions(mockView);
    }

}
