package pages.apidemos;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Views {

    private final AndroidDriver driver;
    private final By dragAndDrop = AppiumBy.accessibilityId("Drag and Drop");
    private final By gallery = AppiumBy.accessibilityId("Gallery");

    public Views(AndroidDriver driver) {
        this.driver = driver;
    }

    public DragAndDrop openDragAndDrop() {
        driver.findElement(dragAndDrop).click();
        return new DragAndDrop(driver);
    }

    public Gallery openGallery() {
        driver.findElement(gallery).click();
        return new Gallery(driver);
    }

    public void scrollDown() {
        driver.findElement(AppiumBy.androidUIAutomator(
                ("new UiScrollable(new UiSelector().scrollable(true).index(0))" +
                        ".scrollIntoView(new UiSelector().text(\"Lists\"))"))).click();
    }
}