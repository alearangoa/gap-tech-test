package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VacationManagementPage {

    WebDriver driver;
    WebDriverWait wait;

    /**
     * Constructor
     *
     * @param driver Web driver
     */
    public VacationManagementPage(WebDriver driver) {
        this.driver = driver;
        //Page factory
        PageFactory.initElements(this.driver, this);
        //Web Driver Wait
        wait = new WebDriverWait(this.driver, 30);

    }

    /**
     * Clicks on a given web element
     *
     * @param element Web Element to be clackable
     */
    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Types a given text on a Web Element
     *
     * @param element Element to be typed
     * @param text    Text to be set
     */
    public void setsIntoElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    /**
     * Verifies if an element is present
     * @param element
     * @return True if the element is visible, false otherwise
     */
    public boolean isElementVisible (WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch(TimeoutException error) {
            return false;
        }

    }

}
