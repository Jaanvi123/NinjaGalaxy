
package dsAlgoPageObjects;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.LoggerLoad;

public class DataStructurePageObj {
	  WebDriver driver;

	public DataStructurePageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath = "//a[@href='data-structures-introduction']") WebElement dsGetStartedBtn;
	@FindBy(xpath = "//a[@href='/data-structures-introduction/practice']") WebElement practiceQuestionsLink;
	@FindBy(xpath = "//a[@href='time-complexity']") WebElement timeComplexityLink;

	public void clickGetStartedBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement getStartedButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[contains(@class,'btn') and contains(text(),'Get Started')]")));
		getStartedButton.click();
		LoggerLoad.info("DS Get Started Button Clicked");
	}

	public void clickPracticeQuestionsLink() {
		practiceQuestionsLink.click();
		LoggerLoad.info("Practice Questions link clicked");
	}

<<<<<<< Updated upstream
	public void getcurrentpageUrl() {

		String actualUrl = driver.getCurrentUrl();
		LoggerLoad.info("Current URL after login: " + actualUrl);
		String expectedUrl = ConfigReader.getProperty("DSPageUrl"); 
		assertEquals(expectedUrl, actualUrl);

=======
	public void logCurrentPageUrl() {
	    String currentUrl = driver.getCurrentUrl();
	    LoggerLoad.info("Current URL after login: " + currentUrl);
>>>>>>> Stashed changes
	}


	public WebElement getTimeComplexityLink() {
		return timeComplexityLink;
	}

	public void ClickTimeComplexityLink() {
		timeComplexityLink.click();
		LoggerLoad.info("Time Complexity Link Clicked");
	}

	public Boolean validateElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public String getTextForElement(WebElement element) {
		return element.getText();
	}


}
