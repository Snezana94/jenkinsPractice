package objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    public static String timeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File(".//screenshots/"+screenshotName+timeStamp()+".png"));
            System.out.println("Screenshot because of test failure(s) taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }
}
