package browser;

import elements.BaseElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
        BrowserManager.clearBrowserInstance();
    }
    //Add new browser actions here (alerts, screenshots, scrolls etc.)
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e) {
            return false;
        }
    }
    public String getAlertText() {
        return getAlert().getText();
    }

    public void acceptAlert() {
        getAlert().accept();
    }

    public void sendKeysInPromptAlert(String text) {
        getAlert().sendKeys(text);
    }

    public <T extends BaseElement> List<T> findElements(By locator, Class<T> clazz) {
        List<T> elements = new ArrayList<>();
        int number = driver.findElements(locator).size();
        for(int i = 1; i <= number; ++i) {

        }
        return null;
    }

    public Alert getAlert() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
