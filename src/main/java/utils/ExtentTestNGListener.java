package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestNGListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 4 Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Extent Reports Version 4 Test Suite ended!");
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        test.set(extentTest);
        System.out.println(result.getMethod().getMethodName() + " started!");
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
        System.out.println(result.getMethod().getMethodName() + " passed!");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
        System.out.println(result.getMethod().getMethodName() + " failed!");
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
        System.out.println(result.getMethod().getMethodName() + " skipped!");
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }
}
