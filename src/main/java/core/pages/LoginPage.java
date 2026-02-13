package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage extends BasePage {

    private SelenideElement usernameField = $("#field_email");
    private SelenideElement passwordField = $("#field_password");
    private SelenideElement loginButton = $("[label='Войти']");
    private SelenideElement loginButtonQR = $("[label='Войти по QR-коду']");
    private SelenideElement buttonCantLogin = $("[class='vkuiInternalTappable vkuiLink__host vkuiLink__withUnderline vkuiTappable__host vkuiTappable__sizeXNone vkuiTappable__hasPointerNone vkuiClickable__host vkuiClickable__realClickable vkuistyles__-focus-visible vkuiRootComponent__host']");
    private SelenideElement registrationButton = $$("[class='vkuiButton__in']").get(2);

    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement mailButton = $("[data-l='t,mailru']");
    private SelenideElement yandexButton = $("[data-l='t,yandex']");

    private SelenideElement errorMessage = $("[class='LoginForm-module__error___1xmAD" +
            " vkuiCaption__sizeYNone vkuiCaption__level1 vkuiTypography__host vkuiTypography__normalize vkuiRootComponent__host']");

    private SelenideElement goToRecoveryButton = $("[class='vkuiInternalTappable vkuiButton__host vkuiButton__sizeL vkuiButton__modePrimary" +
            " vkuiButton__appearanceAccent vkuiButton__sizeYNone vkuiButton__stretched vkuiTappable__host vkuiTappable__sizeXNone vkuiTappable__hasPointerNone" +
            " vkuiClickable__host vkuiClickable__realClickable vkuistyles__-focus-visible vkuiRootComponent__host']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        loginButtonQR.shouldBe(visible);
        buttonCantLogin.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибки входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином и паролем: {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Войти")
    public void loginEmpty () {
        loginButton.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку восстановить профиль")
    public void clickRecoveryButton () {
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с логином и без пароля: {username}")
    public void passwordEmpty(String username) {
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

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage(){
        registrationButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через ВКонтакте")
    public void loginWithVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Mail")
    public void loginWithMail() {
        mailButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Yandex")
    public void loginWithYandex() {
        yandexButton.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Войти по QR-коду")
    public void clickButtonQR() {
        loginButtonQR.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Не получается войти")
    public void clickButtonCantLogin() {
        buttonCantLogin.shouldBe(visible).click();
    }
}