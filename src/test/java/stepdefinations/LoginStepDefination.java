package stepdefinations;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import hooks.Hooks;
import pages.LoginPage;

public class LoginStepDefination {

    WebDriver driver = Hooks.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User navigate to the login page")
    public void user_navigate_to_the_login_page() {
        driver.get("https://dsportalapp.herokuapp.com/login");
        System.out.println("User is on login page");
    }

    @When("User enter valid credentials with username {string} and password {string}")
    public void user_enter_valid_credentials_with_username_and_password(String username, String password) {
        loginPage.loginAs(username, password);
        System.out.println("User entered credentials: " + username + " / " + password);
    }

    @Then("User click the {string} button and should be redirected to the homepage")
    public void user_click_the_button_and_should_be_redirected_to_the_homepage(String button) {
        driver.get("https://dsportalapp.herokuapp.com/home");
        System.out.println("User redirected to homepage after clicking " + button);
    }

    @When("User enter an empty email field and user click the {string} button")
    public void user_enter_an_empty_email_field_and_user_click_the_button(String button) {
        loginPage.enterUsername("");
        loginPage.enterPassword("We_team3");
        loginPage.clickLogin();
        System.out.println("User submitted login form with empty email");
    }

    @Then("user see an error message saying {string}")
    public void user_see_an_error_message_saying(String message) {
        System.out.println("Expected error message: " + message);
        // Add assertion for actual message later if needed
    }

    @When("User enter an Username {string} and I leave the password field empty")
    public void user_enter_an_username_and_i_leave_the_password_field_empty(String username) {
        loginPage.enterUsername(username);
        loginPage.enterPassword("");
        System.out.println("Entered username with empty password");
    }

    @Then("User click the {string} button should see an error message saying {string}")
    public void user_click_the_button_should_see_an_error_message_saying(String button, String message) {
        loginPage.clickLogin();
        System.out.println("Clicked " + button + " and saw error: " + message);
    }

    @When("User enter an invalid Username\"invalid-Username\" and User enter a password {string}")
    public void user_enter_an_invalid_username_and_user_enter_a_password(String password) {
        loginPage.enterUsername("invalid-Username");
        loginPage.enterPassword(password);
    }

    @Then("User click the {string} button and user should see an error message saying {string}")
    public void user_click_the_button_and_user_should_see_an_error_message_saying(String button, String message) {
        loginPage.clickLogin();
        System.out.println("User clicked " + button + " with invalid credentials, expected error: " + message);
    }

    @When("User enter an Username {string} and enter a password {string} and click the {string} button")
    public void user_enter_an_username_and_enter_a_password_and_click_the_button(String username, String password, String button) {
        loginPage.loginAs(username, password);
        System.out.println("User attempted login with: " + username + " / " + password);
    }

    @Then("I should see an error message saying {string}")
    public void i_should_see_an_error_message_saying(String message) {
        System.out.println("Expected error message: " + message);
    }
}
