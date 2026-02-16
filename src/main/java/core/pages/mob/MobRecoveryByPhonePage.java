package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MobRecoveryByPhonePage extends MobileBaseTest {

    private SelenideElement foneInputField = $("#field_phone");
    private SelenideElement countryDropdown  = $("#countryFlag");
    private SelenideElement getCodeButton = $("#getCode");
    private SelenideElement errorMessage  = $("[class='field_error-descr']");

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
        SelenideElement countryItem = $x(String.format(
                "//a[.//div[contains(@class, 'reg_choose_country') and contains(text(), '%s')]]",
                countryName.replace("'", "''")
        ));

        countryItem.scrollTo();
        String countryCode = countryItem.find(".reg_choose_prefix").text();

        ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("arguments[0].click();", countryItem);
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
