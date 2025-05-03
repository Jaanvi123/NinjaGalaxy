package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.LinkedListPageObj;
import dsAlgoPageObjects.SignInPageObj;
import dsAlgoPageObjects.TreePageObj;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;

public class LinkedListStepDefinition {
	
	WebDriver driver = DriverFactory.getDriver();
	SignInPageObj signin = new SignInPageObj(driver);
	ConfigReader configReader = new ConfigReader(driver);
	IntroductionPageObj introductionpage = new IntroductionPageObj();
	HomePageObj homepage = new HomePageObj(driver);
	TreePageObj treePage = new TreePageObj(driver);
	LinkedListPageObj LinkedList = new LinkedListPageObj(driver);
	
	@Given("The user is on home page and clicks sign in link on the home page")
	public void the_user_is_on_home_page_and_clicks_sign_in_link_on_the_home_page() 
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		homepage.openHomeUrl();
		introductionpage.clickgetStartedButton(driver);
		introductionpage.clickSignInLink();
		signin.EnterFromExcel("login", 0);
		signin.clickloginButton();
	}

	@Then("The user enters valid credentials and clicks Get started button for Linked list to land on linked list Page")
	public void the_user_enters_valid_credentials_and_clicks_get_started_button_for_linked_list_to_land_on_linked_list_page() {
		introductionpage.clickLinkedListGetStartedButton();
		LinkedList.LinkedListTitle();
	}

	@When("The user is on the linked list page after signing in and clicks introduction link")
		public void the_user_is_on_the_linked_list_page_after_signing_in_and_clicks_introduction_link() {
		LinkedList.clickIntroductionLink();
	}

	@Then("the user should be redirected to the Introduction page")
	public void the_user_should_be_redirected_to_the_introduction_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Introduction page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_introduction_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		LinkedList.clickIntroductionLink();
		treePage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button for linked list")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_linked_list() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the tryEditor page of linked lists with an empty code editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_linked_lists_with_an_empty_code_editor_and_clicks_run_button() {
		LinkedList.clickIntroductionLink();
		treePage.clickTryHereButton();
		treePage.clickRunButton();
	}

	@Then("No error message is displayed for linked list")
	public void no_error_message_is_displayed_for_linked_list() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the tryEditor page of linked list and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_linked_list_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickIntroductionLink();
		treePage.clickTryHereButton();
		treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console for linked lists")
	public void the_user_should_be_able_to_see_output_in_the_console_for_linked_lists() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user is on Introduction TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_introduction_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickIntroductionLink();
		treePage.clickTryHereButton();
		treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Introduction TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_introduction_try_editor_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Introduction page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_introduction_page_after_signing_in_and_clicks_the_practice_questions_link() {
		LinkedList.clickIntroductionLink();
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Introduction page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_introduction_page() {
		LinkedList.getCurrentPageUrl();
	}

////
	@When("The user is on the linked list page after signing in and clicks Creating Linked List link")
	public void the_user_is_on_the_linked_list_page_after_signing_in_and_clicks_creating_linked_List_link() {
		LinkedList.clickcreatingLinkedListLink();
}

	@Then("the user should be redirected to the Creating Linked List page")
		public void the_user_should_be_redirected_to_the_creating_linked_list_page() {
	   LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Creating Linked List page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_creating_linked_list_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		LinkedList.clickcreatingLinkedListLink();
	    treePage.clickTryHereButton();
	}
	@Then("The user is redirected to a page having Editor with run button for Creating Linked List page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_creating_linked_list_page() {
		 LinkedList.getCurrentPageUrl();
	}
		
	
	@When("The user is on the tryEditor page of Creating Linked List page with an empty code editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_creating_linked_list_page_with_an_empty_code_editor_and_clicks_run_button() {
	LinkedList.clickcreatingLinkedListLink();
	treePage.clickTryHereButton();
	treePage.clickRunButton();
	}

	@Then("No error message is displayed for Creating Linked List page")
	public void no_error_message_is_displayed_for_creating_linked_list_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the tryEditor page of Creating Linked List page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_creating_linked_list_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
	LinkedList.clickcreatingLinkedListLink();
	treePage.clickTryHereButton();
	treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console for Creating Linked List page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_creating_linked_list_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on Creating Linked List TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_creating_linked_list_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
	LinkedList.clickcreatingLinkedListLink();
	treePage.clickTryHereButton();
	treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Creating Linked List TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_creating_linked_list_try_editor_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Creating Linked List page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_creating_linked_list_page_after_signing_in_and_clicks_the_practice_questions_link() {
	LinkedList.clickcreatingLinkedListLink();
	treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Creating Linked List page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_creating_linked_list_page() {
	LinkedList.getCurrentPageUrl();
	}

//////
	@When("The user is on the linked list page after signing in and clicks Types of Linked List link")
	public void the_user_is_on_the_linked_list_page_after_signing_in_and_clicks_types_of_linked_list_link() {
		LinkedList.clickTypesOfLinkedListLink();
}

	@Then("the user should be redirected to the Types of Linked List page")
		public void the_user_should_be_redirected_to_the_types_of_linked_list_page() {
	   LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Types of Linked List page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_types_of_linked_list_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		LinkedList.clickTypesOfLinkedListLink();
	    treePage.clickTryHereButton();
	}
	@Then("The user is redirected to a page having Editor with run button for Types of Linked List page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_types_of_linked_list_page() {
		 LinkedList.getCurrentPageUrl();
	}
		
	
	@When("The user is on the tryEditor page of Types of Linked List page with an empty code editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_types_of_linked_list_page_with_an_empty_code_editor_and_clicks_run_button() {
		LinkedList.clickTypesOfLinkedListLink();
	treePage.clickTryHereButton();
	treePage.clickRunButton();
	}

	@Then("No error message is displayed for Types of Linked List page")
	public void no_error_message_is_displayed_for_types_of_linked_list_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the tryEditor page of Types of Linked List page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_types_of_linked_list_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickTypesOfLinkedListLink();
	treePage.clickTryHereButton();
	treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console for Types of Linked List page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_types_of_linked_list_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on Types of Linked List TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_types_of_linked_list_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickTypesOfLinkedListLink();
	treePage.clickTryHereButton();
	treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Types of Linked List TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_types_of_linked_list_try_editor_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Types of Linked List page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_types_of_linked_list_page_after_signing_in_and_clicks_the_practice_questions_link() {
		LinkedList.clickTypesOfLinkedListLink();
	treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Types of Linked List page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_types_of_linked_list_page() {
	LinkedList.getCurrentPageUrl();
	}
///
	@When("The user is on the linked list page after signing in and clicks Implement Linked List in Python link")
	public void the_user_is_on_the_linked_list_page_after_signing_in_and_clicks_implement_linked_list_in_python_link() {
		LinkedList.clickImplementLLinPythonLink();
}

	@Then("the user should be redirected to the Implement Linked List in Python page")
		public void the_user_should_be_redirected_to_the_implement_linked_list_in_python_page() {
	   LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Implement Linked List in Python page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_implement_linked_list_in_python_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		LinkedList.clickImplementLLinPythonLink();
	    treePage.clickTryHereButton();
	}
	@Then("The user is redirected to a page having Editor with run button for Implement Linked List in Python page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_implement_linked_list_in_python_page() {
		 LinkedList.getCurrentPageUrl();
	}
		
	
	@When("The user is on the tryEditor page of Implement Linked List in Python page with an empty code editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_implement_linked_list_in_python_page_with_an_empty_code_editor_and_clicks_run_button() {
		LinkedList.clickImplementLLinPythonLink();
	treePage.clickTryHereButton();
	treePage.clickRunButton();
	}

	@Then("No error message is displayed for Implement Linked List in Python page")
	public void no_error_message_is_displayed_for_implement_linked_list_in_python_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the tryEditor page of Implement Linked List in Python page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_implement_linked_list_in_python_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickImplementLLinPythonLink();
	treePage.clickTryHereButton();
	treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console for Implement Linked List in Python page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_implement_linked_list_in_python_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on Implement Linked List in Python TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_implement_linked_list_in_python_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickImplementLLinPythonLink();
	treePage.clickTryHereButton();
	treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Implement Linked List in Python TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_implement_linked_list_in_python_try_editor_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Implement Linked List in Python page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_implement_linked_list_in_python_page_after_signing_in_and_clicks_the_practice_questions_link() {
		LinkedList.clickImplementLLinPythonLink();
	treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Implement Linked List in Python page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_implement_linked_list_in_python_page() {
	LinkedList.getCurrentPageUrl();
	}
//////
	@When("The user is on the linked list page after signing in and clicks Traversal link")
	public void the_user_is_on_the_linked_list_page_after_signing_in_and_clicks_traversal_link() {
		LinkedList.clickTraversalLink();
}

	@Then("the user should be redirected to the Traversal page")
		public void the_user_should_be_redirected_to_the_traversal_page() {
	   LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Traversal page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_traversal_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		LinkedList.clickTraversalLink();
	    treePage.clickTryHereButton();
	}
	@Then("The user is redirected to a page having Editor with run button for Traversal page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_traversal_page() {
		 LinkedList.getCurrentPageUrl();
	}
		
	
	@When("The user is on the tryEditor page of Traversal page with an empty code editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_traversal_page_with_an_empty_code_editor_and_clicks_run_button() {
		LinkedList.clickTraversalLink();
	treePage.clickTryHereButton();
	treePage.clickRunButton();
	}

	@Then("No error message is displayed for Traversal page")
	public void no_error_message_is_displayed_for_traversal_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the tryEditor page of Traversal page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_traversal_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickTraversalLink();
	treePage.clickTryHereButton();
	treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console for Traversal page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_traversal_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on Traversal TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_traversal_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickTraversalLink();
	treePage.clickTryHereButton();
	treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Traversal TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_traversal_try_editor_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Traversal page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_traversal_page_after_signing_in_and_clicks_the_practice_questions_link() {
		LinkedList.clickTraversalLink();
	treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Traversal page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_traversal_page() {
	LinkedList.getCurrentPageUrl();
	}
////
	@When("The user is on the linked list page after signing in and clicks Insertion link")
	public void the_user_is_on_the_linked_list_page_after_signing_in_and_clicks_insertion_link() {
		LinkedList.clickInsertionLink();
}

	@Then("the user should be redirected to the Insertion page")
		public void the_user_should_be_redirected_to_the_insertion_page() {
	   LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Insertion page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_insertion_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		LinkedList.clickInsertionLink();
	    treePage.clickTryHereButton();
	}
	@Then("The user is redirected to a page having Editor with run button for Insertion page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_insertion_page() {
		 LinkedList.getCurrentPageUrl();
	}
		
	
	@When("The user is on the tryEditor page of Insertion page with an empty code editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_insertion_page_with_an_empty_code_editor_and_clicks_run_button() {
		LinkedList.clickInsertionLink();
	treePage.clickTryHereButton();
	treePage.clickRunButton();
	}

	@Then("No error message is displayed for Insertion page")
	public void no_error_message_is_displayed_for_insertion_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the tryEditor page of Insertion page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_insertion_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickInsertionLink();
	treePage.clickTryHereButton();
	treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console for Insertion page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_insertion_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on Insertion TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_insertion_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickInsertionLink();
	treePage.clickTryHereButton();
	treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Insertion TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_insertion_try_editor_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Insertion page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_insertion_page_after_signing_in_and_clicks_the_practice_questions_link() {
		LinkedList.clickInsertionLink();
	treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Insertion page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_insertion_page() {
	LinkedList.getCurrentPageUrl();
	}
////
	@When("The user is on the linked list page after signing in and clicks Deletion link")
	public void the_user_is_on_the_linked_list_page_after_signing_in_and_clicks_deletion_link() {
		LinkedList.clickDeletionLink();
      }

	@Then("the user should be redirected to the Deletion page")
		public void the_user_should_be_redirected_to_the_deletion_page() {
	   LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Deletion page in the DS Algo portal and clicks Try Here button")
	public void the_user_is_on_the_deletion_page_in_the_ds_algo_portal_and_clicks_try_here_button() {
		LinkedList.clickDeletionLink();
	    treePage.clickTryHereButton();
	}
	@Then("The user is redirected to a page having Editor with run button for Deletion page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_deletion_page() {
		 LinkedList.getCurrentPageUrl();
	}
		
	
	@When("The user is on the tryEditor page of Deletion page with an empty code editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_deletion_page_with_an_empty_code_editor_and_clicks_run_button() {
		LinkedList.clickDeletionLink();
	treePage.clickTryHereButton();
	treePage.clickRunButton();
	}

	@Then("No error message is displayed for Deletion page")
	public void no_error_message_is_displayed_for_deletion_page() {
		LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the tryEditor page of Deletion page and writes valid Python code in the editor and clicks Run button")
	public void the_user_is_on_the_try_editor_page_of_deletion_page_and_writes_valid_python_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickDeletionLink();
	treePage.clickTryHereButton();
	treePage.validateTextEditorBox();
	}

	@Then("The user should be able to see output in the console for Deletion page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_deletion_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on Deletion TryEditor page and writes invalid code in the editor and clicks Run button")
	public void the_user_is_on_deletion_try_editor_page_and_writes_invalid_code_in_the_editor_and_clicks_run_button() {
		LinkedList.clickDeletionLink();
	treePage.clickTryHereButton();
	treePage.InvalidCode();
	}

	@Then("The user should be able to get alert on Deletion TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_deletion_try_editor_page() {
	LinkedList.getCurrentPageUrl();
	}

	@When("The user is on the Deletion page after signing in and clicks the Practice Questions link")
	public void the_user_is_on_the_deletion_page_after_signing_in_and_clicks_the_practice_questions_link() {
		LinkedList.clickDeletionLink();
	treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Deletion page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_deletion_page() {
	LinkedList.getCurrentPageUrl();
	}

}
