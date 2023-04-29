package page_objects;

import browser.BrowserManager;
import elements.Button;
import elements.Label;
import org.openqa.selenium.By;

public class WebTablesForm extends BasePage{
    private final Button addNewRecord = new Button(By.xpath("//button[contains(@id,'addNew')]"), "AddNewRecord");
    String usersRowsLoc = "//div[contains(@class,'padRow')]//parent::div[contains(@role,'row')]//preceding-sibling::div//div[contains(@class,'action-buttons')]";
    String oneUserRowLoc = "//div[contains(@class,'rt-tr-group')]";
    public WebTablesForm() {
        super(new Button(By.xpath("//button[contains(@id,'addNew')]"), "AddNewRecord"), "Tables Form");
    }

    public RegistrationForm switchToRegistrationForm() {
        addNewRecord.click();
        return new RegistrationForm();
    }

    public String getRowText() {
        int id = BrowserManager.getBrowser().getDriver().findElements(By.xpath(usersRowsLoc)).size();
        String userRowLoc = oneUserRowLoc + "[" + id + "]";
        return new Label(By.xpath(userRowLoc), "LastUserInTable").getText();
    }
}
