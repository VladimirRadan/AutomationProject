package tests;

import driver.DriverManager;
import core.Environment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import static utils.Utils.waitForSeconds;

public class BaseTest {

    WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverManager.getInstance().setDriver();
        softAssert = new SoftAssert();
        new Environment(driver).openBrowser();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }


}
