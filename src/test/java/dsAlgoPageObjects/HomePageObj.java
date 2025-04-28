package dsAlgoPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driverManager.DriverFactory;
import utils.ConfigReader;
import utils.LoggerLoad;

public class HomePageObj {
	
	
	public HomePageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver = DriverFactory.getDriver();
	private String message;

	String URL = ConfigReader.getUrl();
	String homeURL = ConfigReader.getUrlHome();

	// DsAlgo page
	@FindBy(xpath = "//div[@class='content']/p")WebElement HomePageMessage;
	@FindBy(xpath = "//button[@class='btn']")WebElement GetStartedButton;
	
	// alert
	@FindBy(xpath = "//div[@class='alert alert-primary']")WebElement RegisterMsg;
	@FindBy(xpath = "//a[@href='/logout']")WebElement SignOut;
	
	// Constructor to initialize elements


	public void openUrl() {
		driver.get(ConfigReader.getUrl());
		LoggerLoad.info("Inside openURL");
	}

	public void openHomeUrl() {
		driver.get(ConfigReader.getUrlHome());
		LoggerLoad.info("Inside openURL");
	}
	public String getMessage() {
		message = HomePageMessage.getText(); 
		return message;
	}

	public void clickGetStartedHomePageButton() {
		GetStartedButton.click();
	}

	public String getTitle() {
		return driver.getTitle();
	}
	public void SignOut() {
	SignOut.click();
	}
	public String registerSuccess() {
		return RegisterMsg.getText();
	}
	public String getRegisterSuccessMessage() {
	    WebElement alertElement = driver.findElement(By.cssSelector("div.alert.alert-primary"));
	    return alertElement.getText().trim(); // trim to remove extra spaces/newlines
	}
	 public void succesMessage() throws InterruptedException {
			//this.driver = driver; // Set WebDriver instance
			PageFactory.initElements(driver, this); // Initialize elements
			System.out.println("You are logged in");	    
	    }

	 public String getTextForElement(By locator) {
			String elementText = driver.findElement(locator).getText();
			return elementText;
	    
	 }	

}