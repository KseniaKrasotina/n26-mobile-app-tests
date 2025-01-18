import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;

public class LaunchAppTests extends BaseDriver {

    @BeforeEach
    void setUp() throws MalformedURLException {
        setupDriver();
    }

    @AfterEach
    void tearDown() {
        tearDownDriver();
    }

    @Test
    @DisplayName("Launch Monefy app")
    public void testAppLaunch() {
        assertTrue(driver.findElement(AppiumBy.className("androidx.viewpager.widget.ViewPager")).isDisplayed());
    }

    @Test
    @DisplayName("Open next Wizard step")
    public void nextWizardStep() throws InterruptedException {
        driver.findElement(AppiumBy.id("buttonContinue")).click();
    }
}
