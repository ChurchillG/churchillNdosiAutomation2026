
package ExtentReports;

import Utilities.Screenshots;
import base.BaseTest;

import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.testng.*;


public class Listener implements ITestListener {
    private static ExtentReports extent = ExtentManager.extentReports();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();


    @Override
    public void onStart(ITestContext context) {
        extent = ExtentManager.extentReports();
    }


    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = extent.createTest(result.getMethod().getMethodName());

        extentTest.set(test);
    }


    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().log(Status.PASS,
                "Test Case " + result.getMethod().getMethodName() + " PASSED");
    }


    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().log(Status.FAIL,
                "Test Case " + result.getMethod().getMethodName() + " FAILED");

        try {

            // Get the test instance
            BaseTest test = (BaseTest) result.getInstance();

            // Get driver from BaseTest
            WebDriver driver = test.getDriver();

            // Take screenshot using Screenshots utility
            String screenshotPath = Screenshots.takeScreenshot(driver,
                    result.getMethod().getMethodName());

            // Attach screenshot to Extent Report
            extentTest.get().fail("Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().log(Status.SKIP,
                "Test Case " + result.getMethod().getMethodName() + " SKIPPED");
    }


    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }


    // Allows tests to log steps in the report
    public static ExtentTest getTest() {
        return extentTest.get();
    }
}





