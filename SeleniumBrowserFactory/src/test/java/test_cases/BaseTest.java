package test_cases;

import browser.Browser;
import browser.BrowserManager;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.JsonUtil;

public abstract class BaseTest {
    protected Browser browser;
    JSONObject testData = JsonUtil.getJson("src/test/resources/test.json");

    @BeforeClass
    public void setup() {
        browser = BrowserManager.getBrowser();
    }

    @AfterClass
    public void tearDown() {
        browser.close();
    }
}
