package tests.web;

import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.HelpDeskWindowsPage;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoToSupportTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static HelpDeskWindowsPage helpDeskWindowsPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void goToSupportTest() {
        loginPage.clickButtonCantLogin();

        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToSupport();

        helpDeskWindowsPage = new HelpDeskWindowsPage();
        assertTrue(helpDeskWindowsPage.isHelpDeskVisible(), "Диалоговое окно не отображается");

        helpDeskWindowsPage.closedWindows();
        helpDeskWindowsPage.buttonYes();
    }
}
