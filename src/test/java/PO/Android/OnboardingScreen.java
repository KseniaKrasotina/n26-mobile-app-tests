package PO.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;

public class OnboardingScreen {
    private AndroidDriver driver;

    public OnboardingScreen() {
    }

    public OnboardingScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(id = "actionButton")
    private WebElement action_button;


    public boolean isActionButtonDisplayed() {
        return action_button.isDisplayed();
    }
}
