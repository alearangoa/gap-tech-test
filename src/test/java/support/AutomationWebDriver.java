package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutomationWebDriver {

    private WebDriver driver = null;

    public WebDriver getDriver(){
        if (driver == null) {
            String path = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        } else {
            return driver;
        }
    }

    public void clear_status(){
        System.out.println("Closing browser...");
        driver.quit();
        driver = null;
    }

    public void openURL (String url){
        driver.navigate().to(url);
    }

}
