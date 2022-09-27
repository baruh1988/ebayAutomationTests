package WorkFlows;

import Extensions.UIActions;
import Pages.EbaySearchResultsPage;
import Utils.CommonOps;
import io.qameta.allure.Step;

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

}
