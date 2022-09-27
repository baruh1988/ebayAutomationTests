import Extensions.UIActions;
import Extensions.Verifications;
import Pages.EbayCartPage;
import Pages.EbayItemPage;
import Utils.CommonOps;
import WorkFlows.EbayHomePageWorkFlow;
import WorkFlows.EbayLoginWorkFlow;
import WorkFlows.EbaySearchWorkFlow;
import io.qameta.allure.Description;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class EbayTests extends CommonOps {

    @Test(description = "Test user logged in")
    @Description("Verify user logged in to Ebay")
    public void test01_loginToEbay(@Optional("") String userName, @Optional("") String pass, @Optional("") String expected) {
        EbayLoginWorkFlow.loginToEbay(userName, pass);
        Verifications.verifyText(UIActions.getText(homePage.getUserMsg()), expected);
    }

    @Test(description = "Test adding items to cart")
    @Description("Verify Item added to cart")
    public void testAddItemsToCart(@Optional("") String userName, @Optional("") String pass, @Optional("guitar") String term) {
        EbayLoginWorkFlow.loginToEbay(userName, pass);
        EbaySearchWorkFlow.search(term);
        EbaySearchWorkFlow.pickFirstItem();
        UIActions.goToNextTab();
        UIActions.clickElement(EbayItemPage.getAddToCartBtn());
        UIActions.closeTab();
        UIActions.goToNextTab();
        EbayHomePageWorkFlow.goToCartPage();
        Verifications.verifyValuesAboveZero(String.valueOf(EbayCartPage.getItemPrices().size()));
    }

}
