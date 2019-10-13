package steps_definition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data_pool.Data;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import support.AutomationWebDriver;

import static junit.framework.TestCase.assertTrue;

public class LoginPageSteps extends AutomationWebDriver {
    public WebDriver driver;

    @Before("@LoginTests")
    public void setUp() {
        driver = getDriver();
    }

    @After("@LoginTests")
    public void tearDown() {
        clear_status();
    }

    @Given("^The user is on \"([^\"]*)\" site$")
    public void the_user_is_on_site(String urlSite) {
        openURL(urlSite);
    }

    @When("^The user login in with right credentials$")
    public void theUserLoginInWithRightCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserEmail(Data.userName);
        loginPage.setUSerPassword(Data.Password);
        loginPage.clickOnSignInButton();
    }

    @Then("^The user should see the logo of the site$")
    public void theUserShouldSeeTheLogoOfTheSite() {
        HomePage homePage = new HomePage(driver);
        assertTrue("The logo of the site is not visible",homePage.isSiteLogoVisible());
    }

    @And("^The user should see the successful message on the banner$")
    public void theUserShouldSeeTheSuccessfulMessageOnTheBanner() {
        HomePage homePage = new HomePage(driver);
        assertTrue("The successful message is not visible", homePage.isSuccessfulBannerMessageVisible());
    }

    @And("^The user should see his name on the banner$")
    public void theUserShouldSeeHisNameOnTheBanner() {
        HomePage homePage = new HomePage(driver);
        assertTrue("The name of the user is not visible", homePage.isUserInformationVisible());
    }
}
