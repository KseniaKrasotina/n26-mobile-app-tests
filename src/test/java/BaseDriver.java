import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.Attachment;

import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseDriver {
    protected AppiumDriver driver;

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    protected WebDriverWait wait;

    protected void setupDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Android Emulator")
                .setFullReset(true)
                .setAppPackage("com.monefy.app.lite")
                .setApp("src/test/resources/com.monefy.app.lite.apk")
                .setApp("/Users/kkrasotina/IdeaProjects/n26/n26-mobile-app-tests/src/test/resources/com.monefy.app.lite.apk")
                .setAppActivity("com.monefy.activities.main.MainActivity_")

                .amend("appium:intentAction", "android.intent.action.MAIN")
                .amend("appium:intentCategory", "android.intent.category.LAUNCHER")
                .amend("appium:dontStopAppOnReset", true)

                .setAutoGrantPermissions(true);


        URL appUrl = getClass().getClassLoader().getResource("com.monefy.app.lite.apk");
        if (appUrl != null) {
            String appPath = appUrl.getFile();
            options.setApp(appPath);
        } else {
            throw new IllegalStateException("App file not found");
        }


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

//    @After
//    public void tearDownDriver(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            saveScreenshot();
//        }
//        if (driver != null) {
//            driver.quit();
//        }
}


