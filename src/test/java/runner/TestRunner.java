package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.*;


	@RunWith(Cucumber.class)

	@CucumberOptions(
			features="src/test/resources/features",
			glue={"stepDefinitions","hooks"},
			dryRun=false,
			monochrome=true,	
			plugin= {"pretty","html:target/output.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
					}
						)
			
	public class TestRunner extends AbstractTestNGCucumberTests {
		 
		  @Override
		     @DataProvider(parallel = true)
		     public Object[][] scenarios() {
		         return super.scenarios();
		     }
		 		}
