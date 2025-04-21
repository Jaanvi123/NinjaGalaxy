package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriversBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String url;

	public DriversBase() {
		try {
			prop = new Properties();
			System.out.println(System.getProperty("user.dir"));
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//config//config.properties");

			prop.load(fis);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	
	public static void initializeDriver() {
	    if (prop == null) {
	        System.out.println("Properties file not loaded correctly!");
	        return;
	    }
	    if (driver == null) {
	        String browser = prop.getProperty("browser");
	        if (browser == null) {
	            System.out.println("Browser property is missing in config file!");
	            return;
	        }
	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup(); 
	            driver = new FirefoxDriver();
	        } else if (browser.equalsIgnoreCase("Edge")) {
	            WebDriverManager.edgedriver().setup(); 
	            driver = new EdgeDriver();
	        }
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        url = prop.getProperty("Url");
	        if (url == null) {
	            System.out.println("URL property is missing in config file!");
	            return;
	        }
	        driver.get(url);
	    }
	}


	public static void closeDriver() {
	    if (driver != null) {
	        driver.close();
	        driver.quit();
	        System.out.println("Browser closed successfully.");
	    } else {
	        System.out.println("Driver is already null, nothing to close.");
	    }
	}


}
