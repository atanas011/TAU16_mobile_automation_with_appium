package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDrop() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        var actions = new TouchAction((PerformsTouchActions) driver);

        var drag = ElementOption.element(driver.findElement(By.id("drag_dot_1")));
        var drop = ElementOption.element(driver.findElement(By.id("drag_dot_2")));

        actions.longPress(drag)
                .waitAction().moveTo(drop)
                .release()
                .perform();
    }
}