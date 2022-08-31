package AuthenticationTestSuite;

import Pages.LoginPage;
import Utils.DriverUtils;
import Utils.ExcelUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class LoginTests {

    LoginPage loginPage;

    @BeforeClass
    @Parameters({"driverType"})
    void setup(@Optional("1") int driverType) {
        loginPage = new LoginPage(DriverUtils.createDriverObj(driverType));
    }

    @DataProvider(name = "loginTestData")
    Object[][] loginTestData() throws Exception {
        return ExcelUtils.getTableArray("data.xlsx", "loginTestData");
    }

    @Test(dataProvider = "loginTestData")
    void loginTest(String uName, String pass, String expected) {
        Assert.assertEquals(loginPage.enterValues(uName, pass), expected);
    }

    @AfterMethod
    void testFailed(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            DriverUtils.captureScreenshot(loginPage.getDriver(), result.getName());
        }
    }

    @AfterClass
    void teardown() {
        loginPage.getDriver().quit();
    }

}
