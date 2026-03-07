package Utilities;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import ExtentReports.Listener;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
public class ExtentLogger {

    public static void logStep(WebDriver driver, String stepMessage) {

        try {

            // Take screenshot using Screenshots utility
            String screenshotPath = Screenshots.takeScreenshot(
                    driver,
                    stepMessage.replace(" ", "_")
            );

            // Log step with screenshot to Extent Report
            Listener.getTest().log(
                    Status.INFO,
                    stepMessage,
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
