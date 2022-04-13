package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Basket;
import pages.Login;


public class BasketTest extends BaseTest{

    Basket basket;
    Login login;

    @BeforeMethod(alwaysRun = true)
    public void localSetup(){
        basket = new Basket(driver);
        login = new Login(driver);
        //login.loginUser("username", "password");
    }


    @Test
    public void basketCalculationTest(){
        basket.addProductToBasket()
                .goToBasket();
        Assert.assertEquals(basket.basketCalculation(), basket.basketTotalAmount());
    }







}
