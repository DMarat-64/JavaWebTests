package tests.web;

import core.base.BaseTest;
import core.pages.web.AuthorizationQrPage;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthorizationQrCodeTest extends BaseTest {
    private static LoginPage loginPage;
    private static AuthorizationQrPage authorizationQrPage;


    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void authorizationQrCodeTest() {

        loginPage.clickButtonQR();

        authorizationQrPage = new AuthorizationQrPage();
        assertTrue(authorizationQrPage.isQrVisible(), "Qr не отображается");

    }
}
