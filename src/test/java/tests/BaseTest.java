package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.HomePage;
import pages.LoginPage;
import tests.base.TestListener;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    protected LoginPage loginPage;
    protected HomePage homePage;
    public static final String EMAIL = "nastyamartsuta@gmail.com";
    public static final String PASSWORD = "Password16";
    public static final String INVALID_EMAIL = "123@gmail.com";
    public static final String INVALID_PASSWORD = "password___....";

    @BeforeMethod(description = "Open Browser")
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //НЕЯВНЫЕ ОЖИДАНИЯ

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Close Browser")
    public void tearDown() {
        driver.quit();
    }
}
