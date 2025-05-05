
package dsAlgoPageObjects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;
import utils.ExcelRead;
import utils.LoggerLoad;

public class SignInPageObj {
	WebDriver driver;
	ExcelRead excelread = new ExcelRead();
	ConfigReader configReader = new ConfigReader(driver);

	@FindBy(name = "username")WebElement UsernameTextBox;
	@FindBy(xpath = "//input[@name ='password']")WebElement PasswordTextBox;
	@FindBy(xpath = "//input[@value='Login']")WebElement loginButton;
	@FindBy(xpath = "/html/body/div[2]")WebElement homePagemsg;
	@FindBy(xpath = "//*[@class='alert alert-primary']")WebElement errorMessage;

	public SignInPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsernameText(String Username) {
		String name = configReader.getUserName();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

		UsernameTextBox.sendKeys(name);
	}

	public void enterPasswordText(String password) {
		String pwd = configReader.getPassword();
		PasswordTextBox.sendKeys(pwd);
	}

	public void clickloginButton() {
		loginButton.click();
	}

	public void homePagemsg() {
		homePagemsg.getText();
		LoggerLoad.info(homePagemsg.getText());
	}

	public void EnterFromExcel(String sheetname, int row) throws IOException {

		List<Map<String, String>> testData;
		testData = excelread.readExcelSheet("/Users/dineshdeshmukh/eclipse-workspace/NinjaGalaxy-Jaanvi-branch/src/test/resources/TestData/TestingData.xlsx", sheetname);

		if (row >= testData.size()) {
			LoggerLoad.info("Row index " + row + " is out of bounds for the sheet: " + sheetname);
			throw new IllegalArgumentException("Invalid row index: " + row);
		}
		Map<String, String> rowData = testData.get(row);
		String Username = rowData.get("Username");
		String Password = rowData.get("Password");
		
		UsernameTextBox.sendKeys(Username);
		PasswordTextBox.sendKeys(Password);
		LoggerLoad.info("Entered data from Excel");

	}

	public void ErrorMessage() {
		String Msg = errorMessage.getText();
		LoggerLoad.info("Error Message is: " + Msg);
	}

	public void TakeScreenshot() throws IOException {
		String scr = "screenshot_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.move(screenshot.toPath(), Path.of(
				"C:\\Users\\onlin\\eclipse-workspace\\DsAlgo_Galaxy\\src\\test\\resources\\Screenshots", scr + ".png"));
		LoggerLoad.info("Screenshot saved: " + scr + ".png");
		LoggerLoad.info("Error Message is displayed");
	}

}
