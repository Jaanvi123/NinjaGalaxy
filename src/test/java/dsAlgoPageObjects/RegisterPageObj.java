package dsAlgoPageObjects;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import driverManager.DriverFactory;
import utils.ConfigReader;

public class RegisterPageObj {

	WebDriver driver = DriverFactory.getDriver();  
 //   private String baseUrl = "https://dsportalapp.herokuapp.com/register";  // Define URL explicitly
	public String baseUrl =ConfigReader.getUrl();
	private By Registerlink = By.xpath("//a[text()=' Register ']");
    private By userName = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password1']");
    private By confirmPassword = By.xpath("//input[@name='password2']");
    private By registerButton = By.xpath("//input[@value='Register']");
    private By errorMsg = By.xpath("//div[contains(@class, 'error-message')]");
    private By registeredName = By.xpath("//div[contains(text(),'New Account Created')]");
    private By signOut = By.xpath("//a[contains(@href, 'logout')]");
    private By startBtn = By.xpath("//button[@class='btn']");

  public void navigateToRegisterPage() {
        driver.get(baseUrl);
    }
  public void ClickRegisteronHomepage() {
      driver.findElement(Registerlink).click();
  }
   

    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = driver.findElement(errorMsg).getText();
        System.out.println(actualMessage);
        assertEquals(actualMessage, expectedMessage);
    }

    public void enterUserName() {
        driver.findElement(userName).sendKeys(ConfigReader.getUserName());
    }

    public void enterPassword() {
        driver.findElement(password).sendKeys(ConfigReader.getPassword());
    }

    public void enterConfirmPassword(String confirmPasswordText) {
        driver.findElement(confirmPassword).sendKeys(confirmPasswordText);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void verifyUserNameError(String expectedErrorMessage) {
        String actualValidationMessage = driver.findElement(userName).getAttribute("validationMessage");
        System.out.println(actualValidationMessage);
        assertEquals(actualValidationMessage, expectedErrorMessage);
    }

    public void clickSignOut() {
        driver.findElement(signOut).click();
    }
}
