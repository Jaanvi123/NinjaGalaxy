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
	 
	 @FindBy(id ="id_username") WebElement UsernameTextBox;
	 @FindBy(id = "id_password") WebElement PassowrdTextBox;
	 @FindBy(xpath= "//input[@value='Login']") WebElement loginButton;
	 
	 public void enterUsernameText(String username) {
		UsernameTextBox.sendKeys(username);
			
		}
		public void enterPasswordText(String password) {
			PassowrdTextBox.sendKeys(password);
		    }
		public void clickloginButton() {
			loginButton.click();
		   	}
		
		public void loginWithValidCredentials() throws InterruptedException {
			//this.driver = driver; // Set WebDriver instance
			PageFactory.initElements(driver, this); // Initialize elements
			System.out.println("Button clicked succefullyt");	    
	    }
		public void enterLoginFormFields(String sheetname, int row)
				throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
			LoggerLoad.info("Inside enterLoginFormFields");
	
			List<Map<String, String>> testdata = excelReader.readExcelSheet("src/test/resources/TestData/TestData.xlsx" );
			LoggerLoad.info("logintestdata");
		
			
			String username = testdata.get(row).get("username");
			enterUsernameText(username);
			LoggerLoad.info("Fetched username from Excel: " + username);
			
			String password = testdata.get(row).get("password");
			LoggerLoad.info("Fetched password from Excel: " + password);
			enterPasswordText(password);
		}	
}