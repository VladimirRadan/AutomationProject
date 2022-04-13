package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login2 extends BasePage{

    @FindBy(css = "input[name='username']")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(className = "radius")
    WebElement loginButton;

    @FindBy(id = "flash")
    WebElement expectedText;

    public Login2(WebDriver driver) {
        super(driver);
    }


    public void loginUser(String username, String password) throws InterruptedException {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        Thread.sleep(5000);
    }









}
