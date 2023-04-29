package page_objects;

import elements.Button;
import elements.InputField;
import elements.Label;
import org.openqa.selenium.By;

public class RegistrationForm extends BasePage{
    private final InputField firstName = new InputField(By.xpath("//input[contains(@id,'firstName')]"), "FirstName");
    private final InputField lastName = new InputField(By.xpath("//input[contains(@id,'lastName')]"), "LastName");
    private final InputField email = new InputField(By.xpath("//input[contains(@id,'mail')]"), "Email");
    private final InputField age = new InputField(By.xpath("//input[contains(@id,'age')]"), "Age");
    private final InputField salary = new InputField(By.xpath("//input[contains(@id,'salary')]"), "Salary");
    private final InputField department = new InputField(By.xpath("//input[contains(@id,'department')]"), "Department");
    private final Button submit = new Button(By.xpath("//button[contains(@id,'submit')]"), "Submit");
    public RegistrationForm() {
        super(new Label(By.xpath("//div[contains(@id,'registration')]"), "Registration form header"), "Registration Form");
    }

    public void enterData(String firstName, String lastName, String email, String age, String salary, String department) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.age.sendKeys(age);
        this.salary.sendKeys(salary);
        this.department.sendKeys(department);
    }

    public void submit() {
        submit.click();
    }
}
