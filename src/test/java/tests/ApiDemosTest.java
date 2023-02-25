package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ApiDemosTest extends BaseTest {

    @Test
    public void dragAndDrop() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        var actions = new TouchAction<>(driver);

        var drag = ElementOption.element(driver.findElement(By.id("drag_dot_1")));
        var drop = ElementOption.element(driver.findElement(By.id("drag_dot_2")));

        actions.longPress(drag)
                .waitAction().moveTo(drop)
                .release()
                .perform();
    }

    @Test
    public void scroll() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                ("new UiScrollable(new UiSelector().scrollable(true).index(0))" +
                        ".scrollIntoView(new UiSelector().text(\"Lists\"))"))).click();
    }

    @Test
    public void swipe() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        var actions = new TouchAction<>(driver);

        WebElement pic1 = driver.findElements(By.className("android.widget.ImageView")).get(0);

        actions.press(ElementOption.element(pic1))
                .waitAction()
                .moveTo(PointOption.point(-500, 210))
                .release()
                .perform();
    }
}