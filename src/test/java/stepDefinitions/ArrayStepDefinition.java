package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import driverManager.DriverFactory;
import dsAlgoPageObjects.ArrayPageObj;
import dsAlgoPageObjects.DataStructurePageObj;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.SignInPageObj;
import dsAlgoPageObjects.TryEditorPage;
import io.cucumber.java.en.*;
import utils.ConfigReader;
import utils.LoggerLoad;

public class ArrayStepDefinition {

	WebDriver driver = DriverFactory.getDriver();
	HomePageObj homepage = new HomePageObj(driver);
	SignInPageObj signin = new SignInPageObj(driver);
	IntroductionPageObj introductionpage = new IntroductionPageObj();
	DataStructurePageObj dataStructurepage = new DataStructurePageObj(driver);
	TryEditorPage tryEditorpage = new TryEditorPage(driver);
	ArrayPageObj arraypage = new ArrayPageObj(driver);

	@Given("The user is logged into the DS Algo Portal with valid credentials")
	public void the_user_is_logged_into_the_ds_algo_portal_with_valid_credentials() throws InterruptedException {
		homepage.clickGetStartedHomePageButton();
		introductionpage.clickSignInLink();
		signin.enterUsernameText("username");
		signin.enterPasswordText("password");
		signin.clickloginButton();
		LoggerLoad.info("User logged in successfully and reached Home page.");
	}

	@When("The user clicks the Get Started button in Array Panel")
	public void the_user_clicks_the_get_started_button_in_array_panel() {
		introductionpage.clickArrayGetStartedButton();
	}

	@Then("The user should be navigated to the Array page")
	public void the_user_should_be_navigated_to_the_array_page() {
		String pageTitle = introductionpage.getHomePageTitle();
		LoggerLoad.info("Page title is: " + pageTitle);
		Assert.assertEquals(pageTitle, "Array", "Wrong page title! Expected: Array, but found: " + pageTitle);
		LoggerLoad.info("Correct page title displayed: " + pageTitle);

	}

//TC01

	@Given("The user is on the Array page")
	public void the_user_is_on_the_array_page() {
		String expectedTitle = "Array";
		String actualTitle = introductionpage.getHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle,
				"Expected page title: " + expectedTitle + ", but found: " + actualTitle);
	}

	@When("The user clicks the Arrays in Python link")
	public void the_user_clicks_the_arrays_in_python_link() {
		arraypage.clickarraysInPythonLink();

	}

	@Then("The user should be redirected to Arrays in Python page")
	public void the_user_should_be_redirected_to_arrays_in_python_page() {
		String pageTitle = introductionpage.getHomePageTitle();
		Assert.assertEquals(pageTitle, "Arrays in Python",
				"Expected page title: Arrays in Python, but found: " + pageTitle);
		LoggerLoad.info("Correct page title displayed: Arrays in Python");

	}

//TC02
	@Given("The user is on the Arrays in Python page")
	public void the_user_is_on_the_arrays_in_python_page() {
		arraypage.clickarraysInPythonLink();
		String pageTitle = introductionpage.getHomePageTitle();
		Assert.assertEquals(pageTitle, "Arrays in Python",
				"Expected page title: Arrays in Python, but found: " + pageTitle);
		LoggerLoad.info("Correct page title displayed: Arrays in Python");
		}
	
	@When("The user clicks Try Here button in Arrays in Python page")
	public void the_user_clicks_try_here_button_in_arrays_in_python_page() {
		tryEditorpage.clickTryHereButton();

	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button() {
		String pageTitle = introductionpage.getHomePageTitle();

		Assert.assertTrue(pageTitle.contains("Assessment") || pageTitle.contains("Editor"),
				"Unexpected page title: " + pageTitle);
		LoggerLoad.info("User successfully landed on the Try Editor page.");
	}

//TC03
	@Given("The user is on the tryEditor page with a Run button")
	public void the_user_is_on_the_try_editor_page_with_a_run_button() {
		arraypage.clickarraysInPythonLink();
		tryEditorpage.clickTryHereButton();
	}
	
	@When("The user clicks the Run button without entering the code in the code Editor")
	public void the_user_clicks_the_run_button_without_entering_the_code_in_the_code_editor() {
		try {
			tryEditorpage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Exception: ");
			e.printStackTrace();
		}
	}

	@Then("The user should not see any error message in the popup")
	public void the_user_should_not_see_any_error_message_in_the_popup() {
			LoggerLoad.info("No alert was displayed as expected.");
		
	}

// TC04
	
	@When("The user clicks Run button with invalid code from sheetname {string} and row {int} for Arrays in Python page")
	public void the_user_clicks_run_button_with_invalid_code_from_sheetname_and_row_for_arrays_in_python_page(String Sheetname, Integer RowNumber) {
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
		} catch (Exception e) {
			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
		}
	}
	
	@Then("The user should be able to see an error message in alert window")
	public boolean the_user_should_be_able_to_see_an_error_message_in_alert_window() {
		try {
			Alert alert = driver.switchTo().alert();
			LoggerLoad.info("Alert found: " + alert.getText());
			alert.accept(); // Click OK on the alert
			return true;
		} catch (NoAlertPresentException e) {
			LoggerLoad.error("No alert found.");
			return false;
		}
	}

