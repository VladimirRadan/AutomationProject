package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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


    public Basket addProductToBasket(){
        clickOnElement(desktopMenu);
        clickOnElement(showDesktops);
        clickOnElement(productCartIcon);
        return this;
    }

    public Basket goToBasket(){
        clickOnElement(shoppingCartIcon);
        return this;
    }

    public double basketCalculation(){
        double subtotal = getAmountByRegex(getTextFromElement(subTotalAmount));
        double ecoTax = getAmountByRegex(getTextFromElement(ecoTaxAmount));
        double vat = getAmountByRegex(getTextFromElement(vatAmount));
        return subtotal + ecoTax - vat;
    }

    public double basketTotalAmount(){
        return getAmountByRegex(getTextFromElement(totalAmount));
    }




}
