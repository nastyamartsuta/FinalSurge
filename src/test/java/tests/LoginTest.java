package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Login test with valid data")
    public void loginWithValidDataTest() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page did not open");
        loginPage.login(EMAIL, PASSWORD);
        assertTrue(homePage.isPageOpened(), "Calendar page did not open");
    }

    @Test(description = "Login test with invalid email")
    public void loginWithInvalidEmailTest() {
        loginPage
                .open()
                .login(INVALID_EMAIL, PASSWORD);
        String error = loginPage.authenticationWithInvalidData();
        assertEquals(error, "Invalid login credentials. Please try again.");
    }

    @Test(description = "Login test with invalid password")
    public void loginWithInvalidPasswordTest() {
        loginPage
                .open()
                .login(EMAIL, INVALID_PASSWORD);
        String error = loginPage.authenticationWithInvalidData();
        assertEquals(error, "Invalid login credentials. Please try again.");
    }

    @Test(description = "Login test with invalid data")
    public void loginWithInvalidDataTest() {
        loginPage
                .open()
                .login(INVALID_EMAIL, INVALID_PASSWORD);
        String error = loginPage.authenticationWithInvalidData();
        assertEquals(error, "Invalid login credentials. Please try again.");
    }

    @Test(description = "Login test with empty email")
    public void loginWithEmptyEmailTest() {
        loginPage
                .open()
                .login(" ", PASSWORD);
        String errorEmail = loginPage.authenticationWithEmptyEmail();
        assertEquals(errorEmail, "Please enter your e-mail address.");
    }

    @Test(description = "Login test with empty password")
    public void loginWithEmptyPasswordTest() {
        loginPage
                .open()
                .login(EMAIL, " ");
        String errorPassword = loginPage.authenticationWithEmptyPassword();
        assertEquals(errorPassword, "Please enter a password.");
    }

    @Test(description = "Login test with empty data")
    public void loginWithEmptyDataTest() {
        loginPage
                .open()
                .login(" ", " ");
        String errorEmail = loginPage.authenticationWithEmptyEmail();
        assertEquals(errorEmail, "Please enter your e-mail address.");
        String errorPassword = loginPage.authenticationWithEmptyPassword();
        assertEquals(errorPassword, "Please enter a password.");
    }
}
