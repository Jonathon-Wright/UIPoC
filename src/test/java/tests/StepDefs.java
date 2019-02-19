package tests;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_objects.LoginPage;
import utils.Utils;

public class StepDefs {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() {
        driver = Utils.getDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^I navigate to the login page$")
    public void i_navigate_to_the_login_page() throws Throwable {
        driver.get(Utils.getUrl());
        Assert.assertEquals(loginPage.getPageTitle(), "Log in to 4303", "We're not on the log in page or its title has changed");
    }

    @When("^I enter the login details for a 'validUser'$")
    public void i_enter_the_login_details_for_a_validUser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I can see the following message: 'Welcome to Volo'$")
    public void i_can_see_the_following_message_Welcome_to_Volo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I enter the login details for a 'invalidUser'$")
    public void i_enter_the_login_details_for_a_invalidUser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions    throw new PendingException();
    }

    @Then("^I can see the following message: 'Invalid username or password'$")
    public void i_can_see_the_following_message_Invalid_username_or_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
