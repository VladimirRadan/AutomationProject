package tests;

import io.qameta.allure.Description;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Login;
import pages.Login2;
import utils.Utils;

import static utils.Utils.waitForSeconds;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {


    Login login;
    Login2 login2;

    @BeforeMethod
    public void localSetUp() {
         login = new Login(driver);
         login2 = new Login2(driver);
    }

//    @Test
//    public void loginUserTest(){
//        login.loginUser("tomsmith", "SuperSecretPassword!");
//        Assert.assertTrue(login.isUserLoggedIn());
//    }


    @Test(description = "Log user using Page factory")
    @Description("Login user: Expected result - User is logged in, text is present on the Welcome page")
    public void loginUser2(){
        waitForSeconds(0.2);
        driver.get("https://the-internet.herokuapp.com/login");
        login2.loginUser("tomsmith", "SuperSecretPassword!");
    }

    @Test(dataProvider = "dpTest", dataProviderClass = Utils.class)
    public void loginUserTest(String username, String password){
        login.loginUserHeroku(username, password);
        Assert.assertTrue(login.isErrorMessagePresent());
    }










}
