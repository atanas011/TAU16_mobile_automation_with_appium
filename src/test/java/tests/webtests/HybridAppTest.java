package tests.webtests;

import io.appium.java_client.AppiumBy;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.base.BaseWebTest;

public class HybridAppTest extends BaseWebTest {

    private final By chromeBtn = AppiumBy.accessibilityId("buttonStartWebviewCD");
    private final By nameInput = By.xpath("/hierarchy/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout" +
            "/android.widget.TableRow[4]/android.webkit.WebView/android.webkit.WebView" +
            "/android.view.View/android.widget.EditText");
    private final By gotoHomeBtn = By.id("goBack");

    @Test
    public void testHybridApp() {
        driver.findElement(chromeBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(chromeBtn));
//        switchToWebView();
        driver.findElement(nameInput).clear(); // id("name_input") doesn't work
        driver.findElement(nameInput).sendKeys("Ana");
//        driver.context("NATIVE_APP");
        driver.findElement(gotoHomeBtn).click();
    }

    // NO WEBVIEW context !!!
    private void switchToWebView() {
        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            System.out.println("Context1: " + context);
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                System.out.println("Context2: " + context);
                break;
            }
        }
    }
}