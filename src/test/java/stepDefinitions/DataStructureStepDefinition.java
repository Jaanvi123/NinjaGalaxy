		package stepDefinitions;
		
		import java.time.Duration;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;
	import driverManager.DriverFactory;
		import dsAlgoPageObjects.DataStructurePageObj;
		import dsAlgoPageObjects.HomePageObj;
		import dsAlgoPageObjects.IntroductionPageObj;
		import dsAlgoPageObjects.SignInPageObj;
	import dsAlgoPageObjects.TryEditordsPage;
	import io.cucumber.java.en.Given;
		import io.cucumber.java.en.Then;
		import io.cucumber.java.en.When;
	import utils.LoggerLoad;
		
		import static org.junit.Assert.assertEquals;
		
		public class DataStructureStepDefinition {
		
		    WebDriver driver;
		    HomePageObj homepage;
		    SignInPageObj signin;
		    DataStructurePageObj dataStructurepage;
		    IntroductionPageObj introductionpage;
		    TryEditordsPage tryEditordspage;
		    public DataStructureStepDefinition() {
		    	   driver = DriverFactory.getDriver(); // ✅ Initialize driver
		           homepage = new HomePageObj(driver);
		           signin = new SignInPageObj(driver);
		           introductionpage = new IntroductionPageObj(driver);
		           dataStructurepage = new DataStructurePageObj(driver);
		           tryEditordspage = new TryEditordsPage(driver);
		    }
		    @Given("The user is logged into the DS Algo Portal with valid credentials {string} and {string}")
		    public void the_user_is_logged_into_the_ds_algo_portal_with_valid_credentials_and(String username, String password) throws InterruptedException {
		       homepage.clickGetStartedHomePageButton();
		       introductionpage.SignInLinkClick(); // Correct - SignIn link is on Introduction Page
		       signin.loginWithValidCredentials(username, password);
		       new WebDriverWait(driver, Duration.ofSeconds(10))
				            .until(ExpectedConditions.urlContains("home"));
		       LoggerLoad.info("User logged in successfully and reached Home page.");	
				    }
		
		    @When("The user clicks the Get Started button of Data Structure Introduction section")
		    public void the_user_clicks_the_get_started_button_of_data_structure_introduction_section() {
		    	introductionpage.clickDsGetStartedButton(); // ✅ Clicking from Introduction Page
		    }
		
		
		@Then("The user should be directed to  Data Structure introduction Page")
		public void the_user_should_be_directed_to_data_structure_introduction_page() {
			 // Expected title of the Data Structures Introduction page
		    String expectedTitle = "Data Structures-Introduction";
		    
		    // Get the actual title from the page
		    String actualTitle = dataStructurepage.validatePageTitle();  // Use dataStructurepage to validate title
		    
		    // Assert that the expected title matches the actual title
		    assertEquals(expectedTitle, actualTitle);
		    
		    
		    new WebDriverWait(driver, Duration.ofSeconds(10))
		    .until(ExpectedConditions.visibilityOf(dataStructurepage.dsPageTitle));
	
		    // Log the validation message
		    LoggerLoad.info("Verified that the user is on the Data Structures Introduction page. Title: " + actualTitle);
		}
		@When("The user clicks on Time Complexity link of DS Introduction page")
		public void the_user_clicks_on_time_complexity_link_of_ds_introduction_page() throws InterruptedException {
			introductionpage.clickDsGetStartedButton();
			LoggerLoad.info("Data Structures - Get Started button is clicked");
			Thread.sleep(10);
			dataStructurepage.clickTimeComplexityLink();
			LoggerLoad.info("Time Complexity Link is clicked");
		}
		
	
		@Then("The user should be directed to Time Complexity page of DS Intro page")
		public void the_user_should_be_directed_to_time_complexity_page_of_ds_intro_page() {
			
			
		    String expectedTitle = "Time Complexity";
		    
		    // Get the actual title from the page
		    String actualTitle = dataStructurepage.validatePageTitle();  // Use dataStructurepage to validate title
		    
		    // Assert that the expected title matches the actual title
		    assertEquals(expectedTitle, actualTitle);
		    
		    
	//	    new WebDriverWait(driver, Duration.ofSeconds(10))
	//	    .until(ExpectedConditions.visibilityOf(dataStructurepage.dsPageTitle));
		    LoggerLoad.info("Verified that the user is on the Time Complexity page of DS Intro page: " + actualTitle);
		}
	
		@When("The user clicks on Try here button of Time Complexity Page")
		public void the_user_clicks_on_try_here_button_of_time_complexity_page() {
			introductionpage.clickDsGetStartedButton();
			LoggerLoad.info("DS Get Started Btn Clicked");
			dataStructurepage.clickTimeComplexityLink();
			LoggerLoad.info("TimeComplexity Link Clicked");
			tryEditordspage.clickTryHereBtn();
			LoggerLoad.info("Try Here Button Clicked");
	
		}
	
		@Then("The user should be directed to a page having Editor with run button")
		public void the_user_should_be_directed_to_a_page_having_editor_with_run_button() {
			 String expectedTitle = "Assessment";
			    String actualTitle = introductionpage.getHomePageTitle();
	
			    // Check if the page title matches the expected title
			    if (expectedTitle.equals(actualTitle)) {
			        LoggerLoad.info("Page title is correct: " + actualTitle);
			    } else {
			        LoggerLoad.error("Page title is incorrect. Expected: " + expectedTitle + ", but found: " + actualTitle);
			    }
	
			    // Check if the Run button is displayed
			    WebElement runButton = driver.findElement(tryEditordspage.runButton); // Ensure the WebElement is correctly located
			    if (runButton.isDisplayed()) {
			        LoggerLoad.info("Run button is displayed.");
			    } else {
			        LoggerLoad.error("Run button is not displayed.");
			    }
			}
	
		@When("The user clicks the Run button without entering the code in the text area editor")
		public void the_user_clicks_the_run_button_without_entering_the_code_in_the_text_area_editor() {
			introductionpage.clickDsGetStartedButton();
			LoggerLoad.info("DS Get Started Btn Clicked");
			dataStructurepage.clickTimeComplexityLink();
			LoggerLoad.info("TimeComplexity Link Clicked");
	//		   if (tryEditordspage == null || driver == null) {
	//		        throw new IllegalStateException("WebDriver is not initialized or TryEditordsPage instance is not created.");
	//		    }
			tryEditordspage.clickTryHereBtn();
			LoggerLoad.info("Try Here Button Clicked");
			tryEditordspage.clickRunButton();
			LoggerLoad.info("Run Button Clicked");
	
		}
	
		@Then("The user does not see any error message displayed")
		public void the_user_does_not_see_any_error_message_displayed() {
			dataStructurepage.getcurrentpageUrl();
		}
	
		@When("The user clicks Run button with invalidcode from sheetname {string} and row {int}")
		public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row(String Sheetname, Integer RowNumber) {
			introductionpage.clickDsGetStartedButton();
			LoggerLoad.info("DS Get Started Btn Clicked");
			dataStructurepage.clickTimeComplexityLink();
			LoggerLoad.info("TimeComplexity Link Clicked");
			tryEditordspage.clickTryHereBtn();
			LoggerLoad.info("Try Here Button Clicked");
				try {
	
					tryEditordspage.enterTryHereCode("tryEditorCode", 1);
					tryEditordspage.clickRunButton();
			} catch (Exception e) {
				
				
	//			
	//			 ExcelRead excelread = new ExcelRead();
	//				String filepath = "/Users/dineshdeshmukh/eclipse-workspace/NinjaGalaxy-Jaanvi-branch/src/test/resources/TestData/TestingData.xlsx";
	//				List<Map<String, String>>testdata= excelread.readExcelSheet(filepath, sheetName);
	//			    String username = testdata.get(rowIndex).get("Username");
	//			    String password = testdata.get(rowIndex).get("Password");
	//			    String confirmpassword=testdata.get(rowIndex).get("Password confirmation");
	//			    registerPage.fillRegistrationForm(username, password, confirmpassword);
				  
	//				System.out.println("Logging in with Username: " + username + " and Password: " + password +  "and Password confirmation" + confirmpassword) ;
	//		       //     signin.enterLoginFormFields("login", 1);
	//		        registerPage.clickRegisterbtn();
				System.err.println("Error while entering code or clicking Run: " + e.getMessage());
			}
		}
	
		@Then("The user should able to see an error message in alert window")
		public void the_user_should_able_to_see_an_error_message_in_alert_window() {
			boolean isAlertPresent = tryEditordspage.handleAlert();
			if (isAlertPresent) {
			    LoggerLoad.info("Alert displayed");
			} else {
			    LoggerLoad.info("No alert displayed");
			}
		}
	
		@When("The user clicks Run button with valid code from sheetname {string} and row {int}")
		public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row(String Sheetname, Integer RowNumber) {
			introductionpage.clickDsGetStartedButton();
			LoggerLoad.info("DS Get Started Btn Clicked");
			dataStructurepage.clickTimeComplexityLink();
			LoggerLoad.info("TimeComplexity Link Clicked");
			tryEditordspage.clickTryHereBtn();
			LoggerLoad.info("Try Here Button Clicked");
			try {
	
				tryEditordspage.enterTryHereCode("tryEditorCode", 0);
				tryEditordspage.clickRunButton();
			} catch (Exception e) {
				System.err.println("Error while entering code or clicking Run: " + e.getMessage());
			}
	
		}
	
		@Then("The user should able to see output in the console")
		public void the_user_should_able_to_see_output_in_the_console() {
			String consoleOutput =tryEditordspage.getOutputText();
			if (consoleOutput != null && !consoleOutput.isEmpty()) {
			    LoggerLoad.info("Console output: " + consoleOutput);
			} else {
			    LoggerLoad.warn("Console output is null or empty.");
			}
		}
	
		@When("The user clicks Practice Questions link of DS page")
		public void the_user_clicks_practice_questions_link_of_ds_page() {
			introductionpage.clickDsGetStartedButton();
			LoggerLoad.info("DS Get Started Btn Clicked");
			dataStructurepage.clickTimeComplexityLink();
			LoggerLoad.info("TimeComplexity Link Clicked");
			dataStructurepage.clickPracticeQuestionsLink();
		}
	
		@Then("The user should be redirected to Practice Questions page  of DS")
		public void the_user_should_be_redirected_to_practice_questions_page_of_ds() {
			 String expectedTitle = "Assessment";
			    String actualTitle = introductionpage.getPageTitle();
			    
			    // Check if the page title matches the expected title
			    if (expectedTitle.equals(actualTitle)) {
			        LoggerLoad.info("Page title is correct: " + actualTitle);
			    } else {
			        LoggerLoad.error("Page title is incorrect. Expected: " + expectedTitle + ", but found: " + actualTitle);
			    }
			}
		
		
	}