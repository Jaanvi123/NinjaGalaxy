	package stepDefinitions;
	
	import static org.testng.Assert.assertEquals;
	import static org.testng.Assert.assertTrue;
	
	import java.io.IOException;
	import java.util.List;
	import java.util.Map;
	import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import driverManager.DriverFactory;
	import dsAlgoPageObjects.HomePageObj;
	
	import dsAlgoPageObjects.RegisterPageObj;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import utils.ExcelRead;
	import utils.LoggerLoad;
	
	public class RegisterStepDefinition {
	
		WebDriver driver = DriverFactory.getDriver();
	    HomePageObj homepage = new HomePageObj(driver) ;
	    RegisterPageObj registerPage = new RegisterPageObj(DriverFactory.getDriver());
		 WebElement getstartedBtn;
			 
	       
	  

	    // Given step: Navigating to the registration page
	    @Given("The user is on the new user registration page")
	    public void the_user_is_on_the_new_user_registration_page() {
	       DriverFactory.initializeDriver("chrome");  // Initialize the WebDriver
	        homepage.clickGetStartedHomePageButton(); // Navigate to homepage
	       
	        registerPage.navigateToRegisterPage();  // Navigate to the registration page
	    }


    // When step: Register button clicked with all fields empty
   @When("The user clicks Register button with all fields empty on registration form from sheetname {string} and row {int}")
    public void the_user_clicks_register_button_with_all_fields_empty_on_registration_form_from_sheetname_and_row(String sheetName, Integer rowIndex) throws IOException, OpenXML4JException, InterruptedException {
        ExcelRead excelread = new ExcelRead();
		String filepath = "/Users/dineshdeshmukh/eclipse-workspace/NinjaGalaxy-Jaanvi-branch/src/test/resources/TestData/TestingData.xlsx";
		List<Map<String, String>>testdata= excelread.readExcelSheet(filepath, sheetName);
	    String username = testdata.get(rowIndex).get("Username");
	    String password = testdata.get(rowIndex).get("Password");
	    String confirmpassword=testdata.get(rowIndex).get("Password confirmation");
	    registerPage.fillRegistrationForm(username, password, confirmpassword);
	  
		System.out.println("Logging in with Username: " + username + " and Password: " + password +  "and Password confirmation" + confirmpassword) ;
       //     signin.enterLoginFormFields("login", 1);
        registerPage.clickRegisterbtn();


    }

    // Then step: Assert error message below the Username textbox
    @Then("It should display an error {string} below Username textbox")
    public void it_should_display_an_error_below_username_textbox(String expectedMessage) {
    	 String actualMessage = registerPage.getValidationMessageForUsername().replaceAll("\\s+", " ").trim();

    	    // Log both expected and actual messages for debugging purposes
    	    LoggerLoad.info("Expected message: '" + expectedMessage.replaceAll("\\s+", " ").trim() + "'");
    	    LoggerLoad.info("Actual message: '" + actualMessage + "'");

    	    // Compare the messages after normalization
    	    assertEquals(actualMessage, expectedMessage.replaceAll("\\s+", " ").trim(), "Validation message mismatch!");  
    	}

   //  When step: Register button clicked after entering different passwords
   @When("The User clicks Register button after entering different passwords in sheetname {string} and row {int}")
	    		public void the_user_clicks_register_button_after_entering_different_passwords_in_sheetname_and_row(String sheetName, Integer rowIndex) throws IOException, OpenXML4JException, InterruptedException {
	       ExcelRead excelread = new ExcelRead();
		String filepath = "/Users/dineshdeshmukh/eclipse-workspace/NinjaGalaxy-Jaanvi-branch/src/test/resources/TestData/TestingData.xlsx";
		List<Map<String, String>>testdata= excelread.readExcelSheet(filepath, sheetName);
	    String username = testdata.get(rowIndex).get("Username");
	    String password = testdata.get(rowIndex).get("Password");
	    String confirmpassword=testdata.get(rowIndex).get("Password confirmation");
	    registerPage.fillRegistrationForm(username, password, confirmpassword);
	  
		    System.out.println("Logging in with Username: " + username + " and Password: " + password +  "and Password confirmation" + confirmpassword) ;
	     
	          registerPage.clickRegisterbtn();
	    	}
	

	    // Then step: Assert warning message below the registration form
	    @Then("The user see warning message {string} below")
	    public void the_user_see_warning_message_below(String expectedMessage) {
	    	   // Call verifyErrorMessage and store the actual message
	        String actualMessage = registerPage.verifyErrorMessage(expectedMessage).trim();
	
	        // Log both expected and actual messages for debugging purposes
	        LoggerLoad.info("Expected message: '" + expectedMessage + "'");  // Log exact value
	        LoggerLoad.info("Actual message: '" + actualMessage + "'");  // Log exa
	        // Compare the messages after trimming both expected and actual
	        
	        
	        actualMessage = actualMessage.replaceAll("[\\n\\r]", "").trim();
	        expectedMessage = expectedMessage.replaceAll("[\\n\\r]", "").trim();
	
	        assertEquals(actualMessage, expectedMessage.trim(), "Validation message mismatch!");  
	    }
	    
	    
	    
	
	    // When step: User enters valid username, password, and confirm password from the Excel sheet
	    @When("User enters valid username, password,confirm_password from sheetname {string} and row  {int}")
	    public void user_enters_valid_username_password_confirm_password_from_sheetname_and_row(String sheetName, Integer rowIndex) throws Exception {
	        ExcelRead excelread = new ExcelRead();
	    	String filepath = "/Users/dineshdeshmukh/eclipse-workspace/NinjaGalaxy-Jaanvi-branch/src/test/resources/TestData/TestingData.xlsx";
	    	List<Map<String, String>>testdata= excelread.readExcelSheet(filepath, sheetName);
	        String username = testdata.get(rowIndex).get("Username");
	        String password = testdata.get(rowIndex).get("Password");
	        String confirmpassword=testdata.get(rowIndex).get("Password confirmation");
	        registerPage.fillRegistrationForm(username, password, confirmpassword);
	      
	    	    System.out.println("Logging in with Username: " + username + " and Password: " + password +  " and Password confirmation: " + confirmpassword) ;
	       
	              registerPage.clickRegisterbtn();
	        	}


	    // Then step: Assert user is redirected to the homepage after successful registrati
	
	@Then("The User should be redirected to HomePage of DS_Algo and see successful message {string}  on the DS_Algo HomePage")
	public void the_user_should_be_redirected_to_home_page_of_ds_algo_and_see_successful_message_on_the_ds_algo_home_page(String expectedMessage) {
	
		
		    // Get success message from homepage
		String actualMessage = homepage.getRegisterSuccessMessage();  // Get success message from homepage
	
	    // If the registration failed, it will contain "password_mismatch"
	    if (actualMessage.contains("You are logged in")) {
	        LoggerLoad.info("Success message verified: " + actualMessage);        
	    } else {
	        assertTrue(false, "Password mismatch error: " + actualMessage);
	        LoggerLoad.error("Success message mismatch! Actual: '" + actualMessage + "' Expected: '" + expectedMessage + "'");
	            assertEquals(actualMessage, expectedMessage, "Success message mismatch!");
	        }
	    }

	    


	    // When step: User clicks on the signout button
	    @When("User clicks on signout")
	    public void user_clicks_on_signout() {
	       
	        homepage.SignOut();  // Perform signout action
	    }
	
	    // Then step: Assert user lands on the homepage after signing out
	    @Then("User lands on homePage with signout")
	    public void user_lands_on_home_page_with_signout() {
	        LoggerLoad.info("You are on the homepage.");
	        LoggerLoad.info("Logged out successfully.");
	    }
	}
