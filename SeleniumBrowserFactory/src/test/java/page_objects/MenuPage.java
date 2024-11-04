package page_objects;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {
    private final String formsLoc = "//div[contains(@class,'accordion')]//span[contains(@class,'text') and contains(text(),'%s')]";
    public enum Form {
        ALERTS("Alerts"),
        WEBTABLES("Web Tables"),
        FRAMES("Frames"),
        NESTEDFRAMES("Nested Frames"),
        DATEPICKER("Date Picker");

        final String formName;

        Form(String formName) {
            this.formName = formName;
        }

        public String getFormName() {
            return formName;
        }
    }

    public MenuPage() {
        super(new Label(By.xpath("//div[contains(@class,'accordion')]"), "Accordion"), "Menu Page");
    }

    public void openForm(Form formType) {
        By formLocator = By.xpath(String.format(formsLoc, formType.getFormName()));
        new Button(formLocator, formType.formName).click();
    }
}
