package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {
    @FindBy(xpath = "//input[@data-testid='login-email']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@data-testid='login-password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@data-testid='login-submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//ul[@id='parsley-id-5']")
    private List<WebElement> parsleyErrorLogin;
    @FindBy(xpath = "//ul[@id='parsley-id-7']")
    private List<WebElement> parsleyErrorPassword;
    private final WebDriverWait wait;
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }
    public void authorize(String login, String password){
        wait.until(ExpectedConditions.visibilityOf(loginField)).sendKeys(login);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    public void authorizeWithoutPassword(String login){
        wait.until(ExpectedConditions.visibilityOf(loginField)).sendKeys(login);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    public List<WebElement> getParsleyErrorLogin() {
        return this.parsleyErrorLogin;
    }
    public List<WebElement> getParsleyErrorPassword() {
        return this.parsleyErrorPassword;
    }

}
