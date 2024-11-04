package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.DateAndTimeCalendaerForm;
import page_objects.DatePickerForm;
import page_objects.MainPage;
import page_objects.MenuPage;
import utils.DateTimeUtil;
import utils.LogUtil;

public class DateTimeWidgetsTest extends BaseTest{
    @Test
    public void testDateTimeWidgets() {
        LogUtil.makeLog("STEP 1. Open main Page");
        browser.goTo(testData.get("url").toString());
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page did not open");

        LogUtil.makeLog("STEP 2. Navigate to DateTime widgets and check dates and time");
        mainPage.clickOnCard(MainPage.Cards.WIDGETS);
        MenuPage menuPage = new MenuPage();
        menuPage.openForm(MenuPage.Form.DATEPICKER);
        DatePickerForm datePickerForm = new DatePickerForm();
        Assert.assertTrue(datePickerForm.isPageOpen(), "DataPicker form did not open");
        String dateExpected = DateTimeUtil.getDate(testData.get("date-format-1").toString());
        String dateAndTimeExpected = DateTimeUtil.getDateTime(testData.get("date-format-2").toString(), testData.get("time-12").toString());
        String dateActual = datePickerForm.getDate();
        String dateAndTimeActual = datePickerForm.getDateAndTime();
        Assert.assertEquals(dateActual, dateExpected, "Actual date and expected date are not equal");
        Assert.assertEquals(dateAndTimeActual, dateAndTimeExpected, "Actual dateAndTime and expected dateAndTime are not equal");

        LogUtil.makeLog("STEP 3. Select nearest February 29th using arrows buttons in DateAndTime picker");
        String day = testData.get("day").toString();
        String month = testData.get("month").toString();
        String nearestLeapYear = DateTimeUtil.getNearestLeapYear();
        datePickerForm.openDateAndTimeCalendar();
        DateAndTimeCalendaerForm dateAndTimeCalendaerForm = new DateAndTimeCalendaerForm();
        dateAndTimeCalendaerForm.setDateViaArrows(DateTimeUtil.getNearestLeapYear(), testData.get("month").toString(), testData.get("day").toString(), "yyyy/MMMM/dd");
        String expectedDate = String.format("%s %s, %s", month, day, nearestLeapYear);
        Assert.assertTrue(datePickerForm.getDateAndTime().startsWith(expectedDate), "Selected date is not correct");
    }
}
