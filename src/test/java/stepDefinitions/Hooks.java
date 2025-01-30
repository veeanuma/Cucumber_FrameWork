package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverManager;
import utilities.ScreenshotUtil;

import java.time.Duration;


public class Hooks {
    @Before
    public void setup() {
        WebDriver driver = new ChromeDriver(); // or use ConfigReader to get browser type
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        DriverManager.setDriver(driver);
    }



    @After
    public void takeScreenshotOnFailure(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            ScreenshotUtil.captureScreenshot(DriverManager.getDriver(), scenario);
        }
        DriverManager.quitDriver();
    }



}
