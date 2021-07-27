package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutQuickAdd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutQuickAddModal extends BasePage {

    public static final By MODAL_TITLE = By.id("WorkoutAddHeader");
    public static final By WORKOUT_DATE = By.id("WorkoutDate");
    public static final By WORKOUT_PACE = By.id("Pace");
    private static final By SAVE_BUTTON = By.id("saveButton");
    private static final By SAVE_LIBRARY = By.id("SaveLibrary");
    private static final By RACE_BUTTON = By.id("IsRace");
    private static final By PDISTANCE_BUTTON = By.id("PlannedWorkout");

    public WorkoutQuickAddModal(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(MODAL_TITLE);
    }

    @Step("Filling in the form quick add workout")
    public WorkoutQuickAddDetailsPage quickAddWorkout(WorkoutQuickAdd workoutQuickAdd) {
        log.info("Filling in the form quick add workout");
        driver.findElement(WORKOUT_DATE).clear();
        new Input(driver, "WorkoutDate").writeWorkout(workoutQuickAdd.getWorkoutDate());
        new Input(driver, "WorkoutTime").writeWorkout(workoutQuickAdd.getTimeOfDay());
        new DropDown(driver, "ActivityType").selectDropdown(workoutQuickAdd.getActivityType());
        new Input(driver, "Name").writeWorkout(workoutQuickAdd.getWorkoutName());
        new TextArea(driver, "Workout Description").writeWorkout(workoutQuickAdd.getWorkoutDescription());
        showPlannedDistanceClick();
        new Input(driver, "PDistance").writeWorkout(workoutQuickAdd.getPlannedDistance());
        new DropDown(driver, "PDistType").selectDropdown(workoutQuickAdd.getPDistType());
        new Input(driver, "PDuration").writeWorkout(workoutQuickAdd.getPlannedDuration());
        new Input(driver, "Distance").writeWorkout(workoutQuickAdd.getDistance());
        new DropDown(driver, "DistType").selectDropdown(workoutQuickAdd.getDistType());
        new Input(driver, "Duration").writeWorkout(workoutQuickAdd.getDuration());
        driver.findElement(WORKOUT_PACE).clear();
        new Input(driver, "Pace").writeWorkout(workoutQuickAdd.getPace());
        new DropDown(driver, "PaceType").selectDropdown(workoutQuickAdd.getPaceType());
        new DropDown(driver, "HowFeel").selectDropdown(workoutQuickAdd.getHowIFelt());
        new DropDown(driver, "PerEffort").selectDropdown(workoutQuickAdd.getPerceivedEffort());
        new TextArea(driver, "Post Workout Notes/Results").writeWorkout(workoutQuickAdd.getPostWorkoutNotesResults());
        saveToLibraryClick();
        markAsRaceClick();
        new Input(driver, "OverallPlace").writeWorkout(workoutQuickAdd.getOverallPlace());
        new Input(driver, "AgeGroupPlace").writeWorkout(workoutQuickAdd.getAgeGroupPlace());
        save();
        return new WorkoutQuickAddDetailsPage(driver);
    }

    public void showPlannedDistanceClick() {
        driver.findElement(PDISTANCE_BUTTON).click();
    }

    public void saveToLibraryClick() {
        driver.findElement(SAVE_LIBRARY).click();
    }

    public void markAsRaceClick() {
        driver.findElement(RACE_BUTTON).click();
    }

    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
