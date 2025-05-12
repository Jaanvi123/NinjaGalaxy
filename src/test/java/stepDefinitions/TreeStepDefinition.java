package stepDefinitions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.SignInPageObj;
import dsAlgoPageObjects.TreePageObj;
import dsAlgoPageObjects.TryEditorPage;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.LoggerLoad;

public class TreeStepDefinition {

	WebDriver driver = DriverFactory.getDriver();
	SignInPageObj signin = new SignInPageObj(driver);
	HomePageObj homepage = new HomePageObj(driver);
	TreePageObj treePage = new TreePageObj(driver);
	TryEditorPage tryEditorPage = new TryEditorPage(driver);
	
	@Given("The user is on home page")
	public void the_user_is_on_home_page() {
		homepage.openHomeUrl();
	}

	@When("The user clicks Sign in link and enters valid credentials")
	public void the_user_clicks_sign_in_link_and_enters_valid_credentials() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		homepage.clickgetStartedButton(driver);
		homepage.clickSignInLink();
		signin.enterUsernameText("username");
		signin.enterPasswordText("password");
		signin.clickloginButton();
	}

	@Then("The user should land on the tree page by clicking Get started button for tree module")
	public void the_user_should_land_on_the_tree_page_by_clicking_get_started_button_for_tree_module() {
		homepage.clickTreeGetStartedButton();
		Assert.assertEquals(homepage.getHomePageTitle(), "Tree");
		
	}
	//TC01	
	@Given("The user is on the Tree page after signing in")
	public void the_user_is_on_the_tree_page_after_signing_in() {
		treePage.TreePageTitle();
	}
		
	@When("The user clicks the Overview of Trees link")
	public void the_user_clicks_the_overview_of_trees_link() {
		treePage.clickOverviewOfTreesLink();	
	}

	@Then("The user should be redirected to the Overview of Trees data structure page")
	public void the_user_should_be_redirected_to_the_overview_of_trees_data_structure_page() {
		 treePage.getcurrentpageUrl();
		 Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("trees/"));
	}
	//TC02
	@Given("The user is on the Overview of Trees page")
	public void the_user_is_on_the_overview_of_trees_page() {
		treePage.clickOverviewOfTreesLink();
		treePage.getcurrentpageUrl();
	}

	@When("The user clicks Try Here button in Overview of Trees page")
	public void the_user_clicks_try_here_button_in_overview_of_trees_page() {
		tryEditorPage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button for Overview of Trees page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_overview_of_trees_page() {
		treePage.getcurrentpageUrl();
		 Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
	//TC03		
	@Given("The user is on the tryEditor page after clicking Try here button in Overview of Trees link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_overview_of_trees_link() {
		treePage.clickOverviewOfTreesLink();
		tryEditorPage.clickTryHereButton();
	}
	
	@When("The user enters an empty code in editor of Overview of Trees link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_overview_of_trees_link_and_clicks_run_button() {		
		tryEditorPage.clickRunButton();		
	}

	@Then("No error message is displayed for Try editor of Overview of Trees page")
	public void no_error_message_is_displayed_for_try_editor_of_overview_of_trees_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}

	// TC04
    @Given("The user is on the tryEditor page and clicks Try here button in Overview of Trees link")
    public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_overview_of_trees_link() {
    	treePage.clickOverviewOfTreesLink();
        tryEditorPage.clickTryHereButton();
       
    }
    @When("The user writes invalid code in the editor of Overview of Trees page and clicks Run button from sheetname {string} and row {int}")
    public void the_user_writes_invalid_code_in_the_editor_of_overview_of_trees_page_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
        try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
    @Then("The user should be able to get alert on Overview of Trees TryEditor page")
    public void the_user_should_able_to_get_alert_on_overview_of_trees_tryeditor_page() {
    	boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
    	
      
    }
    // TC05
    @Given("The user is on the tryEditor page along with run button and valid code")
    public void the_user_is_on_the_try_editor_page_along_with_run_button_and_valid_code() {
    	treePage.clickOverviewOfTreesLink();
        tryEditorPage.clickTryHereButton();
        
    }
    @When("The user writes valid Python code in the editor of Overview of Trees page and clicks Run button from sheetname {string} and row {int}")
    public void the_user_writes_valid_python_code_in_the_editor_of_overview_of_trees_page_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
        try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
    @Then("The user should be able to see output in the console for Overview of Trees page")
    public void the_user_should_be_able_to_see_output_in_the_console_for_overview_of_trees_page() {
    	treePage.codeEditorOutput();
    }

//TC06	
	@Given("The user is on overview of Trees page after signing in")
	public void the_user_is_on_overview_of_trees_page_after_signing_in() {
		treePage.clickOverviewOfTreesLink();
	}

	@When("The user clicks the Practice Questions link present in Overview of Trees page")
	public void the_user_clicks_the_practice_questions_link_present_in_overview_of_trees_page() {
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Overview of Trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_overview_of_trees_page() {
	    treePage.getcurrentpageUrl();
	    Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC07
	@Given("The user is on the Tree page after valid sign in")
	public void the_user_is_on_the_tree_page_after_valid_sign_in() {
		treePage.getcurrentpageUrl();	
			}	
	@When("The user clicks the Terminologies link")
	public void the_user_clicks_the_terminologies_link() {
		treePage.clickTerminologiesLink();		
	}
	@Then("The user should be redirected to the Terminologies data structure page")
	public void the_user_should_be_redirected_to_the_terminologies_data_structure_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("terminologies/"));

	}
//TC08
	@Given("The user is on the Terminologies page")
	public void the_user_is_on_the_terminologies_page() {
		treePage.clickTerminologiesLink();
	}
	@When("The user clicks Try Here button in Terminologies page")
	public void the_user_clicks_try_here_button_in_terminologies_page() {
		tryEditorPage.clickTryHereButton();
	}
	@Then("The user is redirected to a page having Editor with run button for Terminologies page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_terminologies_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC09			
	@Given("The user is on the tryEditor page after clicking Try here button in Terminologies link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_terminologies_link() {
		treePage.clickTerminologiesLink();
		tryEditorPage.clickTryHereButton();
	}
	
	@When("The user enters an empty code in editor of Terminologies link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_terminologies_link_and_clicks_run_button() {		
		tryEditorPage.clickRunButton();		
	}

	@Then("No error message is displayed for Try editor of Terminologies page")
	public void no_error_message_is_displayed_for_try_editor_of_terminologies_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}

//TC10
    @Given("The user is on the tryEditor page and clicks Try here button in Terminologies link")
    public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_terminologies_link() {
    	treePage.clickTerminologiesLink();
        tryEditorPage.clickTryHereButton();
       
    }
    @When("The user writes invalid code in the editor of Terminologies page and clicks Run button from sheetname {string} and row {int}")
    public void the_user_writes_invalid_code_in_the_editor_of_terminologies_page_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
        try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
    @Then("The user should be able to get alert on Terminologies TryEditor page")
    public void the_user_should_be_able_to_get_alert_on_terminologies_try_editor_page() {
    	boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
    	
      
    }
//TC11
    @Given("The user is on tryEditor page along with run button and valid code for Terminologies page")
    public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_terminologies_page() {
    	treePage.clickTerminologiesLink();
        tryEditorPage.clickTryHereButton();
        
    }
    @When("The user writes valid Python code in the editor of Terminologies page and clicks Run button from sheetname {string} and row {int}")
    public void the_user_writes_valid_python_code_in_the_editor_of_terminologies_page_and_clicks_run_button_from_sheetname_and_row(String sheetName, Integer rowNumber) {
        try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
    @Then("The user should be able to see output in the console for Terminologies page")
    public void the_user_should_be_able_to_see_output_in_the_console_for_terminologies_page() {
              treePage.codeEditorOutput();
    }

//TC12	
	@Given("The user is on Terminologies page after signing in")
	public void the_user_is_on_terminologies_page_after_signing_in() {
		treePage.clickTerminologiesLink();
	}
	@When("The user clicks the Practice Questions link present in Terminologies page")
	public void the_user_clicks_the_practice_questions_link_present_in_terminologies_page() {
		treePage.clickPracticeQuestionsLink();
	}
	@Then("The user should be redirected to the Practice Questions page from Terminologies page")
	public void the_user_should_be_redirected_to_the_practice_questions_from_terminologies_page() {
	    treePage.getcurrentpageUrl();
	    Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC13
	@Given("The user is on the Tree page")
	public void the_user_is_on_the_tree_page() {
		treePage.getcurrentpageUrl();
	}
	@When("The user clicks the Types of Trees link")
	public void the_user_clicks_the_types_of_trees_link() {
		treePage.clickTypesOfTreesLink();	
	}

	@Then("The user should be redirected to the Types of Trees data structure page")
	public void the_user_should_be_redirected_to_the_types_of_trees_data_structure_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("types-of-trees/"));
	}
//TC14	
	@Given("The user is on the Types of Trees page")
	public void the_user_is_on_the_types_of_trees_page() {
		treePage.clickTypesOfTreesLink();
	}

	@When("The user clicks Try Here button in Types of Trees page")
	public void the_user_clicks_try_here_button_in_types_of_trees_page() {
		 tryEditorPage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button for Types of Trees page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_types_of_trees_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}	
//TC15	
	@Given("The user is on the tryEditor page after clicking Try here button in Types of Trees link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_types_of_trees_link() {
		treePage.clickTypesOfTreesLink();
		 tryEditorPage.clickTryHereButton();
	}

	@When("The user enters an empty code in editor of Types of Trees link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_types_of_trees_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Types of Trees page")
	public void no_error_message_is_displayed_for_try_editor_of_types_of_trees_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC16
	@Given("The user is on the tryEditor page and clicks Try here button in Types of Trees link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_types_of_trees_link() {
		treePage.clickTypesOfTreesLink();
		tryEditorPage.clickTryHereButton();
	}	
	@When("The user writes invalid code in the editor of Types of Trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_types_of_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	
	@Then("The user should be able to get alert on Types of Trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_types_of_trees_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}
	

//TC17	
	@Given("The user is on tryEditor page along with run button and valid code for Types of Trees page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_types_of_trees_page() {
		 treePage.clickTypesOfTreesLink();
		 tryEditorPage.clickTryHereButton();
	}

	@When("The user writes valid Python code in the editor of Types of Trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_types_of_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
	@Then("The user should be able to see output in the console for Types of Trees page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_types_of_trees_page() {
		  treePage.codeEditorOutput();
	}
	
//TC18
	@Given("The user is on Types of Trees page after signing in")
	public void the_user_is_on_types_of_trees_page_after_signing_in() {
		treePage.clickTypesOfTreesLink();
	}
	@When("The user clicks the Practice Questions link present in Types of Trees page")
	public void the_user_clicks_the_practice_questions_link_present_in_types_of_trees_page() {
		treePage.clickPracticeQuestionsLink();
	}
	@Then("The user should be redirected to the Practice Questions page from Types of Trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_types_of_trees_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC19
	@Given("The user is on the Tree page after clicking get started button")
	public void the_user_is_on_the_tree_page_after_clicking_get_started_button() {
		treePage.getcurrentpageUrl();
	}

	@When("The user clicks the Tree Traversals link")
	public void the_user_clicks_the_tree_traversals_link() {
	   treePage.clickTreeTraversalsLink();
	   }

	@Then("The user should be redirected to the Tree Traversals data structure page")
	public void the_user_should_be_redirected_to_the_tree_traversals_data_structure_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tree-traversals/"));
	}
//TC20
	@Given("The user is on the Tree Traversals page")
	public void the_user_is_on_the_tree_traversals_page() {
		 treePage.clickTreeTraversalsLink();
	}

	@When("The user clicks Try Here button in Tree Traversals page")
	public void the_user_clicks_try_here_button_in_tree_traversals_page() {
		treePage.PageScrollDown();
		tryEditorPage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button for Tree Traversals page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_tree_traversals_page() {
		treePage.getcurrentpageUrl();
		
	}
//TC21
	@Given("The user is on the tryEditor page after clicking Try here button in Tree Traversals link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_tree_traversals_link() {
		 treePage.clickTreeTraversalsLink();
		 treePage.PageScrollDown();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
			tryHerebutton.click();
	}

	@When("The user enters an empty code in editor of Tree Traversals link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_tree_traversals_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Tree Traversals page")
	public void no_error_message_is_displayed_for_try_editor_of_tree_traversals_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC22
	@Given("The user is on the tryEditor page and clicks Try here button in Tree Traversals link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_tree_traversals_link() {
		treePage.clickTreeTraversalsLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes invalid code in the editor of Tree Traversals page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_tree_traversals_page_and_clicks_run_button_from_sheetname_and_row(
			String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }	
	@Then("The user should be able to get alert on Tree Traversals TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_tree_traversals_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}
	
//TC23
	@Given("The user is on tryEditor page along with run button and valid code for Tree Traversals page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_tree_traversals_page() {
		treePage.clickTreeTraversalsLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	
	@When("The user writes valid Python code in the editor of Tree Traversals page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_tree_traversals_page_and_clicks_run_button_from_sheetname_and_row(
			String sheetName, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}

	@Then("The user should be able to see output in the console for Tree Traversals page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_tree_traversals_page() {
		treePage.codeEditorOutput();
	}

//TC24
	@Given("The user is on Tree Traversals page after signing in")
	public void the_user_is_on_tree_traversals_page_after_signing_in() {
		treePage.clickTreeTraversalsLink();
	}	
	
	
	@When("The user clicks the Practice Questions link present in Tree Traversals page")
	public void the_user_clicks_the_practice_questions_link_present_in_tree_traversals_page() {
	    treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Tree Traversals page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_tree_traversals_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}
	
	
//TC25
	@Given("The user is on the Tree page after clicking get started")
	public void the_user_is_on_the_tree_page_after_clicking_get_started() {
		treePage.getcurrentpageUrl();
	}

	@When("The user clicks the Traversals Illustration link")
	public void the_user_clicks_the_traversals_illustration_link() {
	    treePage.clickTraversalsIllustrationsLink();
	}

	@Then("The user should be redirected to the Traversals Illustration data structure page")
	public void the_user_should_be_redirected_to_the_traversals_illustration_data_structure_page() {
		treePage.getcurrentpageUrl();
        Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("traversals-illustration/"));
	}
//TC26
	@Given("The user is on the Traversals Illustration page")
	public void the_user_is_on_the_traversals_illustration_page() {
		treePage.clickTraversalsIllustrationsLink();
	}

	@When("The user clicks Try Here button in Traversals Illustration page")
	public void the_user_clicks_try_here_button_in_traversals_illustration_page() {
		tryEditorPage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button for Traversals Illustration page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_traversals_illustration_page() {
		treePage.getcurrentpageUrl();
		
	}
//TC27
	@Given("The user is on the tryEditor page after clicking Try here button in Traversals Illustration link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_traversals_illustration_link() {
		treePage.clickTraversalsIllustrationsLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user enters an empty code in editor of Traversals Illustration link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_traversals_illustration_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Traversals Illustration page")
	public void no_error_message_is_displayed_for_try_editor_of_traversals_illustration_page() {
		treePage.getcurrentpageUrl();
	}
//TC28
	@Given("The user is on the tryEditor page and clicks Try here button in Traversals Illustration link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_traversals_illustration_link() {
		treePage.clickTraversalsIllustrationsLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes invalid code in the editor of Traversals Illustration page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_traversals_illustration_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
	@Then("The user should be able to get alert on Traversals Illustration TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_traversals_illustration_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}	
//TC29
	@Given("The user is on tryEditor page along with run button and valid code for Traversals Illustration page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_traversals_illustration_page() {
		treePage.clickTraversalsIllustrationsLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	
	@When("The user writes valid Python code in the editor of Traversals Illustration page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_traversals_illustration_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	@Then("The user should be able to see output in the console for Traversals Illustration page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_traversals_illustration_page() {
		treePage.codeEditorOutput();
	}

//TC30
	@Given("The user is on Traversals Illustration page after signing in")
	public void the_user_is_on_traversals_illustration_page_after_signing_in() {
		treePage.clickTraversalsIllustrationsLink();	
	}
	@When("The user clicks the Practice Questions link present in Traversals Illustration page")
	public void the_user_clicks_the_practice_questions_link_present_in_traversals_illustration_page() {
	    treePage.clickPracticeQuestionsLink();	   
	}
	@Then("The user should be redirected to the Practice Questions page from Traversals Illustration page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_traversals_illustration_page() {
		treePage.getcurrentpageUrl();
		 Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC31
	@Given("The user is on Tree page after clicking get started")
	public void the_user_is_on_tree_page_after_clicking_get_started() {
		treePage.getcurrentpageUrl();		
	}
	@When("The user clicks the  Binary Trees link")
	public void the_user_clicks_the_binary_trees_link() {
	   treePage.clickBinaryTreesLink();
	}
	@Then("The user should be redirected to the  Binary Trees data structure page")
	public void the_user_should_be_redirected_to_the_binary_trees_data_structure_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("binary-trees/"));
	}
//TC32
	@Given("The user is on the  Binary Trees page")
	public void the_user_is_on_the_binary_trees_page() {
		treePage.clickBinaryTreesLink();
	}

	@When("The user clicks Try Here button in  Binary Trees page")
	public void the_user_clicks_try_here_button_in_binary_trees_page() {
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@Then("The user is redirected to a page having Editor with run button for  Binary Trees page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_binary_trees_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC33
	@Given("The user is on the tryEditor page after clicking Try here button in Binary Trees link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_binary_trees_link(){
		treePage.clickBinaryTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user enters an empty code in editor of  Binary Trees link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_binary_trees_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}
	@Then("No error message is displayed for Try editor of  Binary Trees page")
	public void no_error_message_is_displayed_for_try_editor_of_binary_trees_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC34
	@Given("The user is on the tryEditor page and clicks Try here button in Binary Trees link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_binary_trees_link() {
		treePage.clickBinaryTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	
	@When("The user writes invalid code in the editor of Binary Trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_binary_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
	@Then("The user should be able to get alert on Binary Trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_binary_trees_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}
	
//TC35
	@Given("The user is on tryEditor page along with run button and valid code for Binary Trees page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_binary_trees_page() {
		treePage.clickBinaryTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes valid Python code in the editor of Binary Trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_binary_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	@Then("The user should be able to see output in the console for Binary Trees page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_binary_trees_page() {
		treePage.codeEditorOutput();	
	}

//TC36
	@Given("The user is on  Binary Trees page after signing in")
	public void the_user_is_on_binary_trees_page_after_signing_in() {
		treePage.clickBinaryTreesLink();
	}
	@When("The user clicks the Practice Questions link present in  Binary Trees page")
	public void the_user_clicks_the_practice_questions_link_present_in_binary_trees_page() {
	    treePage.clickPracticeQuestionsLink();
	}
	@Then("The user should be redirected to the Practice Questions page from  Binary Trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_binary_trees_page() {
		treePage.getcurrentpageUrl();
		 Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}
//TC37
	@Given("The user is on Tree data Structures Page")
	public void the_user_is_on_tree_data_structures_page() {
		treePage.getcurrentpageUrl();
	}
	@When("The user clicks the  Types of Binary Trees link")
	public void the_user_clicks_the_types_of_binary_trees_link() {
	   treePage.clickTypesofBinaryTreesLink();
	}
	@Then("The user should be redirected to the  Types of Binary Trees data structure page")
	public void the_user_should_be_redirected_to_the_types_of_binary_trees_data_structure_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("types-of-binary-trees/"));
	}
//TC38
	@Given("The user is on the  Types of Binary Trees page")
	public void the_user_is_on_the_types_of_binary_trees_page() {
		treePage.clickTypesofBinaryTreesLink();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("types-of-binary-trees/"));
	}
	@When("The user clicks Try Here button in  Types of Binary Trees page")
	public void the_user_clicks_try_here_button_in_types_of_binary_trees_page() {
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@Then("The user is redirected to a page having Editor with run button for  Types of Binary Trees page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_types_of_binary_trees_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC39
	@Given("The user is on the tryEditor page after clicking Try here button in  Types of Binary Trees link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_types_of_binary_trees_link() {
		treePage.clickTypesofBinaryTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user enters an empty code in editor of  Types of Binary Trees link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_types_of_binary_trees_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}
	@Then("No error message is displayed for Try editor of  Types of Binary Trees page")
	public void no_error_message_is_displayed_for_try_editor_of_types_of_binary_trees_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC40
	@Given("The user is on the tryEditor page clicks Try here button in Types of Binary Trees link")
	public void the_user_is_on_the_try_editor_page_clicks_try_here_button_in_types_of_binary_trees_link() {
		treePage.clickTypesofBinaryTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes invalid code in the editor of Types of Binary Trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_types_of_binary_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }	
	@Then("The user should be able to get alert on Types of Binary Trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_types_of_binary_trees_try_editor_page(){		
		boolean isAlertPresent = tryEditorPage.HandleAlert();
		        assertTrue(isAlertPresent, "No alert displayed");
	}
	
//TC41
	@Given("The user is on tryEditor page along with run button and valid code for Types of Binary Trees page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_types_of_binary_trees_page() {
		treePage.clickTypesofBinaryTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	
	@When("The user writes valid Python code in the editor of Types of Binary Trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_types_of_binary_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }	
	}
	@Then("The user should be able to see output in the console for Types of Binary Trees page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_types_of_binary_trees_page() {
		treePage.codeEditorOutput();
	}
//TC42
	@Given("The user is on  Types of Binary Trees page after signing in")
	public void the_user_is_on_types_of_binary_trees_page_after_signing_in() {
		treePage.clickTypesofBinaryTreesLink();
	}
	@When("The user clicks the Practice Questions link present in  Types of Binary Trees page")
	public void the_user_clicks_the_practice_questions_link_present_in_types_of_binary_trees_page() {
	   treePage.clickPracticeQuestionsLink();
	}
	@Then("The user should be redirected to the Practice Questions page from  Types of Binary Trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_types_of_binary_trees_page() {
		treePage.getcurrentpageUrl();
		 Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC43
	@Given("The user is on the Tree data Structures Page")
	public void the_user_is_on_the_tree_data_structures_page() {
		treePage.getcurrentpageUrl();
	}

	@When("The user clicks the Implementation in Python link")
	public void the_user_clicks_the_implementation_in_python_link() {
	   treePage.clickImplementationinPythonLink();
	}

	@Then("The user should be redirected to the Implementation in Python data structure page")
	public void the_user_should_be_redirected_to_the_implementation_in_python_data_structure_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("implementation-in-python/"));
	}
//TC44
	@Given("The user is on the Implementation in Python page")
	public void the_user_is_on_the_implementation_in_python_page() {
		treePage.clickImplementationinPythonLink();
	}
	@When("The user clicks Try Here button in Implementation in Python page")
	public void the_user_clicks_try_here_button_in_implementation_in_python_page() {
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@Then("The user is redirected to a page having Editor with run button for Implementation in Python page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_implementation_in_python_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC45

	@Given("The user is on the tryEditor page after clicking Try here button in Implementation in Python link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_implementation_in_python_link() {
		treePage.clickImplementationinPythonLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user enters an empty code in editor of Implementation in Python link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_implementation_in_python_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Implementation in Python page")
	public void no_error_message_is_displayed_for_try_editor_of_implementation_in_python_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC46
	@Given("The user is on the tryEditor page and clicks Try here button in Implementation in Python link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_implementation_in_python_link() {
		treePage.clickImplementationinPythonLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes invalid code in the editor of Implementation in Python page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_implementation_in_python_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber){
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }	
	@Then("The user should be able to get alert on Implementation in Python TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_implementation_in_python_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}
	
//TC47
	@Given("The user is on tryEditor page along with run button and valid code for Implementation in Python page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_implementation_in_python_page() {
		treePage.clickImplementationinPythonLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes valid Python code in the editor of Implementation in Python page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_implementation_in_python_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
				try {
		        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
		        	tryEditorPage.clickRunButton();
		        } catch (Exception e) {
		        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
		        }			
	}
	@Then("The user should be able to see output in the console for Implementation in Python page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_implementation_in_python_page() {
		treePage.codeEditorOutput();
	}
	

//TC48
	@Given("The user is on Implementation in Python page after signing in")
	public void the_user_is_on_implementation_in_python_page_after_signing_in() {
		treePage.clickImplementationinPythonLink();
	}
	@When("The user clicks the Practice Questions link present in Implementation in Python page")
	public void the_user_clicks_the_practice_questions_link_present_in_implementation_in_python_page() {
	    treePage.clickPracticeQuestionsLink();
	}
	@Then("The user should be redirected to the Practice Questions page from Implementation in Python page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_implementation_in_python_page() {
		treePage.getcurrentpageUrl();
		 Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}
//TC49
	@Given("The user is on the Tree ds page")
	public void the_user_is_on_the_tree_ds_page() {
		treePage.getcurrentpageUrl();
	}
	@When("The user clicks the Binary Tree Traversals link")
	public void the_user_clicks_the_binary_tree_traversals_link() {
	   treePage.clickBinaryTreeTraversalsLink();
	}
	@Then("The user should be redirected to the Binary Tree Traversals data structure page")
	public void the_user_should_be_redirected_to_the_binary_tree_traversals_data_structure_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("binary-tree-traversals/"));
	}
//TC50
	@Given("The user is on the Binary Tree Traversals page")
	public void the_user_is_on_the_binary_tree_traversals_page() {
		 treePage.clickBinaryTreeTraversalsLink();
	}
	@When("The user clicks Try Here button in Binary Tree Traversals page")
	public void the_user_clicks_try_here_button_in_binary_tree_traversals_page() {
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@Then("The user is redirected to a page having Editor with run button for Binary Tree Traversals page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_binary_tree_traversals_page() {
		treePage.getcurrentpageUrl();
			}
//TC51
	@Given("The user is on the tryEditor page after clicking Try here button in Binary Tree Traversals link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_binary_tree_traversals_link() {
		  treePage.clickBinaryTreeTraversalsLink();	
		  treePage.PageScrollDown();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
			tryHerebutton.click();
	     
	}
	@When("The user enters an empty code in editor of Binary Tree Traversals link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_binary_tree_traversals_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}
	@Then("No error message is displayed for Try editor of Binary Tree Traversals page")
	public void no_error_message_is_displayed_for_try_editor_of_binary_tree_traversals_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC52
	@Given("The user is on the tryEditor page and clicks Try here button in Binary Tree Traversals link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_binary_tree_traversals_link() {
		treePage.clickBinaryTreeTraversalsLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes invalid code in the editor of Binary Tree Traversals page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_binary_tree_traversals_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber)  {
    try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
	@Then("The user should be able to get alert on Binary Tree Traversals TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_binary_tree_traversals_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}
	
//TC53
	@Given("The user is on tryEditor page along with run button and valid code for Binary Tree Traversals page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_binary_tree_traversals_page() {
		treePage.clickBinaryTreeTraversalsLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes valid Python code in the editor of Binary Tree Traversals page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_binary_tree_traversals_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber)  {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	@Then("The user should be able to see output in the console for Binary Tree Traversals page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_binary_tree_traversals_page() {
		treePage.codeEditorOutput();
	}
	
//TC54
	@Given("The user is on Binary Tree Traversals page after signing in")
	public void the_user_is_on_binary_tree_traversals_page_after_signing_in() {
		treePage.clickBinaryTreeTraversalsLink();
	}

	@When("The user clicks the Practice Questions link present in Binary Tree Traversals page")
	public void the_user_clicks_the_practice_questions_link_present_in_binary_tree_traversals_page() {
		treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Binary Tree Traversals page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_binary_tree_traversals_page() {
		treePage.getcurrentpageUrl();
		 Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC55
	@Given("The user is on Tree ds page")
	public void the_user_is_on_tree_ds_page() {
		treePage.getcurrentpageUrl();
	}
	@When("The user clicks the Implementation of Binary Trees link")
	public void the_user_clicks_the_implementation_of_binary_trees_link() {
	   treePage.clickImplementationOfBinaryTreesLink();
	}
	@Then("The user should be redirected to the Implementation of Binary Trees data structure page")
	public void the_user_should_be_redirected_to_the_implementation_of_binary_trees_data_structure_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("implementation-of-binary-trees/"));
	}
//TC56
	@Given("The user is on the Implementation of Binary Trees page")
	public void the_user_is_on_the_implementation_of_binary_trees_page() {
		treePage.clickImplementationOfBinaryTreesLink();
	}
	@When("The user clicks Try Here button in Implementation of Binary Trees page")
	public void the_user_clicks_try_here_button_in_implementation_of_binary_trees_page() {
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@Then("The user is redirected to a page having Editor with run button for Implementation of Binary Trees page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_implementation_of_binary_trees_page() {
		treePage.getcurrentpageUrl();
	}

//TC57
	@Given("The user is on the tryEditor page after clicking Try here button in Implementation of Binary Trees link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_implementation_of_binary_trees_link() {
		treePage.clickImplementationOfBinaryTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user enters an empty code in editor of Implementation of Binary Trees link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_implementation_of_binary_trees_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Implementation of Binary Trees page")
	public void no_error_message_is_displayed_for_try_editor_of_implementation_of_binary_trees_page() {
		treePage.getcurrentpageUrl();
	}
//TC58
	@Given("The user is on the tryEditor page and clicks Try here button in Implementation of Binary Trees link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_implementation_of_binary_trees_link(){
		treePage.clickImplementationOfBinaryTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes invalid code in the editor of Implementation of Binary Trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_implementation_of_binary_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber){
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
	@Then("The user should be able to get alert on Implementation of Binary Trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_implementation_of_binary_trees_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}
	
//TC59
	@Given("The user is on tryEditor page along with run button and valid code for Implementation of Binary Trees page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_implementation_of_binary_trees_page() {
		treePage.clickImplementationOfBinaryTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes valid Python code in the editor of Implementation of Binary Trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_implementation_of_binary_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	@Then("The user should be able to see output in the console for Implementation of Binary Trees page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_implementation_of_binary_trees_page() {
		treePage.codeEditorOutput();
	}
	
//TC60
	@Given("The user is on Implementation of Binary Trees page after signing in")
	public void the_user_is_on_implementation_of_binary_trees_page_after_signing_in() {
		treePage.clickImplementationOfBinaryTreesLink();
	}
	@When("The user clicks the Practice Questions link present in Implementation of Binary Trees page")
	public void the_user_clicks_the_practice_questions_link_present_in_implementation_of_binary_trees_page() {
	    treePage.clickPracticeQuestionsLink();
	}
	@Then("The user should be redirected to the Practice Questions page from Implementation of Binary Trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_implementation_of_binary_trees_page() {
		treePage.getcurrentpageUrl();
		 Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}
//TC61
	@Given("The user is on data structure Tree page")
	public void the_user_is_on_data_structure_tree_page() {
		treePage.getcurrentpageUrl();
	}

	@When("The user clicks the Applications of Binary trees link")
	public void the_user_clicks_the_applications_of_binary_trees_link() {
	    treePage.clickApplicationOfBinarytreesLink();
	}

	@Then("The user should be redirected to the Applications of Binary trees data structure page")
	public void the_user_should_be_redirected_to_the_applications_of_binary_trees_data_structure_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("applications-of-binary-trees/"));
	}
//TC62
	@Given("The user is on the Applications of Binary trees page")
	public void the_user_is_on_the_applications_of_binary_trees_page() {
		  treePage.clickApplicationOfBinarytreesLink();
	}

	@When("The user clicks Try Here button in Applications of Binary trees page")
	public void the_user_clicks_try_here_button_in_applications_of_binary_trees_page() {
		tryEditorPage.clickTryHereButton();
	}

	@Then("The user is redirected to a page having Editor with run button for Applications of Binary trees page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_applications_of_binary_trees_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC63
	@Given("The user is on the tryEditor page after clicking Try here button in Applications of Binary trees link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_applications_of_binary_trees_link() {
		  treePage.clickApplicationOfBinarytreesLink();
		  tryEditorPage.clickTryHereButton();
	}

	@When("The user enters an empty code in editor of Applications of Binary trees link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_applications_of_binary_trees_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Applications of Binary trees page")
	public void no_error_message_is_displayed_for_try_editor_of_applications_of_binary_trees_page() {
		treePage.getcurrentpageUrl();
	}
//TC64
	@Given("The user is on the tryEditor page and clicks Try here button in Applications of Binary trees link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_applications_of_binary_trees_link(){
		treePage.clickApplicationOfBinarytreesLink();
		tryEditorPage.clickTryHereButton();
	}
	@When("The user writes invalid code in the editor of Applications of Binary trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_applications_of_binary_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
	@Then("The user should be able to get alert on  Applications of Binary trees TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_applications_of_binary_trees_try_editor_page(){
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}	

	
//TC65
	@Given("The user is on tryEditor page along with run button and valid code for Applications of Binary trees page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_applications_of_binary_trees_page() {
		treePage.clickApplicationOfBinarytreesLink();
		tryEditorPage.clickTryHereButton();
	}
	@When("The user writes valid Python code in the editor of Applications of Binary trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_applications_of_binary_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	@Then("The user should be able to see output in the console for Applications of Binary trees page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_applications_of_binary_trees_page() {
		treePage.codeEditorOutput();
	}
	
//TC66
	@Given("The user is on Applications of Binary trees page after signing in")
	public void the_user_is_on_applications_of_binary_trees_page_after_signing_in(){
		treePage.clickApplicationOfBinarytreesLink();	
	}
	@When("The user clicks the Practice Questions link present in Applications of Binary trees page")
	public void the_user_clicks_the_practice_questions_link_present_in_applications_of_binary_trees_page() {
	    treePage.clickPracticeQuestionsLink();
	}
	@Then("The user should be redirected to the Practice Questions page from Applications of Binary trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_applications_of_binary_trees_page() {
		treePage.getcurrentpageUrl();
		 Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}
	
//TC67
	@Given("The user is on data structre Tree page")
	public void the_user_is_on_data_structre_tree_page() {
		treePage.getcurrentpageUrl();
	}

	@When("The user clicks the Binary Search Trees link")
	public void the_user_clicks_the_binary_search_trees_link() {
	    treePage.clickBinarySearchTreesLink();
	}

	@Then("The user should be redirected to the Binary Search Trees data structure page")
	public void the_user_should_be_redirected_to_the_binary_search_trees_data_structure_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("binary-search-trees/"));
	}
//TC68
	@Given("The user is on the Binary Search Trees page")
	public void the_user_is_on_the_binary_search_trees_page() {
		treePage.clickBinarySearchTreesLink();
	}

	@When("The user clicks Try Here button in Binary Search Trees page")
	public void the_user_clicks_try_here_button_in_binary_search_trees_page() {
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@Then("The user is redirected to a page having Editor with run button for  Binary Search Trees page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_binary_search_trees_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));
	}
//TC69
	@Given("The user is on the tryEditor page after clicking Try here button in Binary Search Trees link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_binary_search_trees_link() {
		treePage.clickBinarySearchTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}

	@When("The user enters an empty code in editor of Binary Search Trees link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_binary_search_trees_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}

	@Then("No error message is displayed for Try editor of Binary Search Trees page")
	public void no_error_message_is_displayed_for_try_editor_of_binary_search_trees_page() {
		treePage.getcurrentpageUrl();
	}
//TC70
	@Given("The user is on the tryEditor page and clicks Try here button in Binary Search Trees link")
	public void the_user_is_on_the_try_editor_page_and_clicks_try_here_button_in_binary_search_trees_link() {
		treePage.clickBinarySearchTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes invalid code in the editor of Binary Search Trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_binary_search_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}
	
	@Then("The user should be able to get alert on Binary Search Trees TryEditor page")
	public void the_user_should_be_able_get_alert_on_binary_search_trees_try_editor_page() {		
		boolean isAlertPresent = tryEditorPage.HandleAlert();
		        assertTrue(isAlertPresent, "No alert displayed");
	}
//TC71
	@Given("The user is on tryEditor page along with run button and valid code for Binary Search Trees page")
	public void the_user_is_on_try_editor_page_along_with_run_button_and_valid_code_for_binary_search_trees_page() {
		treePage.clickBinarySearchTreesLink();
		treePage.PageScrollDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tryHerebutton = wait.until(ExpectedConditions.elementToBeClickable(tryEditorPage.tryHereButton));
		tryHerebutton.click();
	}
	@When("The user writes valid Python code in the editor of Binary Search Trees page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_binary_search_trees_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
	}

	
	@Then("The user should be able to see output in the console for Binary Search Trees page")
	public void the_user_should_be_able_see_output_in_the_console_for_binary_search_trees_page() {
		treePage.codeEditorOutput();
	}
//TC72
	@Given("The user is on Binary Search Trees page after signing in")
	public void the_user_is_on_binary_search_trees_page_after_signing_in() {
		treePage.clickBinarySearchTreesLink();
	}

	@When("The user clicks the Practice Questions link present in Binary Search Trees page")
	public void the_user_clicks_the_practice_questions_link_present_in_binary_search_trees_page() {
	    treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Binary Search Trees page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_binary_search_trees_page() {
		treePage.getcurrentpageUrl();
		 Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

//TC73
	@Given("The user is on the data structare Tree page")
	public void the_user_is_on_the_data_structre_tree_page() {
		treePage.getcurrentpageUrl();
	}
	@When("The user clicks the Implementation Of BST link")
	public void the_user_clicks_the_implementation_of_bst_link() {
		treePage.clickImplementationofBTSLink();
	}
	@Then("The user should be redirected to the Implementation Of BST data structure page")
	public void the_user_should_be_redirected_to_the_implementation_of_bst_data_structure_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("implementation-of-bst/"));
	}
//TC74
	@Given("The user is on the Implementation Of BST page")
	public void the_user_is_on_the_implementation_of_bst_page() {
		treePage.clickImplementationofBTSLink();
	}
	@When("The user clicks Try Here button in Implementation Of BST page")
	public void the_user_clicks_try_here_button_in_implementation_of_bst_page() {
		tryEditorPage.clickTryHereButton();
	}
	@Then("The user is redirected to a page having Editor with run button for Implementation Of BST page")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_implementation_of_bst_page() {
		treePage.getcurrentpageUrl();
		Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("tryEditor"));		
	}
//TC75
	@Given("The user is on the tryEditor page afterclicking Try here button in Implementation Of BST link")
	public void the_user_is_on_the_try_editor_page_after_clicking_try_here_button_in_implementation_of_bst_link() {
		treePage.clickImplementationofBTSLink();
		tryEditorPage.clickTryHereButton();
	}
	@When("The user enters an empty code in editor of Implementation Of BST link and clicks Run button")
	public void the_user_enters_an_empty_code_in_editor_of_implementation_of_bst_link_and_clicks_run_button() {
		tryEditorPage.clickRunButton();
	}
	@Then("No error message is displayed for Try editor of Implementation Of BST page")
	public void no_error_message_is_displayed_for_try_editor_of_implementation_of_bst_page() {
		treePage.getcurrentpageUrl();
	}
//TC76
	@Given("The user is on the tryEditor page and clicks Try here button in Implementation Of BST link")
	public void the_user_is_on_the_try_editor_page_clicks_try_here_button_in_implementation_of_bst_link() {
		treePage.clickImplementationofBTSLink();
		tryEditorPage.clickTryHereButton();
	}

	@When("The user writes invalid code in the editor of Implementation Of BST page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_invalid_code_in_the_editor_of_implementation_of_bst_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 1);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }

	@Then("The user should be able to get alert on Implementation Of BST TryEditor page")
	public void the_user_should_be_able_to_get_alert_on_implementation_of_bst_try_editor_page() {
		boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
	}
//TC77
	@Given("The user is on tryEditor page along with run button and valid code for Implementation Of BST page")
	public void the_user_is_on_the_try_editor_page_along_with_run_button_and_valid_code_for_implementation_of_bst_page() {
		treePage.clickImplementationofBTSLink();
		tryEditorPage.clickTryHereButton();
	}

	@When("The user writes valid Python code in the editor of Implementation Of BST page and clicks Run button from sheetname {string} and row {int}")
	public void the_user_writes_valid_python_code_in_the_editor_of_implementation_of_bst_page_and_clicks_run_button_from_sheetname_and_row(
			String Sheetname, Integer RowNumber) {
		try {
        	tryEditorPage.enterCodeFromExcel("tryEditorCode", 0);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
			}

	@Then("The user should be able to see output in the console for Implementation Of BST page")
	public void the_user_should_be_able_to_see_output_in_the_console_for_implementation_of_bst_page() {
		treePage.codeEditorOutput();
	}
//TC78
	@Given("The user is on Implementation Of BST page after signing in")
	public void the_user_is_on_implementation_of_bst_page_after_signing_in() {
	    treePage.clickImplementationofBTSLink();
	}

	@When("The user clicks the Practice Questions link present in Implementation Of BST page")
	public void the_user_clicks_the_practice_questions_link_present_in_implementation_of_bst_page() {
	   treePage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to the Practice Questions page from Implementation Of BST page")
	public void the_user_should_be_redirected_to_the_practice_questions_page_from_implementation_of_bst_page() {
		treePage.getcurrentpageUrl();
		 Assert.assertTrue(treePage.getcurrentpageUrl().endsWith("practice"));
	}

	
		
	
	

	
	

	

	
	
	
	
	
	
	



	
}
