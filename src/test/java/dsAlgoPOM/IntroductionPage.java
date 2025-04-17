package dsAlgoPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriversBase;
import utils.LoggerLoad;

public class IntroductionPage {
	
	public WebDriver driver = DriversBase.getDriver();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000)); // Timeout in second
   // NumpyNinja, Data structures
	WebElement numpyNinja = driver.findElement(By.cssSelector("a[href='/home']"));
	WebElement dataStructure = driver.findElement(By.cssSelector("a.dropdown-toggle"));
	WebElement dsDropdown = driver.findElement(By.className("nav-link dropdown-toggle"));
	//*[@id="navbarCollapse"]/div[1]/div/a
	//Dropdown Elements
	WebElement  dropDownArrayItem = driver.findElement(By.cssSelector("a.dropdown-item[href='/array']"));
	WebElement  dropDownLinkedList = driver.findElement(By.cssSelector("a.dropdown-item[href='/linked-list']"));
	WebElement  dropDownStackItem = driver.findElement(By.cssSelector("a.dropdown-item[href='/stack']"));
	WebElement  dropDownQueueItem = driver.findElement(By.cssSelector("a.dropdown-item[href='/queue']"));
	WebElement  dropDownTreeItem = driver.findElement(By.cssSelector("a.dropdown-item[href='/tree']"));
	WebElement  dropDownGraphItem = driver.findElement(By.cssSelector("a.dropdown-item[href='/graph']"));
    // Sign in , Register Link
	
	
	WebElement signInLink = driver.findElement(By.cssSelector("a[href='/login']"));
	
	WebElement registerLink = driver.findElement(By.cssSelector("a[href='/register']"));
	//Get started Button 

	WebElement dsIntroductionGetStartedBtn = driver.findElement(By.cssSelector("a[href='data-structures-introduction']"));
	WebElement  arrayGetStartedBtn = driver.findElement(By.cssSelector("a[href='array']"));
	WebElement  linkedListGetStartedBtn = driver.findElement(By.cssSelector("a[href='linked-list']"));
	WebElement  stackGetStartedBtn = driver.findElement(By.cssSelector("a[href='stack']"));
	WebElement  queueGetStartedBtn = driver.findElement(By.cssSelector("a[href='queue']"));
	WebElement  treeGetStartedBtn = driver.findElement(By.cssSelector("a[href='tree']"));
	WebElement  graphGetStartedBtn = driver.findElement(By.cssSelector("a[href='graph']"));
	
	public void clickOnDropDown() {
		dsDropdown.click();
		LoggerLoad.info("Clicking the DropDown");
	}
	
	
	
	public void clickOnDataStructuresGetStartedBtn() {
		dsIntroductionGetStartedBtn.click();
		LoggerLoad.info("Clicking the DS-Introduction Get Started link");
	}

	public void clickOnArrayGetStartedBtn() {
		arrayGetStartedBtn.click();
		LoggerLoad.info("Clicking the Array Get Started link");
	}


	public void clickOnLinkedListGetStartedBtn() {
		linkedListGetStartedBtn.click();
		LoggerLoad.info("Clicking the Linked List Get Started link");
	}

	public void clickOnStackGetStartedBtn() {
		stackGetStartedBtn.click();
		LoggerLoad.info("Clicking the Stack Get Started link");
	}

	public void clickOnQueueGetStartedBtn() {
		queueGetStartedBtn.click();
		LoggerLoad.info("Clicking the Queue Get Started link");
	}

	public void clickOnTreeGetStartedBtn() {
		treeGetStartedBtn.click();
		LoggerLoad.info("Clicking the Tree Get Started link");
	}

	public void clickOnGraphGetStartedBtn() {
		graphGetStartedBtn.click();
		LoggerLoad.info("Clicking the Graph Get Started link");
	}

	public void clickOnRegisterlink() {
		registerLink.click();
	}

	public void clickOnSignInlink() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/login']")));
		signInLink.click();
	}

	public  String  getPageTitle() {
		String elementText = driver.getTitle();
		System.out.println(elementText);
		return elementText;
	}

	
	
}
