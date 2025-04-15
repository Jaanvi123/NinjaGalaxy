package hooks;



import java.io.IOException;

import org.openqa.selenium.WebDriver;

import driverManager.DriverBase;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utils.ConfigReader;


public class Hooks {

    @BeforeAll
    public static void loadConfig() throws IOException {
        ConfigReader.loadConfig(); 
    }

    @Before
    public void setUp() throws Exception {
        String browser = ConfigReader.getBrowserType();
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser type not declared in config properties file");
        }

       
        DriverBase.initializeBrowser(browser);
        
      
        String url = ConfigReader.getUrl();
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL not declared in config properties file");
        }


        WebDriver driver = DriverBase.getDriver();
        driver.get(url);
    }

    /*   @After
    
    public void tearDown() {
        WebDriver driver = DriversBase.getDriver();
        if (driver != null) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                
            
				String s1 = null;
				Files.move(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).toPath(),
                           Path.of("C:\\Users\\onlin\\eclipse-workspace\\DsAlgo_Galaxy\\src\\test\\resources\\Screenshots", s1 + ".png"));
                System.out.println("Screenshot saved" + s1 + ".png");
            } catch (Exception e) {
                System.err.println("Error saving screenshot: " + e.getMessage());
            }
        }
         
               DriversBase.closeDriver();
    } */
}
    