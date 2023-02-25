package tests.apptests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class SendSmsTest extends BaseTest {

    @Test
    public void testSendSms() {
        driver.sendSMS("+381601234567", "Hello");
    }
}