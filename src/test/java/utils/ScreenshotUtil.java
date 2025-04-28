package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String scenarioName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filename = "screenshot_" + scenarioName.replaceAll(" ", "_") + "_" + System.currentTimeMillis() + ".png";
            File destFile = new File("src/test/resources/Screenshots/" + filename);
            destFile.getParentFile().mkdirs(); // Create folders if they don’t exist
            FileUtils.copyFile(screenshot, destFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
