package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browserName) {

        if (browserName == null) {
            throw new IllegalArgumentException("Browser name cannot be null");
        }

        switch (browserName.trim().toLowerCase()) {

            case "chrome":
                return new ChromeDriver();

            case "edge":
                return new EdgeDriver();

            case "firefox":
                return new FirefoxDriver();

            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
    }

    }

