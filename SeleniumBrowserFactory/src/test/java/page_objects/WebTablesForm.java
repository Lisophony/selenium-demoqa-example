package page_objects;

import elements.Button;
import org.openqa.selenium.By;

public class WebTablesForm extends BasePage{
    private final Button addNewRecord = new Button(By.xpath("//button[contains(@id,'addNew')]"), "AddNewRecord");

    public WebTablesForm() {
        super(new Button(By.xpath("//button[contains(@id,'addNew')]"), "AddNewRecord"), "Tables Form");
    }

    public RegistrationForm switchToRegistrationForm() {
        addNewRecord.click();
        return new RegistrationForm();
    }
}
