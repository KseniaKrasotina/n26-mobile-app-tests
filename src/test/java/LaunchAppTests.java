import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.time.Duration;

public class LaunchAppTests extends BaseDriver {

    @BeforeEach
    void setUp() throws MalformedURLException {
        setupDriver();

//        Activity activity = new Activity("com.monefy.app.lite", "com.monefy.activities.main.MainActivity_");
//        ((AndroidDriver) driver).startActivity(activity);


    }

//    @AfterEach
//    void tearDown() {
//        tearDownDriver();
//    }

    @Test
    public void testAppLaunch() {
        assertTrue(driver.findElement(AppiumBy.className("androidx.viewpager.widget.ViewPager")).isDisplayed());
//        driver.findElement(AppiumBy.id("buttonContinue")).click();
    }

    @Test
    public void nextActivity() throws InterruptedException {
        driver.findElement(AppiumBy.id("buttonContinue")).click();
    }

    @AndroidFindBy(id = "buttonContinue")
    private WebElement ContinueButton;

    public void clickContinue() throws InterruptedException {
        ContinueButton.click();
    }


}

