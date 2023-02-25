package pages.apidemos;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Home {

    private final AndroidDriver driver;
    private final By views = AppiumBy.accessibilityId("Views");

    public Home(AndroidDriver driver) {
        this.driver = driver;
    }

    public Views openViews() {
        driver.findElement(views).click();
        return new Views(driver);
    }
}