package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {

    By itemSelector;
    By itemPriceSelector;
    By removeItemBtnSelector;
    By cartTotalPriceSelector;
    By cartShippingPriceSelector;
    By cartSubTotalPriceSelector;
    By itemCountSelector;
    By itemRemovedMsgSelector;
    By itemShippingSelector;

    public CartPage(WebDriver driver) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(5)));
        initBys();
    }

    public void initBys() {
        itemSelector = By.cssSelector("[data-test-id=\"cart-bucket\"]");
        itemPriceSelector = By.cssSelector(".item-price");
        removeItemBtnSelector = By.cssSelector("[aria-label^=\"Remove - \"]");
        cartTotalPriceSelector = By.cssSelector("[data-test-id=\"ITEM_TOTAL\"]>span>span>span");
        cartShippingPriceSelector = By.cssSelector("[data-test-id=\"SHIPPING\"]>span>span>span");
        itemCountSelector = By.cssSelector(".table>div>div>span>span>span");
        itemRemovedMsgSelector = By.cssSelector(".page-notice--confirmation");
        cartSubTotalPriceSelector = By.cssSelector("[data-test-id=\"SUBTOTAL\"]>span>span>span");
        itemShippingSelector = By.cssSelector(".logistics-costs");
    }

    public By getItemSelector() {
        return itemSelector;
    }

    public By getItemPriceSelector() {
        return itemPriceSelector;
    }

    public By getRemoveItemBtnSelector() {
        return removeItemBtnSelector;
    }

    public By getCartTotalPriceSelector() {
        return cartTotalPriceSelector;
    }

    public By getCartShippingPriceSelector() {
        return cartShippingPriceSelector;
    }

    public By getCartSubTotalPriceSelector() {
        return cartSubTotalPriceSelector;
    }

    public By getItemCountSelector() {
        return itemCountSelector;
    }

    public By getItemShippingSelector() {
        return itemShippingSelector;
    }

    public By getItemRemovedMsgSelector() {
        return itemRemovedMsgSelector;
    }

    public void removeItem() {
        waitUntilElementsPresent(itemSelector);
        findElement(itemSelector).findElement(removeItemBtnSelector).click();
        waitUntilVisibilityElementLocated(itemRemovedMsgSelector);
    }

    public String addItem(SearchPage searchPage, String term) {
        searchPage.performSearch(term);
        searchPage.filterByCountry();
        findElement(searchPage.getResultsSelector()).findElement(new By.ByTagName("img")).click();
        getDriver().getWindowHandles().forEach(tab -> getDriver().switchTo().window(tab));
        String result = searchPage.getText(searchPage.getItemTitleSelector());
        searchPage.waitUntilElementsPresent(searchPage.getAddToCartBtnSelector());
        searchPage.click(searchPage.getAddToCartBtnSelector());
        waitUntilUrlContains("https://cart.payments.ebay.com/");
        return result;
    }

    public double getCalculatedItemPrice() {
        double res = 0;
        for (WebElement curr : findElements(itemPriceSelector)) {
            res += Double.parseDouble(curr.getText().replaceAll("[^\\d.]", ""));
        }
        for (WebElement curr : findElements(itemShippingSelector)) {
            res += curr.getText().equals("Free shipping") ? 0 : Double.parseDouble(curr.getText().replaceAll("[^\\d.]", ""));
        }
        return res;
    }

    public double getCalculatedCartPrice() {
        double res = 0;
        res += Double.parseDouble(getText(cartTotalPriceSelector).replaceAll("[^\\d.]", ""));
        res += getText(cartShippingPriceSelector).equals("Free") ? 0 : Double.parseDouble(getText(cartShippingPriceSelector).replaceAll("[^\\d.]", ""));
        return res;
    }

    public boolean checkPrices() {
        return getCalculatedItemPrice() == getCalculatedCartPrice() && getCalculatedItemPrice() == Double.parseDouble(getText(cartSubTotalPriceSelector).replaceAll("[^\\d.]", ""));
    }

}
