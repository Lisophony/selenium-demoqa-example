package test_cases;

import browser.Browser;
import browser.BrowserManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected Browser browser;

    @BeforeMethod
    public void setup() {
        browser = BrowserManager.getBrowser();
    }

    @AfterMethod
    public void tearDown() {
        browser.close();
    }
}
