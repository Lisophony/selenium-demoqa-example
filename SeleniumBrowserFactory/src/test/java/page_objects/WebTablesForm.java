package page_objects;

import browser.BrowserManager;
import elements.Button;
import elements.Label;
import models.User;
import org.openqa.selenium.By;

public class WebTablesForm extends BasePage{
    private final Button addNewRecord = new Button(By.xpath("//button[contains(@id,'addNew')]"), "AddNewRecord");
    String usersRowsLoc = "//div[contains(@class,'padRow')]//parent::div[contains(@role,'row')]//preceding-sibling::div//div[contains(@class,'action-buttons')]";
    String oneUserRowLoc = "//div[contains(@class,'rt-tr-group')]";
    String deleteRecordLoc = "//span[contains(@id,'delete-record-%s')]";

    public WebTablesForm() {
        super(new Button(By.xpath("//button[contains(@id,'addNew')]"), "AddNewRecord"), "Tables Form");
    }

    public RegistrationForm switchToRegistrationForm() {
        addNewRecord.click();
        return new RegistrationForm();
    }
    public User getLastUserFromTable() {
        String[] userData = getRowText().split("\n");
        return new User(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5]);
    }

    public User getUserFromTable(int row) {
        String[] userData = getRowText(row).split("\n");
        return new User(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5]);
    }

    protected String getRowText() {
        int id = BrowserManager.getBrowser().getDriver().findElements(By.xpath(usersRowsLoc)).size();
        String userRowLoc = oneUserRowLoc + "[" + id + "]";
        return new Label(By.xpath(userRowLoc), "LastUserInTable").getText();
    }

    protected String getRowText(int row) {
        String userRowLoc = oneUserRowLoc + "[" + row + "]";
        return new Label(By.xpath(userRowLoc), "LastUserInTable").getText();
    }

    public void deleteRecord(int row) {
        String deleteLoc = String.format(deleteRecordLoc, row);
        new Button(By.xpath(deleteLoc), "Delete Record " + row).click();
    }

    public void deleteLastRecord() {
        int id = BrowserManager.getBrowser().getDriver().findElements(By.xpath(usersRowsLoc)).size();
        String deleteLoc = String.format(deleteRecordLoc, id);
        new Button(By.xpath(deleteLoc), "Delete Record " + id).click();
    }
}
