package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    static WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        driver = DriverManager.setDriver("chrome");
        softAssert = new SoftAssert();
        //driver.get("https://the-internet.herokuapp.com/login");
        Thread.sleep(2000);
        driver.get("https://demo.opencart.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
