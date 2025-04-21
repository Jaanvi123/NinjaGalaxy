package runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



	@RunWith(Cucumber.class)

	@CucumberOptions(
			features="src/test/resources/features",
			glue={"stepDefinitions"},
			dryRun=false,
			monochrome=true,
			//tags= "@SignIn",
			plugin= {"pretty","html:target/output.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
					}
		//	publish=true
				
			)
			
public class TestRunner {

}
