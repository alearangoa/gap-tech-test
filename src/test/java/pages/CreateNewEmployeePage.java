package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateNewEmployeePage extends VacationManagementPage {

    /**
     * Constructor
     *
     * @param driver Web driver
     */
    public CreateNewEmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id='employee_first_name']")
    private WebElement employeeFirstNameTextBox;

    @FindBy(css = "input[id='employee_last_name']")
    private WebElement employeeLastNameTextBox;

    @FindBy(css = "input[id='employee_email']")
    private WebElement employeeEmailTextBox;

    @FindBy(css = "input[id='employee_identification']")
    private WebElement employeeId;

    @FindBy(css = "input[id='employee_leader_name']")
    private WebElement employeeLeaderName;

    @FindBy(css = "select[id='employee_start_working_on_1i']")
    private WebElement startYear;

    @FindBy(css = "select[id='employee_start_working_on_2i']")
    private WebElement startMonth;

    @FindBy(css = "select[id='employee_start_working_on_3i']")
    private WebElement startDay;

    @FindBy(css = "input[name='commit']")
    private WebElement createEmployeeButton;

    /**
     * Sets first name of the new employee
     *
     * @param firstName
     */
    public void setEmployeeFirstName(String firstName) {
        setsIntoElement(employeeFirstNameTextBox, firstName);
    }

    /**
     * Sets last name of the employee
     *
     * @param lastName
     */
    public void setEmployeeLastName(String lastName) {
        setsIntoElement(employeeLastNameTextBox, lastName);
    }

    /**
     * Sets email of the employee
     *
     * @param email
     */
    public void setEmployeeEmail(String email) {
        setsIntoElement(employeeEmailTextBox, email);
    }

    /**
     * Sets identification of the employee
     *
     * @param identification
     */
    public void setEmployeeId(String identification) {
        setsIntoElement(employeeId, identification);
    }

    /**
     * Sets leader name of the new employee
     *
     * @param leaderName
     */
    public void setEmployeeLeaderName(String leaderName) {
        setsIntoElement(employeeLeaderName, leaderName);
    }

    /**
     * Sets start day
     *
     * @param startDayValue
     */
    public void setStartDay(String startDayValue) {
        Select startDaySelect = new Select(startDay);
        startDaySelect.selectByValue(startDayValue);
    }

    /**
     * Sets start day
     *
     * @param startMonthValue
     */
    public void setStartMonth(String startMonthValue) {
        Select startMonthSelect = new Select(startMonth);
        startMonthSelect.selectByIndex(Integer.parseInt(startMonthValue)-1);
    }

    /**
     * Sets start day
     *
     * @param startYearValue
     */
    public void setStartYear(String startYearValue) {
        Select startYearSelect = new Select(startYear);
        startYearSelect.selectByValue(startYearValue);
    }

    /**
     * Sets start day
     */
    public void clickOnCreateNewEmployeeButton() {
        clickOnElement(createEmployeeButton);
    }
}
