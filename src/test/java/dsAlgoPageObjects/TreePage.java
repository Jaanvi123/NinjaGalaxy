package dsAlgoPageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TreePage {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	WebElement txtarea;
	Alert alert ;
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
	
	
	public TreePage(WebDriver driver) {
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
	
	public void overviewclickbtn() {
	driver.findElement(Overviewoftrees).click();
	//System.out.println((driver.findElements(title)).get(1).getText().contains("Overview of Trees"));
	}
	
	public void tryHerebtn() {
		driver.findElement(tryHere).click();
	}
	public String getcurrentpage1()
	{
		System.out.println(driver.getCurrentUrl());
		return(driver.getCurrentUrl());
	}
	
	public void validateTextEditorBox(String text) {
		txtarea = driver.switchTo().activeElement();
		Actions actions = new Actions(driver);
		actions.moveToElement(txtarea).click().perform();
		txtarea.sendKeys(text);		
		}
	public void clickrun()
	{
		driver.findElement(run_btn).click();	
	}
	
	public String alertpopup() {
		 alert = driver.switchTo().alert();
		 System.out.println(alert.getText());
		return alert.getText();
	}
	public void acceptalert()
	{
		alert.accept();
	}
	public void cleartextarea()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(txtarea).click().perform();
	//	CommonLibraries.TextIndentation(driver, txtarea, 0,0 , false);
		txtarea.sendKeys(Keys.CONTROL + "a");
		txtarea.sendKeys(Keys.DELETE);
	
	}
	public void validatetexteditor1(String text) throws InterruptedException
	{
		Thread.sleep(1000);
		 txtarea = driver.switchTo().activeElement();
		Actions actions = new Actions(driver);
		actions.moveToElement(txtarea).click().perform();
		txtarea.sendKeys(text);
					
	}
	public String getconsolemsg()
	{
		return(driver.findElement(consolemsg).getText());
	}
	public void navigateback()
	{
		driver.navigate().back();
	}
		public void terminologiesBtn() {
	driver.findElement(Terminologies1).click();
	}
	public void typeoftreebtn() {
		driver.findElement(TypesofTrees1).click();
	}
	public void treetraversalbtn() {
		driver.findElement(TreeTraversals1).click();
	}
	public void traversalillustrationbtn() {
		driver.findElement(TreeTraversals1).click();
		}
	public void binarytreebtn() {
		driver.findElement(BinaryTrees1).click();
	}
	public void typesofbinarybtn() {
		driver.findElement(TypesofBinaryTrees1).click();
	}
	public void implementationinpythonbtn() {
		driver.findElement(ImplementationinPython1).click();
	}
	public void binarytreetraversalbtn() {
		driver.findElement(BinaryTreeTraversals1).click();
	}
	public void implementationofbinarybtn() {
		driver.findElement(ImplementationOfBinaryTrees1).click();
	}
	public void applicationofbinarytreebtn() {
		driver.findElement(ApplicationOfBinarytrees1).click();
	}
	public void binarysearchtreebtn() {
		driver.findElement(BinarySearchTrees1).click();
	}
	public void implementationofbtsBtn() {
		driver.findElement(ImplementationofBTS1).click();
	}
	public void practicebtn() {
		driver.findElement(practicalquestionbtn).click();
	}
	
	
}