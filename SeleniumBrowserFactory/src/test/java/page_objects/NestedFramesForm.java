package page_objects;

import browser.BrowserManager;
import elements.BaseElement;
import elements.Label;
import org.openqa.selenium.By;

public class NestedFramesForm extends BasePage {
    private final By parentFrame = By.xpath("//iframe[contains(@id,'frame1')]");

    public NestedFramesForm() {
        super(new Label(By.xpath("//div[contains(@id,'framesWrapper')]//div"), "Nested frames label"), "NestedFrames Form");
    }

    public ParentFrameForm switchToParentIFrame() {
        BrowserManager.getBrowser().switchToIframe(BrowserManager.getBrowser().getDriver().findElement(parentFrame));
        return new ParentFrameForm();
    }
}
