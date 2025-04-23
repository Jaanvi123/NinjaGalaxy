package dsAlgoPageObjects;


import utils.ConfigReader;
import utils.LoggerLoad;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import driverManager.DriverFactory;


public class IntroductionPageObj  {	
	public static WebDriver driver=DriverFactory.getDriver();
	String URL=ConfigReader.getUrl();
	String homeURL=ConfigReader.getUrlHome();
	
	//dropdown
	@FindBy (xpath="//a[@href='#']")WebElement dropdown;
	@FindBy (xpath="//div[@class='dropdown-menu show']")WebElement dropdownArray;
	@FindBy (xpath="//*[@id='navbarCollapse']//a[2]")WebElement dropdownLinkedlist;
	@FindBy (xpath="//*[@id='navbarCollapse']//a[3]")WebElement dropdownStack;
	@FindBy (xpath="//*[@id='navbarCollapse']//a[4]")WebElement dropdownQueue;
	@FindBy (xpath="//*[@id='navbarCollapse']//a[5]")WebElement dropdownTree;
	@FindBy (xpath="//*[@id='navbarCollapse']//a[6]")WebElement dropdownGraph;
	
	//sigin
	@FindBy (xpath="//a[@href='/login']") WebElement SignInLink;
	//register
	@FindBy (xpath="//a[@href='/register']")WebElement RegisterLink;
	
	public String getHomePageTitle() {
	    return driver.getTitle();
	}
	
	private List<String> selectedItems = new ArrayList<>();
	public void dropdown(String string) {

		dropdown.click();
		selectedItems.add(string);
		switch (string) {
		case "Arrays":
			LoggerLoad.info("User click on " + string);
			dropdownArray.click();
			break;
		case "Linkedlist":
			LoggerLoad.info("User click on " + string);
			dropdownLinkedlist.click();
			break;
		case "Stack":
			LoggerLoad.info("User click on " + string);
			dropdownStack.click();
			break;
		case "Queue":
			LoggerLoad.info("User click on " + string);
			dropdownQueue.click();
			break;
		case "Tree":
			LoggerLoad.info("User click on " + string);
			dropdownTree.click();
			break;
		case "Graph":
			LoggerLoad.info("User click on " + string);
			dropdownGraph.click();
			break;
		}
		LoggerLoad.info("User selected: " + string);
	}

	
	public List<String> getSelectedItems() {
        return selectedItems;
    }
	//Signin
	public void SignInLinkClick() {
		SignInLink.click();
	}
	
	
	
	
	
	}
