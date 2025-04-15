package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "btn")
    public WebElement getStartedBtn;

    @FindBy(xpath = "//a[contains(@class, 'dropdown-toggle')]")
    public WebElement dropdown;

    @FindBy(xpath = "//div[contains(@class,'alert') and contains(text(),'You are not logged in')]")
    public WebElement notLoggedInAlert;

    public void clickGetStarted() {
        getStartedBtn.click();
    }

    public void clickDropdown() {
        dropdown.click();
    }

    public boolean isAlertDisplayed() {
        return notLoggedInAlert.isDisplayed();
    }

    public WebElement getDropdownOption(String option) {
        return driver.findElement(By.xpath("//a[@class='dropdown-item' and text()='" + option + "']"));
    }
}
