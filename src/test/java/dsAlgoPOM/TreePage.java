package dsAlgoPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriversBase;

public class TreePage {

	public WebDriver driver = DriversBase.getDriver();
	// Declares a WebDriver instance that will be used to interact with a web
	// browser.

	WebElement tree_getStarted = driver.findElement(By.xpath("//a[@href='tree']"));

	// Tree Page all links

	WebElement overviewofTrees = driver.findElement(By.xpath("//a[@href='overview-of-trees']"));
	WebElement terminologies = driver.findElement(By.linkText("Terminologies"));
	WebElement typesofTrees = driver.findElement(By.xpath("//a[@href='types-of-trees']"));
	WebElement treeTraversals = driver.findElement(By.xpath("//a[@href='tree-traversals']"));
	WebElement traversalsIllustration = driver.findElement(By.xpath("//a[@href='traversals-illustration']"));
	WebElement binaryTrees = driver.findElement(By.xpath("//a[@href='binary-trees']"));
	WebElement typesofBinaryTrees = driver.findElement(By.xpath("//a[@href='types-of-binary-trees']"));
	WebElement implementationInPython = driver.findElement(By.xpath("//a[@href='implementation-in-python']"));
	WebElement binaryTreeTraversals = driver.findElement(By.xpath("//a[@href='binary-tree-traversals']"));
	WebElement implementationofBinaryTrees = driver.findElement(By.xpath("//a[@href='implementation-of-binary-trees']"));
	WebElement applicationsofBinaryTrees = driver.findElement(By.xpath("//a[@href='applications-of-binary-trees']"));
	WebElement binarySearchTrees = driver.findElement(By.xpath("//a[@href='binary-search-trees']"));
	WebElement implementationOfbst = driver.findElement(By.xpath("//a[@href='implementation-of-bst']"));
	WebElement practiceQuestions = driver.findElement(By.linkText("Practice Questions"));
	WebElement clickTryhere = driver.findElement(By.linkText("Try here>"));

	public void getStartedTree() throws InterruptedException {

		System.out.println("trying to get into tree page");
		tree_getStarted.click();
	}

	public void overviewofTreesLink() throws InterruptedException {
		System.out.println("trying overview of trees");

		// Create WebDriverWait to wait for up to 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Wait until the "Overview of Trees" link is clickable
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(overviewofTrees));

		// Once clickable, click the element
		ele.click();
		System.out.println("clicked");
	}

	public void terminologiesLink() {
		terminologies.click();
	}

	public void typesofTrees() {
		typesofTrees.click();
	}

	public void treeTraversals() {
		treeTraversals.click();
	}

	public void traversalsIllustration() {
		traversalsIllustration.click();
	}

	public void binaryTrees() {
		binaryTrees.click();
	}

	public void typesofBinaryTrees() {
		typesofBinaryTrees.click();
	}

	public void implementationInPython() {
		implementationInPython.click();
	}

	public void binaryTreeTraversals() {
		binaryTreeTraversals.click();
	}

	public void implementationofBinaryTrees() {
		implementationofBinaryTrees.click();
	}

	public void applicationsofBinaryTrees() {
		applicationsofBinaryTrees.click();
	}

	public void binarySearchTrees() {
		binarySearchTrees.click();
	}

	public void implementationOfbst() {
		implementationOfbst.click();
	}

	public void practiceQuestions() {
		practiceQuestions.click();
	}

	public void clickTryhere() {
		clickTryhere.click();
	}
}
