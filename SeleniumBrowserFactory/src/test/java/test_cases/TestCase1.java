package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.AlertsForm;
import page_objects.MainPage;
import page_objects.MenuPage;

public class TestCase1 extends BaseTest {
    @Test
    public void test1() {
        System.out.println("STEP 1. Open main Page");
        browser.goTo(testData.get("url").toString());
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page did not open");

        System.out.println("STEP 2. Navigate to Alerts form");
        mainPage.clickOnCard(MainPage.Cards.ALERTS);
        MenuPage menuPage = new MenuPage();
        menuPage.openForm(MenuPage.Form.ALERTS);
        AlertsForm alertsForm = new AlertsForm();
        Assert.assertTrue(alertsForm.isPageOpen(), "Alert form dod not open");

        System.out.println("STEP 3 : Open alert");
        alertsForm.clickOnAlertButton();
        String expectedAlertMessage = testData.get("alert-msg").toString();
        String actualAlertMessage = browser.getAlertText();
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Unexpected alert's message");

        System.out.println("STEP 4 : Accept alert");
        browser.acceptAlert();
        Assert.assertFalse(browser.isAlertPresent(), "Alert did not close");
    }
}
