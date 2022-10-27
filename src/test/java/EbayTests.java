import Extensions.UIActions;
import Extensions.Verifications;
import Pages.EbayCartPage;
import Utils.CommonOps;
import WorkFlows.EbayCartWorkFlow;
import WorkFlows.EbayHomePageWorkFlow;
import WorkFlows.EbayLoginWorkFlow;
import WorkFlows.EbaySearchWorkFlow;
import io.qameta.allure.Description;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class EbayTests extends CommonOps {

    @Test(description = "Test user logged in")
    @Description("Verify user logged in to Ebay")
    public void test01_loginToEbay(@Optional("tavehu.ipifof@gotgel.org") String userName, @Optional("Azx12345!") String pass, @Optional("test") String expected) {
        EbayLoginWorkFlow.loginToEbay(userName, pass);
        Verifications.verifyText(UIActions.getText(homePage.getUserMsg()), expected);
    }

    @Test(description = "Test adding items to cart")
    @Description("Verify Item added to cart")
    public void testAddItemsToCart(@Optional("tavehu.ipifof@gotgel.org") String userName, @Optional("Azx12345!") String pass, @Optional("guitar") String term) {
        EbayLoginWorkFlow.loginToEbay(userName, pass);
        EbaySearchWorkFlow.search(term);
        EbaySearchWorkFlow.pickFirstItem();
        UIActions.goToNextTab();
        EbayCartWorkFlow.addItemToCart();
        UIActions.closeTab();
        UIActions.goToNextTab();
        EbayHomePageWorkFlow.goToCartPage();
        Verifications.verifyValuesAboveZero(String.valueOf(EbayCartPage.getItemPrices().size()));
    }

}
