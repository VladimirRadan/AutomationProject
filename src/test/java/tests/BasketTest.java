package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Basket;

public class BasketTest extends BaseTest{

    Basket basket;

    @BeforeMethod(alwaysRun = true)
    public void localSetup(){
        basket = new Basket(driver);
    }

    @Test
    public void basketCalculationTest(){
        basket.addProductToBasket()
                .goToBasket();
        Assert.assertEquals(basket.basketCalculation(), basket.basketTotalAmount());
    }




}
