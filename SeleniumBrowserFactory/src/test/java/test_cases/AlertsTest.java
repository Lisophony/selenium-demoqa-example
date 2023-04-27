package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.AlertsForm;
import page_objects.MainPage;
import page_objects.MenuPage;
import utils.RandomUtil;

public class AlertsTest extends BaseTest {
    @Test
    public void testAlerts() {
        System.out.println("STEP 1. Open main Page");
        browser.goTo(testData.get("url").toString());
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page did not open");

        System.out.println("STEP 2. Navigate to Alerts form");
        mainPage.clickOnCard(MainPage.Cards.ALERTS);
        MenuPage menuPage = new MenuPage();
        menuPage.openForm(MenuPage.Form.ALERTS);
        AlertsForm alertsForm = new AlertsForm();
        Assert.assertTrue(alertsForm.isPageOpen(), "Alert form did not open");

        System.out.println("STEP 3 : Open alert");
        alertsForm.clickOnAlertButton();
        Assert.assertTrue(browser.isAlertPresent(), "Alert did not open");
        String expectedAlertMessage = testData.get("alert-msg").toString();
        String actualAlertMessage = browser.getAlertText();
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Unexpected alert's message");

        System.out.println("STEP 4 : Accept alert");
        browser.acceptAlert();
        Assert.assertFalse(browser.isAlertPresent(), "Alert did not close");

        System.out.println("STEP 5. Open confirm alert");
        alertsForm.clickOnConfirmAlertButton();
        Assert.assertTrue(browser.isAlertPresent(), "Alert did not open");
        String actualConfirmAlertMessage = browser.getAlertText();
        String expectedConfirmAlertMessage = testData.get("confirm-alert-msg").toString();
        Assert.assertEquals(actualConfirmAlertMessage, expectedConfirmAlertMessage, "Unexpected alert message");

        System.out.println("STEP 6 : Accept confirm alert");
        browser.acceptAlert();
        Assert.assertFalse(browser.isAlertPresent(), "Alert did not close");
        String actualConfirmResultMessage = alertsForm.getConfirmResultText();
        String expectedConfirmResultMessage = testData.get("accept-confirm-alert-msg").toString();
        Assert.assertEquals(actualConfirmResultMessage, expectedConfirmResultMessage, "Confirm alert result does not match");

        System.out.println("STEP 7: Open prompt alert");
        alertsForm.clickOnPromptAlert();
        Assert.assertTrue(browser.isAlertPresent(), "Prompt alert did not open");
        String actualPromptAlertMessage = browser.getAlertText();
        String expectedPromptAlertMessage = testData.get("prompt-alert-msg").toString();
        Assert.assertEquals(actualPromptAlertMessage, expectedPromptAlertMessage, "Unexpected prompt alert message");

        System.out.println("STEP 8. Enter random text and accept alert");
        String promptText = RandomUtil.generateAlphabetic(10);
        browser.sendKeysInPromptAlert(promptText);
        browser.acceptAlert();
        String actualPromptAlertResult = alertsForm.getPromptResultText();
        Assert.assertTrue(actualPromptAlertResult.contains(promptText), "Entered prompt text does not match");
    }
}
