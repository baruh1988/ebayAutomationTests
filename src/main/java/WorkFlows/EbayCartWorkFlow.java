package WorkFlows;

import Extensions.UIActions;
import Pages.EbayItemPage;
import Utils.CommonOps;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class EbayCartWorkFlow extends CommonOps {

    @Step("Add item to cart")
    public static void addItemToCart() {
        UIActions.clickElement(EbayItemPage.getAddToCartBtn());
    }

    @BeforeMethod
    @AfterMethod
    public void takeScreenshot() {
        Allure.addAttachment("", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
