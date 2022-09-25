package Utils;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Variables {

    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static SoftAssert softAssert;
    protected static String url;
    protected static String timeout;
    protected static String browserName;
    protected static WebDriver driver;

    protected static EbayHomePage homePage;
    protected static EbayLoginPage loginPage;
    protected static EbayItemPage itemPage;
    protected static EbayRegisterPage registerPage;
    protected static EbaySearchResultsPage resultsPage;
    protected static EbayCartPage cartPage;

}
