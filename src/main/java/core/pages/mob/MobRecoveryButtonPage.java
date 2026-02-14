package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MobRecoveryButtonPage extends MobileBaseTest {

    private SelenideElement goToRecoveryButton = $x("//span[text()='Восстановить']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        goToRecoveryButton.shouldBe(visible);
    }

    @Step("Нажимаем кнопку восстановить профиль")
    public void clickRecoveryButton () {
        goToRecoveryButton.shouldBe(visible).click();
    }
}
