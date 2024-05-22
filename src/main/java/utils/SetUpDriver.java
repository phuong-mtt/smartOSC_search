package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUpDriver {
    public static WebDriver driver;
    public  static WebDriver initializeDriver(){
        System.setProperty("webDriver.chrome.driver","/Users/pwggm/Downloads/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
    }

}
