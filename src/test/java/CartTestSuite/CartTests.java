package CartTestSuite;

import Pages.CartPage;
import Pages.SearchPage;
import Utils.DriverUtils;
import Utils.ExcelUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class CartTests {

    SearchPage searchPage;
    CartPage cartPage;

    @BeforeClass
    @Parameters({"driverType"})
    void setup(@Optional("1") int driverType) {
        searchPage = new SearchPage(DriverUtils.createDriverObj(driverType));
        cartPage = new CartPage(searchPage.getDriver());
    }

    @DataProvider(name = "searchTerms")
    Object[][] searchTerms() throws Exception {
        return ExcelUtils.getTableArray("data.xlsx", "searchTestData");
    }

    @Test(dataProvider = "searchTerms")
    void checkItemAdded(String term) {
        String addedItemTitle = cartPage.addItem(searchPage, term);
        Assert.assertTrue(cartPage.pageContainsText(addedItemTitle));
    }

    @Test(dependsOnMethods = "checkItemAdded")
    void checkItemRemoved() {
        cartPage.removeItem();
        Assert.assertTrue(cartPage.isDisplayed(cartPage.getItemRemovedMsgSelector()));
    }

    @Test(dependsOnMethods = "checkItemAdded")
    void checkCartPrice() {
        Assert.assertTrue(cartPage.checkPrices());
    }

    @AfterMethod
    void testFailed(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            DriverUtils.captureScreenshot(searchPage.getDriver(), result.getName());
        }
    }

    @AfterClass
    void teardown() {
        searchPage.getDriver().quit();
    }

}
