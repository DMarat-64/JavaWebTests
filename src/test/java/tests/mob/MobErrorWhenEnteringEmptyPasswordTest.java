package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.MobFirstLoginPage;
import core.pages.mob.MobLoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobErrorWhenEnteringEmptyPasswordTest extends MobileBaseTest {
    private static MobLoginPage mobloginPage;
    private static MobFirstLoginPage mobFirstLoginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobFirstLoginPage = new MobFirstLoginPage();
    }

    @Test
    public void passwordEmptyTest() {
        mobFirstLoginPage.clickLoginButton();

        mobloginPage = new MobLoginPage();
        mobloginPage.setLogin("incorrectUser");

        assertTrue(mobloginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        String expectedErrorMessage = "Введите пароль";
        String actualErrorMessage = mobloginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст об ошибке не совпадает");
    }
}
