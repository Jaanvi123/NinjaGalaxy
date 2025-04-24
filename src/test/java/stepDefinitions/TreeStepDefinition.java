package stepDefinitions;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.SignInPageObj;
import dsAlgoPageObjects.TreePageObj;

import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TreeStepDefinition  {
	
	public WebDriver driver = DriverFactory.getDriver();
	//TryEditorPage tryEditor = new TryEditorPage();
    HomePageObj homepage = new HomePageObj(driver);
    SignInPageObj login = new SignInPageObj(driver);
	IntroductionPageObj ip = new IntroductionPageObj();
	TreePageObj treePage = new TreePageObj(driver);
	
		    
	@Given("the user is in the DS Algo portal after signing in")
	public void the_user_is_in_the_ds_algo_portal_after_signing_in() throws InterruptedException {
		homepage.openHomeUrl();
		
	}

	@When("the user clicks the Get Started button in the Tree panel")
	public void the_user_clicks_the_button_in_the_tree_panel() throws InterruptedException, InvalidFormatException, IOException, OpenXML4JException {
		
		 hp.ClickHomePageGetStartedButton();
	        ip.clickOnSignInlink();
	        login.enterLoginFormFields("login", 6);
		     login.clickloginBtn();
		treePage.getStartedTree();
	  
	}

	@Then("the user should be redirected to the Tree data structure page")
	public void the_user_should_be_redirected_to_the_data_structure_page() {
	    	
		Assert.assertEquals(ip.getPageTitle(), "Tree");
	}
	
	@Given("the user is in the home page after signing in")
	public void the_user_is_in_the_home_page_after_signing_in() {
	    // Write code here that turns the phrase above into concrete actions
	   hp.openHomeURL();
	}
	
	
	@When("The user selects tree item from the drop down menu")
	public void the_user_selects_tree_item_from_the_drop_down_menu() throws InterruptedException {
	    ip.clickDropdownToggle();
		ip.clickDropdownItemTree();
	}
  
	// testcase 2  - overview of trees
	@Given("the user is on the Tree page after signing in")
	public void the_user_is_on_the_tree_page_after_signing_in() throws InterruptedException {
		
		hp.openHomeURL();
		treePage.getStartedTree();
		
	}
	
	@When("the user clicks the Overview of Trees button")
	public void the_user_clicks_the_button() throws InterruptedException {
	   
		treePage.overviewofTreesLink();
		
	   	}
		
	
	@Then("the user should be redirected to the Overview of Trees data structure page")
	public void the_user_should_be_redirected_to_the_overview_of_trees_data_structure_page() throws InterruptedException {
	    
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.toLowerCase().contains("Overview of Trees".toLowerCase()), 
                "Page title does not contain 'Tree' . Found: " + pageTitle);
  
	}


	 
	
}