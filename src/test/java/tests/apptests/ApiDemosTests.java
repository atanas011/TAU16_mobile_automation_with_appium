package tests.apptests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.apidemos.Home;
import pages.apidemos.Views;
import tests.base.BaseTest;

public class ApiDemosTests extends BaseTest {

    private Views views;

    @BeforeMethod
    public void openViews() {
        views = new Home(driver).openViews();
    }

    @Test
    public void testDragAndDrop() {
        views.openDragAndDrop().dragAndDrop();
    }

    @Test
    public void testScrollDown() {
        views.scrollDown();
    }

    @Test
    public void testSwipe() {
        views.openGallery().swipe();
    }
}