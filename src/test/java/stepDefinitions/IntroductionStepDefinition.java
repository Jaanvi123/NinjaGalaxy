package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driverManager.DriversBase;
import dsAlgoPageObjects.IntroductionPageObj;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExcelRead;

public class IntroductionStepDefinition extends DriversBase {

	IntroductionPageObj datastructurepage = new IntroductionPageObj();

	// Logger logger =(Logger) LogManager.getLogger("");
	@Given("User is on the {string} homepage")
	public void user_is_on_the_homepage(String expectedhomepagetitle) {
		String homepagetitle = datastructurepage.getHomePageTitle();
		System.out.println(homepagetitle);
		Assert.assertEquals(homepagetitle, expectedhomepagetitle);
	}

	@When("User clicks on Data Structures dropdown")
	public void user_clicks_on_data_structures_dropdown() {
		// datastructurepage.drpdownClick();
	}

	/*
	 * @Then("Data Structures dropdown should be displayed with the list of <options>"
	 * ) public void
	 * data_structures_dropdown_should_be_displayed_with_the_list_of_options(
	 * DataTable data) { // System.out.println("hello"); List<String> options =
	 * data.asList(); String expecteddropitems = options.toString();
	 * //System.out.println();
	 * 
	 * }
	 */
	@Then("User clicks on get started button on the data structures pane")
	public void User_clicks_on_get_started_button_on_the_data_structures_pane() {

		datastructurepage.click_ds_getstarted();
	}

	@Given("User is on the {string}")
	public void user_is_on_the_data_structures_introduction_page(String expectedpagename) {
		String actualpagename = datastructurepage.datastructurepagename();
		System.out.println(actualpagename);
		Assert.assertEquals(actualpagename, expectedpagename);
	}

	@When("User clicks on Time Complexity link")
	public void user_clicks_on_Time_Complexity_link() {
		datastructurepage.clicktimecomplexity();
	}

	@Then("User should be navigated to {string} page")
	public void user_should_be_navigated_to_page(String expectedpageurl) {
		String actualpageurl = datastructurepage.getcurrentpage();
		Assert.assertEquals(actualpageurl, expectedpageurl);
	}

	@Then("User clicks on Try here button")
	public void user_clicks_on_button() {
		datastructurepage.clicktryhere();
	}

	@Given("User is on the text editor screen {string}")
	public void user_is_on_the_text_editor_screen(String expectedpageurl) {
		String actualpageurl = datastructurepage.getcurrentpage();
		Assert.assertEquals(actualpageurl, expectedpageurl);
	}

	@When("^User enters some text in the incorrect format (.+) in the text editor from the excel sheet (.+)$")
	public void user_enters_text_in_the_text_editor(int rowNumber, String SheetName) throws IOException {
		ExcelRead reader = new ExcelRead();
		// List<Map<String,String>> excelData =
		// reader.readExcelSheetFortexteditor(SheetName);
		// String invalidtext = excelData.get(rowNumber).get("invalid_text");
		// System.out.println("invalidtext is "+ invalidtext);
		// datastructurepage.validatetexteditor(invalidtext);
	}

	@When("User clicks on Run button")
	public void user_clicks_on_run_button() {
		datastructurepage.clickrun();
	}

	@Then("A pop up window should be displayed with entered text being displayed in the popup message")
	public void a_pop_up_window_should_be_displayed_with_entered_text_being_displayed_in_the_popup_message(
			String expectedpopupmsg) {
		String actualpopupmsg = datastructurepage.alertpopup();
		System.out.println(actualpopupmsg);
		Assert.assertEquals(actualpopupmsg, expectedpopupmsg);
	}

	@Then("User clicks on OK button in the popup")
	public void user_clicks_on_ok_button_in_the_popup() {
		datastructurepage.acceptalert();
	}

	@Then("User clears the text editor screen")
	public void user_clears_the_text_editor_screen() {
		datastructurepage.cleartextarea();
	}

	@Then("^User enters text in the correct format (.*) in the text editor from the excel sheet (.*)$")
	public void user_enters_text_in_the_correct_formt_in_the_text_editor(int rowNumber, String SheetName)
			throws InterruptedException, IOException {
		ExcelRead reader = new ExcelRead();
		// List<Map<String,String>> excelData =
		// reader.readExcelSheetFortexteditor(SheetName);
		// String validtext = excelData.get(rowNumber).get("valid_text");
		// System.out.println("validtext is "+ validtext);
		// datastructurepage.validatetexteditor1(validtext);
	}

	@Then("The valid text entered in the python text editor should be printed in the console")
	public void the_valid_text_entered_in_the_python_text_editor_should_be_printed_in_the_console() throws IOException {
		String actualconsolemsg = datastructurepage.getconsolemsg();
		System.out.println("console msg:" + actualconsolemsg);
	}

	@Then("User navigates back to the {string}")
	public void user_navigates_back_to_the(String string) {
		datastructurepage.navigateback();
	}

	@Then("User clicks on Practice Questions link")
	public void User_clicks_on_Practice_Questions_link() {
		datastructurepage.clickpracticequestions();

	}

	@Then("Practice Questions page should be displayed with the url {string}")
	public void practice_questions_page_should_be_displayed_with_the_url(String expectedurl) {
		String actualurl = datastructurepage.getcurrentpage();
		System.out.println(actualurl);
		Assert.assertEquals(actualurl, expectedurl);
	}

}
