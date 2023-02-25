package tests.apptests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BuiltInAppDeviceTest extends BaseTest {

    private final By switchBtn = By.className("android.widget.Switch");
    private final By alertTitle = By.id("android:id/alertTitle");
    private final By okBtn = By.id("android:id/button1");

    @Test
    public void testSwitch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(switchBtn)).click();
        assertEquals(driver.findElement(alertTitle).getText(), "Updated to: Available");
        driver.findElement(okBtn).click();

        driver.findElement(switchBtn).click();
        assertTrue(wait.until(ExpectedConditions.textToBe(alertTitle, "Updated to: Unavailable")));
        driver.findElement(okBtn).click();
    }
}