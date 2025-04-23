package dsAlgoPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driverManager.DriverFactory;
import utils.ConfigReader;

public class HomePageObj {    
	WebDriver driver= DriverFactory.getDriver(); 
		private String message;
	
		String URL=ConfigReader.getUrl();
		String homeURL=ConfigReader.getUrlHome();
		
		
		//Dsalgo page
		@FindBy(xpath = "//div[@class='content']/p")WebElement HomePageMessage;  
    	@FindBy(xpath = "//button[@class='btn']")WebElement GetStartedButton;
    	//alert
    	@FindBy(xpath = "//div[@class='alert alert-primary']")WebElement RegisterMsg;
    
    
    // Constructor to initialize elements
		public HomePageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
	
    public String getMessage() {
    	message = HomePageMessage.getText(); // Assign value before returning
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
}
 


