package tests;

import lombok.extern.log4j.Log4j2;
import models.WorkoutFullAdd;
import models.WorkoutFullAddFactory;
import org.testng.annotations.Test;

@Log4j2
public class WorkoutFullAddTest extends BaseTest {

    @Test(description = "Full add workout test")
    public void fullAddWorkoutTest() {

        WorkoutFullAdd workoutFullAdd = WorkoutFullAddFactory.get();

        loginPage
                .open()
                .login(EMAIL, PASSWORD);
        workoutFullAddListPage
                .open()
                .clickFullAdd()
                .create(workoutFullAdd);
    }
}
