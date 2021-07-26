package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import tests.base.TestListener;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected WorkoutQuickAddListPage workoutQuickAddListPage;
    protected WorkoutFullAddListPage workoutFullAddListPage;
    protected WorkoutCalculatorListPage workoutCalculatorListPage;
    public static final String EMAIL = utils.PropertyReader.getProperty("FINALSURGE_EMAIL", "finalsurge.email");
    public static final String PASSWORD = utils.PropertyReader.getProperty("FINALSURGE_PASSWORD", "finalsurge.password");
    public static final String INVALID_EMAIL = "123@gmail.com";
    public static final String INVALID_PASSWORD = "password___....";

    @Parameters({"browser"})
    @BeforeMethod(description = "Open Browser")
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals(("chrome"))) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            OperaOptions options = new OperaOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            options.addArguments("--disable-notifications");
            driver = new OperaDriver();
        }
        testContext.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //НЕЯВНЫЕ ОЖИДАНИЯ
        wait = new WebDriverWait(driver, 25);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        workoutQuickAddListPage = new WorkoutQuickAddListPage(driver);
        workoutFullAddListPage = new WorkoutFullAddListPage(driver);
        workoutCalculatorListPage = new WorkoutCalculatorListPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Close Browser")
    public void tearDown() {
        driver.quit();
    }
}
