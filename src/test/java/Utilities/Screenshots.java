package Utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Screenshots {
    private static final String screenshotDir = System.getProperty("user.dir")
            + File.separator + "target"
            + File.separator + "screenshots";

    public static String takeScreenshot(WebDriver driver, String screenshotName) {

        File directory = new File(screenshotDir);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String fileName = screenshotName + "_" + timestamp + ".png";

        File destination = new File(directory, fileName);

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src, destination);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination.getAbsolutePath();
    }
}

