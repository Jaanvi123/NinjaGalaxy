package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.LoginPageObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import utils.ExcelRead;

public class LoginStepDefinition extends DriverFactory {
	WebDriver driver= DriverFactory.getDriver(); 
	public  LoginPageObj login= new  LoginPageObj(driver);
	HomePageObj homepage = new HomePageObj();
	ConfigReader configReader = new ConfigReader();
	
	@Given("The user is on the DS Algo Sign in Page")
	public void the_user_is_on_the_ds_algo_sign_in_page() {
	   homepage.clickButton();	
	   login.clicksign_in();
	}

	@When("The user clicks login button after leaving the <username> textbox and <password> textbox blank")
	public void the_user_clicks_login_button_after_leaving_the_username_textbox_and_password_textbox_blank() {
		login.clicklogin();
	}

	@Then("The error message {string} appears below Username textbox")
	public void the_error_message_appears_below_username_textbox2(String string) {
	   String contextmessage= login.verifyContextMessage();
	   System.out.println(contextmessage);
	   Assert.assertEquals(contextmessage, string);
	  	
	}

	@Given("user is on the DS Algo Sign in Page")
	public void user_is_on_the_ds_algo_sign_in_page2() {
		configReader.getUrlHome();
	   login.clicksign_in();
	}

@And("^The user clicks login button after entering the userName and leaves password textbox blank (.*) (.*)$")
	public void the_user_clicks_login_button_after_entering_the_abschallengers_and_leaves_textbox_blank(int rowNumber, String sheetName) throws IOException {
	
	ExcelRead reader = new ExcelRead();
	List<Map<String,String>> excelData = reader.readExcelSheet(sheetName);
	String username = excelData.get(rowNumber).get("username");
	System.out.println("username is "+ username);
	login.enterUserName(username);
	login.clicklogin();
		
	}

	@Then("The error message {string} appears below Pwd textbox")
	public void the_error_message_appears_below_pwd_textbox(String string) {
	 String contextmsg=  login.verifyContextMessage1();
	 System.out.println(contextmsg);
	   Assert.assertEquals(contextmsg, string);
	}

	@Given("user is on  DS Algo Sign in Page")
	public void user_is_on_ds_algo_sign_in_page3() {
	    login.clicksign_in();
	}

	@When("^The user clicks login button after entering the passWord only (.*) (.*)$")
	public void the_user_clicks_login_button_after_entering_the_numpyninja17_only(int rowNumber, String sheetName ) throws IOException {
		
		ExcelRead reader = new ExcelRead();
	//	List<Map<String,String>> excelData = reader.readExcelSheet(sheetName);
	//	String password = excelData.get(rowNumber).get("password");
	//	System.out.println("password is "+ password);
		
	//	login.enterPassWord(password);
	//	login.clicklogin();
	   }
	@Then("The error message {string} appears below username textbox")
	public void the_error_message_appears_below_username_textbox(String string) {
		 String contextmsg=  login.verifyContextMessage();
		 System.out.println(contextmsg);
		 System.out.println(string);
		   Assert.assertEquals(contextmsg, string);
	}

	@Given("user lands on DS Algo Sign in page")
	public void user_lands_on_ds_algo_dign_in_page() {
		login.clicksign_in();
	    }

	@When("^The user clicks login button after entering invalid UserName and invalid PassWord (.*) (.*)$")
	public void the_user_clicks_login_button_after_entering_invalid_abs_and_invalid_numpy17(int rowNumber,String sheetName) throws IOException {
		ExcelRead reader = new ExcelRead();
	/*	List<Map<String,String>> excelData = reader.readExcelSheet(sheetName);
		String username = excelData.get(rowNumber).get("username");
		System.out.println("username is "+ username);
		String password = excelData.get(rowNumber).get("password");
		System.out.println("password is "+ password);
		
		
		login.enterUserNamePassWrd(username, password);
		login.clicklogin();   */
	   
	}

	@Then("The error message {string}. appears below Username textbox")
	public void the_error_message_appears_below_username_textbox1(String string) {
		String alertmsg=login.AlertMsg();
		System.out.println(alertmsg);
		Assert.assertEquals(alertmsg, string);
	    
	}

	@Given("The  user land on DS Algo Sign in page")
	public void the_user_lands_on_ds_algo_dign_in_page() {
	    login.clicksign_in();
	}

//	@When("^The user clicks login button after entering valid (.*)and valid (.*)$")
//	public void the_user_clicks_login_button_after_entering_valid_username_and_valid_password(String UserName, String PassWord ) {
//		login.ValidenterUserNamePassWrd(UserName, PassWord);
//		login.clicklogin();
//	}

	@Then("The user should land in Data Structure Home Page {string}")
	public void the_user_should_land_in_data_structure_home_page(String string) {
	   String validmsg= login.validatemessage();
	   System.out.println(validmsg);
	   Assert.assertEquals(validmsg, string);
	}
	
	@When("^The user clicks login button after entering valid UserName and valid PassWord (.*) (.*)$")
	public void user_enters_valid_username_password_confirm_password_and_clicks_register_button_from_row(Integer rowNumber, String sheetName) throws IOException {
		ExcelRead reader = new ExcelRead();
	/*	List<Map<String,String>> excelData = reader.readExcelSheet(sheetName);
		    String username = excelData.get(rowNumber).get("username");
	        System.out.println("username is "+ username);
	        String password = excelData.get(rowNumber).get("password");
	        System.out.println("password is "+ password);
	        
	        login.ValidenterUserNamePassWrd(username, password);
	        login.clicklogin();    */
	}




}