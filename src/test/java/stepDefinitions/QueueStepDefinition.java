package stepDefinitions;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.QueuePageObj;
import dsAlgoPageObjects.SignInPageObj;
import dsAlgoPageObjects.TryEditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.LoggerLoad;

public class QueueStepDefinition{
	WebDriver driver = DriverFactory.getDriver();
	SignInPageObj signin = new SignInPageObj(driver);
	IntroductionPageObj introductionpage = new IntroductionPageObj();
	HomePageObj homepage = new HomePageObj(driver);
	QueuePageObj queuePage = new QueuePageObj(driver);
	TryEditorPage tryEditorPage = new TryEditorPage(driver);
	
	@Given("The user is on home page of ds")
	public void the_user_is_on_home_page_of_ds() {
		homepage.openHomeUrl();		
	}

	@When("The user clicks Sign in link and enters valid credentials for Queue page")
	public void the_user_clicks_sign_in_link_and_enters_valid_credentials_for_queue_page()
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		introductionpage.clickgetStartedButton(driver);
		introductionpage.clickSignInLink();
		signin.enterUsernameText("username");
		signin.enterPasswordText("password");
		signin.clickloginButton();
	}

	@Then("The user lands on the queue page on clicking Get started button for queue module")
	public void the_user_lands_on_the_queue_page_on_clicking_get_started_button_for_queue_module() {
		introductionpage.clickQueueGetStartedButton();
		Assert.assertEquals(introductionpage.getHomePageTitle(), "Queue");
		
	}

//TC01
	@Given("the user is on the Queue page after signing in")
	public void the_user_is_on_the_queue_page_after_signing_in() {
	    queuePage.QueuePageTitle();
	}

	@When("the user clicks the Implementation of queue in python link")
	public void the_user_clicks_the_implementation_of_queue_in_python_link() {
	    queuePage.clickImplementaionOfQueueLink();
	}

	@Then("the user should be redirected to the Implementation of queue in python data structure page")
	public void the_user_should_be_redirected_to_the_implementation_of_queue_in_python_data_structure_page() {
		queuePage.getcurrentpageUrl(); 
		Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("implementation-lists/"));
	}

//TC02
	@Given("The user is on the Implementation of queue in python page")
	public void the_user_is_on_the_implementation_of_queue_in_python_page() {
	    queuePage.clickImplementaionOfQueueLink();
	    queuePage.getcurrentpageUrl();
	}

	@When("The user clicks Try Here button on the Implementation of queue in python page")
	public void the_user_clicks_try_here_button_on_the_implementation_of_queue_in_python_page() {
		tryEditorPage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button for Implementation of queue in python")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_implementation_of_queue_in_python() {
	    queuePage.getcurrentpageUrl();
	    Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("tryEditor"));
	    
	}

//TC03
	@Given("The user is on tryEditor page and clicks Try here button in Implementation of queue")
	public void the_user_is_on_try_editor_page_and_clicks_try_here_button_in_implementation_of_queue() {
		queuePage.clickImplementaionOfQueueLink();
		tryEditorPage.clickTryHereButton();
	}

	@When("The user enters an empty code in editor of Implementation of queue and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_implementation_of_queue_and_clicks_run_button() {
		tryEditorPage.clickRunButton();	
	}

	@Then("No error message is displayed for Implementation of queue")
	public void no_error_message_is_displayed_for_implementation_of_queue() {
		queuePage.getcurrentpageUrl();
		Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
	
//TC04
	@Given("The user is on the tryEditor page after clicking Try here button in Implementation of queue")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_implementation_of_queue() {
		queuePage.clickImplementaionOfQueueLink();
		tryEditorPage.clickTryHereButton();
	}

	@When("The user writes valid Python code in the editor of Implementation of queue page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_implementation_of_queue_page_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
		 try {
	        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
	        	tryEditorPage.clickRunButton();
	        } catch (Exception e) {
	        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
	        }
	}

	@Then("The user should be able to see output in the console for Implementation of queue")
	public void the_user_should_be_able_to_see_output_in_the_console_for_implementation_of_queue() {
	    queuePage.validateCodeEditorOutput();
	}

//TC05
	@Given("The user is on the tryEditor page and clicks Try here button in Implementation of queue link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_implementation_of_queue_link() {
		queuePage.clickImplementaionOfQueueLink();
		tryEditorPage.clickTryHereButton();
	}

	@When("The user writes invalid code in the editor Implementation of queue and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_implementation_of_queue_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
		 try {
	        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
	        	tryEditorPage.clickRunButton();
	        } catch (Exception e) {
	        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
	        }
	}

	@Then("The user should be able to get alert on Implementation of queue in python")
	public void the_user_should_be_able_to_get_alert_on_implementation_of_queue_in_python() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}
	
