package WorkFlows;

import Extensions.UIActions;
import Pages.EbayRegisterPage;
import Utils.CommonOps;
import io.qameta.allure.Step;

public class EbayRegistrationWorkFlow extends CommonOps {

    @Step("Enter first name")
    public static void enterFirstName(String firstName) {
        UIActions.sendKeysToElement(registerPage.getFNameInput(), firstName);
    }

}
