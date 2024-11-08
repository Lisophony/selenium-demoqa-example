package elements;

import org.openqa.selenium.By;
import utils.LogUtil;

public class InputField extends BaseElement{
    public InputField(By locator, String name) {
        super(locator, name);
    }

    public void sendKeys(String text) {
        find().sendKeys(text);
    }
}
