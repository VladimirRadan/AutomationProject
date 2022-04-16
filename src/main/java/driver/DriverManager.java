package driver;

import core.OptionsManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Utils;

import java.time.Duration;

import static core.OptionsManager.*;
import static utils.Utils.dotEnv;

public class DriverManager {

    private DriverManager(){}

    private static final DriverManager instance = new DriverManager();

    public static DriverManager getInstance(){
        return instance;
    }

    private WebDriver driver;
    private String browser = dotEnv().get("BROWSER");

    public WebDriver setDriver(){
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Utils.waitForSeconds(2);
        driver.manage().window().maximize();
        return driver;
    }



}
