package tests;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollTest extends BaseTest {

    @Test
    public void testScroll() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                ("new UiScrollable(new UiSelector().scrollable(true).index(0))" +
                        ".scrollIntoView(new UiSelector().text(\"Lists\"))"))).click();
    }
}