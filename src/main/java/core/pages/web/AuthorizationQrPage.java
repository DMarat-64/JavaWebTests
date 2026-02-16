package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationQrPage {

    private SelenideElement imgQr = $("[class='qr_code_image_wrapper']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        imgQr.shouldBe(visible);
    }

    @Step("Проверяем видимость QR кода")
    public boolean isQrVisible() {
        return imgQr.shouldBe(visible).exists();
    }
}
