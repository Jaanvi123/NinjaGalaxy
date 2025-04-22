package dsAlgoPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;


public class LoginPageObj {
	
	 WebDriver driver;
	 By sign_in =By.xpath("//a[text() =\"Sign in\"]");
	 By login_btn=By.xpath("//input[@type=\"submit\"]");
	 By userName=By.xpath("//input[@name='username']");
	 By signIn=By.xpath("//a[@href=\"/login\"] ");
	 By passWord=By.xpath("//input[@type=\"password\"]");
	 By alertmsg=By.xpath("//div[@class=\"alert alert-primary\"]");
	 By loginmsg=By.xpath("//div[@class=\"alert alert-primary\"]");
	 
	 
	 public LoginPageObj(WebDriver driver) {
		  this.driver=driver;
	 }
	 
	 public void clicksign_in() {
		 driver.findElement(sign_in).click();
		  }
	 
	 public void clicklogin() {
		  driver.findElement(login_btn).click();
	 }
	

	 public String verifyContextMessage()  {
		return  driver.findElement(userName).getAttribute("validationMessage");
		
	 }
	 
	 public void enterUserName(String name) {
		 driver.findElement(userName).sendKeys(name);
	 }

	 public String verifyContextMessage1()  {
		 return (driver.findElement(passWord).getAttribute("validationMessage"));
		 }
	 public void enterPassWord(String passwrd) {
		 driver.findElement(passWord).sendKeys(passwrd);
	 }
	 public void enterUserNamePassWrd(String name,String passwrd) {
		 driver.findElement(userName).sendKeys(name);
		 driver.findElement(passWord).sendKeys(passwrd);
	 }
	 
	 public String AlertMsg() {
		 return driver.findElement(alertmsg).getText();
	 }
	 public void ValidenterUserNamePassWrd(String name,String passwrd) {
		 driver.findElement(userName).sendKeys(name);
		 driver.findElement(passWord).sendKeys(passwrd);
	 }
	  public String validatemessage() {
		  return driver.findElement(loginmsg).getText();
	  }
	 }
