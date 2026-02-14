package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobFirstLoginPage extends MobileBaseTest {

    private SelenideElement goButton = $("[class='base-button_target']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        goButton.shouldBe(visible);
    }

    @Step("Нажимаем кнопку Войти")
    public void clickLoginButton () {
        goButton.shouldBe(visible).click();
    }
}
