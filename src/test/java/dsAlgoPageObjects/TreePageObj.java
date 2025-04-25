package dsAlgoPageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverFactory;
import utils.ConfigReader;



public class TreePageObj {
	
	public WebDriver driver = DriverFactory.getDriver();
	String URL = ConfigReader.getUrl();
	String homeURL = ConfigReader.getUrlHome();

	By treegetStartedBtn=By.xpath("//a[@href=\"tree\"]");
	By treetitle=By.xpath("//h4[@class=\"bg-secondary text-white\"]");
	By Overviewoftrees=By.xpath("//a[@href=\"overview-of-trees\"]");
	By Terminologies=By.xpath("//a[@href=\"terminologies\"]");
	By TypesofTrees=By.xpath("//a[@href=\"types-of-trees\"]");
	By TreeTraversals=By.xpath("//a[@href=\"tree-traversals\"]");
	By TraversalsIllustrations=By.xpath("//a[@href=\"traversals-illustration\"]");
	By BinaryTrees =By.xpath("//a[@href=\"binary-trees\"]");
	By TypesofBinaryTrees =By.xpath("//a[@href=\"types-of-binary-trees\"]");
	By ImplementationinPython =By.xpath("//a[@href=\"implementation-in-python\"]");
	By BinaryTreeTraversals =By.xpath("//a[@href=\"binary-tree-traversals\"]");
	By ImplementationOfBinaryTrees=By.xpath("//a[@href=\"implementation-of-binary-trees\"]");
	By ApplicationOfBinarytrees =By.xpath("//a[@href=\"applications-of-binary-trees\"]");
	By BinarySearchTrees =By.xpath("//a[@href=\"binary-search-trees\"]");
	By  ImplementationofBTS =By.xpath("//a[@href=\"implementation-of-bst\"]");
	By title=By.xpath("//p[@class=\"bg-secondary text-white\"]");
	By tryHere=By.xpath("//a[@href=\"/tryEditor\"]");
	By editorbox=By.xpath("//div[@class=\"CodeMirror-scroll\"]");
	By txteditorarea_1 = By.xpath("//form[@id='answer_form']//pre[@class=' CodeMirror-line ']/span/span");
	By run_btn = By.xpath("//button[text()='Run']");
	By consolemsg = By.xpath("//*[@id='output']");
	By Terminologies1=By.xpath("//a[@href=\"/tree/terminologies/\"]");
	By  TypesofTrees1=By.xpath("//a[@href=\"/tree/types-of-trees/\"]");
	By TreeTraversals1=By.xpath("//a[@href=\"/tree/tree-traversals/\"]");
	By TraversalsIllustrations1=By.xpath("//a[@href=\"/tree/traversals-illustration/\"]");
	By BinaryTrees1 =By.xpath("//a[@href=\"/tree/binary-trees/\"]");
	By TypesofBinaryTrees1 =By.xpath("//a[@href=\"/tree/types-of-binary-trees/\"]");
	By ImplementationinPython1=By.xpath("//a[@href=\"/tree/implementation-in-python/\"]");
	By BinaryTreeTraversals1=By.xpath("//a[@href=\"/tree/binary-tree-traversals/\"]");
	By ImplementationOfBinaryTrees1=By.xpath("//a[@href=\"/tree/implementation-of-binary-trees/\"]");
	By ApplicationOfBinarytrees1=By.xpath("//a[@href=\"/tree/applications-of-binary-trees/\"]");
	By BinarySearchTrees1 =By.xpath("//a[@href=\"/tree/binary-search-trees/\"]");
	By  ImplementationofBTS1 =By.xpath("//a[@href=\"/tree/implementation-of-bst/\"]");
	By practicalquestionbtn=By.xpath("//a[@href=\"/tree/practice\"]");
	
	
	public TreePageObj(WebDriver driver) {
		 this.driver=driver;
	}

	public void getpageTitle()
	 {
		 System.out.println(driver.getTitle());	
	 }
	 
	 public void treeclickgetstartedbtn() {
		 driver.findElement(treegetStartedBtn).click();;
	 }
	 
	public void treepagetitle() {
		System.out.println(driver.findElement(treetitle));
	}
	
	public void validatetreelinks() {
		driver.findElement(Overviewoftrees).click();
		driver.navigate().back();
		driver.findElement(Terminologies).click();
		driver.navigate().back();
		driver.findElement(TypesofTrees).click();
		driver.navigate().back();
		driver.findElement(TreeTraversals).click();
		driver.navigate().back();
		driver.findElement(TraversalsIllustrations).click();
		driver.navigate().back();
		driver.findElement(BinaryTrees).click();
		driver.navigate().back();
		driver.findElement(TypesofBinaryTrees).click();
		driver.navigate().back();
		driver.findElement(ImplementationinPython).click();
		driver.navigate().back();
		driver.findElement(BinaryTreeTraversals).click();
		driver.navigate().back();
		driver.findElement(ImplementationOfBinaryTrees).click();
		driver.navigate().back();
		driver.findElement(ApplicationOfBinarytrees).click();
		driver.navigate().back();
		driver.findElement(BinarySearchTrees).click();
		driver.navigate().back();
		driver.findElement(ImplementationofBTS).click();
		driver.navigate().back();
		}
	
}