package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EbayCartPage {

    @FindBy(css = ".item-price")
    private static List<WebElement> itemPrices;

    @FindBy(css = ".logistics-costs")
    private static List<WebElement> itemShippingPrices;

    @FindBy(css = "[data-test-id=\"cart-remove-item\"]")
    private static List<WebElement> removeItems;

    @FindBy(css = "[data-test-id=\"SUBTOTAL\"]")
    private static WebElement subTotal;

    @FindBy(css = ".page-notice--confirmation")
    private static WebElement itemRemovedMessage;

    public static List<WebElement> getItemPrices() {
        return itemPrices;
    }

    public static List<WebElement> getItemShippingPrices() {
        return itemShippingPrices;
    }

    public static List<WebElement> getRemoveItems() {
        return removeItems;
    }

    public static WebElement getSubTotal() {
        return subTotal;
    }

    public static WebElement getItemRemovedMessage() {
        return itemRemovedMessage;
    }

}
