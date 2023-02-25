package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class BuiltInAppEmuTest {

    private AppiumDriver driver;
    private AppiumDriverLocalService service;

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
                .setPlatformVersion("9")
                .setAvd("Pixel_XL_API_28")
                // install and run Apk Info on emu/device,
                // choose the app from list and copy package/activity
                .setAppPackage("com.android.calculator2")
                .setAppActivity("Calculator");
        driver = new AndroidDriver(service.getUrl(), options);
    }

    @Test
    public void testAdd() {
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_3")).click();
        driver.findElement(By.id("eq")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "4");
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