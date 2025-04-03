package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
public class run {
	

	
		@CucumberOptions(
				plugin = {"pretty", "html:target/bharathi.html"}, //to generate html file reporting purpose
				monochrome=false,  //console output color
				tags = "@tag1", //tags from feature file
				features = {"src/test/resources/source"}, //location of feature files
				glue= "we_Team4ds_algo") //location of step definition files


		public class TestRunner extends AbstractTestNGCucumberTests{
			
			@Override
		    @DataProvider(parallel = false)
		    public Object[][] scenarios() {
						
				return super.scenarios();
		    }
		}


}
