package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthorizationQrCodeTest extends BaseTest {
    private static LoginPage loginPage;


    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void authorizationQrCodeTest() {

        loginPage.clickButtonQR();

        var imgQrCode = $("[class='qr_code_image_wrapper']");
        assertTrue(imgQrCode.isDisplayed());

    }
}
