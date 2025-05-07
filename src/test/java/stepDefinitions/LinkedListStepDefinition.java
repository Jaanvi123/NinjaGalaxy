package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.LinkedListPageObj;
import dsAlgoPageObjects.SignInPageObj;
import dsAlgoPageObjects.TreePageObj;
import dsAlgoPageObjects.TryEditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import utils.LoggerLoad;

public class LinkedListStepDefinition {

	WebDriver driver = DriverFactory.getDriver();
	SignInPageObj signin = new SignInPageObj(driver);
	ConfigReader configReader = new ConfigReader(driver);
	IntroductionPageObj introductionpage = new IntroductionPageObj();
	HomePageObj homepage = new HomePageObj(driver);
	TreePageObj treePage = new TreePageObj(driver);
	LinkedListPageObj LinkedList = new LinkedListPageObj(driver);
	TryEditorPage tryEditorPage = new TryEditorPage(driver);

	@Given("The user is on home page of ds algo portal")
	public void the_user_is_on_home_page_of_ds_algo_portal() throws IOException {
		homepage.openHomeUrl();

	}

	@When("The user clicks Sign in link and enters valid credentials to sign in")
	public void the_user_clicks_sign_in_link_and_enters_valid_credentials_to_sign_in()
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		introductionpage.clickgetStartedButton(driver);
		introductionpage.clickSignInLink();
		signin.enterUsernameText("username");
		signin.enterPasswordText("password");
		signin.clickloginButton();
	}

	@Then("The user should land on the Linked list page by clicking Get started button for Linked list module")
	public void the_user_should_land_on_the_linked_list_page_by_clicking_get_started_button_for_linked_list_module() {
		introductionpage.clickLinkedListGetStartedButton();
		
		Assert.assertEquals(introductionpage.getHomePageTitle(), "Linked List");
	}

//TC01

	@Given("The user is on the Linked List page after signing in")
	public void the_user_is_on_linked_list_page_after_signing_in() {
		LinkedList.LinkedListTitle();

	}

	@When("The user clicks the Introduction link")
	public void the_user_clicks_the_introduction_link() {
		LinkedList.clickIntroductionLink();
	}

	@Then("The user should be redirected to the Introduction page")
	public void the_user_should_be_redirected_to_the_introduction_page() {
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("linked-list/introduction/"));
	}

//TC02
	@Given("The user is on the Introduction page ")
	public void the_user_is_on_introduction_page() {
		LinkedList.clickIntroductionLink();
	}

	@When("The user clicks Try Here button on the Introduction page")
	public void the_user_clicks_try_here_button_on_introduction_page() {
		tryEditorPage.PageScrolldown();
		tryEditorPage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button on the Introduction page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_on_introduction_page() {
		LinkedList.getCurrentPageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}

//TC03
	@Given("The user is on the tryEditor page after clicking Try here button on the Introduction page")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_on_the_introduction_page() {
		LinkedList.clickIntroductionLink();
	}

	@When("The user enters an empty code in editor of Introduction page and clicks Run button")
	public void the_user_entes_an_empty_code_in_editor_of_introduction_page_and_clicks_run_button() {
		tryEditorPage.PageScrolldown();
		tryEditorPage.clickTryHereButton();
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Introduction page")
	public void no_error_message_is_displayed_for_try_editor_of_introduction_page() {
		LinkedList.getCurrentPageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}

//TC04
	@Given("The user is on the tryEditor page and clicks Try here button on the Introduction page")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_on_the_introduction_page() {
		LinkedList.clickIntroductionLink();
		tryEditorPage.PageScrolldown();
		tryEditorPage.clickTryHereButton();

	}

	@When("The user writes invalid code in the editor on the Introduction page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_on_the_introduction_page_and_clicks_run_button_from_sheetname_and_row(
			String sheetName, Integer rowNumber) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to get alert on the Introduction page TryEditor page")
	public void the_user_should_able_to_get_alert_on_the_introduction_page_tryeditor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
		assertTrue(isAlertPresent, "No alert displayed");

	}

	// TC05
	@Given("The user is on the tryEditor page along with run button and valid code on the Introduction page")
	public void the_user_is_on_the_try_editor_page_along_with_run_button_and_valid_codeon_the_introduction_page() {
		LinkedList.clickIntroductionLink();
		tryEditorPage.PageScrolldown();
		tryEditorPage.clickTryHereButton();

	}

	@When("The user writes valid Python code in the editor on the Introduction page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_on_the_introduction_page_and_clicks_run_button_from_sheetname_and_row(
			String sheetName, Integer rowNumber) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to see output in the console on the Introduction page")
	public void the_user_should_be_able_to_see_output_in_the_console_on_the_introduction_page() {
		tryEditorPage.CodeEditorOutput();
	}

	// TC06
	@Given("The user is on the Introduction page after signing in")
	public void the_user_is_on_the_introduction_page_after_signing_in() {
		LinkedList.clickIntroductionLink();
	}

	@When("The user clicks the Practice Questions link present on the Introduction page")
	public void the_user_clicks_the_practice_questions_link_present_on_the_introduction_page() {
		LinkedList.clickPracticeQueLink();
	}

	@Then("The user should be redirected to the Practice Questions page from the Introduction page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_the_introduction_page() {
		LinkedList.getCurrentPageUrl();
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("practice"));
	}

