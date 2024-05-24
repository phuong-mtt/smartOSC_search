package stepDefs;

import PageObject.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverInitializer;

import java.time.Duration;

public class searchStepDefs {
    private HomePage homePage = new HomePage();
    private SearchPage searchPage = new SearchPage();
    private ProductPage productPage = new ProductPage();
    private WebDriver driver = DriverInitializer.getDriver();
    public String productNameExpected = null;

    @Given("I am in Home page")
    public void i_am_in_home_page() {
        driver.get("https://www.central.co.th/en");
    }

    @Given("I close pop-up ads")
    public void i_close_pop_up_ads() {
        homePage.clickClosePopUpBtn();
    }

    @When("search bar is displayed on the top of Home page")
    public void search_bar_is_displayed_on_the_top_of_home_page() {
        Assert.assertTrue("Not display", searchPage.isSearchBarDisplayed());
    }

    @Then("I see text {string} as placeholder")
    public void i_see_text_as_placeholder(String placeholder) {
        Assert.assertEquals(placeholder, searchPage.getPlaceHolderInSearchBar());
    }

    @When("I click search bar")
    public void i_click_search_bar() {
        searchPage.clickSearchBar();
    }

    @Then("I should navigate to search url")
    public void i_should_navigate_to_search_url() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://www.central.co.th/en/search/", currentURL);
    }

    @When("I fill search bar by entering full product name")
    public void i_enter_full_product_name() {
        searchPage.enterFullName();

    }

    @Then("I should see that product in result page")
    public void i_should_see_that_product_in_result_page() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> searchPage.isResultBoxDisplayed());
        Assert.assertTrue(searchPage.isResultBoxDisplayed());
        productNameExpected = searchPage.getProductNameResult();
    }

    @When("I click that product")
    public void i_click_that_product() throws Throwable {
        searchPage.clickFirstItem();
    }

    @Then("I see product's name same as my text entered")
    public void i_see_product_s_name_same_as_my_text_entered() {

        Assert.assertEquals(productNameExpected.toLowerCase(), productPage.getProductName().toLowerCase());
    }

    @When("I enter partial product name")
    public void i_enter_partial_product_name() {
    }

    @Then("I should see those products in result page")
    public void i_should_see_those_products_in_result_page() {
    }

    @When("I fill some texts")
    public void i_fill_some_texts() {
        searchPage.enterFullName();
    }

    @When("I click remove icon")
    public void i_click_remove_icon() {
        searchPage.clickClearBtn();
    }

    @Then("I don't see text I have entered")
    public void i_don_t_see_text_i_have_entered() {
    }

    @Then("I don't see any products in result page")
    public void i_don_t_see_any_products_in_result_page() {
        Assert.assertTrue(searchPage.isNoResultBoxDisplayed());
    }

    @When("I click {string} in suggestion")
    public void i_click_category_in_suggestion(String category) {
        searchPage.clickSuggestion(category);
    }

    @Then("I see products in {string} category")
    public void i_see_products_in__category(String category) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> searchPage.isResultBoxDisplayed());
        Assert.assertTrue(searchPage.isCategoryBannerDisplayed(category));
    }

    @When("^I enter (.+)$")
    public void i_enter_character(String charType) {
    }

}
