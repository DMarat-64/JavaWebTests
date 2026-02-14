package core.base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class MobileBaseTest extends AbstractBaseTest{

    @Override
    protected void configure() {
        Configuration.browser = "chrome";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation",
                Map.of("deviceName", "iPhone XR")
        );

        Configuration.browserCapabilities = chromeOptions;
    }
}
