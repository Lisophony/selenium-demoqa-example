package test_cases;

import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.MainPage;
import page_objects.MenuPage;
import page_objects.RegistrationForm;
import page_objects.WebTablesForm;

public class WebTablesTest extends BaseTest {
    @Test
    public void testWebTables() {
        System.out.println("STEP 1. Open main Page");
        browser.goTo(testData.get("url").toString());
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page did not open");

        System.out.println("STEP 2 : Navigate to WebTables form");
        mainPage.clickOnCard(MainPage.Cards.ELEMENTS);
        MenuPage menuPage = new MenuPage();
        menuPage.openForm(MenuPage.Form.WEBTABLES);
        WebTablesForm webTablesForm = new WebTablesForm();
        Assert.assertTrue(webTablesForm.isPageOpen(), "WebTables form did not open");

        System.out.println("STEP 3 : Open registration form");
        RegistrationForm registrationForm = webTablesForm.switchToRegistrationForm();
    }
}
