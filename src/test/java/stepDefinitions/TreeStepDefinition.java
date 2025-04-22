package stepDefinitions;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverManager.DriverFactory;
import dsAlgoPageObjects.HomePageObj;
import dsAlgoPageObjects.IntroductionPageObj;
import dsAlgoPageObjects.LoginPageObj;
import dsAlgoPageObjects.TreePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExcelRead;

public class TreeStepDefinition  {
	 WebDriver driver; 
	
		public  LoginPageObj login= new  LoginPageObj(driver);
		HomePageObj homepage = new HomePageObj();
		IntroductionPageObj datastructure = new IntroductionPageObj();
	
	TreePage treepage=new TreePage(driver);
	@Given("USER is on Dalgo homepage  and verify the page title")
	public void user_is_on_dalgo_homepage_and_verify_the_page_title_row_number() {
	    treepage.getpageTitle();
	   
	}
  
	@When("The user clicks  Get Started button below the treeList and verify pagetitle")
	public void the_user_clicks_get_started_button_below_the_tree_list_and_verify_pagetitle() {
	    treepage.treeclickgetstartedbtn();
	    treepage.treepagetitle();
	}

	@Then("validate treePage links")
	public void validate_tree_page_links(io.cucumber.datatable.DataTable dataTable) {
	   treepage.validatetreelinks();
	}

	@Given("User is on Overview of trees page and verify the pagetitle")
	public void user_is_on_overview_of_trees_page_and_verify_the_pagetitle() {
	    treepage.overviewclickbtn();
	    
	}

	@When("The user clicks Try Here button of Overview of trees  Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_overview_of_trees_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {
		 treepage.tryHerebtn();
		    String actualpageurl = treepage.getcurrentpage1();
			Assert.assertEquals(actualpageurl, expectedurl);
	}

	@When("^THE  user is on python editor and User write the invalid code in Editor (.*) and (.*) and click run button and the user should able to see an (.*) in alert window$")
	public void the_user_is_on_python_editor_and_user_write_the_invalid_code_in_editor_row_number_and_sheet_name_and_click_run_button_and_the_user_should_able_to_see_an_message_in_alert_window(int rowNumber, String sheetName, String expectedpopupmsg) throws IOException{
		ExcelRead reader = new ExcelRead();
	/*	List<Map<String,String>> excelData = reader.readExcelSheetFortexteditor(sheetName);
		String invalidtext = excelData.get(rowNumber).get("invalid_text");
		
		String validtext = excelData.get(rowNumber).get("valid_text");
		
		System.out.println("invalidtext is "+ invalidtext);		
		treepage.validateTextEditorBox(invalidtext);
		treepage.clickrun();
		String actualpopupmsg = treepage.alertpopup();
		System.out.println(actualpopupmsg);
		Assert.assertEquals(actualpopupmsg, expectedpopupmsg);
	     treepage.acceptalert();
	     treepage.cleartextarea();  */
	}
	

	@Then("^The USER write the valid code in Editor (.*) and (.*) and click run button and the user should able to see output in the console$")
	public void the_user_write_the_valid_code_in_editor_row_number_and_sheet_name_and_click_run_button_and_the_user_should_able_to_see_output_in_the_console(int rowNumber,String SheetName) throws IOException, InterruptedException {
		ExcelRead reader = new ExcelRead();
	/*	List<Map<String,String>> excelData = reader.readExcelSheetFortexteditor(SheetName);
		String validtext = excelData.get(rowNumber).get("valid_text");
		System.out.println("validtext is "+ validtext);		
		treepage.validatetexteditor1(validtext);
		treepage.clickrun();
	
		String actualconsolemsg = treepage.getconsolemsg();
		System.out.println("console msg:" + actualconsolemsg);
		treepage.navigateback();  */
	}

   @Given("User is on Terminologies page and verify the pagetitle")
	public void user_is_on_terminologies_page_and_verify_the_pagetitle() {
	    treepage.terminologiesBtn();
	}

  @ When ("The user clicks Try Here button of Terminologies  Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_terminologies_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {		
	treepage.tryHerebtn();

    String actualpageurl = treepage.getcurrentpage1();
		Assert.assertEquals(actualpageurl, expectedurl);
	}

	@Given("User is on Types of Trees page and verify the pagetitle")
public void user_is_on_types_of_trees_page_and_verify_the_pagetitle() {
  treepage.typeoftreebtn();
}

	@When("The user clicks Try Here button of Types of Trees Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_types_of_trees_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {
		treepage.tryHerebtn();
    String actualpageurl = treepage.getcurrentpage1();
	Assert.assertEquals(actualpageurl, expectedurl);
	}

