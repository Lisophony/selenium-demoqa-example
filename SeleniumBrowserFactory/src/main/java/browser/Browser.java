package browser;

import org.openqa.selenium.WebDriver;

public class Browser {
    private final WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void goTo(String url) {
        driver.get(url);
    }

    public void close() {
        if(driver != null) {
            driver.quit();
        }
    }
    //Add new browser actions here (alerts, screenshots, scrolls etc.)
}
