package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GraphPage
{
	WebDriver driver;
	public GraphPage(WebDriver d) {

		this.driver = d;
		PageFactory.initElements(d, this);
		
	    }
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")WebElement btnSignin;
	@FindBy(name="username")WebElement txtUserName;
	@FindBy(name="password")WebElement txtpassword;
	@FindBy(xpath="//input[@type='submit']")WebElement btnLogin;
	@FindBy(xpath="//h5[contains(text(), 'Graph')]/following::a[1]")WebElement butnGraphGetStart;
	@FindBy(linkText="Graph")WebElement linktxt1;
    @FindBy(xpath="//div[@id='content']/li[2]/a")WebElement linktxt2;
    @FindBy(xpath="//div[2]/div/div[2]/a")WebElement btntryhere;
    @FindBy(xpath="//form[@id='answer_form']/div/div/div[1]/textarea")WebElement graphtxtarea;
	@FindBy(xpath="//button[contains(text(),'Run')]")WebElement btnrun;
	@FindBy(xpath="//div[@id='navbarCollapse']/div[1]/div/a")WebElement dsMenu;
	@FindBy(xpath="//div[@id='navbarCollapse']/div[1]/div/div/a[3]")WebElement selectStack;
	
	public void clickBtnSignin() {
		btnSignin.click();
	}
	public void clickBtnLogin() {
		btnLogin.click();
		}
    public void clickGraphGetStartButn() {
		butnGraphGetStart.click();
	}
	public void clickGraphLinkTxt() {
		linktxt1.click();
	}
    public void clickGraphRepLinkTxt() {
		linktxt2.click();
	}
    public void clickGraphTryHereBtn() {
	    btntryhere.click();
	}
	public void clickRunBtn() {
		btnrun.click();
	}
	public void navigation() {
		dsMenu.click();
		selectStack.click();
	}
}

