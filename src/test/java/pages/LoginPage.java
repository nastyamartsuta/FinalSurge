package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final By EMAIL_INPUT = By.id("login_name");
    public static final By PASSWORD_INPUT = By.id("login_password");
    public static final By LOGIN_BUTTON = By.className("btn");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']");
    public static final By EMPTY_EMAIL = By.xpath("//div[@class='formpad']//label[contains(text(), 'e-mail')]");
    public static final By EMPTY_PASSWORD = By.xpath("//div[@class='formpad']//label[contains(text(), 'password.')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(LOGIN_BUTTON);
    }

    @Step("Open login page")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("User authorization")
    public HomePage login(String user, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }

    @Step("Authentication with invalid email")
    public String authenticationWithInvalidData() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Authentication with empty email")
    public String authenticationWithEmptyEmail() {
        return driver.findElement(EMPTY_EMAIL).getText();
    }

    @Step("Authentication with empty password")
    public String authenticationWithEmptyPassword() {
        return driver.findElement(EMPTY_PASSWORD).getText();
    }
}
