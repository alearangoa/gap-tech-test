package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends VacationManagementPage {

    /**
     * Constructor
     *
     * @param driver Web driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[id='logo']")
    private WebElement siteLogo;

    @FindBy(xpath = "//p[contains(text(), 'Signed in successfully.')]")
    private WebElement successfulBannerMessage;

    @FindBy(xpath = "//span[contains(text(), 'Welcome gap, ')]")
    private WebElement userInformation;

    @FindBy(xpath = "//a[contains(text(), 'Create a new employee')]")
    private WebElement createNewEmployeeLink;

    @FindBy(xpath = "//a[contains(text(), 'Employees Information')]")
    private WebElement employeesListTab;

    @FindBy(xpath = "//div[@id='content']/table")
    private WebElement employeesTable;

    @FindBy(xpath = "//div[@id='content']/table//tr")
    private List<WebElement> employeesTableRows;

    private static final String employeeTableRowsLeaderField = "//div[@id='content']/table//tr[%s]/td[4]";
    private static final String employeeTableRowsFirstNameField = "//div[@id='content']/table//tr[%s]/td[1]";
    private static final String employeeTableRowsLastNameField = "//div[@id='content']/table//tr[%s]/td[2]";
    private static final String employeeTableRowsIdentificationField = "//div[@id='content']/table//tr[%s]/td[3]";
    private static final String employeeTableRowsStartDateField = "//div[@id='content']/table//tr[%s]/td[5]";
    private static final String deleteEmployee = "//div[@id='content']/table//tr[%s]/td[9]/a";

    /**
     * Verifies if the Logo of the site is visible
     *
     * @return True if is visible, False otherwise
     */
    public boolean isSiteLogoVisible() {
        return isElementVisible(siteLogo);
    }

    /**
     * Verifies if the successful message on banner is visible
     *
     * @return True if is visible, False otherwise
     */
    public boolean isSuccessfulBannerMessageVisible() {
        return isElementVisible(successfulBannerMessage);
    }

    /**
     * Verifies if the information of the user on banner is visible
     *
     * @return True if is visible, False otherwise
     */
    public boolean isUserInformationVisible() {
        return isElementVisible(userInformation);
    }

    /**
     * Clicks on create new employee link
     */
    public void clickOnCreateNewEmployeeLink() {
        clickOnElement(createNewEmployeeLink);
    }

    /**
     * Clicks on employees list tab
     */
    public void clickOnEmployeeList() {
        clickOnElement(employeesListTab);
        wait.until(ExpectedConditions.visibilityOf(createNewEmployeeLink));
    }

    /**
     * Gets the number of rows on the Employees Table
     *
     * @return number of rows on the Employees Table
     */
    public int getListOfTableRows() {
        return employeesTableRows.size();
    }

    /**
     * Gets leader name based on a number of row
     *
     * @param row to be analyzed
     * @return leader name of the row
     */
    public String getLeaderName(int row) {
        return driver.findElement(By.xpath(String.format(employeeTableRowsLeaderField, row))).getText();
    }


    /**
     * Gets First Name based on a number of row
     *
     * @param row to be analyzed
     * @return First name of the row
     */
    public String getFirstName(int row) {
        return driver.findElement(By.xpath(String.format(employeeTableRowsFirstNameField, row))).getText();
    }

    /**
     * Gets Last Name based on a number of row
     *
     * @param row to be analyzed
     * @return Last name of the row
     */
    public String getLastName(int row) {
        return driver.findElement(By.xpath(String.format(employeeTableRowsLastNameField, row))).getText();
    }

    /**
     * Gets identification based on a number of row
     *
     * @param row to be analyzed
     * @return Identification of the row
     */
    public String getIdentification(int row) {
        return driver.findElement(By.xpath(String.format(employeeTableRowsIdentificationField, row))).getText();
    }

    /**
     * Gets Start Date based on a number of row
     *
     * @param row to be analyzed
     * @return Start date of the row
     */
    public String getStartDate(int row) {
        return driver.findElement(By.xpath(String.format(employeeTableRowsStartDateField, row))).getText();
    }

    /**
     * Clicks delete link of a given row
     *
     * @param row to be deleted
     */
    public void clicksOnDeleteEmployee(int row) {
        driver.findElement(By.xpath(String.format(deleteEmployee, row))).click();
    }

}
