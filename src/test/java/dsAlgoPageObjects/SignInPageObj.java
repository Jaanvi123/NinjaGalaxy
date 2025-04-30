package dsAlgoPageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import utils.ConfigReader;
import utils.ExcelRead;
import utils.LoggerLoad;


public class SignInPageObj {
	
	 WebDriver driver;
	 ExcelRead excelReader = new ExcelRead();
	 ConfigReader configReader = new ConfigReader();
	 
	 @FindBy(xpath = "//input[@name ='username']") WebElement UsernameTextBox;
	 @FindBy(xpath = "//input[@name ='password']") WebElement PassowrdTextBox;
	 @FindBy(xpath= "//input[@value='Login']") WebElement loginButton;
	 @FindBy(xpath = "/html/body/div[2]")WebElement homePagemsg ;
	 
	 public SignInPageObj(WebDriver driver) {
		 this.driver= driver;
	 }
	 public void enterUsernameText(String Username) {
		 String name= configReader.getUserName();
		 PageFactory.initElements(driver, this);
		UsernameTextBox.sendKeys(name);
		
			
		}
		public void enterPasswordText(String password) {
			String pwd = configReader.getPassword();
			PageFactory.initElements(driver, this);
			PassowrdTextBox.sendKeys(pwd);
		    }
		public void clickloginButton() {
			PageFactory.initElements(driver, this);
			loginButton.click();
		   	}
		
		public void homePagemsg() {
			homePagemsg.getText();
			LoggerLoad.info(homePagemsg.getText());	
		}
		public void loginWithValidCredentials() throws InterruptedException {
			//this.driver = driver; // Set WebDriver instance
			PageFactory.initElements(driver, this); // Initialize elements
			LoggerLoad.info("Button clicked successfully");	    
	    }
		public void enterLoginDetails(String username, String password)
				throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
			PageFactory.initElements(driver, this); 
			UsernameTextBox.sendKeys(username);
			PassowrdTextBox.sendKeys(password);
		
			
		}	 
		
		public void enterLoginFormFields(String sheetname, int row)
				throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
			LoggerLoad.info("Inside enterLoginFormFields");
	
			List<Map<String, String>> testdata = excelReader.readFromExcel("src/test/resources/TestData/TestingData.xlsx", sheetname);
			LoggerLoad.info("logintestdata");
		
			
			String username = testdata.get(row).get("username");
			enterUsernameText(username);
			LoggerLoad.info("Fetched username from Excel: " + username);
			
			String password = testdata.get(row).get("password");
			LoggerLoad.info("Fetched password from Excel: " + password);
			enterPasswordText(password);
			
			LoggerLoad.info("Read from Excel sheet");
		}	
		
		
		
		
		
		
		
		
		
		
}