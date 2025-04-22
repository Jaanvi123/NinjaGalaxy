package stepDefinitions;


import java.io.IOException;


import org.junit.Assert;
import org.openqa.selenium.By;

import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.RegisterPageObj;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import utils.ExcelRead;

public class RegisterStepDefinition extends DriverFactory {
	
	RegisterPageObj registerPage = new RegisterPageObj();
	 HomePageObj homepage = new HomePageObj();
	
	
	
	
	@Given("The User opens Register Page")
	public void the_user_opens_register_page() {
	    DriverFactory.initializeDriver("chrome");  // Pass browser type dynamically
	    registerPage.navigateToRegisterPage();
	    homepage.clickButton();	
	    registerPage.ClickRegisteronHomepage();
	}

	@When("The User clicks {string} button with all fields empty")
	public void the_user_clicks_button_with_all_fields_empty(String string) {
		registerPage.clickRegisterButton();
		
	}

	@Then("It should display an error {string} below Username textbox")
	public void it_should_display_an_error_below_username_textbox(String string) {
	   registerPage.enterUserName();
	   registerPage.enterPassword();
	    registerPage.enterConfirmPassword(string);
	    registerPage.clickRegisterButton();
	    
	}


	@When("The User clicks {string} button after entering different passwords in Password and Password Confirmation fields")
	public void the_user_clicks_button_after_entering_different_passwords_in_password_and_password_confirmation_fields(String string) {
		 registerPage.verifyErrorMessage(string);
		
	}

	@Then("The User should able to see an pwd warning message {string}")
	public void the_user_should_able_to_see_an_pwd_warning_message(String string) {
		
	   
	}
	
	//@When("^User enters valid (.+) (.+) (.+) and clicks Register button$")
	//public void user_enters_valid_username_password_confirm_password_and_clicks_register_button(String string1,String string2,String string3) throws IOException {
	
	@When("User enters valid username, password,confirm_password and clicks Register button from row {int}")
	public void user_enters_valid_username_password_confirm_password_and_clicks_register_button_from_row(Integer int1) throws IOException {
	  ExcelRead reader = new ExcelRead();
/*		List<Map<String,String>> excelData = reader.readExcelSheet();
		    String username = excelData.get(int1).get("username");
	        System.out.println("username is "+ username);
	        String password = excelData.get(int1).get("password");
	        System.out.println("password is "+ password);
	        String confirm_password = excelData.get(int1).get("confirm_password");
	         System.out.println("confirm_password is "+ confirm_password);
	
	    
	    registerPage.setUserName(username);
		registerPage.setpassword(password);
		registerPage.setConfirmPassword(confirm_password);
		registerPage.clickRegisterButton();   */
	}


	
	@Then("The User should be redirected to HomePage of DS_Algo")
	public void the_user_should_be_redirected_to_home_page_of_ds_algo() {
		homepage = new HomePageObj();
		
	}
	
	@Then("The User should able to see successful message {string}  on the DS_Algo HomePage")
	public void the_user_should_able_to_see_successful_message_on_the_ds_algo_home_page(String string) {
	    String successMessage = homepage.RegisterSuccess();
	    Assert.assertNotNull(successMessage, "Success message is null!");
	    Assert.assertTrue(successMessage.contains(string));
	}

	@Then("user clicks on signout")
	public void user_clicks_on_signout() {
		registerPage.clickSignOut();
	}



}