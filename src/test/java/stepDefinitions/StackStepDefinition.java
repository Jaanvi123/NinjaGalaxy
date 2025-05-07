package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.SignInPageObj;
import dsAlgoPageObjects.StackPageObj;
import dsAlgoPageObjects.TryEditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import utils.LoggerLoad;

public class StackStepDefinition {

	WebDriver driver = DriverFactory.getDriver();
	SignInPageObj signin = new SignInPageObj(driver);
	ConfigReader configReader = new ConfigReader(driver);
	IntroductionPageObj introductionpage = new IntroductionPageObj();
	HomePageObj homepage = new HomePageObj(driver);
	StackPageObj stackpage = new StackPageObj(driver);
	TryEditorPage tryeditor = new TryEditorPage(driver);
	
	@Given("The user is logged into the Ds Algo Portal")
	public void the_user_is_logged_into_the_ds_algo_protal() {
		homepage.openHomeUrl();
	}

	@When("The user clicks the Get Started button of stack section")
	public void the_user_clicks_the_get_started_button_of_stack_section() {
		introductionpage.clickStackGetStartedButton();

	}

	@Then("The user should be directed to stack Page")
	public void the_user_should_be_directed_to_stack_page() {
		String expectedTitle = "Stack"; 
		String actualTitle = stackpage.validatePageTitle();
		LoggerLoad.info("Expected: " + expectedTitle + " | Actual: " + actualTitle);
		assertEquals(expectedTitle, actualTitle, "User is not on the expected Stack page.");

	}
//TC01
	@Given("The user is on stack Page")
	public void the_user_is_on_stack_page() {
		LoggerLoad.info("The user is on stack Page");

	}

	@When("The user clicks on Operations in stack link of stack page")
	public void the_user_clicks_on_operations_in_stack_link_of_stack_page() {
			stackpage.ClickOperationsinstackLink();		
	}

	@Then("The user should be directed to Operations in stack page of stack")
	public void the_user_should_be_directed_to_operations_in_stack_page_of_stack() {

		String expectedTitle = "Operations in Stack"; 
		String actualTitle = stackpage.validatePageTitle();
		LoggerLoad.info("Expected: " + expectedTitle + " | Actual: " + actualTitle);
		assertEquals(expectedTitle, actualTitle, "User is not on the expected Stack page.");

	}
//TC02
	@Given("The user is on Operations in stack page of stack page")
	public void the_user_is_on_operations_in_stack_page_of_stack_page() {
		stackpage.ClickOperationsinstackLink();
	
	}

	@When("The user clicks on Try here button of Operations in stack Page")
	public void the_user_clicks_on_try_here_button_of_operations_in_stack_page() {
		tryeditor.PageScrolldown();
		tryeditor.clickTryHereButton();
	}

//TC03
	@Given("The user is on Operations in stack page to explore tryhere page with run button")
	public void the_user_is_on_operations_in_stack_page_to_explore_tryhere_page_with_run_button() {
		stackpage.ClickOperationsinstackLink();
		tryeditor.PageScrolldown();
		tryeditor.clickTryHereButton();
		String expectedTitle = "Operations in Stack";
		String actualTitle = introductionpage.getHomePageTitle();
		assertEquals(actualTitle, expectedTitle,
				"Page title is incorrect. Expected: " + expectedTitle + ", but found: " + actualTitle);

	}

	@When("The user clicks the Run button without entering code in the text area editor")
	public void the_user_clicks_the_run_button_without_entering_code_in_the_text_area_editor() {
			stackpage.clickRunButton();
		
	}

	@Then("The user does not see error message displayed")
	public void the_user_does_not_see_error_message_displayed() {
		LoggerLoad.info("The user does not see error message displayed");

	}
//TC04
	@Given("The user is on tryEditor  page with run button and alert window")
	public void the_user_is_on_try_editor_page_with_run_button_and_alert_window() {
		stackpage.ClickOperationsinstackLink();
		tryeditor.PageScrolldown();
		tryeditor.clickTryHereButton();
		Assert.assertTrue(stackpage.getcurrentpageUrl().endsWith("tryEditor"));

	}

	@When("The user clicks Run button in stack with invalid code from sheetname {string} and row {int}")
	public void the_user_clicks_run_button_in_stack_with_invalid_code_from_sheetname_and_row(String sheetName,
			Integer rowNumber) {
		try {
			tryeditor.enterCodeFromExcel(sheetName, rowNumber);
			tryeditor.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.error("Error while running invalid code: " + e.getMessage());
		}
	}

