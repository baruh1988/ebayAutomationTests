import Extensions.UIActions;
import Extensions.Verifications;
import Utils.CommonOps;
import WorkFlows.EbayLoginWorkFlow;
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

}
