package runner;




//package your.package.name;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/homepage.feature", // Path to your feature files
    glue = {"stepdefinations"},   // Package containing step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reporting plugins
    monochrome = true // Makes console output more readable
)
public class TestRunner {
    // This class remains empty; it is used only as a holder for the above annotations
}
		
		
	