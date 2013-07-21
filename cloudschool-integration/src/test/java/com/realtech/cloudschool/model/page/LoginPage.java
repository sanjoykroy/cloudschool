package com.realtech.cloudschool.model.page;


public class LoginPage extends AbstractPage {

    private static final String LOGIN_PAGE_URL = MAIN_URL;

    private static final LoginPage LOGIN_PAGE = new LoginPage();

    private LoginPage(){
    }

    public static LoginPage getInstance(){
        return LOGIN_PAGE;
    }

    public void loadLoginPage(){
       getPage(LOGIN_PAGE_URL);
    }

    public boolean isCurrentPage(){
        return findElementById("user-name") == null;
    }

    public void setUsername(String username){
        setFieldElement("j_username", username);
    }

    public void setPassword(String password){
        setFieldElement("j_password", password);
    }

    public void signIn(){
        submit("sign-in");
    }

    public void signUp(){
        submit("sign-up");
    }

    public boolean isLoginSuccessful(){
        return findElementById("user-name") != null;
    }

    public void setFieldValue(String id, String value){
        setFieldElement(id, value);
    }
}
