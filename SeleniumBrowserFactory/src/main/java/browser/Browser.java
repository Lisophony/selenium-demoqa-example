package browser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public Alert getAlert() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
