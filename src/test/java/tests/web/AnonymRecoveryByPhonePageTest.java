package tests.web;

import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.LoginPage;
import core.pages.web.RecoveryByPhonePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnonymRecoveryByPhonePageTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryByPhonePage recoveryByPhonePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void anonymRecoveryByPhoneTest() {
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("incorrectPassword");
        }

        loginPage.clickRecoveryButton();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        recoveryByPhonePage = new RecoveryByPhonePage();
        String countryCode = recoveryByPhonePage.selectCountryByName("Антигуа и Барбуда");
        assertEquals("+1268", countryCode,"Код страны не совпадает с ожидаемым");

        recoveryByPhonePage.getCode();
        assertTrue(recoveryByPhonePage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");
        String expectedErrorMessage = "Неправильный номер телефона.";
        String actualErrorMessage = recoveryByPhonePage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст об ошибке не совпадает");
    }
}
