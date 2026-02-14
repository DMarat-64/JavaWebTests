package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryByPhonePage extends BasePage {

    private SelenideElement foneInputField = $("#field_phone");
    private SelenideElement countryDropdown  = $x("//div[@class='isl_w country-select_label']");
    private SelenideElement getCodeButton = $("[data-l='t,submit']");
    private SelenideElement errorMessage  = $("[class='input-e js-ph-vl-hint']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        foneInputField.shouldBe(visible);
        countryDropdown.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Выбираем код страны по номеру: {countryName}")
    public String selectCountryByName(String countryName) {
        countryDropdown.click();
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']", countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text();
        countryItem.click();
        return countryCode;
    }

    @Step("Проверяем видимость сообщения об ошибки входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Нажимаем кнопку Получить код")
    public void getCode () {
        getCodeButton.shouldBe(visible).click();
    }
}
