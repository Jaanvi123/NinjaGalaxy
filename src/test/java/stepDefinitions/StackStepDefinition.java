package stepDefinitions;

import org.openqa.selenium.WebDriver;
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
import utils.LoggerLoad;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
public class StackStepDefinition 
{
	WebDriver driver = DriverFactory.getDriver();
	SignInPageObj signin = new SignInPageObj(driver);
	IntroductionPageObj introductionpage = new IntroductionPageObj();
	HomePageObj homepage = new HomePageObj(driver);
	TryEditorPage tryEditorPage = new TryEditorPage(driver);
	StackPageObj stackPage = new StackPageObj(driver);
	

	@Given("The user is on home page of dsalgo portal")
	public void the_user_is_on_home_page_of_dsalgo_portal() {
		homepage.openHomeUrl();
		
	}
	
	@When("The user press Sign in link and enters valid credentials")
	public void the_user_press_sign_in_link_and_enters_valid_credentials() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException{
		introductionpage.clickgetStartedButton(driver);
		introductionpage.clickSignInLink();
		signin.enterUsernameText("username");
		signin.enterPasswordText("password");
		signin.clickloginButton();
	}
	
	@Then("The user lands on the stack page on clicking Get started button for stack module")
	public void the_user_lands_on_the_stack_page_on_clicking_get_started_button_for_stack_module() {
		introductionpage.clickStackGetStartedButton();
		Assert.assertEquals(introductionpage.getHomePageTitle(), "Stack");
	}
	
//TC01
	
	@Given("the user is on the stack page after signing in")
	public void the_user_is_on_the_stack_page_after_signing_in() {
	   stackPage.validatePageTitle();
	}
	
	@When("the user clicks the Operations in Stack link")
	public void the_user_clicks_the_operations_in_stack_link() {
	    stackPage.ClickOperationsinstackLink();
	}
	
	@Then("the user should be redirected to the Operations in Stack data structure page")
	public void the_user_should_be_redirected_to_the_operations_in_stack_data_structure_page() {
		 stackPage.getcurrentpageUrl();
		 Assert.assertTrue(stackPage.getcurrentpageUrl().endsWith("operations-in-stack/"));
	}

//TC02
	@Given("The user is on the Operations in Stack page")
	public void the_user_is_on_the_operations_in_stack_page() {
	    stackPage.ClickOperationsinstackLink();
	    stackPage.getcurrentpageUrl();
	}
	
	@When("The user clicks Try Here button on the Operations in Stack page")
	public void the_user_clicks_try_here_button_on_the_operations_in_stack_page() {
		try {
			tryEditorPage.clickTryHereButton();
		} catch (Exception e) {
			LoggerLoad.info("Did not click try here button");
			e.printStackTrace();
		}
	}
	
	@Then("The user is redirected to a page having Editor with run button for Operations in Stack")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_operations_in_stack() {
		 stackPage.getcurrentpageUrl();
		 Assert.assertTrue(stackPage.getcurrentpageUrl().endsWith("tryEditor"));
	}
	
//TC03	
	@Given("The user is on tryEditor page and clicks Try here button in Operations in Stack")
	public void the_user_is_on_try_editor_page_and_clicks_try_here_button_in_operations_in_stack() {
		stackPage.ClickOperationsinstackLink();
		tryEditorPage.clickTryHereButton();
	}
	
	@When("The user enters an empty code in editor of Operations in Stack and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_operations_in_stack_and_clicks_run_button() {
		tryEditorPage.clickRunButton();	
	}
	
	@Then("No error message is displayed for Operations in Stack")
	public void no_error_message_is_displayed_for_operations_in_stack() {
		stackPage.getcurrentpageUrl();
		Assert.assertTrue(stackPage.getcurrentpageUrl().endsWith("tryEditor"));
	}
	
//TC04
	@Given("The user is on the tryEditor page after clicking Try here button in Operations in Stack")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_operations_in_stack() {
		stackPage.ClickOperationsinstackLink();
		try {
			tryEditorPage.clickTryHereButton();
		} catch (Exception e) {
			LoggerLoad.info("Did not click try here button");
			e.printStackTrace();
		}
	}

