package steps_definition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import data_pool.Data;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import pages.CreateNewEmployeePage;
import pages.HomePage;
import pages.LoginPage;
import support.AutomationWebDriver;


public class CreateEmployeesSteps extends AutomationWebDriver {
    public WebDriver driver;

    public static class Employee {
        String firstName;
        String lastName;
        String identification;
        String leaderName;
        String startDate;
        String email;

        @Override
        public boolean equals(Object obj) {
            Employee emp = (Employee) obj;
            return firstName.equals(emp.firstName) &&
                    lastName.equals(emp.lastName) &&
                    identification.equals(emp.identification) &&
                    leaderName.equals(emp.leaderName) &&
                    startDate.equals(emp.startDate);
        }
    }

    int i;
    boolean isNewEmployeeCreated = false;
    Employee newEmployee = new Employee();

    @Before("@CreateEmployeesTests")
    public void setUp() {
        driver = getDriver();
    }

    @After("@CreateEmployeesTests")
    public void tearDown() {
        clear_status();
    }

    @Given("^The user is logged on \"([^\"]*)\" site$")
    public void the_user_is_logged_on_site(String urlSite) {
        openURL(urlSite);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserEmail(Data.userName);
        loginPage.setUSerPassword(Data.Password);
        loginPage.clickOnSignInButton();
    }

    @When("^The user enters to 'New Employee' page$")
    public void theUserEntersToNewEmployeePage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCreateNewEmployeeLink();
    }


    @And("^The user creates a new employee with (.*?), (.*?), (.*?), (.*?), (.*?), (.*?), (.*?), (.*?)$")
    public void theUserCreatesANewEmployeeWithFirstNameLastNameEmailIdLeaderNameStartYearStartMonthStartDay(String firstName, String lastName, String email, String id, String leaderName, String startYear, String startMonth, String startDay) {
        CreateNewEmployeePage createNewEmployeePage = new CreateNewEmployeePage(driver);
        createNewEmployeePage.setEmployeeFirstName(firstName);
        createNewEmployeePage.setEmployeeLastName(lastName);
        createNewEmployeePage.setEmployeeEmail(email);
        createNewEmployeePage.setEmployeeLeaderName(leaderName);
        createNewEmployeePage.setEmployeeId(id);
        createNewEmployeePage.setStartYear(startYear);
        createNewEmployeePage.setStartMonth(startMonth);
        createNewEmployeePage.setStartDay(startDay);
        createNewEmployeePage.clickOnCreateNewEmployeeButton();
        newEmployee.firstName = firstName;
        newEmployee.lastName = lastName;
        newEmployee.identification = id;
        newEmployee.leaderName = leaderName;
        newEmployee.email = email;
        newEmployee.startDate = startMonth.concat("/").concat(startDay).concat("/").concat(startYear);

    }

    @Then("^The new employee should be created on 'Listing Employees' Page$")
    public void theUserWithFirstNameLastNameEmailIdLeaderNameStartYearStartMonthStartDayShouldBeCreatedOnListingEmployeesPage() {
        Employee employee = new Employee();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnEmployeeList();
        for (i = 2; i< homePage.getListOfTableRows(); i++) {
            employee.firstName = homePage.getFirstName(i);
            employee.lastName = homePage.getLastName(i);
            employee.identification = homePage.getIdentification(i);
            employee.leaderName = homePage.getLeaderName(i);
            employee.startDate = homePage.getStartDate(i);
            if (employee.equals(newEmployee)) {
                isNewEmployeeCreated = true;
                break;
            }
        }
        assertTrue("The created employee is not in the table", isNewEmployeeCreated);
    }


    @But("^The user clicks on 'Delete' link of the created employee$")
    public void theUserClicksOnDeleteLinkOfTheCreatedEmployee() {
        HomePage homePage = new HomePage(driver);
        homePage.clicksOnDeleteEmployee(i);
        driver.switchTo().alert().accept();
        isNewEmployeeCreated = false;
    }

    @Then("^The created employee should be deleted$")
    public void theEmployeeWithFirstNameLastNameEmailIdLeaderNameStartYearStartMonthStartDayShouldBeDeleted() {
        driver.navigate().refresh();
        Employee employee = new Employee();
        HomePage homePage = new HomePage(driver);
        for (i = 2; i > homePage.getListOfTableRows(); i++) {
            employee.firstName = homePage.getFirstName(i);
            employee.lastName = homePage.getLastName(i);
            employee.identification = homePage.getIdentification(i);
            employee.leaderName = homePage.getLeaderName(i);
            employee.startDate = homePage.getStartDate(i);
            if (employee.equals(newEmployee)) {
                isNewEmployeeCreated = true;
                break;
            }
        }
        assertFalse("The created employee is on the table", isNewEmployeeCreated);
    }
}
