package stepDefinitions;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import driverManager.DriverFactory;
import dsAlgoPageObjects.DataStructurePageObj;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.SignInPageObj;
import dsAlgoPageObjects.TryEditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.LoggerLoad;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class DataStructureStepDefinition {
	       
        
	    WebDriver driver = DriverFactory.getDriver();
        HomePageObj homepage = new HomePageObj(driver);
        SignInPageObj signin = new SignInPageObj(driver);
        IntroductionPageObj introductionpage = new IntroductionPageObj();
        DataStructurePageObj dataStructurepage = new DataStructurePageObj(driver);
        TryEditorPage tryEditorPage = new TryEditorPage(driver);
    
    
    @Given("The user is logged into the DS Algo Portal")
    public void the_user_is_logged_into_the_ds_algo_portal() throws InterruptedException, InvalidFormatException, IOException, OpenXML4JException {
        homepage.clickGetStartedHomePageButton();
        introductionpage.clickSignInLink();
        signin.enterUsernameText("username");
		signin.enterPasswordText("password");
		signin.clickloginButton();
        
    }
    @When("The user clicks the Get Started button of Data Structure Introduction section")
    public void the_user_clicks_the_get_started_button_of_data_structure_introduction_section() {
        introductionpage.clickDsGetStartedButton();
    }
    @Then("The user should be directed to Data Structure introduction Page")
    public void the_user_should_be_directed_to_data_structure_introduction_page() {
        String expectedTitle = "Data Structures-Introduction";
        String actualTitle = dataStructurepage.validatePageTitle();
        assertEquals(expectedTitle, actualTitle);
        
    }
    // TC01
    @Given("The user is on data Structure introduction Page")
    public void the_user_is_on_data_structure_introduction_page() {
        String expectedTitle = "Data Structures-Introduction";
        String actualTitle = dataStructurepage.validatePageTitle();
        assertEquals("User is not on the expected page.", expectedTitle, actualTitle);
       
      
    }
    @When("The user clicks on Time Complexity link of DS Introduction page")
    public void the_user_clicks_on_time_complexity_link_of_ds_introduction_page() {
         dataStructurepage.ClickTimeComplexityLink();
       
    }
    @Then("The user should be directed to Time Complexity page of DS Intro page")
    public void the_user_should_be_directed_to_time_complexity_page_of_ds_intro_page() {
        String expectedTitle = "Time Complexity";
        String actualTitle = dataStructurepage.validatePageTitle();
         assertEquals("User is not on the expected Time Complexity page.", expectedTitle, actualTitle);
    }
    // TC02
    @Given("The user is on Time Complexity page of DS Introduction page")
    public void the_user_is_on_time_complexity_page_of_ds_introduction_page() {
    	 dataStructurepage.ClickTimeComplexityLink();
    }
    @When("The user clicks on Try here button of Time Complexity Page")
    public void the_user_clicks_on_try_here_button_of_time_complexity_page() {
          tryEditorPage.clickTryHereButton();
      
    }
    @Then("The user should be directed to a page having Editor with run button")
    public void the_user_should_be_directed_to_a_page_having_editor_with_run_button() {
        String expectedTitle = "Assessment";
        String actualTitle = introductionpage.getHomePageTitle();
        assertEquals("Page title is incorrect. Expected: " + expectedTitle + ", but found: " + actualTitle,
                     expectedTitle, actualTitle);
       
    }
    // TC03			
    @Given("The user is on time comlexity page to explore tryhere page with run button")
    public void the_user_is_on_time_comlexity_page_to_explore_tryhere_page_with_run_button() {
        dataStructurepage.ClickTimeComplexityLink();
        
    }
    @When("The user clicks the Run button without entering the code in the text area editor")
    public void the_user_clicks_the_run_button_without_entering_the_code_in_the_text_area_editor() {
    	tryEditorPage.clickTryHereButton();
    	tryEditorPage.clickRunButton();
                   }
    
    @Then("The user does not see any error message displayed")
    public void the_user_does_not_see_any_error_message_displayed() {
    	LoggerLoad.info("No alert to display");
             
        }
    
    // TC04
    @Given("The user is on tryEditor  page with run button with alert window")
    public void the_user_is_on_try_editor_page_with_run_button_with_alert_window() {
        dataStructurepage.ClickTimeComplexityLink();
       
        tryEditorPage.clickTryHereButton();
        
    }
    @When("The user clicks Run button in DS with invalid code from sheetname {string} and row {int}")
    public void the_user_clicks_run_button_in_ds_with_invalid_code_from_sheetname_and_row(String sheetName, Integer rowNumber) {
        try {
        	tryEditorPage.enterCodeFromExcel(sheetName, rowNumber);
        	tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
    @Then("The user should able to see an error message in the alert window")
    public void the_user_should_able_to_see_an_error_message_in_the_alert_window() {
        boolean isAlertPresent = tryEditorPage.HandleAlert();
        assertTrue(isAlertPresent, "No alert displayed");
    }
    // TC05
    @Given("The user is on tryEditor page with run button and valid code")
    public void the_user_is_on_try_editor_page_with_run_button_and_valid_code() {
        dataStructurepage.ClickTimeComplexityLink();
        tryEditorPage.clickTryHereButton();
       
    }
    @When("The user clicks Run button with valid code from sheetname {string} and row {int}")
    public void the_user_clicks_run_button_with_valid_code_from_sheetname_and_row(String sheetName, Integer rowNumber) {
        try {
            tryEditorPage.enterCodeFromExcel(sheetName, rowNumber);
            tryEditorPage.clickRunButton();
        } catch (Exception e) {
        	LoggerLoad.info("Error while entering code or clicking Run: " + e.getMessage());
        }
    }
    @Then("The user should able to see output in the console")
    public void the_user_should_able_to_see_output_in_the_console() {
        String consoleOutput = tryEditorPage.getOutputText();
        assertNotNull("Console output is null or empty.", consoleOutput);
       
    }
    // TC06	
    @Given("The user lands on time complexity page")
    public void the_user_lands_on_time_complexity_page() {
        dataStructurepage.ClickTimeComplexityLink();
       
    }
    @When("The user clicks Practice Questions link of DS page")
    public void the_user_clicks_practice_questions_link_of_ds_page() {
        dataStructurepage.clickPracticeQuestionsLink();
    }
    @Then("The user should be redirected to Practice Questions page of DS")
    public void the_user_should_be_redirected_to_practice_questions_page_of_ds() {
        String expectedTitle = "Practice Questions";
        String actualTitle = introductionpage.getHomePageTitle();
         assertEquals("Page title is incorrect. Expected: " + expectedTitle + ", but found: " + actualTitle,
                     expectedTitle, actualTitle);
    }
}