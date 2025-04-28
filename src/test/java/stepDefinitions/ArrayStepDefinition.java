		package stepDefinitions;
		
		import java.time.Duration;
		import org.openqa.selenium.Alert;
		import org.openqa.selenium.NoAlertPresentException;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;
		import driverManager.DriverFactory;
		import dsAlgoPageObjects.ArrayPageObj;
		import dsAlgoPageObjects.DataStructurePageObj;
		import dsAlgoPageObjects.HomePageObj;
		import dsAlgoPageObjects.IntroductionPageObj;
		import dsAlgoPageObjects.SignInPageObj;
		import dsAlgoPageObjects.TryEditordsPage;
		import io.cucumber.java.en.*;
		
		import utils.LoggerLoad;
		
		public class ArrayStepDefinition {
		
		    WebDriver driver;
		    HomePageObj homepage;
		    SignInPageObj signin;
		    IntroductionPageObj introductionpage;
		    DataStructurePageObj dataStructurepage;
		    TryEditordsPage tryEditordspage;
		    ArrayPageObj arraypage;
		
		    // Constructor - this will run when this step definition class is created
		    public ArrayStepDefinition() {
		        driver = DriverFactory.getDriver(); // ✅ Initialize driver
		        homepage = new HomePageObj(driver);
		        signin = new SignInPageObj(driver);
		        introductionpage = new IntroductionPageObj(driver);
		        dataStructurepage = new DataStructurePageObj(driver);
		        tryEditordspage = new TryEditordsPage(driver);
		        arraypage = new ArrayPageObj(driver);
		        
		    }
		  //TC01
		    @Given("The user is logged with valid credentials {string} and {string}")
		    public void the_user_is_logged_with_valid_credentials_and(String username, String password) throws InterruptedException {
		        
		   
		    	 homepage.clickGetStartedHomePageButton();
			       introductionpage.SignInLinkClick(); // Correct - SignIn link is on Introduction Page
			       signin.loginWithValidCredentials(username, password);
			       new WebDriverWait(driver, Duration.ofSeconds(10))
					            .until(ExpectedConditions.urlContains("home"));
			       LoggerLoad.info("User logged in successfully and reached Home page.");	
		    }
		
		    @When("The user clicks the Getting Started button in Array Panel")
		    public void the_user_clicks_the_getting_started_button_in_array_panel() {
		    	
		    	arraypage.clickarrayGetStartedBtn();
		        LoggerLoad.info("Array Get Started Button Clicked");
		    }
		
		    @Then("The user should be redirected to Array page")
		    public void the_user_should_be_redirected_to_array_page() {
		    	String pageTitle = introductionpage.getPageTitle();
		    	LoggerLoad.info("Page title is: " + pageTitle);
		
		    	if (pageTitle.equals("Array")) {
		    	    LoggerLoad.info(" Correct page title displayed: Array");
		    	} else {
		    	    LoggerLoad.error(" Wrong page title! Expected: Array, but found: " + pageTitle);
		    	}
		    	LoggerLoad.info("Page title is: " + introductionpage.getPageTitle());
		    }
		  //TC02
		    
			@When("The user clicks the Arrays in Python link")
			public void the_user_clicks_the_arrays_in_python_link() {
				arraypage.clickarraysInPythonLink();
				LoggerLoad.info("Arrays in Python link Clicked");
			}
		
			@Then("The user should be redirected to Arrays in Python page")
			public void the_user_should_be_redirected_to_arrays_in_python_page() {
				String pageTitle = introductionpage.getPageTitle();
		    	LoggerLoad.info("Page title is: " + pageTitle);
		
		    	if (pageTitle.equals("Arrays in Python")) {
		    	    LoggerLoad.info(" Correct page title displayed: Array");
		    	} else {
		    	    LoggerLoad.error(" Wrong page title! Expected: Array, but found: " + pageTitle);
		    	}
		    	LoggerLoad.info("Page title is: " + introductionpage.getPageTitle());
		    }
			//TC03
			@When("The user clicks Try Here button in Arrays in Python page")
			public void the_user_clicks_try_here_button_in_arrays_in_python_page() {
				arraypage.clickarraysInPythonLink();
				tryEditordspage.clickTryHereBtn();
			}
			@Then("The user should be redirected to a page having an tryEditor with a Run button")
			public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button() throws InterruptedException {
				String pageTitle = introductionpage.getPageTitle();
		    	LoggerLoad.info("Page title is: " + pageTitle);
		    	if (pageTitle.equals("Run Button displayed")) {
		    	    LoggerLoad.info(" Correct page title displayed: Array");
		    	} else {
		    	    LoggerLoad.error(" Wrong page title! Expected: Array, but found: " + pageTitle);
		    	}
		    	LoggerLoad.info("Page title is: " + introductionpage.getPageTitle());
		    }
			//TC4
			@When("The user clicks the Run button without entering the code in the code Editor")
			public void the_user_clicks_the_run_button_without_entering_the_code_in_the_code_editor() {
				arraypage.clickarraysInPythonLink();
				tryEditordspage.clickTryHereBtn();
				tryEditordspage.clickRunButton();
				LoggerLoad.info("Run Button clicked");
			}
		
			@Then("The user should not see any error message in the popup")
			public void the_user_should_not_see_any_error_message_in_the_popup() {
				dataStructurepage.getcurrentpageUrl();
				LoggerLoad.info("No Error message displayed");
			}
			//TC05
			@When("The user clicks Run button with invalid code from sheetname {string} and row {int}")
			public void the_user_clicks_run_button_with_invalid_code_from_sheetname_and_row(String Sheetname, Integer intRowNumber) {
				arraypage.clickarraysInPythonLink();
				LoggerLoad.info("Arrays In Python Clicked");
				tryEditordspage.clickTryHereBtn();
				LoggerLoad.info("Try Here Button Clicked");
		
				try {
		
					tryEditordspage.enterTryHereCode("tryEditorCode", 1);
					tryEditordspage.clickRunButton();
				} catch (Exception e) {
					System.err.println("Error while entering code or clicking Run: " + e.getMessage());
				}
		
			}
		
			@Then("The user should be able to see an error message in alert window")
			public boolean the_user_should_be_able_to_see_an_error_message_in_alert_window() {
				// Assert.assertEquals(true, tp.handleAlert());
				try {
					Alert alert = driver.switchTo().alert();
					System.out.println("Alert found: " + alert.getText());
					alert.accept(); // Click OK on the alert
					return true;
				} catch (NoAlertPresentException e) {
					System.out.println("No alert found.");
					return false;
				}
		
			}
			//TC06
			@When("The user clicks Run button with the valid code from sheetname {string} and row {int}")
			public void the_user_clicks_run_button_with_the_valid_code_from_sheetname_and_row(String string, Integer int1) {
				arraypage.clickarraysInPythonLink();
				LoggerLoad.info("Arrays In Python Clicked");
				tryEditordspage.clickTryHereBtn();
				LoggerLoad.info("Try Here Button Clicked");
		
				try {
		
					tryEditordspage.enterTryHereCode("tryEditorCode", 0);
					tryEditordspage.clickRunButton();
				} catch (Exception e) {
					System.err.println("Error while entering code or clicking Run: " + e.getMessage());
				}
		
			}
		//	@Then use from dataStructurestepdef
			//TC07
			@When("The user clicks the Arrays Using List link")
			public void the_user_clicks_the_arrays_using_list_link() {
				arraypage.clickarraysUsingListLink();
			}
		
			@Then("The user should be redirected to Arrays Using List page")
			public void the_user_should_be_redirected_to_arrays_using_list_page() {
				String pageTitle = introductionpage.getPageTitle();
		    	LoggerLoad.info("Page title is: " + pageTitle);
		    	if (pageTitle.equals("Arrays Using List")) {
		    	    LoggerLoad.info(" Correct page title displayed: Array");
		    	} else {
		    	    LoggerLoad.error(" Wrong page title! Expected: Array, but found: " + pageTitle);
		    	}
		    	LoggerLoad.info("Page title is: " + introductionpage.getPageTitle());
		    }
			//TC08	
			@When("The user clicks Try Here button in Arrays Using List page")
			public void the_user_clicks_try_here_button_in_arrays_using_list_page() {
				arraypage.clickarraysUsingListLink();
				tryEditordspage.clickTryHereBtn();
				
			}
			
		
			//T09
			@When("The user clicks the Run button without entering the code in the Editor for Arrays Using List section")
			public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor_for_arrays_using_list_section() {
				arraypage.clickarraysUsingListLink();
				tryEditordspage.clickTryHereBtn();
				tryEditordspage.clickRunButton();
				LoggerLoad.info("Run Button clicked");
			}	
		//		@Then reusing stepdef
			
			//TC10
			@When("The user clicks Run button with invalidcode from sheetname {string} and row {int} for Arrays Using List page")
			public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row_for_arrays_using_list_page(
					String string, Integer int1) {
				arraypage.clickarraysUsingListLink();
				LoggerLoad.info("Arrays Using List link Clicked");
				tryEditordspage.clickTryHereBtn();
				LoggerLoad.info("Try Here Button Clicked");
		
				try {
					tryEditordspage.enterTryHereCode("tryEditorCode", 1);
					tryEditordspage.clickRunButton();
				} catch (Exception e) {
					System.err.println("Error while entering code or clicking Run: " + e.getMessage());
				}
			}
			
		//	 @Then reusing stepdef
			//TC11
			@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Arrays Using List page")
			public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_arrays_using_list_page(
					String string, Integer int1) {
				arraypage.clickarraysUsingListLink();
				LoggerLoad.info("Arrays Using List link Clicked");
				tryEditordspage.clickTryHereBtn();
				LoggerLoad.info("Try Here Button Clicked");
		
				try {
		
					tryEditordspage.enterTryHereCode("tryEditorCode", 0);
					tryEditordspage.clickRunButton();
				} catch (Exception e) {
					System.err.println("Error while entering code or clicking Run: " + e.getMessage());
				}
			}
		
		//	@Then reusing stepdef
			
			//--------------------------- (Basic Operations in Lists)---------------------------
			//TC12
			@When("The user clicks the Basic Operations in Lists link")
			public void the_user_clicks_the_basic_operations_in_lists_link() {
				arraypage.clickbasicOperationsInListsLink();
				LoggerLoad.info("Basic Operations in Lists-link Clicked");
			}
			
			@Then("The user should be redirected to Basic Operations in Lists page")
			public void the_user_should_be_redirected_to_basic_operations_in_lists_page() {
				String pageTitle = introductionpage.getPageTitle();
		    	LoggerLoad.info("Page title is: " + pageTitle);
		    	if (pageTitle.equals("Basic Operations in Lists")) {
		    	    LoggerLoad.info(" Correct page title displayed: Array");
		    	} else {
		    	    LoggerLoad.error(" Wrong page title! Expected: Array, but found: " + pageTitle);
		    	}
		    	LoggerLoad.info("Page title is: " + introductionpage.getPageTitle());
				
			
			}
		
		//TC13
			@When("The user clicks Try Here button in Basic Operations in Lists page")
			public void the_user_clicks_try_here_button_in_basic_operations_in_lists_page() {
				arraypage.clickbasicOperationsInListsLink();
				tryEditordspage.clickTryHereBtn();
			}
		
		//Then - called thru reusable step def and methods 
			//TC14
			@When("The user clicks the Run button without entering the code in the Editor for Basic Operations in Lists section")
			public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor_for_basic_operations_in_lists_section() {
				arraypage.clickbasicOperationsInListsLink();
				tryEditordspage.clickTryHereBtn();
				tryEditordspage.clickRunButton();
				LoggerLoad.info("Run Button clicked");
			}
		
		//Then - called thru reusable step def and methods 
		
		//TC15
			@When("The user clicks Run button with invalidcode from sheetname {string} and row {int} for Basic Operations in Lists page")
			public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row_for_basic_operations_in_lists_page(
					String string, Integer int1) {
				arraypage.clickbasicOperationsInListsLink();
				LoggerLoad.info("Basic Operations in Lists Clicked");
				tryEditordspage.clickTryHereBtn();
				LoggerLoad.info("Try Here Button Clicked");
		
				try {
		
					tryEditordspage.enterTryHereCode("tryEditorCode", 1);
					tryEditordspage.clickRunButton();
				} catch (Exception e) {
					System.err.println("Error while entering code or clicking Run: " + e.getMessage());
				}
			}
		
		//TC16
			@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Basic Operations in Lists page")
			public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_basic_operations_in_lists_page(
					String Sheetname, Integer RowNumber) {
				arraypage.clickbasicOperationsInListsLink();
				LoggerLoad.info("Basic Operations in Lists Clicked");
				tryEditordspage.clickTryHereBtn();
				LoggerLoad.info("Try Here Button Clicked");
		
				try {
		
					tryEditordspage.enterTryHereCode("tryEditorCode", 0);
					tryEditordspage.clickRunButton();
				} catch (Exception e) {
					System.err.println("Error while entering code or clicking Run: " + e.getMessage());
				}
			}
			//--------------------------- (Applications of Array)---------------------------
		
			//TC17 
				@When("The user clicks the Applications of Array link")
				public void the_user_clicks_the_applications_of_array_link() {
					arraypage.clickapplicationsOfArrayLink();
				}
		
				@Then("The user should be redirected to Applications of Array page")
				public void the_user_should_be_redirected_to_applications_of_array_page() {
					String pageTitle = introductionpage.getPageTitle();
			    	LoggerLoad.info("Page title is: " + pageTitle);
			    	if (pageTitle.equals("Applications of Array")) {
			    	    LoggerLoad.info(" Correct page title displayed: Array");
			    	} else {
			    	    LoggerLoad.error(" Wrong page title! Expected: Array, but found: " + pageTitle);
			    	}
			    	LoggerLoad.info("Page title is: " + introductionpage.getPageTitle());
				
				}
		
			//TC18
				@When("The user clicks Try Here button in Applications of Array page")
				public void the_user_clicks_try_here_button_in_applications_of_array_page() throws InterruptedException {
					arraypage.clickapplicationsOfArrayLink();
					tryEditordspage.clickTryHereBtn();
		
				}
		
			//TC19
				@When("The user clicks the Run button without entering the code in the Editor for Applications of Array section")
				public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor_for_applications_of_array_section() {
					arraypage.clickapplicationsOfArrayLink();
					tryEditordspage.clickTryHereBtn();
					tryEditordspage.clickRunButton();
					LoggerLoad.info("Run Button clicked");
		
				}
		
			//TC20
				@When("The user clicks Run button with invalidcode from sheetname {string} and row {int} for Applications of Array page")
				public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row_for_applications_of_array_page(
						String Sheetname, Integer RowNumber) {
					arraypage.clickapplicationsOfArrayLink();
					tryEditordspage.clickTryHereBtn();
					LoggerLoad.info("Try Here Button Clicked");
		
					try {
						tryEditordspage.enterTryHereCode("tryEditorCode", 1);
						tryEditordspage.clickRunButton();
					} catch (Exception e) {
						System.err.println("Error while entering code or clicking Run: " + e.getMessage());
					}
				}
		
			//TC21
				@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Applications of Array page")
				public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_applications_of_array_page(
						String Sheetname, Integer RowNumber) {
					arraypage.clickapplicationsOfArrayLink();
					tryEditordspage.clickTryHereBtn();
					LoggerLoad.info("Try Here Button Clicked");
		
					try {
						tryEditordspage.enterTryHereCode("tryEditorCode", 0);
						tryEditordspage.clickRunButton();
					} catch (Exception e) {
						System.err.println("Error while entering code or clicking Run: " + e.getMessage());
					}
				}
		
			//--------------------------- (Practice Questions Validations)------------------------------------------------------
		
			//TC22
				@When("The user clicks Practice Questions link of Array page")
				public void the_user_clicks_practice_questions_link_of_array_page() throws InterruptedException {
					arraypage.clickapplicationsOfArrayLink();
					LoggerLoad.info("Applications of Array link clicked");
					arraypage.clickPracticeQuestionsLink();
					LoggerLoad.info("Practice Questions Link Clicked");
				}
		
				@Then("The user should be redirected to page with four Practice Questions")
				public void the_user_should_be_redirected_to_page_with_four_practice_questions() {
					
					    String actualText1 = arraypage.searchTheArrayLink.getText();
					    if (actualText1.equals("Search the array")) {
					        LoggerLoad.info("Text matched: " + actualText1);
					    } else {
					        LoggerLoad.error("Text mismatch! Expected: Search the array, but Found: " + actualText1);
					    }
		
					    String actualText2 = arraypage.maxConsecutiveOnes.getText();
					    if (actualText2.equals("Max Consecutive Ones")) {
					        LoggerLoad.info("Text matched: " + actualText2);
					    } else {
					        LoggerLoad.error("Text mismatch! Expected: Max Consecutive Ones, but Found: " + actualText2);
					    }
		
					    String actualText3 = arraypage.findNumWithEvenNumOfDigits.getText();
					    if (actualText3.equals("Find Numbers with Even Number of Digits")) {
					        LoggerLoad.info("Text matched: " + actualText3);
					    } else {
					        LoggerLoad.error("Text mismatch! Expected: Find Numbers with Even Number of Digits, but Found: " + actualText3);
					    }
		
					    String actualText4 = arraypage.squaresOfAsortedArray.getText();
					    if (actualText4.equals("Squares of a Sorted Array")) {
					        LoggerLoad.info("Text matched: " + actualText4);
					    } else {
					        LoggerLoad.error("Text mismatch! Expected: Squares of a Sorted Array, but Found: " + actualText4);
					    }		
					}
		
		
			//TC23
				@When("The user clicks Search the array page Question link")
				public void the_user_clicks_search_the_array_page_question_link() throws InterruptedException {
					arraypage.clickapplicationsOfArrayLink();
					LoggerLoad.info("Applications of Array link clicked");
					arraypage.clickPracticeQuestionsLink();
					LoggerLoad.info("Practice Questions Link Clicked");
					arraypage.clickSearchTheArrayLink();
					LoggerLoad.info("Search the array Link Clicked");
				}
		
				@Then("The user should be redirected to try Editor page with a Run and Submit buttons")
				public void the_user_should_be_redirected_to_try_editor_page_with_a_run_and_submit_buttons() {
					if (introductionpage.validateElementDisplayed(arraypage.runButton)) {
					    LoggerLoad.info(" Run Button is displayed.");
					} else {
					    LoggerLoad.error(" Run Button is NOT displayed.");
					}
		
					if (introductionpage.validateElementDisplayed(arraypage.submitButton)) {
					    LoggerLoad.info("Submit Button is displayed.");
					} else {
					    LoggerLoad.error("Submit Button is NOT displayed.");
					}
		
				}
			//TC24
		
				@When("The user clicks Run button with invalidcode from sheetname {string} and row {int} for Search the array practice question")
				public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row_for_search_the_array_practice_question(
						String string, Integer int1) throws InterruptedException {
					arraypage.clickapplicationsOfArrayLink();
					LoggerLoad.info("Applications of Array link clicked");
					arraypage.clickPracticeQuestionsLink();
					LoggerLoad.info("Practice Questions Link Clicked");
					arraypage.clickSearchTheArrayLink();
					LoggerLoad.info("Search the array Link Clicked");
		
					try {
		
						tryEditordspage.enterTryHereCode("tryEditorCode", 1);
						tryEditordspage.clickRunButton();
					} catch (Exception e) {
						System.err.println("Error while entering code or clicking Run: " + e.getMessage());
					}
		
				}
		
			//TC25
				@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Search the array practice question")
				public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_search_the_array_practice_question(
						String string, Integer int1) throws InterruptedException {
					arraypage.clickapplicationsOfArrayLink();
					LoggerLoad.info("Applications of Array link clicked");
					arraypage.clickPracticeQuestionsLink();
					LoggerLoad.info("Practice Questions Link Clicked");
					arraypage.clickSearchTheArrayLink();
					LoggerLoad.info("Search the array Link Clicked");
		
					try {
		
						tryEditordspage.enterTryHereCode("tryEditorCode", 0);
						tryEditordspage.clickRunButton();
					} catch (Exception e) {
						System.err.println("Error while entering code or clicking Run: " + e.getMessage());
					}
		
				}
		
			//TC26
		
				@When("The user clicks Run button with invalidcode from sheetname {string} and row {int} for Max Consecutive Ones practice question")
				public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row_for_max_consecutive_ones_practice_question(
						String string, Integer int1) throws InterruptedException {
					arraypage.clickarraysInPythonLink();
					LoggerLoad.info("Arrays in Python link clicked");
					arraypage.clickPracticeQuestionsLink();
					LoggerLoad.info("Practice Questions Link Clicked");
					arraypage.clickMaxConsecutiveOnes();
					LoggerLoad.info("Max Consecutive Ones Link Clicked");
		
					try {
		
						tryEditordspage.enterTryHereCode("tryEditorCode", 1);
						tryEditordspage.clickRunButton();
					} catch (Exception e) {
						System.err.println("Error while entering code or clicking Run: " + e.getMessage());
					}
		
				}
		
			//TC27
				@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Max Consecutive Ones question")
				public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_max_consecutive_ones_question(
						String string, Integer int1) throws InterruptedException {
					arraypage.clickarraysInPythonLink();
					LoggerLoad.info("Arrays in Python link clicked");
					arraypage.clickPracticeQuestionsLink();
					LoggerLoad.info("Practice Questions Link Clicked");
					arraypage.clickMaxConsecutiveOnes();
					LoggerLoad.info("Max Consecutive Ones Link Clicked");
		
					try {
		
						tryEditordspage.enterTryHereCode("tryEditorCode", 0);
						tryEditordspage.clickRunButton();
					} catch (Exception e) {
						System.err.println("Error while entering code or clicking Run: " + e.getMessage());
					}
				}
		
			//TC28
				@When("The user clicks Run button with invalidcode from sheetname {string} and row {int} for Find Numbers with Even Number of Digits practice question")
				public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row_for_find_numbers_with_even_number_of_digits_practice_question(
						String string, Integer int1) throws InterruptedException {
					arraypage.clickarraysUsingListLink();
					LoggerLoad.info("Arrays Using List link clicked");
					arraypage.clickPracticeQuestionsLink();
					LoggerLoad.info("Practice Questions Link Clicked");
					arraypage.clickFindNumWithEvenNumOfDigits();
					LoggerLoad.info("Find Numbers with Even Number of Digits Link Clicked");
		
					try {
		
						tryEditordspage.enterTryHereCode("tryEditorCode", 1);
						tryEditordspage.clickRunButton();
					} catch (Exception e) {
						System.err.println("Error while entering code or clicking Run: " + e.getMessage());
					}
				}
		
			//TC29
				@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Find Numbers with Even Number of Digits question")
				public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_find_numbers_with_even_number_of_digits_question(
						String string, Integer int1) throws InterruptedException {
					arraypage.clickarraysUsingListLink();
					LoggerLoad.info("Arrays Using List link clicked");
					arraypage.clickPracticeQuestionsLink();
					LoggerLoad.info("Practice Questions Link Clicked");
					arraypage.clickFindNumWithEvenNumOfDigits();
					LoggerLoad.info("Find Numbers with Even Number of Digits Link Clicked");
		
					try {
		
						tryEditordspage.enterTryHereCode("tryEditorCode", 0);
						tryEditordspage.clickRunButton();
					} catch (Exception e) {
						System.err.println("Error while entering code or clicking Run: " + e.getMessage());
					}
				}
			//TC30
		
				@When("The user clicks Run button with invalidcode from sheetname {string} and row {int} for Squares of a Sorted Array practice question")
				public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row_for_squares_of_a_sorted_array_practice_question(
						String string, Integer int1) throws InterruptedException {
					arraypage.clickbasicOperationsInListsLink();
					LoggerLoad.info("Basic Operations In Lists link clicked");
					arraypage.clickPracticeQuestionsLink();
					LoggerLoad.info("Practice Questions Link Clicked");
					arraypage.clickSquaresOfASortedArray();
					LoggerLoad.info("Squares of a Sorted Array Link Clicked");
		
					try {
		
						tryEditordspage.enterTryHereCode("tryEditorCode", 1);
						tryEditordspage.clickRunButton();
					} catch (Exception e) {
						System.err.println("Error while entering code or clicking Run: " + e.getMessage());
					}
		
				}
		
			//TC31
				@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Squares of a Sorted Array question")
				public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_squares_of_a_sorted_array_question(
						String string, Integer int1) throws InterruptedException {
					arraypage.clickbasicOperationsInListsLink();
					LoggerLoad.info("Basic Operations In Lists link clicked");
					arraypage.clickPracticeQuestionsLink();
					LoggerLoad.info("Practice Questions Link Clicked");
					arraypage.clickSquaresOfASortedArray();
					LoggerLoad.info("Squares of a Sorted Array Link Clicked");
		
					try {
		
						tryEditordspage.enterTryHereCode("tryEditorCode", 0);
						tryEditordspage.clickRunButton();
					} catch (Exception e) {
						System.err.println("Error while entering code or clicking Run: " + e.getMessage());
					}
		
				}
		
			}
		//Then - called thru reusable step def and methods 
			
			
		
