package dsAlgoPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driverManager.DriverFactory;
import utils.ConfigReader;
import utils.LoggerLoad;

public class HomePageObj {
	WebDriver driver = DriverFactory.getDriver();
	String URL = ConfigReader.getUrl();
	String homeURL = ConfigReader.getUrlHome();
	String expectedMessage = "You are not logged in";
	
	@FindBy(xpath = "//div[@class='content']/p")WebElement HomePageMessage;
	@FindBy(xpath = "//button[@class='btn']")WebElement GetStartedButton;
	@FindBy(xpath = "//div[@class='alert alert-primary']")WebElement RegisterMsg;

	public HomePageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openUrl() {
		driver.get(ConfigReader.getUrl());
		LoggerLoad.info("Inside openURL");
	}
	
	public String getMessage() {
		String message = HomePageMessage.getText(); 
		return message;
	}

	public void clickGetStartedHomePageButton() {
		PageFactory.initElements(driver, this);
		GetStartedButton.click();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String registerSuccess() {
		return RegisterMsg.getText();
	}
		
	public void openHomeUrl() {
		PageFactory.initElements(driver, this);
		driver.get(ConfigReader.getUrlHome());
		LoggerLoad.info("Inside Home URL");
	}
}