package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class WorkoutCalculatorListPage extends BasePage {

    public static final By title = By.id("dpMonth");
    public static final By CALCULATOR_BUTTON = By.xpath("//*[@class='icsw16-stop-watch']");
    private static final String IFRAME_PATTERN = "IntensityCalciFrame";
    public static final By HANSONS_BUTTON = By.xpath("//a[contains(text(), 'Hansons')]");
    public static final By MCMILLAN_BUTTON = By.xpath("//a[contains(text(), 'McMillan')]");
    public static final By TINMAN_BUTTON = By.xpath("//a[contains(text(), 'Tinman')]");
    public static final By PALLADINO_BUTTON = By.xpath("//a[contains(text(), 'Palladino')]");

    public WorkoutCalculatorListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(title);
    }

    @Step("Open account page")
    public WorkoutCalculatorListPage open() {
        log.info("Open Calendar Page {}", BASE_URL);
        driver.get(BASE_URL + "/Calendar.cshtml");
        return this;
    }

    @Step("Click workout calculator on calendar page")
    public IntensityModal clickWorkoutCalculator() {
        log.info("Click {} in order to open calculator page", CALCULATOR_BUTTON);
        driver.findElement(CALCULATOR_BUTTON).click();
        driver.switchTo().frame(IFRAME_PATTERN);
        return new IntensityModal(driver);
    }

    @Step("Click workout calculator and then the Hansons button")
    public HansonsModal clickWorkoutCalculatorAndHansonsButton() {
        log.info("Click {} in order to open calculator page", CALCULATOR_BUTTON);
        driver.findElement(CALCULATOR_BUTTON).click();
        driver.switchTo().frame(IFRAME_PATTERN);
        log.info("Click {} in order to open the Hansons workout on the calculator page", HANSONS_BUTTON);
        driver.findElement(HANSONS_BUTTON).click();
        return new HansonsModal(driver);
    }

    @Step("Click workout calculator and then the McMillan button")
    public McMillanModel clickWorkoutCalculatorAndMcMillanButton() {
        log.info("Click {} in order to open calculator page", CALCULATOR_BUTTON);
        driver.findElement(CALCULATOR_BUTTON).click();
        driver.switchTo().frame(IFRAME_PATTERN);
        log.info("Click {} in order to open the McMillan workout on the calculator page", MCMILLAN_BUTTON);
        driver.findElement(MCMILLAN_BUTTON).click();
        return new McMillanModel(driver);
    }

    @Step("Click workout calculator and then the Tinman button")
    public TinmanModel clickWorkoutCalculatorAndTinmanButton() {
        log.info("Click {} in order to open calculator page", CALCULATOR_BUTTON);
        driver.findElement(CALCULATOR_BUTTON).click();
        driver.switchTo().frame(IFRAME_PATTERN);
        log.info("Click {} in order to open the Tinman workout on the calculator page", TINMAN_BUTTON);
        driver.findElement(TINMAN_BUTTON).click();
        return new TinmanModel(driver);
    }

    @Step("Click workout calculator and then the Palladino button")
    public PalladinoModel clickWorkoutCalculatorAndPalladinoButton() {
        log.info("Click {} in order to open calculator page", CALCULATOR_BUTTON);
        driver.findElement(CALCULATOR_BUTTON).click();
        driver.switchTo().frame(IFRAME_PATTERN);
        log.info("Click {} in order to open the Palladino workout on the calculator page", PALLADINO_BUTTON);
        driver.findElement(PALLADINO_BUTTON).click();
        return new PalladinoModel(driver);
    }

//    @Step("Checking intensity paces was opened")
//    public void checkingCalculationWasOpened() {
//        Assert.assertTrue(WorkoutCalculatorDetailsPage.checkCalculationsIsOpened(), "Calculations did not open");
//    }
}
