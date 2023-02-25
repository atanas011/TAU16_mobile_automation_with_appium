package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected AppiumDriver driver;
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
                .setPlatformVersion("10")
                .setAppPackage("io.appium.android.apis")
                .setAppActivity("ApiDemos")
                .setNoReset(true);
        driver = new AndroidDriver(service.getUrl(), options);
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