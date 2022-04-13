package tests;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Login;
import pages.Login2;

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


    @Test
    public void loginUser2() throws InterruptedException {
        login2.loginUser("tomsmith", "SuperSecretPassword!");
    }

}
