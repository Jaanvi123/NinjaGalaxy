package hooks;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import driverManager.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utils.ConfigReader;
import utils.LoggerLoad;

public class HooksPage {

	WebDriver driver = DriverFactory.getDriver();
	ConfigReader configReader = new ConfigReader(driver);

	@BeforeAll
	public static void loadConfig() throws IOException {
		ConfigReader.loadConfig();
	}

	@Before
	public void setUp() throws Exception {
		String browser = configReader.getBrowserType();
		String url = configReader.getUrl();
			if (browser == null || browser.isEmpty()) {
			throw new IllegalArgumentException("Browser type not declared in config properties file");
		}
		if (url == null || url.isEmpty()) {
			throw new IllegalArgumentException("URL not declared in config properties file");
		}
		LoggerLoad.info("Initializing driver for browser: " + browser);
		driver = DriverFactory.initializeDriver(browser);
		LoggerLoad.info("Navigating to URL: " + url);
		driver.get(url);
		
	}

	@After
	public void tearDown() {
		/*
		 * if (driver != null) { try { String s2 = "screenshot13"; File screenshot =
		 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * Files.move(screenshot.toPath(), Path.of(
		 * "C:\\Users\\onlin\\eclipse-workspace\\DsAlgo_Galaxy\\src\\test\\resources\\Screenshots",
		 * s2 + ".png")); System.out.println("Screenshot saved: " + s2 + ".png"); }
		 * catch (Exception e) { System.err.println("Error saving screenshot: " +
		 * e.getMessage()); } DriverFactory.closeDriver(); }
		 */

		// Close the browser after taking the screenshot
		DriverFactory.closeDriver();
	}

}