	@When("The user enter valid Python code in the editor of Operations in Stack page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_enter_valid_python_code_in_the_editor_of_operations_in_stack_page_and_clicks_run_button_from_sheetname_and_row(String string, Integer int1) {
		 try {
	        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
	        	tryEditorPage.clickRunButton();
	        } catch (Exception e) {
	        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
	        }
	}

	@Then("The user should be able to see output in the console for Operations in Stack")
	public void the_user_should_be_able_to_see_output_in_the_console_for_operations_in_stack() {
		 stackPage.validateCodeEditorOutput();
	}
	
//TC05	
	@Given("The user is on the tryEditor page and clicks Try here button in Operations in Stack link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_operations_in_stack_link() {
	    stackPage.ClickOperationsinstackLink();
	    try {
			tryEditorPage.clickTryHereButton();
		} catch (Exception e) {
			LoggerLoad.info("Did not click try here button");
			e.printStackTrace();
		}
	}
	
	@When("The user enter invalid code in the editor Operations in Stack and clicks Run button from sheetname {string} and row {int}")
	public void the_user_enter_invalid_code_in_the_editor_operations_in_stack_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer RowNumber) {
		  try {
	        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
	        	tryEditorPage.clickRunButton();
	        } catch (Exception e) {
	        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
	        }
	}
	
	@Then("The user should be able to get alert on Operations in Stack")
	public void the_user_should_be_able_to_get_alert_on_operations_in_stack() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}
	
//TC06	
	@Given("The user is in the Operations in Stack page")
	public void the_user_is_in_the_operations_in_stack_page() {
		stackPage.ClickOperationsinstackLink();
	}
	
	@When("The user clicks the Practice Questions link from the Operations in Stack page")
	public void the_user_clicks_the_practice_questions_link_from_the_operations_in_stack_page() {
		stackPage.clickPracticeQuestionsLink();
	}
	
	@Then("The user should be redirected to the Practice Questions page from Operations in Stack page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_operations_in_stack_page() {
		stackPage.getcurrentpageUrl();
		Assert.assertTrue(stackPage.getcurrentpageUrl().endsWith("practice"));

	}
	
//TC07
	@Given("The user is in stack page after signing in")
	public void the_user_is_in_stack_page_after_signing_in() {
		stackPage.getcurrentpageUrl();
	}
	
	@When("the user clicks the Implementation")
	public void the_user_clicks_the_implementation() {
		stackPage.ClickStackImplementationLink();
	}
	
	@Then("the user should be redirected to the Implementation data structure page")
	public void the_user_should_be_redirected_to_the_implementation_data_structure_page() {
		stackPage.getcurrentpageUrl();
		Assert.assertTrue(stackPage.getcurrentpageUrl().endsWith("implementation/"));
	}
	
//TC08
	@Given("The user is on the Implementation")
	public void the_user_is_on_the_implementation() {
	   stackPage.ClickStackImplementationLink();
	}
	
	@When("The user clicks Try Here button on the Implementation")
	public void the_user_clicks_try_here_button_on_the_implementation() {
		tryEditorPage.clickTryHereButton();
	}
	
	@Then("The user is redirected to a page having Editor with run button for Implementation")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_implementation() {
		stackPage.getcurrentpageUrl();
		Assert.assertTrue(stackPage.getcurrentpageUrl().endsWith("tryEditor"));
	}
	
//TC09
	@Given("The user is on tryEditor page and clicks Try here button in Implementation")
	public void the_user_is_on_try_editor_page_and_clicks_try_here_button_in_implementation() {
		  stackPage.ClickStackImplementationLink();
		  tryEditorPage.clickTryHereButton();
	}
	
	@When("The user enters an empty code in editor of Implementation and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_implementation_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}
	
	@Then("No error message is displayed for Implementation")
	public void no_error_message_is_displayed_for_implementation() {
		stackPage.getcurrentpageUrl();
		Assert.assertTrue(stackPage.getcurrentpageUrl().endsWith("tryEditor"));
	}
	
//TC10
	@Given("The user is on the tryEditor page after clicking Try here button in Implementation")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_implementation() {
		  stackPage.ClickStackImplementationLink();
		  tryEditorPage.clickTryHereButton();
	}
	
	@When("The user wrote valid Python code in the editor of Implementation and clicks Run button from sheetname {string} and row {int}")
	public void the_user_wrote_valid_python_code_in_the_editor_of_implementation_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	
	@Then("The user should be able to see output in the console for Implementation")
	public void the_user_should_be_able_to_see_output_in_the_console_for_implementation() {
	   stackPage.validateCodeEditorOutput();
	}
	
//TC011
	@Given("The user is on the tryEditor page and clicks Try here button in Implementation")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_implementation() {
		 stackPage.ClickStackImplementationLink();
		  tryEditorPage.clickTryHereButton();
	}
	
	@When("The user wrote invalid code in the editor Implementation and clicks Run button from sheetname {string} and row {int}")
	public void the_user_wrote_invalid_code_in_the_editor_implementation_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	
	@Then("The user should be able to get alert on Implementation")
	public void the_user_should_be_able_to_get_alert_on_implementation() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}

