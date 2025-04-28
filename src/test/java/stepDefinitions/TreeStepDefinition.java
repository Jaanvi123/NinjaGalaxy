package stepDefinitions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.SignInPageObj;
import dsAlgoPageObjects.TreePageObj;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;

public class TreeStepDefinition {

	WebDriver driver = DriverFactory.getDriver();
	SignInPageObj signin = new SignInPageObj(driver);
	ConfigReader configReader = new ConfigReader();
	IntroductionPageObj introductionpage = new IntroductionPageObj();
	HomePageObj homepage = new HomePageObj(driver);
	TreePageObj treePage = new TreePageObj(driver);

	@Given("The user is on home page and clicks sign in link")
	public void the_user_is_on_home_page_and_clicks_sign_in_link()
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		homepage.openHomeUrl();
		introductionpage.clickgetStartedButton(driver);
		introductionpage.SignInLinkClick();
		signin.enterLoginFormFields("login", 0);
		signin.clickloginButton();
	}

	@Then("The user enters valid credentials and clicks Get started tree button to land on tree page")
	public void the_user_enters_valid_credentials_and_clicks_get_started_tree_button_to_land_on_tree_page()
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		introductionpage.clickTreeGetStartedButton();
		treePage.TreePageTitle();
	}

	@Given("The user is on the Tree page after signing in")
	public void the_user_is_on_the_tree_page_after_signing_in() {
		treePage.getcurrentpageUrl();
	}

	@When("The user clicks the Overview of Trees link")
	public void the_user_clicks_the_overview_of_trees_link() {
		treePage.clickOverviewOfTreesLink();
		
	}

	@Then("The user should be redirected to the Overview of Trees data structure page")
	public void the_user_should_be_redirected_to_the_overview_of_trees_data_structure_page() {
		treePage.getcurrentpageUrl();
	}

	@When("The user is on the Overview of Trees page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_overview_of_trees_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickOverviewOfTreesLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button for Tree")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_tree() {
		treePage.getcurrentpageUrl();
	}

	@When("The user is on the tryEditor page of Trees with an empty code editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_trees_with_an_empty_code_editor_and_clicks_run_button() {
		treePage.clickOverviewOfTreesLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
		
	}

	@Then("No error message is displayed for Tree")
	public void no_error_message_is_displayed_for_tree() {
		treePage.getcurrentpageUrl();
	}

	@When("The user is on the tryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickOverviewOfTreesLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
		
	}

	@Then("The user should be able to see output in the console for Trees")
	public void the_user_should_be_able_to_see_output_in_the_console_for_trees() {
		treePage.getcurrentpageUrl();
	} 
    @When("The user is on Overview of Trees TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_overview_of_trees_tryeditor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickOverviewOfTreesLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	
	}

	@Then("The user should be able to get alert on Overview of Trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_overview_of_trees_tryeditor_page() {
		treePage.getcurrentpageUrl();
	}
	@When("The user is on the Overview of Trees page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_overview_of_trees_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickOverviewOfTreesLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Overview of Trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_overview_of_trees_page() {
	    treePage.getcurrentpageUrl();
	}

