package page_object.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainScreen {
    private AndroidDriver driver;

    public MainScreen() {
    }

    public MainScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(id = "monefyLogo")
    private WebElement logo;


    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }
}
