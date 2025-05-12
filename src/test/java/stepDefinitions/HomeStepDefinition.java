package stepDefinitions;

import org.openqa.selenium.WebDriver;
import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.RegisterPageObj;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.LoggerLoad;


public class HomeStepDefinition {	
	WebDriver driver = DriverFactory.getDriver();
    HomePageObj homepage = new HomePageObj(driver) ;
  
	RegisterPageObj registerPage = new RegisterPageObj(driver);
	
	@Given("The user enter correct DsAlgo portal URL")
	public void the_user_enter_correct_ds_algo_portal_url() {
		homepage.openUrl();
	}

	@When("The user clicks on Get started button")
	public void the_user_clicks_on_get_started_button() {
		homepage.clickGetStartedHomePageButton();
	}
	

	@Then("The user is navigated to Home Page")
	public void the_user_is_navigated_to_home_page() {
		homepage.getTitle();
	}
	//TC01
		
	@When("The user clicks the Data Structures dropdown")
	public void the_user_clicks_the_data_structures_dropdown() throws InterruptedException {
		homepage.clickDropdownArrow(driver);

	}

	@Then("The user should be able to see six options like Arrays Linked List Stack Queue Tree Graph in dropdown menu")
	public void the_user_should_be_able_to_see_six_options_like_arrays_linked_list_stack_queue_tree_graph_in_dropdown_menu() {
		
		LoggerLoad.info("User is on Data Structure Introduction Page and clicking on the Arrow");
	
	}
	//TC02

	@When("The user selects Arrays from the drop down without Sign in")
	public void the_user_selects_arrays_from_the_drop_down_without_sign_in() {
		homepage.clickDropdownArrow(driver);
		homepage.clickDropdownArray();
	}

	@Then("The user should able to see an warning message You are not logged in for Array drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_array_drop_down_option() {
		LoggerLoad.info(homepage.getAuthenticationMessage());

	}
	
	//TC03
	@When("The user selects Linked List from the drop down without Sign in")
	public void the_user_selects_linked_list_from_the_drop_down_without_sign_in() throws InterruptedException {
		homepage.clickDropdownArrow(driver);
		homepage.clickDropdownLinkedList();
	}

	@Then("The user should able to see an warning message You are not logged in for Linked List drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_linked_list_drop_down_option() {
		LoggerLoad.info(homepage.getAuthenticationMessage());
	}
	
	//TC04
	@When("The user selects Stack from the drop down without Sign in")
	public void the_user_selects_stack_from_the_drop_down_without_sign_in() {
		homepage.clickDropdownArrow(driver);
		homepage.clickDropdownStack();
	}

	@Then("The user should able to see an warning message You are not logged in for Stack drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_stack_drop_down_option() {
		LoggerLoad.info(homepage.getAuthenticationMessage());
	}
	
	//TC05
	@When("The user selects Queue from the drop down without Sign in")
	public void the_user_selects_queue_from_the_drop_down_without_sign_in() {
		homepage.clickDropdownArrow(driver);
		homepage.clickDropdownQueue();
	}

	@Then("The user should able to see an warning message You are not logged in for Queue drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_queue_drop_down_option() {
		LoggerLoad.info(homepage.getAuthenticationMessage());
	}
	
	//TC06
	@When("The user selects Tree from the drop down without Sign in")
	public void the_user_selects_tree_from_the_drop_down_without_sign_in() {
		homepage.clickDropdownArrow(driver);
		homepage.clickDropdownTree();
	}

	@Then("The user should able to see an warning message You are not logged in for Tree drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_tree_drop_down_option() {
		LoggerLoad.info(homepage.getAuthenticationMessage());
	}
	//TC07

	@When("The user selects Graph from the drop down without Sign in")
	public void the_user_selects_graph_from_the_drop_down_without_sign_in() {
		homepage.clickDropdownArrow(driver);
		homepage.clickDropdownGraph();
	}

	@Then("The user should able to see an warning message You are not logged in for Graph drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_graph_drop_down_option() {
		LoggerLoad.info(homepage.getAuthenticationMessage());
	}
	
	//TC08
	
	@When("The user clicks Get Started buttons of Data Structures-Introduction on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_data_structures_introduction_on_the_homepage_without_sign_in() {
		homepage.clickgetStartedButton(driver);
		homepage.clickDsGetStartedButton();

	}

	@Then("The user should able to see an warning message You are not logged in for DS Introduction")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_ds_introduction() {
		LoggerLoad.info("warning message You are not logged in for DS Introduction");
	}
	//TC09

	@When("The user clicks Get Started buttons of Array on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_array_on_the_homepage_without_sign_in() {
		homepage.clickgetStartedButton(driver);
		homepage.clickArrayGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Array")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_array() {
		LoggerLoad.info(homepage.getAuthenticationMessage());
	}

	//TC10
	@When("The user clicks Get Started buttons of Linked List on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_linked_list_on_the_homepage_without_sign_in() {
		homepage.clickgetStartedButton(driver);
		homepage.clickLinkedListGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Linked List")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_linked_list() {
		LoggerLoad.info(homepage.getAuthenticationMessage());
	}

	//TC11
	@When("The user clicks Get Started buttons of Stack on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_stack_on_the_homepage_without_sign_in() {
		homepage.clickgetStartedButton(driver);
		homepage.clickStackGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Stack")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_stack() {
		LoggerLoad.info(homepage.getAuthenticationMessage());
	}

	//TC12
	@When("The user clicks Get Started buttons of Queue on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_queue_on_the_homepage_without_sign_in() {
		homepage.clickgetStartedButton(driver);
		homepage.clickQueueGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Queue")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_queue() {
		LoggerLoad.info(homepage.getAuthenticationMessage());
	}

	//TC13
	@When("The user clicks Get Started buttons of Tree on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_tree_on_the_homepage_without_sign_in() {
		homepage.clickgetStartedButton(driver);
		homepage.clickTreeGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Tree")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_tree() {
		LoggerLoad.info(homepage.getAuthenticationMessage());
	}

	//TC14
	@When("The user clicks Get Started buttons of Graph on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_graph_on_the_homepage_without_sign_in() {
		homepage.clickgetStartedButton(driver);
		homepage.clickGraphGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Graph")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_graph() {
		LoggerLoad.info(homepage.getAuthenticationMessage());
	}
	//TC15
	@When("The user clicks on RegisterLink on Home Page")
	public void the_user_clicks_on_registerlink_on_home_page() {
		
		homepage.clickRegisterLink();
	}
	@Then("The user lands on Register page")
	public void the_user_lands_on_register_page() {
		LoggerLoad.info("Regsiter page clicked");
	}
	//TC16
	@When("The user clicks on Sign in on Home Page")
	public void the_user_clicks_on_sign_in_on_home_page() {
		
		homepage.clickSignInLink();
	}
	@Then("The user lands on Login page")
	public void the_user_lands_on_login_page() {
		LoggerLoad.info("Sign In page clicked");
	}
}