	@Then("The user should able to see error message in the alert window")
	public boolean the_user_should_able_to_see_error_message_in_the_alert_window() {

		try {
			Alert alert = driver.switchTo().alert();
			LoggerLoad.info("Alert found: " + alert.getText());
			alert.accept(); 
			return true;
		} catch (NoAlertPresentException e) {
			LoggerLoad.error("No alert found.");
			return false;
		}
	}
//TC05
	@Given("The user is on tryEditor page along with run button and valid code in the editor")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_in_the_editor() {
		stackpage.ClickOperationsinstackLink();
		tryeditor.PageScrolldown();
		tryeditor.clickTryHereButton();
		String expectedTitle = "Assessment"; 
		String actualTitle = stackpage.validatePageTitle();
		LoggerLoad.info("Expected: " + expectedTitle + " | Actual: " + actualTitle);
		assertEquals(actualTitle, expectedTitle,
				"Page title is incorrect. Expected: " + expectedTitle + ", but found: " + actualTitle);

	}

	@When("The user clicks Run button with valid code from the sheetname {string} and row {int} of implementation link")
	public void the_user_clicks_run_button_with_valid_code_from_the_sheetname_and_row_of_implementation_link(
			String sheetName, Integer rowNumber) {
		try {
			tryeditor.enterCodeFromExcel(sheetName, rowNumber);
			tryeditor.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.error("Error while running invalid code: " + e.getMessage());
		}

	}

	@Then("The user should able to see the output in the console")
	public void the_user_should_able_to_see_the_output_in_the_console() {
		tryeditor.CodeEditorOutput();
	}
//TC06
	@Given("The user is on stack the Page")
	public void the_user_is_on_stack_the_page() {
		String expectedTitle = "Stack";
		String actualTitle = stackpage.validatePageTitle();
		LoggerLoad.info("Actual page title: " + actualTitle);
		assertEquals("User is not on the expected page.", expectedTitle, actualTitle);

	}

	@When("The user clicks on Applications link of stack page")
	public void the_user_clicks_on_applications_link_of_stack_page() {
		
		stackpage.StackApplicationslink();

	}

	@Then("The user should be directed to Applicationk page of stack")
	public void the_user_should_be_directed_to_applicationk_page_of_stack() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String expectedTitle = "Applications";
		String actualTitle = introductionpage.getHomePageTitle();
		LoggerLoad.info("Actual page title: " + actualTitle);
		assertEquals("User is not on the expected Applications page.", expectedTitle, actualTitle);
	}
