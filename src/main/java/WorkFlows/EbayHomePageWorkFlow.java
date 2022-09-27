package WorkFlows;

import Extensions.UIActions;
import Utils.CommonOps;
import io.qameta.allure.Step;

public class EbayHomePageWorkFlow extends CommonOps {

    @Step("Go to registration page")
    public static void goToRegistrationPage() {
        UIActions.clickElement(homePage.getRegisterLink());
    }

    @Step("Go to login page")
    public static void goToLoginPage() {
        UIActions.clickElement(homePage.getSignInLink());
    }

    @Step("Go to home page")
    public static void goToHomePage() {
        UIActions.clickElement(homePage.getLogo());
    }

    @Step("Go to cart page")
    public static void goToCartPage() {
        UIActions.clickElement(homePage.getCartLink());
    }

}
