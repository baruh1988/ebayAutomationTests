package WorkFlows;

import Extensions.UIActions;
import Pages.EbaySearchResultsPage;
import Utils.CommonOps;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class EbaySearchWorkFlow extends CommonOps {

    @Step("Preform search")
    public static void search(String term) {
        UIActions.sendKeysToElement(homePage.getSearchField(), term);
        UIActions.pressEnter(homePage.getSearchField());
    }

    @Step("Pick first item")
    public static void pickFirstItem() {
        UIActions.clickElement(EbaySearchResultsPage.getFilterBuyNow());
        UIActions.clickElement(EbaySearchResultsPage.getResults().get(0));
    }

    @BeforeMethod
    @AfterMethod
    public void takeScreenshot() {
        Allure.addAttachment("", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
