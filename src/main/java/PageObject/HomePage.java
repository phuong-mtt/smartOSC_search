package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverInitializer;

public class HomePage {
    public WebDriver driver;
    public HomePage(){
        driver = DriverInitializer.getDriver();
    }
    private By closePopUpBtn = By.xpath("//span[normalize-space()='×']");
    public void clickClosePopUpBtn(){
        driver.findElement(closePopUpBtn).click();
    }
}
