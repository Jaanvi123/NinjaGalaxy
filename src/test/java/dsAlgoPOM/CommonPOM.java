package dsAlgoPOM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;
import utils.LoggerLoad;

public class CommonPOM {


	private WebDriver driver;
		    
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 

	WebElement getStartedButton = driver.findElement(By.cssSelector("button.btn"));
	WebElement  contentHeader = driver.findElement(By.cssSelector(".content h1"));
	
	WebElement  contentText = driver.findElement(By.cssSelector("div.content p"));
	WebElement  signOutLink = driver.findElement(By.xpath("//a[@href='/logout']"));

	public void openURL() {
		driver.get(ConfigReader.getUrl());
		LoggerLoad.info("Inside openURL");

	}
	
	
	public void openPracticeQnsPageUrl(String url) {
        driver.get(url);
    }

	public void ClickHomePageGetStartedButton() {
		getStartedButton.click();
		LoggerLoad.info("Before ClickHomePageGetStartedButton");
	}

	public WebElement linkClickable(By locator) {
    	return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}
	
    public void openHomeURL() {
    	ConfigReader.getUrlHome();
    	LoggerLoad.info("Inside openURL");
    		
    }
    public void openUrlTree() {
    	driver.get(ConfigReader.getUrlTree());
    	LoggerLoad.info("Tree URL opened");	
    }
        
      
 	public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}

   	
	

	

}

	
