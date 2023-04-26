package utils;

import browser.Browser;
import browser.BrowserManager;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {
    private static final String keySleep = "wait-delay";

    public static void waitUntil(ExpectedCondition<?> condition) {
        Browser browser= BrowserManager.getBrowser();
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(10));
        wait.until(condition);
    }
}
