package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Register;

public class RegisterTest extends BaseTest{

    Register register;

    @BeforeMethod(alwaysRun = true)
    public void localSetup(){
        register = new Register(driver);
    }

    @Test()
    public void registerUserTest(){
        register.goToRegisterPage()
                .registerUser();
        softAssert.assertTrue(register.isUserRegistered());
        softAssert.assertTrue(register.isLogoutButtonPresent());
        softAssert.assertAll();
    }



}
