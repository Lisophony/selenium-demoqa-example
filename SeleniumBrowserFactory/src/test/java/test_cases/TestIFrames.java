package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.MainPage;
import page_objects.MenuPage;

public class TestIFrames extends BaseTest {
    @Test
    public void testIFrames() {
        System.out.println("STEP 1. Open main Page");
        browser.goTo(testData.get("url").toString());
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page did not open");

        System.out.println("STEP 2. Navigate to Frames form");
        mainPage.clickOnCard(MainPage.Cards.ALERTS);
        MenuPage menuPage = new MenuPage();
        menuPage.openForm(MenuPage.Form.FRAMES);
        int i = 0;


    }
}
