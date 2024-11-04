package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.DatePickerForm;
import page_objects.MainPage;
import page_objects.MenuPage;

public class DateTimeWidgetsTest extends BaseTest{
    @Test
    public void testDateTimeWidgets() {
        System.out.println("STEP 1. Open main Page");
        browser.goTo(testData.get("url").toString());
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page did not open");

        System.out.println("STEP 2. Navigate to DateTime widgets");
        mainPage.clickOnCard(MainPage.Cards.WIDGETS);
        MenuPage menuPage = new MenuPage();
        menuPage.openForm(MenuPage.Form.DATEPICKER);
        DatePickerForm datePickerForm = new DatePickerForm();
        Assert.assertTrue(datePickerForm.isPageOpen(), "DataPicker form did not open");


    }
}