	@Given("User is on Tree Traversalss page and verify the pagetitle")
	public void user_is_on_tree_traversalss_page_and_verify_the_pagetitle() {
	  treepage.treetraversalbtn();
	}

	@When("The user clicks Try Here button of Tree Traversals  Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_tree_traversals_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {
		treepage.tryHerebtn();
	    String actualpageurl = treepage.getcurrentpage1();
		Assert.assertEquals(actualpageurl, expectedurl);	}

	@Given("User is on Traversals Illustrations page and verify the pagetitle")
	public void user_is_on_traversals_illustrations_page_and_verify_the_pagetitle() {
	   treepage.traversalillustrationbtn();
	}

	@When("The user clicks Try Here button of Traversals Illustrations  Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_traversals_illustrations_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {
		treepage.tryHerebtn();
	    String actualpageurl = treepage.getcurrentpage1();
		Assert.assertEquals(actualpageurl, expectedurl);
	}

	@Given("User is on Binary Trees page and verify the pagetitle")
	public void user_is_on_binary_trees_page_and_verify_the_pagetitle() {
		treepage.binarytreebtn();
	  	}

	@When("The user clicks Try Here button of Binary Trees Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_binary_trees_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {
		treepage.tryHerebtn();
	    String actualpageurl = treepage.getcurrentpage1();
		Assert.assertEquals(actualpageurl, expectedurl);
	}

	@Given("User is on Types of Binary Trees page and verify the pagetitle")
	public void user_is_on_types_of_binary_trees_page_and_verify_the_pagetitle() {
	   treepage.typesofbinarybtn();
	}

	@When("The user clicks Try Here button of Types of Binary Trees  Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_types_of_binary_trees_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {
		treepage.tryHerebtn();
	    String actualpageurl = treepage.getcurrentpage1();
		Assert.assertEquals(actualpageurl, expectedurl);
	}

	@Given("User is on Implementation in Python page and verify the pagetitle")
	public void user_is_on_implementation_in_python_page_and_verify_the_pagetitle() {
	    treepage.implementationinpythonbtn();
	}

	@When("The user clicks Try Here button of Implementation in Python Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_implementation_in_python_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {
		treepage.tryHerebtn();
	    String actualpageurl = treepage.getcurrentpage1();
		Assert.assertEquals(actualpageurl, expectedurl);
	}

	@Given("User is on Binary Tree Traversals page and verify the pagetitle")
	public void user_is_on_binary_tree_traversals_page_and_verify_the_pagetitle() {
	    treepage.binarytreetraversalbtn();
	}

	@When("The user clicks Try Here button of Binary Tree Traversals  Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_binary_tree_traversals_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {
		treepage.tryHerebtn();
	    String actualpageurl = treepage.getcurrentpage1();
		Assert.assertEquals(actualpageurl, expectedurl);	}

	@Given("User is on Implementation Of Binary Trees page and verify the pagetitle")
	public void user_is_on_implementation_of_binary_trees_page_and_verify_the_pagetitle() {
	    treepage.implementationofbinarybtn();
	}

	@When("The user clicks Try Here button of Implementation Of Binary Trees Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_implementation_of_binary_trees_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {
		treepage.tryHerebtn();
	    String actualpageurl = treepage.getcurrentpage1();
		Assert.assertEquals(actualpageurl, expectedurl);
	}

	@Given("User is on Application Of Binary trees page and verify the pagetitle")
	public void user_is_on_application_of_binary_trees_page_and_verify_the_pagetitle() {
	    treepage.applicationofbinarytreebtn();
	}

	@When("The user clicks Try Here button of Application Of Binary trees  Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_application_of_binary_trees_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {
		treepage.tryHerebtn();
	    String actualpageurl = treepage.getcurrentpage1();
		Assert.assertEquals(actualpageurl, expectedurl);
	}

	@Given("User is on  Implementation of BTS  page and verify the pagetitle")
	public void user_is_on_implementation_of_bts_page_and_verify_the_pagetitle() {
	    treepage.implementationofbtsBtn();
	}

	@When("The user clicks Try Here button of  Implementation of BTS Page and the user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_clicks_try_here_button_of_implementation_of_bts_page_and_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String expectedurl) {
		treepage.tryHerebtn();
	    String actualpageurl = treepage.getcurrentpage1();
		Assert.assertEquals(actualpageurl, expectedurl);
	}
	
	 @ Given ("USER is on Types Of PractionQuestion page and verify the url{string}")
	 public void practicemethod(String expectedurl) {
		 treepage.practicebtn();

		 String actualpageurl = treepage.getcurrentpage1();
		 System.out.println(expectedurl);
		 System.out.println(actualpageurl);
			Assert.assertEquals(actualpageurl, expectedurl);
	 }
}


	
