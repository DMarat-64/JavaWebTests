package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MobAnonymRecoveryPage extends MobileBaseTest {

    private SelenideElement recoveryByPhoneButton = $("[class='content-card registration_step item __center-align']");
    private SelenideElement recoveryByMailButton = $(By.xpath("//div[contains(@class, 'registration_step') and .//div[text()='Электронная почта']]"));
    private SelenideElement goToSupportButton = $x("//a[text()='Служба поддержки']");

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
