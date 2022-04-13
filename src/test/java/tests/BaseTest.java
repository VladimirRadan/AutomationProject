package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        driver = DriverManager.getInstance().setDriver("chrome");
        Thread.sleep(3000);
        softAssert = new SoftAssert();
        //driver.get("https://the-internet.herokuapp.com/login");
        driver.get("https://demo.opencart.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }


}
