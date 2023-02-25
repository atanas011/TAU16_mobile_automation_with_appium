package tests.apptests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class BuiltInAppEmuTest extends BaseTest {

    @Test
    public void testAdd() {
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_3")).click();
        driver.findElement(By.id("eq")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "4");
    }
}