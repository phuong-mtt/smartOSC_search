package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    public WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver = driver;
    }
    private By productName = By.xpath("//div[@class='pdp-productDetail__desc']");

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}
