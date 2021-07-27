package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

@Log4j2
public class WorkoutQuickAddListPage extends BasePage {

    public static final By QUICK_BUTTON = By.id("QuickAddToggle");
    public static final By title = By.id("dpMonth");
    public static final By MESSAGE = By.cssSelector(".alert");
    String deleteButton = "//div[contains(text(),'%s')]/ancestor::div[contains(@class , 'dropdown')]/ul//li/a[contains(@class, 'quick-delete')]";
    String calendarButton = "//div[contains(text(),'%s')]";
    public static final By OK_BUTTON = By.xpath("//a[contains(.,'OK')]");

    public WorkoutQuickAddListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(title);
    }

    @Step("Open calendar page")
    public WorkoutQuickAddListPage open() {
        log.info("Open Calendar Page {}", BASE_URL);
        driver.get(BASE_URL + "/Calendar.cshtml");
        return this;
    }

    @Step("Click quick add workout on calendar page")
    public WorkoutQuickAddModal clickQuickAdd() {
        log.info("Click {} in order to open quick add workout", QUICK_BUTTON);
        driver.findElement(QUICK_BUTTON).click();
        return new WorkoutQuickAddModal(driver);
    }

    @Step("Get message")
    public String getMessage() {
        return driver.findElement(MESSAGE).getText();
    }

    @Step("Delete workout")
    public void deleteWorkout(String workout) {
        driver.findElement(By.xpath(String.format(calendarButton, workout))).click();
        driver.findElement(By.xpath(String.format(deleteButton, workout))).click();
        try {
            driver.findElement(OK_BUTTON).click();
        } catch (ElementClickInterceptedException e) {
            WebElement element = driver.findElement(OK_BUTTON);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
    }
}
