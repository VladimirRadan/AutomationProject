package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver = DriverManager.setDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/login");
        //driver.get("https://demo.opencart.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
