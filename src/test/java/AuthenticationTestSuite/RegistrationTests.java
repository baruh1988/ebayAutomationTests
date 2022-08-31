package AuthenticationTestSuite;

import Pages.RegistrationPage;
import Utils.DriverUtils;
import Utils.ExcelUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class RegistrationTests {

    RegistrationPage registrationPage;

    @BeforeClass
    @Parameters({"driverType"})
    void setup(@Optional("1") int driverType) {
        registrationPage = new RegistrationPage(DriverUtils.createDriverObj(driverType));
    }

    @DataProvider(name = "registrationTestData")
    Object[][] registrationTestData() throws Exception {
        return ExcelUtils.getTableArray("data.xlsx", "registrationTestData");
    }

    @Test(dataProvider = "registrationTestData")
    void registrationTest(String fName, String lName, String email, String pass, String expected) {
        registrationPage.enterValues(fName, lName, email, pass);
        if (expected.equals("")) {
            registrationPage.waitUntilElementClickable(registrationPage.getCreateAccountBtnSelector());
            Assert.assertTrue(registrationPage.isEnabled(registrationPage.getCreateAccountBtnSelector()));
        } else {
            Assert.assertEquals(registrationPage.getActualErrorMsg(), expected);
        }
    }

    @AfterMethod
    void testFailed(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            DriverUtils.captureScreenshot(registrationPage.getDriver(), result.getName());
        }
    }

    @AfterClass
    void teardown() {
        registrationPage.getDriver().quit();
    }

}
