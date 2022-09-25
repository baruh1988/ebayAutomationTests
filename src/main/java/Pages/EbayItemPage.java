package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EbayItemPage {

    @FindBy(css = "select[id^=\"msku-sel-\"]")
    private static List<WebElement> itemSelectionOptions;

    @FindBy(css = "#isCartBtn_btn")
    private static WebElement addToCartBtn;

    @FindBy(css = "#qtyTextBox")
    private static WebElement qtyInput;

    @FindBy(css = ".x-item-title span")
    private static WebElement itemTitle;

    public static List<WebElement> getItemSelectionOptions() {
        return itemSelectionOptions;
    }

    public static WebElement getAddToCartBtn() {
        return addToCartBtn;
    }

    public static WebElement getQtyInput() {
        return qtyInput;
    }

    public static WebElement getItemTitle() {
        return itemTitle;
    }

}
