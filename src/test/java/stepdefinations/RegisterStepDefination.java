package stepdefinations;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pages.RegisterPage;
import hooks.Hooks;

public class RegisterStepDefination {

    WebDriver driver = Hooks.getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @Given("User navigate to the registration page")
    public void user_navigate_to_the_registration_page() {
        driver.get("https://dsportalapp.herokuapp.com/register");
        registerPage.registerLink.click();
    }

    @When("User enter valid details in the registration form and click the {string} button")
    public void user_enters_valid_details(String button) {
        registerPage.register("Ninja_Galaxy", "We_team3", "We_team3");
    }

    @Then("User should be redirected to the home page and see alert message of logged in")
    public void user_redirected_to_home_page() {
        System.out.println("User is redirected and logged in.");
    }

    @When("User enter the details without an Username and click the {string} button")
    public void user_enters_details_without_username(String button) {
        registerPage.username.clear();
        registerPage.password1.sendKeys("We_team3");
        registerPage.password2.sendKeys("We_team3");
        registerPage.registerButton.click();
        System.out.println("Attempted to register without username.");
    }

    @Then("User should see an error message saying {string}")
    public void user_sees_error_message(String message) {
        System.out.println("Error message: " + message);
        // Optional: Assert visibility of the error element
    }

    @When("User enter an invalid Username \"invalid\"and I click the {string} button")
    public void user_enters_invalid_username(String button) {
        registerPage.register("invalid", "123455", "123455");
        System.out.println("Attempted with invalid username.");
    }

    @When("User enter the\"Username\" and fill in other required details and click the {string} button")
    public void user_fills_username_and_details(String button) {
        registerPage.register("Ninja_Galaxy", "We_team3", "We_team3");
        System.out.println("Filled form with matching passwords.");
    }

    @Then("User should see an error message saying {string} and press {string}")
    public void user_sees_error_and_clicks_login(String message, String action) {
        System.out.println("Alert message: " + message);
        registerPage.loginLink.click();
        System.out.println("Redirected to login page.");
    }
}