//TC05
	@Given("The user is on the tryEditor page of Array in python")
	public void the_user_is_on_the_try_editor_page_of_array_in_python() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("The user clicks Run button with the valid code from sheetname {string} and row {int}")
	public void the_user_clicks_run_button_with_the_valid_code_from_sheetname_and_row(String Sheetname,
			Integer RowNumber) {

		arraypage.clickarraysInPythonLink();
		tryEditorpage.clickTryHereButton();
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
		} catch (Exception e) {
			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
		}

	}

	@Then("The user should be able to see output in the console")
	public void the_user_should_be_able_to_see_output_in_the_console() {
		String consoleOutput = tryEditorpage.getOutputText();
		if (consoleOutput != null && !consoleOutput.isEmpty()) {
			LoggerLoad.info("Console output: " + consoleOutput);
		} else {
			LoggerLoad.warn("Console output is null or empty.");
		}

	}

//TC06
	@Given("The user is on the Array page to explore Arrays Using List page")
	public void the_user_is_on_the_array_page_to_explore_arrays_using_list_page() {
		LoggerLoad.info("The user is on the Array page to explore Arrays Using List page");
	}
	
	@When("The user clicks the Arrays Using List link")
	public void the_user_clicks_the_arrays_using_list_link() {
		arraypage.clickarraysUsingListLink();
	}


	@Then("The user should be redirected to Arrays Using List page")
	public void the_user_should_be_redirected_to_arrays_using_list_page() {
		String pageTitle = introductionpage.getHomePageTitle();
		LoggerLoad.info("Page title is: " + pageTitle);
		Assert.assertEquals(pageTitle, "Arrays Using List",
				"Expected page title: Arrays Using List, but found: " + pageTitle);
		LoggerLoad.info("Correct page title displayed: Arrays Using List");

	}

//TC07
	@Given("The user is on the Arrays Using List page")
	public void the_user_is_on_the_arrays_using_list_page() {
		arraypage.clickarraysUsingListLink();
	}
	
	@When("The user clicks Try Here button in Arrays Using List page")
	public void the_user_clicks_try_here_button_in_arrays_using_list_page() {
		tryEditorpage.clickTryHereButton();
	}
	@Then("The user should be redirected to a page having a tryEditor with a run button")
	public void the_user_should_be_redirected_to_a_page_having_a_try_editor_with_a_run_button() {
		LoggerLoad.info("tryEditor with a run button visible");
	}

//	TC08
	@When("The user clicks the Run button without entering code in the Editor for Arrays Using List section")
	public void the_user_clicks_the_run_button_without_entering_code_in_the_editor_for_arrays_using_list_section() {
	 	tryEditorpage.clickTryHereButton();
		try {
			tryEditorpage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("button not cliked");
			e.printStackTrace();
		}
	}
	

