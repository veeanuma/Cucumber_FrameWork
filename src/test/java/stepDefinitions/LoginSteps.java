package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverManager;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("User is on the login page")
    public void navigateToLoginPage() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getProperty("app.url"));
        loginPage = new LoginPage(driver);
    }

    @When("User enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("User should be redirected to the dashboard")
    public void verifyDashboard() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
}
