package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MobLoginPage extends MobileBaseTest {

    private SelenideElement usernameField = $("#field_email");
    private SelenideElement passwordField = $("#field_password");
    private SelenideElement loginButton = $("[label='Войти']");
    private SelenideElement buttonCantLogin = $("[class='common-module__centered___tKWXI vkuiSubhead__host vkuiSubhead__sizeYNone vkuiTypography__host vkuiTypography__normalize vkuiTypography__weight2 vkuiRootComponent__host']");
    private SelenideElement registrationButton = $x("//span[text()='Регистрация']");

    private SelenideElement errorMessage = $("[class='LoginForm-module__error___1xmAD vkuiCaption__sizeYNone vkuiCaption__level1 vkuiTypography__host vkuiTypography__normalize vkuiRootComponent__host']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        buttonCantLogin.shouldBe(visible);
        registrationButton.shouldBe(visible);
    }

    @Step("Входим на сайт с логином и паролем: {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с логином и без пароля: {username}")
    public void setLogin(String username) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);;
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с паролем и без логина: {password}")
    public void setPassword(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);;
        loginButton.shouldBe(visible).click();
    }

    @Step("Проверяем видимость сообщения об ошибки входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }
}
