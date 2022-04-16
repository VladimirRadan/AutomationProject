package core;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {


    public static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        //options.addArguments("headless");
        //options.addArguments("window-size=1920,1080");
        options.addArguments("--disable-popup-blocking");
        return options;
    }

    public static FirefoxOptions getFirefoxOptions(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("headless");
        //options.addArguments("window-size=1920,1080");
        options.addArguments("--disable-popup-blocking");
        return options;
    }




}