//TC06
	@Given("The user is on the Implementation of queue page")
	public void the_user_is_on_the_implementation_of_queue_page() {
	    queuePage.clickImplementaionOfQueueLink();
		
	}

	@When("The user clicks the Practice Questions link from the Implementation of queue page")
	public void the_user_clicks_the_practice_questions_link_from_the_implementation_of_queue_page() {
	   queuePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Implementation of queue in python page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_implementation_of_queue_in_python_page() {
		    queuePage.getcurrentpageUrl();
		    Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC07
	@Given("The user is in Queue page after signing in")
	public void the_user_is_in_queue_page_after_signing_in() {
	    queuePage.getcurrentpageUrl();
	}

	@When("the user clicks the Implementation using collections deque")
	public void the_user_clicks_the_implementation_using_collections_deque() {
	   queuePage.clickUsingCollectionsLink();
	}

	@Then("the user should be redirected to the Implementation using collections deque data structure page")
	public void the_user_should_be_redirected_to_the_implementation_using_collections_deque_data_structure_page() {
		queuePage.getcurrentpageUrl();
		Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("implementation-collections/"));
	}
	
//TC08
	@Given("The user is on the Implementation using collections deque")
	public void the_user_is_on_the_implementation_using_collections_deque() {
	    queuePage.clickUsingCollectionsLink();
	}

	@When("The user clicks Try Here button on the Implementation using collections deque")
	public void the_user_clicks_try_here_button_on_the_implementation_using_collections_deque() {
		tryEditorPage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button for Implementation using collections deque")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_implementation_using_collections_deque() {
		queuePage.getcurrentpageUrl();
		Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("tryEditor"));

	}

//TC09
	@Given("The user is on tryEditor page and clicks Try here button in Implementation using collections deque")
	public void the_user_is_on_try_editor_page_and_clicks_try_here_button_in_implementation_using_collections_deque() {
	    queuePage.clickUsingCollectionsLink();
		tryEditorPage.clickTryHereButton();
	}

	@When("The user enters an empty code in editor of Implementation using collections deque and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_implementation_using_collections_deque_and_clicks_run_button() {
		tryEditorPage.clickRunButton();	
	}

	@Then("No error message is displayed for Implementation using collections deque")
	public void no_error_message_is_displayed_for_implementation_using_collections_deque() {
		queuePage.getcurrentpageUrl();
		Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("tryEditor"));
	}

//TC10
	@Given("The user is on the tryEditor page after clicking Try here button in Implementation using collections deque")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_implementation_using_collections_deque() {
	    queuePage.clickUsingCollectionsLink();
		tryEditorPage.clickTryHereButton();
	}

	@When("The user writes valid Python code in the editor of Implementation using collections deque and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_implementation_using_collections_deque_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
		 try {
	        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
	        	tryEditorPage.clickRunButton();
	        } catch (Exception e) {
	        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
	        }
	}

	@Then("The user should be able to see output in the console for Implementation using collections deque")
	public void the_user_should_be_able_to_see_output_in_the_console_for_implementation_using_collections_deque() {
	    queuePage.validateCodeEditorOutput();
	}

//TC11
	@Given("The user is on the tryEditor page and clicks Try here button in Implementation using collections deque")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_implementation_using_collections_deque() {
		    queuePage.clickUsingCollectionsLink();
			tryEditorPage.clickTryHereButton();
	}

	@When("The user writes invalid code in the editor Implementation using collections deque and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_implementation_using_collections_deque_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
		 try {
	        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
	        	tryEditorPage.clickRunButton();
	        } catch (Exception e) {
	        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
	        }
	}

	@Then("The user should be able to get alert on Implementation using collections deque")
	public void the_user_should_be_able_to_get_alert_on_implementation_using_collections_deque() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}

//TC12
	@When("The user clicks the Practice Questions link from the Implementation using collections deque")
	public void the_user_clicks_the_practice_questions_link_from_the_implementation_using_collections_deque() {
	    queuePage.clickUsingCollectionsLink();
	    queuePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Implementation using collections deque")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_implementation_using_collections_deque() {
		queuePage.getcurrentpageUrl();
	    Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC13
	@When("the user clicks the Implementation using array")
	public void the_user_clicks_the_implementation_using_array() {
	   queuePage.clickImplementatonUsingArraylink();
	}

	@Then("the user should be redirected to the Implementation using array data structure page")
	public void the_user_should_be_redirected_to_the_implementation_using_array_data_structure_page() {
		queuePage.getcurrentpageUrl();
	    Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("Implementation-array/"));
	}

//TC14
	@Given("The user is on the Implementation using array")
	public void the_user_is_on_the_implementation_using_array() {
	    queuePage.clickImplementatonUsingArraylink();
	}

	@When("The user clicks Try Here button on the Implementation using array")
	public void the_user_clicks_try_here_button_on_the_implementation_using_array() {
		 tryEditorPage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button for Implementation using array")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_implementation_using_array() {
		queuePage.getcurrentpageUrl();
		Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("tryEditor"));
	}

