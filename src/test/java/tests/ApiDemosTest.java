package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiDemosTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10"); // "9" for emu
//        caps.setCapability("deviceName", "Redmi 7A");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");
        caps.setCapability("noReset", "true"); // for physical device (skips permissions' prompt)
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void clickAppButton() {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}