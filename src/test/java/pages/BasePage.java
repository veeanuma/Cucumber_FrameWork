package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.WaitUtils;

import static oracle.net.ns.NetException.TIMEOUT;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    // Enhanced click method with auto-wait
    protected void click(WebElement element) {
        WaitUtils.waitForClickability(driver, element).click();
    }

    // Enhanced sendKeys method with auto-wait
    protected void sendKeys(WebElement element, String text) {
        WaitUtils.waitForVisibility(driver, element).sendKeys(text);
    }




}
