package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage {

    By searchInputSelector;
    By searchBtnSelector;
    By resultsSelector;
    By resultsCountSelector;
    By addToCartBtnSelector;
    By itemTitleSelector;
    By countryFilterSelector;
    By itemLocationSelector;

    public SearchPage(WebDriver driver) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(5)));
        initBys();
    }

    public void initBys() {
        searchInputSelector = By.cssSelector("#gh-ac");
        searchBtnSelector = By.cssSelector("#gh-btn");
        resultsSelector = By.cssSelector(".srp-results>li[data-view]");
        resultsCountSelector = By.cssSelector(".srp-controls__count-heading span:first-child");
        addToCartBtnSelector = By.cssSelector("#isCartBtn_btn");
        itemTitleSelector = By.cssSelector(".x-item-title__mainTitle");
        countryFilterSelector = By.cssSelector("[data-value=\"US Only\"]");
        itemLocationSelector = By.cssSelector(".s-item__location");
    }

    public By getSearchInputSelector() {
        return searchInputSelector;
    }

    public By getSearchBtnSelector() {
        return searchBtnSelector;
    }

    public By getResultsSelector() {
        return resultsSelector;
    }

    public By getResultsCountSelector() {
        return resultsCountSelector;
    }

    public By getAddToCartBtnSelector() {
        return addToCartBtnSelector;
    }

    public By getItemTitleSelector() {
        return itemTitleSelector;
    }

    public void performSearch(String term) {
        visit("https://www.ebay.com/");
        typeInto(term, searchInputSelector);
        click(searchBtnSelector);
        waitUntilElementsPresent(resultsCountSelector);
    }

    public void filterByCountry() {
        waitUntilElementsPresent(countryFilterSelector);
        click(countryFilterSelector);
    }

    public boolean checkAllItemsLocation(String location) {
        for (WebElement curr : findElements(itemLocationSelector)) {
            if (!curr.getText().contains(location)) {
                return false;
            }
        }
        return true;
    }

}
