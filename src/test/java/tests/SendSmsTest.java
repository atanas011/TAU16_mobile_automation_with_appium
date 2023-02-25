package tests;

import org.testng.annotations.Test;

public class SendSmsTest extends BaseTest {

    @Test
    public void testSendSms() {
        driver.sendSMS("+381601234567", "Hello");
    }
}