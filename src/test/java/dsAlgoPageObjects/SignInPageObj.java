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
import utils.ExcelRead;
import utils.LoggerLoad;


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
		 PageFactory.initElements(driver, this);
		UsernameTextBox.sendKeys(username);
			
		}
		public void enterPasswordText(String password) {
			PageFactory.initElements(driver, this);
			PassowrdTextBox.sendKeys(password);
		    }
		public void clickloginButton() {
			PageFactory.initElements(driver, this);
			loginButton.click();
		   	}
		
		public void homePagemsg() {
			homePagemsg.getText();
			System.out.println(homePagemsg.getText());	
		}
		public void loginWithValidCredentials() throws InterruptedException {
			//this.driver = driver; // Set WebDriver instance
			PageFactory.initElements(driver, this); // Initialize elements
			System.out.println("Button clicked successfully");	    
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
			
			System.out.print("Read from Excel sheet");
		}	
		
		
		
		
		
		
		
		
		
		
}