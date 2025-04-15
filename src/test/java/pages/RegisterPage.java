package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement registerLink;

    @FindBy(id = "id_username")
    public WebElement username;

    @FindBy(id = "id_password1")
    public WebElement password1;

    @FindBy(id = "id_password2")
    public WebElement password2;

    @FindBy(xpath = "//input[@type='submit' and @value='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//div[@class='alert alert-primary' and @role='alert']")
    public WebElement alertMessage;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginLink;

    // Common action method
    public void register(String user, String pass1, String pass2) {
        username.sendKeys(user);
        password1.sendKeys(pass1);
        password2.sendKeys(pass2);
        registerButton.click();
    }
}
