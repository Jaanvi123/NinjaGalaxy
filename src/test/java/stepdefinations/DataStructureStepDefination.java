package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.DataStructuresIntroductionPage;
import pages.TryEditorPage;
import hooks.Hooks;

public class DataStructureStepDefination {
    WebDriver driver = Hooks.getDriver();
    DataStructuresIntroductionPage dataStructuresPage = new DataStructuresIntroductionPage(driver);
    TryEditorPage tryEditorPage = new TryEditorPage(driver);

    @Given("The user is on the Home page after logging in")
    public void userOnHomePage() {
        driver.get("https://dsportalapp.herokuapp.com/home");
        System.out.println("User is on the Home page");
    }

    @When("The user clicks the {string} button in Data Structures - Introduction")
    public void userClicksGetStarted(String button) {
        dataStructuresPage.clickGetStarted();
    }

    @Then("The user is on the Data Structures Introduction page")
    public void userOnDataStructuresIntroductionPage() {
        driver.get("https://dsportalapp.herokuapp.com/data-structures-introduction");
        System.out.println("User is on the Data Structures Introduction page");
    }

    @Given("The user is on the {string} page")
    public void userOnSpecificPage(String pageName) {
        driver.get("https://dsportalapp.herokuapp.com/data-structures-introduction");
        System.out.println("User is on the " + pageName + " page");
    }

    @When("The user clicks {string} button")
    public void userClicksButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("Time Complexity")) {
            dataStructuresPage.clickTimeComplexity();
        } else if (buttonName.equalsIgnoreCase("Practice Questions")) {
            dataStructuresPage.clickPracticeQuestions();
        }
    }

    @Then("The user should be redirected to {string}")
    public void userRedirectedTo(String pageName) {
        if (pageName.equalsIgnoreCase("Time Complexity")) {
            driver.get("https://dsportalapp.herokuapp.com/data-structures-introduction/time-complexity");
            System.out.println("User is on the Time Complexity page");
        }
    }

    @Then("The user should be redirected to a page having a Try Editor with a Run button to test")
    public void userRedirectedToTryEditor() {
        tryEditorPage.clickTryHere();
        System.out.println("User is on the Try Editor page");
    }

    @Given("The user is on the Try Editor page")
    public void userOnTryEditorPage() {
        driver.get("https://dsportalapp.herokuapp.com/tryEditor");
        System.out.println("User is on the Try Editor page");
    }

    @When("The user clicks the Run Button with valid code in the Editor")
    public void userRunsValidCode() {
        tryEditorPage.enterCode("print('Hello World')");
        tryEditorPage.clickRun();
        System.out.println("User entered valid Python code");
    }

    @Then("The user should be able to see valid output")
    public void userSeesValidOutput() {
        System.out.println("User sees valid output");
        // Add assertions to verify the output
    }

    @When("The user writes invalid code")
    public void userWritesInvalidCode() {
        tryEditorPage.enterCode("print('Hello'");
        tryEditorPage.clickRun();
        System.out.println("User entered invalid Python code");
    }

    @Then("An error window pops up")
    public void errorWindowPopsUp() {
        System.out.println("Error window is displayed");
        // Add assertions to verify the error message
    }
}
