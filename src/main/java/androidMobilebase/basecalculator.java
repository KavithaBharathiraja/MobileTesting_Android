package androidMobilebase;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;

public class basecalculator {
    protected AppiumDriver driver;

    public void setup() throws MalformedURLException {
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability("platformName", "Android");
        cp.setCapability("automationName", "UiAutomator2");
        cp.setCapability("platformVersion", "9.0");
        cp.setCapability("deviceName", "Pixel_3");
        cp.setCapability("appPackage", "com.android.calculator2");
        cp.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cp);
        
        
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
