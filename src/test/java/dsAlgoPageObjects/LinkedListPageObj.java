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

public class LinkedListPageObj {
	
	WebDriver driver = DriverFactory.getDriver();
	String URL = ConfigReader.getUrl();
	String homeURL = ConfigReader.getUrlHome();
	
//	@FindBy(css= "a[href='linked-list']")WebElement GetStartedLinkedListButton;
	@FindBy(xpath = "//a[@href='introduction']")WebElement Introduction;
	@FindBy(xpath = "//a[@href='creating-linked-list']") WebElement creatingLinkedList;
	@FindBy(xpath = "//a[@href='types-of-linked-list']") WebElement TypesOfLinkedList;
	@FindBy(xpath = "//a[@href='implement-linked-list-in-python']") WebElement ImplementLLinPython;
	@FindBy(xpath = "//a[@href='traversal']") WebElement Traversal;
	@FindBy(xpath = "//a[@href='insertion-in-linked-list']") WebElement Insertion;
	@FindBy(xpath = "//a[@href='deletion-in-linked-list']")WebElement Deletion;
	@FindBy(xpath = "Practice Questions")WebElement PracticeQueLinkedList;
	@FindBy(xpath = "//a[@href='/tryEditor']")WebElement TryHere;
	@FindBy(xpath = "//h4[@class='bg-secondary text-white']")WebElement LinkedListTitle;
	
	public LinkedListPageObj(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}  
		
	public String getCurrentPageUrl()
	{
		System.out.println(driver.getCurrentUrl());
		return(driver.getCurrentUrl());
	}
	public void LinkedListTitle() {
		 PageFactory.initElements(driver, this);
		LoggerLoad.info("Linked List Page title" + LinkedListTitle);
	}
/*	public void clickGetStartedLinkedListButton() {
		 PageFactory.initElements(driver, this);
		 GetStartedLinkedListButton.click();
		LoggerLoad.info("Get Started Linked List Button clicked");
	}   */
	public void clickIntroductionLink() {
		 PageFactory.initElements(driver, this);
		 Introduction.click();
		LoggerLoad.info("Introduction Link clicked");
	}
	public void clickcreatingLinkedListLink() {
		 PageFactory.initElements(driver, this);
		 creatingLinkedList.click();
		LoggerLoad.info("creating Linked List Link clicked");
	}
	
	public void clickTypesOfLinkedListLink() {
		 PageFactory.initElements(driver, this);
		 TypesOfLinkedList.click();
		LoggerLoad.info("Types Of Linked List Link clicked");
	}
	
	public void clickImplementLLinPythonLink() {
		 PageFactory.initElements(driver, this);
		 ImplementLLinPython.click();
		LoggerLoad.info("Implement Linked List in Python Link clicked");
	}
		
	public void clickTraversalLink() {
		 PageFactory.initElements(driver, this);
		 Traversal.click();
		LoggerLoad.info("Traversal Link clicked");
	}
	
	public void clickInsertionLink() {
		 PageFactory.initElements(driver, this);
		 Insertion.click();
		LoggerLoad.info("Insertion Link clicked");
	}
	public void clickDeletionLink() {
		 PageFactory.initElements(driver, this);
		 Deletion.click();
		LoggerLoad.info("Deletion Link clicked");
	}
	
	public void clickPracticeQueLink() {
		 PageFactory.initElements(driver, this);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement editorOutputEle = wait.until(ExpectedConditions.visibilityOf(PracticeQueLinkedList));
		PracticeQueLinkedList.click();
		LoggerLoad.info("Practice Questions Link clicked");
	}
	
	

}
