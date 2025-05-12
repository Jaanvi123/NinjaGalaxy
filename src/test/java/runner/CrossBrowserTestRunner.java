package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.LoggerLoad;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import driverManager.DriverFactory;
import org.testng.annotations.AfterTest;

	@CucumberOptions(
	        features = "src/test/resources/features/linkedList.feature", 
	        glue = {"stepDefinitions", "hooks"},
	        monochrome = true, 
	        dryRun = false,
	        plugin = {
	                "pretty",
	                "html:target/cucumber-reports/cucumber.html",
	                "json:target/cucumber-reports/cucumber.json"  
	        }
	)
	public class CrossBrowserTestRunner extends AbstractTestNGCucumberTests {
	    
	    @BeforeTest
	    @Parameters("browser") 
	    public void setUp(String browser) throws Exception {
	        LoggerLoad.info("Initializing WebDriver for browser: " + browser);
	        if (DriverFactory.getDriver() == null) {
	        	DriverFactory.initializeDriver(browser);
	        }
	    }
	   
	    @AfterTest
	    public void tearDown() {
	    	DriverFactory.closeDriver(); 
	    }
	}
	

