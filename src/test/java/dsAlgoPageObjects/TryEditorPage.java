package dsAlgoPageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverFactory;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import utils.ExcelRead;
import utils.LoggerLoad;

public class TryEditorPage {
	WebDriver driver;

    @FindBy(xpath = "//a[@href='/tryEditor']") 
    public WebElement tryHereButton;

    @FindBy(xpath = "//textarea[@tabindex='0']") 
    WebElement textAreaForCode;

    @FindBy(xpath = "//button[text()='Run']") 
    WebElement runButton;

    @FindBy(xpath = "//*[@id='answer_form']/div/div/div[6]") 
    WebElement CodeEditor;

    @FindBy(xpath = "//pre[@id='output']") 
    WebElement consoleOutputMsg;

    @FindBy(xpath = "//pre[@id='output']") 
    WebElement CodeEditorOutput;

    public TryEditorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
 
    public void clickRunButton() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(runButton));
        
        runButton.click();
        LoggerLoad.info("Clicked the Run button.");
    }

	public void clickTryHereButton() {
	
		Actions act = new Actions(driver);
		act.moveToElement(tryHereButton).click().perform();
		LoggerLoad.info("Clicked the Try Here button.");
	}



	public void enterCodeFromExcel(String sheetName, int row)
			throws InvalidFormatException, IOException, OpenXML4JException {
		ExcelRead excelread = new ExcelRead();
		LoggerLoad.info("Reading code from Excel sheet: " + sheetName + ", Row: " + row);

		List<Map<String, String>> testData =excelread.readExcelSheet( sheetName);

		String editorCode = "";
		if (row <= testData.size()) {
			editorCode = testData.get(row).get("editorCode");
			LoggerLoad.info("Editor Code is -->" + editorCode);
		} else {
			throw new IllegalArgumentException("Row index out of bounds.");
		}
		
	}

	public boolean HandleAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			LoggerLoad.info("Alert present: " + alert.getText());
			alert.accept();
			return true;
		} catch (NoAlertPresentException e) {
			LoggerLoad.info("No alert present.");
			return false;
		}
	}

	public String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			LoggerLoad.warn("No alert was present to get text from.");
			return null;
		}
	}

	public String getOutputText() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement output = wait.until(ExpectedConditions.visibilityOf(consoleOutputMsg));
			String consoleOutput = output.getText();
			LoggerLoad.info("Console output: " + consoleOutput);
			return consoleOutput;
		} catch (Exception e) {
			LoggerLoad.error("Error fetching console output: " + e.getMessage());
			return "";
		}
	}

	public void PageScrolldown() {
		PageFactory.initElements(driver, this);

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, 1000);");

	}

	public void CodeEditorOutput() {
		CodeEditorOutput.getText();
		LoggerLoad.info("Code editor Output is :" + CodeEditorOutput.getText());
	}
}
