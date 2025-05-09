package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;




	@RunWith(Cucumber.class)

	@CucumberOptions(
			features="src/test/resources/features/Stack.feature",
			glue={"stepDefinitions","hooks"},
			dryRun=false,
			monochrome=true,	
			plugin= {"pretty","html:target/output.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
			public class TestRunner{
				 
			     
	
		 		}
