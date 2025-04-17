package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverManager.DriversBase;
import dsAlgoPOM.CommonPOM;
import dsAlgoPOM.IntroductionPage;
import dsAlgoPOM.LoginPage;
import dsAlgoPOM.TreePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TreeStepDefinition {
	
	TreePage treePage = new TreePage();
	
	public WebDriver driver = DriversBase.getDriver();

	 LoginPage login = new LoginPage();	
	 CommonPOM common = new CommonPOM();
	 IntroductionPage IP = new IntroductionPage();
	 
	@Given("the user is in the DS Algo portal after signing in")
	public void the_user_is_in_the_ds_algo_portal_after_signing_in() {
		
		common.openURL();
		System.out.println("Step is executing!");
		   
	}

	@When("the user clicks the Get Started button")
	public void the_user_clicks_the_get_started_button() {
		common.ClickHomePageGetStartedButton();
		
		System.out.println("Get started button clicked successfully");
	    
	}

	@Then("the user should be redirected to the Tree data structure page")
	public void the_user_should_be_redirected_to_the_tree_data_structure_page() {
		Assert.assertEquals(IP.getPageTitle(), "Tree");
		System.out.println("Tree data structure page opens");
	  
	}

	@Given("the user is in the home page and is signed in")
	public void the_user_is_in_the_home_page_and_is_signed_in() {
		common.openHomeURL();
	  
	}

	@When("The user selects tree item from the drop down menu")
	public void the_user_selects_tree_item_from_the_drop_down_menu() {
		IP.clickOnDropDown();
		System.out.println("DropDown Clicked");
	  
	}

	@Given("the user is on the Tree page after signing in")
	public void the_user_is_on_the_tree_page_after_signing_in() {
		IP.clickOnTreeGetStartedBtn();
		System.out.println("Get Started Button Clicked");
	   
	}

	/*@When("the user clicks the Overview of Trees button")
	public void the_user_clicks_the_overview_of_trees_button() {
		System.out.println("Step is executing!");
	   
	}

	@Then("the user should be redirected to the Overview of Trees data structure page")
	public void the_user_should_be_redirected_to_the_overview_of_trees_data_structure_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Overview of Trees page in the DS Algo portal")
	public void the_user_is_on_the_overview_of_trees_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks Try Here button on the  page")
	public void the_user_clicks_try_here_button_on_the_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user is redirected to a page having Editor with run button for Tree")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_tree() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("the user is on the tryEditor page of Trees with an empty code editor")
	public void the_user_is_on_the_try_editor_page_of_trees_with_an_empty_code_editor() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the Run button without entering any code for Tree")
	public void the_user_clicks_on_the_run_button_without_entering_any_code_for_tree() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("nothing happens and no error message is displayed for Tree")
	public void nothing_happens_and_no_error_message_is_displayed_for_tree() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user writes invalid Python code in the editor and clicks the Run button for Trees")
	public void the_user_writes_invalid_python_code_in_the_editor_and_clicks_the_run_button_for_trees() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see an error message in an alert window for Trees")
	public void the_user_should_see_an_error_message_in_an_alert_window_for_trees() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user writes valid Python code in the editor and clicks the Run button for Trees")
	public void the_user_writes_valid_python_code_in_the_editor_and_clicks_the_run_button_for_trees() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to see output in the console for Trees")
	public void the_user_should_be_able_to_see_output_in_the_console_for_trees() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Terminologies button")
	public void the_user_clicks_the_terminologies_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Terminologies data structure page")
	public void the_user_should_be_redirected_to_the_terminologies_data_structure_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Terminologies page in the DS Algo portal")
	public void the_user_is_on_the_terminologies_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Types of Trees link")
	public void the_user_clicks_the_types_of_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Types of Trees page")
	public void the_user_should_be_redirected_to_the_types_of_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Types of Trees page in the DS Algo portal")
	public void the_user_is_on_the_types_of_trees_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Tree Traversals link")
	public void the_user_clicks_the_tree_traversals_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Tree Traversals page")
	public void the_user_should_be_redirected_to_the_tree_traversals_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Tree Traversals page in the DS Algo portal")
	public void the_user_is_on_the_tree_traversals_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Traversals Illustration link")
	public void the_user_clicks_the_traversals_illustration_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Traversals Illustration page")
	public void the_user_should_be_redirected_to_the_traversals_illustration_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Traversals Illustration page in the DS Algo portal")
	public void the_user_is_on_the_traversals_illustration_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Binary Trees link")
	public void the_user_clicks_the_binary_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Binary Trees page")
	public void the_user_should_be_redirected_to_the_binary_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Binary Trees page in the DS Algo portal")
	public void the_user_is_on_the_binary_trees_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Types of Binary Trees link")
	public void the_user_clicks_the_types_of_binary_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Types of Binary Trees page")
	public void the_user_should_be_redirected_to_the_types_of_binary_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Types of Binary Trees page in the DS Algo portal")
	public void the_user_is_on_the_types_of_binary_trees_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Implementation In Python link")
	public void the_user_clicks_the_implementation_in_python_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Implementation In Python page")
	public void the_user_should_be_redirected_to_the_implementation_in_python_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Implementation in Python page in the DS Algo portal")
	public void the_user_is_on_the_implementation_in_python_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Binary Tree Traversals link")
	public void the_user_clicks_the_binary_tree_traversals_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Binary Tree Traversals page")
	public void the_user_should_be_redirected_to_the_binary_tree_traversals_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Binary Tree Traversals page in the DS Algo portal")
	public void the_user_is_on_the_binary_tree_traversals_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Implementation Of Binary Trees link")
	public void the_user_clicks_the_implementation_of_binary_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Implementation Of Binary Trees page")
	public void the_user_should_be_redirected_to_the_implementation_of_binary_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Implementation of Binary Trees page in the DS Algo portal")
	public void the_user_is_on_the_implementation_of_binary_trees_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Applications Of Binary Trees link")
	public void the_user_clicks_the_applications_of_binary_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Applications Of Binary Trees page")
	public void the_user_should_be_redirected_to_the_applications_of_binary_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Applications of Binary Trees page in the DS Algo portal")
	public void the_user_is_on_the_applications_of_binary_trees_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Binary Search Trees link")
	public void the_user_clicks_the_binary_search_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Binary Search Trees page")
	public void the_user_should_be_redirected_to_the_binary_search_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Binary Search Trees page in the DS Algo portal")
	public void the_user_is_on_the_binary_search_trees_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Implementation of Binary Search Trees link")
	public void the_user_clicks_the_implementation_of_binary_search_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Implementation of Binary Search Trees page")
	public void the_user_should_be_redirected_to_the_implementation_of_binary_search_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the Implementation of BST page in the DS Algo portal")
	public void the_user_is_on_the_implementation_of_bst_page_in_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks Practice Questions link")
	public void the_user_clicks_practice_questions_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user is redirected to Practice Questions page.")
	public void the_user_is_redirected_to_practice_questions_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}   */


}
