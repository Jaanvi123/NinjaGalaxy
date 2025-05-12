package stepDefinitions;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverManager.DriverFactory;
import dsAlgoPageObjects.GraphPageObj;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.SignInPageObj;
import dsAlgoPageObjects.TryEditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.LoggerLoad;

public class GraphStepDefinition {
	WebDriver driver = DriverFactory.getDriver();
	SignInPageObj signin = new SignInPageObj(driver);
	HomePageObj homepage = new HomePageObj(driver);
	TryEditorPage tryEditorPage = new TryEditorPage(driver);
	GraphPageObj graphpage = new GraphPageObj(driver);
	

	@Given("The user is on home page of ds portal")
	public void the_user_is_on_home_page_of_ds_portal() {
		homepage.openHomeUrl();
	
	}
	
	@When("The user clicks Sign in link for ds and enters valid credentials")
	public void the_user_clicks_sign_in_link_for_ds_and_enters_valid_credentials() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		homepage.clickgetStartedButton(driver);
		homepage.clickSignInLink();
		signin.enterUsernameText("username");
		signin.enterPasswordText("password");
		signin.clickloginButton();
	}
	
	@Then("The user lands on the graph page on clicking Get started button for graph module")
	public void the_user_lands_on_the_graph_page_on_clicking_get_started_button_for_graph_module() {
		homepage.clickGraphGetStartedButton();
		Assert.assertEquals(homepage.getHomePageTitle(), "Graph");
	}

//TC01
	
	@Given("The user is on the Graph page after signing in")
	public void the_user_is_on_the_graph_page_after_signing_in() {
		graphpage.getcurrentpageUrl();
	}
	
	@When("The user clicks the Inside graph link")
	public void the_user_clicks_the_inside_graph_link() {
	    graphpage.ClickInsideGraphkLink();
	}
	
	@Then("The user should be redirected to the Inside graph data structure page")
	public void the_user_should_be_redirected_to_the_inside_graph_data_structure_page() {
		graphpage.getcurrentpageUrl();
		 Assert.assertTrue(graphpage.getcurrentpageUrl().endsWith("graph/"));
	}

//TC02
	@Given("The user is on the Inside graph page")
	public void the_user_is_on_the_inside_graph_page() {
	    graphpage.ClickInsideGraphkLink();
	    graphpage.getcurrentpageUrl();
	}
	
	@When("The user clicks Try Here button on the Inside graph page")
	public void the_user_clicks_try_here_button_on_the_inside_graph_page() {
		tryEditorPage.clickTryHereButton();
	}
	
	@Then("The user is redirected to a page having Editor with run button for Inside graph")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_inside_graph() {
		graphpage.getcurrentpageUrl();
		 Assert.assertTrue(graphpage.getcurrentpageUrl().endsWith("tryEditor"));
	}