///
	@When("The user is on the Tree page after signing in and clicks the Terminologies link")
	public void the_user_is_on_tree_page_after_signing_in_and_clicks_the_terminologies_link() {
		treePage.clickTerminologiesLink();
				
	}

	@Then("The user should be redirected to the Terminologies data structure page")
	public void the_user_should_be_redirected_to_the_terminologies_data_structure_page() {
		treePage.getcurrentpageUrl();
	}

	@When("The user is on the Terminologies page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_terminologies_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickTerminologiesLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to a page with run button")
	public void the_user_is_redirected_to_a_page_with_run_button() {
		treePage.getcurrentpageUrl();
	}  
	@When("The user is on Terminologies TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_terminologies_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickTerminologiesLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}
	
	
	@Then("No error message is displayed on Terminologies TryEditor page")
	public void no_error_message_is_displayed_on_terminologies_tryeditor_page() {
		treePage.getcurrentpageUrl();
	}  
	
	@When("The user is on Terminologies TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_terminologies_tryeditor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickTerminologiesLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	
	}

	@Then("The user should be able to see output in the console Terminologies TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_terminologies_tryeditor_page() {
		treePage.getcurrentpageUrl();
	}  
	
	@When("The user is on Terminologies TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_terminologies_tryeditor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickTerminologiesLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	
	}

	@Then("The user should be able to get alert on Terminologies TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_terminologies_tryeditor_page() {
		treePage.getcurrentpageUrl();
	}  
	
	@When("The user is on the Terminologies page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_terminologies_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickTerminologiesLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Terminologies page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_terminologies_page() {
	    treePage.getcurrentpageUrl();
	}
	
	////////
	@When("The user is on the Tree page after signing in and clicks the types of trees link")
	public void the_user_is_on_the_tree_page_after_signing_in_and_clicks_the_types_of_trees_link() {
		treePage.clickTypesOfTreesLink();
	}

	@Then("The user should be redirected to the types of trees page")
	public void the_user_should_be_redirected_to_the_types_of_trees_page() {
	    treePage.getcurrentpageUrl();
	}

	@When("The user is on the types of trees page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_types_of_trees_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickTypesOfTreesLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to page with run button on types of trees page")
	public void the_user_is_redirected_to_page_with_run_button_on_types_of_trees_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on types of trees TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_types_of_trees_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickTypesOfTreesLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed on types of trees TryEditor page")
	public void no_error_message_is_displayed_on_types_of_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on types of trees TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_types_of_trees_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickTypesOfTreesLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console types of trees TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_types_of_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on types of trees TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_types_of_trees_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickTypesOfTreesLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on types of trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_types_of_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}
	@When("The user is on the types of trees page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_types_of_trees_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickTypesOfTreesLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from types of trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_types_of_trees_page() {
	    treePage.getcurrentpageUrl();
	}

///////////
	@When("The user is on the Tree page after signing in and clicks the Tree Traversals link")
	public void the_user_is_on_the_tree_page_after_signing_in_and_clicks_the_tree_traversals_link() {
		treePage.clickTreeTraversalsLink();
	}

	@Then("The user should be redirected to the Tree Traversals page")
	public void the_user_should_be_redirected_to_the_tree_traversals_page() {
	    treePage.getcurrentpageUrl();
	}

	@When("The user is on the Tree Traversals page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_tree_traversals_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickTreeTraversalsLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to page with run button on Tree Traversals page")
	public void the_user_is_redirected_to_page_with_run_button_on_tree_traversals_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Tree Traversals TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_tree_traversals_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickTreeTraversalsLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed on Tree Traversals TryEditor page")
	public void no_error_message_is_displayed_on_tree_traversals_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Tree Traversals TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_tree_traversals_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickTreeTraversalsLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console Tree Traversals TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_tree_traversals_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Tree Traversals TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_tree_traversals_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickTreeTraversalsLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Tree Traversals TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_tree_traversals_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}
	
	@When("The user is on the Tree Traversals page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_tree_traversals_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickTreeTraversalsLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Tree Traversals page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_tree_traversals_page() {
	    treePage.getcurrentpageUrl();
	}
//////
	@When("The user is on the Tree page after signing in and clicks the Traversals Illustration link")
	public void the_user_is_on_the_tree_page_after_signing_in_and_clicks_the_traversals_illustration_link() {
		treePage.clickTraversalsIllustrationsLink();
	}

	@Then("The user should be redirected to the Traversals Illustration page")
	public void the_user_should_be_redirected_to_the_traversals_illustration_page() {
	    treePage.getcurrentpageUrl();
	}

	@When("The user is on the Traversals Illustration page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_traversals_illustration_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickTraversalsIllustrationsLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to page with run button on Traversals Illustration page")
	public void the_user_is_redirected_to_page_with_run_button_on_traversals_illustration_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Traversals Illustration TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_traversals_illustration_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickTraversalsIllustrationsLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed on Traversals Illustration TryEditor page")
	public void no_error_message_is_displayed_on_traversals_illustration_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Traversals Illustration TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_traversals_illustration_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickTraversalsIllustrationsLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console Traversals Illustration TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_traversals_illustration_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Traversals Illustration TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_traversals_illustration_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickTraversalsIllustrationsLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Traversals Illustration TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_traversals_illustration_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}
	
	@When("The user is on the Traversals Illustration page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_traversals_illustration_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickTraversalsIllustrationsLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Traversals Illustration page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_traversals_illustration_page() {
	    treePage.getcurrentpageUrl();
	}
	
