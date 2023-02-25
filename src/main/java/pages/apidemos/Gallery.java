package pages.apidemos;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

public class Gallery {

    private final AndroidDriver driver;
    private final By imageView = By.className("android.widget.ImageView");

    public Gallery(AndroidDriver driver) {
        this.driver = driver;
    }

    public void swipe() {
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        var pic1 = ElementOption.element(driver.findElements(imageView).get(0));
        var actions = new TouchAction<>(driver);

        actions.press(pic1)
                .waitAction()
                .moveTo(PointOption.point(-500, 210))
                .release()
                .perform();
    }
}