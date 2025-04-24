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
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.SignInPageObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import utils.ExcelRead;

public class SignInStepDefinition {
	WebDriver driver= DriverFactory.getDriver(); 
	SignInPageObj signin= new  SignInPageObj();
	ConfigReader configReader = new ConfigReader();
	IntroductionPageObj introductionpage = new IntroductionPageObj();
	HomePageObj homepage = new HomePageObj(driver) ;
	
	@Given("The user is on the DS Algo Sign in Page")
	public void the_user_is_on_the_ds_algo_sign_in_page() {
		homepage.clickGetStartedHomePageButton();
		
		introductionpage.clicklink(driver);
		introductionpage.clickSignInLink();
	}

	@When("The user clicks login button after leaving the Username textbox and Password textbox empty")
	public void the_user_clicks_login_button_after_leaving_the_username_textbox_and_password_textbox_empty()  throws InterruptedException {
		signin.loginWithValidCredentials();
		signin.clickloginButton();
		}

	
	  	
	}

	