/////
	@When("The user is on the Tree page after signing in and clicks the Binary Trees link")
	public void the_user_is_on_the_tree_page_after_signing_in_and_clicks_the_binary_trees_link() {
		treePage.clickBinaryTreesLink();
	}

	@Then("The user should be redirected to the Binary Trees page")
	public void the_user_should_be_redirected_to_the_binary_trees_page() {
	    treePage.getcurrentpageUrl();
	}

	@When("The user is on the Binary Trees page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_binary_trees_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickBinaryTreesLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to page with run button on Binary Trees page")
	public void the_user_is_redirected_to_page_with_run_button_on_binary_trees_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Binary Trees TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_binary_trees_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickBinaryTreesLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed on Binary Trees TryEditor page")
	public void no_error_message_is_displayed_on_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Binary Trees TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_binary_trees_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickBinaryTreesLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console Binary Trees TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Binary Trees TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_binary_trees_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickBinaryTreesLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Binary Trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}
	@When("The user is on the Binary Trees page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_binary_trees_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickBinaryTreesLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Binary Trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_binary_trees_page() {
	    treePage.getcurrentpageUrl();
	}
//
	@When("The user is on the Tree page after signing in and clicks the Types of Binary Trees link")
	public void the_user_is_on_the_tree_page_after_signing_in_and_clicks_the_types_of_binary_trees_link() {
		treePage.clickTypesofBinaryTreesLink();
	}

	@Then("The user should be redirected to the Types of Binary Trees page")
	public void the_user_should_be_redirected_to_the_types_of_binary_trees_page() {
	    treePage.getcurrentpageUrl();
	}

	@When("The user is on the Types of Binary Trees page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_types_of_binary_trees_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickTypesofBinaryTreesLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to page with run button on Types of Binary Trees page")
	public void the_user_is_redirected_to_page_with_run_button_on_types_of_binary_trees_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Types of Binary Trees TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_types_of_binary_trees_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickTypesofBinaryTreesLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed on Types of Binary Trees TryEditor page")
	public void no_error_message_is_displayed_on_types_of_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Types of Binary Trees TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_types_of_binary_trees_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickTypesofBinaryTreesLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console Types of Binary Trees TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_types_of_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Types of Binary Trees TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_types_of_binary_trees_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickTypesofBinaryTreesLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Types of Binary Trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_types_of_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}
	@When("The user is on the Types of Binary Trees page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_types_of_binary_trees_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickTypesofBinaryTreesLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Types of Binary Trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_types_of_binary_trees_page() {
	    treePage.getcurrentpageUrl();
	}
	
