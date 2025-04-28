package dsAlgoPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LoggerLoad;

public class DataStructurePageObj {

    WebDriver driver;

    public DataStructurePageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Get Started') and contains(@href, 'data-structures-introduction')]")
    private WebElement dsGetStartedBtn;

    @FindBy(xpath = "//a[contains(@href, 'time-complexity')]")
    private WebElement timeComplexityLink;

    @FindBy(xpath = "//a[contains(text(),'Practice Questions')]")
    private WebElement practiceQuestionsLink;

    @FindBy(xpath = "//h4[text()='Data Structures-Introduction']")
	public WebElement dsPageTitle;

//	WebElement dataStructuresHeader = driver.findElement(By.xpath("//h4[@class='bg-secondary text-white']"));
//    WebElement timeComplexityText = driver.findElement(By.xpath("//p[@class='bg-secondary text-white']"));
   
//    
//    @FindBy(xpath = "//p[@class='bg-secondary text-white']")
//    	public WebElement timeComplexityTitle;
//    public string validatePageTitle
    public void clickGetStartedBtn() {
        dsGetStartedBtn.click();
        LoggerLoad.info("DS Get Started Button Clicked");
    }

    public void clickTimeComplexityLink() {
        timeComplexityLink.click();
        LoggerLoad.info("Time Complexity link clicked");
    }

    public void clickPracticeQuestionsLink() {
        practiceQuestionsLink.click();
        LoggerLoad.info("Practice Questions link clicked");
    }
    public String getcurrentpageUrl()
	{
		System.out.println(driver.getCurrentUrl());
		return(driver.getCurrentUrl());
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

    public Integer getElementSize(WebElement element) {
        return element.isDisplayed() ? 1 : 0;
    }
}
