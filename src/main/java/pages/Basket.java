package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Basket extends BasePage{

    private By desktopMenu = By.xpath("//a[text()='Desktops']");
    private By showDesktops = By.xpath("//a[text()='Show All Desktops']");
    private By productCartIcon = By.xpath("//a[text()='MacBook']/../../..//button[1]");

    private By shoppingCartIcon = By.cssSelector("a[title='Shopping Cart']");

    private By subTotalAmount = By.xpath("//strong[text()='Sub-Total:']/../../td[2]");
    private By ecoTaxAmount = By.xpath("//strong[text()='Eco Tax (-2.00):']/../../td[2]");
    private By vatAmount = By.xpath("//strong[text()='VAT (20%):']/../../td[2]");
    private By totalAmount = By.xpath("//strong[text()='Total:']/../../td[2]");


    public Basket(WebDriver driver) {
        super(driver);
    }


    @Step("Add product to basket")
    public Basket addProductToBasket(){
        //clickOnElement(desktopMenu);
        moveToElementAndClick(desktopMenu);
        clickOnElement(showDesktops);
        clickOnElement(productCartIcon);
        return this;
    }

    protected void moveToElementAndClick(By locator){
        Actions actions = new Actions(driver);
        WebElement element = getElement(locator);
        actions.moveToElement(element)
                .click()
                .build()
                .perform();
    }



    @Step("Go to basket by clicking button in header")
    public Basket goToBasket(){
        clickOnElement(shoppingCartIcon);
        return this;
    }

    @Step("Calculate basket amount")
    public double basketCalculation(){
        double subtotal = getAmountByRegex(getTextFromElement(subTotalAmount));
        double ecoTax = getAmountByRegex(getTextFromElement(ecoTaxAmount));
        double vat = getAmountByRegex(getTextFromElement(vatAmount));
        return subtotal + ecoTax - vat;
    }

    @Step("Get total amount from webelement")
    public double basketTotalAmount(){
        return getAmountByRegex(getTextFromElement(totalAmount));
    }




}
