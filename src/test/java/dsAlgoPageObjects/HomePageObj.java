package dsAlgoPageObjects;

import org.openqa.selenium.By;


import driverManager.DriversBase;


public class HomePageObj extends DriversBase{
      
	By home_msg = By.xpath("//div[@class='content']/p");
	By startBtn = By.xpath("//button[@class='btn']");
	By register_msg = By.xpath("//div[@class='alert alert-primary']");
	private String msg;
    
 public HomePageObj()
 {
	 	 	 
 }
 
 public String getmessage()
 {	
	return msg = driver.findElement(home_msg).getText();	 
 }
 public void clickButton()
 {
	 driver.findElement(startBtn).click(); 
 }
 public String getTitle()
 {
	 return driver.getTitle();
 }
 public String RegisterSuccess()
 {	
 	 return msg=driver.findElement(register_msg).getText();
 	 
 }


}