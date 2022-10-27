package Extensions;

import Utils.CommonOps;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;

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

    @BeforeMethod
    @AfterMethod
    public void takeScreenshot() {
        Allure.addAttachment("", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
