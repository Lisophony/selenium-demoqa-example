package browser;
import org.openqa.selenium.WebDriver;

public class Browser {
    private final WebDriver driver;

    public Browser(BrowserType browserType) {
        driver = BrowserFactory.createDriver(browserType);
    }
    public Browser () {
        driver = BrowserFactory.createDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void close() {
        if(driver != null) {
            driver.quit();
        }
    }
}
