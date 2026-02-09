package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryPage extends BasePage {

    private SelenideElement recoveryByPhoneButton = $("[data-l='t,phone']");
    private SelenideElement recoveryByMailButton = $("[data-l='t,email']");
    private SelenideElement goToSupportButton = $("[class='support-link_item-text']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByMailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку восстановления через почту")
    public void goToRecoveryByMail() {
        recoveryByMailButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку обратиться в службу поддержки")
    public void goToSupport() {
        goToSupportButton.shouldBe(visible).click();
    }
}
