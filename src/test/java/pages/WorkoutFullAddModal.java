package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import models.WorkoutFullAdd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutFullAddModal extends BasePage {
    public static final By MODAL_TITLE = By.id("WorkoutAddHeader");
    public static final By WORKOUT_DATE = By.id("WorkoutDate");
    private static final By SAVE_BUTTON = By.id("saveButton");
    private static final By RACE_BUTTON = By.id("IsRace");
    private static final By PDISTANCE_BUTTON = By.id("PlannedWorkout");
    public static final By WORKOUT_PACE = By.id("Pace");

    public WorkoutFullAddModal(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(MODAL_TITLE);
    }

    @Step("Fill in form for new workout")
    public WorkoutFullAddDetailsPage create(WorkoutFullAdd workoutFullAdd) {
        driver.findElement(WORKOUT_DATE).clear();
        new Input(driver, "WorkoutDate").writeWorkout(workoutFullAdd.getWorkoutDate());
        new Input(driver, "WorkoutTime").writeWorkout(workoutFullAdd.getTimeOfDay());
        new Input(driver, "Name").writeWorkout(workoutFullAdd.getWorkoutName());
        new TextArea(driver, "Workout Description").writeWorkout(workoutFullAdd.getWorkoutDescription());
        showPlannedDistanceClick();
        new Input(driver, "PDistance").writeWorkout(workoutFullAdd.getPlannedDistance());
//        new DropDown(driver, "pDistType").selectDropdown(workoutFullAdd.getPDistType());
        new Input(driver, "PDuration").writeWorkout(workoutFullAdd.getPlannedDuration());
        new Input(driver, "Distance").writeWorkout(workoutFullAdd.getDistance());
//        new DropDown(driver, "distType").selectDropdown(workoutFullAdd.getDistType());
        new Input(driver, "Duration").writeWorkout(workoutFullAdd.getDuration());
        driver.findElement(WORKOUT_PACE).clear();
        new Input(driver, "Pace").writeWorkout(workoutFullAdd.getPace());
//        new DropDown(driver, "paceType").selectDropdown(workoutFullAdd.getPaceType());
        markAsRaceClick();
        new Input(driver, "OverallPlace").writeWorkout(workoutFullAdd.getOverallPlace());
        new Input(driver, "AgeGroupPlace").writeWorkout(workoutFullAdd.getAgeGroupPlace());
//        new DropDown(driver, "howIFelt").selectDropdown(workoutFullAdd.getHowIFelt());
        new DropDown(driver, "PerEffort").selectDropdown(workoutFullAdd.getPerceivedEffort());
        new Input(driver, "MinHR").writeWorkout(workoutFullAdd.getMinHR());
        new Input(driver, "AvgHR").writeWorkout(workoutFullAdd.getAvgHR());
        new Input(driver, "MaxHR").writeWorkout(workoutFullAdd.getMaxHR());
        new Input(driver, "kCal").writeWorkout(workoutFullAdd.getCaloriesBurned());
        save();
        return new WorkoutFullAddDetailsPage(driver);
    }

    public void showPlannedDistanceClick() {
        driver.findElement(PDISTANCE_BUTTON).click();
    }

    public void markAsRaceClick() {
        driver.findElement(RACE_BUTTON).click();
    }

    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}