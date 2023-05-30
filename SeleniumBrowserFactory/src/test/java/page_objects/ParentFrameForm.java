package page_objects;

import browser.BrowserManager;
import elements.Label;
import org.openqa.selenium.By;

public class ParentFrameForm extends BasePage {
    private final By childFrame = By.xpath("//iframe[contains(@srcdoc,'Child')]");

    public ParentFrameForm() {
        super(new Label(By.xpath("//body[contains(text(),'Parent frame')]"), "Parent Frame body"), "ParentFrame Form");
    }

    public ChildFrameForm switchToChildFrameForm() {
        BrowserManager.getBrowser().switchToIframe(BrowserManager.getBrowser().getDriver().findElement(childFrame));
        return new ChildFrameForm();
    }
}
