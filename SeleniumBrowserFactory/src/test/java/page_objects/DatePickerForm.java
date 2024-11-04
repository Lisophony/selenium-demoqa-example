package page_objects;

import elements.BaseElement;
import org.openqa.selenium.By;

public class DatePickerForm extends BasePage{
    public DatePickerForm() {
        super(new BaseElement(By.xpath("//div[contains(@id,'datePicker')]//h1[contains(@class, 'text')]"), "Date picker header"), "DatePicker Form");

    }
}
