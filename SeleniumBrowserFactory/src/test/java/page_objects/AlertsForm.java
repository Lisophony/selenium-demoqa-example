package page_objects;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;

public class AlertsForm extends BasePage {
    private final Button alert = new Button(By.xpath("//button[contains(@id,'alert')]"), "Alert");
    private final Button confirmAlert = new Button(By.xpath("//button[contains(@id,'confirm')]"), "Confirm alert");
    private final Button promptAlert = new Button(By.xpath("//button[contains(@id,'promtButton')]"), "Prompt alert");
    private final Label confirmResult = new Label(By.xpath("//span[contains(@id,'confirmResult')]"), "Confirm result");
    private final Label promptResult = new Label(By.xpath("//span[contains(@id,'promptResult')]"), "Prompt result");

    public AlertsForm() {
        super(new Button(By.xpath("//button[contains(@id,'alert')]"), "Alert"), "Alert Form");
    }

    public void clickOnAlertButton() {
        alert.click();
    }

    public void clickOnConfirmAlertButton() {
        confirmAlert.click();
    }

    public void clickOnPromptAlert() {
        promptAlert.click();
    }

    public String getConfirmResultText() {
        return confirmResult.getText();
    }

    public String getPromptResultText() {
        return promptResult.getText();
    }
}
