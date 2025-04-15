package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TryeditorPage {
	WebDriver driver;

    public void TryEditorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web elements
    @FindBy(xpath = "//a[@href='/tryEditor' and contains(@class, 'btn-info')]")
    WebElement tryHereLink;

    @FindBy(xpath = "//form[@id='answer_form']/div/div/div[1]/textarea")
    WebElement codeEditor;

    @FindBy(xpath = "//button[@type='button' and @onclick='runit()']")
    WebElement runButton;

    // Actions
    public void clickTryHere() {
        tryHereLink.click();
    }

    public void enterCode(String code) {
        codeEditor.clear();
        codeEditor.sendKeys(code);
    }

    public void clickRun() {
        runButton.click();
    }

}
