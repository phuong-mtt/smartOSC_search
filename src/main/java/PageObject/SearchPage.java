package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    public WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }
    private By searchBar = By.xpath("//input[contains(@type,'search')]");
    private By removeBtn = By.xpath("//button[@title='Clear']");
    private By noResultBox = By.xpath("//div[@id='emptyNosearchBox']");
    private By resultBox = By.xpath("//div[@id='product-list']");
    private By firstItemInList = By.xpath("//li[@class='ais-Hits-item'][1]");
    private By productNameResult = By.xpath("//a[@class='sliderDesc']");

    public boolean isSearchBarDisplayed(){
        return driver.findElement(searchBar).isDisplayed();
    }
    public boolean isNoResultBoxDisplayed(){
        return driver.findElement(noResultBox).isDisplayed();
    }
    public boolean isResultBoxDisplayed(){
        return driver.findElement(resultBox).isDisplayed();
    }
    public boolean isCategoryBannerDisplayed(String category){
        return driver.findElement(By.xpath("//a[@href=\"/" +category +"\"]")).isDisplayed();
    }
    public void clickSearchBar(){
        driver.findElement(searchBar).click();
    }
    public void clickClearBtn(){
        driver.findElement(removeBtn).click();
    }
    public void clickFirstItem(){
        driver.findElement(productNameResult).click();
    }
    public void clickSuggestion(String category){
        driver.findElement(By.xpath("//a[@data-suggestion-label=\"" +category+"\"]")).click();
    }
    public void enterFullName(){
        driver.findElement(searchBar).sendKeys("CALENDULA DEEP CLEANSING FOAMING FACE WASH 230 ML GENTLE, SOOTHING FOR ALL SKIN TYPES");
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
    }
    public String getPlaceHolderInSearchBar(){
        return driver.findElement(searchBar).getAttribute("placeholder");
    }
    public String getProductNameResult(){
        return driver.findElement(productNameResult).getText();
    }
}
