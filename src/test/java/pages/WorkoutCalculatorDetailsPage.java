package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkoutCalculatorDetailsPage extends BasePage {

//    private static WebDriver driver;
//    public static final By PACES_HEADER = By.xpath("//h4[contains(.,'Your Workout Paces')]/ancestor::div[@class='w-box-header']");
//    public static final By TIMES_HEADER = By.xpath("//h4[contains(.,'Equivalent Event Performance Times Based on your PR')]/ancestor::div[@class='w-box-header']");
//    public static final By SPLITS_HEADER = By.xpath("//h4[contains(.,'VO2 Max Workout Splits')]/ancestor::div[@class='w-box-header']");

//    public static final By DETAILS_TAB = By.xpath("//div[contains(@class,'w-box-header')]//h4[contains(text(), 'Workout Details')]");

    public WorkoutCalculatorDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

//    public static boolean checkCalculationsIsOpened() {
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(PACES_HEADER));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(TIMES_HEADER));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(SPLITS_HEADER));
//        return true;
//    }
}

