package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

public class TestIFrames extends BaseTest {
    @Test(priority = 2)
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
        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(framesPage.isPageOpen(), "Frames page was not open");

        System.out.println("STEP 7 :Switch to iframe1 and get text from heading");
        Frame1Form frame1Form = framesPage.switchToFrame1();
        Assert.assertTrue(frame1Form.isPageOpen(), "Driver has not switched to Frames1 form");
        String frame1FormHeading = frame1Form.getHeadingText();

        System.out.println("STEP 8 :Switch to iframe2 and get text from heading");
        browser.switchToDefaultContent();
        Frame2Form frame2Form = framesPage.switchToFrame2();
        Assert.assertTrue(frame2Form.isPageOpen(), "Driver has not switched to Frames2 form");
        String frame2FormHeading = frame2Form.getHeadingText();
        Assert.assertEquals(frame1FormHeading, frame2FormHeading, "Frames heading do not match");
    }
}