//TC07
	@Given("The user is on the Linked list page after valid sign in")
	public void the_user_is_on_the_linked_list_page_after_valid_sign_in() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user clicks the Creating Linked List link")
	public void the_user_clicks_the_creating_linked_list_link() {
		LinkedList.clickcreatingLinkedListLink();
	}

	@Then("The user should be redirected to the Creating Linked List page")
	public void the_user_should_be_redirected_to_the_creating_linked_list_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("creating-linked-list/"));
	}

	// TC08
	@Given("The user is on the Creating Linked List page")
	public void the_user_is_on_the_creating_linked_list_page() {
		LinkedList.clickcreatingLinkedListLink();
	}

	@When("The user clicks Try Here button in Creating Linked List page")
	public void the_user_clicks_try_here_button_in_creating_linked_list_page() {
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@Then("The user is redirected to a page having Editor with run button for Creating Linked List page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_creating_linked_list_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC09
	@Given("The user is on the tryEditor page after clicking Try here button in Creating Linked List page")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_creating_linked_list_page() {
		LinkedList.clickcreatingLinkedListLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();

	}

	@When("The user enters an empty code in editor of Creating Linked List page and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_creating_linked_list_page_and_clicks_run_button() {

		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Creating Linked List page")
	public void no_error_message_is_displayed_for_try_editor_of_creating_linked_list_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC10
	@Given("The user is on the tryEditor page and clicks Try here button in Creating Linked List page")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_creating_linked_list_page() {
		LinkedList.clickcreatingLinkedListLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes invalid code in the editor of Creating Linked List page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_creating_linked_list_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to get alert on Creating Linked List page")
	public void the_user_should_be_able_to_get_alert_on_creating_linked_list_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
		assertTrue(isAlertPresent, "No alert displayed");
	}

	// TC11
	@Given("The user is on tryEditor page along with run button and valid code for Creating Linked List page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_creating_linked_list_page() {
		LinkedList.clickcreatingLinkedListLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes valid Python code in the editor of Creating Linked List page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_creating_linked_list_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

//TC12
	@Then("The user should be able to see output in the console for Creating Linked List page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_creating_linked_list_page() {
		tryEditorPage.CodeEditorOutput();
	}

	@Given("The user is on Creating Linked List page after signing in")
	public void the_user_is_on_creating_linked_list_page_after_signing_in() {
		LinkedList.clickcreatingLinkedListLink();
	}

	@When("The user clicks the Practice Questions link present in Creating Linked List page")
	public void the_user_clicks_the_practice_questions_link_present_in_creating_linked_list_page() {
		LinkedList.clickPracticeQueLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Creating Linked List page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_creating_linked_list_page() {
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC13
	@Given("The user is on the Types of Linked List data structure page")
	public void the_user_is_on_the_types_of_linked_list_data_structure_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user clicks the Types of Linked List link")
	public void the_user_clicks_the_types_of_linked_list_link() {
		LinkedList.clickTypesOfLinkedListLink();
	}

	@Then("The user should be redirected to the Types of Linked List page")
	public void the_user_should_be_redirected_to_the_types_of_linked_list_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("types-of-linked-list/"));
	}

	// TC14
	@Given("The user is on the Types of Linked List page")
	public void the_user_is_on_the_types_of_linked_list_page() {
		LinkedList.clickTypesOfLinkedListLink();
	}

	@When("The user clicks Try Here button in Types of Linked List page")
	public void the_user_clicks_try_here_button_in_types_of_linked_list_page() {
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@Then("The user is redirected to a page having Editor with run button for Types of Linked List page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_types_of_linked_list_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC15
	@Given("The user is on the tryEditor page after clicking Try here button in Types of Linked List link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_types_of_linked_list_link() {
		LinkedList.clickTypesOfLinkedListLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();

	}

	@When("The user enters an empty code in editor of Types of Linked List link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_types_of_linked_list_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Types of Linked List page")
	public void no_error_message_is_displayed_for_try_editor_of_types_of_linked_list_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC16
	@Given("The user is on the tryEditor page and clicks Try here button in Types of Linked List page")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_types_of_linked_list_page() {
		LinkedList.clickTypesOfLinkedListLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes invalid code in the editor of Types of Linked List page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_types_of_linked_list_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to get alert on Types of Linked List TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_types_of_linked_list_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
		assertTrue(isAlertPresent, "No alert displayed");
	}

	// TC17
	@Given("The user is on tryEditor page along with run button and valid code for Types of Linked List page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_types_of_linked_list_page() {
		LinkedList.clickTypesOfLinkedListLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes valid Python code in the editor of Types of Linked List page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_types_of_linked_list_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to see output in the console for Types of Linked List page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_types_of_linked_list_page() {
		tryEditorPage.CodeEditorOutput();
	}

//TC18
	@Given("The user is on Types of Linked List page after signing in")
	public void the_user_is_on_types_of_linked_list_page_after_signing_in() {
		LinkedList.clickTypesOfLinkedListLink();
	}

	@When("The user clicks the Practice Questions link present in Types of Linked List page")
	public void the_user_clicks_the_practice_questions_link_present_in_types_of_linked_list_page() {
		LinkedList.clickPracticeQueLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Types of Linked List page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_types_of_linked_list_page() {
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC19
	@Given("The user is on the Implement Linked List in Python data structure page")
	public void the_user_is_on_the_implement_linked_list_in_python_data_structure_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user clicks the Implement Linked List in Python link")
	public void the_user_clicks_the_implement_linked_list_in_python_link() {
		LinkedList.clickImplementLLinPythonLink();
	}

	@Then("The user should be redirected to the Implement Linked List in Python data structure page")
	public void the_user_should_be_redirected_to_the_implement_linked_list_in_python_data_structure_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("implement-linked-list-in-python/"));
	}

	// TC20
	@Given("The user is on the Implement Linked List in Python page")
	public void the_user_is_on_the_implement_linked_list_in_python_page() {
		LinkedList.clickImplementLLinPythonLink();
	}

	@When("The user clicks Try Here button in Implement Linked List in Python page")
	public void the_user_clicks_try_here_button_in_implement_linked_list_in_python_page() {
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@Then("The user is redirected to a page having Editor with run button for Implement Linked List in Python page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_implement_linked_list_in_python_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC21
	@Given("The user is on the tryEditor page after clicking Try here button in Implement Linked List in Python link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_implement_linked_list_in_python_link() {
		LinkedList.clickImplementLLinPythonLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();

	}

	@When("The user enters an empty code in editor of Implement Linked List in Python link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_implement_linked_list_in_python_link_and_clicks_run_button() {

		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Implement Linked List in Python page")
	public void no_error_message_is_displayed_for_try_editor_of_implement_linked_list_in_python_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC22
	@Given("The user is on the tryEditor page and clicks Try here button in Implement Linked List in Python page")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_implement_linked_list_in_python_page() {
		LinkedList.clickImplementLLinPythonLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes invalid code in the editor of Implement Linked List in Python page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_implement_linked_list_in_python_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to get alert on Implement Linked List in Python TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_implement_linked_list_in_python_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
		assertTrue(isAlertPresent, "No alert displayed");
	}

	// TC23
	@Given("The user is on tryEditor page along with run button and valid code for Implement Linked List in Python page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_implement_linked_list_in_python_page() {
		LinkedList.clickImplementLLinPythonLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes valid Python code in the editor of Implement Linked List in Python page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_implement_linked_list_in_python_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to see output in the console for Implement Linked List in Python page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_implement_linked_list_in_python_page() {
		tryEditorPage.CodeEditorOutput();
	}

//TC24
	@Given("The user is on Implement Linked List in Python page after signing in")
	public void the_user_is_on_implement_linked_list_in_python_page_after_signing_in() {
		LinkedList.clickImplementLLinPythonLink();
	}

	@When("The user clicks the Practice Questions link present in Implement Linked List in Python page")
	public void the_user_clicks_the_practice_questions_link_present_in_implement_linked_list_in_python_page() {
		LinkedList.clickPracticeQueLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Implement Linked List in Python page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_implement_linked_list_in_python_page() {
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC25
	@Given("The user should be redirected to the Traversal data structure page")
	public void the_user_should_be_redirected_to_the_traversal_data_structure_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user clicks the Traversal link")
	public void the_user_clicks_the_traversal_link() {
		LinkedList.clickTraversalLink();
	}

	@Then("The user should be redirected to the Traversal page")
	public void the_user_should_be_redirected_to_the_traversal_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("traversal/"));
	}

	// TC26
	@Given("The user is on the Traversal page")
	public void the_user_is_on_the_traversal_page() {
		LinkedList.clickTraversalLink();
	}

	@When("The user clicks Try Here button in Traversal page")
	public void the_user_clicks_try_here_button_in_traversal_page() {
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@Then("The user is redirected to a page having Editor with run button for Traversal page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_traversal_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC27
	@Given("The user is on the tryEditor page after clicking Try here button in Traversal link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_traversal_link() {
		LinkedList.clickTraversalLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();

	}

	@When("The user enters an empty code in editor of Traversal link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_traversal_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Traversal page")
	public void no_error_message_is_displayed_for_try_editor_of_traversal_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC28
	@Given("The user is on the tryEditor page and clicks Try here button in Traversal page")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_traversal_page() {
		LinkedList.clickTraversalLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes invalid code in the editor of Traversal page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_traversal_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to get alert on Traversal TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_traversal_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
		assertTrue(isAlertPresent, "No alert displayed");
	}

	// TC29
	@Given("The user is on tryEditor page along with run button and valid code for Traversal page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_traversal_page() {
		LinkedList.clickTraversalLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes valid Python code in the editor of Traversal page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_traversal_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to see output in the console for Traversal page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_traversal_page() {
		tryEditorPage.CodeEditorOutput();
	}

//TC30
	@Given("The user is on Traversal page after signing in")
	public void the_user_is_on_traversal_page_after_signing_in() {
		LinkedList.clickTraversalLink();
	}

	@When("The user clicks the Practice Questions link present in Traversal page")
	public void the_user_clicks_the_practice_questions_link_present_in_traversal_page() {
		LinkedList.clickPracticeQueLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Traversal page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_traversal_page() {
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC31
	@Given("The user is on the Insertion data structure page")
	public void the_user_is_on_the_Insertion_data_structure_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user clicks the Insertion link")
	public void the_user_clicks_the_Insertion_link() {
		LinkedList.clickInsertionLink();
	}

	@Then("The user should be redirected to the Insertion data structure page")
	public void the_user_should_be_redirected_to_the_insertion_data_structure_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("insertion-in-linked-list/"));
	}

	// TC32
	@Given("The user is on the Insertion page")
	public void the_user_is_on_the_Insertion_page() {
		LinkedList.clickInsertionLink();
	}

	@When("The user clicks Try Here button in Insertion page")
	public void the_user_clicks_try_here_button_in_Insertion_page() {
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@Then("The user is redirected to a page having Editor with run button for Insertion page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_Insertion_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC33
	@Given("The user is on the tryEditor page after clicking Try here button in Insertion link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_Insertion_link() {
		LinkedList.clickInsertionLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();

	}

	@When("The user enters an empty code in editor of Insertion link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_Insertion_link_and_clicks_run_button() {

		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Insertion page")
	public void no_error_message_is_displayed_for_try_editor_of_Insertion_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC34
	@Given("The user is on the tryEditor page and clicks Try here button in Insertion page")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_Insertion_page() {
		LinkedList.clickInsertionLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes invalid code in the editor of Insertion page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_Insertion_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to get alert on Insertion TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_Insertion_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
		assertTrue(isAlertPresent, "No alert displayed");
	}

	// TC35
	@Given("The user is on tryEditor page along with run button and valid code for Insertion page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_Insertion_page() {
		LinkedList.clickInsertionLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes valid Python code in the editor of Insertion page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_Insertion_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to see output in the console for Insertion page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_Insertion_page() {
		tryEditorPage.CodeEditorOutput();
	}

//TC36
	@Given("The user is on Insertion page after signing in")
	public void the_user_is_on_Insertion_page_after_signing_in() {
		LinkedList.clickInsertionLink();
	}

	@When("The user clicks the Practice Questions link present in Insertion page")
	public void the_user_clicks_the_practice_questions_link_present_in_Insertion_page() {
		LinkedList.clickPracticeQueLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Insertion page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_Insertion_page() {
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC37
	@Given("The user is on the Deletion data structure page")
	public void the_user_is_on_the_Deletion_data_structure_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user clicks the Deletion link")
	public void the_user_clicks_the_Deletion_link() {
		LinkedList.clickDeletionLink();
	}

	@Then("The user should be redirected to the Deletion data structure page")
	public void the_user_should_be_redirected_to_the_Deletion_data_structure_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("deletion-in-linked-list/"));
	}

	// TC38
	@Given("The user is on the Deletion page")
	public void the_user_is_on_the_Deletion_page() {
		LinkedList.clickDeletionLink();
	}

	@When("The user clicks Try Here button in Deletion page")
	public void the_user_clicks_try_here_button_in_Deletion_page() {
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@Then("The user is redirected to a page having Editor with run button for Deletion page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_Deletion_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC39
	@Given("The user is on the tryEditor page after clicking Try here button in Deletion link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_Deletion_link() {
		LinkedList.clickDeletionLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();

	}

	@When("The user enters an empty code in editor of Deletion link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_Deletion_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Deletion page")
	public void no_error_message_is_displayed_for_try_editor_of_Deletion_page() {
		Assert.assertTrue(LinkedList.getCurrentPageUrl().endsWith("tryEditor"));
	}

	// TC40
	@Given("The user is on the tryEditor page and clicks Try here button in Deletion page")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_Deletion_page() {
		LinkedList.clickDeletionLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes invalid code in the editor of Deletion page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_Deletion_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to get alert on Deletion TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_Deletion_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
		assertTrue(isAlertPresent, "No alert displayed");
	}

	// TC41
	@Given("The user is on tryEditor page along with run button and valid code for Deletion page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_Deletion_page() {
		LinkedList.clickDeletionLink();
		tryEditorPage.PageScrolldown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user writes valid Python code in the editor of Deletion page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_Deletion_page_and_clicks_run_button_from_sheetname_and_row(
			String string, Integer int1) {
		try {
			tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
			tryEditorPage.clickRunButton();
		} catch (Exception e) {
			LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

	@Then("The user should be able to see output in the console for Deletion page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_Deletion_page() {
		tryEditorPage.CodeEditorOutput();
	}

//TC42
	@Given("The user is on Deletion page after signing in")
	public void the_user_is_on_Deletion_page_after_signing_in() {
		LinkedList.clickDeletionLink();
	}

	@When("The user clicks the Practice Questions link present in Deletion page")
	public void the_user_clicks_the_practice_questions_link_present_in_Deletion_page() {
		LinkedList.clickPracticeQueLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Deletion page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_Deletion_page() {
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

}