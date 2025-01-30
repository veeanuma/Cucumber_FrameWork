package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement logoutdropdown;
        @FindBy(linkText = "Logout")
    private WebElement logoutbutton;

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement aadminbutton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void click_logoutdropdown() {
        click(logoutdropdown);
    }

    public void click_logoutbutton() {
        click(logoutbutton);
    }

    public void click_admonbutton() {
        click(aadminbutton);
    }
}
