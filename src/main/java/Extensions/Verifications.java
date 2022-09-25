package Extensions;

import Utils.CommonOps;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;

public class Verifications extends CommonOps {

    @Step("Verify 2 given strings")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify values is above zero")
    public static void verifyValuesAboveZero(String amount) {
        softAssert = new SoftAssert();
        softAssert.assertTrue(Integer.parseInt(amount) > 0, "Amount must be above 0.");
    }

}
