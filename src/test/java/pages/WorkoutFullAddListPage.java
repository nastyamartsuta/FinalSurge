package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutFullAddListPage extends BasePage {
    public static final By FULL_BUTTON = By.id("FullAddBtn");
    public static final By title = By.id("dpMonth");
    public static final By SELECT_TYPE = By.xpath("//div[@id='col0']//a[@data-code='run']");
    public static final By NAV_LIST = By.xpath("//div[@class='accordion-inner']//a[contains(text(), 'Long Run')]");

    public WorkoutFullAddListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(title);
    }

    @Step("Open account page")
    public WorkoutFullAddListPage open() {
        driver.get(BASE_URL + "/Calendar.cshtml");
        return this;
    }

    @Step("Click NEW button on workout page")
    public WorkoutFullAddModal clickFullAdd() {
        driver.findElement(FULL_BUTTON).click();
        return new WorkoutFullAddModal(driver);
    }

    @Step("Click Select an Activity Type")
    public void clickSelectAnActivityType() {
        driver.findElement(SELECT_TYPE).click();
        driver.findElement(NAV_LIST).click();
    }

}
