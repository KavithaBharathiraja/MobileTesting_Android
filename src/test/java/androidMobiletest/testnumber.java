package androidMobiletest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class testnumber {
	 public static void main(String[] args) throws MalformedURLException {

	        AppiumDriver driver;

	        DesiredCapabilities cp = new DesiredCapabilities();
	        cp.setCapability("platformName", "Android");
	        cp.setCapability("automationName", "UiAutomator2");
	        cp.setCapability("platformVersion", "9.0");
	        cp.setCapability("deviceName", "Pixel_3");
	        cp.setCapability("appPackage", "com.android.calculator2");
	        cp.setCapability("appActivity", "com.android.calculator2.Calculator");

	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cp);

	        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
	        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
	        driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();
	        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

	        // Get the result
	        String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
	        System.out.println("Result of 2 + 3 = " + result);

	        driver.quit();
	    }
}
