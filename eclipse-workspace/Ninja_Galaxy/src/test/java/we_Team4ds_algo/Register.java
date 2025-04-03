package we_Team4ds_algo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	WebDriver driver;
	@Given("user is login to ds algo application with {string} and {string}")
	public void user_is_login_to_ds_algo_application_with_and(String username, String password) {
	    // Your code here to perform the login with username and password
	

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://dsportalapp.herokuapp.com/register");
		
		driver.findElement(By.name("username")).sendKeys("pathfinder");
		driver.findElement(By.name("password1")).sendKeys("codepath4!");
		driver.findElement(By.name("password2")).sendKeys("codepath4!");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/input[5]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).click();
		driver.findElement(By.name("username")).sendKeys("pathfinder");
		driver.findElement(By.name("password")).sendKeys("codepath4!");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/input[4]")).click();
		driver.manage().window().minimize();
	
		        // Add your code here to perform the login action
		    }
	
		//Given("user is login to ds_algo application with\"pathfinder\"and {string}")
		//public void user_is_login_to_ds_algo_application_with_pathfinder_and(String string) {
		    // Write code here that turns the phrase above into concrete actions
		//    throw new io.cucumber.java.PendingException();
		

	@Given("some other precondition")
	public void some_other_precondition() {
	    
	}

	@When("I complete action")
	public void i_complete_action() {
	}

	@When("some other action")
	public void some_other_action() {
	   
	}

	@When("yet another action")
	public void yet_another_action() {
	   
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	    
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
	    
	}

	@Given("I want to write a step with name1")
	public void i_want_to_write_a_step_with_name1() {
	    
	}

	@When("I check for the {int} in step")
	public void i_check_for_the_in_step(Integer int1) {
	    
	}

	@Then("I verify the success in step")
	public void i_verify_the_success_in_step() {
	    
	}

	@Given("I want to write a step with name2")
	public void i_want_to_write_a_step_with_name2() {
	    
	}

	@Then("I verify the Fail in step")
	public void i_verify_the_fail_in_step() {
	    
	}
	



}
