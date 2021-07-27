package tests;

import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculator;
import models.WorkoutCalculatorFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class WorkoutCalculatorTest extends BaseTest {

    @Test(description = "Calculator Intensity test")
    public void calculatorIntensityTest() {

        WorkoutCalculator workoutCalculator = WorkoutCalculatorFactory.get();

        loginPage
                .open()
                .login(EMAIL, PASSWORD);
        workoutCalculatorListPage
                .open()
                .clickWorkoutCalculator()
                .createIntensityCalculator(workoutCalculator);
        boolean message = driver.findElement(By.xpath("//h4[contains(text(), 'Your Workout Paces')]")).isDisplayed();
        Assert.assertTrue(message, "Error filling out the Intensity Workout Form");
    }

    @Test(description = "Calculator Hansons test")
    public void calculatorHansonsTest() {

        WorkoutCalculator workoutCalculator = WorkoutCalculatorFactory.get();

        loginPage
                .open()
                .login(EMAIL, PASSWORD);
        workoutCalculatorListPage
                .open()
                .clickWorkoutCalculatorAndHansonsButton()
                .createHansonsCalculator(workoutCalculator);
        boolean message = driver.findElement(By.xpath("//h4[contains(text(), 'Recent Race Information')]")).isDisplayed();
        Assert.assertTrue(message, "Error filling out the Hansons Workout Form");
    }

    @Test(description = "Calculator McMillan test")
    public void calculatorMcMillanTest() {

        WorkoutCalculator workoutCalculator = WorkoutCalculatorFactory.get();

        loginPage
                .open()
                .login(EMAIL, PASSWORD);
        workoutCalculatorListPage
                .open()
                .clickWorkoutCalculatorAndMcMillanButton()
                .createMcMillanCalculator(workoutCalculator);
        boolean message = driver.findElement(By.xpath("//h4[contains(text(), 'McMillan Running Calculator')]")).isDisplayed();
        Assert.assertTrue(message, "Error filling out the McMillan Workout Form");
    }

    @Test(description = "Calculator Tinman test")
    public void calculatorTinmanTest() {

        WorkoutCalculator workoutCalculator = WorkoutCalculatorFactory.get();

        loginPage
                .open()
                .login(EMAIL, PASSWORD);
        workoutCalculatorListPage
                .open()
                .clickWorkoutCalculatorAndTinmanButton()
                .createTinmanCalculator(workoutCalculator);
        boolean message = driver.findElement(By.xpath("//h4[contains(text(), 'Race Information')]")).isDisplayed();
        Assert.assertTrue(message, "Error filling out the Tinman Workout Form");
    }

    @Test(description = "Calculator Palladino test")
    public void calculatorPalladinoTest() {

        WorkoutCalculator workoutCalculator = WorkoutCalculatorFactory.get();

        loginPage
                .open()
                .login(EMAIL, PASSWORD);
        workoutCalculatorListPage
                .open()
                .clickWorkoutCalculatorAndPalladinoButton()
                .createPalladinoCalculator(workoutCalculator);
        boolean message = driver.findElement(By.xpath("//h4[contains(text(), 'Interval Power Targets')]")).isDisplayed();
        Assert.assertTrue(message, "Error filling out the Palladino Workout Form");
    }
}
