package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage{

    By passwordField = By.name("password");
    By usernameField = By.cssSelector("input[name='username']");
    By loginButton = By.className("radius");
    By expectedLoggedInElement = By.id("flash");



    public Login(WebDriver driver) {
        super(driver);
    }

    //HomePage
    public void loginUser(String username, String password){
        typeIn(usernameField, username);
        typeIn(passwordField, password);
        clickOnElement(loginButton);
    }


    public boolean isUserLoggedIn(){
        String actual[] = getElement(expectedLoggedInElement).getText().split("(?<=!)"); //regex
        String actualtext = actual[0];
        String actualBackgroundColor = getElement(expectedLoggedInElement).getCssValue("background-color");
        String expectedText = "You logged into a secure area!";
        String expectedColor = "rgba(93, 164, 35, 1)";
        if (expectedText.equals(actualtext)
                && actualBackgroundColor.equals(expectedColor)){
             return true;
        }
        return false;
    }

}
