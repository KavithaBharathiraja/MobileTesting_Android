package androidMobiletest;

import androidMobilebase.basecalculator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import utils.ExtentManager;

public class TestCalculator extends basecalculator {

    @BeforeClass
    public void setUp() throws Exception {
        setup();
        ExtentManager.createTest("Calculator Test", "Test for addition operation");
    }

    @Test
    public void testAddition() {
        ExtentManager.getTest().log(Status.INFO, "Starting addition test");

        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

        String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        ExtentManager.getTest().log(Status.INFO, "Result of 2 + 3 = " + result);
        Assert.assertEquals(result, "5");

        ExtentManager.getTest().log(Status.PASS, "Addition test passed");
    }

    @AfterClass
    public void tearDown() {
        ExtentManager.getInstance().flush();
        super.tearDown();
    }
}
