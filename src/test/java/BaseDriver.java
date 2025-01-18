import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseDriver {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    protected void setupDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Android Emulator")
                .setFullReset(true)
                .setAppPackage("com.monefy.app.lite")
                .setAppActivity("com.monefy.activities.main.MainActivity_")
                .setApp("/Users/kkrasotina/IdeaProjects/n26/n26-mobile-app-tests/src/test/resources/com.monefy.app.lite.apk")
                .setAutoGrantPermissions(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
