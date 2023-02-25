package tests.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.*;

public class BaseWebTest {

    protected AndroidDriver driver;
    private AppiumDriverLocalService service;

    @BeforeTest
    public void startServer() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
                .usingAnyFreePort()
                .withArgument(() -> "--allow-insecure", "chromedriver_autodownload")
                .build();
        service.start();
    }

    @BeforeClass
    @Parameters({"version", "avd", "browser", "pack", "activity"})
    public void setUp(String version, String avd, String browser, String pack, String activity) {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion(version)
                .setAvd(avd)
                .withBrowserName(browser)
                .setAppPackage(pack)
                .setAppActivity(activity)
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