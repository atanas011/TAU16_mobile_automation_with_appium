package tests.apptests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClipboardTest extends BaseTest {

    @Test
    public void testClipboard() {
        String text = "Hello";
        driver.setClipboardText(text);
        WebElement nameTxt = driver.findElement(
                AppiumBy.accessibilityId("my_text_fieldCD"));
        nameTxt.clear();
        nameTxt.sendKeys(driver.getClipboardText());
        Assert.assertEquals(text, nameTxt.getText());
    }
}