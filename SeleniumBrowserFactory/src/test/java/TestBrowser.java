import browser.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBrowser {
    Browser browser;
    @BeforeMethod
    public void setup() {
        browser = new Browser();
    }

    @AfterMethod
    public void tearDown() {
        browser.close();
    }

    @Test
    public void shouldBeCorrectInstance() {
        Assert.assertTrue(browser.getDriver() instanceof ChromeDriver, "Incorrect driver type");
    }

}
