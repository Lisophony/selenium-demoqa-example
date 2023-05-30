package page_objects;

import elements.Label;
import org.openqa.selenium.By;

public class Frame2Form extends BasePage {
    private final Label heading = new Label(By.xpath("//h1[contains(@id,'sample')]"), "Heading");

    public Frame2Form() {
        super(new Label(By.xpath("//h1[contains(@id,'sample')]"), "Heading"), "Frame2 Form");
    }

    public String getHeadingText() {
        return heading.getText();
    }
}