//
	@When("The user is on the Tree page after signing in and clicks the Implementation in Python link")
	public void the_user_is_on_the_tree_page_after_signing_in_and_clicks_the_implementation_in_python_link() {
		treePage.clickImplementationinPythonLink();
	}

	@Then("The user should be redirected to the Implementation in Python page")
	public void the_user_should_be_redirected_to_the_implementation_in_python_page() {
	    treePage.getcurrentpageUrl();
	}

	@When("The user is on the Implementation in Python page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_implementation_in_python_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickImplementationinPythonLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to page with run button on Implementation in Python page")
	public void the_user_is_redirected_to_page_with_run_button_on_implementation_in_python_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Implementation in Python TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_implementation_in_python_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickImplementationinPythonLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed on Implementation in Python TryEditor page")
	public void no_error_message_is_displayed_on_implementation_in_python_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Implementation in Python TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_implementation_in_python_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickImplementationinPythonLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console Implementation in Python TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_implementation_in_python_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Implementation in Python TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_implementation_in_python_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickImplementationinPythonLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Implementation in Python TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_implementation_in_python_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}
	
	@When("The user is on the Implementation in Python page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_implementation_in_python_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickImplementationinPythonLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Implementation in Python page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_implementation_in_python_page() {
	    treePage.getcurrentpageUrl();
	}
	
	//////
	@When("The user is on the Tree page after signing in and clicks the Binary Tree Traversals link")
	public void the_user_is_on_the_tree_page_after_signing_in_and_clicks_the_binary_tree_traversals_link() {
		treePage.clickBinaryTreeTraversalsLink();
	}

	@Then("The user should be redirected to the Binary Tree Traversals page")
	public void the_user_should_be_redirected_to_the_binary_tree_traversals_page() {
	    treePage.getcurrentpageUrl();
	}

	@When("The user is on the Binary Tree Traversals page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_binary_tree_traversals_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickBinaryTreeTraversalsLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to page with run button on Binary Tree Traversals page")
	public void the_user_is_redirected_to_page_with_run_button_on_binary_tree_traversals_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Binary Tree Traversals TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_binary_tree_traversals_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickBinaryTreeTraversalsLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed on Binary Tree Traversals TryEditor page")
	public void no_error_message_is_displayed_on_binary_tree_traversals_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Binary Tree Traversals TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_binary_tree_traversals_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickBinaryTreeTraversalsLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console Binary Tree Traversals TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_binary_tree_traversals_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Binary Tree Traversals TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_binary_tree_traversals_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickBinaryTreeTraversalsLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Binary Tree Traversals TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_binary_tree_traversals_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}
	@When("The user is on the Binary Tree Traversals page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_binary_tree_traversals_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickBinaryTreeTraversalsLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Binary Tree Traversals page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_binary_tree_traversals_page() {
	    treePage.getcurrentpageUrl();
	}
	
	
	//////
	@When("The user is on the Tree page after signing in and clicks the Implementation of Binary Trees link")
	public void the_user_is_on_the_tree_page_after_signing_in_and_clicks_the_implementation_of_binary_trees_link() {
		treePage.clickImplementationOfBinaryTreesLink();
	}

	@Then("The user should be redirected to the Implementation of Binary Trees page")
	public void the_user_should_be_redirected_to_the_implementation_of_binary_trees_page() {
	    treePage.getcurrentpageUrl();
	}

	@When("The user is on the Implementation of Binary Trees page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_implementation_of_binary_trees_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickImplementationOfBinaryTreesLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to page with run button on Implementation of Binary Trees page")
	public void the_user_is_redirected_to_page_with_run_button_on_implementation_of_binary_trees_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Implementation of Binary Trees TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_implementation_of_binary_trees_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickImplementationOfBinaryTreesLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed on Implementation of Binary Trees TryEditor page")
	public void no_error_message_is_displayed_on_implementation_of_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Implementation of Binary Trees TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_implementation_of_binary_trees_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickImplementationOfBinaryTreesLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console Implementation of Binary Trees TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_implementation_of_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Implementation of Binary Trees TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_implementation_of_binary_trees_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickImplementationOfBinaryTreesLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Implementation of Binary Trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_implementation_of_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}
	@When("The user is on the Implementation of Binary Trees page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_implementation_of_binary_trees_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickImplementationOfBinaryTreesLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Implementation of Binary Trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_implementation_of_binary_trees_page() {
	    treePage.getcurrentpageUrl();
	}

