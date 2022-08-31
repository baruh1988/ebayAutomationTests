package SearchTestSuite;

import Pages.SearchPage;
import Utils.DriverUtils;
import Utils.ExcelUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class SearchTests {

    SearchPage searchPage;

    @BeforeClass
    @Parameters({"driverType"})
    void setup(@Optional("1") int driverType) {
        searchPage = new SearchPage(DriverUtils.createDriverObj(driverType));
    }

    @DataProvider(name = "searchTestData")
    Object[][] searchTestData() throws Exception {
        return ExcelUtils.getTableArray("data.xlsx", "searchTestData");
    }

    @Test(dataProvider = "searchTestData")
    void findResults(String term) {
        searchPage.performSearch(term);
        String count = searchPage.getText(searchPage.getResultsCountSelector()).replaceAll(",","");
        Assert.assertTrue(Integer.parseInt(count) > 0);
    }

    @Test(dependsOnMethods = "findResults")
    void checkLocationFilter() {
        searchPage.filterByCountry();
        Assert.assertTrue(searchPage.checkAllItemsLocation("United States"));
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
