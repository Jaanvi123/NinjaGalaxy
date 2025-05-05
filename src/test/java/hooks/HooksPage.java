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

        System.out.println("Initializing driver for browser: " + browser);
        DriverFactory.initializeDriver(browser);

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
