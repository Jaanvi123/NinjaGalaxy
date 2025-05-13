package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverManager.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utils.ConfigReader;

public class HooksPage {

    @BeforeAll
    public static void loadConfig() throws IOException {
        ConfigReader.loadConfig();
    }

    @Before
    public void setUp() throws Exception {
        String browser = ConfigReader.getBrowserType();
        String url = ConfigReader.getUrl();

        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser type not declared in config properties file");
        }

        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL not declared in config properties file");
        }

<<<<<<< Updated upstream
        System.out.println("Initializing driver for browser: " + browser);
        DriverFactory.initializeDriver(browser);
=======
		String browser = ConfigReader.getProperty("browser");
	
			if (browser == null || browser.isEmpty()) {
			throw new IllegalArgumentException("Browser type not declared in config properties file");
		}
			LoggerLoad.info("Initializing WebDriver...");
		    DriverFactory.initializeDriver(browser);
		    driver = DriverFactory.getDriver();
	
		String url = ConfigReader.getProperty("Url");
		if (url == null || url.isEmpty()) {
	        throw new IllegalArgumentException("URL not declared in config properties file");
	    }
	    LoggerLoad.info("Navigating to URL: " + url);
	    driver.get(url);
		
	}

	@After
	public void tearDown(Scenario scenario)  throws Exception  {

			        WebDriver driver = DriverFactory.getDriver();
	        	 if (driver != null) 
	        	            if (scenario.isFailed()) {
	        	String scrShot = "screenshot_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	 			File screenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 			Files.move(screenshots.toPath(), Path.of(
	 					"/Users/dineshdeshmukh/eclipse-workspace/NinjaGalaxy-working/src/test/resources/Screenshots", scrShot + ".png"));
	 			LoggerLoad.info("Screenshot saved: " + scrShot + ".png");
	        }
	       
	        DriverFactory.closeDriver();
	    }		  
	 			
	}
>>>>>>> Stashed changes

        System.out.println("Navigating to URL: " + url);
        DriverFactory.getDriver().get(url);
    }

    @After
    public void tearDown() {
//        WebDriver driver = DriverFactory.getDriver();
//        if (driver != null) {
//            try {
//                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
//                String screenshotName = "screenshot_" + timestamp + ".png";
//                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                Path destination = Path.of("C:\\Users\\onlin\\eclipse-workspace\\DsAlgo_Galaxy\\src\\test\\resources\\Screenshots", screenshotName);
//                Files.move(screenshot.toPath(), destination);
//                System.out.println("Screenshot saved: " + screenshotName);
//            } catch (Exception e) {
//                System.err.println("Error saving screenshot: " + e.getMessage());
//            } finally {
//                DriverFactory.closeDriver();
//            }
//        }
//    }
}}
