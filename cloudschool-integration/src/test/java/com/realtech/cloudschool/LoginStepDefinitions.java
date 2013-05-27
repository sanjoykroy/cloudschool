package com.realtech.cloudschool;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinitions {

    @Given("^I am in login page$")
    public void I_am_in_login_page(){
    }

    @And("^I enter username ([^\"]*)$")
    public void I_enter_username(String username){
    }

    @And("^I enter password ([^\"]*)$")
    public void I_enter_password(String password){
    }

    @When("^I click on login$")
    public void I_click_on_login(){
    }

    @Then("^I should be able to login$")
    public void assertLoggedIn(){
    }
}
