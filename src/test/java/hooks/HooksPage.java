package hooks;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverManager.DriversBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utils.ConfigReader;


public class HooksPage {
	public static WebDriver driver;
    @BeforeAll
    public static void loadConfig() throws IOException {
        ConfigReader.loadConfig(); 
    }

  
    @Before
    public void setUp() throws Exception {
        String browser = ConfigReader.getBrowserType();
        System.out.println("Browser Type: " + browser);
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser type not declared in config properties file");
        }

        DriversBase.initializeDriver();

        String url = ConfigReader.getUrl();
        System.out.println("URL: " + url);
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL not declared in config properties file");
        }
    }
     
       
    
       @After
       public void tearDown() {
           if (driver != null) {
               try {
                   String s2 = "screenshot11";
                   File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                   Files.move(screenshot.toPath(),
                              Path.of("C:\\Users\\onlin\\eclipse-workspace\\DsAlgo_Galaxy\\src\\test\\resources\\Screenshots", s2 + ".png"));
                   System.out.println("Screenshot saved: " + s2 + ".png");
               } catch (Exception e) {
                   System.err.println("Error saving screenshot: " + e.getMessage());
               }
           }

           // Close the browser after taking the screenshot
           DriversBase.closeDriver();
       }

               
    } 

    

