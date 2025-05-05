
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
public class ChromeTest {

	
	
	

	
	    public static void main(String[] args) {
	        // Optional: Set path if ChromeDriver isn't in PATH
	        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

	        WebDriver driver = new ChromeDriver();
	        driver.get("https://www.google.com");
	        System.out.println("Page Title: " + driver.getTitle());
	        driver.quit();
	    }
	}

