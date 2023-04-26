package page_objects;

import browser.BrowserManager;
import elements.BaseElement;

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
}