//TC07
	@Given("The user is on Application page of stack page")
	public void the_user_is_on_application_page_of_stack_page() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String expectedTitle = "Applications";
		String actualTitle = introductionpage.getHomePageTitle();
		LoggerLoad.info("Actual page title: " + actualTitle);
		assertEquals("User is not on the expected Applications page.", expectedTitle, actualTitle);

	}

	@When("The user clicks on Try here button of Application Page")
	public void the_user_clicks_on_try_here_button_of_application_page() {
		stackpage.StackApplicationslink();
		tryeditor.clickTryHereButton();
	}

	@Then("The user should be redirected to page having Editor with run button")
	public void the_user_should_be_redirected_to_page_having_editor_with_run_button() {
		String expectedTitle = "Assessment";
		String actualTitle = introductionpage.getHomePageTitle();
		// Check if the page title matches the expected title
		assertEquals("Page title is incorrect. Expected: " + expectedTitle + ", but found: " + actualTitle,
				expectedTitle, actualTitle);
	}

	@Given("The user is on Applications page to explore tryhere page with run button")
	public void the_user_is_on_applications_page_to_explore_tryhere_page_with_run_button() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		stackpage.StackApplicationslink();
		String expectedTitle = "Applications";
		String actualTitle = introductionpage.getHomePageTitle();
		LoggerLoad.info("Actual page title: " + actualTitle);
		assertEquals("User is on the expected Applications page.", expectedTitle, actualTitle);
	}

	@When("The user clicks the Run button without entering any of code in the text area editor")
	public void the_user_clicks_the_run_button_without_entering_any_of_code_in_the_text_area_editor() {
		tryeditor.clickTryHereButton();
	}

	@Then("The user does not see error message tobe displayed")
	public void the_user_does_not_see_error_message_tobe_displayed() {
		LoggerLoad.info("The user does not see error message tobe displayed");
	}

	@Given("The user is on tryEditor  page with run button and  an alert window")
	public void the_user_is_on_try_editor_page_with_run_button_and_an_alert_window() {
		stackpage.StackApplicationslink();
		tryeditor.clickTryHereButton();
		String expectedTitle = "Assessment";
		String actualTitle = introductionpage.getHomePageTitle();
		assertEquals(expectedTitle, actualTitle);

	}

	@When("The user clicks on the Run button  with invalid code from sheetname {string} and row {int}")
	public void the_user_clicks_on_the_run_button_with_invalid_code_from_sheetname_and_row(String sheetName,
			Integer rowNumber) {
		try {
			tryeditor.enterCodeFromExcel(sheetName, rowNumber);
			tryeditor.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.error("Error while running invalid code: " + e.getMessage());
		}
	}

	@Then("The user should able to see an error message in the form alert window")
	public void the_user_should_able_to_see_an_error_message_in_the_form_alert_window() {
		boolean isAlertPresent = tryeditor.HandleAlert();
		assertTrue(isAlertPresent, "No alert displayed");
	}

	@Given("The user is on tryEditor page and with run button along with valid code in the editor")
	public void the_user_is_on_try_editor_page_and_with_run_button_along_with_valid_code_in_the_editor() {
		stackpage.StackApplicationslink();
		tryeditor.clickTryHereButton();
		String expectedTitle = "Assessment";
		String actualTitle = introductionpage.getHomePageTitle();
		assertEquals(expectedTitle, actualTitle);

	}

	@When("The user clicks Run button  and with valid code from the sheetname {string} and row {int}")
	public void the_user_clicks_run_button_and_with_valid_code_from_the_sheetname_and_row(String sheetName,
			Integer rowNumber) {
		try {
			tryeditor.enterCodeFromExcel(sheetName, rowNumber);
			tryeditor.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should able to see valid output in the console")
	public void the_user_should_able_to_see_valid_output_in_the_console() {
		String consoleOutput = tryeditor.getOutputText();
		assertNotNull("Console output is null or empty.", consoleOutput);
	}

	@Given("The user is stack Page")
	public void the_user_is_stack_page() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String expectedTitle = "stack";
		String actualTitle = introductionpage.getHomePageTitle();
		// Check if the page title matches the expected title
		assertEquals(expectedTitle, actualTitle);

	}

	@When("The user clicks on  Implementation  link of stack page")
	public void the_user_clicks_on_implementation_link_of_stack_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		stackpage.ClickStackImplementationLink();
	}

	@Then("The user should be directed to  Implementation  page of stack")
	public void the_user_should_be_directed_to_implementation_page_of_stack() {

		String expectedTitle = "Implementation";
		String actualTitle = introductionpage.getHomePageTitle();
		assertEquals(expectedTitle, actualTitle,
				"Page title is incorrect. Expected: " + expectedTitle + ", but found: " + actualTitle);
	}

	@Given("The user is on  Implementation  page of stack page")
	public void the_user_is_on_implementation_page_of_stack_page() {
		stackpage.ClickStackImplementationLink();
		LoggerLoad.info("The user is on the Implemenation link");
	}

	@When("The user clicks on Try here button of  Implementation  Page")
	public void the_user_clicks_on_try_here_button_of_implementation_page() {
		stackpage.clickTryHereButton();
	}

	@Then("The user should be redirected to page having tryEditor box with run button")
	public void the_user_should_be_redirected_to_page_having_try_editor_box_with_run_button() {
		String expectedTitle = "Assessment";
		String actualTitle = introductionpage.getHomePageTitle();
		assertEquals(expectedTitle, actualTitle,
				"Page title is incorrect. Expected: " + expectedTitle + ", but found: " + actualTitle);
	}

	@Given("The user is on Implementation page to explore tryhere page with run button in stack")
	public void the_user_is_on_implementation_page_to_explore_tryhere_page_with_run_button_in_stack() {
		stackpage.ClickStackImplementationLink();
	}

	@Given("The user is on tryEditor  page with run button with alert window of stack")
	public void the_user_is_on_try_editor_page_with_run_button_with_alert_window_of_stack() {
		stackpage.ClickStackImplementationLink();
		stackpage.clickTryHereButton();

	}

	@Given("The user is on tryEditor page along with run button and valid code")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code() {
		stackpage.ClickStackImplementationLink();
		stackpage.clickTryHereButton();
	}

	@When("The user clicks Run button with valid code from sheetname {string} and row {int}")
	public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row(String sheetName, Integer rowNumber) {
		try {
			tryeditor.enterCodeFromExcel(sheetName, rowNumber);
			tryeditor.clickRunButton();
		} catch (Exception e) {

		}

	}

	@Given("The user lands on Opeartions in stack page")
	public void the_user_lands_on_opeartions_in_stack_page() {
		stackpage.ClickOperationsinstackLink();

	}

	@When("The user clicks Practice Questions link of stack page")
	public void the_user_clicks_practice_questions_link_of_stack_page() {
		stackpage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to Practice Questions page of Stack")
	public void the_user_should_be_redirected_to_practice_questions_page_of_stack() {
		String expectedTitle = "Practice Questions";
		String actualTitle = introductionpage.getHomePageTitle();
		assertEquals(expectedTitle, actualTitle,
				"Page title is incorrect. Expected: " + expectedTitle + ", but found: " + actualTitle);
	}

}
