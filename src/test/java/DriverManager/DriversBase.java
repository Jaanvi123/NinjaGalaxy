package DriverManager;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

	public class DriversBase {	
		public static WebDriver driver;

	      	public static void initializeBrowser(String browser) throws InterruptedException {
	      		
	      		if (driver == null) {
	                 switch (browser.toLowerCase()) {
		        case "chrome":
		        	WebDriverManager.chromedriver().setup();
		        	driver = new ChromeDriver();
		            break;
		        case "firefox":
		        	WebDriverManager.firefoxdriver().setup();
		            driver = new FirefoxDriver();
		            break;
		        case "edge":
		        	
		        	 WebDriverManager.edgedriver().setup();
		            driver = new EdgeDriver();
		            break;
		        default:
		            throw new IllegalArgumentException("Unsupported browser: " + browser);
		    }
		    
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	      	}
		public static WebDriver getDriver() {
		    if (driver == null) {
		        throw new IllegalStateException("WebDriver not initialized! Call initializeBrowser() first.");
		    }
		    return driver;
		}

		public static void closeDriver() {
		    if (driver != null) {
		        driver.quit();
		        System.out.println("Browser closed successfully.");
		    } else {
		    	driver = new ChromeDriver();  // Reinitialize the driver
		        driver.get("https://dsportalapp.herokuapp.com");
	        }
	    }
		      
		    
		}
	