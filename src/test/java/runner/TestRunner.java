package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)

@CucumberOptions(
    features = "src/test/resources/features/",     // path to your .feature files
    glue = "stepDefinitions",                     // package of your step defs
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)    
public class TestRunner extends AbstractTestNGCucumberTests {
}