//////
	@When("The user is on the Tree page after signing in and clicks the Applications of Binary trees link")
	public void the_user_is_on_the_tree_page_after_signing_in_and_clicks_the_applications_of_binary_trees_link() {
		treePage.clickApplicationOfBinarytreesLink();
	}

	@Then("The user should be redirected to the Applications of Binary trees page")
	public void the_user_should_be_redirected_to_the_applications_of_binary_trees_page() {
	    treePage.getcurrentpageUrl();
	}

	@When("The user is on the Applications of Binary trees page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_applications_of_binary_trees_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickApplicationOfBinarytreesLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to page with run button on Applications of Binary trees page")
	public void the_user_is_redirected_to_page_with_run_button_on_applications_of_binary_trees_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Applications of Binary trees TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_applications_of_binary_trees_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickApplicationOfBinarytreesLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed on Applications of Binary trees TryEditor page")
	public void no_error_message_is_displayed_on_applications_of_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Applications of Binary trees TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_applications_of_binary_trees_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickApplicationOfBinarytreesLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console Applications of Binary trees TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_applications_of_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Applications of Binary trees TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_applications_of_binary_trees_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickApplicationOfBinarytreesLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Applications of Binary trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_applications_of_binary_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}
	@When("The user is on the Applications of Binary trees page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_applications_of_binary_trees_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickApplicationOfBinarytreesLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Applications of Binary trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_applications_of_binary_trees_page() {
	    treePage.getcurrentpageUrl();
	}
//////
	@When("The user is on the Tree page after signing in and clicks the Binary Search Trees link")
	public void the_user_is_on_the_tree_page_after_signing_in_and_clicks_the_binary_search_trees_link() {
		treePage.clickBinarySearchTreesLink();
	}

	@Then("The user should be redirected to the Binary Search Trees page")
	public void the_user_should_be_redirected_to_the_binary_search_trees_page() {
	    treePage.getcurrentpageUrl();
	}

	@When("The user is on the Binary Search Trees page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_binary_search_trees_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickBinarySearchTreesLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to page with run button on Binary Search Trees page")
	public void the_user_is_redirected_to_page_with_run_button_on_binary_search_trees_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Binary Search Trees TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_binary_search_trees_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickBinarySearchTreesLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed on Binary Search Trees TryEditor page")
	public void no_error_message_is_displayed_on_binary_search_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Binary Search Trees TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_binary_search_trees_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickBinarySearchTreesLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console Binary Search Trees TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_binary_search_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Binary Search Trees TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_binary_search_trees_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickBinarySearchTreesLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Binary Search Trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_binary_search_trees_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}
	
	@When("The user is on the Binary Search Trees page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_binary_search_trees_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickBinarySearchTreesLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Applications of Binary Search Trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_applications_of_binary_search_trees_page() {
	    treePage.getcurrentpageUrl();
	}

/// 
	@When("The user is on the Tree page after signing in and clicks the Implementation Of BST link")
	public void the_user_is_on_the_tree_page_after_signing_in_and_clicks_the_implementation_of_bst_link() {
		treePage.clickImplementationofBTSLink();
	}

	@Then("The user should be redirected to the Implementation Of BST page")
	public void the_user_should_be_redirected_to_the_implementation_of_bst_page() {
	    treePage.getcurrentpageUrl();
	}

	@When("The user is on the Implementation Of BST page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_implementation_of_bst_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		treePage.clickImplementationofBTSLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to page with run button on Implementation Of BST page")
	public void the_user_is_redirected_to_page_with_run_button_on_implementation_of_bst_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Implementation Of BST TryEditor page and clicks on Run button with an empty code in Code Editor")
	public void the_user_is_on_implementation_of_bst_try_editor_page_and_clicks_on_run_button_with_an_empty_code_in_code_editor() {
		treePage.clickImplementationofBTSLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed on Implementation Of BST TryEditor page")
	public void no_error_message_is_displayed_on_implementation_of_bst_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Implementation Of BST TryEditor page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_implementation_of_bst_try_editor_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		treePage.clickImplementationofBTSLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console Implementation Of BST TryEditor page")
	public void the_user_should_be_able_to_see_output_in_the_console_implementation_of_bst_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on Implementation Of BST TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_implementation_of_bst_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		treePage.clickImplementationofBTSLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Implementation Of BST TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_implementation_of_bst_try_editor_page() {
		 treePage.getcurrentpageUrl();
	}

	@When("The user is on the Implementation Of BST page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_implementation_of_bst_page_after_signing_in_and_clicks_the_practice_questions_link() {
		treePage.clickImplementationofBTSLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Implementation Of BST page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_implementation_of_bst_page() {
	    treePage.getcurrentpageUrl();
	}







}
