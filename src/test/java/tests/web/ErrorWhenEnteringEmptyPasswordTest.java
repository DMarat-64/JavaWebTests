package tests.web;

import core.base.BaseTest;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ErrorWhenEnteringEmptyPasswordTest extends BaseTest {
    private static LoginPage loginPage;


    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void passwordEmptyTest() {
        loginPage.passwordEmpty("incorrectUser");

        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        String expectedErrorMessage = "Введите пароль";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст об ошибке не совпадает");
    }
}
