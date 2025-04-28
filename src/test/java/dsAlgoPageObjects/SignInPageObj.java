package dsAlgoPageObjects;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ExcelRead;


public class SignInPageObj {
	
	 WebDriver driver;
	 ExcelRead excelReader = new ExcelRead();
	 
	 @FindBy(xpath = "//input[@name ='username']") WebElement UsernameTextBox;
	 @FindBy(xpath = "//input[@name ='password']") WebElement PassowrdTextBox;
	 @FindBy(xpath= "//input[@value='Login']") WebElement loginButton;
	 @FindBy(xpath = "/html/body/div[2]")WebElement homePagemsg ;
	 
	 public SignInPageObj(WebDriver driver) {
		 this.driver= driver;
	 }
	 public void enterUsernameText(String username) {
		UsernameTextBox.sendKeys(username);
			
		}
		public void enterPasswordText(String password) {
			PassowrdTextBox.sendKeys(password);
		    }
		public void clickloginButton() {
			loginButton.click();
		   	}
		
		public void homePagemsg() {
			homePagemsg.getText();
		}
		public void loginWithValidCredentials( String username,String password) throws InterruptedException {
			//this.driver = driver; // Set WebDriver instance
			PageFactory.initElements(driver, this); // Initialize elements
			enterUsernameText(username);
			enterPasswordText(password);
			clickloginButton();
			System.out.println("Login successfully");	    
	    }
		public void enterLoginFormFields(String username, String password)
				throws InvalidArgumentException, IOException, OpenXML4JException, InterruptedException {
			PageFactory.initElements(driver, this); 
			UsernameTextBox.sendKeys(username);
			PassowrdTextBox.sendKeys(password);
		
			
			
		}	  
}