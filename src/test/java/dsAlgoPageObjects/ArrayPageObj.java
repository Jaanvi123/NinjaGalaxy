package dsAlgoPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ExcelRead;
import utils.LoggerLoad;

public class ArrayPageObj {
    WebDriver driver;
    ExcelRead excelReader = new ExcelRead();
    public ArrayPageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes the @FindBy elements
    }

    @FindBy(xpath = "//div[h5[text()='Array']]//a[text()='Get Started']")
    public WebElement arrayGetStartedButton;

    @FindBy(xpath = "//a[@href='arrays-in-python']")
    public WebElement arraysInPythonLink;

    @FindBy(xpath = "//a[@href='arrays-using-list']")
    public WebElement arraysUsingListLink;

    @FindBy(xpath = "//a[@href='basic-operations-in-lists']")
    public WebElement basicOperationsInListsLink;

    @FindBy(xpath = "//a[@href='applications-of-array']")
    public WebElement applicationsOfArrayLink;

    @FindBy(linkText = "Practice Questions")
    public WebElement practiceQuestionsLink;

    @FindBy(xpath = "//a[@href='/question/1']")
    public WebElement searchTheArrayLink;

    @FindBy(xpath = "//a[@href='/question/2']")
    public WebElement maxConsecutiveOnes;

    @FindBy(xpath = "//a[@href='/question/3']")
    public WebElement findNumWithEvenNumOfDigits;

    @FindBy(xpath = "//a[@href='/question/4']")
    public WebElement squaresOfAsortedArray;

    @FindBy(xpath = "//button[text()='Run']")
    public WebElement runButton;

    @FindBy(xpath = "/html/body/div/div/form/input[@type='submit']")
    public WebElement submitButton;

    public void clickarrayGetStartedBtn() {
        arrayGetStartedButton.click();
        LoggerLoad.info("Clicking the Array Get Started link");
    }

    public void clickarraysInPythonLink() {
        arraysInPythonLink.click();
        LoggerLoad.info("Clicking Arrays in Python link");
    }

    public void clickarraysUsingListLink() {
        arraysUsingListLink.click();
        LoggerLoad.info("Clicking Arrays Using List link");
    }

    public void clickbasicOperationsInListsLink() {
        basicOperationsInListsLink.click();
        LoggerLoad.info("Clicking Basic Operations In Lists link");
    }

    public void clickapplicationsOfArrayLink() {
        applicationsOfArrayLink.click();
        LoggerLoad.info("Clicking Applications Of Array link");
    }

    public void clickPracticeQuestionsLink() {
        practiceQuestionsLink.click();
        LoggerLoad.info("Practice Questions link clicked");
    }

    public void clickSearchTheArrayLink() {
        searchTheArrayLink.click();
        LoggerLoad.info("Clicking Search the Array link");
    }

    public void clickMaxConsecutiveOnes() {
        maxConsecutiveOnes.click();
        LoggerLoad.info("Clicking Max Consecutive Ones link");
    }

    public void clickFindNumWithEvenNumOfDigits() {
        findNumWithEvenNumOfDigits.click();
        LoggerLoad.info("Clicking Find Numbers with Even Number of Digits link");
    }

    public void clickSquaresOfASortedArray() {
        squaresOfAsortedArray.click();
        LoggerLoad.info("Clicking Squares of a Sorted Array link");
    }
}
