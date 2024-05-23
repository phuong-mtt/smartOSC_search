package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUpDriver {
    public static WebDriver driver;
    public static WebDriver initializeDriver(){
        return getDriver();
    }

    public static void closeDriver(){
        getDriver().quit();
    }

    public static WebDriver getDriver(){
        System.setProperty("webDriver.chrome.driver","/Users/pwggm/Downloads/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
