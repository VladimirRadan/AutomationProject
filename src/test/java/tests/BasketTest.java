package tests;

import io.qameta.allure.*;
import listeners.RetryAnalyzer;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Basket;
import pages.Login;

@Listeners(TestListener.class)
public class BasketTest extends BaseTest{

    /**
     * TC #01:{@link #basketCalculationTest}
     * TC #02:{}
     */

    Basket basket;
    Login login;

    @BeforeMethod(alwaysRun = true)
    public void localSetup(){
        basket = new Basket(driver);
        login = new Login(driver);
        //login.loginUser("username", "password");
    }


//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    @Description("Basket calculation test: Expected result - amount in basket equals expected sum of amounts")
//    @Severity(SeverityLevel.CRITICAL)
//    @Epic("Epic: Basket")
//    @Story("Story: Basket Page Test")
//    public void basketCalculationTest(){
//        basket.addProductToBasket()
//                .goToBasket();
//        Assert.assertEquals(basket.basketCalculation(), basket.basketTotalAmount());
//    }







}
