package elements;

import browser.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class BaseElement {
    protected By locator;
    protected String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }


    public String getAttribute(final String attributeName) {
       return null;
    }

    public Dimension getSize() {
        return null;
    }

    public WebElement find() {
        return BrowserManager.getBrowser().getDriver().findElement(locator);
    }

    public boolean exists() {
        return false;
    }

    public void waitClickable() {

    }

    public void clickViaJS() {
    }

    public void click() {
        BrowserManager.getBrowser().getDriver().findElement(locator).click();
    }

    public By getLocator() {
        return locator;
    }

    public String getText() {
        return BrowserManager.getBrowser().getDriver().findElement(locator).getText();
    }
}
