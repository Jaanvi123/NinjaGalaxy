package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class ArrayStepDefination {

    WebDriver driver;

    @Given("the user is on the DS Algo Portal")
    public void user_is_on_ds_algo_portal() {
        // Initialize the WebDriver (e.g., ChromeDriver)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dsportalapp.herokuapp.com/home");
    }

    @When("the user navigates to the {string} page from the home page")
    public void user_navigates_to_array_page(String Array) {
        // Click on the "Get Started" button for the specified page
        WebElement getStartedButton = driver.findElement(By.xpath("//a[@href='array' and contains(@class, 'btn-primary')]\n"
        		+ "'" + Array + "']/following-sibling::a"));
        getStartedButton.click();
    }

    @Then("the page title should be {string}")
    public void page_title_should_be(String Array) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(Array,actualTitle );
    }

    @When("the user clicks on the {string} link")
    public void user_clicks_on_link(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    @Then("the user should be navigated to the {string} page")
    public void user_should_be_navigated_to_page(String Arraysinpython) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(Arraysinpython, actualTitle);
    }

    @Given("the user is on the {string} page")
    public void user_is_on_page(String pageTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, actualTitle);
    }

    @When("the user clicks on the {string} Link")
    public void user_clicks_on_link_capitalized(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    @Then("the user should be redirected to the editor page")
    public void user_should_be_redirected_to_editor_page() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Editor", actualTitle);
    }

    @Given("the user is on the Try Editor page")
    public void user_is_on_try_editor_page() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Editor", actualTitle);
    }

    @When("the user enters valid Python code and clicks on the Run button")
    public void user_enters_valid_python_code_and_runs() {
        WebElement codeEditor = driver.findElement(By.id("codeEditor"));
        codeEditor.sendKeys("print('Array test successful')");
        WebElement runButton = driver.findElement(By.id("runButton"));
        runButton.click();
    }

    @Then("the output should display {string}")
    public void output_should_display(String expectedOutput) {
        WebElement outputElement = driver.findElement(By.id("output"));
        String actualOutput = outputElement.getText();
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Then("the user should be on the {string} page")
    public void user_should_be_on_page(String expectedPageTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle, actualTitle);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
