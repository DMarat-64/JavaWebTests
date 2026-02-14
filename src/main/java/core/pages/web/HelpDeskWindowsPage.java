package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HelpDeskWindowsPage extends BasePage {
    private SelenideElement helpDesk = $("[class='support-chat__kmsu6']");
    private SelenideElement closedWindows = $x("//button[@class='button__tndfc button-icon__tndfc']//span[@name='ico_close_16']");
    private SelenideElement buttonYes = $x("//span[text()='Да']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        helpDesk.shouldBe(visible);
        closedWindows.shouldBe(visible);
    }

    @Step("Закрываем чат")
    public void closedWindows() {
        closedWindows.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Да")
    public void buttonYes() {
        buttonYes.shouldBe(visible).click();
    }

    @Step("Проверяем видимость диалогового окна")
    public boolean isHelpDeskVisible() {
        return helpDesk.shouldBe(visible).exists();
    }
}
