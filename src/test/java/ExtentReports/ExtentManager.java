package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {


    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;

    private static String reportPath = System.getProperty("user.dir")
            + File.separator + "target"
            + File.separator + "reports"
            + File.separator + "NdosiAutomationReport.html";

    public static ExtentReports extentReports() {

        if (extentReports == null) {

            extentReports = new ExtentReports();
            extentSparkReporter = new ExtentSparkReporter(reportPath);

            extentReports.attachReporter(extentSparkReporter);

            extentSparkReporter.config().setDocumentTitle("Extent Report For Ndosi Site");
            extentSparkReporter.config().setReportName("Ndosi Automation Report");
            extentSparkReporter.config().setTheme(Theme.DARK);

            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("User", System.getProperty("user.name"));
        }

        return extentReports;
    }
}
