package page_objects;

import elements.Button;
import org.openqa.selenium.By;

public class AlertsForm extends BasePage {
    private final Button alert = new Button(By.xpath("//button[contains(@id,'alert')]"), "Alert");

    public AlertsForm() {
        super(new Button(By.xpath("//button[contains(@id,'alert')]"), "Alert"), "Alert Form");
    }

    public void clickOnAlertButton() {
        alert.click();
    }
}
