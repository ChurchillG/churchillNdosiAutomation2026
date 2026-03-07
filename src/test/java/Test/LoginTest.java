package Test;

import Utilities.ExcelUtils;
import Utilities.Screenshots;
import base.BaseTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LearningPage;
import pages.LoginPage;

import java.io.IOException;

import ExtentReports.Listener;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class LoginTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/testdata/testdata.xlsx";

        return ExcelUtils.getSheetData(path, "LoginData");
    }


    @Test(dataProvider = "loginData")
    public void completeNdosiFlow(String username, String password) throws Exception {

        // Step 0: Open Website
        driver.get("https://ndosisimplifiedautomation.vercel.app/");

        String openSiteShot = Screenshots.takeScreenshot(driver, "Open_Ndosi_Site");

        Listener.getTest().log(Status.INFO,
                "Opened Ndosi website",
                MediaEntityBuilder.createScreenCaptureFromPath(openSiteShot).build());


        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        String loginShot = Screenshots.takeScreenshot(driver, "Login_Success");

        Listener.getTest().log(Status.INFO,
                "User logged in successfully",
                MediaEntityBuilder.createScreenCaptureFromPath(loginShot).build());


        // Step 2 - 5: Learning Flow
        LearningPage learningPage = new LearningPage(driver);
        learningPage.completeLearningFlow();

        String learningShot = Screenshots.takeScreenshot(driver, "Learning_Flow_Completed");

        Listener.getTest().log(Status.INFO,
                "Learning flow completed",
                MediaEntityBuilder.createScreenCaptureFromPath(learningShot).build());
    }
}
