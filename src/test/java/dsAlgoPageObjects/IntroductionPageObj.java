package dsAlgoPageObjects;

import utils.ConfigReader;
import utils.LoggerLoad;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverFactory;

public class IntroductionPageObj {
	public WebDriver driver = DriverFactory.getDriver();
	String URL = ConfigReader.getUrl();
	//String homeURL = ConfigReader.getUrlHome();

	// dropdown
	@FindBy(css = "//a[@href='#']")
	WebElement dropdown;

	@FindBy(css = "a.dropdown-item[href='/array']")
	WebElement dropdownArray;
	@FindBy(css = "a.dropdown-item[href='/linked-list']")
	WebElement dropdownLinkedlist;
	@FindBy(css = "a.dropdown-item[href='/stack']")
	WebElement dropdownStack;
	@FindBy(css = "a.dropdown-item[href='/queue']")
	WebElement dropdownQueue;
	@FindBy(css = "a.dropdown-item[href='/tree']")
	WebElement dropdownTree;
	@FindBy(css = "a.dropdown-item[href='/graph']")
	WebElement dropdownGraph;

	// Get started button
	@FindBy(css = "a.btn-primary[href='data-structures-introduction']")
	WebElement dsIntroductionGetStartedBtn;
	@FindBy(css = "a[href='array']")
	WebElement arrayGetStartedBtn;
	@FindBy(css = "a[href='linked-list']")
	WebElement linkedListGetStartedBtn;
	@FindBy(css = "a[href='stack']")
	WebElement stackGetStartedBtn;
	@FindBy(css = "a[href='queue']")
	WebElement queueGetStartedBtn;
	@FindBy(css = "a[href='tree']")
	WebElement treeGetStartedBtn;
	@FindBy(css = "a[href='graph']")
	WebElement graphGetStartedBtn;

	// sigin
	@FindBy(xpath ="//div[@class='navbar-nav']//a[@href='/login']") WebElement SignInLink;
	// register
	@FindBy(xpath="//div[2]/ul/a[2]") WebElement RegisterLink;

	// to locate the authentication message element
	@FindBy(css = "div.alert.alert-primary")
	WebElement authenticationMessage;

	public String getAuthenticationMessage() {
		return authenticationMessage.getText();
	}

	// Using FindBy annotation to locate the alert message
	@FindBy(css = "div.alert.alert-primary[role='alert']")
	WebElement ActualauthenticationMessage;

	public void ActualAuthenticationMessage(String string) {
		ActualauthenticationMessage.getText();
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	// Signin
	public void SignInLinkClick() {
		SignInLink.click();
	}

	@FindBy(css = "a.dropdown-toggle")
	WebElement DropdownArrow;

	public void clickDropdownArrow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(DropdownArrow));
			Actions actions = new Actions(driver);
			actions.moveToElement(DropdownArrow).perform();
			DropdownArrow.click();
			System.out.println("Dropdown Arrow clicked successfully.");
		    } catch (Exception e) {
			System.out.println("Error clicking dropdown Dropdown Arrow: " + e.getMessage());
		        }
	         }

	public void clickDropdownArray() {
		dropdownArray.click();
		LoggerLoad.info("Array Dropdown selected");
	}

	public void clickDropdownLinkedList() {
		dropdownLinkedlist.click();
		LoggerLoad.info("LinkedList Dropdown selected");
	}

	public void clickDropdownStack() {
		dropdownStack.click();
		LoggerLoad.info("Stack Dropdown selected");
	}

	public void clickDropdownQueue() {
		dropdownQueue.click();
		LoggerLoad.info("Queue Dropdown selected");
	}

	public void clickDropdownTree() {
		dropdownTree.click();
		LoggerLoad.info("Tree Dropdown selected");
	}

	public void clickDropdownGraph() {
		dropdownGraph.click();
		LoggerLoad.info("Graph Dropdown selected");
	}

	public void clickgetStartedButton(WebDriver driver) {
		this.driver = driver; // Set WebDriver instance
		PageFactory.initElements(driver, this); // Initialize elements
		System.out.println("Button clicked successfully.");
	}

	public void clickDsGetStartedButton() {
		dsIntroductionGetStartedBtn.click();
		LoggerLoad.info("Clicked on DS-Introduction Get Started Button");
	}

	public void clickArrayGetStartedButton() {
		arrayGetStartedBtn.click();
		LoggerLoad.info("Clicked on Array Get Started Button");
	}

	public void clickLinkedListGetStartedButton() {
		linkedListGetStartedBtn.click();
		LoggerLoad.info("Clicked on Linked List Get Started Button");
	}

	public void clickStackGetStartedButton() {
		stackGetStartedBtn.click();
		LoggerLoad.info("Clicked on Stack Get Started Button");
	}

	public void clickQueueGetStartedButton() {
		queueGetStartedBtn.click();
		LoggerLoad.info("Clicked on Queue Get Started Button");
	}

	public void clickTreeGetStartedButton() {
		PageFactory.initElements(driver, this); 
		treeGetStartedBtn.click();
		LoggerLoad.info("Clicked on Tree Get Started Button");
	}

	public void clickGraphGetStartedButton() {
		graphGetStartedBtn.click();
		LoggerLoad.info("Clicked on Graph Get Started Button");
	}
// PageFactory.initElements(driver, this); automatically finds and assigns values to @FindBy elements when the class instance is created.
	// Without this initialization, dsIntroductionGetStartedBtn remains null,
	// causing an error when clicking.
	// Now, when calling clickDsGetStartedButton(), the element is properly set up
	// and ready for interaction.
	
	public void clickRegisterLink() {
		PageFactory.initElements(driver, this); 
		RegisterLink.click();
		LoggerLoad.info("Clicked on Register Link on Homepage");
			}
	public void clickSignInLink() {
		PageFactory.initElements(driver, this); 
		SignInLink.click();
		LoggerLoad.info("Clicked on Sign In Link on Homepage");
	}
	public void clicklink(WebDriver driver) {
		this.driver = driver; // Set WebDriver instance
		PageFactory.initElements(driver, this); // Initialize elements
		
	}
	
}
