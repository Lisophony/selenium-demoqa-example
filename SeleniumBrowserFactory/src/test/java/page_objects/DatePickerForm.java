package page_objects;

import elements.BaseElement;
import elements.InputField;
import org.openqa.selenium.By;

public class DatePickerForm extends BasePage{
    public DatePickerForm() {
        super(new BaseElement(By.xpath("//div[contains(@id,'datePicker')]//h1[contains(@class, 'text')]"), "Date picker header"), "DatePicker Form");
    }

    private InputField selectDate = new InputField(By.xpath("//input[contains(@id,'datePicker')]"), "Simple date InputField");
    private InputField dateTime = new InputField(By.xpath("//input[contains(@id,'dateAndTime')]"), "DateAndTime InputField");

    public String getDate() {
        return selectDate.getAttribute("value");
    }

    public String getDateAndTime() {
        return dateTime.getAttribute("value");
    }

    public void openDateAndTimeCalendar() {
        dateTime.click();
    }
}