//TC09
	@When("The user clicks Run button with invalid code from sheetname {string} and row {int} for Arrays Using List page")
	public void the_user_clicks_run_button_with_invalid_code_from_sheetname_and_row_for_arrays_using_list_page(
			String Sheetname, Integer RowNumber) {
		try {
			tryEditorpage.clickTryHereButton();
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
		} catch (Exception e) {
			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

//TC10
	@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Arrays Using List page")
	public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_arrays_using_list_page(
			String Sheetname, Integer RowNumber) {

		tryEditorpage.clickTryHereButton();
		LoggerLoad.info("Try Here Button Clicked");
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
		} catch (Exception e) {
			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

//TC11
	@When("The user clicks the Basic Operations in Lists link")
	public void the_user_clicks_the_basic_operations_in_lists_link() {
		arraypage.clickbasicOperationsInListsLink();
	}

	@Then("The user should be redirected to Basic Operations in Lists page")
	public void the_user_should_be_redirected_to_basic_operations_in_lists_page() {
		String pageTitle = introductionpage.getHomePageTitle();
		LoggerLoad.info("Page title is: " + pageTitle);
		assertEquals("Basic Operations in Lists", pageTitle,
				"Page title mismatch! Expected: Basic Operations in Lists, but found: " + pageTitle);
	}

//TC12
	@Given("The user is on Basic Operations in Lists page with tryhere button")
	public void the_user_is_on_basic_operations_in_lists_page_with_tryhere_button() {
		arraypage.clickbasicOperationsInListsLink();
	}
	@When("The user clicks Try Here button in Basic Operations in Lists page")
	public void the_user_clicks_try_here_button_in_basic_operations_in_lists_page() {
		tryEditorpage.clickTryHereButton();
	}

//TC13
	@Given("The user is on tryeditor page of Basic Operations in Lists page")
	public void the_user_is_on_try_here_page_of_basic_operations_in_lists() {
		arraypage.clickbasicOperationsInListsLink();
		tryEditorpage.clickTryHereButton();
	}
	@When("The user clicks the Run button without entering the code in the Editor for Basic Operations in Lists section")
	public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor_for_basic_operations_in_lists_section() {
		tryEditorpage.clickRunButton();
	}

//TC14
	@When("The user clicks Run button with invalid code from sheetname {string} and row {int} for Basic Operations in Lists page")
	public void the_user_clicks_run_button_with_invalid_code_from_sheetname_and_row_for_basic_operations_in_lists_page(
			String Sheetname, Integer RowNumber) {
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
			LoggerLoad.info("Run button clicked with invalid code.");
		} catch (Exception e) {
			LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

//TC15
	@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Basic Operations in Lists page")
	public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_basic_operations_in_lists_page(
			String Sheetname, Integer RowNumber) {
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
			LoggerLoad.info("Run button clicked with valid code.");
		} catch (Exception e) {
			LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

//TC16
	@When("The user clicks the Applications of Array link")
	public void the_user_clicks_the_applications_of_array_link() {
		arraypage.clickapplicationsOfArrayLink();
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button in Applications of Array link")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_in_applications_of_array_link() {
		String actualTitle = introductionpage.getHomePageTitle();
		LoggerLoad.info("Verifying page title: " + actualTitle);
		Assert.assertEquals(actualTitle, "Applications of Array", "Expected title: 'Applications of Array' but found: " + actualTitle);
	}

//TC17
	@Given("The user is on Applications of Array page")
	public void the_user_is_on_applications_of_array_page() {
		arraypage.clickapplicationsOfArrayLink();
	}
	@When("The user clicks Try Here button in Applications of Array page")
	public void the_user_clicks_try_here_button_in_applications_of_array_page() {
		tryEditorpage.clickTryHereButton();
	}

//TC18
	@When("The user clicks the Run button without entering the code in the Editor for Applications of Array section")
	public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor_for_applications_of_array_section() {
		tryEditorpage.clickRunButton();
	}

//TC19
	@When("The user clicks Run button with invalidcode from sheetname {string} and row {int} for Applications of Array page")
	public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row_for_applications_of_array_page(
			String Sheetname, Integer RowNumber) {
		tryEditorpage.clickTryHereButton();
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
			LoggerLoad.info("Run button clicked with invalid code.");
		} catch (Exception e) {
			LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

//TC20
	@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Applications of Array page")
	public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_applications_of_array_page(
			String Sheetname, Integer RowNumber) {
		tryEditorpage.clickTryHereButton();

		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
			LoggerLoad.info("Run button clicked with valid code.");
		} catch (Exception e) {
			LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

//TC21
	@When("The user clicks Practice Questions link of Array page")
	public void the_user_clicks_practice_questions_link_of_array_page() {
		arraypage.clickapplicationsOfArrayLink();
		arraypage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to page with four Practice Questions")
	public void the_user_should_be_redirected_to_page_with_four_practice_questions() {
		assertEquals("Search the array", arraypage.searchTheArrayLink.getText(),
				"Text mismatch! Expected: Search the array");
		assertEquals("Max Consecutive Ones", arraypage.maxConsecutiveOnes.getText(),
				"Text mismatch! Expected: Max Consecutive Ones");
		assertEquals("Find Numbers with Even Number of Digits", arraypage.findNumWithEvenNumOfDigits.getText(),
				"Text mismatch! Expected: Find Numbers with Even Number of Digits");
		assertEquals("Squares of a Sorted Array", arraypage.squaresOfAsortedArray.getText(),
				"Text mismatch! Expected: Squares of a Sorted Array");
	}

//TC22
	@Given("The user is on the Practice Questions page")
	public void the_user_is_on_the_practice_questions_page() {
		arraypage.clickarraysInPythonLink();
	  arraypage.clickPracticeQuestionsLink();
		
	}
	@When("The user clicks Search the array page Question link")
	public void the_user_clicks_search_the_array_page_question_link() {
		arraypage.clickSearchTheArrayLink();

	}

	@Then("The user should be redirected to try Editor page with a Run and Submit buttons")
	public void the_user_should_be_redirected_to_try_editor_page_with_a_run_and_submit_buttons() {
		String pageTitle = introductionpage.getHomePageTitle();
		Assert.assertTrue(pageTitle.contains("Assessment") || pageTitle.contains("Editor"),
				"Unexpected page title: " + pageTitle);
		LoggerLoad.info("User successfully landed on the Try Editor page.");

	}

//TC23
	@Given("The user is on the try Editor page for Search the array practice question")
	public void the_user_is_on_the_try_editor_page_for_search_the_array_practice_question() {
		 arraypage.clickarraysInPythonLink();
		arraypage.clickPracticeQuestionsLink();
		arraypage.clickSearchTheArrayLink();
		
	}



	@When("The user clicks Run button with invalidcode from sheetname {string} and row {int} for Search the array practice question")
	public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row_for_search_the_array_practice_question(
			String Sheetname, Integer RowNumber) throws InterruptedException {
		
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
			LoggerLoad.info("Run button clicked with invalid code.");
		} catch (Exception e) {
			LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should able to see an error message in alert window")
	public void the_user_should_able_to_see_an_error_message_in_alert_window() {
		boolean isAlertPresent = tryEditorpage.HandleAlert();
		assertTrue(isAlertPresent, "No alert displayed");
	}

//TC24
	
	@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Search the array practice question")
	public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_search_the_array_practice_question(
			String Sheetname, Integer RowNumber) throws InterruptedException {
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
			LoggerLoad.info("Run button clicked with valid code.");
		} catch (Exception e) {
			LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	

//TC25
	@Given("The user is on the try Editor page for Max Consecutive Ones practice question")
	public void the_user_is_on_the_try_editor_page_for_max_consecutive_ones_practice_question() {
		 arraypage.clickarraysInPythonLink();
			arraypage.clickPracticeQuestionsLink();
			arraypage.clickMaxConsecutiveOnes();
			
	}

	@When("The user clicks Run button with invalidcode from sheetname {string} and row {int}")
	public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) throws InterruptedException {
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
			LoggerLoad.info("Run button clicked with invalid code.");
		} catch (Exception e) {
			LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
		}
	
	}
	

//TC26
	@When("The user clicks Run button with validcode from sheetname {string} and row {int} for Max Consecutive Ones practice question")
	public void the_user_clicks_run_button_with_validcode_from_sheetname_and_row_for_max_consecutive_ones_practice_question(
			String Sheetname, Integer RowNumber) throws InterruptedException {
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
			LoggerLoad.info("Run button clicked with valid code.");
		} catch (Exception e) {
			LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
		}
	
	}
	

//TC27
	@Given("The user is on the try Editor page for Find Numbers with Even Number of Digits practice question")
	public void the_user_is_on_the_try_editor_page_for_find_numbers_with_even_number_of_digits_practice_question() {
		 arraypage.clickarraysInPythonLink();
			arraypage.clickPracticeQuestionsLink();
			arraypage.clickFindNumWithEvenNumOfDigits();
	}
	@When("The user clicks Run button with invalidcode from sheetname {string} and row {int} for Find Numbers with Even Number of Digits practice question")
	public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row_for_find_numbers_with_even_number_of_digits_practice_question(
			String string, Integer int1) throws InterruptedException {
		try {
			tryEditorpage.enterCodeFromExcel("tryEditorCode", 1);
			tryEditorpage.clickRunButton();
			LoggerLoad.info("Run button clicked with invalid code.");
		} catch (Exception e) {
			LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

//TC28

@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Find Numbers with Even Number of Digits practice question")
public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_find_numbers_with_even_number_of_digits_practice_question(
		String Sheetname, Integer RowNumber) throws InterruptedException {
	try {
		tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
		tryEditorpage.clickRunButton();
		LoggerLoad.info("Run button clicked with valid code.");
	} catch (Exception e) {
		LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
	}
}
	

//TC29
	@Given("The user is on the try Editor page for Squares of a Sorted Array practice question")
	public void the_user_is_on_the_try_editor_page_for_squares_of_a_sorted_array_practice_question() {
		 arraypage.clickarraysInPythonLink();
			arraypage.clickPracticeQuestionsLink();
			arraypage.clickSquaresOfASortedArray();
	}
	@When("The user clicks Run button with invalidcode from sheetname {string} and row {int} for Squares of a Sorted Array practice question")
	public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row_for_squares_of_a_sorted_array_practice_question(
			String Sheetname, Integer RowNumber) throws InterruptedException {
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
			LoggerLoad.info("Run button clicked with invalid code.");
		} catch (Exception e) {
			LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

//TC30	
	@When("The user clicks Run button with valid code from sheetname {string} and row {int} for Squares of a Sorted Array question")
	public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row_for_squares_of_a_sorted_array_question(
			String Sheetname, Integer RowNumber) throws InterruptedException {
		try {
			tryEditorpage.enterCodeFromExcel(Sheetname, RowNumber);
			tryEditorpage.clickRunButton();
			LoggerLoad.info("Run button clicked with valid code.");
		} catch (Exception e) {
			LoggerLoad.error("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

}
