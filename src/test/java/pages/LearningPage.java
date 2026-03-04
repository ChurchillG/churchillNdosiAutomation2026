package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LearningPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LearningPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By learnDropdown = By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]");
    private By learningMaterialOption = By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]");
    private By webAutomationAdvanceButton =
            By.xpath("//*[@id=\"tab-btn-web\"]");
    private By inventoryFormRequirementsButton =
            By.xpath("//*[@id=\"assessment-instructions\"]/summary");

    public void completeLearningFlow() {

        driver.findElement(learnDropdown).click();
        driver.findElement(learningMaterialOption).click();
        driver.findElement(webAutomationAdvanceButton).click();
        driver.findElement(inventoryFormRequirementsButton).click();
    }
}
