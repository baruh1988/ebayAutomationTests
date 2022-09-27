package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EbaySearchResultsPage {

    @FindBy(css = "#srp-river-results .s-item__link")
    private static List<WebElement> results;

    @FindBy(xpath = "//a/span[text()='Buy It Now']")
    private static WebElement filterBuyNow;

    public static List<WebElement> getResults() {
        return results;
    }

    public static WebElement getFilterBuyNow() {
        return filterBuyNow;
    }

}
