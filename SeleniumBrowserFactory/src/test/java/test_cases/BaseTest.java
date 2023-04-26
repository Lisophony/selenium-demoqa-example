package test_cases;

import browser.Browser;
import browser.BrowserManager;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.JsonUtil;

public abstract class BaseTest {
    protected Browser browser;
    JSONObject testData = JsonUtil.getJson("src/test/resources/test.json");

    @BeforeMethod
    public void setup() {
        browser = BrowserManager.getBrowser();
    }

    @AfterMethod
    public void tearDown() {
        browser.close();
    }
}
