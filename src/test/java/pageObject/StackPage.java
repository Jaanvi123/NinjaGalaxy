package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StackPage 
{
	WebDriver driver;
	public StackPage(WebDriver d) {

		this.driver = d;
		PageFactory.initElements(d, this);
		
	    }
	
	
	@FindBy(xpath="//h5[contains(text(), 'Stack')]/following::a[1]")WebElement butnStackGetStart;
	@FindBy(linkText="Operations in Stack")WebElement linktxt1;
    @FindBy(xpath="//div[@id='content']/li[2]/a")WebElement linktxt2;
    @FindBy(xpath="//div[@id='content']/li[3]/a")WebElement linktxt3;
	@FindBy(xpath="//div[2]/div/div[2]/a")WebElement btntryhere;
    @FindBy(xpath="//form[@id='answer_form']/div/div/div[1]/textarea")WebElement stacktxtarea;
	@FindBy(xpath="//button[contains(text(),'Run')]")WebElement btnrun;
	@FindBy(xpath="//div[@id='navbarCollapse']/div[1]/div/a")WebElement dsMenu;
	@FindBy(xpath="//div[@id='navbarCollapse']/div[1]/div/div/a[4]")WebElement selectQueue;
	
	
    public void clickStackGetStartButn() {
		butnStackGetStart.click();
	}
	public void clickOSLinkTxt() {
		linktxt1.click();
	}
    public void clickImpLinkTxt() {
		linktxt2.click();
	}
    public void clickAppLinkTxt() {
		linktxt3.click();
	}
	public void clickStackTryHereBtn() {
	    btntryhere.click();
	}
	public void setCode(String code) {
		stacktxtarea.sendKeys(code);
	}
	public void clickRunBtn() {
		btnrun.click();
	}
	public void navigation() {
		dsMenu.click();
		selectQueue.click();
	}
}

