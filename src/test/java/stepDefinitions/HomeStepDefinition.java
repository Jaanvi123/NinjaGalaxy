package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomeStepDefinition {	
	WebDriver driver = DriverFactory.getDriver();
    HomePageObj homepage = new HomePageObj(driver) ;
	
	String homepageTitle;
	WebElement getstartedBtn;

	@Given("The user should open the browser and enters the DS_Algo Portal")
	public void the_user_should_open_the_browser_and_enters_the_ds_algo_portal()
	{
		DriverFactory.initializeDriver("chrome");  
		System.out.println("URl opened");
	}	
	@Then("The user should be landed on the DS_Algo Get Started page with message {string}")
	public void the_user_should_be_landed_on_the_ds_algo_get_started_page_with_message(String expectedmsg){
	
		String landingpageMsg = homepage.getMessage();
		System.out.println(landingpageMsg);
		Assert.assertEquals(landingpageMsg, expectedmsg);
	}

	@When("User clicks on get started button")
	public void user_clicks_on_get_started_button() {
		homepage.clickGetStartedHomePageButton();
	}

	@Then("User should be landed on the data structure page with title {string}")
	public void user_should_be_landed_on_the_data_structure_page(String expectedpageTitle) {
		homepageTitle=homepage.getTitle();
		System.out.println(homepageTitle);
		System.out.println("Home page execution completed");
		Assert.assertEquals(homepageTitle, expectedpageTitle);
	    //Log.info("Title of the homepage:"+homepageTitle+ "and"+expectedpageTitle);
	}

}