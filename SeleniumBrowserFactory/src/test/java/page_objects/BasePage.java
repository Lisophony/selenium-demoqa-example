package page_objects;

import browser.BrowserManager;
import elements.BaseElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaitUtil;

public abstract class BasePage {
    protected BaseElement uniqueElement;
    protected String name;

    public BasePage(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public boolean isPageOpen() {
        return BrowserManager.getBrowser().getDriver().findElements(uniqueElement.getLocator()).size() > 0;
    }

    public void waitPageOpen() {
        WaitUtil.waitUntil(ExpectedConditions.presenceOfElementLocated(uniqueElement.getLocator()));
    }
}
