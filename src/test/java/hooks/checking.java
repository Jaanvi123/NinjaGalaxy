package hooks;

import org.openqa.selenium.WebDriver;

import driverManager.DriverFactory;
import utils.LoggerLoad;

public class checking {
	
	
	public void cheklog(){
		WebDriver driver = DriverFactory.getDriver();
		LoggerLoad.info("Tree Page title");
	}
	
	public static void main(String[] args)
    {
		LoggerLoad.info("Tree Page title  main");
    }

 
}