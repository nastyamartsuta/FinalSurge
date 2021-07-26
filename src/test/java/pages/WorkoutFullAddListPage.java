package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutFullAddListPage extends BasePage {
    public static final By FULL_BUTTON = By.id("FullAddBtn");
    public static final By title = By.id("dpMonth");
    public static final By MESSAGE = By.xpath("//span[contains(text(), 'View and Edit your workout.')]");
    public static final By SELECT_TYPE = By.xpath("//div[@id='col0']//a[@data-code='run']");
    public static final By NAV_LIST = By.xpath("//div[@class='accordion-inner']//a[contains(text(), 'Long Run')]");

    public WorkoutFullAddListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(title);
    }

    @Step("Open calendar page")
    public WorkoutFullAddListPage open() {
        log.info("Open Calendar Page {}", BASE_URL);
        driver.get(BASE_URL + "/Calendar.cshtml");
        return this;
    }

    @Step("Click full add workout on calendar page")
    public WorkoutFullAddModal clickFullAdd() {
        log.info("Click {} in order to open full add workout", FULL_BUTTON);
        driver.findElement(FULL_BUTTON).click();
        driver.findElement(SELECT_TYPE).click();
        driver.findElement(NAV_LIST).click();
        return new WorkoutFullAddModal(driver);
    }

    @Step("Get message")
    public String getMessage() {
        return driver.findElement(MESSAGE).getText();
    }
}
