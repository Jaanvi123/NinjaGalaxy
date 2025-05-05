package stepDefinitions;

import java.io.IOException;
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
	WebDriver driver = DriverFactory.getDriver();
	SignInPageObj signin = new SignInPageObj(driver);
	ConfigReader configReader = new ConfigReader(driver);
	IntroductionPageObj introductionpage = new IntroductionPageObj();
	HomePageObj homepage = new HomePageObj(driver);
	ExcelRead excelread = new ExcelRead();

	@Given("The user is on the DS Algo Sign in Page")
	public void the_user_is_on_the_ds_algo_sign_in_page() {
		homepage.clickGetStartedHomePageButton();
		try {
			introductionpage.clickSignInLink();
		} catch (Exception e) {
		
		}
	}

//TC01
	@When("The user clicks login button after entering valid username and valid password")
	public void the_user_clicks_login_button_after_entering_valid_username_and_valid_password()
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		introductionpage.clickSignInLink();
        signin.enterUsernameText("username");
		signin.enterPasswordText("password");
		signin.clickloginButton();
	}
	@Then("The user should land on Data Structure Home Page with message {string}")
	public void the_user_should_land_on_data_structure_home_page_with_message(String expectedAlertMessage) {
		signin.homePagemsg();
	}

//TC02
	@When("The user clicks login button after leaving the Username textbox and Password textbox empty from sheetname {string} and row {int}")
	public void the_user_clicks_login_button_after_leaving_the_username_textbox_and_password_textbox_empty_from_sheetname_and_row(
			String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		try {
			signin.EnterFromExcel(SheetName, RowNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signin.clickloginButton();
	}
	@Then("The error message {string} appears below Username textbox")
	public void the_error_message_appears_below_username_textbox(String expectedalertmsg) throws IOException {
		signin.TakeScreenshot();
		
	}

//TC03
	@When("The user clicks login button after entering the Password only from sheetname {string} and row {int}")
	public void the_user_clicks_login_button_after_entering_the_password_only_from_sheetname_and_row(String SheetName,
			Integer RowNumber) throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		signin.EnterFromExcel("login", 2);
		signin.clickloginButton();
	}

	@Then("The error message {string} appears below Password textbox")
	public void the_error_message_appears_below_password_textbox(String string) throws IOException {
		signin.TakeScreenshot();
		
	}
//TC04
	@When("The user clicks login button after entering the Username and leaves Password textbox empty from sheetname {string} and row {int}")
	public void the_user_clicks_login_button_after_entering_the_username_and_leaves_password_textbox_empty_from_SheetName_and_row(
			String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		signin.EnterFromExcel("login", 3);
		signin.clickloginButton();
	}
	@Then("The user should able to see an error message {string}")
	public void the_user_should_able_to_see_an_error_message(String string) throws IOException {
		signin.TakeScreenshot();
		
	}
//TC05
	@When("The user clicks login button after entering invalid username and invalid password from sheetname {string} and row {int}")
	public void the_user_clicks_login_button_after_entering_invalid_username_and_invalid_password_from_SheetName_and_row(
			String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		signin.EnterFromExcel("login", 4);
		signin.clickloginButton();
	}
	@Then("The user should able to see the error message {string}")
	public void the_user_should_able_to_see_the_error_message(String string) throws IOException {
		signin.TakeScreenshot();
	
	}
//TC06
	@When("The user clicks login button after entering invalid username and valid password {string} and row {int}")
	public void the_user_clicks_login_button_after_entering_invalid_username_and_valid_password_and_row(String string, Integer int1) throws IOException {
		signin.EnterFromExcel("login", 5);
		signin.clickloginButton();
	}
	@Then("The user should able to see error message {string}")
	public void the_user_should_able_to_see_error_message(String string) throws IOException {
		signin.TakeScreenshot();
	
	}
//TC07
	@When("The user clicks login button after entering valid username and invalid password from {string} and row {int}")
	public void the_user_clicks_login_button_after_entering_valid_username_and_invalid_password_from_and_row(String string, Integer int1) throws IOException {
		signin.EnterFromExcel("login", 6);
		signin.clickloginButton();
	}
	@Then("The user should see error message {string}")
	public void the_user_should_see_error_message(String string) throws IOException {
		signin.TakeScreenshot();
		
		}	
		
	}