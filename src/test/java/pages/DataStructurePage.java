package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataStructurePage {
	

	
 
	    WebDriver driver;

	    public void DataStructuresIntroductionPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Web elements
	    @FindBy(xpath = "//a[@href='data-structures-introduction']")
	    WebElement getStartedButton;

	    @FindBy(xpath = "//a[@href='time-complexity' and @class='list-group-item']")
	    WebElement timeComplexityLink;

	    @FindBy(xpath = "//a[@href='/data-structures-introduction/practice' and contains(@class, 'list-group-item')]")
	    WebElement practiceQuestionsLink;

	    // Actions
	    public void clickGetStarted() {
	        getStartedButton.click();
	    }

	    public void clickTimeComplexity() {
	        timeComplexityLink.click();
	    }

	    public void clickPracticeQuestions() {
	        practiceQuestionsLink.click();
	    }
	}


