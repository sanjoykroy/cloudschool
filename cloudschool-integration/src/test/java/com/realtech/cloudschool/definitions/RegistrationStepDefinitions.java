package com.realtech.cloudschool.definitions;


import com.realtech.cloudschool.model.page.HomePage;
import com.realtech.cloudschool.model.page.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

public class RegistrationStepDefinitions {

    private LoginPage loginPage = LoginPage.getInstance();
    private HomePage homePage = HomePage.getInstance();

    @Given("I want to register")
    public void i_want_to_register(){
        loginPage.loadLoginPage();
        assertTrue(loginPage.isCurrentPage());
    }

    @And("I enter my firstname '(.*)'")
    public void i_enter_my_firstname(String firstName){
        loginPage.setFieldValue("inputFirstName", firstName);
    }

    @And("I enter my lastname '(.*)'")
    public void i_enter_my_lastname(String lastName){
        loginPage.setFieldValue("inputLastName", lastName);
    }

    @And("I enter my email '(.*)'")
    public void i_enter_my_email(String email){
        loginPage.setFieldValue("inputEmail", email);
    }

    @And("I enter my username '(.*)'")
    public void i_enter_my_username(String username){
        loginPage.setFieldValue("inputUsername", username);
    }

    @And("I enter my password '(.*)'")
    public void i_enter_my_password(String password){
        loginPage.setFieldValue("inputPassword", password);
    }

    @When("I click on signup")
    public void i_click_on_signup(){
        loginPage.signUp();
    }

    @Then("I should register myself")
    public void i_should_register_myself(){
        assertTrue(homePage.isCurrentPage());
    }

    @And("I should be able to logout after registration")
    public void i_should_be_able_to_logout_after_registration(){
        homePage.logout();
    }
}
