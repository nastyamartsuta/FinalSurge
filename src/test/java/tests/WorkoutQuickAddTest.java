package tests;

import lombok.extern.log4j.Log4j2;
import models.WorkoutQuickAdd;
import models.WorkoutQuickAddFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class WorkoutQuickAddTest extends BaseTest {

    @Test(description = "Quick add workout test")
    public void quickAddWorkoutTest() {

        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.get();

        loginPage
                .open()
                .login(EMAIL, PASSWORD);
        workoutQuickAddListPage
                .open()
                .clickQuickAdd()
                .quickAddWorkout(workoutQuickAdd);

        String error = workoutQuickAddListPage.getMessage();
        assertEquals(error, "×\n" +
                        "*The workout was successfully saved to your Workout Library.",
                "Workout has not been added to your workout library");
    }

    @Test(description = "Delete workout test")
    public void deleteWorkoutTest() {

        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.get();

        loginPage
                .open()
                .login(EMAIL, PASSWORD);
        workoutQuickAddListPage
                .open()
                .clickQuickAdd()
                .quickAddWorkout(workoutQuickAdd);

        String error = workoutQuickAddListPage.getMessage();
        assertEquals(error, "×\n" +
                        "*The workout was successfully saved to your Workout Library.",
                "Workout has not been added to your workout library");
        workoutQuickAddListPage.deleteWorkout(workoutQuickAdd.getWorkoutName());
    }
}
