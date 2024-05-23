package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverInitializer;

public class ProductPage {
    public WebDriver driver;

    public ProductPage() {
        driver = DriverInitializer.getDriver();
    }

    private By productName = By.xpath("//div[@class='pdp-productDetail__desc']");

    public String getProductName() {
        return driver.findElement(productName).getText();
    }
}
