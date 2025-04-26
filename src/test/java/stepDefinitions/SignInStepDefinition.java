package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.SignInPageObj;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import utils.ExcelRead;


public class SignInStepDefinition {
	WebDriver driver= DriverFactory.getDriver(); 
	SignInPageObj signin= new SignInPageObj(driver);
	ConfigReader configReader = new ConfigReader();
	IntroductionPageObj introductionpage = new IntroductionPageObj();
	HomePageObj homepage = new HomePageObj(driver) ;
	ExcelRead excelread = new ExcelRead();
	
	@Given("The user is on the DS Algo Sign in Page")
	public void the_user_is_on_the_ds_algo_sign_in_page() {
		DriverFactory.initializeDriver("chrome"); 
		homepage.clickGetStartedHomePageButton();
		introductionpage.clicklink(driver);
		introductionpage.clickSignInLink();
	}

	@When("The user clicks login button after entering valid username and valid password from {string} and row {int}")
	public void the_user_clicks_login_button_after_entering_valid_username_and_valid_password_from_and_row(String Sheetname ,Integer RowNumber)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		ExcelRead excelread = new ExcelRead();
		String filepath = "src/test/resources/TestData/TestingData.xlsx";
		List<Map<String, String>>testdata= excelread.readExcelSheet(filepath, Sheetname);
	    String username = testdata.get(RowNumber).get("username");
	    String password = testdata.get(RowNumber).get("password");

	        signin.enterLoginDetails(username, password);
	//    System.out.println("Logging in with Username: " + username + " and Password: " + password);
      //     signin.enterLoginFormFields("login", 1);
            signin.clickloginButton();
        }
	

	@Then("The user should land in Data Structure Home Page with message {string}")
	public void the_user_should_land_in_data_structure_home_page_with_message(String expectedAlertMessage) {
		
		signin.homePagemsg();
	}

	
	  	
	}

	
