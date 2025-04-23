package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.RegisterPageObj;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExcelRead;
import utils.LoggerLoad;

public class IntroductionStepDefinition {
	 WebDriver driver= DriverFactory.getDriver(); 
	IntroductionPageObj datastructurepage = new IntroductionPageObj();
	RegisterPageObj registerPage = new RegisterPageObj();
	 HomePageObj homepage = new HomePageObj(driver);
	 
	// Logger logger =(Logger) LogManager.getLogger("");
	 @Given("User is on the Get Started Page")
	 public void user_is_on_the_get_started_page() {
	     registerPage.navigateToRegisterPage();
	    //	driver.get("https://dsportalapp.herokuapp.com/home");
		    homepage.clickGetStartedHomePageButton();	
		    System.out.print("hello");
	 }
	
	 @Then("User clicks on Data Structures dropddown and validates all the in  pane")
	 public void user_clicks_on_data_structures_dropddown_and_validates_all_the_in_pane(io.cucumber.datatable.DataTable dataTable) {
		 LoggerLoad.info("User clicks on dropdown without login");
		 datastructurepage.getSelectedItems();
		 System.out.print("Dropdown done ");
		 
    
}

}
	
	