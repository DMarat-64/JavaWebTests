package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import core.pages.RecoveryByPhone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnonymRecoveryByPhoneTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryByPhone recoveryByPhone;

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
        recoveryByPhone = new RecoveryByPhone();
        String countryCode = recoveryByPhone.selectCountryByName("Антигуа и Барбуда");
        assertEquals("+1268", countryCode,"Код страны не совпадает с ожидаемым");

        recoveryByPhone.getCode();
        assertTrue(recoveryByPhone.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");
        String expectedErrorMessage = "Неправильный номер телефона.";
        String actualErrorMessage = recoveryByPhone.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст об ошибке не совпадает");
    }
}
