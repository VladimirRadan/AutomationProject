package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    public BasePage(WebDriver driver){
        faker = new Faker();
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    protected WebElement getElement(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        //return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    protected void typeIn(By locator, String text){
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clickOnElement(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected String getTextFromElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
    }

    protected boolean isElementDisplayed(By locator){
        boolean isElementVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        if (isElementVisible){
            System.out.println("PASSED ----- Element je prisutan!!!" );
            return true;
        }else {
            System.out.println("FAILED ----- Element nije Prisutan!!!" );
        }
        return false;
    }

    protected boolean matchesExpectedText(By locator, String expectedText){
        WebElement element = getElement(locator);
        if (element.getText().trim().equals(expectedText)){
            System.out.println("Tekst u elementu: " + element.getText() + " je jednak ocekivanom tekstu!" );
            return true;
        }else {
            System.out.println("Tekst u elementu: " + element.getText() + " nije jednak ocekivanom tekstu!" );
        }
        return false;
    }

    protected double getAmountByRegex(String value){
        return Double.parseDouble(value.replaceAll("[^\\d.]", ""));
    }




}
