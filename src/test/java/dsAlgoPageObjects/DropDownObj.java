//package dsAlgoPageObjects;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import driverManager.DriverFactory;
//import utils.ConfigReader;
//
//public class DropDownObj {
//
//	WebDriver driver; // get WebDriver
//	String url = ConfigReader.getUrl();   // ✅ get URL from config
//	
//    @FindBy(xpath = "//a[text()='Data Structures']")
//    WebElement dropdownButton;
//
//    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[@class='dropdown-item']")
//    List<WebElement> dropdownItems;
//
//    // ✅ Constructor
//    public DropDownObj() {
//        this.driver = DriverFactory.getDriver();
//        PageFactory.initElements(driver, this);
//    }
//
//    public void navigateToHomePage() {
//    	driver.get(url);
//    }
//
//    public List<String> getDropdownTexts() {
//        dropdownButton.click(); // Open dropdown
//        List<String> items = new ArrayList<>();
//        for (WebElement el : dropdownItems) {
//            items.add(el.getText());
//        }
//        return items;
//    }
//
//    // Optional: main method to test
//    public static void main(String[] args) {
//        DropDownObj obj = new DropDownObj();
//        obj.navigateToHomePage();
//
//        List<String> dropdownValues = obj.getDropdownTexts();
//        System.out.println("Dropdown values:");
//        dropdownValues.forEach(System.out::println);
//    }
//    
//}
