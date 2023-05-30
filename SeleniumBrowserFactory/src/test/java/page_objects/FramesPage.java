package page_objects;

import browser.BrowserManager;
import elements.Label;
import org.openqa.selenium.By;

public class FramesPage extends BasePage{
    private final By locIframe1 = By.xpath("//iframe[contains(@id,'frame1')]");
    private final By locIframe2 = By.xpath("//iframe[contains(@id,'frame2')]");

    public FramesPage() {
        super(new Label(By.xpath("//div[contains(@id,'frame2')]"), "Frame 2 Wrapper"), "Frames Form");
    }

    public Frame1Form switchToFrame1() {
        BrowserManager.getBrowser().switchToIframe(BrowserManager.getBrowser().getDriver().findElement(locIframe1));
        return new Frame1Form();
    }

    public Frame2Form switchToFrame2() {
        BrowserManager.getBrowser().switchToIframe(BrowserManager.getBrowser().getDriver().findElement(locIframe2));
        return new Frame2Form();
    }
}
