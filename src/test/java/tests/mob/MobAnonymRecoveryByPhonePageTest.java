package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobAnonymRecoveryByPhonePageTest extends MobileBaseTest {

    private static MobFirstLoginPage mobFirstLoginPage;
    private static MobLoginPage mobloginPage;
    private static MobAnonymRecoveryPage mobAnonymRecoveryPage;
    private static MobRecoveryButtonPage mobRecoveryButtonPage;
    private static MobRecoveryByPhonePage mobRecoveryByPhonePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobFirstLoginPage = new MobFirstLoginPage();
    }

    @Test
    public void mobAnonymRecoveryByPhoneTest() {
        mobFirstLoginPage.clickLoginButton();

        mobloginPage = new MobLoginPage();
        mobloginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            mobloginPage.setPassword("incorrectPassword");
        }

        mobRecoveryButtonPage = new MobRecoveryButtonPage();
        mobRecoveryButtonPage.clickRecoveryButton();

        mobAnonymRecoveryPage = new MobAnonymRecoveryPage();
        mobAnonymRecoveryPage.goToRecoveryByPhone();

        mobRecoveryByPhonePage = new MobRecoveryByPhonePage();
        String countryCode = mobRecoveryByPhonePage.selectCountryByName("Аргентина");
        assertEquals("+54", countryCode,"Код страны не совпадает с ожидаемым");

        mobRecoveryByPhonePage.getCode();
        assertTrue(mobRecoveryByPhonePage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");
        String expectedErrorMessage = "Введен неверный номер телефона";
        String actualErrorMessage = mobRecoveryByPhonePage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст об ошибке не совпадает");
    }
}
