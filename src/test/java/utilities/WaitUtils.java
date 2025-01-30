package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final int TIMEOUT = Integer.parseInt(ConfigReader.getProperty("element.timeout"));
    private static final int POLLING = Integer.parseInt(ConfigReader.getProperty("polling.interval"));

    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .pollingEvery(Duration.ofMillis(POLLING))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickability(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .pollingEvery(Duration.ofMillis(POLLING))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Add more methods as needed (e.g., presence, staleness, etc.)
}
