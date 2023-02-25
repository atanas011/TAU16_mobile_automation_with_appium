package pages.apidemos;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;


public class DragAndDrop {

    private final AndroidDriver driver;
    private final By dragDot1 = By.id("drag_dot_1");
    private final By dragDot2 = By.id("drag_dot_2");

    public DragAndDrop(AndroidDriver driver) {
        this.driver = driver;
    }

    public void dragAndDrop() {
        var actions = new TouchAction<>(driver);
        var option1 = ElementOption.element(driver.findElement(dragDot1));
        var option2 = ElementOption.element(driver.findElement(dragDot2));

        actions.longPress(option1)
                .waitAction()
                .moveTo(option2)
                .release()
                .perform();
    }
}