package Utils;

import Pages.*;
import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Variables{

    public static void initializeWebPages() {
        homePage = PageFactory.initElements(driver, EbayHomePage.class);
        registerPage = PageFactory.initElements(driver, EbayRegisterPage.class);
        loginPage = PageFactory.initElements(driver, EbayLoginPage.class);
        resultsPage = PageFactory.initElements(driver, EbaySearchResultsPage.class);
        itemPage = PageFactory.initElements(driver, EbayItemPage.class);
        cartPage = PageFactory.initElements(driver, EbayCartPage.class);
    }

}
