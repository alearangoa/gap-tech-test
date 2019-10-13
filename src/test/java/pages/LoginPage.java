package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends VacationManagementPage {

    /**
     * Constructor
     *
     * @param driver Web driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name = 'commit']")
    private WebElement signInButton;

    @FindBy(css = "input[id = 'user_email']")
    private WebElement emailTextBox;

    @FindBy(css = "input[id = 'user_password']")
    private WebElement passwordTextBox;

    /**
     * Clicks on 'Sign In' button
     */
    public void clickOnSignInButton() {
        clickOnElement(signInButton);
    }

    /**
     * Sets user email
     *
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        setsIntoElement(emailTextBox, userEmail);
    }

    /**
     * Sets user password
     *
     * @param userPassword
     */
    public void setUSerPassword(String userPassword) {
        setsIntoElement(passwordTextBox, userPassword);
    }
}
