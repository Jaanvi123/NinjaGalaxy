package dsAlgoPageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class IntroductionPageObj  {	
	
	static WebDriver driver;
	By signin = By.xpath("//a[@href='/login']");
	By username = By.id("id_username");
	By pwd = By.id("id_password");
	By submit = By.xpath("//input[@value='Login']");	
	By datastructure_dropdown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	By parentDiv = By.xpath("//div[@class='dropdown-menu show']");
	static By dropdownvalues = By.tagName("a");
	By homepagetitle = By.xpath("//a[@href='/home']");
	By datastructures_getstarted = By.xpath("//a[@href='data-structures-introduction']");
	By datastructurespg = By.xpath("//h4[@class='bg-secondary text-white']");
	By timecomplexity = By.xpath("//a[@href='time-complexity']");
	By tryhere_btn = By.xpath("//a[@href='/tryEditor']");
	By texteditorarea = By.xpath("//div//pre[@class='CodeMirror-line-like']/span");
	By txteditorarea_1 = By.xpath("//form[@id='answer_form']//pre[@class=' CodeMirror-line ']/span/span");
	By run_btn = By.xpath("//button[text()='Run']");
	By practicequestions = By.xpath("//a[text()='Practice Questions']");
	By consolemsg = By.xpath("//*[@id='output']");
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	Alert alert;
	WebElement txtarea;
	
	public String getHomePageTitle() {
	    return driver.getTitle();
	}

	public void drpdownClick()
	{
		driver.findElement(datastructure_dropdown).click();
	}
	public List<WebElement> getDropdownElements() {
	    return driver.findElement(parentDiv).findElements(dropdownvalues);
	}

	public  List<String> getDropdownValues() {
	    List<String> values = new ArrayList<>();
	    List<WebElement> dropdownItems = driver.findElements(dropdownvalues);

	    
	    for (WebElement item : dropdownItems) {
	        values.add(item.getText());
	    }
	    return values;
	}

	
	public void click_ds_getstarted()
	{
		driver.findElement(datastructure_dropdown).click();
		driver.findElement(datastructures_getstarted).click();
	}
	public String datastructurepagename()
	{
		return(driver.findElement(datastructurespg).getText());		
	}
	public void clicktimecomplexity()
	{
		wait.until(ExpectedConditions.elementToBeClickable(timecomplexity));
		driver.findElement(timecomplexity).click();	
	}
	public String getcurrentpage()
	{
		return(driver.getCurrentUrl());
	}
	public void clicktryhere()
	{
		driver.findElement(tryhere_btn).click();
	}
	public void validatetexteditor1(String text) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement editor = wait.until(ExpectedConditions.elementToBeClickable(txtarea));
	    
	    Actions actions = new Actions(driver);
	    actions.moveToElement(editor).click().perform();
	    editor.sendKeys(text);
	}

	
	public void clickrun()
	{
		driver.findElement(run_btn).click();	
	}
	public String alertpopup()
	{
	    alert = driver.switchTo().alert();
		String alertmsg = driver.switchTo().alert().getText();			
		return alertmsg;
	}
	public void acceptalert()
	{
		alert.accept();
		
	}
	public void cleartextarea() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement editor = wait.until(ExpectedConditions.elementToBeClickable(txtarea));
	    
	    Actions actions = new Actions(driver);
	    actions.moveToElement(editor).click().sendKeys(Keys.CONTROL + "a").sendKeys(Keys.DELETE).perform();
	}

	public void validatetexteditor2(String text) throws InterruptedException
	{
		Thread.sleep(1000);
		 txtarea = driver.switchTo().activeElement();
		Actions actions = new Actions(driver);
		actions.moveToElement(txtarea).click().perform();
		txtarea.sendKeys(text);
					
	}
	public String getconsolemsg()
	{
		return(driver.findElement(consolemsg).getText());
	}
	public void navigateback()
	{
		driver.navigate().back();
		
	}
	public String clickpracticequestions()
	{
		driver.findElement(practicequestions).click();
		return(driver.getCurrentUrl());
		
	}
	
	}