//TC15
	@Given("The user is on tryEditor page and clicks Try here button in Implementation using array")
	public void the_user_is_on_try_editor_page_and_clicks_try_here_button_in_implementation_using_array() {
	    queuePage.clickImplementatonUsingArraylink();
	    tryEditorPage.clickTryHereButton();
	}

	@When("The user enters an empty code in editor of Implementation using array and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_implementation_using_array_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Implementation using array")
	public void no_error_message_is_displayed_for_implementation_using_array() {
		queuePage.getcurrentpageUrl();
		Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("tryEditor"));
	}

	
//TC16
	@Given("The user is on the tryEditor page after clicking Try here button in Implementation using array")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_implementation_using_array() {
	    queuePage.clickImplementatonUsingArraylink();
	    tryEditorPage.clickTryHereButton();
	}

	@When("The user writes valid Python code in the editor of Implementation using array and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_implementation_using_array_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
		 try {
	        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
	        	tryEditorPage.clickRunButton();
	        } catch (Exception e) {
	        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
	        }
	}

	@Then("The user should be able to see output in the console for Implementation using array")
	public void the_user_should_be_able_to_see_output_in_the_console_for_implementation_using_array() {
	    queuePage.validateCodeEditorOutput();
	}

//TC17
	@Given("The user is on the tryEditor page and clicks Try here button in Implementation using array")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_implementation_using_array() {
		 queuePage.clickImplementatonUsingArraylink();
		    tryEditorPage.clickTryHereButton();
	}

	@When("The user writes invalid code in the editor Implementation using array and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_implementation_using_array_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
		 try {
	        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
	        	tryEditorPage.clickRunButton();
	        } catch (Exception e) {
	        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
	        }
	}

	@Then("The user should be able to get alert on Implementation using array")
	public void the_user_should_be_able_to_get_alert_on_implementation_using_array() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}

//TC18
	@When("The user clicks the Practice Questions link from the Implementation using array")
	public void the_user_clicks_the_practice_questions_link_from_the_implementation_using_array() {
	    queuePage.clickImplementatonUsingArraylink();
	    queuePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Implementation using array")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_implementation_using_array() {
		queuePage.getcurrentpageUrl();
		Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC19
	@When("the user clicks the Queue operations")
	public void the_user_clicks_the_queue_operations() {
	    queuePage.clickQueueOperationslink();
	}

	@Then("the user should be redirected to the Queue operations data structure page")
	public void the_user_should_be_redirected_to_the_queue_operations_data_structure_page() {
		queuePage.getcurrentpageUrl();
		Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("QueueOp/"));
	}

//TC20
	@Given("The user is on the Queue operations")
	public void the_user_is_on_the_queue_operations() {
	    queuePage.clickQueueOperationslink();
	}

	@When("The user clicks Try Here button on the Queue operations")
	public void the_user_clicks_try_here_button_on_the_queue_operations() {
		//queuePage.PageScrollDown();
		tryEditorPage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button for Queue operations")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_queue_operations() {
	    queuePage.getcurrentpageUrl();
	}

//TC21
	@Given("The user is on tryEditor page and clicks Try here button in Queue operations")
	public void the_user_is_on_try_editor_page_and_clicks_try_here_button_in_queue_operations() {
	     queuePage.clickQueueOperationslink(); 
		 tryEditorPage.clickTryHereButton();
	}

	@When("The user enters an empty code in editor of Queue operations and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_queue_operations_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Queue operations")
	public void no_error_message_is_displayed_for_queue_operations() {
		queuePage.getcurrentpageUrl();
		Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("tryEditor"));
	}

//TC22
	@Given("The user is on the tryEditor page after clicking Try here button in Queue operations")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_queue_operations() {
		queuePage.clickQueueOperationslink(); 
		tryEditorPage.clickTryHereButton();
	}

	@When("The user writes valid Python code in the editor of Queue operations and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_queue_operations_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}

	@Then("The user should be able to see output in the console for Queue operations")
	public void the_user_should_be_able_to_see_output_in_the_console_for_queue_operations() {
	    queuePage.validateCodeEditorOutput();
	}

//TC23
	@Given("The user is on the tryEditor page and clicks Try here button in Queue operations")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_queue_operations() {
		queuePage.clickQueueOperationslink(); 
		tryEditorPage.clickTryHereButton();
	}

	@When("The user writes invalid code in the editor Queue operations and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_queue_operations_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}

	@Then("The user should be able to get alert on Queue operations")
	public void the_user_should_be_able_to_get_alert_on_queue_operations() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}

//TC24
	@When("The user clicks the Practice Questions link from the Queue operations")
	public void the_user_clicks_the_practice_questions_link_from_the_queue_operations() {
	    queuePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Queue operations")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_queue_operations() {
		queuePage.getcurrentpageUrl();
		Assert.assertTrue(queuePage.getcurrentpageUrl().endsWith("practice"));
	}

}