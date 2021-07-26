package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public static final String BASE_URL = "https://log.finalsurge.com/login.cshtml";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public abstract boolean isPageOpened();

    public boolean isExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
