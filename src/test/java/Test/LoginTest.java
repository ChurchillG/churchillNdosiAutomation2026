package Test;
import Utilities.ExcelUtils;
import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LearningPage;
import pages.LoginPage;

import java.io.IOException;

public class LoginTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/testdata/testdata.xlsx";

        return ExcelUtils.getSheetData(path, "LoginData");
    }


    @Test(dataProvider = "loginData")
    public void completeNdosiFlow(String username, String password) {

        driver.get("https://ndosisimplifiedautomation.vercel.app/");

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Step 2 - 5
        LearningPage learningPage = new LearningPage(driver);
        learningPage.completeLearningFlow();
    }
}
