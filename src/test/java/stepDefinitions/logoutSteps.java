package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverManager;

import java.util.Map;

public class logoutSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;


    @Given("User is logged in with valid credentials")
    public void userIsLoggedIn(DataTable dataTable) {
        driver = DriverManager.getDriver();
        Map<String, String> credentials = dataTable.asMap(String.class, String.class);
        loginPage = new LoginPage(driver);
        loginPage.login(credentials.get("username"), credentials.get("password"));
    }

    @When("User clicks on the logout button")
    public void clickLogout() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.click_logoutdropdown();
        dashboardPage.click_logoutbutton();
    }

    @Then("User should be redirected to the login page")
    public void verifyLoginPageRedirection() {
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.getProperty("app.url"));
    }

    @When("User clicks on the Admin button")
    public void clickAdmin() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.click_admonbutton();
    }
    @Then("User should be redirected to the viewSystemUsers page")
    public void verifyviewSystemUsersPageRedirection() {
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.getProperty("viewSystemUsers.url"));
    }
}
