package com.realtech.cloudschool.definitions;

import com.realtech.cloudschool.model.page.HomePage;
import com.realtech.cloudschool.model.page.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginStepDefinitions {

    private LoginPage loginPage = LoginPage.getInstance();
    private HomePage homePage = HomePage.getInstance();

    @Given("I am in login page")
    public void i_am_in_login_page(){
        loginPage.loadLoginPage();
    }

    @And("I enter username '(.*)'")
    public void i_enter_username(String username){
        loginPage.setUsername(username);
    }

    @And("I enter password '(.*)'")
    public void i_enter_password(String password){
        loginPage.setPassword(password);
    }

    @When("I click on login")
    public void i_click_on_login(){
        loginPage.signIn();
    }

    @Then("I should be able to login")
    public void i_should_be_able_to_login(){
        assertTrue(loginPage.isLoginSuccessful());
    }

    @Then("I should not be able to login")
    public void i_should_not_be_able_to_login(){
        assertFalse(loginPage.isLoginSuccessful());
    }

    @And("I should be able to logout")
    public void i_should_be_able_to_logout(){
        homePage.logout();
    }
}