//TC12
	@When("The user clicks the Practice Questions link from the Implementation")
	public void the_user_clicks_the_practice_questions_link_from_the_implementation() {
		 //stackPage.ClickStackImplementationLink();
		 stackPage.clickPracticeQuestionsLink();
	}
	
	@Then("The user should be redirected to the Practice Questions page from Implementation")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_implementation() {
		stackPage.getcurrentpageUrl();
		Assert.assertTrue(stackPage.getcurrentpageUrl().endsWith("practice"));
	}

//TC13
	@When("the user clicks the Applications")
	public void the_user_clicks_the_applications() {
	    stackPage.StackApplicationslink();
	}
	
	@Then("the user should be redirected to the Applications data structure page")
	public void the_user_should_be_redirected_to_the_applications_data_structure_page() {
		stackPage.getcurrentpageUrl();
		Assert.assertTrue(stackPage.getcurrentpageUrl().endsWith("stack-applications/"));
	}
	
//TC14
	@Given("The user is on the Applications")
	public void the_user_is_on_the_applications() {
		stackPage.StackApplicationslink();
	}
	
	@When("The user clicks Try Here button on the Applications")
	public void the_user_clicks_try_here_button_on_the_applications() {
		tryEditorPage.clickTryHereButton();
}
	
	@Then("The user is redirected to a page having Editor with run button for Applications")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_applications() {
		stackPage.getcurrentpageUrl();
	}

//TC15
	@Given("The user is on tryEditor page and clicks Try here button in Applications")
	public void the_user_is_on_try_editor_page_and_clicks_try_here_button_in_applications() {
	    stackPage.StackApplicationslink();
	    tryEditorPage.clickTryHereButton();
	}
	
	@When("The user enters an empty code in editor of Applications and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_applications_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}
	
	@Then("No error message is displayed for Applications")
	public void no_error_message_is_displayed_for_applications() {
		stackPage.getcurrentpageUrl();
		Assert.assertTrue(stackPage.getcurrentpageUrl().endsWith("tryEditor"));
	}
	
//TC16	
	@Given("The user is on the tryEditor page after clicking Try here button in Applications")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_applications() {
	    stackPage.StackApplicationslink();
		tryEditorPage.clickTryHereButton();
	}
	
	@When("The user has valid Python code in the editor of Applications and clicks Run button from sheetname {string} and row {int}")
	public void the_user_has_valid_python_code_in_the_editor_of_applications_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	
	@Then("The user should be able to see output in the console for Applications")
	public void the_user_should_be_able_to_see_output_in_the_console_for_applications() {
		   stackPage.validateCodeEditorOutput();
	}
	
//TC17
	@Given("The user is on the tryEditor page and clicks Try here button in Applications")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_applications() {
		    stackPage.StackApplicationslink();
			tryEditorPage.clickTryHereButton();
	}
	
	@When("The user has invalid code in the editor Applications and clicks Run button from sheetname {string} and row {int}")
	public void the_user_has_invalid_code_in_the_editor_applications_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	
	@Then("The user should be able to get alert on Applications")
	public void the_user_should_be_able_to_get_alert_on_applications() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}
	
//TC18
	@When("The user clicks the Practice Questions link from the Applications")
	public void the_user_clicks_the_practice_questions_link_from_the_applications() {
	    stackPage.clickPracticeQuestionsLink();
	}
	
	@Then("The user should be redirected to the Practice Questions page from Applications")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_applications() {
		stackPage.getcurrentpageUrl();
		Assert.assertTrue(stackPage.getcurrentpageUrl().endsWith("practice"));
	}

}