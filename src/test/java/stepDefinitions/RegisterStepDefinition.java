package stepDefinitions;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.RegisterPageObj;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegisterStepDefinition {

	WebDriver driver = DriverFactory.getDriver();
	IntroductionPageObj introductionpage = new IntroductionPageObj();
	HomePageObj homepage = new HomePageObj(driver);
	RegisterPageObj registerPage = new RegisterPageObj(driver);
	WebElement getstartedBtn;
	String actualErrorMsg;
	String expectedErrorMsg;
	String actualSuccessMsg;
	String expectedSuccessMsg;

	@Given("The user is on the new user registration page")
	public void the_user_is_on_the_new_user_registration_page() {
		registerPage.openURL();
		registerPage.clickGetStartedButton();
		registerPage.clickRegisterLink();
		
	}

	@When("The user clicks Register button with all fields empty on registration form from sheetname {string} and row {int}")
	public void the_user_clicks_register_button_with_all_fields_empty_on_registration_form_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) throws IOException, OpenXML4JException, InterruptedException {
		registerPage.fillRegistrationForm("register", 0);
		registerPage.clickRegisterButton();
	}

	@Then("The error Please fill out this field. appears below Username textbox")
	public void the_error_please_fill_out_this_field_appears_below_username_textbox() {
		String browserValidationmsg = registerPage.switchToElementAndGetValidationMessage();
		String expectedErrorMsg = "Please fill out this field.";
		Assert.assertEquals(browserValidationmsg, expectedErrorMsg);  
		
	}

	// TC02
	@When("The user clicks Register button after entering Username with other fields empty from sheetname {string} and row {int}")
	public void the_user_clicks_register_button_after_entering_username_with_other_fields_empty_from_sheetname_and_row(
			String string, Integer int1) throws IOException, OpenXML4JException, InterruptedException {
		registerPage.fillRegistrationForm("register", 1);
		registerPage.clickRegisterButton();
	}

	@Then("The error message Please fill out this field. appears below Password textbox")
	public void the_error_message_please_fill_out_this_field_appears_below_password_textbox() {
		String browserValidationmsg = registerPage.switchToElementAndGetValidationMessage();
		String expectedErrorMsg = "Please fill out this field.";
		Assert.assertEquals(browserValidationmsg, expectedErrorMsg);
	}

	// TC03
	@When("The user clicks Register button after entering Username and Password leaving Password Confirmation field empty from sheetname {string} and row {int}")
	public void the_user_clicks_register_button_after_entering_username_and_password_leaving_password_confirmation_field_empty_from_sheetname_and_row(
			String string, Integer int1) throws IOException, OpenXML4JException, InterruptedException {
		registerPage.fillRegistrationForm("register", 2);
		registerPage.clickRegisterButton();
	}

	@Then("The error message Please fill out this field. appears below  Password Confirmation textbox")
	public void the_error_message_please_fill_out_this_field_appears_below_password_confirmation_textbox() {
		String browserValidationmsg = registerPage.switchToElementAndGetValidationMessage();
		String expectedErrorMsg = "Please fill out this field.";
		Assert.assertEquals(browserValidationmsg, expectedErrorMsg);
	}

	// TC04
	@When("The user clicks Register button after entering a username with spacebar characters other than digits and symbols from sheetname {string} and row {int}")
	public void the_user_clicks_register_button_after_entering_a_username_with_spacebar_characters_other_than_digits_and_symbols_from_sheetname_and_row(
			String string, Integer int1) throws IOException, OpenXML4JException, InterruptedException {
		registerPage.fillRegistrationForm("register", 3);
		registerPage.clickRegisterButton();
	}

	@Then("The user should be able to see error msg after entering invalid data")
	public void the_user_should_be_able_to_see_error_msg_after_entering_invalid_data() {
		expectedErrorMsg = "password_mismatch:The two password fields didn’t match.";
		actualErrorMsg = registerPage.displayPasswordMismatchError();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}

	// TC05
	@When("The user clicks Register button after entering a password with only numeric data from sheetname {string} and row {int}")
	public void the_user_clicks_register_button_after_entering_a_password_with_only_numeric_data_from_sheetname_and_row(
			String string, Integer int1) throws IOException, OpenXML4JException, InterruptedException {
		registerPage.fillRegistrationForm("register", 4);
		registerPage.clickRegisterButton();
	}

	@Then("The user should be able to see error msg after entering invalid data in password fields")
	public void the_user_should_be_able_to_see_error_msg_after_entering_invalid_data_in_password_fields() {
		expectedErrorMsg = "password_mismatch:The two password fields didn’t match.";
		actualErrorMsg = registerPage.displayPasswordMismatchError();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}

	// TC06
	@When("The user clicks Register button after entering a password with less than eight characters from sheetname {string} and row {int}")
	public void the_user_clicks_register_button_after_entering_a_password_with_less_than_eight_characters_from_sheetname_and_row(
			String string, Integer int1) throws IOException, OpenXML4JException, InterruptedException {
		registerPage.fillRegistrationForm("register", 5);
		registerPage.clickRegisterButton();
	}

	@Then("The user should be able to see error msg after entering less than eight characters")
	public void the_user_should_be_able_to_see_error_msg_after_entering_less_than_eight_characters() {
		expectedErrorMsg = "password_mismatch:The two password fields didn’t match.";
		actualErrorMsg = registerPage.displayPasswordMismatchError();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}

	
	


	// TC07
	@When("The user clicks login link from Registration page")
	public void the_user_clicks_login_link_from_registration_page() {
		registerPage.clickLoginLink();
	}

	@Then("The user should be landed on login page")
	public void the_user_should_be_landed_on_login_page() {
		Assert.assertEquals(introductionpage.getHomePageTitle(), "Login");
	}

	// TC08
	@When("The user clicks Sign in link from Registration page")
	public void the_user_clicks_sign_in_link_from_registration_page() {
		registerPage.clickSignInLink();
	}

}