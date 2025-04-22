package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriversBase {

  
	public static Properties prop;
	public static String Url;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	ConfigReader cofigReader = new ConfigReader();
	
	public static WebDriver initializeDriver(String browser) {
	

	    if (tlDriver == null) {
	   //     String browser = prop.getProperty("browser");
	        if (browser == null) {
	            System.out.println("Browser property is missing in config file!");
	        //    return ;
	        }
	        if (browser.equalsIgnoreCase("chrome")) {
	 //       System.setProperty("webdriver.chrome.driver", "C:\\Users\\onlin\\eclipse-workspace\\Chromedriver\\chromedriver.exe");
	       tlDriver.set(new ChromeDriver()); 
	   
	   
	          //  driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	        
	        	tlDriver.set(new FirefoxDriver());
	        } else if (browser.equalsIgnoreCase("Edge")) {
	         
	        	tlDriver.set(new EdgeDriver());
	        }
	        tlDriver.get().manage().window().maximize();
	        tlDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  	     
	    }
	  return   tlDriver.get();
	}
	
	
  public static WebDriver getDriver() {
	return tlDriver.get();
	  
  }

	public static void closeDriver() {
	    if (tlDriver != null) {
	    	tlDriver.get().close();
	    	tlDriver.get().quit();
	        System.out.println("Browser closed successfully.");
	    } else {
	        System.out.println("Driver is already null, nothing to close.");
	    }
	}


}
