package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {

        LoginPage login = new LoginPage();

        login.login();
    }

    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        Assert.assertEquals("Zero - Account Summary",Driver.get().getTitle());
    }

    @When("the user enters {string} {string} username and {string} {string} password")
    public void the_user_enters_username_and_password(String string, String string2, String string3, String string4) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The error message {string} should be displayed.")
    public void the_error_message_should_be_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
