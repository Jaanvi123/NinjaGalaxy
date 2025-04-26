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
	private String message;

	String URL = ConfigReader.getUrl();
	String homeURL = ConfigReader.getUrlHome();

	// DsAlgo page
	@FindBy(xpath = "//div[@class='content']/p")WebElement HomePageMessage;
	@FindBy(xpath = "//button[@class='btn']")WebElement GetStartedButton;
	
	// alert
	@FindBy(xpath = "//div[@class='alert alert-primary']")WebElement RegisterMsg;

	// Constructor to initialize elements
	public HomePageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openUrl() {
		PageFactory.initElements(driver, this);
	driver.get(ConfigReader.getUrl());
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

	public String registerSuccess() {
		return RegisterMsg.getText();
	}
	
	
	public void openHomeUrl() {
		PageFactory.initElements(driver, this);
	//	String homeURL = ConfigReader.getUrlHome();
		driver.get(ConfigReader.getUrlHome());
		LoggerLoad.info("Inside Home URL");
	}
}
