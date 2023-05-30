package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

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
        menuPage.openForm(MenuPage.Form.NESTEDFRAMES);
        NestedFramesForm nestedFramesForm = new NestedFramesForm();
        Assert.assertTrue(nestedFramesForm.isPageOpen(), "NestedFrames form was not open");

        System.out.println("STEP 3: Switch to parent iframe form");
        ParentFrameForm parentFrameForm = nestedFramesForm.switchToParentIFrame();
        Assert.assertTrue(parentFrameForm.isPageOpen(), "Driver has not switched to Parent iframe");

        System.out.println("STEP 4 : Switch ti child frame");
        ChildFrameForm childFrameForm = parentFrameForm.switchToChildFrameForm();
        Assert.assertTrue(childFrameForm.isPageOpen(), "Driver has not switched to child iframe");

        System.out.println("STEP 5: Switch to default content");
        browser.switchToDefaultContent();
        Assert.assertTrue(nestedFramesForm.isPageOpen(), "Driver has not switched to default content");

        System.out.println("STEP 6 : Navigate to Frames form");
        menuPage.openForm(MenuPage.Form.FRAMES);
        FramesForm framesForm = new FramesForm();

    }
}
