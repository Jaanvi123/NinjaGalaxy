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

public class TreePageObj {

	WebDriver driver = DriverFactory.getDriver();

	String URL = ConfigReader.getUrl();
	String homeURL = ConfigReader.getUrlHome();

	@FindBy(xpath = "//a[@href='overview-of-trees']")
	WebElement Overviewoftrees;
	@FindBy(xpath = "//a[@href='terminologies']")
	WebElement Terminologies;
	@FindBy(xpath = "//a[@href='types-of-trees']")
	WebElement TypesofTrees;
	@FindBy(xpath = "//a[@href='tree-traversals']")
	WebElement TreeTraversals;
	@FindBy(xpath = "//a[@href='traversals-illustration']")
	WebElement TraversalsIllustrations;
	@FindBy(xpath = "//a[@href='binary-trees']")
	WebElement BinaryTrees;
	@FindBy(xpath = "//a[@href='types-of-binary-trees']")
	WebElement TypesofBinaryTrees;
	@FindBy(xpath = "//a[@href='implementation-in-python']")
	WebElement ImplementationinPython;
	@FindBy(xpath = "//a[@href='binary-tree-traversals']")
	WebElement BinaryTreeTraversals;
	@FindBy(xpath = "//a[@href='implementation-of-binary-trees']")
	WebElement ImplementationOfBinaryTrees;
	@FindBy(xpath = "//a[@href='applications-of-binary-trees']")
	WebElement ApplicationOfBinarytrees;
	@FindBy(xpath = "//a[@href='binary-search-trees']")
	WebElement BinarySearchTrees;
	@FindBy(xpath = "//a[@href='implementation-of-bst']")
	WebElement ImplementationofBTS;
	@FindBy(xpath = "//*[@id='content']/a")
	WebElement PracticeQuestions;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement tryHere;
	@FindBy(xpath = "//*[@id='answer_form']/button")
	WebElement RunButton;
	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[6]")
	WebElement CodeEditor;
	@FindBy(xpath = "//pre[@id='output']")
	WebElement CodeEditorOutput;
	@FindBy(xpath = "//h4[@class='bg-secondary text-white']")
	WebElement TreePageTitle;

	public TreePageObj() {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void TreePageTitle() {
		PageFactory.initElements(driver, this);
		TreePageTitle.getText();
		LoggerLoad.info("Tree Page title : " + driver.getCurrentUrl());
	}

	public String getcurrentpageUrl() {
		LoggerLoad.info(driver.getCurrentUrl());
		return (driver.getCurrentUrl());
	}

	public void clickOverviewOfTreesLink() {
		Overviewoftrees.click();
		LoggerLoad.info("Overview of trees Link clicked");
	}

	public void clickTerminologiesLink() {
		PageFactory.initElements(driver, this);
		Terminologies.click();
		LoggerLoad.info("Terminologies Link clicked");
	}

	public void clickTypesOfTreesLink() {
		PageFactory.initElements(driver, this);
		TypesofTrees.click();
		LoggerLoad.info("Types of Trees Link clicked");
	}

	public void clickTreeTraversalsLink() {
		PageFactory.initElements(driver, this);
		TreeTraversals.click();
		LoggerLoad.info("Tree Traversals Link clicked");
	}

	public void clickTraversalsIllustrationsLink() {
		PageFactory.initElements(driver, this);
		TraversalsIllustrations.click();
		LoggerLoad.info("Traversals Illustrations Link clicked");
	}

	public void clickBinaryTreesLink() {
		PageFactory.initElements(driver, this);
		BinaryTrees.click();
		LoggerLoad.info("Binary Trees Link clicked");
	}

	public void clickTypesofBinaryTreesLink() {
		PageFactory.initElements(driver, this);
		TypesofBinaryTrees.click();
		LoggerLoad.info("Types of BinaryTrees Link clicked");
	}

	public void clickImplementationinPythonLink() {
		PageFactory.initElements(driver, this);
		ImplementationinPython.click();
		LoggerLoad.info("Implementation in Python Link clicked");
	}

	public void clickBinaryTreeTraversalsLink() {
		PageFactory.initElements(driver, this);
		BinaryTreeTraversals.click();
		LoggerLoad.info("Binary Tree Traversals Link clicked");
	}

	public void clickImplementationOfBinaryTreesLink() {
		PageFactory.initElements(driver, this);
		ImplementationOfBinaryTrees.click();
		LoggerLoad.info("Implementation Of Binary Trees Link clicked");
	}

	public void clickApplicationOfBinarytreesLink() {
		PageFactory.initElements(driver, this);
		ApplicationOfBinarytrees.click();
		LoggerLoad.info("Application Of Binarytrees Link clicked");
	}

	public void clickBinarySearchTreesLink() {
		PageFactory.initElements(driver, this);
		BinarySearchTrees.click();
		LoggerLoad.info("Binary Search Trees Link clicked");
	}

	public void clickImplementationofBTSLink() {
		PageFactory.initElements(driver, this);
		ImplementationofBTS.click();
		LoggerLoad.info("Implementation of BTS Link clicked");
	}

	public void clickPracticeQuestionsLink() {
		PageFactory.initElements(driver, this);
		PracticeQuestions.click();
		LoggerLoad.info("Practice Questions Link clicked");
	}

	public void clickTryHereButton() {
		PageFactory.initElements(driver, this);
		tryHere.click();
		LoggerLoad.info("Try here button clicked");
	}

	public void clickRunButton() {
		PageFactory.initElements(driver, this);
		RunButton.click();
		LoggerLoad.info("Run button clicked");
	}

	public void validateTextEditorBox() {

		String Code = "print('Python is fun!')";
		PageFactory.initElements(driver, this);
		CodeEditor = driver.switchTo().activeElement();
		Actions actions = new Actions(driver);
		actions.moveToElement(CodeEditor).click().perform();
		CodeEditor.sendKeys(Code);
		LoggerLoad.info("The given code is : " + Code);
	}

	public void validateCodeEditorOutput() {
		PageFactory.initElements(driver, this);
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//    WebElement editorOutputElement = wait.until(ExpectedConditions.visibilityOf(CodeEditorOutput));
		String message = CodeEditorOutput.getText();
		LoggerLoad.info("The given code is Valid :" + message);
	}

	public void HandleAlert() {
		PageFactory.initElements(driver, this);
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		LoggerLoad.info("Alert message: " + alertMessage);
		alert.accept();
		LoggerLoad.info("Alert message:" + alertMessage);
	}

	public void InvalidCode() {
		String invalidCode = "This is a test message !";
		PageFactory.initElements(driver, this);
		CodeEditor = driver.switchTo().activeElement();
		Actions actions = new Actions(driver);
		actions.moveToElement(CodeEditor).click().perform();
		CodeEditor.sendKeys(invalidCode);
		LoggerLoad.info("The code is Invalid");

	}

}