package page_objects;

import elements.Label;
import org.openqa.selenium.By;

public class ChildFrameForm extends BasePage {
    public ChildFrameForm() {
        super(new Label(By.xpath("//body//p[contains(text(),'Child')]"), "ChildFrame Label"), "ChildFrame Form");
    }
}
