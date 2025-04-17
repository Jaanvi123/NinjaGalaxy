package dsAlgoPOM;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import driverManager.DriversBase;
import utils.ExcelRead;
import utils.LoggerLoad;

public class LoginPage {

	WebDriver driver = DriversBase.getDriver();
	ExcelRead excelReader = new ExcelRead();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
		
	WebElement  usernameTextBox = driver.findElement(By.id("id_username"));
	WebElement  passwordTextBox = driver.findElement(By.id("id_password"));
	WebElement  loginBtn =   driver.findElement(By.xpath("//input[@value='Login']"));
	WebElement alertMsg = driver.findElement(By.cssSelector(".alert.alert-primary"));
	
	
	public void enterUsernameTxt(String username) {
		usernameTextBox.sendKeys(username);
		
	}
	public void enterPasswordTxt(String password) {
	    	passwordTextBox.sendKeys(password);
	    }
	public void clickloginBtn() {
	    	loginBtn.click();
	    }
	
    public void loginWithValidCredentials(String username, String password) throws InterruptedException {
	    	usernameTextBox.sendKeys(username);
	    	passwordTextBox.sendKeys(password);
	    	loginBtn.click();
	    }
	 
	public void passwordTextField(String password) {
			passwordTextBox.sendKeys(password);
		}

		public void enterLoginFormFields(String sheetname, int row)
				throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
			LoggerLoad.info("Inside enterLoginFormFields");
	
			List<Map<String, String>> testdata = excelReader.readFromExcel("src/test/resources/TestData/TestingData.xlsx", sheetname);
			LoggerLoad.info("logintestdata");
		
			
			String username = testdata.get(row).get("username");
			enterUsernameTxt(username);
			LoggerLoad.info("Fetched username from Excel: " + username);
			
			String password = testdata.get(row).get("password");
			LoggerLoad.info("Fetched password from Excel: " + password);
			enterPasswordTxt(password);
		}	

}


