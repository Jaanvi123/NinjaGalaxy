package stepDefinitions;

import org.openqa.selenium.WebDriver;

import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.RegisterPageObj;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.LoggerLoad;


public class HomeStepDefinition {	
	WebDriver driver = DriverFactory.getDriver();
    HomePageObj homepage = new HomePageObj(driver) ;
   	IntroductionPageObj introductionpage = new IntroductionPageObj();
	RegisterPageObj registerPage = new RegisterPageObj();
	
	String expectedMessage = "You are not logged in";
	//String homepageTitle;
	//WebElement getstartedBtn;

	
	@Given("The user enter correct dsAlgo portal URL")
	public void the_user_enter_correct_ds_algo_portal_url() {
		DriverFactory.initializeDriver("chrome");  
		System.out.println("URl opened");
	}

	@Then("The user clicks the Get Started button")
	public void the_user_clicks_the_get_started_button() {
		homepage.clickGetStartedHomePageButton();
	}

	@Then("The user should land in Data Structure Introduction Page with register and Sign in links")
	public void the_user_should_land_in_data_structure_introduction_page_with_register_and_sign_in_links() {
		LoggerLoad.info("User is on Data Structure Introduction Page");
	}

	@When("The user clicks the Data Structures dropdown")
	public void the_user_clicks_the_data_structures_dropdown() throws InterruptedException {
		introductionpage.clickDropdownArrow(driver);

	}

	@Then("The user should be able to see six options like Arrays Linked List Stack Queue Tree Graph in dropdown menu")
	public void the_user_should_be_able_to_see_six_options_like_arrays_linked_list_stack_queue_tree_graph_in_dropdown_menu() {
		LoggerLoad.info("User is on Data Structure Introduction Page and clicking on the Arrow");
		// put assert statement
	}

	@When("The user selects Arrays from the drop down without Sign in")
	public void the_user_selects_arrays_from_the_drop_down_without_sign_in() {
		introductionpage.clickDropdownArrow(driver);
		introductionpage.clickDropdownArray();
	}

	@Then("The user should able to see an warning message You are not logged in for Array drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_array_drop_down_option() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());

	}

	@When("The user selects Linked List from the drop down without Sign in")
	public void the_user_selects_linked_list_from_the_drop_down_without_sign_in() throws InterruptedException {
		introductionpage.clickDropdownArrow(driver);
		introductionpage.clickDropdownLinkedList();
	}

	@Then("The user should able to see an warning message You are not logged in for Linked List drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_linked_list_drop_down_option() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());
	}

	@When("The user selects Stack from the drop down without Sign in")
	public void the_user_selects_stack_from_the_drop_down_without_sign_in() {
		introductionpage.clickDropdownArrow(driver);
		introductionpage.clickDropdownStack();
	}

	@Then("The user should able to see an warning message You are not logged in for Stack drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_stack_drop_down_option() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());
	}

	@When("The user selects Queue from the drop down without Sign in")
	public void the_user_selects_queue_from_the_drop_down_without_sign_in() {
		introductionpage.clickDropdownArrow(driver);
		introductionpage.clickDropdownQueue();
	}

	@Then("The user should able to see an warning message You are not logged in for Queue drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_queue_drop_down_option() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());
	}

	@When("The user selects Tree from the drop down without Sign in")
	public void the_user_selects_tree_from_the_drop_down_without_sign_in() {
		introductionpage.clickDropdownArrow(driver);
		introductionpage.clickDropdownTree();
	}

	@Then("The user should able to see an warning message You are not logged in for Tree drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_tree_drop_down_option() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());
	}

	@When("The user selects Graph from the drop down without Sign in")
	public void the_user_selects_graph_from_the_drop_down_without_sign_in() {
		introductionpage.clickDropdownArrow(driver);
		introductionpage.clickDropdownGraph();
	}

	@Then("The user should able to see an warning message You are not logged in for Graph drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_graph_drop_down_option() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());
	}
	
	@When("The user clicks Get Started buttons of Data Structures-Introduction on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_data_structures_introduction_on_the_homepage_without_sign_in() {
		introductionpage.clickgetStartedButton(driver);
		introductionpage.clickDsGetStartedButton();

	}

	@Then("The user should able to see an warning message You are not logged in for DS Introduction")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_ds_introduction() {
		System.out.println("warning message You are not logged in for DS Introduction");
	}


	@When("The user clicks Get Started buttons of Array on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_array_on_the_homepage_without_sign_in() {
		introductionpage.clickgetStartedButton(driver);
		introductionpage.clickArrayGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Array")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_array() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());
	}


	@When("The user clicks Get Started buttons of Linked List on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_linked_list_on_the_homepage_without_sign_in() {
		introductionpage.clickgetStartedButton(driver);
		introductionpage.clickLinkedListGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Linked List")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_linked_list() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());
	}


	@When("The user clicks Get Started buttons of Stack on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_stack_on_the_homepage_without_sign_in() {
		introductionpage.clickgetStartedButton(driver);
		introductionpage.clickStackGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Stack")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_stack() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());
	}


	@When("The user clicks Get Started buttons of Queue on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_queue_on_the_homepage_without_sign_in() {
		introductionpage.clickgetStartedButton(driver);
		introductionpage.clickQueueGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Queue")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_queue() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());
	}


	@When("The user clicks Get Started buttons of Tree on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_tree_on_the_homepage_without_sign_in() {
		introductionpage.clickgetStartedButton(driver);
		introductionpage.clickTreeGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Tree")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_tree() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());
	}


	@When("The user clicks Get Started buttons of Graph on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_graph_on_the_homepage_without_sign_in() {
		introductionpage.clickgetStartedButton(driver);
		introductionpage.clickGraphGetStartedButton();
	}

	@Then("The user should able to see an warning message You are not logged in for Graph")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_graph() {
		LoggerLoad.info(introductionpage.getAuthenticationMessage());
	}
	
	@When("The user clicks on RegisterLink on Home Page")
	public void the_user_clicks_on_registerlink_on_home_page() {
		introductionpage.clicklink(driver);
		introductionpage.clickRegisterLink();
	}
	@Then("The user lands on Register page")
	public void the_user_lands_on_register_page() {
		LoggerLoad.info("Regsiter page clicked");
	}
	@When("The user clicks on Sign in on Home Page")
	public void the_user_clicks_on_sign_in_on_home_page() {
		introductionpage.clicklink(driver);
		introductionpage.clickSignInLink();
	}
	@Then("The user lands on Login page")
	public void the_user_lands_on_login_page() {
		LoggerLoad.info("Sign In page clicked");
	}
}


