package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {

    @Test
    public void swipe() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        var actions = new TouchAction((PerformsTouchActions) driver);

        WebElement pic1 = driver.findElements(By.className("android.widget.ImageView")).get(0);

        actions.press(ElementOption.element(pic1))
                .waitAction()
                .moveTo(PointOption.point(-500, 210))
                .release()
                .perform();
    }
}