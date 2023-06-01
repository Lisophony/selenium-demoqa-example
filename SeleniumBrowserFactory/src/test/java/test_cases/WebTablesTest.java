package test_cases;

import models.User;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.MainPage;
import page_objects.MenuPage;
import page_objects.RegistrationForm;
import page_objects.WebTablesForm;

public class WebTablesTest extends BaseTest {
    @DataProvider
    public Object[][] userData() {
        JSONArray userData = ((JSONArray) testData.get("user-data"));
        Object[][] data = new Object[userData.size()][((JSONArray) userData.get(0)).size()];
        for(int i = 0; i < userData.size(); ++i) {
            for (int j = 0; j <  ((JSONArray) userData.get(0)).size(); ++j) {
                data[i][j] = ((JSONArray) userData.get(i)).get(j);
            }
        }
        return data;
    }

    @Test(dataProvider = "userData", priority = 1)
    public void testWebTables(String firstName, String lastName, String email, String age, String salary, String department) {
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
        registrationForm.enterData(firstName, lastName, email, age, salary, department);
        registrationForm.submit();

        User expectedUser = new User(firstName, lastName, age, email, salary, department);
        User actualUser = webTablesForm.getLastUserFromTable();
        Assert.assertEquals(actualUser, expectedUser, "Users do not match");
        webTablesForm.deleteLastRecord();

        System.out.println("STEP 4 : Delete new user record from table");
        webTablesForm.deleteLastRecord();
        User lastTableUser = webTablesForm.getLastUserFromTable();
        Assert.assertNotEquals(lastTableUser, expectedUser, "User record was not deleted");
    }
}
