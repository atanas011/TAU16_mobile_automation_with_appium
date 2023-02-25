package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BuiltInAppDeviceTest {

    private AppiumDriver driver;
    private AppiumDriverLocalService service;
    private final By switchBtn = By.className("android.widget.Switch");
    private final By alertTitle = By.id("android:id/alertTitle");
    private final By okBtn = By.id("android:id/button1");

    @BeforeTest
    public void startServer() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
                .build();
        service.start();
    }

    @BeforeClass
    public void setUp() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion("10")
                // install and run Apk Info on emu/device,
                // choose the app from list and copy package/activity
                .setAppPackage("com.appcargo.driver")
                .setAppActivity("MainActivity")
                .noReset();
        driver = new AndroidDriver(service.getUrl(), options);
    }

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


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterTest
    public void stopServer() {
        service.stop();
    }
}