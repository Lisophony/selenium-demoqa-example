package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.MainPage;
import utils.JsonUtil;

public class TestCase1 extends BaseTest {
    @Test
    public void test1() {
        String url = JsonUtil.getJson("src/test/resources/test.json").get("url").toString();
        browser.goTo(url);
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page did not open");
        mainPage.clickOnCard(MainPage.Cards.ALERTS);
    }
}
