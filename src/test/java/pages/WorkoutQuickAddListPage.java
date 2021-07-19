package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutQuickAddListPage extends BasePage {

    public static final By QUICK_BUTTON = By.id("QuickAddToggle");
    public static final By title = By.id("dpMonth");
    public static final By MESSAGE = By.cssSelector(".alert");
    String okButton = "//a[contains(.,'OK')]";
    String deleteButton = "//div[contains(text(),'%s')]/ancestor::div[contains(@class , 'dropdown')]/ul//li/a[contains(@class, 'quick-delete')]";
    String calendarButton = "//div[contains(text(),'%s')]";

    public WorkoutQuickAddListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(title);
    }

    @Step("Open account page")
    public WorkoutQuickAddListPage open() {
        driver.get(BASE_URL + "/Calendar.cshtml");
        return this;
    }

    @Step("Click NEW button on workout page")
    public WorkoutQuickAddModal clickQuickAdd() {
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
        driver.findElement(By.xpath(String.format(okButton, workout))).click();
    }
}
