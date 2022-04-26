package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTemplate {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor executor;

    @BeforeClass
    public void beforeClass() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        executor = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 30);
    }

    @AfterMethod
    public void tkscreenshot (ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Utility utility = new Utility();
            utility.captureScreenshot(driver, result.getName());
        }
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://snezana94.github.io/my-first-site/");
        String h = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(h, "Kuhinjski DEKOR");
        System.out.println(h);
    }

    @Test
    public void test2() {
        System.out.println("test2 proba");
    }
    
}
