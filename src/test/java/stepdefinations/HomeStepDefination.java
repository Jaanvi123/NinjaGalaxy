package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDefination {

    private WebDriver driver = hooks.Hooks.getDriver();
    private HomePage homePage = new HomePage(driver);

    @Given("The user is in the ds-algo launch page")
    public void the_user_is_in_the_ds_algo_launch_page() {
        driver.get("https://dsportalapp.herokuapp.com/");
        System.out.println("User is on the DS Algo launch page");
    }

    @When("The user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {
        homePage.clickGetStarted();
        System.out.println("Clicked on Get Started button");
    }

    @Then("The user should land on dsAlgo home portal")
    public void the_user_should_land_on_ds_algo_home_portal() {
        driver.get("https://dsportalapp.herokuapp.com/home");
        System.out.println("User landed on home portal");
    }

    @Given("The user is on the Home page")
    public void the_user_is_on_the_home_page() {
        driver.get("https://dsportalapp.herokuapp.com/home");
        System.out.println("The user is on the Home page");
    }

    @When("The user clicks on dropdown {string}")
    public void the_user_clicks_on_dropdown(String string) {
        homePage.clickDropdown();
        System.out.println("User clicked on dropdown");
    }

    @Then("The user should see all the options of {string}")
    public void the_user_should_see_all_the_options_of(String optionsList) throws InterruptedException {
        Thread.sleep(500);
        String[] options = optionsList.split(",");
        for (String option : options) {
            WebElement optionElement = homePage.getDropdownOption(option.trim());
            Assert.assertTrue("Option " + option + " is not visible.", optionElement.isDisplayed());
            System.out.println("Verified visibility for: " + option);
        }
    }

    @Then("The user should see warning message")
    public void the_user_should_see_warning_message() {
        Assert.assertTrue(homePage.isAlertDisplayed());
        System.out.println("You are not logged in alert is displayed");
    }
}

