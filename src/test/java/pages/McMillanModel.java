package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class McMillanModel extends BasePage {

    public static final By MODAL_TITLE = By.id("//*[@class='w-box-header']//h4[contains(text()," +
            " 'McMillan Running Calculator')]");
    public static final By SAVE_BUTTON = By.id("saveButtonSettings");

    public McMillanModel(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(MODAL_TITLE);
    }

    @Step("Filling in the form calculator McMillan workout")
    public WorkoutCalculatorDetailsPage createMcMillanCalculator(WorkoutCalculator workoutCalculator) {
        log.info("Filling in the form calculator McMillan workout");
        new DropDown(driver, "distance").selectDropdown(workoutCalculator.getDistanceMillan());
        new Input(driver, "TimeHH").writeWorkout(workoutCalculator.getHoursMillan());
        new Input(driver, "TimeMM").writeWorkout(workoutCalculator.getMinutesMillan());
        new Input(driver, "TimeSS").writeWorkout(workoutCalculator.getSecondsMillan());
        save();
        return new WorkoutCalculatorDetailsPage(driver);
    }

    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
