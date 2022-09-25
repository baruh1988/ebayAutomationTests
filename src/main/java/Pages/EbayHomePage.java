package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbayHomePage {

    @FindBy(css = "#gh-ac")
    private static WebElement searchField;

    @FindBy(css = "#gh-ug")
    private static WebElement signInLink;

    @FindBy(css = "#gh-ug-flex")
    private static WebElement registerLink;

    @FindBy(css = "gh-btn")
    private static WebElement searchBtn;

    @FindBy(css = "gh-cat")
    private static WebElement categorySelect;

    @FindBy(css = ".gh-cart-icon")
    private static WebElement cartLink;

    @FindBy(css = "#gh-logo")
    private static WebElement logo;

    @FindBy(css = "#gh-ug>b")
    private static WebElement userMsg;

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSignInLink() {
        return signInLink;
    }

    public WebElement getRegisterLink() {
        return registerLink;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }

    public WebElement getCategorySelect() {
        return categorySelect;
    }

    public WebElement getCartLink() {
        return cartLink;
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getUserMsg() {
        return userMsg;
    }

}
