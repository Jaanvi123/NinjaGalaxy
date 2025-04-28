package dsAlgoPageObjects;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigReader;
import utils.ExcelRead;
import utils.LoggerLoad;

public class RegisterPageObj {

     WebDriver driver;  // WebDriver instance for browser interactions
     ExcelRead excelReader;  // ExcelReader to handle test data
    // Web elements related to the registration page
    @FindBy(xpath = "//a[text()=' Register ']")//register link on home page
    private WebElement registerLink;
    
    @FindBy(xpath = "//a[contains(@href, 'logout')]")//signout button on homepagereeoe
    private WebElement signoutButton;
  
    @FindBy(name = "username")//username box
    private WebElement userNameField;

    @FindBy(name = "password1") //password box
    private WebElement passwordField;

    @FindBy(name = "password2") //password confirmation box
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@type='submit' and @value='Register']")//Rgister button
    private WebElement registerButton;


    @FindBy(xpath = "//div[@class='alert alert-primary']") //error message on register page 
    private WebElement errorMessage;


  

    //  Actions on the page (Methods that perform actions)
    

        public RegisterPageObj(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void navigateToRegisterPage() {
            driver.findElement(By.linkText("Register")).click(); // or however you navigate
        }
    
        
      public void signOut() {
        signoutButton.click();  // Click signout button
    }
    public void clickRegisterbtn() {
        registerButton.click();//Click the register button on register page
    	///((JavascriptExecutor) driver).executeScript("arguments[0].click();
    }
   

    public void enterPassword(String password) {
        passwordField.sendKeys(password);  // Enter the password into the password field
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);  // Enter confirm password
    }
    
    public void registerwithouthCredentials() throws InterruptedException {
		//this.driver = driver; // Set WebDriver instance
		PageFactory.initElements(driver, this); // Initialize elements
		System.out.println("Please fill out this field.");	    
    }
    public void registerdifferentCredentials() throws InterruptedException {
		//this.driver = driver; // Set WebDriver instance
		PageFactory.initElements(driver, this); // Initialize elements
		System.out.println("password_mismatch:The two password fields didn’t match.");	    
    }
    

    // Method to fill the registration form using data from an Excel sheet
    public void fillRegistrationForm(String username ,String password,String confirmPassword ) throws IOException, OpenXML4JException, InterruptedException {
    	PageFactory.initElements(driver, this); 
    	
    	
    	
    	userNameField.sendKeys(username != null ? username : "");
    	    passwordField.sendKeys(password != null ? password : "");
    	    confirmPasswordField.sendKeys(confirmPassword != null ? confirmPassword : "");
    	}
       // LoggerLoad.info("Filling form with -> Username: " + username + ", Password: " + password + ", Confirm Password: " + passwordConfirm);

        // Call methods that already handle null values
        

    public String verifyErrorMessage(String expectedMessage) {
        String actualMessage = errorMessage.getText().trim();  // Get the error message text
        LoggerLoad.info("Actual error message: '" + actualMessage + "'");
        
        // Normalize both expected and actual messages (replace non-breaking spaces and trim)
        actualMessage = actualMessage.replaceAll("\\u00A0", " ").trim();  // Replace non-breaking space with regular space
        expectedMessage = expectedMessage.replaceAll("\\u00A0", " ").trim();

        // Optionally perform assertion here, after normalization
        assertEquals(actualMessage, expectedMessage, "Validation message mismatch!");

        return actualMessage;  // Return the actual error message
    }



   

    // Method to get the validation message for the username field (using JavaScript)
    public String getValidationMessageForUsername() {
//        WebElement usernameField = driver.findElement(By.id("id_username"));  // Locate the username field
        return (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].validationMessage;", userNameField);  // Get the validation message
    }

}
