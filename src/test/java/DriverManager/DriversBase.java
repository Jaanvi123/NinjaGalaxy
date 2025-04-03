package DriverManager;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriversBase {
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//	public static ThreadLocal<RemoteWebDriver > driver = new ThreadLocal<>();
	public Properties prop;
	public static String url;
	
	public void setDriver(WebDriver driver) {
		this. driver.set(driver);
	}
	
	public WebDriver getDriver() {
		return this.driver.get();
	}

	public void setupDriver(String browser) {
		if(getDriver()==null){
//			if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			if(browser.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
//				System.setProperty("webdriver.Chrome.driver","\\src\\test\\resources\\drivers\\chromedriver.exe");
				setDriver(new ChromeDriver());
				}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
					WebDriverManager.firefoxdriver().setup();
					setDriver(new FirefoxDriver());
					}else if(browser.equalsIgnoreCase("Edge")){
						WebDriverManager.edgedriver().setup();
						setDriver(new EdgeDriver());
						}
			}
		}
	
	public void loadProperties() {
		try {
			 prop = new Properties();
			 System.out.println(System.getProperty("user.dir"));
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config//config.properties");
			prop.load(fis);			
			} catch (IOException e) {
				e.getMessage();
			}
	}
	
//	@BeforeMethod (alwaysRun = true)
	@BeforeMethod
	public void driverInitializer(String browser) {
		loadProperties();
		setupDriver(browser);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		this.url = prop.getProperty("Url");
		getDriver().get(url);
	}
}


	
	



