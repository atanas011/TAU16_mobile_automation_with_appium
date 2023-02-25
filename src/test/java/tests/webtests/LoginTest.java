package tests.webtests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.base.BaseWebTest;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseWebTest {

    @Test
    public void testLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        assertTrue(wait.until(ExpectedConditions.urlContains("secure")));
    }
}