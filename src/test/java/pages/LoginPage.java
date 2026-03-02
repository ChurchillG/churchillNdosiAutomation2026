package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== LOCATORS =====

    // First login button on homepage
    private By homeLoginButton = By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]");

    // Login form fields
    private By usernameField = By.id("login-email");
    private By passwordField = By.id("login-password");

    // Submit login button inside form
    private By submitLoginButton = By.id("login-submit");

    // ===== ACTIONS =====

    // Step 1: Click login button on homepage
    public void clickHomeLoginButton() {
        driver.findElement(homeLoginButton).click();
    }

    // Step 2: Enter username
    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    // Step 3: Enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    // Step 4: Click submit login
    public void clickSubmitLogin() {
        driver.findElement(submitLoginButton).click();
    }

    // Combined method (optional shortcut)
    public void login(String username, String password) {
        clickHomeLoginButton();
        enterUsername(username);
        enterPassword(password);
        clickSubmitLogin();
    }
}
