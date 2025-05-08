package dsAlgoPageObjects;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driverManager.DriverFactory;
import utils.ConfigReader;
import utils.LoggerLoad;

public class GraphPageObj {
	WebDriver driver = DriverFactory.getDriver();
	String URL = ConfigReader.getUrl();
	String homeURL = ConfigReader.getUrlHome();

	@FindBy(xpath = "//h4[@class='bg-secondary text-white']")WebElement GraphPageTitle;
	@FindBy(xpath = "//a[@href='graph']")WebElement InsideGraphLink;
	@FindBy(xpath = "//a[@href='graph-representations']")
	WebElement GraphRpresentationsLink;

	@FindBy(xpath = "//a[@href='/graph/practice']")
	WebElement GraphPracticeQuestionsLink;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement GraphTryHereLink;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement GraphRunButtonLink;

	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[6]")
	WebElement CodeEditor;
	@FindBy(xpath = "//pre[@id='output']")
	WebElement CodeEditorOutput;

	public GraphPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void GraphTitle() {
		PageFactory.initElements(driver, this);
		GraphPageTitle.getText();
		LoggerLoad.info(" Page title is " + GraphPageTitle);
	}

	public void GraphPageTitle() {
	    ConfigReader.getProperty("GraphPageUrl");
		LoggerLoad.info("Graph Page title:" + driver.getCurrentUrl());
	}

	public String getcurrentpageUrl() {
		System.out.println(driver.getCurrentUrl());
		return (driver.getCurrentUrl());
	}

	public void ClickInsideGraphkLink() {
		PageFactory.initElements(driver, this);
		InsideGraphLink.click();
		LoggerLoad.info("Inside Graph Link is clicked");
	}

	public void ClickGraphRepresentationLink() {
		PageFactory.initElements(driver, this);
		GraphRpresentationsLink.click();
		LoggerLoad.info("Graph Rpresentations Link is clicked");
	}

	public void clickPracticeQuestionsLink() {
		PageFactory.initElements(driver, this);
		new WebDriverWait(driver, Duration.ofSeconds(20));
				GraphPracticeQuestionsLink.click();
		LoggerLoad.info("Practice Questions Link clicked");
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public void codeEditorOutput() {
		CodeEditorOutput.getText();
		LoggerLoad.info("Code editor Output is :" + CodeEditorOutput.getText());
	}

	public void clickGraphTryHereButton() {
		PageFactory.initElements(driver, this);
		GraphTryHereLink.click();
		LoggerLoad.info("Try here button is clicked");
	}

	public void clickGraphRunButton() {
		PageFactory.initElements(driver, this);
		GraphRunButtonLink.click();
		LoggerLoad.info("Run button is clicked");
	}

	public void validateTextEditorBox() {

		String Code = "print('Python is fun!')";
		PageFactory.initElements(driver, this);
		CodeEditor = driver.switchTo().activeElement();
		Actions actions = new Actions(driver);
		actions.moveToElement(CodeEditor).click().perform();
		CodeEditor.sendKeys(Code);
		clickGraphRunButton();
		validateCodeEditorOutput();
	}

	public void validateCodeEditorOutput() {
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(CodeEditorOutput));
		String message = CodeEditorOutput.getText();
		System.out.println("Code Printed Successfully " + message);
	}

	public void HandleAlert() {
		PageFactory.initElements(driver, this);
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		LoggerLoad.info("Alert message: " + alertMessage);
		alert.accept();
		System.out.println("Alert message:" + alertMessage);
	}

	public void InvalidCode() {
		String invalidCode = "This is a test message !";
		PageFactory.initElements(driver, this);
		CodeEditor = driver.switchTo().activeElement();
		Actions actions = new Actions(driver);
		actions.moveToElement(CodeEditor).click().perform();
		CodeEditor.sendKeys(invalidCode);
		clickGraphRunButton();
		HandleAlert();

	}
}
