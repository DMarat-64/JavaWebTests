package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HelpDeskWindowsPage extends BasePage {
    private SelenideElement helpDesk = $("[class='support-chat__kmsu6']");
    private SelenideElement closedWindows = $("[name='ico_close_16']");
  //  private SelenideElement buttonYes = $$("[data-uikit-old='Button']").get(0);
   // private SelenideElement closedHelpDesk = $("[class='confirm-text-main__n9ga2']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        helpDesk.shouldBe(visible);
        closedWindows.shouldBe(visible);
      //  buttonYes.shouldBe(visible);
       // closedHelpDesk.shouldBe(visible);
    }

    @Step("Закрываем чат")
    public void closedWindows() {
        closedWindows.shouldBe(visible).click();
    }

//    @Step("Нажимаем кнопку Да")
//    public void buttonYes() {
//        buttonYes.shouldBe(visible).click();
//    }

    @Step("Проверяем видимость диалогового окна")
    public boolean isHelpDeskVisible() {
        return helpDesk.shouldBe(visible).exists();
    }
}
