package tests;

import core.base.BasePage;
import core.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchForGroupsTest extends BaseTest {
    private static BasePage basePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        basePage = new BasePage();
    }

    @Test
    public void searchTest() {
        basePage.search("тестировщик");

        assertThat($("[data-l='t,userAltGroup']").shouldBe(visible));
    }
}
