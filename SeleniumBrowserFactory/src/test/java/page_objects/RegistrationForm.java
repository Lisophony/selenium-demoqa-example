package page_objects;

import elements.InputField;
import elements.Label;
import org.openqa.selenium.By;

public class RegistrationForm extends BasePage{
    private final InputField firstName = new InputField(By.xpath("//input[contains(@id,'firstName')]"), "FirstName");
    private final InputField lastName = new InputField(By.xpath("//input[contains(@id,'lastName')]"), "LastName");
    private final InputField email = new InputField(By.xpath("//input[contains(@id,'mail')]"), "Email");
    private final InputField salary = new InputField(By.xpath("//input[contains(@id,'salary')]"), "Salary");
    private final InputField department = new InputField(By.xpath("//input[contains(@id,'department')]"), "Department");

    public RegistrationForm() {
        super(new Label(By.xpath("//div[contains(@id,'registration')]"), "Registration form header"), "Registration Form");
    }
}
