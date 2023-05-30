package page_objects;

import elements.BaseElement;
import elements.Label;
import org.openqa.selenium.By;

public class FramesForm extends BasePage{
    public FramesForm() {
        super(new Label(By.xpath("//div[contains(@id,'frame2')]"), "Frame 2 Wrapper"), "Frames Form");
    }
}
