package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.MobAnonymRecoveryPage;
import core.pages.mob.MobFirstLoginPage;
import core.pages.mob.MobLoginPage;
import core.pages.mob.MobRecoveryButtonPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class MobAnonymRecoveryByMailTest extends MobileBaseTest {

    private static MobFirstLoginPage mobFirstLoginPage;
    private static MobLoginPage mobloginPage;
    private static MobAnonymRecoveryPage mobAnonymRecoveryPage;
    private static MobRecoveryButtonPage mobRecoveryButtonPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobFirstLoginPage = new MobFirstLoginPage();
    }

    @Test
    public void mobAnonymRecoveryByMailTest() {
        mobFirstLoginPage.clickLoginButton();

        mobloginPage = new MobLoginPage();
        mobloginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            mobloginPage.setPassword("incorrectPassword");
        }

        mobRecoveryButtonPage = new MobRecoveryButtonPage();
        mobRecoveryButtonPage.clickRecoveryButton();

        mobAnonymRecoveryPage = new MobAnonymRecoveryPage();
        mobAnonymRecoveryPage.goToRecoveryByMail();

        assertThat($("#field_email").shouldBe(visible));
    }
}