//TC03	
	@Given("The user is on tryEditor page and clicks Try here button in Inside Graph")
	public void the_user_is_on_try_editor_page_and_clicks_try_here_button_in_inside_graph() {
		graphpage.ClickInsideGraphkLink();
		tryEditorPage.clickTryHereButton();
	}
	
	@When("The user enters an empty code in editor of Inside Graph and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_inside_graph_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}
	
	@Then("No error message is displayed for Inside Graph")
	public void no_error_message_is_displayed_for_inside_graph() {
		 graphpage.getcurrentpageUrl();
		 Assert.assertTrue(graphpage.getcurrentpageUrl().endsWith("tryEditor"));
	}

//TC04
	@Given("The user is on the tryEditor page after clicking Try here button in Inside Graph")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_inside_graph() {
		graphpage.ClickInsideGraphkLink(); 
		tryEditorPage.clickTryHereButton();
	}
	
	@When("The user writes valid Python code in the editor of Inside Graph page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_inside_graph_page_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	
	@Then("The user should be able to see output in the console for Inside Graph")
	public void the_user_should_be_able_to_see_output_in_the_console_for_inside_graph() {
		graphpage.codeEditorOutput();
	}

//TC05
	@Given("The user is on the tryEditor page and clicks Try here button in Inside Graph link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_inside_graph_link() {
		graphpage.ClickInsideGraphkLink(); 
		tryEditorPage.clickTryHereButton();
	}
	
	@When("The user writes invalid code in the editor Inside Graph and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_inside_graph_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	
	@Then("The user should be able to get alert on Inside graph")
	public void the_user_should_be_able_to_get_alert_on_inside_graph() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}
	
//TC06
	@Given("The user is on Inside Graph page")
	public void the_user_is_on_inside_graph_page() {
	    graphpage.ClickInsideGraphkLink(); 
	}
	
	@When("The user clicks the Practice Questions link from the Inside Graph page")
	public void the_user_clicks_the_practice_questions_link_from_the_inside_graph_page() {
		graphpage.clickPracticeQuestionsLink();
	}
	
	@Then("The user should be redirected to the Practice Questions page from Inside graph page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_inside_graph_page() {
		graphpage.getcurrentpageUrl();
		Assert.assertTrue(graphpage.getcurrentpageUrl().endsWith("practice"));
	}

//TC07
	
	@Given("The user is in Graph page after signing in")
	public void the_user_is_in_graph_page_after_signing_in() {
	        graphpage.getcurrentpageUrl();
	}
	
	@When("The user clicks the Graph representations")
	public void the_user_clicks_the_graph_representations() {
	    graphpage.ClickGraphRepresentationLink();
	}
	
	@Then("The user should be redirected to the Graph representations data structure page")
	public void the_user_should_be_redirected_to_the_graph_representations_data_structure_page() {
		graphpage.getcurrentpageUrl();
		Assert.assertTrue(graphpage.getcurrentpageUrl().endsWith("graph-representations/"));
	}
	
//TC08
	@Given("The user is on the Graph representations")
	public void the_user_is_on_the_graph_representations() {
	    graphpage.ClickGraphRepresentationLink();
	}
	
	@When("The user clicks Try Here button on the Graph representations")
	public void the_user_clicks_try_here_button_on_the_graph_representations() {
		tryEditorPage.clickTryHereButton();
	}
	
	@Then("The user is redirected to a page having Editor with run button for Graph representations")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_graph_representations() {
	    graphpage.getcurrentpageUrl();
	}
	
//TC09
	@Given("The user is on tryEditor page and clicks Try here button in Graph representations")
	public void the_user_is_on_try_editor_page_and_clicks_try_here_button_in_graph_representations() {
		graphpage.ClickGraphRepresentationLink();
		tryEditorPage.clickTryHereButton();
	}
	
	@When("The user enters an empty code in editor of Graph representations and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_graph_representations_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}
	
	@Then("No error message is displayed for Graph representations")
	public void no_error_message_is_displayed_for_graph_representations() {
		graphpage.getcurrentpageUrl();
	}
	
//TC10
	@Given("The user is on the tryEditor page after clicking Try here button in Graph representations")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_graph_representations() {
		graphpage.ClickGraphRepresentationLink();
		tryEditorPage.clickTryHereButton();
	}
	
	@When("The user writes valid Python code in the editor of Graph representations and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_graph_representations_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	
	@Then("The user should be able to see output in the console for Graph representations")
	public void the_user_should_be_able_to_see_output_in_the_console_for_graph_representations() {
	    graphpage.codeEditorOutput();
	}
	
//TC11
	@Given("The user is on the tryEditor page and clicks Try here button in Graph representations")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_graph_representations() {
		graphpage.ClickGraphRepresentationLink();
		tryEditorPage.clickTryHereButton();
	}
	
	@When("The user writes invalid code in the editor Graph representations and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_graph_representations_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	
	@Then("The user should be able to get alert on Graph representations")
	public void the_user_should_be_able_to_get_alert_on_graph_representations() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");;
	}
	
//TC12
	
	@Given("The user is on Graph representations")
	public void the_user_is_on_graph_representations() {
	    graphpage.ClickGraphRepresentationLink();
	}
	
	@When("The user clicks the Practice Questions link from the Graph representations")
	public void the_user_clicks_the_practice_questions_link_from_the_graph_representations() {
		
		graphpage.clickPracticeQuestionsLink();
	}
	
	@Then("The user should be redirected to the Practice Questions page from Graph representations")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_graph_representations() {
		graphpage.getcurrentpageUrl();
		Assert.assertTrue(graphpage.getcurrentpageUrl().endsWith("practice"));
	}

}